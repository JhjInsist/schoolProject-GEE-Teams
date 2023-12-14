<template>
  <div id="content">
    <div v-if="tableData.length === 0">
      <el-empty description="暂无消息" :image-size="300">
      </el-empty>
    </div>
    <el-table :data="tableData" style="width: 100%" v-if="tableData.length !== 0">
      <el-table-column label="文件名称" prop="title"></el-table-column>
      <el-table-column label="时间" prop="downloadTime"></el-table-column>
      <el-table-column label="描述" prop="description"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary">下载</el-button>
          <el-button @click="handleDelete(scope.$index)" type="danger">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      show: false,
      tableData: [
      ],
    };
  },
  methods: {
    handleDelete(index) {
      // 获取数据
      axios.post('/downloadRecord/delete',{
        userId:sessionStorage.getItem('userId'),
        id:this.tableData[index].id
      }).then(res => {
        this.loadData();
      }).catch(()=>{
        this.$message.error("获取列表失败");
      })
    },
    review(index) {
      window.open(this.tableData[index].filePath, '_blank');
    },
    loadData(){
      // 获取数据
      axios.get('/downloadRecord/list?userId='+sessionStorage.getItem('userId')).then(res => {
        this.tableData = res.data.data;
      }).catch(()=>{
        this.$message.error("获取列表失败");
      })
    }
  },
  created() {

    this.loadData()
  }
}
</script>

<style scoped>
#content {
  height: 100%;
  width: 100%;
}
</style>