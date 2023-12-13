<template>
  <div class="breadcrumb">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item v-for="(item, index) in $route.meta" :key="index">{{ item }}</el-breadcrumb-item>
    </el-breadcrumb>
    <el-dropdown @command="handleCommand" id="btn">
      <span class="el-dropdown-link">
        <el-avatar>{{ avatarText }}</el-avatar>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="mine">个人中心</el-dropdown-item>
        <el-dropdown-item command="layOut">退出登录</el-dropdown-item>
        <el-dropdown-item command="feedback">反馈</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<script>
export default {
  data() {
    return {
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      sizeList: ["large", "medium", "small"],
      avatarText:'aa'
    }
  },
  methods: {
    layOut() {
      this.$router.replace('/login');
      this.$route.history = []
    },
    handleCommand(command) {
      if (command == "layOut") {
        this.layOut();
      }
      else if (command == "feedback") {
        this.$router.push('/feedback');
      }
      else {
        this.$router.push('/mine');
      }
    }
  },
  created:function(){
    this.avatarText = JSON.parse(sessionStorage.getItem('userMessage')).name
    console.log(this.avatarText);
  }

}
</script>

<style scoped lang="less">
.breadcrumb {
  height: 60px;
  padding-left: 20px !important;
  background-color: #f5f5f5;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  border-bottom: #e8e8e8 1px solid;
  user-select: none;
}

#btn {
  float: right;
  margin-right: 20px;
}

.bread /deep/ .el-breadcrumb__item {
  width: 600px !important;
  height: 60px !important;
}

/deep/ .el-breadcrumb {
  width: 600px !important;
  height: 60px !important;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
}
</style>