<template>
  <div class="body">
    <div class="personalInfo clearfix">
      <div class="user2"><a @click="home()" href="javascript:void(0);"><img src="../assets/user.png" alt=""></a></div>
      <div style="width: 200px;text-align: end;" class="user2"><a @click="home()" href="javascript:void(0);"
          style="color: #111111;font-size: 25px;">{{this.$route.params.username}}</a></div>

    </div>

    <!--  -->
    <!--  -->
    <!--  -->
    <!--  -->
    <div>


      <div>
        <div class="mask" v-if="showModal" @click="showModal=false"></div>
        <div class="pop" v-if="showModal">
          <div class="bottom">
            <div class="text">Upload product</div>
            <ul>
              <li>
                <label>Product name: </label>
                <input v-model="productForm.name" type="text" placeholder="Product name">
              </li>
              <li>
                <label> Price: </label>
                <input v-model="productForm.price" type="number" placeholder="0" step="100">
              </li>
              <li>
                <label>Usage time:</label>
                <input v-model="productForm.lifeTime" type="text" placeholder="How long you used">
              </li>
              <li>
                <label>Category:</label>
                <select class="choose" v-model="productForm.tag">
                  <option value="" disabled selected hidden>Type</option>
                  <option>Clothes</option>
                  <option>Fitness Equipment</option>
                  <option>Device</option>
                  <option>Supplies</option>
                </select>
              </li>
              <li style="position: relative;">
                <span style="position: absolute;top:10px">Description: </span>
                <textarea placeholder="Describe your product" v-model="productForm.description" wrap="soft"
                  autocomplete="off" spellcheck="false" rows="5" class="ivu-input"
                  style="width: 450px; min-height: 52px; max-height: 50px; font-size: 15px; border-color: #5162f4; border-radius: 5px;margin-left: 130px;">
					  </textarea>
              </li>
              <li>
                <el-upload class="upload-demo" :on-change="onUploadChange" :limit="3" :file-list="this.images"
                  :auto-upload="false" list-type="picture" action="">
                  <el-button size="small" type="primary">Upload</el-button>
                  <div slot="tip" class="el-upload__tip"> 3 jpg/png only，no more than 500kb</div>
                </el-upload>


              </li>
            </ul>
            <el-button class="submit" type="primary" @click="submit">Issue</el-button>

            <el-button @click="showModal=false" class="cancelBtn">Cancel</el-button>

          </div>
        </div>

      </div>

      <div
        style="width: 80px;height: 80px;border-radius: 40px;background-color: white;margin-left: 1400px;margin-bottom: 100px;"
        @click="showModal=true" class="btn">
        <img src="../assets/issue/add.png" style="height:80px;width:80px">
        <p style="color: white;font-size: 20px!important;padding-left: 15px" class="h7">Issue</p>
      </div>

      <div class="serchbar">
        <div class="first">x</div>
        <div class="middle">
          <label>
            <input type="text" v-model="key" value="" onkeypress="BindEnter();">
          </label>
        </div>
        <div class="first">
          <button @click="search()" @keyup.enter="search()"></button>
        </div>
      </div>

    </div>
    <div class="board">
      <el-carousel :interval="4000" type="card" height="600px">
        <el-carousel-item style="width: 50%">
          <img src="../assets/browseProduct/1.jpg" class="image">
        </el-carousel-item>
        <el-carousel-item style="width: 50%">
          <img src="../assets/browseProduct/2.jpg" class="image">
        </el-carousel-item>
        <el-carousel-item style="width: 50%">
          <img src="../assets/browseProduct/3.jpg" class="image">
        </el-carousel-item>

      </el-carousel>
    </div>
    <div>
      <h2>Products Center</h2>
    </div>
    <el-row :gutter="20" style="margin-left: 400px">
      <el-col :span="4">
        <div class="grid-content bg-purple"><a href="#Cloth">Clothes</a></div>
      </el-col>
      <el-col :span="4">
        <div class="grid-content bg-purple"><a href="#Fitness Equipment">Fitness Equipment</a></div>
      </el-col>
      <el-col :span="4">
        <div class="grid-content bg-purple"><a href="#Device">Device</a></div>
      </el-col>
      <el-col :span="4">
        <div class="grid-content bg-purple"><a href="#Supplie">Supplies</a></div>
      </el-col>
    </el-row>
    <div id="Cloth" class="mainBox">
      <div class="market">
        <ul class="leftBox clearfix">
          <li class="biggest1">
            <button @click=jump1()>VIEW MORE</button>
          </li>
          <li><a @click="detail(0,0)" href="javascript:void(0);"><img ref="img00" :src="images.tag1Image.img1" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(0,1)" href="javascript:void(0);"><img ref="img01" :src="images.tag1Image.img2" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(0,2)" href="javascript:void(0);"><img ref="img02" :src="images.tag1Image.img3" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(0,3)" href="javascript:void(0);"><img ref="img03" :src="images.tag1Image.img4" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(0,4)" href="javascript:void(0);"><img ref="img04" :src="images.tag1Image.img5" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(0,5)" href="javascript:void(0);"><img ref="img05" :src="images.tag1Image.img6" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(0,6)" href="javascript:void(0);"><img ref="img06" :src="images.tag1Image.img7" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(0,7)" href="javascript:void(0);"><img ref="img07" :src="images.tag1Image.img8" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
        </ul>
      </div>
    </div>

    <div id="Fitness Equipment" class="mainBox">
      <div class="market">
        <ul class="leftBox clearfix">
          <li class="biggest2">
            <button @click=jump2()><a style="color: #1ead0d;" href="#">VIEW MORE</a></button>
          </li>
          <li><a @click="detail(1,0)" href="javascript:void(0);"><img ref="img10" :src="images.tag2Image.img1" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(1,1)" href="javascript:void(0);"><img ref="img11" :src="images.tag2Image.img2" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(1,2)" href="javascript:void(0);"><img ref="img12" :src="images.tag2Image.img3" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(1,3)" href="javascript:void(0);"><img ref="img13" :src="images.tag2Image.img4" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(1,4)" href="javascript:void(0);"><img ref="img14" :src="images.tag2Image.img5" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(1,5)" href="javascript:void(0);"><img ref="img15" :src="images.tag2Image.img6" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(1,6)" href="javascript:void(0);"><img ref="img16" :src="images.tag2Image.img7" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(1,7)" href="javascript:void(0);"><img ref="img17" :src="images.tag2Image.img8" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
        </ul>
      </div>
    </div>

    <div id="Device" class="mainBox">
      <div class="market">
        <ul class="leftBox clearfix">
          <li class="biggest3">
            <button @click=jump3()><a style="color: #2e4abd;" href="#">VIEW MORE</a></button>
          </li>
          <li><a @click="detail(2,0)" href="javascript:void(0);"><img ref="img20" :src="images.tag3Image.img1" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(2,1)" href="javascript:void(0);"><img ref="img21" :src="images.tag3Image.img2" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(2,2)" href="javascript:void(0);"><img ref="img22" :src="images.tag3Image.img3" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(2,3)" href="javascript:void(0);"><img ref="img23" :src="images.tag3Image.img4" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(2,4)" href="javascript:void(0);"><img ref="img24" :src="images.tag3Image.img5" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(2,5)" href="javascript:void(0);"><img ref="img25" :src="images.tag3Image.img6" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(2,6)" href="javascript:void(0);"><img ref="img26" :src="images.tag3Image.img7" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(2,7)" href="javascript:void(0);"><img ref="img27" :src="images.tag3Image.img8" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
        </ul>
      </div>
    </div>

    <div id="Supplie" class="mainBox">
      <div class="market">
        <ul class="leftBox clearfix">
          <li class="biggest4">
            <button @click=jump4()><a style="color: #d41b0c;" href="#">VIEW MORE</a></button>
          </li>
          <li><a @click="detail(3,0)" href="javascript:void(0);"><img ref="img30" :src="images.tag4Image.img1" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(3,1)" href="javascript:void(0);"><img ref="img31" :src="images.tag4Image.img2" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(3,2)" href="javascript:void(0);"><img ref="img32" :src="images.tag4Image.img3" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(3,3)" href="javascript:void(0);"><img ref="img33" :src="images.tag4Image.img4" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(3,4)" href="javascript:void(0);"><img ref="img34" :src="images.tag4Image.img5" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(3,5)" href="javascript:void(0);"><img ref="img35" :src="images.tag4Image.img6" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(3,6)" href="javascript:void(0);"><img ref="img36" :src="images.tag4Image.img7" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>
          <li><a @click="detail(3,7)" href="javascript:void(0);"><img ref="img37" :src="images.tag4Image.img8" alt=""
                height="300px" width="250px" :onError="defaultImg" /></a></li>

        </ul>
      </div>
    </div>
  </div>

