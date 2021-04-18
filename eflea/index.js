import Vue from 'vue'
import VueRouter from 'vue-router'

import browseProduct from "@/views/browseProduct"
import login from "@/views/login"
import register from "@/views/register"
import personalPage from "@/views/personalPage"
import editPersonalInfoPage from "../views/editPersonalInfoPage.vue"
import forgetPassword from "../views/forgetPassword.vue"


Vue.use(VueRouter)

const routes = [
	{
		path: '/',
		name: 'BrowseProduct',
		component: browseProduct
	},
	{
		path: "/login",
		name: 'Login',
		component: login
	},
	{
		path: '/register',
		name: 'Register',
		component: register
	},
	{
		path: '/:username/home',
		name:'PersonalPage',
		component: personalPage
	},
	{
		path: '/:username/editPersonalInfoPage',
		name:'EditPersonalInfoPage',
		component: editPersonalInfoPage
	},
	{
		path:'/forgetPassword',
		name:'ForgetPassword',
		component:forgetPassword
	}

]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

export default router
