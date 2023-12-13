import Vue from 'vue';
import ElementUI from 'element-ui';
// import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
import store from './store'



// 引入 echarts
import echarts from "echarts";
Vue.prototype.$echarts = echarts;

// 引入路由
import router from './router/index';

// axios全局配置
import axios from 'axios';

// 配置axios
axios.defaults.baseURL = 'http://localhost:8080/keshe';
// axios.defaults.timeout = 5000;
axios.defaults.headers.post['Content-Type'] = 'application/json';
axios.defaults.withCredentials = true
Vue.config.productionTip = false

// 使用 element-ui
Vue.use(ElementUI);


new Vue({
  render: h => h(App),
  // 组测路由信息
  router,
  store,
  beforeCreate() {
    //此时这个this就是vm，只不过这个时候还并没有去解析模版
    Vue.prototype.$bus = this; //安装全局事件总线
  }
}).$mount('#app')

router.beforeEach((to, from, next) => {
  var userId = sessionStorage.getItem('userId')//存储userId
  if (userId) {//to.meta.nacy=='true'这里面的nacy就是自己在路由中设置的//不参与token验证的页面参数变量这个变量可以自己定义
        next()
  } else {
    if (to.path == '/login' || to.path == '/register') {
      next()
    } else {
      next('/login')
    }
  }
 
});