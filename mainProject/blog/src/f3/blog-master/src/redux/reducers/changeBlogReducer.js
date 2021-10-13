
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