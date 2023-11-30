<template>
  <div class="content">
    <div class="container">
      <div class="login-wrapper">
        <div class="header">登录</div>
        <div class="form-wrapper">
          <el-input type="text" name="username" placeholder="用户名" class="input-item" v-model="username"></el-input>
          <el-input type="password" name="password" placeholder="密码" class="input-item" show-password v-model="password"></el-input>
          <button class="btn" @click="login">登录</button>
          <div id="register">
            <router-link to='/register'>
              前往注册
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "Login",
  data() {
    return {
      password: '',
      username: ''
    }
  },
  methods: {
    login() {
    //   const usernamePattern = /^(?:(?:\+|00)86)?1[3-9]\d{9}$/; // 11-digit phone number pattern
    //   const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // Email pattern
    //   const passwordPattern = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*]).{8,}$/; // Password pattern
      axios.post('/user/login',{
        password: this.password,
        username: this.username
      }).then(res=>{
        if(res.data.status === "成功"){
          sessionStorage.setItem('userId',res.data.msg.id);
          sessionStorage.setItem('userMessage',JSON.stringify(res.data.msg));
          if (this.username === 'root' && this.password === '12345678') {
            this.$router.push({ path: '/homeadm' });
          } else {            
                this.$router.push({ path: '/home' });
          }
        }
        else {
          alert('登陆失败，请重新登录')
        }
      }).catch(e=>{console.error(e)})
      
    }
  },
}
</script>

<style scoped lang="less">
* {
  margin: 0;
  padding: 0;
}

.content {
  width: 100%;
  height: 100vh;
  background-image: url(https://elaina-1309843050.cos.ap-beijing.myqcloud.com/0119015c6675f4a801213f26120f09.png%401280w_1l_2o_100sh.png);
  background-size: 100% 100%;
  //user-select: none;
}

.container {
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

.login-wrapper {
  background-color: rgb(247, 239, 228);
  width: 250px;
  height: 200px;
  border-radius: 15px;
  position: relative;
  left: 50%;
  top: 25%;
  transform: translate(-50%, -50%);
}

.header {
  font-size: 38px;
  font-weight: bold;
  text-align: center;
  line-height: 200px;
  color: rgb(216, 147, 164);
}

.btn {
  text-align: center;
  padding: 10px;
  width: 100%;
  margin-top: 40px;
  margin-bottom: 50px;
  background-color: rgb(247, 239, 228);
  color: rgb(216, 147, 164);
  border-radius: 12px;
  border: none;
}

.btn:hover {
  box-shadow: 5px 5px 20px rgb(222, 219, 219);
}

#register {
  margin-left: 100px;
}

/deep/ .el-input__inner {
  display: block !important;
  width: 100% !important;
  margin-bottom: 20px !important;
  border: none !important;
  border-radius: 12px !important;
  padding: 10px !important;
  box-shadow: inset 5px 5px 20px rgb(225, 225, 225) !important;
  font-size: 15px !important;
  outline: none !important;
  background-color: rgb(247, 239, 228) !important;
}

.el-input__inner:placeholder {
  text-transform: uppercase !important;
}
</style>

