<template>
  <div class="breadcrumb">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/homeadm' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item v-for="(item, index) in $route.meta" :key="index">{{ item }}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.breadcrumb {
  height: 60px;
  padding-left: 20px !important;
  background-color: #f5f5f5;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  border-bottom: #e8e8e8 1px solid;
  user-select: none;
}

.bread /deep/ .el-breadcrumb__item {
  width: 600px !important;
}
</style>