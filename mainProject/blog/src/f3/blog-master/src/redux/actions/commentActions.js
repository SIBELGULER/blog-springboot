import * as actionTypes from "./actionTypes"

export function getCommentsSuccess(comments) {

    return {
        type: actionTypes.GET_COMMENT_SUCCESS,
        payload: comments
    };
}

export function saveCommentsSuccess(comment) {
    return {
        type: actionTypes.SAVE_COMMENT_SUCCESS,
        payload: comment
    }
}

export async function handleResponse(response) {
    if (response.ok) {
        return response.json()
    }
    const error = await response.text()
    throw new Error(error)
}

export function handleError(error) {
    console.error("Bir hata oluştu.")
    throw error;

}

export function saveCommentsApi(comment) {
    let obj = {
        "id": comment.id,
        "ad": comment.ad,
        "soyad": comment.soyad,
        "mail": comment.mail,
        "icerik": comment.icerik,
        "blogId": comment.blogId
    }

    return fetch("http://localhost:8080/api/yorum/kaydet",
        {
            method: 'POST',
            headers: {"content-type": "application/json"},
            body: JSON.stringify(obj)
        })
        .then(handleResponse)
        .catch(handleError);

}

export function saveComments(comment) {

    return function (dispatch) {
        return saveCommentsApi(comment)
            .then(savedComment => {
                dispatch(saveCommentsSuccess(savedComment))
            }).catch(error => {
                throw error;
            })
    }
}

export function getComments(blog) {
    return function (dispatch) {
        let url = "http://localhost:8080/api/yorum/blog-id-ye-gore-getir";
        let obj = {id: blog.id}
        return fetch(url,
            {
                method: 'POST',
                headers: new Headers({
                    'Content-Type': 'application/json; charset=utf-8',
                    "Access-Control-Allow-Origin": "*",
                }),
                body: JSON.stringify(obj),


            }
        )
            .then(response => response.json())
            .then(result => dispatch(getCommentsSuccess(result)))
    };
}