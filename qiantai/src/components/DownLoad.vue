<template>
  <div id="content">
    <div v-if="show">
      <el-empty description="暂无资源可下载" :image-size="300">
        <el-button type="primary" @click="toLoad">去上传</el-button>
      </el-empty>
    </div>
    <el-table :data="tableData" style="width: 100%" v-if="!show">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="发件人">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="描述">
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
      <el-table-column label="描述" prop="desc">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="downLoad(scope.$index)" type="primary"><el-link :underline="false">下载</el-link></el-button>
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
      show: true,
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
    downLoad(index) {
      const h = this.$createElement;
      this.$notify({
        title: '提示',
        message: h('i', { style: 'color: teal' }, '下载成功'),
        type: 'success',
        duration: 1000
      });
    },
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
}
</style>