<template>


  <div class="body">
    <div class="personalInfo clearfix">
      <div class="user"><a @click="home()" href="javascript:void(0);"><img src="../assets/back2.png" alt=""></a></div>
    </div>


    <div class="product-detail">
      <div class="container">

        <el-carousel :interval="4000" type="card" height="300px" class="lt-all">
          <el-carousel-item v-for="item in info.item">
            <img :src=" 'data:image/png;base64,' + item" class="image" style="height: 100%" :onError="defaultImage">
          </el-carousel-item>
        </el-carousel>



        <div class="pro-rt">
          <h2>&nbsp;{{this.info.name}}</h2>

          <div class="price-info">
            <span>Price:&nbsp&nbsp&nbsp{{this.info.price}}</span>
          </div>
          <div class="price-info">
            <span>Usage time:{{this.info.lifeTime}}</span>
          </div>
          <div class="price-info">
            <span style="width: 250px;">Category:&nbsp{{this.info.tag}}</span>
          </div>
          <div class="price-info">
            <span>Status:&nbsp{{this.info.status}}</span>
          </div>
          <div class="line"></div>
          <div class="address-box">
            <i class="iconfont icon-weizhi"></i>
            <div class="address-info">

              <div class="have">
                <span>
                  <p>{{this.info.description}}</p>
                </span>
              </div>
            </div>
          </div>


          <div class="btn-box">
            <a href="">
              <div class="sale-btn">
                Contact seller
              </div>
            </a>
          </div>

        </div>
      </div>
    </div>
    <!--  <div class="product-title">-->
    <!--    <div class="container">-->
    <!--      <h2>留言区</h2>-->

    <!--    </div>-->
    <!--  </div>-->

    <!--  <div class="mainbox">-->
    <!--    <span>你想对宝贝儿说点什么</span>-->
    <!--    <span class="tag">你最多可以输入100个字符</span>-->
    <!--    <textarea id="text" cols="100" rows="10" maxlength="30" class="text"></textarea><br>-->
    <!--    <input type="button" value="发 表" id="ipt">-->
    <!--    <div id="txt" >-->




    <!--    </div>-->
    <!--  </div>-->
  </div>
</template>

<script>


  import axios from "axios";

  export default {
    name: "item",
    data() {
      return {
        defaultImage: 'this.src="' + require("../assets/fill.png") + '"',
        // windowWidth: document.documentElement.clientWidth, 
        // windowHeight: document.documentElement.clientHeight,
        dec: '',
        price: '',
        index: 0,
        pid: this.$route.params.pid,
        info: {
          name: '',
          tag: '',
          lifeTime: '',
          price: '',
          description: '',
          item: [],
          status: '',

        },
        imagebox: [{ id: 0, idView: require('../assets/items/马.jpg') },
        { id: 1, idView: require('../assets/items/桥.jpg') },
        { id: 2, idView: require('../assets/items/xx.jpg') }

        ],

        // item: [
        //   "../assets/items/马.jpg",
        //   "../assets/items/桥.jpg",
        //   "../assets/items/布.jpg",
        // ],
        colorA: "#d6d6d6",
      }
    },
    // watch: {
    //   windowHeight (val) {
    //     let that = this;
    //     console.log("实时屏幕高度：",val, that.windowHeight );
    //   },
    //   windowWidth (val) {
    //     let that = this;
    //     console.log("实时屏幕宽度：",val, that.windowHeight );
    //   }
    // },
    // mounted () {
    //   const that = this
    //   window.onresize = () => {
    //     return (() => {
    //       window.fullHeight = document.documentElement.clientHeight;
    //       window.fullWidth = document.documentElement.clientWidth;
    //       that.windowHeight = window.fullHeight;  // 高
    //       that.windowWidth = window.fullWidth; // 宽
    //     })()
    //   }
    // },

    methods: {
      prev: function () {
        this.index--;
        this.colorA = "#a3a3a3";
      },
      next: function () {
        this.index++;
        this.colorA = "#a3a3a3";

      },
      home: function () {
        this.$router.push({ name: 'BrowseProduct', params: { username: this.$route.params.username } });
      },
    },
    mounted: function () {
      axios({
        url: 'http://localhost:9000/products/' + this.$route.params.username + '/' + this.$route.params.name,
        method: 'get',
      }).then((res) => {
        console.log(res.data)
        this.info.name = res.data.name;
        this.info.tag = res.data.tag;
        this.info.price = res.data.price;
        this.info.lifeTime = res.data.lifeTime;
        this.info.description = res.data.description;
        if (res.data.state == false) {
          this.info.status = "Selling";
        } else {
          this.info.status = "Sold";
        }

        this.info.item[0] = res.data.image1;
        this.info.item[1] = res.data.image2;
        this.info.item[2] = res.data.image3;

      });
    }
  }
