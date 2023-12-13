<template>
  <div id="content">
    <div v-if="show">
      <el-empty description="暂无消息" :image-size="300">
      </el-empty>
    </div>
    <el-table :data="tableData" style="width: 100%" v-if="!show">
      <el-table-column prop="date" label="日期"></el-table-column>
      <el-table-column prop="name" label="用户名"></el-table-column>
      <el-table-column prop="desc" label="类别"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="handleDelete(scope.$index)" type="primary">标记成未处理</el-button>
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
        { date: '2022-01-01', name: '张三', desc: '软件闪退' },
        { date: '2022-01-02', name: '李四', desc: '软件闪退' },
        { date: '2022-01-03', name: '王五', desc: '软件闪退' },
      ],
    };
  },
  methods: {
    handleDelete(index) {
      this.tableData.splice(index, 1);
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