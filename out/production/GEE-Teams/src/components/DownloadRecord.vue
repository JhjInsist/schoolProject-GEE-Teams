<template>
  <div id="content">
    <div v-if="show">
      <el-empty description="暂无消息" :image-size="300">
      </el-empty>
    </div>
    <el-table :data="tableData" style="width: 100%" v-if="!show">
      <el-table-column prop="date" label="日期"></el-table-column>
      <el-table-column label="文件详情" href="#"><template slot-scope="scope">
          <el-link type="primary" @click.prevent="review(scope.$index)">预览</el-link>
        </template></el-table-column>
      <el-table-column prop="address" label="下载地址"></el-table-column>
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
export default {
  data() {
    return {
      show: false,
      tableData: [
        { date: '2022-01-01', address: '上海市' },
        { date: '2022-01-02', address: '上海市' },
        { date: '2022-01-03', address: '上海市' },
      ],
    };
  },
  methods: {
    handleDelete(index) {
      this.tableData.splice(index, 1);
    },
    review(index) {
      console.log(index);
      window.open('https://s1.ax1x.com/2023/03/05/ppExLLT.jpg', '_blank');
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