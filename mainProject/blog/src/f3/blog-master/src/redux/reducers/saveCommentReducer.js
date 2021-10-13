import * as actionTypes from "../actions/actionTypes"
import initialState from "./initialState"

// const initialState = {
//     comments:[]
//
// }

export default function saveCommentReducer(state = initialState.comments, action) {
    console.log(state)
    console.log("comment: > ",action.payload)
    switch (action.type) {
        case actionTypes.SAVE_COMMENT_SUCCESS:
       return action.payload

        /*{
           ...state,
               comments: []
       }
*/
        default:
            return state;
    }
}