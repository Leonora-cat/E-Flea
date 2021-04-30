<template>
	<div class="background">
		<div class="container">
			<form method="POST">
				<div class="login-form">
					<div class="text">Reset your password</div>
					<div class="form-item" ref="passwordResetRef" :model="passwordReset">
						<input class="input" type="text" placeholder="Username" v-model="passwordReset.username"
							readonly="readonly">
						<input class="input" type="text" placeholder="Email" v-model="passwordReset.email"
							oninput="value= value.replace(/[^a-zA-Z0-9.]/g,'')"
							readonly="readonly">
						<input class="input" type="password" placeholder="New Password"
							v-model="passwordReset.newPassword">
						<input class="input" type="password" placeholder="Repeat Password"
							v-model="passwordReset.repeatNewPassword">
					</div>
					<div class="btn" @click="submit()">Reset</div>
				</div>
			</form>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				passwordReset: {
					username: this.$route.params.username,
					email: this.$route.params.email,
					newPassword: '',
					repeatNewPassword: ''
				}
			}
		},
		methods: {
			async submit() {
				if (this.passwordReset.newPassword == '') {
					this.$message.error("Empty password");
					return;
				}
				if (this.passwordReset.repeatNewPassword == '') {
					this.$message.error("Empty password");
					return;
				}
				if (this.passwordReset.newPassword !== this.passwordReset.repeatNewPassword) {
					this.$message.error("Two passwords are different");
					return;
				}
				var data = {
					username: this.passwordReset.username,
					email: this.passwordReset.email,
					newPassword: this.passwordReset.newPassword,
					repeatNewPassword: this.passwordReset.repeatNewPassword

				}
				const {
					data: res
				} = await this.$http.post("http://localhost:9000/forgetPassword", data);
				if (res == "success") {
					this.$message.success("success!!!");
					this.$router.push({ name: 'Login' });
				}
				else {
					this.$message.error(res);
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
		background: url(../assets/forgetPassword/forget.png);
		background-repeat: no-repeat;
		background-size: cover;
		background-attachment: fixed;
	}

	.container {
		margin-top: 100px;
		padding-left: 80px;
	}

	.login-form {
		background-color: rgb(255, 255, 255);
		width: 400px;
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

	.form-item,
	.other {
		margin: 40px auto;
		width: 90%;
	}

	.input {
		width: 80%;
		margin-top: 20px;
		padding: 10px;
		border: 0;
		outline: none;
		border-bottom: 1px solid #5162f4;
	}

	.email {
		width: 35%;
		margin-top: 20px;
		padding: 10px;
		border: 0;
		outline: none;
		border-bottom: 1px solid #5162f4;
	}

	.email::placeholder {
		font-weight: bold;
		color: #acb7c9;
	}

	.email:focus {
		animation: bBottom 2s infinite;
	}

	.input::placeholder {
		font-weight: bold;
		color: #acb7c9;
	}

	.input:focus {
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
		color: #fff;
		font-weight: bold;
		text-align: center;
		cursor: pointer;
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