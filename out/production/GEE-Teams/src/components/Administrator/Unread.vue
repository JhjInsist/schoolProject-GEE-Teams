<template>
  <div id="content">
    <div v-if="show">
      <el-empty description="暂无消息" :image-size="300">
      </el-empty>
    </div>
    <el-table :data="tableData" style="width: 100%" v-if="!show">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="用户名">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="类别">
              <span>{{ props.row.desc }}</span>
            </el-form-item>
            <el-form-item label="详情">
              <span>{{ props.row.detail }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column label="时间" prop="date">
      </el-table-column>
      <el-table-column label="发件人" prop="name">
      </el-table-column>
      <el-table-column label="类别" prop="desc">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="handleDelete(scope.$index)" type="danger">删除</el-button>
          <el-button @click="handleDelete(scope.$index)" type="primary">已处理</el-button>
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
      tableData: [{
        date: '2022-01-01',
        name: '张山',
        desc: '无法打开',
        detail: 'xiaoqingjianjijisgkghasdjk'
      }, {
        date: '2022-01-02',
        name: '王五',
        desc: '软件闪退',
        detail: 'xiaoqingjianjijisgkghasdjk'
      }, {
        date: '2022-01-03',
        name: '坤坤',
        desc: '缺少院校',
        detail: 'xiaoqingjianjijisgkghasdjk'
      }, {
        date: '2022-01-04',
        name: '艾坤',
        desc: '缺少院校',
        detail: 'xiaoqingjianjijisgkghasdjk'
      }]
    }
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