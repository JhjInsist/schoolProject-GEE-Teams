<template>
  <div id="content">
    <div id="carousel">
      <el-carousel :interval="3000" type="card" height="300px">
        <el-carousel-item v-for="item in items" :key="item">
          <img :src="item" alt="">
        </el-carousel-item>
      </el-carousel>
    </div>
    <div id="table">
      <el-table :data="tableData" border style="width: 100%" stripe>
        <el-table-column prop="date" label="日期" width="180">
        </el-table-column>
        <el-table-column prop="name" label="院校名称" width="180">
        </el-table-column>
        <el-table-column prop="desc" label="概要">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-link type="primary" @click.prevent="review(scope.$index)">详情</el-link>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items:[
        'https://pic35.photophoto.cn/20150511/0034034892281415_b.jpg',
        'https://pic35.photophoto.cn/20150511/0034034892281415_b.jpg',
        'https://pic35.photophoto.cn/20150511/0034034892281415_b.jpg',
        'https://pic35.photophoto.cn/20150511/0034034892281415_b.jpg',
        'https://pic35.photophoto.cn/20150511/0034034892281415_b.jpg',
        'https://pic35.photophoto.cn/20150511/0034034892281415_b.jpg'
      ],
      tableData: [{
        date: '2016-05-02',
        name: '北京大学',
        desc: '这是一条概要1'
      }, {
        date: '2016-05-04',
        name: '清华大学',
        desc: '这是一条概要2'
      }, {
        date: '2016-05-01',
        name: '北京理工大学',
        desc: '这是一条概要3'
      }, {
        date: '2016-05-03',
        name: '四川大学',
        desc: '这是一条概要4'
      }, {
        date: '2016-05-01',
        name: '华南理工大学',
        desc: '这是一条概要5'
      }, {
        date: '2016-05-01',
        name: '厦门大学',
        desc: '这是一条概要6'
      }, {
        date: '2016-05-01',
        name: '东北大学',
        desc: '这是一条概要7'
      },
      {
        date: '2016-05-01',
        name: '大连理工大学',
        desc: '这是一条概要7'
      },
      {
        date: '2016-05-01',
        name: '厦门大学',
        desc: '这是一条概要7'
      },
      {
        date: '2016-05-01',
        name: '大连交通大学',
        desc: '这是一条概要7'
      },
      ]
    }
  },
  methods: {
    review(index) {
      console.log(index);
      window.open('https://element.eleme.io', '_blank');
    },
  },
}
</script>

<style scoped>
#content {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

#table {
  width: 90%;
  height: auto;
  padding: 0 5% 1% 5%;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  text-align: center;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>