<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container">
        <router-link class="navbar-brand" :to="{name: 'FindWay'}">地铁主界面</router-link>
        <div class="collapse navbar-collapse" id="navbarText">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <router-link :class="route_name == 'FindWay' ? 'nav-link active' : 'nav-link'" :to="{name: 'FindWay'}">查询换乘</router-link>
            </li>
            <li class="nav-item">
              <router-link :class="route_name == 'SelectWay' ? 'nav-link active' : 'nav-link'" :to="{name: 'SelectWay'}">查询线路</router-link>
            </li>
            <li class="nav-item">
                <router-link :class="route_name == 'ShowWay' ? 'nav-link active' : 'nav-link'" :to="{name: 'ShowWay'}">查看地图</router-link>
              </li>
          </ul>
        </div>
      </div>
    </nav>
    <router-view></router-view>
    </template>
    
    <script>
    
    export default {
        setup() {
        }
    }
    </script>
    
    <style scoped>
    
    </style>
    