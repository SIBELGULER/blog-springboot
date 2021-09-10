import React, {Component} from 'react';
import {connect} from "react-redux";
import {Badge} from "reactstrap";
import BlogDetail from "./BlogDetail";

class BlogDetailPage extends Component {

    render() {
        console.log(this.props.secilenBlog)
        return (
            <div className="content">
                <div className={"container-fluid d-flex justify-content-center"}>
                    <div className={"row"}>
                        {
                            // this.props.secilenBlog?.body?.map(blog => ( //her bir elemanı gez ve onları listgroupitem içine yerleştir
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
                                        <p className="description">{this.props.secilenBlog.tarih}</p>
                                        {this.props.secilenBlog.etiketler.length > 0 ?
                                            <p>{this.props.secilenBlog.etiketler[0].ad}</p> : null}
                                        {this.props.secilenBlog.kategoriler.length > 0 ?
                                            <p>{this.props.secilenBlog.kategoriler[0].ad}</p> : null}
                                        {this.props.secilenBlog.yorumlar.length > 0 ?
                                            <p>{this.props.secilenBlog.yorumlar[0].icerik}</p> : null}
                                    </div>
                                </div>
                            </div>
                            // ))

                        }
                    </div>
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) { //state i reducer a bağladık
    return {
        currentBlog: state.changeBlogReducer
    }
}


export default connect(
    mapStateToProps
)(BlogDetailPage);
