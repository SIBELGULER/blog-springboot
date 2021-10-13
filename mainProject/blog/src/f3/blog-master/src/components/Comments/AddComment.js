import React, {Component} from 'react';
import {Button, Form, FormGroup, Input, Label} from "reactstrap";
import {bindActionCreators} from "redux";
import * as commentActions from "../../redux/actions/commentActions";
import {connect} from "react-redux";

class AddComment extends Component {
    state = {
        yorum: {
            ad: "",
            soyad: "",
            mail: "",
            icerik: "",
            blogId: this.props.blog.id
        }
    }
    changeInput = (e) => {
        this.setState({
            ...this.state,
            yorum: {
                ...this.state.yorum,
                [e.target.name]: e.target.value,
            }
        })
    }

    componentDidMount() {
        this.setState({
            ...this.state,
            yorum: {
                ...this.state.yorum,
                blogId: this.props.blog.id
            }
        },() => console.log("asd"))
    }


    render() {
        return (
            <Form>
                <FormGroup className={"needs-validation"} novalidate>
                    <div className="row g-3">
                        <div className="col has-validation">
                            <Label>Ad</Label>
                            <Input
                                validate={"required, maxLength15"}
                                type="text" className="form-control"
                                name={'ad'}
                                onChange={this.changeInput}
                                id="validationTextarea" placeholder="First name"
                                aria-label="First name" required/>
                        </div>
                        <div className="col has-validation">
                            <Label>Soyad</Label>
                            <Input
                                required
                                validate={"required, maxLength15"}
                                type="text" name={'soyad'} className="form-control" placeholder="Last name"
                                aria-label="Last name"
                                onChange={this.changeInput}/>
                        </div>
                    </div>
                </FormGroup>
                <FormGroup>
                    <div className={"col has-validation"}>
                        <Label for="exampleEmail">Email</Label>
                        <Input validate={"required, maxLength15"}
                               required
                               type="email" name="mail" className={"form-control"} id="exampleEmail"
                               placeholder="name@example.com"
                               onChange={this.changeInput}/>
                    </div>
                </FormGroup>
                <FormGroup>
                    <div className={"col has-validation"}>
                        <Label for="exampleText">Text Area</Label>
                        <Input validate={"required"}
                               type="textarea" name="icerik" className={"form-control"} required id="exampleText"
                               onChange={this.changeInput}/>
                    </div>

                </FormGroup>
                <Button className={"bg-danger"}
                        onClick={() => this.props.actions.savedComment(this.state.yorum)}>GÖNDER</Button>
            </Form>


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
            savedComment: bindActionCreators(commentActions.saveComments, dispatch),

        }
    }


}


export default connect(
    mapStateToProps,
    mapDispatchToProps
)(AddComment);
