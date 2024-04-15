<template>
  <div id="app">
  <!-- <NavBar /> -->
  <router-view></router-view>
  </div>
</template>

<script>
// import NavBar from './components/NavBar.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"

export default {
  components: {
    // NavBar
  },
  setup() {
  }
}
</script>

<style>
body {
  background-image: url("@/assets/back.png");
  background-size: 10%;
}
</style>
