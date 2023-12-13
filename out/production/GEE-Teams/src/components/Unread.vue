<template>
  <div id="content">
    <div v-if="show">
      <el-empty description="暂无消息" :image-size="300">
      </el-empty>
    </div>
    <el-table :data="tableData" style="width: 100%" v-if="!show">
      <el-table-column prop="senderName" label="发送人"></el-table-column>
      <el-table-column prop="content" label="消息"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="read(scope.row.id)" type="warning">标记已读</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      show: false,
      tableData: []
    }
  },
  created() {
    this.getTableList();
  },
  methods: {
    getTableList(){axios.get('/message/myMessage?readStatus=0').then(res => {
        console.log(res);
        this.tableData = res.data;
      }).catch(error => {
        this.$$message.error("获取列表失败");
      })
    },
   
    
    read(id) {
      axios.get("/message/read?id="+id+"&readStatus=1").then(res=>{
        if(res.data.status === "成功"){
          this.$message.success(res.data.msg);
          this.getTableList();
        }else{
          this.$message.error(res.data.msg)
        }
      }).catch(e=>{
        this.$message.error("error");
        console.log(e);
      })
    },
  },
  
}
</script>

<style scoped>
#content {
  height: 100%;
  width: 100%;
}

.demo-table-expand {
  font-size: 0;
  margin-left: 20px;
}

.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}

.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>