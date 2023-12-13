<template>
  <div>
    <!-- 第一行四分格 -->
    <el-row :gutter="20" style="margin-left: 0px; margin-right: 0px">
      <el-col :span="12">
        <div class="grid-content bg-purple">
          <div class="titleFirst">
            <i class="el-icon-user-solid" :style="{ color: iconColor[0] }"></i
            >我的小队
          </div>
          <div class="content">
            <el-row :gutter="5" class="listBox">
              <el-col
                :span="12"
                v-bind:key="item.id"
                v-for="item of this.myTeamList"
                style="
                  margin-top: 4px;
                  margin-left: auto;
                  margin-right: auto;
                  margin-bottom: 0;
                "
              >
                <el-card
                  style="
                    width: 95%;
                    text-align: center;
                    margin: auto;
                    height: 3rem;
                    padding: auto;
                  "
                  shadow="hover"
                >
                  {{ item.teamName }}
                </el-card>
              </el-col>
              <el-col v-if="this.myTeamList.length === 0" :span="24">
                <el-empty description="暂无记录" :image-size="90"></el-empty>
              </el-col>
            </el-row>
          </div>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          <div class="titleFirst">
            <i
              class="el-icon-s-cooperation"
              :style="{ color: iconColor[0] }"
            ></i
            >我的资源
          </div>
          <div class="content">
            <el-row :gutter="5" class="listBox">
              <el-col
                :span="12"
                v-bind:key="item.id"
                v-for="item of this.myResourceList"
                style="
                  margin-top: 4px;
                  margin-left: auto;
                  margin-right: auto;
                  margin-bottom: 0;
                "
              >
                <el-card
                  style="
                    width: 95%;
                    text-align: center;
                    margin: auto;
                    height: 3rem;
                    padding: auto;
                  "
                  shadow="hover"
                >
                  {{ item.teamName }}
                </el-card>
              </el-col>
              <el-col v-if="this.myResourceList.length === 0" :span="24">
                <el-empty description="暂无记录" :image-size="90"></el-empty>
              </el-col>
            </el-row>
          </div>
        </div>
      </el-col>
    </el-row>
    <!-- 第一行四分格 -->

    <!-- 第二行二分格 -->
    <el-row style="margin-left: 0px; margin-right: 0px">
      <el-col :span="24">
        <div class="grid-content bg-purple">
          <div class="titleFirst">
            <i class="el-icon-s-comment" :style="{ color: iconColor[0] }"></i
            >资讯速览
          </div>
          <div class="content">
            <el-row class="listBox" :gutter="20">
              <el-col
                :span="12"
                v-bind:key="index"
                v-for="(item, index) in this.info"
              >
                <el-link
                  shadow="hover"
                >
                  {{ item }}
                </el-link>
              </el-col>
              <el-col v-if="this.info.length === 0" :span="24">
                <el-empty description="暂无记录" :image-size="90"></el-empty>
              </el-col>
            </el-row>
          </div>
        </div>
      </el-col>
    </el-row>
    <!-- 第二行二分格 -->
  </div>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {
      // 导航 关注 资源 历史组队
      iconColor: ["#1b813e", "#FDE047", "#64748B", "#22D3EE"],
      info: [
        "清华大学夏令营开放",
        "考研数学怎么学？",
        "今天你背单词了吗",
        "政治什么时候开始背最好？",
        "你的心仪院校报录比是多少？",
        "清华大学夏令营开放",
        "考研数学怎么学？",
        "今天你背单词了吗",
        "政治什么时候开始背最好？",
        "你的心仪院校报录比是多少？",        
        "清华大学夏令营开放",
        "考研数学怎么学？",
        "今天你背单词了吗",
        "政治什么时候开始背最好？",
        "你的心仪院校报录比是多少？",        
        "清华大学夏令营开放",
        "考研数学怎么学？",
        "今天你背单词了吗",
        "政治什么时候开始背最好？",
        "你的心仪院校报录比是多少？",       
        "清华大学夏令营开放",
        "考研数学怎么学？",
        "今天你背单词了吗",
        "政治什么时候开始背最好？",
        "你的心仪院校报录比是多少？",
      ],
      myTeamList: [],
      myResourceList: [],
    };
  },
  methods: {
    toTeam() {
      this.$router.push({ path: "/teamhistory" });
    },
    toMySources() {
      this.$router.push({ path: "/resourcesload" });
    },
    showInfo() {
      this.$router.push({ path: "/info" });
    },
  },
  created() {
    // 获取数据
    axios
      .get("/team/myteam")
      .then((res) => {
        console.log(res);
        this.myTeamList = res.data.msg;
      })
      .catch((error) => {
        this.$$message.error("获取列表失败");
      });
  },
};
</script>

<style scoped>
.el-row {
  margin-bottom: 20px;
}

.el-col {
  border-radius: 4px;
}

.bg-purple-dark {
  background: #99a9bf;
}

.bg-purple {
  background: #d3dce6;
}

.bg-purple-light {
  background: #e5e9f2;
}

.grid-content {
  margin-top: 10px;
  min-height: 25vh;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  background-color: #ffffff;
}

.grid-content:hover {
  box-shadow: 0 2px 8px rgb(0 0 0 / 15%);
}

.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

.grid {
  min-height: 25vh;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  background: #ffffff;
}

.title {
  width: 100%;
  height: 35px;
  margin-bottom: 35px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  border-bottom: #e8e8e8 2px solid;
  font-size: 16px;
  font-weight: bolder;
}

.titleFirst {
  width: 100%;
  height: 40px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  border-bottom: #e8e8e8 2px solid;
  background-color: #d3dce6;
  font-size: 16px;
  font-weight: bolder;
}

.content {
  width: 100%;
}

.el-empty {
  padding: 0px;
}

i {
  margin-right: 10px;
  font-size: 30px;
}

#gridL {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  text-align: center;
}

#gridR {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}

.info {
  width: 95%;
  margin: 10px 10px 0px 10px;
  background-color: #f5f5f5;
  border-radius: 12px;
  font-size: 13px;
}

.one {
  min-height: 6vh;
  display: flex;
  width: 8vw;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.one:hover {
  box-shadow: inset 0 2px 8px rgba(0, 0, 0, 0.1);
}

.listBox {
  height: 200px;
  overflow-y: auto;
  text-align: center;
}
</style>
