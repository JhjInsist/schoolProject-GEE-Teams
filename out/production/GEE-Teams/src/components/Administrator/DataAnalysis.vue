<template>
  <div class="echarts" ref="chart"></div>
</template>

<script>
import echarts from 'echarts/lib/echarts';
// 引入柱状图
export default {
  data() { return { chart: null } }, //图表实例
  mounted() { this.init() },
  methods: {
    init() {
      //2.初始化
      this.chart = echarts.init(this.$refs.chart);
      //3.配置数据
      let option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            crossStyle: {
              color: '#999'
            }
          }
        },
        toolbox: {
          feature: {
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ['line', 'bar'] },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        legend: {
          data: ['上传', '下载', '用户访问数']
        },
        xAxis: [
          {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            axisPointer: {
              type: 'shadow'
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '数量',
            min: 0,
            max: 250,
            interval: 50,
            axisLabel: {
              formatter: '{value}'
            }
          },
          {
            type: 'value',
            name: '用户访问数',
            min: 0,
            max: 25,
            interval: 5,
            axisLabel: {
              formatter: '{value}'
            }
          }
        ],
        series: [
          {
            name: '上传',
            type: 'bar',
            tooltip: {
              valueFormatter: function (value) {
                return value;
              }
            },
            data: [
              2, 5, 7, 23, 25, 76, 135, 162, 32, 20, 7, 4
            ]
          },
          {
            name: '下载',
            type: 'bar',
            tooltip: {
              valueFormatter: function (value) {
                return value;
              }
            },
            data: [
              3, 6, 9, 26, 29, 71, 176, 182, 49, 19, 6, 3
            ]
          },
          {
            name: '用户访问数',
            type: 'line',
            yAxisIndex: 1,
            tooltip: {
              valueFormatter: function (value) {
                return value;
              }
            },
            data: [2, 3, 3, 5, 6, 10, 20, 23, 23, 16, 12, 6]
          }
        ]
      };
      // 4.传入数据
      this.chart.setOption(option);
    }
  }
};
</script>

<style>
.echarts {
  height: 100%;
  width: 100%;
  background-color: #f5f5f5;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  /* border: red 1px solid; */
}
</style>