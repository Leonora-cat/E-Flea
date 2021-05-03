<template>
	<div class="body">
		<div class="personalInfo clearfix">
			<div class="user"><a @click="home()" href="javascript:void(0);"><img src="../assets/user.png" alt=""></a>
			</div>
			<div class="user"><a @click="back()" href="javascript:void(0);"><img src="../assets/back1.png" alt=""></a>

			</div>
		</div>
		<div>
			<div class="mask" v-if="showModal" @click="showModal=false"></div>
			<div class="pop" v-if="showModal">
				<div class="bottom">
					<div class="text">Issue</div>
					<ul>
						<li>
							<label>Product name: </label>
							<input v-model="productForm.name" type="text" placeholder="Product name">
						</li>
						<li>
							<label> Price: </label>
							<input v-model="productForm.price" type="number" placeholder="0">
						</li>
						<li>
							<label>Usage time:</label>
							<input v-model="productForm.lifeTime" type="text" placeholder="How long you used">
						</li>
						<li>
							<label>Category：</label>
							<select class="choose" v-model="productForm.tag">
								<option value="" disabled selected hidden>Type</option>
								<option>Clothes</option>
								<option>Fitness Equipment</option>
								<option>Device</option>
								<option>Supplies</option>
							</select>
						</li>
						<li>
							<label>Description: </label>
							<textarea placeholder="Describe your product" v-model="productForm.description" wrap="soft"
								autocomplete="off" spellcheck="false" rows="5" class="ivu-input"
								style="width: 450px; min-height: 52px; max-height: 50px; font-size: 15px; border-color: #5162f4; border-radius: 5px">
					  </textarea>
						</li>
						<li>
							<el-upload style="float: left" name="images" :drag="true" ref="upload_attach"
								class="upload-demo" action="" multiple accept=".jpg,.png,.jpeg" :limit="3"
								:file-list="this.images" :auto-upload="false" :on-change="onUploadChange">
								<i class="el-icon-upload"></i>
								<div class="el-upload__text">Drag or <em>click</em></div>


								<div class="el-upload__tip" slot="tip"> 3 jpg/png only，no more than 500kb</div>
							</el-upload>


						</li>
					</ul>
					<el-button class="submit" type="primary" @click="submit">Issue</el-button>

					<el-button @click="showModal=false" class="cancelBtn">Cancel</el-button>

				</div>
			</div>
			<button @click="showModal=true" class="btn">
				<img src="../assets/issue/add.png" style="height:80px;width:80px">
				<p class="h7" style="margin-left: 14px">Issue</p>
			</button>
		</div>
		<div>

			<div class="serchbar">

				<div class="first">x</div>
				<div class="middle">
					<label>
						<input type="text" v-model="searchKey.key">
					</label>
				</div>

				<div class="first">
					<button type="button" @click="search()"></button>
				</div>

			</div>

		</div>



		<!-- <div id="box">
			<dl>
				<dt>品牌：</dt>
				<dd>惠普</dd>
				<dd>联想</dd>
				<dd>戴尔</dd>
				<dd>三星</dd>
				<dd>宏基</dd>
				<dd>苹果</dd>
				<dd>神舟</dd>
				<dd>华硕</dd>
				<dd>方正</dd>
			</dl>
			<dl>
				<dt>价格：</dt>
				<dd>3000-3999</dd>
				<dd>4000-4999</dd>
				<dd>5000-5999</dd>
				<dd>6000-6999</dd>
				<dd>7000-7999</dd>
				<dd>8000-8999</dd>
				<dd>9000-9999</dd>
				<dd>10000以上</dd>
			</dl>
			<dl>
				<dt>尺寸：</dt>
				<dd>8.9英寸以及以下</dd>
				<dd>11英寸</dd>
				<dd>12英寸</dd>
				<dd>13英寸</dd>
				<dd>14英寸</dd>
				<dd>15英寸</dd>
				<dd>16英寸</dd>
			</dl>
			<dl style="border: none">
				<dt>显卡：</dt>
				<dd>独立显卡</dd>
				<dd>集成显卡</dd>
				<dd>核芯显卡</dd>
			</dl>
			<dl class="select" style="border-bottom-width: 0;">
				<dt>已选条件：</dt>
			</dl>
		</div> -->




		<el-row>
			<el-tooltip effect="" placement="right"
				v-for="item in this.pageList.slice((currentPage-1)*pageSize,currentPage*pageSize)">
				<el-card style="width: 220px;margin-bottom: 15px;height: 330px;float: left;margin-left: 140px; "
					bodyStyle="padding:10px">
					<div class="member-image">
						<img :src="'data:image/png;base64,' + item.image1" alt="Member" @click="goGoodsPage(item.name)"
							:onError="defaultImage">
					</div>
					<div class="member-info">
						<h3>{{ item.name }}</h3>
						<h5> price: {{ item.price }}</h5>
						<el-popover placement="top-start" title="Description" width="200" trigger="hover"
							:content="item.description">
							<h6 v-if="item.description.length > 20" slot="reference">description:
								{{item.description.substring(0,20)}}......</h6>
							<h6 v-else slot="reference">Description: {{item.description}}</h6>
						</el-popover>
					</div>
					<div class="social-touch">
						<a class="fb-touch"></a>
						<a class="tweet-touch"></a>
						<a class="linkedin-touch"></a>
					</div>
				</el-card>
			</el-tooltip>
		</el-row>
		<el-row>
			<el-pagination class="pages" @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="currentPage" :page-sizes="[8]" :page-size="this.pageSize"
				layout="total, sizes, prev, pager, next, jumper" :total="totalSize">
			</el-pagination>
		</el-row>
	</div>


