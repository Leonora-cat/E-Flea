<template>
	<div class="body">
		<div class="personalInfo clearfix">
			<div class="user"><a @click="home()" href="javascript:void(0);"><img src="../assets/back1.png" alt=""></a>

			</div>
		</div>
		<div class="container">
			<div ref="mask" class="mask" :style="{display:'none',zIndex: 999,}">

				<div class="login-form-first">

					<div class="form-item ">
						<button class="close" @click="close()">x</button>

						<div>
							<span>Product name:</span>
							<span>
								<input type="text" placeholder="Product name" v-model="editProduct.name"
									readonly="readonly">
							</span>
						</div>
						<div>
							<span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspPrice:</span>
							<span>
								<input type="text" placeholder="0" v-model="editProduct.price">
							</span>
						</div>
						<div>
							<span>Usage Time:</span>
							<span>
								<input type="text" placeholder="How long you used" v-model="editProduct.lifeTime">
							</span>
						</div>
						<div style="margin-left:-190px;">
							<span>Category:</span>

							<span>
								<select style="width: 100px;" class="choose" v-model="editProduct.tag">
									<option value="" disabled selected hidden>Type</option>
									<option>Clothes</option>
									<option>Fitness equipment</option>
									<option>Device</option>
									<option>Supplies</option>
								</select>
							</span>
						</div>
						<div style="margin-bottom:10px">
							<span>Description:</span>
							<span>
								<input type="text" placeholder="Description" v-model="editProduct.description">
							</span>
						</div>
						<div>
							<!--              <el-row>-->
							<!--                <el-image-->
							<!--                    style="width: 100px; height: 100px; margin: 20px"-->
							<!--                    :src="'data:image/png;base64,' + this.images2[0]"-->
							<!--                    ></el-image>-->
							<!--                <el-image-->
							<!--                    style="width: 100px; height: 100px; margin: 20px"-->
							<!--                    :src="'data:image/png;base64,' + this.images2[1]"-->
							<!--                    ></el-image>-->
							<!--                <el-image-->
							<!--                    style="width: 100px; height: 100px; margin: 20px"-->
							<!--                    :src="'data:image/png;base64,' + this.images2[2]"-->
							<!--                    ></el-image>-->
							<!--              </el-row>-->
							<el-upload class="upload-demo" :on-change="onUploadChange" :limit="3"
								:file-list="this.images" :auto-upload="false" list-type="picture" action="">
								<el-button size="small" type="primary">Upload</el-button>
								<div slot="tip" class="el-upload__tip"> 3 jpg/png only，no more than 500kb</div>
							</el-upload>

						</div>

						<button style="margin-top: 15px" class="btn" @click="editProductInfo()">submit</button>
					</div>

				</div>

			</div>
			<div ref="mask2" class="mask2" :style="{display:'none',zIndex: 999,}">
				<div class="login-form2">
					<div class="form-item2">
						<button class="close" @click="close2()">x</button>
						<form>

							<div>
								<span>Product name: </span>

								<span>
									<input type="text" placeholder="Product name" v-model="productForm.name">
								</span>
							</div>

							<div>
								<span>Price:</span>

								<span>
									<input type="text" placeholder="0" oninput="value=value.replace(/[^\d]/g,'')"
										v-model="productForm.price">
								</span>
							</div>

							<div>
								<span>Usage time:</span>

								<span>
									<input type="text" placeholder="How long you used" v-model="productForm.lifeTime">
								</span>
							</div>

							<div>
								<span>Category:</span>

								<span>
									<select class="choose" v-model="productForm.tag">
										<option value="" disabled selected hidden>Type</option>
										<option>Clothes</option>
										<option>Fitness Equipment</option>
										<option>Device</option>
										<option>Supplies</option>
									</select>
								</span>
							</div>

							<div style="margin-top: 10px;">
								<!-- <el-upload style="margin-top: 30px;height: 167px;" name="images" :drag="true"
									ref="upload_attach" class="upload-demo" action="" multiple accept=".jpg,.png,.jpeg"
									:limit="3" :file-list="this.images" :auto-upload="false"
									:on-change= "onUploadChange">
									<i class="el-icon-upload"></i>
									<div class="el-upload__text">Drag or <em>click</em></div>


									<div class="el-upload__tip" slot="tip"> 3 jpg/png only，no more than 500kb</div>
								</el-upload> -->
								<el-upload class="upload-demo" :on-change="onUploadChange" :limit="3"
									:file-list="this.images" :auto-upload="false" list-type="picture" action="">
									<el-button size="small" type="primary">Upload</el-button>
									<div slot="tip" class="el-upload__tip"> 3 jpg/png only，no more than 500kb</div>
								</el-upload>


							</div>

							<div style="position: absolute;top: 486px;left: -32px;">
								<span style="position: relative;left: 30px;bottom: 20px">Description:</span>
								<span style="position: relative;left: 40px">
									<textarea style="height: 25px;" rows="2" cols="50" v-model="productForm.description"
										placeholder="Describe your product"></textarea>
								</span>
							</div>
						</form>
						<button style="position: absolute;top:580px;left: 86px;margin-top: 5px;" class="btn"
							@click="submit()">issue</button>

					</div>

				</div>

			</div>

			<div ref="mask3" class="mask3" :style="{display:'none',zIndex: 999,}">

				<div class="login-form" :model="editForm">

					<div class="form-item3">
						<button class="close" @click="close3()">x</button>
						<form>
							<div>
								<span>Username:</span>
								<span>
									<input type="text" :placeholder="username" v-model="editForm.username"
										readonly="readonly">
								</span>
							</div>

							<div>
								<span>Email:</span>
								<span>
									<input type="text" placeholder="email" v-model="editForm.email" readonly="readonly">
								</span>
							</div>

							<div>
								<span>Major:</span>
								<span>
									<input type="text" placeholder="major" v-model="editForm.major">
								</span>
							</div>

							<div>
								<span>Birthday:</span>
								<span>
									<select v-model="editForm.year">
										<option selected>1990</option>
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

									<select v-model="editForm.month">
										<option selected>1</option>
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
									<select v-model="editForm.day">
										<option selected>1</option>
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
									Sex:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<label for="s">Male</label><input
										type="radio" name="al" checked="checked" id="s" value="0"
										v-model="editForm.sex">Female<input type="radio" name="al" value="1"
										v-model="editForm.sex">
								</span>
							</div>

						</form>
						<button style="margin-top:50px;margin-right: 10px;" class="editBtn" @click="editInfo()">Edit
							Info</button>
						<button style="margin-top: 50px;margin-left: 10px;" class="resetBtn"
							@click="resetPassword()">Reset Password</button>

					</div>

				</div>

			</div>
			<div class="mainBox">
				<div class="inforBox">
					<ul class="mainList clearfix">
						<li class="leftBox">
							<img class="user1" src="../assets/personalPage/user.png">
							<h1 class="a">{{ username }}</h1>
							<h4 class="edit"><a href="javascript:void(0);" @click="editBox3()">Account Info</a></h4>

							<img class="server0" src="../assets/personalPage/add.png" @click="showModal=true">
							<h4 class="ser"><a id='myPublished' :style="{color:'#0061a8'}" href="javascript:void(0);"
									ref="issue" @click=editBox2>Issue</a></h4>

							<img class="server1" src="../assets/personalPage/collection.png">
							<h4 class="ser"><a id='myCollectionPage' :style="{color:'#7f61ff'}"
									href="javascript:void(0);" ref="page0" @click="showBox(0)">Products for sale</a>
							</h4>
							<img class="server2" src="../assets/personalPage/commodity.png">
							<h4 class="ser"><a id='myCommodityPage' :style="{color:'#0061a8'}"
									href="javascript:void(0);" ref="page1" @click="showBox(1)">Products sold</a></h4>
							<img class="server3" src="../assets/personalPage/message.png">
							<h4 class="ser"><a id='myMessagePage' :style="{color:'#0061a8'}" href="javascript:void(0);"
									ref="page2" @click="showBox(2)">My
									message</a></h4>
							<img class="server4" src="../assets/personalPage/service.png">
							<h4 class="ser"><a id='servicePage' :style="{color:'#0061a8'}" href="javascript:void(0);"
									ref="page3" @click="showBox(3)">Customer
									service</a></h4>
						</li>

						<li id='collectionRbox' ref="myPage0" class="rbox" :style="{display:'block'}"
							style="list-style-type:none">

							<img class="collect" src="../assets/personalPage/collection.png">
							<h1 class="c">Products for sale</h1><br />
							<div class="clear"></div>
							<div class="a">
								<el-row>
									<el-tooltip effect="" placement="right"
										v-for="item in this.pageList.slice((currentPage-1)*pageSize,currentPage*pageSize)">
										<el-card
											style="width: 220px;margin-bottom: 15px;height: 330px;float: left;margin-left: 100px;position: relative; "
											bodyStyle="padding:10px">
											<button class="editInfoButton2" @click="close4(item)">$</button>

											<div class="editInfoButton" @click="editBox(item)"></div>

											<div class="member-image">
												<img :src="'data:image/png;base64,' + item.image1" alt="Member"
													@click="jump(item.name)" :onError="defaultImage">
											</div>
											<div class="member-info">
												<h3>{{ item.name }}</h3>
												<h5> price: {{ item.price }}</h5>
												<el-popover placement="top-start" title="Description" width="200"
													trigger="hover" :content="item.description">
													<h6 v-if="item.description.length > 20" slot="reference">
														Description:
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
									<el-pagination class="pages" @size-change="handleSizeChange"
										@current-change="handleCurrentChange" :current-page="currentPage"
										:page-sizes="[6]" :page-size="this.pageSize"
										layout="total, sizes, prev, pager, next, jumper" :total="totalSize">
									</el-pagination>
								</el-row>

							</div>


						</li>

						<li id='commityRbox' ref="myPage1" class="rbox" :style="{display:'none'}"
							style="list-style-type:none">

							<img class="collect" src="../assets/personalPage/collection.png">
							<h1 class="c">Products sold</h1><br />
							<div class="clear"></div>
							<div class="a">

								<el-row>
									<el-tooltip effect="" placement="right"
										v-for="item in this.pageList1.slice((currentPage1-1)*pageSize1,currentPage1*pageSize1)">
										<el-card
											style="width: 220px;margin-bottom: 15px;height: 330px;float: left;margin-left: 100px; "
											bodyStyle="padding:10px">
											<div class="member-image">
												<img :src="'data:image/png;base64,' + item.image1" alt=""
													:onError="defaultImage" @click="jump(item.name)">

											</div>
											<div class="member-info">
												<h3>{{ item.name }}</h3>
												<h5> price: {{ item.price }}</h5>
												<el-popover placement="top-start" title="Description" width="200"
													trigger="hover" :content="item.description">
													<h6 v-if="item.description.length > 20" slot="reference">
														Description:
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
									<el-pagination class="pages" @size-change="handleSizeChange1"
										@current-change="handleCurrentChange1" :current-page="currentPage1"
										:page-sizes="[6]" :page-size="this.pageSize1"
										layout="total, sizes, prev, pager, next, jumper" :total="totalSize1">
									</el-pagination>
								</el-row>
							</div>



						</li>
						<li id='messageRbox' ref="myPage2" class="rbox" :style="{display:'none'}"
							style="list-style-type:none">
							<div class="chatbox">
								<div class="chatleft">
									<div class="center">
										<ul v-for="item in contactList">
											<li>
												<img style="border-radius: 20px; vertical-align: middle;"
													src="http://placehold.it/40x40">
												<span style="margin-left: 10px;"><a @click="openContact(item)"
														href="javascript:void(0);">{{ item }}</a></span>
											</li>
										</ul>
									</div>
								</div>
								<div ref="chatBox" class="chatright" :style="{display:'none'}">
									<div class="top">
										<img style="border-radius: 20px; vertical-align: middle;"
											src="http://placehold.it/40x40">
										<span style="margin-left: 20px;">{{ currentContact }}</span>
										<i class="fas fa-ellipsis-v"
											style="font-size: 1.4em; position: absolute; right: 20px; color: gray;"></i>
									</div>
									<div class="center">
										<ul ref="messageBox" v-for="item in messageList" id="message">
											<li class="msgleft" v-if="item.receiver == username">
												<img style="border-radius: 20px; vertical-align: top;"
													src="http://placehold.it/40x40">
												<p class="msgcard">{{ item.content }}</p>
											</li>
											<li class="msgright" v-if="item.sender == username">
												<p class="msgcard">{{ item.content }}</p>
												<img style="border-radius: 20px; vertical-align: top;"
													src="http://placehold.it/40x40">
											</li>
										</ul>
									</div>
									<div class="footer">
										<textarea maxlength="800" rows="5" cols="40"
											style="width: 100%; resize: none; border: none; "
											placeholder="Please type..." v-model="text"></textarea>
										<button class="sendbtn" @click="send()">Send</button>
									</div>
								</div>
							</div>
						</li>
						<li id='serviceRbox' ref="myPage3" class="rbox" :style="{display:'none'}"
							style="list-style-type:none">
							<div id='Servic' class="telep"><img src="../assets/personalPage/telephone.png" width="70px">
							</div>
							<div id='Servic' class="let1">13849657482</div>
							<br />
							<div id='Servic' class="mail"><img src="../assets/personalPage/mailbox.png" width="70px">
							</div>
							<div id='Servic' class="let2">CustomerService@eflea.com</div>
							<br />
							<div id='Servic' class="wec"><img src="../assets/personalPage/wechat.png" width="70px">
							</div>
							<div id='Servic' class="let3">CustomerServiceEflea</div>
						</li>
					</ul>

				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import axios from "axios";

	export default {
		data() {
			return {

				totalSize1: 0,

				currentPage1: 1,

				pageSize1: 6,
				pageList1: [],

				totalSize: 0,

				currentPage: 1,
				defaultImage: 'this.src="' + require("../assets/fill.png") + '"',
				pageSize: 6,
				pageList: [],
				productForm: {
					date: "",
					description: '',
					image1: "",
					image2: "",
					image3: "",
					lifeTime: '',
					name: '',
					pid: 0,
					price: '',
					state: true,
					tag: '',
					uid: 0
				},
				editProduct: {
					uid: '',
					description: '',
					price: '',
					lifeTime: '',
					name: '',
					tag: '',
				},
				editForm: {
					username: this.$route.params.username,
					email: '',
					year: '',
					month: '',
					day: '',
					sex: '',
					major: '',
					password: '',
				},
				images: [],
				images2: [],
				images3: [],
				showModal: false,
				username: this.$route.params.username,
				contactList: '',
				currentContact: '',
				messageList: '',
				text: '',
				timer: '',
			}
		},
		mounted: function () {
			axios({
				url: 'http://127.0.0.1:9000/products/' + this.$route.params.username + '/selling',
				method: 'get',
			}).then((res) => {

				this.pageList = res.data;
				this.totalSize = this.pageList.length;
				console.log(this.pageList[0])

			});
		},
		methods: {
			showBox(index) {
				var pageList = [this.$refs.page0, this.$refs.page1, this.$refs.page2, this.$refs.page3];
				var pageComponentList = [this.$refs.myPage0, this.$refs.myPage1, this.$refs.myPage2, this.$refs.myPage3];
				for (var i = 0; i < 4; i++) {
					if (i == index) {
						pageList[i].style.color = "#7f61ff";
						pageComponentList[i].style.display = "block";
					} else {
						pageList[i].style.color = "#0061a8";
						pageComponentList[i].style.display = "none";
					}
				}
				if (index == 0) {
					axios({
						url: 'http://127.0.0.1:9000/products/' + this.$route.params.username + '/selling',
						method: 'get',
					}).then((res) => {

						this.pageList = res.data;
						this.totalSize = this.pageList.length;
						console.log(this.pageList[0])

					});
				}
				if (index == 1) {
					axios({
						url: 'http://127.0.0.1:9000/products/' + this.$route.params.username + '/sold',
						method: 'get',
					}).then((res) => {

						this.pageList1 = res.data;
						this.totalSize1 = this.pageList1.length;
						console.log(this.pageList1[0])

					});
				}
				if (index == 2) {
					axios({
						url: 'http://127.0.0.1:9000/' + this.$route.params.username + '/contactList',
						method: 'get',
					}).then((res) => {
						this.contactList = res.data;
						console.log(this.contactList);

					});
				}
			},
			editBox() {
				this.$refs.mask.style.display = "block";
			},
			editBox2() {
				this.$refs.mask2.style.display = "block";
				this.$refs.issue.style.color = "#7f61ff";
			},
			async editBox3() {

				const {
					data: res
				} = await this.$http.get("http://127.0.0.1:9000/" + this.$route.params.username + "/home");
				this.$refs.mask3.style.display = "block";
				this.editForm.email = res.userInfo.email;
				this.editForm.major = res.userInfo.major;
				this.editForm.year = res.userInfo.dateOfBirth.substring(0, 4);
				this.editForm.month = res.userInfo.dateOfBirth.substring(5, 7).replace(/\b(0+)/gi, "");
				this.editForm.day = res.userInfo.dateOfBirth.substring(8, 10).replace(/\b(0+)/gi, "");
				console.log(typeof (res.userInfo.sex));
				if (res.userInfo.sex == "0") {
					this.editForm.sex = 0;
				}
				else {
					this.editForm.sex = 1;
				}
			},
			close() {
				this.images3 = [];
				this.images = [];
				this.$refs.mask.style.display = "none";
			},
			close2() {
				this.$refs.mask2.style.display = "none";
				this.$refs.issue.style.color = "#0061a8";
			},
			close3() {
				this.$refs.mask3.style.display = "none";
			},
			close4(item) {
				axios({
					url: 'http://127.0.0.1:9000/products/updateState',
					method: 'put',
					data: {
						date: "",
						description: item.description,
						lifeTime: item.lifeTime,
						name: item.name,
						pid: item.pid,
						price: item.price,
						state: true,
						tag: item.tag,
						uid: item.uid
					}
				}).then((res) => {
					if (res.data == "success") {
						this.$message.success("The product is sold");
						axios({
							url: 'http://127.0.0.1:9000/products/' + this.$route.params.username + '/selling',
							method: 'get',
						}).then((res) => {
							this.pageList = res.data;
							this.totalSize = this.pageList.length;
							console.log(this.pageList[0])

						});
					}
				});

			},
			openContact(name) {
				clearInterval(this.timer);
				this.currentContact = name;
				this.$refs.chatBox.style.display = "block";
				axios({
					url: 'http://127.0.0.1:9000/' + this.$route.params.username + '/' + name + '/contactDetail',
					method: 'get',
				}).then((res) => {
					this.messageList = res.data;
					console.log(this.messageList);
				});

				this.timer = setInterval(() => {

					axios({
						url: 'http://127.0.0.1:9000/' + this.$route.params.username + '/' + name + '/contactDetail',
						method: 'get',
					}).then((res) => {
						this.messageList = res.data;
						console.log(this.messageList);
					});

				}, 6000)

			},
			handleCurrentChange: function (currentPage) {
				this.currentPage = currentPage
				console.log(this.currentPage)
			},
			handleSizeChange: function (size) {
				this.pagesize = size;
				console.log(this.pagesize)
			},
			handleCurrentChange1: function (currentPage) {
				this.currentPage1 = currentPage
				console.log(this.currentPage1)
			},
			handleSizeChange1: function (size) {
				this.pagesize1 = size;
				console.log(this.pagesize)
			},
			home: function () {
				this.$router.push({ name: 'BrowseProduct', params: { username: this.$route.params.username } });
			},
			jump(e) {
				this.$router.push({ name: 'item', params: { username: this.$route.params.username, name: e } });
			},
			send() {
				var message = {
					content: this.text,
					messageId: null,
					receiver: this.currentContact,
					sendTime: null,
					sender: this.username
				};
				this.messageList.push(message);
				this.text = '';
				axios({
					url: 'http://127.0.0.1:9000/addContent',
					method: 'post',
					data: message,
				}).then((res) => {
					this.messageList = res.data;
					console.log(this.messageList);
				})
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
				if (this.productForm.price >= 9999999) {
					this.$message.error("The price should be smaller than 9999999");
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
						this.$refs.mask2.style.display = "none";
						this.$message.success("Success");
					} else {
						this.$message.error("Product name have been used");
					}
					console.log(res.data);

					this.temp = res.data;
					let data = new FormData();
					for (let i = 0; i < 3; i++) {
							try{
							data.append("images", this.images[i].raw);
							}catch(e){
								this.$message.error("3 pictures are required");
								return;
							}
					}
					console.log(this.images);

					axios({
						url: `http://127.0.0.1:9000/products/uploadImage${this.temp}`,

						data: data,
						method: 'post',
						headers: {
							'Content-Type': 'multipart/form-data'
						}
					}).then((res) => {
						if (res.data != "success") {
							this.$message.error("Upload picture failed! Pleas choose no more than 3 images!");
							console.log("err");
						} else {
							console.log(res.data);
							this.$message.success(res.data);
							this.$refs.mask2.style.display = "none";
							this.$refs.issue.style.color = '#0061a8';
							this.images = [];
							this.productForm.email = '';
							this.productForm.description = '';
							this.productForm.lifeTime = '';
							this.productForm.name = '';
							this.productForm.price = 0;
							this.productForm.tag = '';
							this.productForm.state = true;
							if (this.$refs.page0.style.color != this.$refs.issue.style.color) {
								axios({
									url: 'http://127.0.0.1:9000/products/' + this.$route.params.username + '/selling',
									method: 'get',
								}).then((res) => {

									this.pageList = res.data;
									this.totalSize = this.pageList.length;
									console.log(this.pageList[0])

								});
							}
						}

					})
				});
			},
			onUploadChange(file) {
				this.images.push(file)
				console.log(111)
			},
			onUploadChange3(file) {
				this.images3.push(file)
			},
			async editInfo() {
				var form = {
					username: this.editForm.username,
					email: this.editForm.email,
					year: this.editForm.year,
					month: this.editForm.month,
					day: this.editForm.day,
					sex: '',
					major: this.editForm.major,
				};
				if (this.editForm.sex == "0") {
					form.sex = 0;
				} else {
					form.sex = 1;
				}
				const {
					data: res
				} = await this.$http.post("http://127.0.0.1:9000/editPersonalInfo", form);
				if (res != "success") {
					this.$message.error("Email has been used");
				} else {
					this.$message.success("Success");
					this.$refs.mask3.style.display = "none";
				}

			},
			editBox(item) {
				// this.images.push(item.image1);
				// this.images.push(item.image2);
				// this.images.push(item.image3);
				console.log(item);
				this.editProduct.pid = item.pid;
				this.editProduct.tag = item.tag;
				this.editProduct.description = item.description;
				this.editProduct.price = item.price;
				this.editProduct.lifeTime = item.lifeTime;
				this.editProduct.tag = item.tag;
				this.editProduct.name = item.name;
				this.$refs.mask.style.display = "block";
			},
			editProductInfo() {

				if (this.editProduct.price == '') {
					this.$message.error("Empty price");
					return;
				} else if (this.editProduct.price == 0) {
					this.$message.error("Enter a price");
					return;
				}

				if (this.editProduct.price >= 9999999) {
					this.$message.error("The price should be smaller than 9999999");
					return;
				}
				if (this.editProduct.description == '') {
					this.$message.error("Empty description");
					return;
				}
				axios({
					url: 'http://127.0.0.1:9000/products/update' + this.editProduct.pid,

					data: this.editProduct,
					method: 'put',
				}).then((res) => {
					if (res.data != "success") {
						this.$message.error(res.data);
					} else {
						this.$message.success(res.data);
						this.$refs.mask.style.display = "none";
						axios({
							url: 'http://127.0.0.1:9000/products/' + this.$route.params.username + '/selling',
							method: 'get',
						}).then((res) => {

							this.pageList = res.data;
							this.totalSize = this.pageList.length;
							console.log(this.pageList[0])

						});
					}
				});

				let data = new FormData();
				for (let i = 0; i < 3; i++) {

					data.append("images", this.images[i].raw);

				}

				axios({
					url: `http://127.0.0.1:9000/products/uploadImage` + this.editProduct.pid,

					data: data,
					method: 'post',
					headers: {
						'Content-Type': 'multipart/form-data'
					}
				}).then((res) => {
					if (res.data !== "success") {
						this.$message.error("Upload picture failed! Pleas choose no more than 3 images!");
						console.log("err");
						this.images = [];
					} else {
						console.log(res.data);
						this.$message.success(res.data);
						this.$refs.mask.style.display = "none";

						this.images = [];
					}

				});
			},
			back() {
				this.$router.push({ name: 'BrowseProduct', params: { username: this.username } });
			},
			imgError() {
				this.$refs.img.src = this.defaultImage;
			},
			resetPassword() {
				this.$router.push({ name: 'ResetPassword', params: { username: this.username, email: this.editForm.email } });
			}


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




	.personalInfo {
		margin-bottom: 50px;
	}

	.personalInfo div {
		height: 50px;
		float: right;
	}

	.personalInfo .user {
		height: 66px;
		width: 66px;
		background-color: rgba(78, 97, 243, 0);
		line-height: 50px;
		margin-right: 20px;
		margin-top: 10px;
	}

	.personalInfo .user img {
		height: 66px;
		width: 66px;
		background-color: rgba(78, 97, 243, 0);
		line-height: 50px;
		margin-right: 20px;
		margin-top: 10px;
	}

	.container {
		font-size: 17px;
		font-weight: bold;
		height: 564px;
		width: 1390px;
		position: relative;
		background-color: unset;
		opacity: unset;
	}

	.mask {
		left: 560px;
		top: 55px;
		position: absolute;
		background-color: black;
	}

	.mask2 {
		left: 560px;
		top: 25px;
		position: absolute;
		background-color: black
	}

	.mask3 {
		left: 560px;
		top: 155px;
		position: absolute;
		background-color: black;
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

	.bottom ul li input {
		margin-top: 20px;
		padding: 10px;
		border: 0;
		outline: none;
		border-bottom: 1px solid #5162f4;
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

	.text {
		font-size: 30px;
		font-weight: bold;
		text-align: center;
		line-height: 50px;
		margin-top: 10px;
		color: #5162f4;
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
		width: 1390px;
	}

	.body {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 10px;
		color: #000;
		background-image: url(../assets/personalPage/background.png);
		min-width: 1100px;
		background-repeat: no-repeat;
		background-size: cover;

	}

	.mainList {
		width: 1390px;
		/* background-color: cyan; */
	}

	h2 {
		margin-left: 10px;
	}


	.leftBox {
		float: left;
		width: 250px;
		height: 490px;
		display: inline;
		border-radius: 30px;
		background-color: white;
		margin-top: 15px;
	}

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
		background-color: #0061a8;
		color: white;
		width: 130px;
		height: 10px;
		border-radius: 20px;
		text-align: center;
		display: inline-table;
		font-size: 15px;
		margin-top: 0px;
		margin-left: 60px;
		padding: 3px;
		text-decoration: none;
	}

	.edit a {
		color: white;
	}

	.server0 {
		width: 35px;
		margin-top: 0px;
		padding: 10px;
		margin-left: 15px;
	}

	.server1 {
		width: 35px;
		margin-top: 25px;
		padding: 10px;
		margin-left: 15px;
	}

	.server2 {
		width: 38px;
		margin-top: 25px;
		padding: 10px;
		margin-left: 12px;
	}

	.server3 {
		width: 35px;
		margin-top: 25px;
		padding: 10px;
		margin-left: 15px;
	}

	.server4 {
		width: 35px;
		margin-top: 30px;
		padding: 10px;
		margin-left: 15px;
	}


	.ser {
		font-size: 17px;
		text-decoration: none;
		margin-top: -40px;
		margin-left: 85px;
	}


	.rbox {
		float: left;
		width: 1100px;
		height: 490px;
		display: inline;
		border-radius: 25px;
		background-color: white;
		margin-top: 15px;
		margin-left: 40px;
		overflow-x: hidden;

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
		border-bottom: 5px solid #0061a8;
		height: 212px;
		overflow: hidden;
		width: 100%;
		transition: 0.4s;
		display: inline-block;
		float: none;
		vertical-align: middle;
	}

	.effect .member-info {
		position: relative;
		transition: 0.4s;
	}

	.effect .member-image img {
		width: 100%;
		vertical-align: bottom;
	}

	.effect .social-touch {
		background-color: #0061a8;
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

	.infoBar {
		height: 60px;
		overflow: hidden;
	}

	.pages {

		text-align: center;
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
		width: 100px;
	}

	.describle {
		width: 120px;
	}

	.price {
		width: 90px;
	}

	.id {
		width: 125px;
	}

	.date {
		width: 165px;
	}

	.state {
		width: 41px;
	}

	.viewMore {
		padding-left: 20px;
	}

	.editInfo {
		width: 40px;
	}

	.editInfoButton {
		position: absolute;
		left: 2px;
		top: 2px;
		width: 20px;
		height: 20px;
		background-image: url(../assets/personalPage/edit.png);
		background-size: cover;
		background-repeat: no-repeat;
	}

	.editInfoButton2 {
		position: absolute;
		left: 195px;
		top: 2px;
		width: 20px;
		height: 20px;
		border-radius: 10px;
		background-color: white;
		border-color: rgba(158, 154, 154, 0.322);
	}

	.editInfoButton2:hover,
	.editInfoButton:hover {
		cursor: pointer;
	}

	.login-form-first {

		position: absolute;
		top: -170px;
		background-color: rgb(255, 255, 255);
		width: 600px;
		height: 670px;
		border-radius: 15px;
		text-align: center;
		border: #5162f4;
		border-style: solid;
		box-shadow: 10px 10px 10px #5162f4;
	}

	.login-form {

		position: absolute;
		top: -260px;
		background-color: rgb(255, 255, 255);
		width: 600px;
		height: 640px;
		border-radius: 15px;
		text-align: center;
		border: #5162f4;
		border-style: solid;
		box-shadow: 10px 10px 10px #5162f4;
	}

	.login-form2 {

		position: absolute;
		top: -135px;
		background-color: rgb(255, 255, 255);
		width: 600px;
		height: 650px;
		border-radius: 15px;
		text-align: center;
		border: #5162f4;
		border-style: solid;
		box-shadow: 10px 10px 10px #5162f4;
	}

	.choose {
		width: 65px;
		height: 20px;
		margin-left: 20px;
	}

	.other,
	.form-item,
	.form-item3 {
		position: relative;
		margin: 10px auto;
		width: 90%;
		margin-top: 10px;
	}

	.form-item2 {
		position: relative;
		margin: 10px auto;
		width: 90%;

	}

	.form-item3 input {
		width: 50%;
		margin-top: 40px;
		padding: 10px;
		border: 0;
		outline: none;
		border-bottom: 1px solid #5162f4;
	}

	.form-item3 select {
		width: 15%;
		margin-top: 30px;
		margin-left: 20px;
		padding: 10px;
		outline: none;
	}

	.form-item3 .sex input {
		width: 20%;
		margin-top: 40px;
		padding: 10px;
		border: 0;
		outline: none;
		border-bottom: 1px solid #5162f4;
	}


	input {
		width: 50%;
		margin-top: 10px;
		padding: 10px;
		border: 0;
		outline: none;
		border-bottom: 1px solid #5162f4;
	}

	.form-item2 input {
		width: 50%;
		margin-top: 3px;
		padding: 10px;
		border: 0;
		outline: none;
		border-bottom: 1px solid #5162f4;
	}

	.form-item2 textarea {
		width: 50%;
		margin-top: 36px;
		padding: 10px;
		outline: none;
		border-bottom: 1px solid #5162f4;
	}

	.form-item2 select {
		width: 50%;
		margin-top: 18px;
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
		margin-top: 90px;
	}

	.btn:hover {
		animation: btnAnimate 1s infinite;
	}

	.editBtn {
		width: 40%;
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
		margin-top: 90px;
	}

	.editBtn:hover {
		animation: btnAnimate 1s infinite;
	}

	.resetBtn {
		width: 40%;
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
		margin-top: 90px;
	}

	.resetBtn:hover {
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
		outline: none;
		border: 0;

	}

	.close:hover {
		cursor: pointer;
	}

	.msgleft {
		float: left;
	}

	.msgright {
		float: right;
	}

	.chatbox {
		margin: 0;
		height: 100%;
		width: 100%;
		box-shadow: 0 0 0 1px gray;
		display: flex;
	}

	.chatleft {
		background-color: #ffffff;
		width: 25%;
		left: 0;
		height: 100%;
	}

	.chatleft .top {
		height: 10%;
		color: grey;
		background-color: #F7F9F9;
		display: flex;
		align-items: center;
		padding-left: 20px;
	}

	.chatleft .center {
		overflow-y: scroll;
		height: 100%;
	}

	.chatleft .center ul {
		padding-left: 10px;
	}

	.chatleft .center li {
		margin: 10px;
	}

	.chatright {
		background-color: #ffffff;
		width: 70%;
		height: 100%;
	}

	.chatright .top {
		height: 10%;
		display: flex;
		align-items: center;
		padding-left: 30px;
	}

	.chatright .center {
		background-color: #edf5f8;
		height: 60%;
		overflow-y: scroll;
	}

	.chatright .center ul {
		padding: 10px;
	}

	.chatright .center li {
		margin: 10px;
		width: 100%;
	}

	.chatright .center p {
		display: inline-block;
	}

	.msgcard {
		margin: 0 10px 0 10px;
		background-color: white;
		border-radius: 10px;
		padding: 10px;
		max-width: 40%;
	}

	.chatright .footer {
		height: 30%;
		background-color: #FBFCFC;
		text-align: right;
	}

	.sendbtn {
		height: 40px;
		width: 80px;
		border-radius: 10px;
		background-color: #0061a8;
		color: white;
		font-weight: bold;
		margin: 10px 20px 0 0;
	}

	.choose {
		width: 65px;
		height: 20px;
		margin-left: 20px;
	}
</style>