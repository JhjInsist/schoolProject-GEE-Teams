<template>
  <div id="content">
    <div id="form" style="margin-top: 30px">
      <div class="header">注冊</div>
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="form-wrapper"
        style="margin-top: 30px"
        :disabled="show"
      >
        <el-form-item label="姓名" prop="name" class="input-item">
          <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>

        <el-form-item label="用户名" prop="username">
          <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item label="电话（用户名）" prop="phoneNum">
          <el-input v-model="ruleForm.phoneNum"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="ruleForm.password" show-password></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-radio v-model="ruleForm.gender" label="男">男</el-radio>
          <el-radio v-model="ruleForm.gender" label="女">女</el-radio>
        </el-form-item>
        <el-form-item label="所在省份" prop="province">
          <el-select v-model="ruleForm.province" placeholder="请选择所在省份">
            <el-option label="上海" value="shanghai"></el-option>
            <el-option label="北京" value="beijing"></el-option>
            <el-option label="辽宁" value="liaoning"></el-option>
            <el-option label="深圳" value="shenzhen"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="个人描述" prop="content">
          <el-input type="textarea" v-model="ruleForm.content"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')"
            >立即创建</el-button
          >
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      ruleForm: {
        name: "",
        phoneNum: "",
        password: "",
        gender: "",
        province: "",
        content: "",
        username:"",
      },
      show: false,
      rules: {
        name: [
          { required: true, message: "请输入姓名", trigger: "blur" },
          {
            min: 1,
            max: 10,
            message: "长度在 1 或 10 个字符",
            trigger: "blur",
          },
        ],
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          {
            min: 1,
            max: 10,
            message: "长度在 1 或 10 个字符",
            trigger: "blur",
          },
        ],
        province: [
          { required: true, message: "请选择所在省份", trigger: "change" },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "change" },
          { min: 8, max: 256, message: "长度8个字符", trigger: "blur" },
        ],
        content: [
          { required: true, message: "请填写个人描述", trigger: "blur" },
        ],
        gender: [{ required: true, message: "请选择性别", trigger: "blur" }],
        phoneNum: [
          { required: true, message: "请输入联系方式", trigger: "blur" },
          { min: 11, max: 11, message: "长度在 11 个字符", trigger: "blur" },
        ],
      },
      numsRegex: /^1(3\d|4[5-9]|5[^4]|6[567]|7[^249]|8\d|9[189])\d{8}$/, // 定义正则表达式
      idRegex:
        /^[1-9]\d{5}(19|20)\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}[Xx\d]$/,
      isNumsValid: false,
      isIdValid: false,
    };
  },
  methods: {
    checkNums() {
      this.isNumsValid = this.numsRegex.test(this.ruleForm.phoneNum); // 使用正则表达式测试输入值
    },

    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        // 校验所有信息是否合格
        if (valid) {
          // 继续校验手机号码是否正确
          this.checkNums();
          if (this.isNumsValid) {
            // 数据传输
            axios
              .post("/user/register", this.ruleForm)
              .then((res) => {
                if (res.data.status === "成功") {
                  this.$message.success(res.data.msg);
                  this.$router.push({ path: "/login" });
                } else {
                  this.$message.error(res.data.msg);
                }
              })
              .catch((error) => {
                this.$message.error("未知错误");
                console.log(error);
                this.$router.push({ path: "/login" });
              });
            // bind(this)将当前上下文绑定到回调函数中，确保在回调函数中使用的 this 指向的是 vue 组件实例的上下文
          } else {
            console.log("error submit!!111");
            return false;
          }
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style lang="less" scoped>
#content {
  width: 100vw;
  height: 100vh;
  background-color: #c3d7df;
  background-size: cover;
  user-select: none;
  display: flex;
  align-items: center;
  justify-content: center;
}
#content {
  width: 100%;
  height: 100vh;
  background-image: url(https://elaina-1309843050.cos.ap-beijing.myqcloud.com/0119015c6675f4a801213f26120f09.png%401280w_1l_2o_100sh.png);
  background-size: 100% 100%;
  //user-select: none;
}
.header {
  font-size: 38px;
  font-weight: bold;
  text-align: center;
  color: rgb(216, 147, 164);
}

#form {
  height: 70%;
  width: 450px;
  position: absolute;
  left: 65%;
  top: 15%;
  background-color: rgb(248, 232, 208);
  border-radius: 15px;
  box-shadow: 10px 10px 55px rgb(222, 219, 219);
  border: rgb(222, 219, 219) solid 0.5px;
}

#main {
  width: 100%;
  height: 85%;
}

/deep/ .el-input {
  width: 70%;
}

/deep/ .el-textarea {
  width: 70%;
}

/deep/ .el-select {
  width: 100%;
}
</style>
