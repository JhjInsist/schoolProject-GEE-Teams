<template>
  <el-dialog title="小队详情" :visible="dialogVisible" width="30%" :before-close="handleClose">
    <div id="info">
      <div id="info_name">队长：{{ obj.leaderName }}</div>
      <div id="info_teamName">小队名称：{{ obj.teamName }}</div>
      <div id="info_leader">队长性别：{{ obj.leaderGender }}</div>
      <div id="info_address">学校：{{ obj.institutionName }}</div>
      <div id="info_contact">联系方式：{{ obj.leaderPhonenum }}</div>
      <div id="info_dec">需求描述：{{ obj.teamRequest }}</div>
    </div>
  </el-dialog>
</template>

<script >
export default {
  props: {
    dialogVisible: Boolean,
    obj:Object
  },
  data() {
    return {
      
    }
  },
  methods: {
    handleClose(done) {
      var that = this
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
          this.$emit('send', false) 
          // 调用父类里的send函数
          // that.$router.push('/teamlist')
        })
        .catch(_ => { });
    }
  },
}
</script>

<style>
#info {
  width: 90%;
  height: 250px;
  /* border: 1px solid red; */
  margin: 25px;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: flex-start;
}
</style>