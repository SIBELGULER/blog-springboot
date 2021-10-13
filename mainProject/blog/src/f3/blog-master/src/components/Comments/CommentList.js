import React, {Component} from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import CommentDetail from "./CommentDetail";
import * as commentActions from "../../redux/actions/commentActions"

class CommentList extends Component {
    /*state = {
        secilenComment: null,
    }*/

    componentDidMount() {
        this.props.actions.getComments(this.props.blog)
    }

    componentDidUpdate(prevProps, prevState, snapshot) {


        if (prevProps.comments !== this.props.comments && this.props.comments) {
            console.log(this.props.comments.data)
        }
    }

    /* selectBlog = (comment) => {
         this.setState({
             ...this.state,
             secilenComment: comment,
         })
     };*/

    render() {
        return (
            <div className="content">
                <div className={"container-fluid d-flex justify-content-center"}>

                    <div className={"row"}>
                        {
                            this.props.comments?.data?.map(comment => {
                                return <CommentDetail comment={comment}/>;
                            })
                        }

                    </div>

                </div>


            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        comments: state.commentListReducer


    }
}

function mapDispatchToProps(dispatch) {
    return {
        actions: {
            getComments: bindActionCreators(commentActions.getComments, dispatch),

        }
    }


}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(CommentList);
