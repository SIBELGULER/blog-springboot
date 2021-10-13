import React, {Component} from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import * as blogActions from "../../redux/actions/blogActions"
import BlogDetail from "./BlogDetail";
import BlogDetailPage from "./BlogDetailPage";


class BlogList extends Component {
    state = {
        secilenBlog: null,
    }

    componentDidMount() {
        this.props.actions.getBlogs()
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (prevProps.blogs !== this.props.blogs && this.props.blogs) {
        }
    }

    selectBlog = (blog) => {
        this.setState({
            ...this.state,
            secilenBlog: blog,
        })
    };

    render() {
        return (
            <div className="content">
                <div className={"container-fluid d-flex justify-content-center"}>
                    {this.state.secilenBlog === null ?
                        <div className={"row"}>
                            {
                                this.props.blogs?.data?.map(blog => {
                                    return <BlogDetail blog={blog}
                                                       selectBlogAction={(secilenBlog) => this.selectBlog(secilenBlog)}
                                                       blogChangeAction={this.props.actions.changeBlog}/>;
                                })
                            }
                        </div>
                        :


                        <BlogDetailPage secilenBlog={this.state.secilenBlog}/>
                    }

                </div>


            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        currentBlog: state.changeBlogReducer,
        blogs: state.blogListReducer
    }
}

function mapDispatchToProps(dispatch) {
    return {
        actions: {
            getBlogs: bindActionCreators(blogActions.getBlogs, dispatch),
            changeBlog: bindActionCreators(blogActions.changeBlog, dispatch),

        }
    }


}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(BlogList);