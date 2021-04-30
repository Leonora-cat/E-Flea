<template>
	<div class="container" :model="editForm">
		<div align="center" style="margin: auto ">

			<button @click="openwindow()">Edit your information</button>
		</div>
		<!-- 弹窗隐藏区域 -->
		<div id="myModal" class="modal">
			<div class="edit-form" >
				<form method="POST">
					<div class="text">Edit your information</div>
					<div class="form-item">
						<div>
							<span style="padding-right: 340px;">Username:{{editForm.username}}</span>
						</div>
						<div>
							<span>Email:</span>
							<span>
								<input type="text" placeholder="" v-model="editForm.email">
							</span>
						</div>
						<div class="birthday">
							<span>Birthday:</span>
							<span>
								<select class="choose" v-model="editForm.year">
									<option selected>year</option>
									<option>1990</option>
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
								<select class="choose" v-model="editForm.month">
									<option selected>month</option>
									<option>1</option>
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
								<select class="choose" v-model="editForm.day">
									<option selected>day</option>
									<option>1</option>
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
						<div>
							<span class="sex">
								Sex:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<label for="s">Male</label><input type="radio" name="al" checked="checked"
								 id="s" value="0" v-model="editForm.sex">Female<input type="radio" name="al" value="1" v-model="editForm.sex">
							</span>
						</div>
					</div>
				</form>
				<button class="ok" @click="ok()">confirm</button>&nbsp&nbsp&nbsp&nbsp<button class="no" @click="no()">cancel</button>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				editForm: {
					username:this.$route.params.username,
					email:'',
					year: '',
					month: '',
					day: '',
					sex: '',
				}
			}
		},
		methods: {
			async openwindow() {
				const {
					data: res
				} = await this.$http.get("/"+this.$route.params.username+"/home");
				
				//获取弹窗得div
				var modal = document.getElementById('myModal');
				//获取弹窗中得确定按钮
				var ok = document.getElementsByClassName("ok")[0];
				//获取弹窗中得取消按钮
				var no = document.getElementsByClassName("no")[0];
				//窗体弹出
				modal.style.display = "block";
				this.editForm.email = res.userInfo.email;
				this.editForm.year = res.userInfo.dateOfBirth.substring(0,4);
				this.editForm.month =res.userInfo.dateOfBirth.substring(5,7).replace(/\b(0+)/gi,"");
				this.editForm.day = res.userInfo.dateOfBirth.substring(8,10).replace(/\b(0+)/gi,"");
				if(res.userInfo.sex == false){
					this.editForm.sex = 0;
				}
				else{
					this.editForm.sex = 1;
				}
				
			},
			async editInfo() {
				const {
					data: res
				} = await this.$http.post("editPersonalInfo", this.editForm);
				if(res != "success"){
					this.$message.error("Email has been used");
				}else{
					this.$router.push({name:'PersonalPage',params:{username:this.editForm.username}});
				}
				return res;
				
			},
			ok() {
				console.log(this.editForm.email);
				var res = this.editInfo();
				if(res == "success"){
					var modal = document.getElementById('myModal');
					modal.style.display = "none";
				}
				
				// this.$message.success("Successfully modified！");
				//关闭窗口
				
			},
			no() {
				var modal = document.getElementById('myModal');
				modal.style.display = "none";
			}
		},
	}
</script>

<style scoped>
	/* 弹窗 (background) */
	.modal {
		display: none;
		/* 默认隐藏 */
		/*生成绝对定位的元素，相对于浏览器窗口进行定位。*/
		position: fixed;
		z-index: 1;
		left: 0;
		top: 0;

		/*浮在全屏上*/
		width: 100%;
		height: 100%;
		/*overflow：auto；如果内容被修剪，则浏览器会显示滚动条，以便查看其余内容。*/
		overflow: auto;
		background-color: rgb(0, 0, 0);
		background-color: rgba(0, 0, 0, 0.4);
		text-align: center;
	}



	/* 添加动画 */
	@-webkit-keyframes animatetop {
		from {
			top: -200px;
			opacity: 0
		}

		to {
			top: 0;
			opacity: 1
		}
	}

	@keyframes animatetop {
		from {
			top: -200px;
			opacity: 0
		}

		to {
			top: 0;
			opacity: 1
		}
	}

	/* 关闭按钮 */
	.close {
		color: white;
		float: right;
		font-size: 28px;
		font-weight: bold;
	}

	.close:hover,
	.close:focus {
		color: #5162f4;
		text-decoration: none;
		cursor: pointer;
	}



	.edit-form {
		background-color: rgb(255, 255, 255);

		border-radius: 15px;
		text-align: center;
		border: #5162f4;
		border-style: solid;
		width: 50%;
		height: 60%;
		box-shadow: 10px 10px 10px #5162f4;
		/* 定位到中心 */
		transform: translate(50%, 50%);

	}

	.text {
		font-size: 30px;
		font-weight: bold;
		text-align: center;
		line-height: 80px;
		margin-top: 10px;
		color: #5162f4;
	}



	input {
		width: 50%;
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

	.ok {
		width: 70px;
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
		border-style: none;
	}

	.no {
		width: 70px;
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
		border-style: none;
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
		padding-right: 130px;
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
		margin-bottom:20px;
	}

	.sex {
		padding-right: 210px;
	}
</style>
