<template>
  <div id="content">
    <div id="header">
      <div id="input">
        <el-input v-model="data.title" placeholder="请输入文件标题"></el-input>
        <el-input v-model="data.discription" placeholder="请输入文件文件描述"></el-input>
      </div>
      <el-upload class="upload-demo" drag action="http://localhost:8080/keshe/resource/upload" :data="data" :before-upload="beforeUpload">
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip" slot="tip">文件大小不超过500kb</div>
      </el-upload>
    </div>
    <el-table :data="recordList" style="width: 100%" v-if="recordList.length !== 0">
      <el-table-column prop="title" label="文件名"></el-table-column>
      <el-table-column prop="description" label="简介"></el-table-column>
      <el-table-column prop="createTime" label="上传日期"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" @click="review(scope.$index)">预览 </el-button>
          <el-button @click="handleDelete(scope.$index)" type="danger">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
<!--    <div id="list">-->
<!--      <div id="title">历史上传</div>-->
<!--      <div id="listInfo" v-for="item of recordList">-->
<!--        <div>文件名称： {{item.description}}</div>-->
<!--        <div>文件描述： {{item.description}}</div>-->
<!--      </div>-->
<!--    </div>-->
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      da: '',
      data: {
        title: '',
        discription: '',
        userId: '',
      },
      recordList:[],
    }
  },
  methods: {
    review(index) {
      window.open(this.recordList[index].filePath, '_blank');
    },
    handleDelete(index) {
      // 获取数据
      axios.post('/resource/delete',{
        id:this.recordList[index].id
      }).then(() => {
        this.loadData();
      }).catch(()=>{
        this.$message.error("删除失败");
      })
    },
    beforeUpload() {
      if (this.data.title == '' && this.data.discription == '') {
        this.$notify.error({
          title: '通知',
          message: '请输入文件标题和文件描述',
          duration: 1000
        });
        return false;
      } else {
        return true
      }
    },
    success() {
      const h = this.$createElement;
      this.$notify({
        title: '提示',
        message: h('i', { style: 'color: teal' }, '上传成功，鼠标悬浮在项目上可删除'),
        type: 'success',
        duration: 1000
      });
    },
    remove() {
      const h = this.$createElement;
      this.$notify.error({
        title: '通知',
        message: '删除成功',
        duration: 1000
      });
    },
    loadData(){
      // 获取数据
      axios.get('/resource/list?uploaderId='+this.data.userId).then(res => {
        this.recordList = res.data.data;
        console.log(this.recordList)
      }).catch(()=>{
        this.$message.error("获取列表失败");
      })
    }
  },
  created() {
    this.data.userId = sessionStorage.getItem('userId')
    this.loadData();
  },
}
</script>

<style scoped lang="less">
#content {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  // justify-content: space-around;
  align-items: center;
}

#header {
  width: 100%;
  height: 30%;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  border-bottom: #e8e8e8 2px solid;
}

#list {
  margin-top: 1%;
  padding: 1% 0 1% 0;
  width: 100%;
  height: 66%;
  display: flex;
  flex-direction: column;
  align-items: center;
  overflow-y: auto;
}
#title {
  width: 90%;
  height: 30px;
  font-size: larger;
  background-color: #f0f2f5;
  text-align: center;
  line-height: 30px;
  margin-bottom: 1px;
}

#listInfo {
  padding: 0 1% 0 1%;
  width: 90%;
  height: 40px;
  margin-bottom: 20px;
  flex-shrink: 0;
  flex-grow: 0;
  flex-basis: auto;
  background-color: #fff;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  border-radius: 12px;
}

#name {
  width: 40%;
}

.upload-demo {
  margin-top: 10px;
  width: 30%;
  display: flex;
  flex-direction: column;
  align-items: center;
}

#input {
  width: 30%;
  height: 80%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  border-radius: 12px;
  border: #d9d9d9 2px dotted;
  background-color: #fff;
}

#input:hover {
  border: #409eff 2px dotted;
}

/deep/ .el-input {
  width: 80%;
}

/deep/ .el-input__inner {
  border-radius: 12px !important;
}

// /deep/.el-upload-list__item {
//   background-color: #ffffff;
//   font-size: 26px;
// }

// /deep/ .el-upload-list {
//   width: 96%;
//   margin: 0 2% 0 2%;
// }
</style>