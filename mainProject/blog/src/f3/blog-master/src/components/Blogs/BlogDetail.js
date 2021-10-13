import React, {Component} from 'react';
import "../../assets/css/devamı.css"

class BlogDetail extends Component {
    state = {
        secilenBlog: null,
    }

    selectBlog = (blog) => {
        this.setState({
            ...this.state,
            secilenBlog: blog
        });
        this.props.selectBlogAction(blog);
    };


    render() {
        return (
            <div className={"col-md-4 w-50  d-inline-block"}>
                <div className={"card text-center p-3"}>
                    <div className={"container-fluid"} >
                        <img className={"buyuyen-resim"} style={{
                            "width": 200, "height": 300
                        }}
                             alt="..."
                             src={this.props.blog?.resimler[0]?.link}
                        />
                    </div>
                    <div className={"card-body text-dark"}>
                        <br/>
                        <h4 style= {{"text-transform": "uppercase" , "color":"red"}}>
                            {this.props.blog.baslik}
                        </h4>
                        <p className="description  text-truncate  "
                           style={{"max-width": 500}}>{this.props.blog.icerik}</p>
                    </div>
                    <div
                        style={{"color":"black"}}
                        type={"button"}
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
