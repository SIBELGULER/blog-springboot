import React, {Component} from 'react';
import {connect} from "react-redux";
import {Badge, Button, Card, CardBody, CardFooter, CardText, ListGroup, ListGroupItem} from "reactstrap";
import {bindActionCreators} from "redux";
import * as blogActions from "../../redux/actions/blogActions"
import BlogDetail from "./BlogDetail";
import BlogDetailPage from "./BlogDetailPage";

class BlogList extends Component {
    state = {
        secilenBlog: null,
    }

    componentDidMount() { //uygulama açıldığında state değişmiş oluyor --> categori statei
        this.props.actions.getBlogs()
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (prevProps.blogs !== this.props.blogs && this.props.blogs) {
            // console.log(this.props.blogs.data)
        }
    }

    //=()=> event
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
                                this.props.blogs?.data?.map(blog => { //her bir elemanı gez ve onları listgroupitem içine yerleştir
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

//mapStateToProps => state i propslara bağla
function mapStateToProps(state) { //reducer a bağlan ordaki data yı çek //state i reducer a bağladık
    return {
        currentBlog: state.changeBlogReducer,
        blogs: state.blogListReducer
    }
}

//aksiyona bağlanmak için
//mapDispatchToProps => aksiyonu propslara bağla
//dispatch => actions?
//redux daki action ı buraya bağlayacağız bunun için 2 tane import yapılır
//import {bindActionCreators} from "redux"
//import * as categoryActions from "../../redux/actions/categoryActions"
function mapDispatchToProps(dispatch) { //action ı reducera bağladık
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
)(BlogList); //connect fonk bir fonk döndürür. bizde oraya CategoryList i verdik.

// export default BlogList;