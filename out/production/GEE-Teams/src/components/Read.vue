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
        <!-- 插槽 -->
        <template slot-scope="scope">
          <el-button @click="unRead(scope.row.id)" type="primary">标记未读</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  created() {
    this.getTableList()
  },
  data() {
    return {
      show: false,
      tableData: [
        
      ],
    };
  },
  methods: {
    getTableList(){
      axios.get('/message/myMessage?readStatus=1').then(res => {
        console.log(res);
        this.tableData = res.data;
      }).catch(error => {
        this.$message.error("获取列表失败");
      })
    },
    // 未读：
    unRead(id) {
      axios.get("/message/read?id="+id+"&readStatus=0").then(res=>{
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
</style>