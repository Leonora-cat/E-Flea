<template>
	<div class="background">
		<div class="container">
			<div class="login-form">
				<div class="text">Register</div>
				<div class="form-item" :model="registerForm">
					<div>
						<span>Username:</span>
						<span>
							<input type="text" placeholder="Enter your username" v-model="registerForm.username">
						</span>
					</div>
					<div>
						<span>Password:</span>
						<span>
							<input type="password" placeholder="Enter your password" v-model="registerForm.password">
						</span>
					</div>
					<div style="padding-left:30px;" class="email">
						<span>Email:</span>
						<span>
							<input placeholder="Email" v-model="registerForm.email" oninput="value= value.replace(/[^a-zA-Z0-9.]/g,'')">
						</span>
						<span>@student.xjtlu.edu.cn</span>
					</div>
					<div style="padding-left:19px;">
						<span>Major:</span>
						<span>
							<input type="text" placeholder="Enter your major" v-model="registerForm.major">
						</span>
					</div>
					<div class="birthday">
						<span>Birthday:</span>
						<span>
							<select class="choose" v-model="registerForm.year">
								<option selected = "true">1990</option>
								<option>1991</option>
								<option>1992</option>
								<option>1993</option>
								<option>1994</option>
								<option>1995</option>
								<option>1996</option>
								<option>1997</option>
								<option>1998</option>
								<option>1999</option>
								<option>2000</option>
								<option>2001</option>
								<option>2002</option>
								<option>2003</option>
								<option>2004</option>
								<option>2005</option>
								<option>2006</option>
								<option>2007</option>
								<option>2008</option>
								<option>2009</option>
								<option>2010</option>
								<option>2011</option>
								<option>2012</option>
								<option>2013</option>
								<option>2014</option>
								<option>2015</option>
								<option>2016</option>
								<option>2017</option>
								<option>2018</option>
								<option>2019</option>
								<option>2020</option>
								<option>2021</option>
							</select>
							<select class="choose" v-model="registerForm.month">
								<option selected = "true">1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
								<option>11</option>
								<option>12</option>
							</select>
							<select class="choose" v-model="registerForm.day">
								<option selected = "true">1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
								<option>11</option>
								<option>12</option>
								<option>13</option>
								<option>14</option>
								<option>15</option>
								<option>16</option>
								<option>17</option>
								<option>18</option>
								<option>19</option>
								<option>20</option>
								<option>21</option>
								<option>22</option>
								<option>23</option>
								<option>24</option>
								<option>25</option>
								<option>26</option>
								<option>27</option>
								<option>28</option>
								<option>29</option>
								<option>30</option>
								<option>31</option>

							</select>
						</span>
					</div>
					<div class="sex">
						<input type="radio" id="male" value="0" v-model="registerForm.sex">
						<label for="male">Male</label>
						<input type="radio" id="female" value="1" v-model="registerForm.sex">
						<label for="female">Female</label>
					</div>
					<!-- <div class="clause">
						<input class="xx" type="checkbox" value="agree" v-model="registerForm.agree">
						<label for="agree">I agree xxxxx</label>
					</div> -->
				</div>
				<button class="btn" type="submit" @click="register()">Register</button>

				<div class="other">
					<a href="/login">Back to log in</a>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				registerForm: {
					username: '',
					password: '',
					email: '',
					major: '',
					year: '1990',
					month: '1',
					day: '1',
					sex: '0',
					// agree: []
				}
			}
		},
		methods: {
			async register() {
				if (this.registerForm.username == '') {
					this.$message.error("Empty username");
					return;
				}
				if (this.registerForm.password == '') {
					this.$message.error("Empty password");
					return;
				}
				if (this.registerForm.email == '') {
					this.$message.error("Empty email address");
					return;
				}
				var pattern1 = /^[a-zA-Z]+\.[a-zA-Z]+[0-9]+$/;
				if (!pattern1.test(this.registerForm.email)) {
					this.$message.error("Invalid email address");
					return;
				}
				// if (this.registerForm.agree[0] !== 'agree') {
				// 	this.$message.error("You need to agree to the user terms");
				// 	return;
				// }
				var data = {
					username:this.registerForm.username ,
					password:this.registerForm.password ,
					email:this.registerForm.email+"@student.xjtlu.edu.cn" ,
					major:this.registerForm.major ,
					year:this.registerForm.year ,
					month:this.registerForm.month ,
					day:this.registerForm.day ,
					sex:this.registerForm.sex
				}
				const {
					data: res
				} = await this.$http.post("http://localhost:9000/register", data);
				if (res.msg === "successfully registered") {
					this.$message.success("Success");
					this.$router.push({ path: '/login' });
				} else if (res.msg === "Username already exists") {
					this.$message.error("Username already exists");
				} else{
					this.$message.error("Email already exists");
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
		background: url(../assets/register.png);
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
		width: 600px;
		height: 550px;
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
		margin-top: 10px;
		color: #5162f4;
	}

	.other,
	.form-item {
		margin: 10px auto;
		width: 90%;
	}

	input {
		width: 50%;
		margin-top: 20px;
		padding: 10px;
		border: 0;
		outline: none;
		border-bottom: 1px solid #5162f4;
	}

	.email input{
		width: 20%;
		margin-top: 20px;
		padding: 10px;
		border: 0;
		outline: none;
		border-bottom: 1px solid #5162f4;
	}

	input::placeholder {
		font-weight: bold;
		color: #acb7c9;
	}

	input:focus {
		animation: bBottom 2s infinite;
	}

	@keyframes bBottom {
		50% {
			border-bottom: 1px solid #a6c1ee;
		}
	}

	.btn {
		width: 70%;
		height: 40px;
		line-height: 40px;
		color: #fff;
		font-weight: bold;
		text-align: center;
		cursor: pointer;
		border-radius: 10px;
		background: linear-gradient(to right, #5162f4, #a6c1ee, #5968ee);
		background-size: 200%;
		border-style: none;
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

	.birthday {
		margin-top: 20px;
		padding-right: 20px;
	}

	.birthday .choose {
		width: 65px;
		height: 20px;
		margin-left: 20px;
	}

	.sex input {
		width: 50px;
		margin-top: 20px;
		padding-left: 5px;
		padding-right: 5px;
	}

	.sex {
		padding-right: 80px;
	}

	.xx {
		width: 14px;
		height: 14px;
	}
</style>