</script>

<style scoped>
  .body {
    font-size: 12px;
    color: #333;

    background: url(../assets/items/background.png);
    background-repeat: no-repeat;
    background-size: cover;
    height: 120%;

  }

  .container {
    width: 1228px;
    margin-left: auto;
    margin-right: auto;


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
    margin-bottom: 0px;
  }

  .personalInfo div {
    height: 50px;
    float: right;
  }

  .personalInfo .user,
  .personalInfo .user img {
    height: 51px;
    width: 66px;
    background-color: rgba(78, 97, 243, 0);
    line-height: 50px;
    margin-right: 20px;
    margin-top: 12px;
  }


  .product-title {


    z-index: 4;
    background: #fff;
    border-top: 1px solid #e0e0e0;
    border-bottom: 1px solid #e0e0e0;
    box-shadow: 0 5px 5px rgba(0, 0, 0, .07);
    height: 63px;
    width: 100%;
    color: #616161;

  }

  .product-title .container h2 {

    margin: 0;
    font-size: 18px;
    font-weight: 400;
    line-height: 60px;
    color: #424242;
    float: left;
  }

  .product-title .container .right {
    float: right;
    margin: 17px 0 0 0;
    font-size: 14px;

  }

  .product-title .container .right a:hover {
    color: #5162f4;
  }

  .product-title .container .right span {
    color: #e0e0e0;
  }


  .product-detail {
    height: 575px;
  }


  .lt-all {
    float: left;
    width: 600px;
    height: 500px;
    margin-left: -100px;
    margin-top: 100px;
  }

  .pro-lt {
    position: relative;
    height: 600px;
    width: 560px;
    margin-top: 140px;

  }

  .pro-lt .banner-list {
    width: 580px;
    height: 566px;
    position: relative;
    left: -40px;
    transition: left 0s linear;
  }

  .pro-lt li {
    width: 560px;
    height: 566px;
    position: absolute;
    opacity: 0;
    transition: opacity 0.5s linear;
  }

  .pro-lt li.on {
    opacity: 1;
  }

  .pro-lt li img {
    width: 560px;
    height: 566px;
  }

  .pro-lt .btn {
    position: absolute;
    top: 50%;
    margin-top: -35px;
    width: 40px;
    height: 70px;
    cursor: pointer;
  }

  .pro-lt .btn.prev {
    left: -20px;
    background: url(../assets/items/left-arrow.png) center center no-repeat;
    background-size: 40px 40px;
  }

  .pro-lt .btn.next {


    right: 50px;
    background: url(../assets/items/right-arrow.png) center center no-repeat;
    background-size: 40px 40px;

  }

  .pro-lt .btn.prev:hover {
    background: url(../assets/items/deep-left-arrow.png) center center no-repeat;
    background-size: 40px 60px;
  }

  .pro-lt .btn.next:hover {
    background: url(../assets/items/deep-right-arrow.png) center center no-repeat;
    background-size: 40px 60px;
  }

  .pro-lt .page {
    position: absolute;
    bottom: 50px;
    left: -40px;
    width: 100%;
    height: 10px;
    text-align: center;

  }

  .pro-lt .page a {
    display: inline-block;
    margin: 0 5px;
    width: 50px;
    height: 3px;

    border-color: rgba(255, 255, 255, 0.3);

    background-color: #d6d6d6;

    cursor: pointer;
  }

  .pro-lt .page .on {
    background-color: #a3a3a3;
  }

  .pro-lt .page a:hover {
    background-color: #a3a3a3;

  }

  .pro-lt .page span {
    visibility: hidden;
  }


  .product-detail .container .pro-rt {
    padding-top: 80px;
    font-size: 14px;
    float: right;
    width: 598px;
    overflow: hidden;
  }

  .product-detail .container .pro-rt h2 {
    margin: 0;
    padding: 0;
    font-size: 24px;
    font-weight: 400;
    color: #212121;
  }

  .product-detail .pro-rt .pdesc {
    color: #b0b0b0;
    margin: 0;
    padding: 0;
    padding-top: 8px;
    line-height: 1.5;

  }



  .product-detail .pro-rt .price-info {
    display: block;
    font-size: 18px;
    line-height: 1;
    color: #5162f4;
    padding: 12px 0 10px;
    margin-top: 20px;
  }

  .product-detail .pro-rt .line {
    margin-top: 12px;
    border-bottom: 1px solid #e0e0e0;
  }

  .product-detail .pro-rt .address-box {
    margin: 20px 0;
    padding: 30px 50px;
    position: relative;
    background: #fafafa;
    border: 1px solid #e0e0e0;

  }

  .product-detail .pro-rt .address-box .address-info {
    margin-top: -5px;
  }

  .product-detail .pro-rt .address-box i {
    position: absolute;
    left: 20px;
    top: 26px;
    font-size: 20px;
    color: #999;
  }

  .product-detail .pro-rt .address-box .address-info .place span {
    margin-right: 14px;
  }

  .product-detail .pro-rt .address-box .address-info .place a {
    color: #5162f4;
  }

  .product-detail .pro-rt .address-box .address-info .have span {
    color: #b0b0b0;
  }

  .product-detail .pro-rt .color-box .choosecolor {
    font-size: 18px;
  }

  .product-detail .pro-rt .color-box .color {
    margin-top: 10px;
    border: 1px solid #5162f4;
    width: 50%;
    height: 43px;
    text-align: center;
    font-size: 15px;
    color: #5162f4;
    line-height: 43px;
  }

  .product-detail .pro-rt .pay-box {
    background: #f9f9fa;
    padding: 30px;
    margin-top: 28px;
    height: 80px;
  }

  .product-detail .pro-rt .pay-box h3 {
    font-weight: normal;
  }

  .product-detail .pro-rt .pay-box span {
    margin-left: 280px;
  }

  .product-detail .pro-rt .pay-box .total-money {
    color: #5162f4;
    font-size: 24px;
    padding-top: 25px;
  }

  .product-detail .pro-rt .btn-box {
    margin: 10px 0 20px 0;
    height: 50px;
  }

  .product-detail .pro-rt .btn-box .sale-btn {
    float: left;
    margin-left: 150px;
    margin-top: 35px;
    margin-right: 10px;
    width: 298px;
    height: 52px;
    line-height: 52px;
    font-size: 16px;
    background: #5162f4;
    border-color: #5162f4;
    color: #fff;
  }

  .product-detail .pro-rt .btn-box a {
    text-align: center;
  }

  .product-detail .pro-rt .btn-box .love-btn {
    background-color: #b0b0b0;
    float: right;
    width: 140px;
    height: 50px;
    line-height: 50px;
    padding: 0;
    font-size: 16px;
    margin-right: 147px;
    border: 1px solid #b0b0b0;
    text-align: center;
    cursor: pointer;
    font-size: 16px;
    position: relative;
    color: #fff;
  }

  .product-detail .pro-rt .btn-box .love-btn:hover {
    background-color: #757575;
  }

  .product-detail .tip-box span {
    display: inline-block;

    margin-right: 15px;
    line-height: 30px;
    margin-bottom: 10px;
    cursor: default;
    white-space: nowrap;
    color: #b0b0b0;
  }

  .product-detail .tip-box i {
    font-size: 20px;
    display: inline-block;
    font-style: normal;
    vertical-align: middle;
  }

  .product-detail .tip-box em {
    font-style: normal;
    display: inline-block;
    margin-left: 2px;
    vertical-align: middle;
  }



  .mainbox {
    width: 800px;
    margin: 20px auto;
  }

  span {
    display: inline-block;
    width: 200px;
    height: 25px;
    line-height: 25px;
    vertical-align: center;
    text-align: left;
    margin-bottom: 10px;
  }

  .tag {
    font-size: 13px;
    margin-left: 370px;
    vertical-align: bottom;
    text-align: center;
    margin-bottom: 0;
  }

  .text {
    width: 750px;
    height: 180px;
    margin: 0 auto;

    resize: none;
  }

  input {
    display: inline-block;
    width: 80px;
    height: 50px;
    background: #5162f4;
    border: 0;
    margin-left: 670px;
    margin-top: 10px;

  }

  .creatediv {
    width: 675px;
    height: 80px;
    border: 1px solid gray;
    position: relative;
    margin-top: 10px;
    padding-left: 75px;
  }

  .createinput {
    width: 80px;
    height: 30px;
    position: absolute;
    right: 5px;
    bottom: 5px;
  }

  .createimg {
    width: 50px;
    height: 50px;
    position: absolute;
    top: 15px;
    left: 15px;
  }

  .createdivs {
    width: 600px;
    height: 50px;
    position: absolute;
    top: 15px;
    left: 85px;
  }

  .block {
    margin-top: 0;
  }

  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  .image {
    object-fit: fill
  }
</style>