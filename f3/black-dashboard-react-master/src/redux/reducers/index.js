// {combineReducers} => fonk old için {} içerisinde import ettik
//Store => tüm reducerları bir arada topladığımız yerdir
import {combineReducers} from "redux";
import blogListReducer from "./blogListReducer";
import changeBlogReducer from "./changeBlogReducer";
//combineReducers() fonk içerisinde bir obje ile{} reducer larımızı yazarız

const rootReducer = combineReducers({

    blogListReducer,
    //changeCategoryReducer: changeCategoryReducer şeklinde yazabilirdik obje old için (ismi: değeri şeklinde)
    //ama javascript de ikisinide aynı kullanacaksak changeCategoryReducer şeklinde yazmamız yeterli oluyor
    changeBlogReducer
})

export default rootReducer;