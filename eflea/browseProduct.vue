<template>
	<div class="body">
		<div class="personalInfo clearfix">
			<div class="user"><img src="../assets/1.png" alt=""></div>
			<div class="user">my name</div>
		</div>

		<div>
			<h1>E-flea</h1>
		</div>

		<p class="describe">Second-hand trading platform for students </p>
		<!--  -->
		<!--  -->
		<!--  -->
		<!--  -->
		<div>
			<form action="search" method="POST">
				<div class="serchbar">
					<div class="first">x</div>
					<div class="middle">
						<label>
							<input type="text" v-model="keyword">
						</label>
					</div>
					<div class="first">
						<button type="submit"></button>
					</div>
				</div>
			</form>
		</div>
		<!--  -->
		<!--  -->
		<!--  -->
		<!--  -->
		<div class="info">
			<div class="infobar clearfix">
				<div id="op" class="inital">x</div>
				<div>x</div>
				<div>x</div>
			</div>
		</div>
		<!--  -->
		<!--  -->
		<!-- 展板 -->
		<div class="board"></div>
		<!-- 商品页面 -->
		<!--  -->
		<!--  -->
		<!--  -->
		<div>
			<h2>Products center</h2>
		</div>
		<div class="mainBox">
			<div class="market">
				<ul class="leftBox clearfix">
					<li class="biggest">
						<button><a href="#">查看更多</a></button>
					</li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>

		<div class="mainBox">
			<div class="market">
				<ul class="leftBox clearfix">
					<li class="biggest">
						<button><a href="#">查看更多</a></button>
					</li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>

		<div class="mainBox">
			<div class="market">
				<ul class="leftBox clearfix">
					<li class="biggest">
						<button><a href="#">查看更多</a></button>
					</li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>

		<div class="mainBox">
			<div class="market">
				<ul class="leftBox clearfix">
					<li class="biggest">
						<button><a href="#">查看更多</a></button>
					</li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		name: 'browseProduct',
		data() {
			return {
				searchKeyword: {
					keyword: 'keyword',
				},
			}
		},
		methods: {
			search() {
				this.$refs.searchKeyword.validate((valid) => {
					if (valid) {
						this.$message({
							message: 'Success submit!',
							type: 'success',
							showClose: true,
						});
						postRequest('/', this.searchKeyword).then(resp => {
							alert(11);
						})

					} else {
						this.$message({
							message: 'Error submit!',
							type: 'error',
							showClose: true,
						});
						return false;
					}
				});
			}
		}
	}
</script>
<style scoped>
	li {
		list-style: none;
	}


	/* 清除链接下划线 */

	a {
		text-decoration: none;
	}


	/* 清除内外边距 */

	* {
		margin: 0;
		padding: 0;
	}


	/* body样式 */

	.body {
		position: absolute;
		width: 100%;
		height: 100%;
		top: 0;
		left: 0;
		overflow-y: auto;
		font: 14px/1.5 Helvetica Neue, Helvetica, Arial, Microsoft Yahei, Hiragino Sans GB, Heiti SC, WenQuanYi Micro Hei, sans-serif;
		color: #333;
		background-color: rgb(247, 247, 247);
		min-width: 1226px;
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


	/* 顶部信息 */

	.personalInfo {
		margin-bottom: 50px;
	}

	.personalInfo div {
		height: 50px;
		float: right;
	}

	.personalInfo .user {
		height: 51px;
		width: 66px;
		background-color: rgba(247, 247, 247, 1);
		line-height: 50px;
	}

	h1 {
		text-align: center;
		margin-bottom: 40px;
		font-size: 60px;
	}

	.describe {
		text-align: center;
		margin-bottom: 30px;
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
		background: url(../assets/search.png);
	}


	/* 信息栏 */

	.infobar {
		margin: 0 auto;
		padding-top: 0;
		padding-left: 0;
		width: 900px;
		height: 210px;
		overflow: hidden;
	}

	.infobar div {
		margin-left: 100px;
		float: left;
		width: 200px;
		height: 200px;
		background-color: rgb(198, 224, 240);
		border-bottom-left-radius: 50px;
		box-shadow: -10px 10px 5px rgb(184, 179, 179);
	}

	#op {
		margin-left: 50px;
	}


	/* 大型展板 */

	.board {
		margin: 100px auto;
		width: 1450px;
		height: 600px;
		background-color: black;
	}


	/* 标题 */

	h2 {
		margin-top: 100px;
		text-align: center;
		margin-bottom: 40px;
		font-size: 60px;
		color: rgb(189, 177, 177);
	}


	/* 商品展示页面 */

	.mainBox {
		margin-top: 100px;
	}

	.market {
		margin: 0 auto;
		width: 1450px;
		height: 620px;
		background-color: rgb(54, 50, 50);
	}

	.leftBox .biggest {
		margin: 5px;
		float: left;
		width: 400px;
		height: 610px;
		background-color: #ff0000;
	}

	.leftBox li {
		margin: 5px;
		float: left;
		width: 250px;
		height: 300px;
		background-color: orange;
	}

	.leftBox .biggest button {
		width: 160px;
		height: 60px;
		margin-top: 400px;
		margin-left: 120px;
		border-style: solid;
		border-color: white;
		background-color: red;
		font-size: 18px;
	}

	.leftBox .biggest button a {
		color: white;
	}
</style>>
