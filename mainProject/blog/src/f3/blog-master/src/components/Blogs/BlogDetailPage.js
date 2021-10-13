import React, {Component} from 'react';
import {connect} from "react-redux";
import AddComment from "../Comments/AddComment";
import CommentList from "../Comments/CommentList";

class BlogDetailPage extends Component {

    render() {
        return (
            <div className="content">
                <div className={"container-fluid d-flex justify-content-center"}>
                    <div className={"row"}>
                        {
                            <div>


                                <h3 style={{"text-transform": "uppercase", "color": "red"}}
                                >{this.props.secilenBlog.baslik}</h3>

                                <hr/>
                                <div className={"d-flex"}>
                                    <div className={"container-fluid"}>
                                        <img className={"buyuyen-resim"} style={{
                                            "width": 200, "height": 300
                                        }}
                                             alt="..."
                                             src={this.props.secilenBlog?.resimler[0]?.link}
                                        />
                                    </div>
                                    <div className={"mr-xl-xl pr-xl-xl"}>
                                        <p className="description">
                                            {this.props.secilenBlog.icerik}
                                        </p>

                                        {this.props.secilenBlog.etiketler.length > 0 ?
                                            <p style={{
                                                "color": "red",
                                                "font-style": "italic"
                                            }}>{this.props.secilenBlog.etiketler[0].ad}</p> : null}
                                        {this.props.secilenBlog.kategoriler.length > 0 ?
                                            <p>{this.props.secilenBlog.kategoriler[0].ad}</p> : null}
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <h3>YORUM YAZ</h3>
                                <AddComment blog={this.props.secilenBlog}/>
                                <br/><br/>
                                <h3>YORUMLAR</h3>

                                <CommentList blog={this.props.secilenBlog}/>


                            </div>
                            // ))

                        }
                    </div>
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        currentBlog: state.changeBlogReducer
    }
}


export default connect(
    mapStateToProps
)(BlogDetailPage);
