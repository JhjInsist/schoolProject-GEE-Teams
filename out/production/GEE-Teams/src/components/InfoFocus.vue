<template>
  <div id="content">
    <div id="matchList">
      <el-collapse v-model="activeName" accordion>
        <el-collapse-item title="北京大学" name="1">
          <div>队长：小明</div>
          <div>联系方式：11111111111</div>
          <div>组队需求：高数很厉害</div>
        </el-collapse-item>
        <el-collapse-item title="清华大学" name="2">
          <div>队长：小红</div>
          <div>联系方式：66666666666</div>
          <div>组队需求：英语阅读做的好</div>
        </el-collapse-item>
        <el-collapse-item title="北京理工大学" name="3">
          <div>队长：小兰</div>
          <div>联系方式：66666666666</div>
          <div>组队需求：政治互相背</div>
        </el-collapse-item>
        <el-collapse-item title="四川大学" name="4">
          <div>队长：小军</div>
          <div>联系方式：66666666666</div>
          <div>组队需求：掌握院校信息</div>
        </el-collapse-item>
        <el-collapse-item title="华南理工大学" name="5">
          <div>队长：小李</div>
          <div>联系方式：66666666666</div>
          <div>组队需求：交流考研经验</div>
        </el-collapse-item>
        <el-collapse-item title="东北大学" name="6">
          <div>队长：小张</div>
          <div>联系方式：66666666666</div>
          <div>组队需求：交流专业课</div>
        </el-collapse-item>
        <el-collapse-item title="厦门大学" name="7">
          <div>队长：小王</div>
          <div>联系方式：66666666666</div>
          <div>组队需求：相互打卡学习</div>
        </el-collapse-item>
      </el-collapse>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeName: '1'
    };
  }
}
</script>

<style scoped lang="less">
#content {
  margin-top: 10px;
  width: 100%;
}

#matchList {
  width: 96%;
  margin: 0 1% 0 2%;
}

/deep/.el-collapse-item__header {
  padding-left: 1%;
  font-size: 16px;
  font-weight: 700;
}

/deep/.el-collapse-item__content {
  padding-left: 1%;
}
</style>