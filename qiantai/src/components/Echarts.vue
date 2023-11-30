<template>
  <div class="echarts" ref="chart"></div>
</template>

<script>
import echarts from 'echarts/lib/echarts';

export default {
  data() { return { chart: null } }, //图表实例
  mounted() { this.init() },
  methods: {
    init() {
      //2.初始化
      this.chart = echarts.init(this.$refs.chart);
      //3.配置数据
      let option = {
        title: {
          text: '最近通知'
        },
        tooltip: {
          trigger: 'axis'
        },
        xAxis: { type: 'category', data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'], name: '日期' }, //X轴
        yAxis: { type: 'value', name: '消息数', interval: 2, min: 0, max: 10 }, //Y轴
        series: [{ data: [1, 4, 2, 6, 3, 2, 5], type: 'line' ,lineStyle:{color:'#1b813e'}}], //配置项
      };
      // 4.传入数据
      this.chart.setOption(option);
    }
  }
};
</script>

<style scoped>
.echarts {
  height: 35vh;
  width: auto;
  background-color: #f5f5f5;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  box-shadow: 10px 10px 20px rgb(170, 170, 170);
}
</style>