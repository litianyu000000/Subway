import { createRouter, createWebHistory } from 'vue-router'
import FindWay from '../views/findway/FindWay'
import MainWay from '../views/findway/MainWay'
import SelectWay from '../views/findway/SelectWay'
import ShowWay from '../views/findway/ShowWay'

const routes = [
  {
    path:"/",
    name:"home",
    redirect:"/home/",
    component:MainWay,
    children:[
      {
        path:"/FindWay/",
        name:"FindWay",
        component:FindWay,
      },
      {
        path:"/SelectWay/",
        name:"SelectWay",
        component:SelectWay,
      },
      {
        path:"/ShowWay/",
        name:"ShowWay",
        component:ShowWay,
      },
    ]
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
