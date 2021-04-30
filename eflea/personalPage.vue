<template>
	<div class="container">
		<div class="mask" :style="{display:'none'}">
			<div class="login-form">
				<!-- 提交修改信息 -->
				<form action="#" method="POST">
					<div class="form-item ">
						<button class="close">x</button>
						<div>
							<span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspImage:</span>
							<span>
								<input type="file">
							</span>
						</div>

						<div>
							<span>Describle:</span>
							<span>
								<input name='describle' type="txet" placeholder="Username">
							</span>
						</div>
						<div>
							<span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspPrice:</span>
							<span>
								<input name='Price' type="password" placeholder="Password">
							</span>
						</div>


					</div>
					<button class="btn" type="submit">submit</button>

				</form>
			</div>

		</div>
		<h2>Index > Personal Page</h2>
		<div class="mainBox">
			<div class="inforBox">
				<ul class="mainList clearfix">
					<li class="leftBox">
						<img class="user1" src="../assets/personalPage/user.png">
						<h1 class="a">{{username}}</h1>
						<h4 class="edit"><a :href="editPersonalInfoUrl" target="_blank">edit information</a></h4>
						<img class="server1" src="../assets/personalPage/collection.png">
						<h4 class="ser"><a id='myCollectionPage' :style="{color:'red'}" href="javascript:void(0);" ref="page0" @click="showBox(0)">My Collection</a></h4>
						<img class="server2" src="../assets/personalPage/commodity.png">
						<h4 class="ser"><a id='myCommodityPage' :style="{color:'blue'}" href="javascript:void(0);" ref="page1" @click="showBox(1)">My Commodity</a></h4>
						<img class="server3" src="../assets/personalPage/message.png">
						<h4 class="ser"><a id='myMessagePage' :style="{color:'blue'}" href="javascript:void(0);" ref="page2" @click="showBox(2)">My Message</a></h4>
						<img class="server4" src="../assets/personalPage/service.png">
						<h4 class="ser"><a id='servicePage' :style="{color:'blue'}" href="javascript:void(0);" ref="page3" @click="showBox(3)">Customer Service</a></h4>
					</li>
					<li id='collectionRbox' ref="myPage0" class="rbox" :style="{display:'block'}" style="list-style-type:none" >
						<img class="collect" src="../assets/personalPage/collection.png">
						<h1 class="c">My Collection</h1><br />
						<div class="clear"></div>
						<div class="a">
							<div class="single-member effect">
								<div class="member-image">
									<img src="../assets/personalPage/member_270x210.jpg" alt="Member">
								</div>
								<div class="member-info">
									<h3>Sophia</h3>
									<h5>ShowGilr</h5>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
										dolore magna aliqua.</p>
									<div class="social-touch">
										<a class="fb-touch" href="#"></a>
										<a class="tweet-touch" href="#"></a>
										<a class="linkedin-touch" href="#"></a>
									</div>
								</div>
							</div>
						</div>
						<div class="a">
							<div class="single-member effect">
								<div class="member-image">
									<img src="../assets/personalPage/member_270x210.jpg" alt="Member">
								</div>
								<div class="member-info">
									<h3>Sophia</h3>
									<h5>ShowGilr</h5>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
										dolore magna aliqua.</p>
									<div class="social-touch">
										<a class="fb-touch" href="#"></a>
										<a class="tweet-touch" href="#"></a>
										<a class="linkedin-touch" href="#"></a>
									</div>
								</div>
							</div>
						</div>
						<div class="a">
							<div class="single-member effect">
								<div class="member-image">
									<img src="../assets/personalPage/member_270x210.jpg" alt="Member">
								</div>
								<div class="member-info">
									<h3>Sophia</h3>
									<h5>ShowGilr</h5>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
										dolore magna aliqua.</p>
									<div class="social-touch">
										<a class="fb-touch" href="#"></a>
										<a class="tweet-touch" href="#"></a>
										<a class="linkedin-touch" href="#"></a>
									</div>
								</div>
							</div>
						</div>
						<div class="a">
							<div class="single-member effect">
								<div class="member-image">
									<img src="../assets/personalPage/member_270x210.jpg" alt="Member">
								</div>
								<div class="member-info">
									<h3>Sophia</h3>
									<h5>ShowGilr</h5>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
										dolore magna aliqua.</p>
									<div class="social-touch">
										<a class="fb-touch" href="#"></a>
										<a class="tweet-touch" href="#"></a>
										<a class="linkedin-touch" href="#"></a>
									</div>
								</div>
							</div>
						</div>
						<div class="a">
							<div class="single-member effect">
								<div class="member-image">
									<img src="../assets/personalPage/member_270x210.jpg" alt="Member">
								</div>
								<div class="member-info">
									<h3>Sophia</h3>
									<h5>ShowGilr</h5>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
										dolore magna aliqua.</p>
									<div class="social-touch">
										<a class="fb-touch" href="#"></a>
										<a class="tweet-touch" href="#"></a>
										<a class="linkedin-touch" href="#"></a>
									</div>
								</div>
							</div>
						</div>
						<div class="a">
							<div class="single-member effect">
								<div class="member-image">
									<img src="../assets/personalPage/member_270x210.jpg" alt="Member">
								</div>
								<div class="member-info">
									<h3>Sophia</h3>
									<h5>ShowGilr</h5>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
										dolore magna aliqua.</p>
									<div class="social-touch">
										<a class="fb-touch" href="#"></a>
										<a class="tweet-touch" href="#"></a>
										<a class="linkedin-touch" href="#"></a>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li id='commityRbox' ref="myPage1" class="rbox" :style="{display:'none'}" style="list-style-type:none">
						<div class="title clearfix">
							<div class="image1"></div>
							<h1 class="afterImage">
								Selling
							</h1>
						</div>


						<ul class="infoBar clearfix">
							<li class="none"></li>
							<li class="describle">Describle</li>
							<li class="price">Price</li>
							<li class="id">Product ID</li>
							<li class="date">Date</li>
							<li class="state">State</li>
						</ul>
						<!-- 待修改 动态创建 -->
						<ul class="productBar clearfix">
							<li class="none"></li>
							<li class="describle">s</li>
							<li class="price">Price</li>
							<li class="id">Product ID</li>
							<li class="date">Date</li>
							<li class="state">State</li>
							<li class="viewMore"><a href="#">查看详情</a></li>
						</ul>

						<div class="title clearfix">
							<div class="image2"></div>
							<h1 class="afterImage">
								Sold Out
							</h1>
						</div>

						<!-- 待修改 动态创建 -->
						<ul class="productBar clearfix">
							<li class="none"></li>
							<li class="describle">s</li>
							<li class="price">Price</li>
							<li class="id">Product ID</li>
							<li class="date">Date</li>
							<li class="state">State</li>
							<li class="editInfo">
								<div class="editInfoButton"></div>
							</li>

						</ul>

					</li>
					<li id='messageRbox' ref="myPage2" class="rbox" :style="{display:'none'}" style="list-style-type:none">
					</li>
					<li id='serviceRbox' ref="myPage3" class="rbox" :style="{display:'none'}" style="list-style-type:none">
						<div id='Servic' class="telep"><img src="../assets/personalPage/telephone.png" width="70px"></div>
						<div id='Servic' class="let1">someone's telephone</div><br />
						<div id='Servic' class="mail"><img src="../assets/personalPage/mailbox.png" width="70px"></div>
						<div id='Servic' class="let2">someone's mail address</div><br />
						<div id='Servic' class="wec"><img src="../assets/personalPage/wechat.png" width="70px"></div>
						<div id='Servic' class="let3">someone's wechat</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				username: this.$route.params.username,
				editPersonalInfoUrl: "/" + this.$route.params.username + "/editPersonalInfoPage",
			}
		},
		methods:{
			showBox(index){
				var pageList = [this.$refs.page0,this.$refs.page1,this.$refs.page2,this.$refs.page3];
				var pageComponentList = [this.$refs.myPage0,this.$refs.myPage1,this.$refs.myPage2,this.$refs.myPage3];
				for(var i=0;i<4;i++){
					if(i == index){
						pageList[i].style.color = "red";
						pageComponentList[i].style.display="block";
					}
					else{
						pageList[i].style.color = "blue";
						pageComponentList[i].style.display="none";
					}
				}
			},
			
		}
	}
