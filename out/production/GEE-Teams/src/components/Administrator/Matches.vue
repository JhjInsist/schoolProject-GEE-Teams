<template>
  <div id="content">
    <div class="select">
      <div id="title">信息筛选</div>
      <div id="input"><el-input v-model="value1" placeholder="院校名称"></el-input></div>
      <div id="btn">
        <el-button @click="reData()" type="primary" round>清空</el-button>
        <el-button @click="filterData()" type="primary" round>搜索</el-button>
        <el-button @click="newTO()" type="primary" round>添加</el-button>
      </div>
    </div>
    <el-table :data="tableData" style="width: 100%" v-if="!show">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="院校名称">
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
      <el-table-column label="添加时间" prop="date">
      </el-table-column>
      <el-table-column label="院校名称" prop="name">
      </el-table-column>
      <el-table-column label="描述" prop="desc">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="handleDelete(scope.$index)" type="danger">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-empty el-empty description=" 暂无数据" :image-size="300" v-if="show">
    </el-empty>
  </div>
</template>

<script>
export default {
  data() {
    return {
      show: false,
      value1: [],
      matches: [{
        value: '北京大学',
        label: '北京大学'
      }, {
        value: '清华大学',
        label: '清华大学'
      }, {
        value: '北京理工大学',
        label: '北京理工大学'
      }, {
        value: '四川大学',
        label: '四川大学'
      }, {
        value: "华南理工大学",
        label: '华南理工大学'
      }],
      tableData: [],
      tableDataCopy: [],
    }
  },
  methods: {
    newTO() {
      this.$router.push({ path: '/adm-add' })
    },
    handleDelete(index) {
      this.tableData.splice(index, 1);
    },
    reData() {
      this.value1 = [];
      this.tableData = this.tableDataCopy;
      this.show = false;
    },
    filterData() {
      //
      console.log(this.value1);
      const val = this.value1;
      if (val == "北京大学") {
        this.show = false;
        this.tableData = [{
          date: '2021-10-10',
          name: '北京大学',
          desc: '北京大学是一所好大学',
          detail: '寻找一个同样考北京大学的同学'
        }]
      }
      else if (val == "清华大学") {
        this.flag = false;
        this.tableData = [{
          date: '2021-10-13',
          name: '清华大学',
          desc: '清华大学是一所好大学',
          detail: '寻找一个同样考北京大学的同学'
        },]
      } else if (val == "ACM") {
        this.show = false;
        this.tableData = [{
          date: '2021-10-14',
          name: '北京理工大学',
          desc: '北京理工大学是一所好大学',
          detail: '寻找一个同样考北京理工大学的同学'
        },]
      } else {
        this.show = true
      }
    }
  },
  mounted() {
    const info = [{
      date: '2021-10-10',
      name: '北京大学',
      desc: '北京大学是一所好大学',
      detail: '寻找一个同样考北京大学的同学'
    }, {
      date: '2021-10-13',
      name: '清华大学',
      desc: '清华大学是一所好大学',
      detail: '寻找一个同样考北京大学的同学'
    }, {
      date: '2021-10-14',
      name: '北京理工大学',
      desc: '北京理工大学是一所好大学',
      detail: '寻找一个同样考北京理工大学的同学'
    }, {
      date: '2021-10-15',
      name: '四川大学',
      desc: '四川大学是一所好大学',
      detail: '寻找一个同样考四川大学的同学'
    }];
    this.tableData = info;
    this.tableDataCopy = info;
  }
}
</script>

<style scoped lang="less">
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

.select {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
  width: 100%;
  height: aoto;
  padding: 10px 0 10px 0;
  border-bottom: 2px solid #e8e8e8;
  background-color: #fff;
}

#title {
  font-weight: 600;
  font-size: 14px;
  width: 10%;
  text-align: center;
}

#input {
  width: 20%;
}

#btn {
  width: 30%;

  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
}

/deep/ .el-input__inner {
  display: block !important;
  width: 100% !important;
  font-size: 15px !important;
  margin-left: 15%;
  outline: none !important;
}
</style>