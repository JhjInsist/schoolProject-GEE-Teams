<template>
  <div id="content">
    <div id="userload">
      <div id="title">上传文件</div>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="date" label="日期"></el-table-column>
        <el-table-column prop="name" label="用户名"></el-table-column>
        <el-table-column prop="address" label="上传地址"></el-table-column>
        <el-table-column prop="detail" label="文件详情">
          <template slot-scope="scope">
            <el-link type="primary" @click.prevent="review(scope.$index)">预览</el-link>
          </template></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button @click="downLoad(scope.$index)" type="primary">下载</el-button>
            <el-button @click="handleDelete(scope.$index)" type="danger">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-upload class="upload-demo" drag action="https://jsonplaceholder.typicode.com/posts/" multiple show-file-list :on-success="success" :on-remove="remove">
      <i class="el-icon-upload"></i>
      <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
      <div class="el-upload__tip" slot="tip">文件大小不超过500kb</div>
    </el-upload>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [
        { date: '2022-01-01', name: '张三', address: '北京市', detail: '详情' },
        { date: '2022-01-02', name: '李四', address: '上海市', detail: '详情' },
        { date: '2022-01-03', name: '王五', address: '广州市', detail: '详情' },
      ],
    }
  },
  methods: {
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
    handleDelete(index) {
      this.tableData.splice(index, 1);
    },
    review(index) {
      console.log(index);
      window.open('https://s1.ax1x.com/2023/03/05/ppExLLT.jpg', '_blank');
    },
    downLoad(index) {
      console.log(index);
    }
  },
}
</script>

<style scoped lang="less">
#content {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  /* background-color: red; */
}

#userload {
  width: 100%;
}

#title {
  width: 95%;
  height: 30px;
  background-color: #ffffff;
  border-bottom: 1px #ebeef5 solid;
  text-align: center;
  line-height: 30px;
}

.upload-demo {
  margin-top: 10px;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}


/deep/.el-upload-list__item {
  background-color: #ffffff;
  font-size: 26px;
}

/deep/ .el-upload-list {
  width: 96%;
  margin: 0 2% 0 2%;
}
</style>