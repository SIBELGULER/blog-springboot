import React, {Component} from 'react';
import {Card, CardBody, CardText} from "reactstrap";
import {bindActionCreators} from "redux";
import * as blogActions from "../../redux/actions/blogActions";
import {connect} from "react-redux";
import {Link} from "react-router-dom";


class BlogDetail extends Component {
    state = {
        secilenBlog: null,
    }

    selectBlog = (blog) => { //seçilen blogun detayını getirsin
        // this.props.blogChangeAction(blog);
        this.setState({
            ...this.state,
            secilenBlog: blog
        });
        this.props.selectBlogAction(blog);
        // window.location.href = "/admin/blog-detail";
    };


    render() {
        return (

            <div className={"col-md-4 w-50  d-inline-block"}>
                <div className={"card text-center p-3"}>
                    <div className={"container-fluid"} >
                        <img class={"buyuyen-resim"} style={{
                            "width": 200, "height": 300

                        }}
                             alt="..."
                             src={this.props.blog?.resimler[0]?.link}
                        />
                    </div>
                    <div className={"card-body text-dark"}>
                        <h4 style= {{"text-transform": "uppercase" , "color":"red"}}>
                            {this.props.blog.baslik}
                        </h4>
{/*
                        <p className="description">{this.props.blog.tarih}</p>
*/}
                        <p className="description  text-truncate  "
                           style={{"max-width": 500}}>{this.props.blog.icerik}</p>
                    </div>
                    {/*<Link to={"/admin/blog-detail/"+this.props.blog.id} className="btn-red-text text-info">DEVAMI</Link>*/}



                    <div
                        style={{"color":"black"}}
                        type={"button"}
                        /*class="btn btn-outline-primary"*/
                        className="btn-red-text text-info"
                        onClick={() => this.selectBlog(this.props.blog)}>
                        DEVAMI <i className="fas fa-arrow-right"></i>
                    </div>
                </div>
            </div>
        );
    }
}

export default BlogDetail;
