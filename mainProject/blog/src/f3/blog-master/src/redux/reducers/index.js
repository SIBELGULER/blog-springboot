
import {combineReducers} from "redux";
import blogListReducer from "./blogListReducer";
import changeBlogReducer from "./changeBlogReducer";
import commentListReducer from "./commentListReducer";
import saveCommentReducer from "./saveCommentReducer";



const rootReducer = combineReducers({

    blogListReducer,
    changeBlogReducer,
    commentListReducer,
    saveCommentReducer,
})

export default rootReducer;