</template>

<script>
	import axios from "axios";
	export default {
		name: "issue",
		data() {
			return {
				messageNum: "",
				searchKey: {
					key: "",
				},
				username: this.$route.params.username,
				totalSize: 0,
				currentPage: 1,
				defaultImage: 'this.src="' + require("../assets/fill.png") + '"',
				pageSize: 8,
				pageList: [],
				showModal: false,
				images: [],
				temp: 0,
				productForm: {
					date: "",
					description: "",
					image1: "",
					image2: "",
					image3: "",
					lifeTime: "",
					name: "",
					pid: 0,
					price: "",
					state: true,
					tag: "",
					uid: 0
				},
				file: "",
			}
		},
		mounted: function () {
			axios({
				url: 'http://127.0.0.1:9000/products/' + this.$route.params.username + '/pages',
				method: 'get',
			}).then((res) => {

				this.pageList = res.data;
				this.totalSize = this.pageList.length;
				console.log(this.pageList[0])

			});

			axios({
				url: 'http://127.0.0.1:9000/' + this.$route.params.username + '/message',
				method: 'get',
			}).then((res) => {
				this.messageNum = res.data;
				console.log(this.messageNum);

			});


		},
		methods: {
			goGoodsPage(e) {
				this.$router.push({ name: 'item', params: { username: this.$route.params.username, name: e } });
			},

			search: function () {
				if (this.searchKey.key != '') {
					axios({
						url: 'http://127.0.0.1:9000/products/' + this.$route.params.username + '/searchAll',
						method: 'post',
						data: this.searchKey.key,
					}).then((res) => {
						this.pageList = res.data;
						this.totalSize = this.pageList.length;
						console.log(this.pageList)
					})
				} else {
					axios({
						url: 'http://127.0.0.1:9000/products/' + this.$route.params.username + '/pages',
						method: 'get',
					}).then((res) => {

						this.pageList = res.data;
						this.totalSize = this.pageList.length;
						console.log(this.pageList[0])

					});
				}

			},
			handleCurrentChange: function (currentPage) {
				this.currentPage = currentPage
				console.log(this.currentPage)
			},
			handleSizeChange: function (size) {
				this.pagesize = size;
				console.log(this.pagesize);
			},
			submit: function () {
				if (this.productForm.name == '') {
					this.$message.error("Empty name");
					return;
				}
				if (this.productForm.price == '') {
					this.$message.error("Empty price");
					return;
				} else if (this.productForm.price == 0) {
					this.$message.error("Enter a price");
					return;
				}
				if (this.productForm.tag == '') {
					this.$message.error("Choose a category");
					return;
				}
				if (this.productForm.description == '') {
					this.$message.error("Empty description");
					return;
				}
				axios({
					url: 'http://127.0.0.1:9000/products/upload',
					data: {
						"date": "",
						"description": this.productForm.description,
						"image1": "",
						"image2": "",
						"image3": "",
						"lifeTime": this.productForm.lifeTime,
						"name": this.productForm.name,
						"pid": 0,
						"price": this.productForm.price,
						"state": false,
						"tag": this.productForm.tag,
						"uid": this.$route.params.username
					},
					method: 'put',
				}).then((res) => {
					if (res.data != 0) {
						this.$message.success("Success");
						this.showModal = false;
					} else {
						this.$message.error("Product name have been used");
					}
					console.log(res.data);
					this.temp = res.data;
					let data = new FormData();
					
						for (let i = 0; i < 3; i++) {
							try{
							data.append("images", this.images1[i].raw);
							}catch(e){
								this.$message.error("3 pictures are required");
								return;
							}
					}
					
					axios({
						url: `http://127.0.0.1:9000/products/uploadImage${this.temp}`,

						data: data,
						method: 'post',
						headers: {
							'Content-Type': 'multipart/form-data'
						}
					}).then((res) => {
						console.log(res.data)
						if (res.data == "success") {
							this.showModal = false;
							console.log(res.data);
							this.$message.success("Sucess");
							this.images1 = [];
							
						} else {
							this.$message.error("3 pictures are required");
							console.log("err")
						}

					})
				})

			},
			onUploadChange(file) {
				this.images.push(file)
			},
			home: function () {
				this.$router.push({ name: 'PersonalPage', params: { username: this.username } });
			},
			back() {
				this.$router.push({ name: 'BrowseProduct', params: { username: this.username } });
			}

		},

	}
