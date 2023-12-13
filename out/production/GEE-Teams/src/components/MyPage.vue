<template>
  <div id="content">
    <div class="avatar"><el-avatar :size="100">{{avatarText}}</el-avatar></div>
    <div class="info">
      <el-descriptions class="margin-top" :column="3" :size="size" border v-for="(item, index) in info" :key=index>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            用户名
          </template>
          {{ item.name }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            性別
          </template>
          {{ item.gender }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机号
          </template>
          {{ item.phoneNum }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-location-outline"></i>
            居住地
          </template>
          {{ item.province }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            学校
          </template>
          {{ item.school }}
        </el-descriptions-item>
      </el-descriptions>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      info: [],
      avatarText: '',
    };
  },
  created:function(){
    this.info.push(JSON.parse(sessionStorage.getItem('userMessage')))
    this.avatarText = JSON.parse(sessionStorage.getItem('userMessage')).name
  }
}
</script>

<style scoped lang="less">
#content {
  margin-top: 10px;
  width: 100%;
  height: 95%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
}

.info {
  width: 90%;
  height: 100%;
  background-color: rgb(255, 255, 255);
}
</style>