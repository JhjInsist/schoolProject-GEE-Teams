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
      </div>
      <div class="showpage" v-if="flag">
        <div class="info" v-for="(info, index) in infoList" :key=index>
          <div id="name" class="style">{{ info.name }}</div>
          <div id="leader" class="style">队长：{{ info.leader }}</div>
          <div id="contact" class="style">联系方式：{{ info.contact }}</div>
          <div id="delte" @click="delte(index)">删除该小队</div> 
          <!-- <el-button  type="text" size="small" @click="deleteStudent(info.id)">删除</el-button> -->
          <div id="avatar" class="style"><el-avatar icon="el-icon-user-solid"></el-avatar><el-avatar icon="el-icon-user-solid"></el-avatar><el-avatar icon="el-icon-user-solid"></el-avatar>
            <h5>···</h5>
          </div>
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
        value: '大连理工大学',
        label: '大连理工大学'
      }, {
        value: '东北大学',
        label: '东北大学'
      }, {
        value: '天津大学',
        label: '天津大学'
      }, {
        value: "华南理工大学",
        label: '华南理工大学'
      }],
      value1: [],
      // value2: [],
      infoList: [],
      infoListCopy: [],
      flag: true,
    }
  },
  methods: {
    delte(index) {
      let flag = window.confirm(`确定要删除吗？`)
      if(!flag){return}
      this.infoList.splice(index, 1);
    }, 

    reData() {
      this.value1 = [];
      this.infoList = this.infoListCopy;
      this.flag = true;
    },
    filterData() {
      //
      console.log(this.value1);
      const val = this.value1;
      if (val == "北京大学") {
        this.flag = true;
        this.infoList = [{
          name: "北京大学",
          leader: "小明",
          contact: "18172440102",
        }]
      }
      else if (val == "清华大学") {
        this.flag = true;
        this.infoList = [{
          name: "清华大学",
          leader: "小红",
          contact: "15976245978",
        }]
      }
      else if (val == "北京理工大学") {
        this.flag = true;
        this.infoList = [{
          name: "北京理工大学",
          leader: "小兰",
          contact: "18172445236",
        }]
      }
      else if (val == "四川大学") {
        this.flag = true;
        this.infoList = [{
          name: "四川大学",
          leader: "小军",
          contact: "15147256798",
        }]
      }
      else if (val == "华南理工大学") {
        this.flag = true;
        this.infoList = [{
          name: "华南理工大学",
          leader: "小梓",
          contact: "18172645436",
        }]
      }
      else if (val == "大连理工大学") {
        this.flag = true;
        this.infoList = [{
          name: "大连理工大学",
          leader: "小黄",
          contact: "15176255998",
        }]
      }
      else if (val == "东北大学") {
        this.flag = true;
        this.infoList = [{
          name: "东北大学",
          leader: "小绿",
          contact: "18972645636",
        }]
      }
      else if (val == "天津大学") {
        this.flag = true;
        this.infoList = [{
          name: "天津大学",
          leader: "小白",
          contact: "15146256998",
        }]
      } else {
        this.flag = false
      }
    }
  },
  mounted() {
    const info = [{
      name: "北京大学",
      leader: "小明",
      contact: "18172440102",
      id: 1
    }, {
      name: "清华大学",
      leader: "小红",
      contact: "15976245978",
      id: 2
    }, {
      name: "北京理工大学",
      leader: "小兰",
      contact: "18172445236",
      id: 3
    }, {
      name: "四川大学",
      leader: "小军",
      contact: "15147256798",
      id: 4
    }, {
      name: "华南理工大学",
      leader: "小梓",
      contact: "18172645436",
      id: 5
    }, {
      name: "大连理工大学",
      leader: "小黄",
      contact: "15176255998",
      id: 6
    }, {
      name: "东北大学",
      leader: "小绿",
      contact: "18972645636",
      id: 7
    }, {
      name: "天津大学",
      leader: "小白",
      contact: "15146256998",
      id: 8
    },];
    this.infoList = info;
    this.infoListCopy = info;
  }
  // 检查是否有数据然后展示不同的界面
  // created() {
  //   // 获取数据
  //   axios.get(url).then(response => {
  //     if (response.data == NULL) {
  //       this.show = true
  //     }
  //     console.log('添加成功：' + response.data);
  //     this.tableData = response.data;
  //   }).catch(error => {
  //     console.log(error.message);
  //   });
  // }
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
  width: 100%;
  height: auto;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: flex-start;
  flex-flow: row wrap;
}

.info {
  width: 200px;
  height: 250px;
  /* border: 1px solid red; */
  margin: 25px;
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

#delte {
  width: 90%;
  height: 40px;
  background-color: #fef0f0;
  border-radius: 12px;
  margin: 0 5% 0 5%;
  line-height: 40px;
  text-align: center;
  color: #f56c6c;
  font-size: 14px;
}

#delte:hover {
  background-color: #f56c6c;
  color: #fef6f6;
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