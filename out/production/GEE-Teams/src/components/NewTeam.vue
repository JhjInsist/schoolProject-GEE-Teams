<template>
  <div id="content">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" :disabled=show>
      <el-form-item label="队伍名称" prop="teamName">
        <el-input v-model="ruleForm.teamName"></el-input>
      </el-form-item>
      <el-form-item label="院校省份" prop="institutionProvince">
        <el-input v-model="ruleForm.institutionProvince" placeholder="请输入目标院校所在省份"></el-input>
      </el-form-item>
      <el-form-item label="院校名称" prop="institutionName">
        <el-input v-model="ruleForm.institutionName" placeholder="请输入院校名称">
        </el-input>
      </el-form-item>
      <el-form-item label="队长性别" prop="leaderGender">
        <el-radio v-model="ruleForm.leaderGender" label="1">男</el-radio>
        <el-radio v-model="ruleForm.leaderGender" label="2">女</el-radio>
      </el-form-item>
      <el-form-item label="需求描述" prop="teamRequest">
        <el-input type="textarea" v-model="ruleForm.teamRequest"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      ruleForm: {
        teamName: '',
        institutionProvince: '',
        institutionName: '',
        leaderGender: '1',
        teamRequest: ''
      },
      show: false,
      rules: {
        teamName: [
          { required: true, message: '请输入活动名称', trigger: 'blur' },
          { min: 2, max: 8, message: '长度在 2 到  个字符', trigger: 'blur' }
        ],
        institutionProvince: [
          { required: true, message: '请选择所在区域', trigger: 'change' }
        ],
        institutionName: [
          { required: true, message: '请选择院校名称', trigger: 'change' }
        ],
        teamRequest: [
          { required: true, message: '请填写个人描述', trigger: 'blur' }
        ],
        leaderGender: [
          { required: true, message: '请选择性别', trigger: 'blur' }
        ],
      },
      numsRegex: /^1(3\d|4[5-9]|5[^4]|6[567]|7[^249]|8\d|9[189])\d{8}$/, // 定义正则表达式
      isNumsValid: false,
    };
  },
  methods: {
    success() {
      this.show = true;
      this.$message({
        message: '恭喜你，成功创建',
        type: 'success'
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        // 校验所有信息是否合格
        if (valid) {
            
          // 发送http请求
            axios.post("/team/create",this.ruleForm).then(res=>{
              if(res.data.status === "成功"){
                this.$message.success(res.data.msg);
                this.$router.push({ path: '/teamlist' });  
              }else{
                this.$message.error(res.data.msg);
              }
            }).catch(e=>{
              console.log(e);
              this.$message("出现错误");
            })
          } else {
            console.log('error submit!!');
            return false;
          }
       
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
}
</script>
<style scoped>
#content {
  width: 50%;
  height: auto;
  margin: 10% 25% 0 25%;
}
</style>
