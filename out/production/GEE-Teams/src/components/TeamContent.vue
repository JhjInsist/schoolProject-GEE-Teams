<template>
  <div id="content">
    <div v-if="!show">
      <div class="select">
        <div id="title">信息筛选</div>
        <el-select v-model="value1" placeholder="院校名称">
          <el-option v-for="item in matches" :key="item.value" :label="item.label" :value="item.value">
          </el-option>
        </el-select>
        <el-button @click="reData()" type="primary" round>清空</el-button>
        <el-button @click="filterData()" type="primary" round>搜索</el-button>
        <el-button @click="newTO()" type="primary" round>创建</el-button>
      </div>
      <div class="showpage" v-if="flag">
        <div class="info" v-for="(info, index) in infoList" :key=index>
          <div id="name" class="style">{{ info.teamName }}</div>
          <div id="competitionName" class="style">院校名称：{{ info.institutionName }}</div>
          <div id="leaderName" class="style">队长：{{ info.leaderName }}</div>
          <div id="leaderPhone" class="style">联系方式：{{ info.leaderPhonenum }}</div>
          <div id="detail" @click="Visible">详情</div>
          <div id="join" @click="join(info.id)">申请入队</div>
          <!-- 父子传值、事件委托 -->
          <Detail :dialogVisible="visible" :obj="info" @send="(data) => { getData(data) }"></Detail> 
        </div>
      </div>
      <el-empty el-empty description=" 暂无数据" :image-size="300" v-if="!flag">
      </el-empty>
    </div>
    <el-empty el-empty description=" 暂无数据" :image-size="300" v-if="show">
    </el-empty>
  </div>
</template>

<script>
import axios from 'axios'
import Detail from '../pages/Demo'
export default {
  components: { Detail },
  data() {
    return {
      visible: false,
      show: false,
      matchesList: [],
      matches: [{
        value: '北京大学',
        label: '北京大学'
      }, {
        value: '清华大学',
        label: '清华大学'
      }, {
        value: '北京理工大学',
        label: '北京理工大学'
      }, {
        value: '四川大学',
        label: '四川大学'
      }, {
        value: "华南理工大学",
        label: '华南理工大学'
      }],
      value1: [],
      infoList: [],
      infoListCopy: [],
      flag: true,
    }
  },
  methods: {
    join(teamId) {
      this.$confirm('确定加入小队吗？')
        .then(_ => {
            axios.get("/team/addTeam?teamId="+teamId).then(res=>{
              if(res.data.status === "成功"){
                this.$message.success(res.data.msg);
              }else{
                 this.$message.error(res.data.msg);
              }
            }).catch(error=>{
              this.$message.error("未知错误");
              console.log(error);
            })
        })
        .catch(_ => { });
    },
    newTO() {
      this.$router.push({ path: '/new' })
    },
    reData() {
      this.value1 = [];
      this.infoList = this.infoListCopy;
      this.flag = true;
    },
    filterData() {
      
      console.log(this.value1);
      const val = this.value1;

      if (val == "清华大学") {
        this.flag = true;
        this.infoList = [{
          name: "清华大学",
          leader: "诸葛",
          contact: "15976245978",
        }]
      }
      else if (val == "北京大学") {
        this.flag = true;
        this.infoList = [{
          name: "北京大学",
          leader: "小明",
          contact: "18172440102",
        }]
      } else if (val == "华南理工大学") {
        this.flag = true;
        this.infoList = [{
          name: "华南理工大学",
          leader: "罗斯",
          contact: "18972645636",
        }]
      } else if (val == "北京理工大学") {
        this.flag = true;
        this.infoList = [{
          name: "北京理工大学",
          leader: "霍德",
          contact: "18172645436",
        }]
      } else if (val == "四川大学") {
        this.flag = true;
        this.infoList = [{
          name: "四川大学",
          leader: "蔡坤",
          contact: "15147256798",
        }]
      } else {
        this.flag = false
      }
    },
    Visible() {
      // this.$router.push({ path: '/demo' })
      this.visible = true
    },
    getData(data) { // 监听子组件 send 事件，并获取传递的数据
      this.visible = data;
      console.log(data);
    }
  },
  mounted() {
    

  },
  created() {
    // 获取数据
    axios.get('/team/list').then(res => {
        console.log(res);
        this.infoList = res.data.msg;
      }).catch(error => {
        this.$$message.error("获取列表失败");
      })
  }
}
</script>

<style scoped>
#content {
  height: 100%;
  width: 100%;
}

#title {
  font-weight: lighter;
  font-size: 14px;
  width: 80px;
  text-align: center;
  /* background-color: aqua; */
  border-radius: 12px;
}

.select {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  width: 100%;
  height: aoto;
  padding: 10px 0 10px 0;
  border-bottom: 2px solid #e8e8e8;
}

.showpage {
  margin-top: 10px;
  width: 90%;
  padding-left: 100px;
  height: auto;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: flex-start;
  flex-flow: row wrap;
}

#detail {
  width: 90%;
  height: 20px;
  color: #4fa6ff;
  text-align: end;
  font-size: 13px;
}

.info {
  width: 200px;
  height: 250px;
  /* border: 1px solid red; */
  margin-top: 25px;
  margin-bottom: 25px;
  margin-left: 0px;
  margin-right: 75px;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
  background-color: #ffffff;
}

.info:hover {
  box-shadow: 0 2px 8px rgb(0 0 0 / 15%);
}

.style {
  border-radius: 12px;
}

#name {
  width: 90%;
  height: 30px;
  /* background-color: blue; */
  margin: 0 5% 0 5%;
  text-align: center;
  line-height: 30px;
}

#leaderName {
  width: 90%;
  height: 30px;
  margin: 0 5% 0 5%;
  line-height: 30px;
  font-size: 12px;
}

#competitionName {
  width: 90%;
  height: 30px;
  margin: 0 5% 0 5%;
  line-height: 30px;
  font-size: 12px;
}

#leaderPhone {
  width: 90%;
  height: 30px;
  margin: 0 5% 0 5%;
  line-height: 30px;
  font-size: 12px;
}

#join {
  width: 90%;
  height: 40px;
  background-color: #ecf5ff;
  border-radius: 12px;
  margin: 0 5% 0 5%;
  line-height: 40px;
  text-align: center;
  color: #4fa6ff;
  font-size: 14px;
}

#join:hover {
  background-color: #4fa6ff;
  color: #ecf5ff;
}

#avatar {
  width: 90%;
  height: 40px;
  margin: 0 5% 0 5%;
  line-height: 40px;
  display: flex;
  justify-content: space-evenly;
}
</style>