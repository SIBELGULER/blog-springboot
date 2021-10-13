import * as actionTypes from "../actions/actionTypes"
import initialState from "./initialState"

export default function blogListReducer(state=initialState.blogs,action){
    switch (action.type) {
        case actionTypes.GET_BLOGS_SUCCESS: {
            console.log(action.payload)
            return action.payload;
        }
        default:
            return state;
    }
}