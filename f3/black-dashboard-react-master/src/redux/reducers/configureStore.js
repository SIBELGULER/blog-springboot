/*
Redux bir depo-store
store da actions ve reducers ları tutuyoruz
configureStore da store u oluşturacak fonk yazıyoruz
* */

import {applyMiddleware, createStore} from "redux";
import rootReducer from "./index" //reducerları çektik
import thunk from "redux-thunk";

export default function configureStore(){
    return createStore(rootReducer,applyMiddleware(thunk))
}