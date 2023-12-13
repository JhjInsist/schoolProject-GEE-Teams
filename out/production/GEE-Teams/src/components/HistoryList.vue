<template>
  <div id="content">
    <div v-if="!show">
      <div class="select">
        <div id="title">信息筛选</div>
        <el-select v-model="value1" placeholder="请选择">
          <el-option v-for="item in matches" :key="item.value" :label="item.label" :value="item.value">
          </el-option>
        </el-select>
        <el-button @click="this.reData()" type="primary" round>清空</el-button>
        <el-button @click="this.filterData()" type="primary" round>搜索</el-button>
      </div>
      <div class="showpage" v-if="flag">
        <div class="info" v-for="(item, index) in this.infoList" :key=index>
          <div id="name" class="style">{{ item.teamName }}</div>
          <div id="leader" class="style">队长：{{ item.leaderName }}</div>
          <div id="contact" class="style">联系方式：{{ item.leaderPhonenum }}</div>
          <div id="delete">退出队伍</div>
          <!-- <div id="avatar" class="style"><el-avatar icon="el-icon-user-solid"></el-avatar><el-avatar icon="el-icon-user-solid"></el-avatar><el-avatar icon="el-icon-user-solid"></el-avatar>
            <h5>···</h5>
          </div> -->
        </div>
      </div>
      <el-empty el-empty description=" 暂无数据" :image-size="300" v-if="!flag">
      </el-empty>
    </div>
    <el-empty description="暂无数据" :image-size="300" v-if="show">
    </el-empty>
  </div>
</template>

<script lang="ts">
import axios from 'axios';
export default {
  data() {
    return {
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
    // 筛选数据
    filterData() {
      console.log(this.value1);
      const val = this.value1;
    },

    // 重置数据
    reData() {
      this.value1 = [];
      this.infoList = this.infoListCopy;
      this.flag = true;
    },
  },
  created() {
    // 获取数据
    axios.get('/team/myteam').then(res => {
        console.log(res);
        this.infoList = res.data.msg;
        console.log('infoList',this.infoList);
        
      }).catch(()=>{
        this.$message.error("获取列表失败");
      })
  },
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

#leader {
  width: 90%;
  height: 30px;
  margin: 0 5% 0 5%;
  line-height: 30px;
  font-size: 12px;
}

#contact {
  width: 90%;
  height: 30px;
  margin: 0 5% 0 5%;
  line-height: 30px;
  font-size: 12px;
}

#delete {
  width: 90%;
  height: 40px;
  background-color: #fef0f0;
  border-radius: 12px;
  margin: 0 5% 0 5%;
  line-height: 40px;
  text-align: center;
  color: #f67979;
  font-size: 14px;
}

#delete:hover {
  background-color: #f56c6c;
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