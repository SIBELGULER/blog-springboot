//actionTypes ları import et
//.. --> bir klasör yukarı gider
//reducer bizim için o anki state i döndürüyor
//isteyen herkes reducer a abone olup istediği state i dğndürebiliyor
import * as actionTypes from "../actions/actionTypes"
import initialState from "./initialState";


export default function changeBlogReducer(state= initialState.currentBlog, action){
    switch (action.type) {
        case actionTypes.CHANGE_BLOG:
            return action.payload;

        default:
            return state;
    }
}