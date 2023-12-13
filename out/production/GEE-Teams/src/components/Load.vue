<template>
  <div id="content">
    <el-input v-model="da"></el-input>
    <el-upload class="upload-demo" ref="upload" action="https://jsonplaceholder.typicode.com/posts/" :file-list="fileList" :auto-upload="false">
      <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
      <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
      <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
    </el-upload>
  </div>
</template>

<script>
export default {
  data() {
    return {
      da: '',
      fileList: [{
        name: 'food.jpeg',
        url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
      }, {
        name: 'food2.jpeg',
        url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
      }]
    };
  },
  methods: {
    submitUpload() {
      if (this.$data.da === '') {
        console.log(11111);
        this.$refs.upload.submit();
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
    check() {
      console.log(111);
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