</template>

<script>
  import axios from "axios";

  export default {
    name: 'browseProduct',

    data() {
      return {
        defaultImg: 'this.src="' + require("../assets/fill.png") + '"',
        defaultImage2: 'this.src="' + require("../assets/emptyFill.png") + '"',

        showModal: false,
        arrBanner: [
          "../assets/1.jpg",
          "../assets/2.jpg",
          "../assets/3.jpg",
        ],
        images1: [],
        productForm: {
          date: "",
          description: "",
          image1: "",
          image2: "",
          image3: "",
          lifeTime: "",
          name: "",
          pid: 0,
          price: '',
          state: true,
          tag: "",
          uid: 0
        },
        file: "",
        displayImage: '',
        key: '',
        productName: [[], [], [], []],
        images: {
          tag1Image: {
            img1: '',
            img2: '',
            img3: '',
            img4: '',
            img5: '',
            img6: '',
            img7: '',
            img8: '',
          },
          tag2Image: {
            img1: '',
            img2: '',
            img3: '',
            img4: '',
            img5: '',
            img6: '',
            img7: '',
            img8: '',
          },
          tag3Image: {
            img1: '',
            img2: '',
            img3: '',
            img4: '',
            img5: '',
            img6: '',
            img7: '',
            img8: '',
          },
          tag4Image: {
            img1: '',
            img2: '',
            img3: '',
            img4: '',
            img5: '',
            img6: '',
            img7: '',
            img8: '',
          },
        },


      }
    },
    mounted() {
      var temp = '';

      axios
        .get("http://127.0.0.1:9000/products/")
        .then(response => {
          console.log(response);
          try {
            this.images.tag1Image.img1 = 'data:image/png;base64,' + response.data[0][0].image1
            this.productName[0][0] = response.data[0][0].name
            this.images.tag1Image.img2 = 'data:image/png;base64,' + response.data[0][1].image1
            this.productName[0][1] = response.data[0][1].name
            this.images.tag1Image.img3 = 'data:image/png;base64,' + response.data[0][2].image1
            this.productName[0][2] = response.data[0][2].name
            this.images.tag1Image.img4 = 'data:image/png;base64,' + response.data[0][3].image1
            this.productName[0][3] = response.data[0][3].name
            this.images.tag1Image.img5 = 'data:image/png;base64,' + response.data[0][4].image1
            this.productName[0][4] = response.data[0][4].name
            this.images.tag1Image.img6 = 'data:image/png;base64,' + response.data[0][5].image1
            this.productName[0][5] = response.data[0][5].name
            this.images.tag1Image.img7 = 'data:image/png;base64,' + response.data[0][6].image1
            this.productName[0][6] = response.data[0][6].name
            this.images.tag1Image.img8 = 'data:image/png;base64,' + response.data[0][7].image1
            this.productName[0][7] = response.data[0][7].name
          } catch (Exception) {
          }
          try {
            this.images.tag2Image.img1 = 'data:image/png;base64,' + response.data[1][0].image1
            this.productName[1][0] = response.data[1][0].name
            this.images.tag2Image.img2 = 'data:image/png;base64,' + response.data[1][1].image1
            this.productName[1][1] = response.data[1][1].name
            this.images.tag2Image.img3 = 'data:image/png;base64,' + response.data[1][2].image1
            this.productName[1][2] = response.data[1][2].name
            this.images.tag2Image.img4 = 'data:image/png;base64,' + response.data[1][3].image1
            this.productName[1][3] = response.data[1][3].name
            this.images.tag2Image.img5 = 'data:image/png;base64,' + response.data[1][4].image1
            this.productName[1][4] = response.data[1][4].name
            this.images.tag2Image.img6 = 'data:image/png;base64,' + response.data[1][5].image1
            this.productName[1][5] = response.data[1][5].name
            this.images.tag2Image.img7 = 'data:image/png;base64,' + response.data[1][6].image1
            this.productName[1][6] = response.data[1][6].name
            this.images.tag2Image.img8 = 'data:image/png;base64,' + response.data[1][7].image1
            this.productName[1][7] = response.data[1][7].name
          } catch (Exception) {
          }
          try {
            this.images.tag3Image.img1 = 'data:image/png;base64,' + response.data[2][0].image1
            this.productName[2][0] = response.data[2][0].name
            this.images.tag3Image.img2 = 'data:image/png;base64,' + response.data[2][1].image1
            this.productName[2][1] = response.data[2][1].name
            this.images.tag3Image.img3 = 'data:image/png;base64,' + response.data[2][2].image1
            this.productName[2][2] = response.data[2][2].name
            this.images.tag3Image.img4 = 'data:image/png;base64,' + response.data[2][3].image1
            this.productName[2][3] = response.data[2][3].name
            this.images.tag3Image.img5 = 'data:image/png;base64,' + response.data[2][4].image1
            this.productName[2][4] = response.data[2][4].name
            this.images.tag3Image.img6 = 'data:image/png;base64,' + response.data[2][5].image1
            this.productName[2][5] = response.data[2][5].name
            this.images.tag3Image.img7 = 'data:image/png;base64,' + response.data[2][6].image1
            this.productName[2][6] = response.data[2][6].name
            this.images.tag3Image.img8 = 'data:image/png;base64,' + response.data[2][7].image1
            this.productName[2][7] = response.data[2][7].name
          } catch (Exception) {
          }
          try {
            this.images.tag4Image.img1 = 'data:image/png;base64,' + response.data[3][0].image1
            this.productName[3][0] = response.data[3][0].name
            this.images.tag4Image.img2 = 'data:image/png;base64,' + response.data[3][1].image1
            this.productName[3][1] = response.data[3][1].name
            this.images.tag4Image.img3 = 'data:image/png;base64,' + response.data[3][2].image1
            this.productName[3][2] = response.data[3][2].name
            this.images.tag4Image.img4 = 'data:image/png;base64,' + response.data[3][3].image1
            this.productName[3][3] = response.data[3][3].name
            this.images.tag4Image.img5 = 'data:image/png;base64,' + response.data[3][4].image1
            this.productName[3][4] = response.data[3][4].name
            this.images.tag4Image.img6 = 'data:image/png;base64,' + response.data[3][5].image1
            this.productName[3][5] = response.data[3][5].name
            this.images.tag4Image.img7 = 'data:image/png;base64,' + response.data[3][6].image1
            this.productName[3][6] = response.data[3][6].name
            this.images.tag4Image.img8 = 'data:image/png;base64,' + response.data[3][7].image1
            this.productName[3][7] = response.data[3][7].name
          } catch (Exception) {
          }
        })
    },

    methods: {

      onUploadChange(file) {
        this.images1.push(file)
      },
      submit: function () {
        if (this.productForm.name == '') {
          this.$message.error("Empty Name");
          return;
        }
        if (this.productForm.price == '') {
          this.$message.error("Empty Price");
          return;
        } else if (this.productForm.price == 0) {
          this.$message.error("Enter a price");
          return;
        }
        if (this.productForm.tag == '') {
          this.$message.error("choose a category");
          return;
        }
        if (this.productForm.description == '') {
          this.$message.error("Empty Description");
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
            this.$message.success("Sucess");
            this.showModal = false;
          } else {
            this.$message.error("Product name have been used");
          }
          console.log(res.data);
          this.temp = res.data;
          let data = new FormData();
          for (let i = 0; i < 3; i++) {

            data.append("images", this.images1[i].raw);
          }
          console.log(this.images1);
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
              console.log("err")
            } else {
              this.showModal = false;
              console.log(res.data);
              this.$message.success("Sucess");
              this.images1 = [];
            }

          })
        })

      },
      jump1: function () {
        this.$router.push({ name: 'productList', params: { username: this.$route.params.username, category: 'Clothes' } });
      },
      jump2: function () {
        this.$router.push({ name: 'productList', params: { username: this.$route.params.username, category: 'Fitness Equipment' } });
      },
      jump3: function () {
        this.$router.push({ name: 'productList', params: { username: this.$route.params.username, category: 'Device' } });
      },
      jump4: function () {
        this.$router.push({ name: 'productList', params: { username: this.$route.params.username, category: 'Supplies' } });
      },
      search: function () {
        if (this.key != "") {
          this.$router.push({ name: 'issue2', params: { username: this.$route.params.username, key: this.key } });
        } else {
          this.$router.push({ name: 'issue', params: { username: this.$route.params.username } });
        }

      },
      home: function () {
        this.$router.push({ name: 'PersonalPage', params: { username: this.$route.params.username } });
      },
      detail: function (index1, index2) {
        console.log(this.productName);
        if (index2 >= this.productName[index1].length) {
          this.$message.error("There is no product here");
          return;
        }
        console.log(this.productName);
        this.$router.push({ name: 'item', params: { username: this.$route.params.username, name: this.productName[index1][index2] } });
      },
      // defaultImg(index1, index2) {
      //   var imageList = [[this.$refs.img00, this.$refs.img01, this.$refs.img02, this.$refs.img03, this.$refs.img04, this.$refs.img05, this.$refs.img06, this.$refs.img07],
      //   [this.$refs.img10, this.$refs.img11, this.$refs.img12, this.$refs.img13, this.$refs.img14, this.$refs.img15, this.$refs.img16, this.$refs.img17],
      //   [this.$refs.img20, this.$refs.img21, this.$refs.img22, this.$refs.img23, this.$refs.img24, this.$refs.img25, this.$refs.img26, this.$refs.img27],
      //   [this.$refs.img30, this.$refs.img31, this.$refs.img32, this.$refs.img33, this.$refs.img34, this.$refs.img35, this.$refs.img36, this.$refs.img37]
      //   ];
      //   console.log(this.productName[index1]);
      //   console.log(imageList[0][1]);
      //   if (index2 >= this.productName[index1].length) {
      //     imageList[index1][index2].src = this.defaultImage2;
      //   }
      //   else {
      //     imageList[index1][index2].src = this.defaultImage;
      //   }
      // }

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

  .body {
    font: 14px/1.5 Helvetica Neue, Helvetica, Arial, Microsoft Yahei, Hiragino Sans GB, Heiti SC, WenQuanYi Micro Hei, sans-serif;
    color: #333;

    background-color: rgb(247, 247, 247);
    background: url(../assets/browseProduct/indexbackground.png);
    background-repeat: no-repeat;
    background-size: cover;

    min-width: 1226px;
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
    color: #111111;
  }

  .personalInfo .user,
  .personalInfo .user img {
    height: 51px;
    width: 66px;
    line-height: 50px;
    margin-right: 1px;
    margin-left: 10px;
    margin-top: 2px
  }

  .personalInfo .user2,
  .personalInfo .user2 img {
    height: 51px;
    width: 66px;
    line-height: 50px;
    margin-right: 10px;
    margin-top: 2px
  }

  h1 {
    text-align: center;
    margin-bottom: 40px;
    font-size: 60px;
    color: #111111;
  }

  .describe {
    text-align: center;
    margin-bottom: 30px;
  }

  .mask {

    background-color: #111;
    z-index: 999
  }



  .pop {
    /*border-width: 5px;*/
    position: fixed;
    top: 11px;
    left: 400px;
    width: 750px;
    height: 670px;
    z-index: 999;
    border-radius: 10px;
    border: #5162f4;
    border-style: solid;
    box-shadow: 10px 10px 10px #5162f4;
    background: white;


  }

  .bottom {
    float: left;
    width: 730px;
    height: 580px;
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
    margin-top: -13px;

  }

  /* 发布框 */
  .text {
    /* 标题Login的样式 */
    font-size: 30px;
    font-weight: bold;
    text-align: center;
    line-height: 50px;
    margin-top: -13px;
    color: #5162f4;
  }

  .choose {
    width: 65px;
    height: 20px;
    margin-left: 20px;
  }

  .bottom .submit {
    width: 100px;
    height: 30px;
    float: right;
    background: rgb(68, 113, 210);
    color: white;
    margin-right: 390px;
    margin-top: -5px;
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
    margin-top: -5px;
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

  .serchbar {
    height: 60px;
    width: 700px;
    background-color: rgb(20, 65, 39);
    margin: 50px auto;
    border-radius: 30px;
    border-style: solid;
    overflow: hidden;
    margin-top: 200px;
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
    background: url(../assets/browseProduct/search.png);

  }

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

  .board {

    width: 100%;
    height: 500px;
    margin: 0px auto;
    margin-top: 400px;
  }

  .image {
    object-fit: fill;
    height: 450px;
    width: 100%;
  }

  .el-carousel__container {
    position: relative;
    height: 510px;
  }

  h2 {
    margin-top: 100px;
    text-align: center;
    margin-bottom: 40px;
    font-size: 60px;
    color: rgba(78, 97, 243, 1);
  }


  .mainBox {
    margin-top: 100px;
  }

  .market {
    margin: 0 auto;
    width: 1450px;
    height: 620px;
    background-color: rgba(201, 218, 233, 0.74);
  }

  .leftBox .biggest1 {
    margin: 5px;
    float: left;
    width: 400px;
    height: 610px;
    background: url("../assets/browseProduct/clothes.jpg");
    background-repeat: no-repeat;
    background-size: 100% 100%;
  }

  .leftBox .biggest2 {
    margin: 5px;
    float: left;
    width: 400px;
    height: 610px;
    background: url("../assets/browseProduct/fitness.jpg");
    background-repeat: no-repeat;
    background-size: 100% 100%;


  }

  .leftBox .biggest3 {
    margin: 5px;
    float: left;
    width: 400px;
    height: 610px;
    background: url("../assets/browseProduct/devices.jpg");
    background-repeat: no-repeat;
    background-size: 100% 100%;
  }

  .leftBox .biggest4 {
    margin: 5px;
    float: left;
    width: 400px;
    height: 610px;
    background: url("../assets/browseProduct/suplies.jpg");
    background-repeat: no-repeat;
    background-size: 100% 100%;

  }


  .leftBox li {
    margin: 5px;
    float: left;
    width: 250px;
    height: 300px;
    background-color: white;
  }

  .leftBox .biggest1 button {
    width: 160px;
    height: 60px;
    margin-top: 500px;
    margin-left: 120px;
    border-style: solid;
    border-color: #a715c1;
    background-color: #e3b9eb;
    font-size: 18px;
    color: #a715c1;
  }

  .leftBox .biggest2 button {
    width: 160px;
    height: 60px;
    margin-top: 500px;
    margin-left: 120px;
    border-style: solid;
    border-color: #1ead0d;
    background-color: #bbe6b7;
    font-size: 18px;
    color: #1ead0d;
  }

  .leftBox .biggest3 button {
    width: 160px;
    height: 60px;
    margin-top: 500px;
    margin-left: 120px;
    border-style: solid;
    border-color: #2e4abd;
    background-color: #7c94da;
    font-size: 18px;
    color: #2e4abd;
  }

  .leftBox .biggest4 button {
    width: 160px;
    height: 60px;
    margin-top: 500px;
    margin-left: 120px;
    border-style: solid;
    border-color: #d41b0c;
    background-color: #f2b9b6;
    font-size: 18px;
    color: #d41b0c;
  }

  .leftBox .biggest1 button a {
    color: white;
  }

  .el-row {
    margin-bottom: 20px;
  }

  .el-col {
    border-radius: 4px;
  }

  .bg-purple-dark {
    background: #99a9bf;
  }

  .bg-purple {
    background: #d3dce6;
  }

  .bg-purple-light {
    background: #e5e9f2;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
    line-height: 36px;
    text-align: center;
    font-family: Andale Mono;
    color: #111111;

  }

  .grid-content a {
    color: #99a9bf;
    color: #2e4abd;

  }

  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>