<template>
  <div class="body" >

  <div class="left">
    <img class="user" src="../assets/user.png" alt="">
    <h1>Username</h1>
    <h2>transferred:415</h2>
    <h2>collection:215</h2>
    <h2>message:60</h2>
  </div>
    <div>
      <div class="mask" v-if="showModal" @click="showModal=false"></div>
      <div class="pop" v-if="showModal">
        <div class="bottom">
          <div class="text">Upload product</div>
          <ul>
            <li>
              <label>Title: </label>
              <input v-model="productForm.name" type="text" >
            </li>
            <li>
              <label> Price: </label>
              <input v-model="productForm.price" type="number" step="100">
            </li>
            <li>
              <label>Usage time:</label>
              <input v-model="productForm.lifeTime" type="text">
            </li>
            <li>
              <label>Category：</label>
              <select class="choose" v-model="productForm.tag" >
                <option>Clothes</option>
                <option>Cosmetics</option>
                <option>Electronic</option>
                <option>Books</option>
                <option>Food</option>
                <option>virtual product</option>
              </select>
            </li>
            <li>
              <label>Description: </label>
              <textarea v-model="productForm.description" wrap="soft" autocomplete="off" spellcheck="false"  rows="5" class="ivu-input"
                        style="width: 450px; min-height: 52px; max-height: 50px; font-size: 15px; border-color: #5162f4; border-radius: 5px">
                </textarea>
            </li>
            <li>
              <el-upload style="float: left"
                         name="images"
                         :drag="true"
                         ref="upload_attach"
                         class="upload-demo"
                         action=""
                         multiple
                         accept=".jpg,.png,.jpeg"
                         :limit="3"
                         :file-list="this.images"
                         :auto-upload="false"
                         :on-change="onUploadChange"
              >
                <i class="el-icon-upload"></i>
                <div class="el-upload__text">Drag or  <em>click</em></div>


                <div class="el-upload__tip" slot="tip"> 3 jpg/png only，no more than 500kb</div>
              </el-upload>


            </li>
          </ul>
          <el-button class="submit" type="primary" @click="submit">Issue</el-button>

          <el-button @click="showModal=false" class="cancelBtn">Cancel</el-button>

        </div>
      </div>
      <button @click="showModal=true" class="btn" >
       <img src="../assets/issue/add.png" style="height:80px;width:80px">
        <h7>Upload Product</h7>
      </button>
    </div>


    <div>
    <form action="#" method="POST">
      <div class="serchbar">

        <div class="first">x</div>
        <div class="middle">
          <label>
            <input type="text">
          </label>
        </div>

        <div class="first">
          <button type="submit"></button>
        </div>

      </div>
    </form>
  </div>




    <div id="box">
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
  </div>





  <div class="item">
    <ul>
      <li>
        <div class="single-member effect">

          <div class="member-image">
            <img src="../assets/issue/member_270x210.jpg" alt="Member">
          </div>

            <div class="member-info">
              <h3>Sophia</h3>
              <h5>ShowGilr</h5>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                labore et
                dolore magna aliqua.</p>
            </div>


            <div class="social-touch">
              <a class="fb-touch" href="#"></a>
              <a class="tweet-touch" href="#"></a>
              <a class="linkedin-touch" href="#"></a>
            </div>
        </div>

      </li>
      <li>
        <div class="single-member effect">
          <div class="member-image">
            <img src="../assets/issue/member_270x210.jpg" alt="Member">
          </div>
          <div class="member-info">
            <h3>Sophia</h3>
            <h5>ShowGilr</h5>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
              labore et
              dolore magna aliqua.</p>
          </div>
          <div class="social-touch">
            <a class="fb-touch" href="#"></a>
            <a class="tweet-touch" href="#"></a>
            <a class="linkedin-touch" href="#"></a>
          </div>
        </div>

      </li>
      <li>
        <div class="single-member effect">
          <div class="member-image">
            <img src="../assets/issue/member_270x210.jpg" alt="Member">
          </div>
          <div class="member-info">
            <h3>Sophia</h3>
            <h5>ShowGilr</h5>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
              labore et
              dolore magna aliqua.</p>
          </div>
          <div class="social-touch">
            <a class="fb-touch" href="#"></a>
            <a class="tweet-touch" href="#"></a>
            <a class="linkedin-touch" href="#"></a>
          </div>
        </div>
      </li>
      <li>
        <div class="single-member effect">
          <div class="member-image">
            <img src="../assets/issue/member_270x210.jpg" alt="Member">
          </div>
          <div class="member-info">
            <h3>Sophia</h3>
            <h5>ShowGilr</h5>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
              labore et
              dolore magna aliqua.</p>
          </div>

          <div class="social-touch">
            <a class="fb-touch" href="#"></a>
            <a class="tweet-touch" href="#"></a>
            <a class="linkedin-touch" href="#"></a>
          </div>
        </div>

      </li>
      <li>
        <div class="single-member effect">
          <div class="member-image">
            <img src="../assets/issue/member_270x210.jpg" alt="Member">
          </div>
          <div class="member-info">
            <h3>Sophia</h3>
            <h5>ShowGilr</h5>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
              labore et
              dolore magna aliqua.</p>
          </div>
          <div class="social-touch">
            <a class="fb-touch" href="#"></a>
            <a class="tweet-touch" href="#"></a>
            <a class="linkedin-touch" href="#"></a>
          </div>
        </div>

      </li>
      <li>
        <div class="single-member effect">
          <div class="member-image">
            <img src="../assets/issue/member_270x210.jpg" alt="Member">
          </div>
          <div class="member-info">
            <h3>Sophia</h3>
            <h5>ShowGilr</h5>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
              labore et
              dolore magna aliqua.</p>
          </div>
          <div class="social-touch">
            <a class="fb-touch" href="#"></a>
            <a class="tweet-touch" href="#"></a>
            <a class="linkedin-touch" href="#"></a>
          </div>
        </div>

      </li>
      <li>
        <div class="single-member effect">
          <div class="member-image">
            <img src="../assets/issue/member_270x210.jpg" alt="Member">
          </div>
          <div class="member-info">
            <h3>Sophia</h3>
            <h5>ShowGilr</h5>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
              labore et
              dolore magna aliqua.</p>
          </div>

          <div class="social-touch">
            <a class="fb-touch" href="#"></a>
            <a class="tweet-touch" href="#"></a>
            <a class="linkedin-touch" href="#"></a>
          </div>
        </div>

      </li>
      <li>
        <div class="single-member effect">
          <div class="member-image">
            <img src="../assets/issue/member_270x210.jpg" alt="Member">
          </div>
          <div class="member-info">
            <h3>Sophia</h3>
            <h5>ShowGilr</h5>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
              labore et
              dolore magna aliqua.</p>
          </div>
          <div class="social-touch">
            <a class="fb-touch" href="#"></a>
            <a class="tweet-touch" href="#"></a>
            <a class="linkedin-touch" href="#"></a>
          </div>
        </div>

      </li>
    </ul>

  </div>

  <div class="page">
    <ul>
      <li>
        <a href="#">
          <h1> &lt;last page</h1>
        </a>
      </li>
      <li>
        <a href="#">
          <h1>1</h1>
        </a>
      </li>
      <li>
        <a href="#">
          <h1>2</h1>
        </a>
      </li>
      <li>
        <a href="#">
          <h1>3</h1>

        </a>
      </li>
      <li>
        <a href="#">
          <h1>4</h1>
        </a>
      </li>

      <li>
        <a href="#">
          <h1>5</h1>
        </a>
      </li>

      <li>
        <a href="#">
          <h1>6</h1>
        </a>
      </li>

      <li>
        <a href="#">
          <h1>7</h1>
        </a>
      </li>

      <li>
        <a href="#">
          <h1>...</h1>
        </a>
      </li>

      <li>
        <a href="#">
          <h1>Next page&gt;</h1>
        </a>
      </li>

    </ul>

  </div>


  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "issue",
  data(){
    return{
      showModal: false,
      images: [],
      temp:0,
      productForm:{
        date: "",
        description: "string",
        image1: "",
        image2: "",
        image3: "",
        lifeTime: "string",
        name: "string",
        pid: 0,
        price: 0,
        state: true,
        tag: "string",
        uid: 0
      },
      file: "",
    }
  },
  methods: {

    submit: function() {

      this.showModal = false;
      axios({
        url: 'http://localhost:9000/products/upload',
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
          "uid": 0
        },
        method: 'put',
      }).then((res) => {
        console.log(res.data);
        alert("Finished");
        this.temp = res.data;
        let data = new FormData();
        for (let i = 0; i < 3; i++) {

          data.append("images",this.images[i].raw);
        }
        console.log(this.images);
        axios({
          url: `http://localhost:9000/products/uploadImage${this.temp}`,

          data: data,
          method: 'post',
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        }).then((res) => {
          console.log(res.data);
          alert(res.data);
          this.images = [];
        })
      })

    },
    onUploadChange(file){
      this.images.push(file)
    }

  },

}
</script>

<style scoped>

.body {
  background-image: url("../assets/issue/background.png");
  background-repeat: no-repeat;
  background-size: cover;
 position:absolute;
  height: 100%;
}

li {
  list-style: none;
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
  margin-left: 450px;
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
.page {
  float: left;
  height: 100px;
  width: 1430px;

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

h7{
  font-size: 20px;
  color: black;
  text-align: center;
  float:left;
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

.bottom ul li{
  margin-bottom: 20px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  font-size: 20px;
  font-weight: bolder;
  margin-left: 20px;
  margin-top: 20px;

}

.bottom ul li input {
  margin-top: 20px;
  padding: 10px;
  /* placeholder变更为大写字体 */
  /* 边框效果 */
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

.mask {
  background-color: #111;
  z-index: 1;

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
  border:white;
  margin-right:70px;
  margin-top: 120px;

}

.cancelBtn{
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