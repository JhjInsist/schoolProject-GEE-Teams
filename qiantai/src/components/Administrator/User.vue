<template>
  <div id="content">
    <div v-if="!show">
      <div class="select">
        <div id="title">信息筛选</div>
        <el-select v-model="value1" placeholder="性别">
          <el-option v-for="item in matches" :key="item.value" :label="item.label" :value="item.value">
          </el-option>
        </el-select>
        <el-button @click="reData()" type="primary" round>清空</el-button>
        <el-button @click="filterData()" type="primary" round>搜索</el-button>
      </div>
      <div class="showpage" v-if="flag">
        <div class="info" v-for="(info, index) in infoList" :key=index>
          <div id="avatar" class="style"><el-avatar icon="el-icon-user-solid" :size=50></el-avatar>
          </div>
          <div id="name" class="style">{{ info.name }}</div>
          <div id="gender" class="style">性别：{{ info.gender }}</div>
          <div id="contact" class="style">联系方式：{{ info.contact }}</div>
          <div id="delte" @click="delte(index)">删除该小队</div>
          <!-- <div id="delte" @click="delte()">删除该用户</div> -->
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
        value: '男',
        label: '男'
      }, {
        value: '女',
        label: '女'
      },],
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
      if (val == "男") {
        this.flag = true;
        this.infoList = [{
          name: "诸葛",
          gender: "男",
          contact: "15976245978",
        }, {
          name: "蔡集美",
          gender: "男",
          contact: "15146256998",
        }, {
          name: "蔡坤",
          gender: "男",
          contact: "15147256798",
        }, {
          name: "小明",
          gender: "男",
          contact: "18172440102",
        }, {
          name: "李宁",
          gender: "男",
          contact: "18172445236",
        }, {
          name: "罗斯",
          gender: "男",
          contact: "18972645636",
        },]
      }
      else if (val == "女") {
        this.flag = true;
        this.infoList = [{
          name: "霍德",
          gender: "女",
          contact: "18172645436",
        }, {
          name: "刘欢",
          gender: "女",
          contact: "15176255998",
        },]
      } else {
        this.flag = false
      }
    }
  },
  mounted() {
    const info = [{
      name: "小明",
      gender: "男",
      contact: "18172440102",
    }, {
      name: "诸葛",
      gender: "男",
      contact: "15976245978",
    }, {
      name: "李宁",
      gender: "男",
      contact: "18172445236",
    }, {
      name: "蔡坤",
      gender: "男",
      contact: "15147256798",
    }, {
      name: "霍德",
      gender: "女",
      contact: "18172645436",
    }, {
      name: "刘欢",
      gender: "女",
      contact: "15176255998",
    }, {
      name: "罗斯",
      gender: "男",
      contact: "18972645636",
    }, {
      name: "蔡集美",
      gender: "男",
      contact: "15146256998",
    },];
    this.infoList = info;
    this.infoListCopy = info;
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

#gender {
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