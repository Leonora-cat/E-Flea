import Vue from 'vue'
import VueRouter from 'vue-router'

import browseProduct from "@/views/browseProduct";
import issue from "@/views/issue";
import personalPage from "@/views/personalPage";
import forgetPassword from "@/views/forgetPassword";
import login from "@/views/login";
import register from "@/views/register"
import productList from "@/views/productList";
import item from "@/views/item";
import issue2 from "@/views/issue2"
import resetPassword from "@/views/resetPassword"




Vue.use(VueRouter)

const routes = [
  {
    path: '/:username/product',
    name: 'BrowseProduct',
    component: browseProduct
  },
  {
    path: "/:username/product/:category",
    name: 'productList',
    component: productList,
  },
  {
    path: '/:username/issue',
    name: 'issue',
    component: issue
  },
  {
    path: '/:username/issue/:key',
    name: 'issue2',
    component: issue2
  },
  {
    path: "/login",
    name: 'Login',
    component: login
  },
  {
    path: '/:username/item/:name',
    name: 'item',
    component: item
  },
  {
    path: '/register',
    name: 'Register',
    component: register
  },
  {
    path: '/:username/home',
    name: 'PersonalPage',
    component: personalPage
  },
  {
    path: '/forgetPassword',
    name: 'ForgetPassword',
    component: forgetPassword
  },
  {
    path: ':username/resetPassword',
    name: 'ResetPassword',
    component: resetPassword
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
