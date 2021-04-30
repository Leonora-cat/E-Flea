import axios from "axios";
import {Message} from "element-ui";
import router from "@/router";


axios.interceptors.response.use(success=>{


})



let base = '';
export const postRequest = (url, params)=>{
    return axios({
        method:'post',
        url:`${base}${url}`,
        data: params
    })



}