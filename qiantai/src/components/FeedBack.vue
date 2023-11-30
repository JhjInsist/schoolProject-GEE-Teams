<template>
  <div id="content">
    <div id="main">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" :disabled=show>
        <el-form-item label="反馈主题" prop="name">
          <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="手机号码" prop="phone">
          <el-input v-model="ruleForm.phone"></el-input>
        </el-form-item>
        <el-form-item label="反馈类型" prop="category">
          <el-select v-model="ruleForm.category" placeholder="请选择反馈类型">
            <el-option label="网页问题" value="网页问题"></el-option>
            <el-option label="使用反馈" value="使用反馈"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="反馈内容">
          <el-checkbox-group v-model="ruleForm.type">
            <el-checkbox label="没有要参加的比赛/比赛少" name="type"></el-checkbox>
            <el-checkbox label="使用体验差" name="type"></el-checkbox>
            <el-checkbox label="功能太少" name="type"></el-checkbox>
            <el-checkbox label="其他" name="type"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="具体内容" prop="desc">
          <el-input type="textarea" v-model="ruleForm.desc"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="this.submitForm('ruleForm')">提交反馈</el-button>
          <el-button @click="this.resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script lang="ts">
export default {
  data() {
    return {
      ruleForm: {
        name: '',
        phone: '',
        category: '',
        type: [],
        desc: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入反馈主题', trigger: 'blur' },
          { min: 2, max: 20, message: '长度在 3 或 20 个字符', trigger: 'blur' }
        ],
        category: [
          { required: true, message: '请选择反馈类型', trigger: 'change' }
        ],
        desc: [
          { required: true, message: '请填写具体内容', trigger: 'blur' }
        ],
        phone: [
          { required: true, message: '请输入联系方式', trigger: 'blur' },
          { min: 11, max: 11, message: '长度在 11 个字符', trigger: 'blur' }
        ]
      },
      show: false,
      numsRegex: /^1(3\d|4[5-9]|5[^4]|6[567]|7[^249]|8\d|9[189])\d{8}$/,
      isNumsValid: false,
    }
  },
  methods: {
    success() {
      this.show = true;
      this.$message({
        message: '反馈成功',
        type: 'success'
      });
    },
    checkNums() {
      this.isNumsValid = this.numsRegex.test(this.ruleForm.phone); // 使用正则表达式测试输入值
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        // 校验所有信息是否合格
        if (valid) {
          // 继续校验手机号码是否正确
          this.checkNums();
          if (this.isNumsValid) {
            this.success();
            setTimeout(function () {
              this.$router.push({ path: '/home' });
            }.bind(this), 1000);
          } else {
            console.log('error submit!!');
            return false;
          }
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
#content {
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>