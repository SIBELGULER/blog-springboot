import * as actionTypes from "./actionTypes"


export function getBlogsSuccess(blogs){

    return{
        type: actionTypes.GET_BLOGS_SUCCESS,
        payload: blogs
    };
}

export function changeBlog(blog){
    return{
        type: actionTypes.CHANGE_BLOG,
        payload:blog
    }
    /*bu işlemde reducer da CHANGE_CATEGORY i gördüğü anda state i payload da belirtilen değer olarak set ediyor*/
}


export function getBlogs(){

    return function (dispatch){
    let url = "http://localhost:8080/api/blog/tumunu-getir";
    return fetch(url,{
        "method":"GET",
        "Access-Control-Allow-Origin":"*"
    }
    )
        .then(response=> response.json())
        .then(result=>dispatch(getBlogsSuccess(result))) //apiye bağlantı redux-thunk
    };
}