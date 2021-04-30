<template>
  <el-container>

    <el-header>
      <span>{{ this.$route.params.category }}</span>
      <span class="personalInfo clearfix" :style="{zIndex:999}">
        <div class="user"><a @click="home()" href="javascript:void(0);"><img src="../assets/user.png" alt=""></a></div>
        <div class="user"><a @click="back()" href="javascript:void(0);"><img src="../assets/back1.png" alt=""></a></div>
      </span>
    </el-header>

    <el-main>
      <el-row style="position: relative;">
        <el-tooltip effect="" placement="right"
          v-for="item in this.pageList.slice((currentPage-1)*pageSize,currentPage*pageSize)">

          <el-card style="width: 220px;margin-bottom: 15px;height: 330px;float: left;margin-left: 140px; "
            bodyStyle="padding:10px">
            <div class="member-image">
              <img style="width: 100%;height: 100%;" :src="'data:image/png;base64,' + item.image1" alt="Member" @click="goGoodsPage(item.name)"
                :onError="defaultImg">
            </div>
            <div class="member-info">
              <h3>{{ item.name }}</h3>
              <h5> Price: {{ item.price }}</h5>
              <h6 v-if="item.description.length > 20" slot="reference">Description:
                {{item.description.substring(0,20)}}......</h6>
              <h6 v-else slot="reference">Description: {{item.description}}</h6>
            </div>
            <div class="social-touch">
              <a class="fb-touch"></a>
              <a class="tweet-touch"></a>
              <a class="linkedin-touch"></a>
            </div>
          </el-card>
        </el-tooltip>

        <el-pagination class="pages" @size-change="handleSizeChange" @current-change="handleCurrentChange"
          :current-page="currentPage" :page-sizes="[4]" :page-size="this.pageSize"
          layout="total, sizes, prev, pager, next, jumper" :total="totalSize">
        </el-pagination>
      </el-row>
    </el-main>

  </el-container>
</template>

<script>
  import axios from "axios";

  export default {
    name: "productList",

    data() {
      return {
        defaultImg: 'this.src="' + require("../assets/fill.png") + '"',
        totalSize: 0,
        currentPage: 1,
        pageSize: 4,
        pageList: [],
      }
    },
    methods: {
      goGoodsPage(e) {
        this.$router.push({ name: 'item', params: { username: this.$route.params.username, name: e } });
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
        console.log(this.currentPage)
      },
      handleSizeChange: function (size) {
        this.pagesize = size;
        console.log(this.pagesize)
      },
      home: function () {
        this.$router.push({ name: 'PersonalPage', params: { username: this.$route.params.username } });
      },
      back() {
        this.$router.push({ name: 'BrowseProduct', params: { username: this.$route.params.username } });
      }
    },
    mounted: function () {

      axios({
        url: 'http://127.0.0.1:9000/products/' + this.$route.params.category,
        method: 'get',
      }).then((res) => {

        this.pageList = res.data;
        this.totalSize = this.pageList.length;
        console.log(this.pageList[0])

      })

    },
  }
</script>

<style scoped>
  .el-header,
  .el-footer {
    background-color: #365cd8;
    color: white;
    text-align: center;
    font-size: 40px;
    line-height: 60px;
    height: 200px;
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

  .personalInfo .user,
  .personalInfo .user img {
    height: 51px;
    width: 66px;
    background-color: rgba(78, 97, 243, 0);
    line-height: 50px;
    margin-right: 10px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    height: 580px;


  }

  body>.el-container {
    margin-bottom: 40px;
  }

  .pages {
    position: absolute;
    text-align: center;
    color: #333;
    top: 576px;
    left: 570px;
  }

  h3,
  h5,
  h6 {
    margin-top: 15px;
    margin-bottom: 0px;
  }

  .el-main {
    background-image: url(../assets/productList/background.jpg);
    background-size: 100% 100%;
    background-repeat: no-repeat;
    height: 645px;
  }

  .el-row {
    left: -40px;
    top: 10px;
    padding-top: 60px;
  }
</style>