import React, {Component} from 'react';
import {Button, Col, Container, ListGroup, ListGroupItem, Row} from "reactstrap";
import {BiDislike, BiLike} from "react-icons/all";
class CommentDetail extends Component {


    selectComment = (comment) => {
    };


    render() {
        return (

            <Container>
            <ListGroup>
                <ListGroupItem>

            <Row>
                <Col xs={12} md={8}>
                    {this.props.comment?.ad} {' '}
                    {this.props.comment?.soyad}
                    <br/>
                    {this.props.comment?.icerik}
                   <Col><Button className={"btn btn-sm btn-outline-danger"}><BiLike/></Button>
                      <Button variant={"outline-danger"} size={"sm"}> <BiDislike/></Button></Col>
                </Col>
                <Col xs={6} md={4} style={{"font-size":"0.74em"}}>
                    {this.props.comment?.tarih}


                </Col>
            </Row></ListGroupItem></ListGroup>
            </Container>
        );
    }
}

export default CommentDetail;
