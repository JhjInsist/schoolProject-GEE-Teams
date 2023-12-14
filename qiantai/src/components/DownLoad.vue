<template>
  <div id="content">
    <div v-if="tableData.length === 0">
      <el-empty description="暂无资源可下载" :image-size="300">
        <el-button type="primary" @click="toLoad">去上传</el-button>
      </el-empty>
    </div>
    <el-table :data="tableData" style="width: 100%" v-if="tableData.length !== 0">
      <el-table-column label="文件名称" prop="title"></el-table-column>
      <el-table-column label="时间" prop="createTime"></el-table-column>
      <el-table-column label="描述" prop="description"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="downLoad(scope.$index)" type="primary">下载</el-button>
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
      userId:'',
      tableData: [{
        date: '12987122',
        name: '好滋好味鸡蛋仔',
        desc: '荷兰优质淡奶，奶香浓而不腻',
        detail: 'xiaoqingjianjijisgkghasdjk'
      }, {
        date: '12987123',
        name: '好滋好味鸡蛋仔',
        desc: '荷兰优质淡奶，奶香浓而不腻',
        detail: 'xiaoqingjianjijisgkghasdjk'
      }, {
        date: '12987123',
        name: '好滋好味鸡蛋仔',
        desc: '荷兰优质淡奶，奶香浓而不腻',
        detail: 'xiaoqingjianjijisgkghasdjk'
      }, {
        date: '12987123',
        name: '好滋好味鸡蛋仔',
        desc: '荷兰优质淡奶，奶香浓而不腻',
        detail: 'xiaoqingjianjijisgkghasdjk'
      }]
    }
  },
  methods: {

    toLoad() {
      this.$router.push({ path: '/resourcesload' })
    },
    downLoad(index)  {
       axios.post('/downloadRecord/add',{
         userId: this.userId,
         filePath: this.tableData[index].filePath,
         title: this.tableData[index].title,
         description: this.tableData[index].description,
      }).then(()=>{
         window.open(this.tableData[index].filePath, '_blank');
       })
    },
    loadData(){
      // 获取数据
      axios.get('/resource/list').then(res => {
        this.tableData = res.data.data;
        console.log(this.tableData)
      }).catch(()=>{
        this.$message.error("获取列表失败");
      })
    }
  },
  created() {
    this.userId = sessionStorage.getItem('userId');
    this.loadData()
  }
}
</script>

<style scoped lang="less">
#content {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}
</style>