</script>

<style scoped>
	.body {
		background-image: url("../assets/issue/background.png");
		background-repeat: no-repeat;
		background-size: cover;
		position: absolute;
		height: 200%;
		width: 100%;

		overflow: hidden;
	}

	li {
		list-style: none;
	}

	/* 清除浮动 */

	.clearfix:after {
		content: "";
		display: block;
		height: 0;
		clear: both;
		visibility: hidden;
	}

	.clearfix {
		*zoom: 1;
	}

	.choose {
		width: 65px;
		height: 20px;
		margin-left: 20px;
	}

	.personalInfo {
		margin-bottom: 50px;
	}

	.personalInfo div {
		height: 50px;
		float: right;
	}

	.personalInfo .user,
	.personalInfo .user img {
		height: 51px;
		width: 66px;
		background-color: rgba(78, 97, 243, 1);
		line-height: 50px;
		margin-right: 10px;
	}


	/* 用户信息 */
	.left {
		float: left;
		width: 300px;
		height: 405px;
		border: rgb(81, 98, 244) solid;
		display: inline;
		font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
		border-radius: 30px;
		margin-left: 30px;
		margin-top: 140px;
	}

	.left .user {
		width: 100px;
		height: 100px;
		margin-left: 100px;
		margin-top: 10px;
	}

	h1 {
		text-align: center;
		font-size: 25px;
		margin: 0 auto;
		margin-bottom: 50px;
	}

	h2 {
		text-align: center;
		font-size: 10px;
		margin: 0 auto;
		margin-top: 20px;
		color: #8a8a8a;
	}

	/* 搜索栏 */
	.serchbar {
		height: 60px;
		width: 700px;
		background-color: rgb(20, 65, 39);
		margin: 50px auto;
		border-radius: 30px;
		border-style: solid;
		overflow: hidden;
		margin-top: 150px;
		margin-left: 400px;

	}

	.serchbar div {
		float: left;
	}

	.serchbar .first {
		width: 100px;
		height: 60px;
		background-color: black;
	}

	.serchbar .middle {
		width: 500px;
	}

	.serchbar .middle input {
		width: 485px;
		height: 60px;
		font-size: 30px;
		padding-left: 15px;
	}

	.serchbar .first button {
		width: 75px;
		height: 88px;
		border: hidden;
		background: url("../assets/issue/serch.png");
	}

	/* 商品信息 */
	.item {
		float: left;
		height: 750px;
		width: 1430px;
	}

	.item li {
		float: left;
		width: 320px;
		height: 330px;
		margin-left: 20px;
		margin-right: 5px;
		margin-top: 20px;
		overflow: hidden;
	}

	.single-member {
		width: 280px;
		float: left;
		margin: 30px 2.5%;
		background-color: #fff;
		text-align: center;
		position: relative;
	}

	.member-image img {
		max-width: 100%;
		vertical-align: middle;
	}

	h3 {
		font-size: 24px;
		font-weight: normal;
		margin: 10px 0 0;
		text-transform: uppercase;
	}

	h5 {
		font-size: 16px;
		font-weight: 300;
		margin: 0 0 15px;
		line-height: 22px;
	}

	p {
		font-size: 14px;
		font-weight: 300;
		line-height: 22px;
		padding: 0 30px;
		margin-bottom: 10px;
	}

	.social-touch a {
		display: inline-block;
		width: 27px;
		height: 26px;
		vertical-align: middle;
		margin: 0 2px;
		background-image: url("../assets/issue/social-icons.png");
		background-repeat: no-repeat;
		opacity: 0.7;
		transition: 0.3s;
	}

	.social-touch a:hover {
		opacity: 1;
		transition: 0.3s;
	}

	.fb-touch {
		background-position: 0 0;
	}

	.tweet-touch {
		background-position: -35px 0;
	}

	.linkedin-touch {
		background-position: -71px 0;
	}

	.icon-colored .fb-touch {
		background-position: 0 -27px;
	}

	.icon-colored .tweet-touch {
		background-position: -35px -27px;
	}

	.icon-colored .linkedin-touch {
		background-position: -71px -27px;
	}

	.effect {
		max-height: 302px;
		min-height: 302px;
		overflow: hidden;
	}

	.effect h3 {
		padding-top: 7px;
		line-height: 33px;
	}


	.effect .member-image {
		border-bottom: 5px solid #1fb554;
		height: 212px;
		overflow: hidden;
		width: 100%;
		transition: 0.4s;
		display: inline-block;
		float: none;
		vertical-align: middle;
	}

	.effect .member-info {
		transition: 0.4s;
	}

	.effect .member-image img {
		width: 100%;
		vertical-align: bottom;
	}

	.effect .social-touch {
		background-color: #1fb554;
		float: left;
		left: 0;
		bottom: 0;
		overflow: hidden;
		padding: 5px 0;
		width: 100%;
		transition: 0.4s;
	}

	.effect:hover .member-image {
		height: 81px;
		transition: 0.4s;
	}

	/* 导航 */
	dl,
	dd {
		margin: 0;
	}

	#box {
		width: 850px;
		background: rgba(255, 255, 255, 0.8);
		box-shadow: 0 0 10px rgba(73, 66, 66, .1);
		margin: 50px auto;
		vertical-align: middle;
		border: 1px solid #E5E5E5;
	}

	#box dl {
		height: 50px;
		line-height: 50px;
		border-bottom: 1px dashed #dadada;
		margin: 0 20px;
	}

	#box dt {
		float: left;
		color: #8a8a8a;
	}

	#box dd {
		float: left;
		color: #252525;
		margin: 0 10px;
		font-size: 14px;
		cursor: pointer;
	}

	#box dd.active {
		color: #c4284d;
		font-weight: bold;
	}

	#box dl.select {
		background: #efefef;
		margin: 0;
		padding: 0 20px;
	}

	#box dl.select dd {
		border: 1px solid #c4284d;
		height: 25px;
		line-height: 25px;
		margin-top: 13px;
		padding: 0 2px 0 10px;
		border-radius: 3px;
		background-color: #fff;
	}

	#box dl.select dd span {
		width: 20px;
		height: 20px;
		display: inline-block;
		text-align: center;
		line-height: 20px;
		background: #c4284d;
		color: #fff;
		margin-left: 10px;
		cursor: pointer;
		border-radius: 5px;
	}

	/* 翻页 */
	.pages {

		text-align: center;
	}

	.page li {
		float: left;
		height: 80px;
		width: 130px;
		margin-left: 5px;

	}


	/* 发布框 */
	.text {
		/* 标题Login的样式 */
		font-size: 30px;
		font-weight: bold;
		text-align: center;
		line-height: 50px;
		margin-top: 10px;
		color: #5162f4;
	}

	.h7 {
		font-size: 20px;
		color: black;
		text-align: center;
		float: left;
	}

	.bottom {
		float: left;
		width: 730px;
		height: 700px;
		margin-left: 10px;
		margin-top: 10px;
		background-color: white;
		border-color: #5968ee;
		border-radius: 10px;

	}

	.bottom ul li {
		margin-bottom: 20px;
		font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
		font-size: 20px;
		font-weight: bolder;
		margin-left: 20px;
		margin-top: 20px;

	}

	input {
		width: 300px;
	}



	.bottom .submit {
		width: 100px;
		height: 30px;
		float: right;
		background: rgb(68, 113, 210);
		color: white;
		margin-right: 150px;
		margin-top: 230px;
		border: none;
		outline: none;
		cursor: pointer;
		border-radius: 10px;
		background: linear-gradient(to right, #5162f4, #a6c1ee, #5968ee);
		background-size: 200%;
		font-weight: bold;
		text-align: center;


	}

	.bottom .submit:hover {
		animation: submitAnimate 1s infinite;
	}

	@keyframes submitAnimate {
		50% {
			background-position: 200%;
		}
	}

	.mask {
		background-color: #111;
		z-index: 1
	}



	.pop {
		/*border-width: 5px;*/
		position: fixed;
		top: 0px;
		left: 400px;
		width: 750px;
		height: 720px;
		z-index: 2;
		border-radius: 10px;
		border: #5162f4;
		border-style: solid;
		box-shadow: 10px 10px 10px #5162f4;
		background: white;

	}

	.btn {
		float: right;
		width: 150px;
		height: 140px;
		background-color: white;
		border: white;
		margin-right: 70px;
		margin-top: 50px;
	}

	.cancelBtn {
		width: 100px;
		height: 30px;
		float: right;
		background: linear-gradient(to right, #5162f4, #a6c1ee, #5968ee);
		margin-right: -230px;
		margin-top: 230px;
		border: none;
		outline: none;
		cursor: pointer;
		border-radius: 10px;
		color: #fff;
		font-weight: bold;
		text-align: center;
	}

	.cancelBtn:hover {
		animation: cancelBtnAnimate 1s infinite;
	}

	@keyframes cancelBtnAnimate {
		50% {
			background-position: 200%;
		}
	}
</style>