<template>
  <div id="content">
    <div class="header">
      <div class="left">
        <div id="title">小队总数</div>
        <div id="left" ref="chartL"></div>
      </div>
      <div id="right" ref="chartR"></div>
    </div>
    <div class="center">
      <div id="cl">
        <div id="centerL" ref="chartCL"></div>
        <div id="name">参与人数</div>
      </div>
      <div id="centerR" ref="chartCR"></div>
    </div>
    <div id="bottom" ref="chartB"></div>
  </div>
</template>

<script>
import echarts from 'echarts/lib/echarts';
import 'echarts/lib/chart/line';
import 'echarts/lib/chart/pie';
import 'echarts/lib/chart/bar';
import 'echarts/lib/component/title';
import 'echarts/lib/component/tooltip';
export default {
  data() { return { chartL: null, chartR: null, chartCL: null, chartCR: null, chartB: null } }, //图表实例
  mounted() { this.initL(); this.initR(), this.initCL(), this.initCR(), this.initB() },
  methods: {
    initL() {
      //2.初始化
      this.chartL = echarts.init(this.$refs.chartL);
      //3.配置数据
      let option = {
        title: {
          text: ''
        },
        tooltip: {},
        legend: {
          data: ['北京大学', '清华大学', '北京邮电大学', '四川大学', '华南理工大学']
        },
        series: [{
          name: '院校名称',
          type: 'pie',
          radius: '55%',
          data: [
            { value: 235, name: '北京大学' },
            { value: 274, name: '清华大学' },
            { value: 310, name: '北京邮电大学' },
            { value: 335, name: '四川大学' },
            { value: 400, name: '华南理工大学' }
          ]
        }]
      };
      // 4.传入数据
      this.chartL.setOption(option);
    },
    initR() {
      //2.初始化
      this.chartR = echarts.init(this.$refs.chartR);
      //3.配置数据
      let option = {
        title: {
          text: '活跃用户数'
        },
        grid: {
          left: '10%',
          right: '10%',
          bottom: '10%',
          top: '25%',
        },
        tooltip: {
          trigger: 'axis'
        },
        xAxis: { type: 'category', data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'], name: '日期' }, //X轴
        yAxis: { type: 'value', name: '用户数/千', interval: 2, min: 0, max: 10 }, //Y轴
        series: [{
          data: [1, 4, 2, 6, 3, 2, 5], type: 'line', lineStyle: {
            color: '#2aaaef'
          }
        }], //配置项
      };
      // 4.传入数据
      this.chartR.setOption(option);
    },
    initCL() {
      //2.初始化
      this.chartCL = echarts.init(this.$refs.chartCL);
      //3.配置数据
      let option = {
        title: {
          text: ''
        },
        grid: {
          left: '10%',
          right: '10%',
          bottom: '10%',
          top: '10%',
        },
        tooltip: {},
        xAxis: {
          type: 'category',
          data: ['北京大学', '清华大学', '北京理工大学', '四川大学', '华南理工大学',]
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: [
              {
                value: 120,
                itemStyle: {
                  color: '#63b2ee'
                }
              },
              {
                value: 200,
                itemStyle: {
                  color: '#76da91'
                }
              },
              {
                value: 150,
                itemStyle: {
                  color: '#f8cb7f'
                }
              },
              {
                value: 80,
                itemStyle: {
                  color: '#f89588'
                }
              },
              {
                value: 70,
                itemStyle: {
                  color: '#7cd6cf '
                }
              },
            ],
            type: 'bar'
          }
        ]
      };
      // 4.传入数据
      this.chartCL.setOption(option);
    },
    initCR() {
      //2.初始化
      this.chartCR = echarts.init(this.$refs.chartCR);
      //3.配置数据
      let option = {
        title: {
          text: '访问量'
        },
        grid: {
          left: '10%',
          right: '10%',
          bottom: '10%',
          top: '25%',
        },
        tooltip: {
          trigger: 'axis'
        },
        xAxis: { type: 'category', data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'], name: '日期' }, //X轴
        yAxis: { type: 'value', name: '访问量/万', interval: 2, min: 0, max: 10 }, //Y轴
        series: [{
          data: [3, 8, 9, 4, 2, 6, 5], type: 'line', lineStyle: {
            color: '#9489fa'
          }
        }], //配置项
      };
      // 4.传入数据
      this.chartCR.setOption(option);
    },
    initB() {
      //2.初始化
      this.chartB = echarts.init(this.$refs.chartB);
      //3.配置数据
      let option = {
        title: {
          text: '用户反馈数'
        },
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        grid: {
          left: '10%',
          right: '10%',
          bottom: '10%',
          top: '25%',
        },
        tooltip: { trigger: 'axis' },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: [220, 432, 901, 934, 1290, 1130, 520],
            type: 'line',
            smooth: true,
            lineStyle: {
              color: '#f49495'
            }
          }
        ]
      };
      // 4.传入数据
      this.chartB.setOption(option);
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
  justify-content: space-evenly;
  align-items: center;
}

.header {
  width: 100%;
  /* height: 250px; */
  height: 30%;
  display: flex;
  justify-content: space-evenly;
  /* align-items: center; */
  margin-top: 1%;
}

.left {
  width: 45%;
  height: 100%;
  background-color: #fff;
  display: flex;
  justify-content: space-evenly;
}

#title {
  width: 3%;
  height: 90%;
  margin-top: 2%;
  font-weight: 600;
  /* background-color: aqua; */
}

#left {
  width: 90%;
  height: 100%;
  /* height: 250px; */
  background-color: #fff;
}

#right {
  width: 45%;
  height: 100%;
  /* height: 250px; */
  background-color: #fff;
}

.center {
  margin: 1% 2.5% 0 2.5%;
  width: 100%;
  /* height: 200px; */
  height: 30%;
  display: flex;
  justify-content: space-evenly;
}

#cl {
  width: 45%;
  height: 100%;
  background-color: #fff;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  font-weight: 600;
}

#centerL {
  height: 95%;
  width: 100%;
  background-color: #fff;
}

#centerR {
  height: 100%;
  width: 45%;
  background-color: #fff;
}

#bottom {
  margin: 1% 2.5% 0 2.5%;
  width: 95%;
  /* height: 220px; */
  height: 30%;
  background-color: #fff;
}
</style>