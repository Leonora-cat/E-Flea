<template>
	<div class="background">
		<div class="container">
			<div class="login-form">
				<div class="text">Welcome to E-flea</div>
				<div class="form-item" ref="loginFormRef" :model="loginForm">
					<input type="text" placeholder="Username" v-model="loginForm.username">
					<input type="password" placeholder="Password" v-model="loginForm.password">
				</div>
				<div class="btn" @click="login()">Log in</div>
				<div class="forget"><a href="/forgetPassword">Forget password?</a></div>
				<div class="other">
					No account？<a href="/register">Go register</a>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				loginForm: {
					username: '',
					password: ''
				}
			}
		},
		methods: {
			async login() {
				const {
					data: res
				} = await this.$http.post("login", this.loginForm);
				console.log(res);
				if (res.status == "success") {
					this.$message.success("success!!!");
					this.$router.push({name:'PersonalPage',params:{username:this.loginForm.username}});
				} else {
					this.$message.error("error!!!");
				}
				
			}
		}
	}
</script>
<style scoped>
	* {
		margin: 0;
		padding: 0;
	}

	.background {
		position: absolute;
		width: 100%;
		height: 100%;
		top: 0;
		left: 0;
		overflow-y: auto;
		background: url(../assets/background.png);
		background-repeat: no-repeat;
		background-size: cover;
		background-attachment: fixed;
	}

	.container {
		margin-top: 100px;
		padding-left: 150px;
	}

	.login-form {
		background-color: rgb(255, 255, 255);
		width: 350px;
		height: 500px;
		border-radius: 15px;
		text-align: center;
		border: #5162f4;
		border-style: solid;
		box-shadow: 10px 10px 10px #5162f4;
	}

	.text {
		font-size: 30px;
		font-weight: bold;
		text-align: center;
		line-height: 80px;
		margin-top: 40px;
		color: #5162f4;
	}

	.form-item {
		margin: 20px auto;
		width: 90%;
	}

	.other {
		margin: 40px auto;
		width: 90%;
	}

	input {
		width: 80%;
		margin-top: 20px;
		padding: 10px;
		/* placeholder变更为大写字体 */
		/* 边框效果 */
		border: 0;
		outline: none;
		border-bottom: 1px solid #5162f4;
	}

	input::placeholder {
		font-weight: bold;
		color: #acb7c9;
	}

	input:focus {
		/* 当输入框获取焦点时的效果 */
		/* box-shadow: 0px 0px 5px #fbc2eb;
	    border-bottom: 1px solid #fff; */
		animation: bBottom 2s infinite;
	}

	@keyframes bBottom {
		50% {
			border-bottom: 1px solid #a6c1ee;
		}
	}

	.btn {
		margin: 40px 20px;
		margin-bottom: 10px;
		height: 40px;
		line-height: 40px;
		/* 字体 */
		color: #fff;
		font-weight: bold;
		text-align: center;
		/* 鼠标样式 */
		cursor: pointer;
		/* 边框、背景 */
		border-radius: 10px;
		background: linear-gradient(to right, #5162f4, #a6c1ee, #5968ee);
		background-size: 200%;
	}

	.btn:hover {
		animation: btnAnimate 1s infinite;
	}

	@keyframes btnAnimate {
		50% {
			background-position: 200%;
		}
	}

	a {
		text-decoration: none;
		color: #5162f4;
	}

	.forget {
		padding-left: 180px;
		font-size: small;
	}
</style>
