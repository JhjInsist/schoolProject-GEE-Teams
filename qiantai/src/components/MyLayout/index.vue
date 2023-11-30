<template>
  <el-container>
    <el-aside>
      <nav-menu></nav-menu>
    </el-aside>
  </el-container>
</template>

<script>
import NavMenu from './NavMenu'
export default {
  components: { NavMenu }
}
</script>

<style>
html,
body,
.el-container {
  padding: 0px !important;
  margin: 0px !important;
  height: 100vh;
}
</style>