</script>

<style scoped>
	li {
		list-style: none;
	}

	a {
		text-decoration: none;
	}

	* {
		margin: 0;
		padding: 0;
	}

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

	.container {
		font-size: 17px;
		font-weight: bold;
		height: 700px;
		width: 1690px;
		position: relative;
		padding-top: 125px;
		background-color: unset;
		opacity: unset;
	}

	.mask {
		left: 560px;
		top: 155px;
		position: absolute;
		background-color: black;
	}

	.mainBox {
		height: 50px;
		margin-left: 25px;
		/* background-color: blue; */
	}

	.inforBox {
		height: 500px;
		background-color: white(54, 50, 50);
		/* background-color: coral; */
		width: 1600px;
	}

	body {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 10px;
		color: #000;
		background-image: url(../assets/personalPage/background.png);
		min-width: 1100px;
		background-repeat: no-repeat;
		background-size: cover;
	}

	.mainList {
		width: 1600px;
		/* background-color: cyan; */
	}

	h2 {
		margin-left: 10px;
	}

	/* 左盒子 */

	.leftBox {
		float: left;
		width: 250px;
		height: 490px;
		border: 1.5px solid rgb(81 98 244);
		display: inline;
		border-radius: 30px;
		background-color: white;
		margin-top: 15px;
	}

	/* 头像 */

	.user1 {
		width: 90px;
		height: 90px;
		margin-left: 78px;
		margin-top: 10px;
	}

	.a {
		font-size: 25px;
		text-align: center;
	}

	.edit {
		float: left;
		color: white;
		background-color: rgb(81 98 244);
		width: 130px;
		height: 10px;
		border-radius: 20px;
		text-align: center;
		display: inline-table;
		font-size: 15px;
		margin-top: 15px;
		margin-left: 60px;
		padding: 3px;
		text-decoration: none;
	}

	/* 客服头像 */

	.server1 {
		width: 35px;
		margin-top: 30px;
		padding: 10px;
		margin-left: 15px;
	}

	.server2 {
		width: 38px;
		margin-top: 30px;
		padding: 10px;
		margin-left: 15px;
	}

	.server3 {
		width: 42px;
		margin-top: 30px;
		padding: 10px;
		margin-left: 15px;
	}

	.server4 {
		width: 33px;
		margin-top: 30px;
		padding: 10px;
		margin-left: 20px;
	}

	/* 客服文字 */

	.ser {
		font-size: 17px;
		text-decoration: none;
		margin-top: -40px;
		margin-left: 85px;
	}

	/* 右边整个大盒子 */

	.rbox {
		float: left;
		width: 1310px;
		height: 490px;
		border: 2px solid rgb(81 98 244);
		display: inline;
		border-radius: 25px;
		background-color: white;
		margin-top: 15px;
		margin-left: 30px;
		overflow-x: hidden;
		overflow-y: scroll;
	}

	.collect {
		float: left;
		padding: 15px;
		width: 40px;
		margin-left: 30px;
	}

	.c {
		float: left;
		font-size: 25px;
		margin-top: 20px;
	}

	.clear {
		clear: both;
	}

	/* 商品 */

	.single-member {
		float: left;
		height: 30px;
		width: 220px;
		margin-right: 20px;
		background-color: #fff;
		margin-left: 22px;
	}

	.member-image img {
		max-width: 100%;
		vertical-align: middle;
	}

	h3 {
		font-size: 20px;
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
		/* background-image: url("../assets/personalPage/social-icons.png"); */
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

	/*  */

	.telep {
		display: inline-block;
		vertical-align: middle;
		padding: 60px;
		margin-left: 100px;
	}

	.let1 {
		font-size: 20px;
		font-weight: bold;
		display: inline-block;
	}

	.mail {
		display: inline-block;
		vertical-align: middle;
		margin-left: 160px;
	}

	.let2 {
		font-size: 20px;
		font-weight: bold;
		display: inline-block;
		margin-left: 60px;
	}

	.wec {
		display: inline-block;
		vertical-align: middle;
		margin-left: 100px;
		padding: 60px;
	}

	.let3 {
		font-size: 20px;
		font-weight: bold;
		display: inline-block;
	}

	/*  */
	/* 设置标题栏 */

	.title {
		height: 100px;
	}

	.image1 {
		float: left;
		height: 100px;
		width: 100px;
		background-image: url(../assets/personalPage/ed.png);
		background-repeat: no-repeat;
		background-size: cover;
	}

	.image2 {
		float: left;
		height: 100px;
		width: 100px;
		background-image: url(../assets/personalPage/ing.png);
		background-repeat: no-repeat;
		background-size: cover;
	}

	.afterImage {
		float: left;
		margin-top: 25px;
	}

	/* 设置表单样式 */

	.infoBar {
		height: 60px;
		overflow: hidden;
	}

	.productBar {
		height: 200px;
		overflow: hidden;
	}

	.productBar li {
		float: left;
		float: left;
		text-align: center;
		height: 200px;
		line-height: 200px;
	}

	.infoBar li {
		float: left;
		text-align: center;
		height: 60px;
		line-height: 60px;
	}

	.none {
		width: 200px;
	}

	.describle {
		width: 240px;
	}

	.price {
		width: 180px;
	}

	.id {
		width: 250px;
	}

	.date {
		width: 230px;
	}

	.state {
		width: 83px;
	}

	.viewMore {
		padding-left: 20px;
	}

	.editInfo {
		width: 110px;
	}

	.editInfoButton {
		margin: 85px auto;
		width: 30px;
		height: 30px;
		background-image: url(../assets/personalPage/edit.png);
		background-size: cover;
		background-repeat: no-repeat;
	}

	.editInfoButton:hover {
		cursor: pointer;
	}

	/* 修改商品信息 */

	.login-form {
		background-color: rgb(255, 255, 255);
		width: 600px;
		height: 500px;
		border-radius: 15px;
		text-align: center;
		border: #5162f4;
		border-style: solid;
		box-shadow: 10px 10px 10px #5162f4;
		/* 定位到中心 */
	}

	.other,
	.form-item {
		position: relative;
		margin: 10px auto;
		width: 90%;
		margin-top: 10px;
	}

	input {
		width: 50%;
		margin-top: 70px;
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
		width: 70%;
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
		margin-top: 90px;
	}

	.btn:hover {
		animation: btnAnimate 1s infinite;
	}

	@keyframes btnAnimate {
		50% {
			background-position: 200%;
		}
	}

	.close {
		width: 30px;
		height: 30px;
		left: 520px;
		margin-top: 5px;
		position: absolute;
	}
</style>
