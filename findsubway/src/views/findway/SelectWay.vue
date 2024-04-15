<template>
    <ContentField>
        <div class="card">
            <div class="card-body">
                <div class="row justify-content-md-center">
                  <div class="col-5">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="exampleFormControlTextarea1" class="form-label">几号线（显示该线路所有站点）</label>
                            <textarea v-model="sta" class="form-control" id="exampleFormControlTextarea1" rows="1"></textarea>
                          </div>
                    </div>
                    <button type="button" class="btn btn-primary" @click="che()" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                        查询
                      </button>
                      
                      <!-- Modal -->
                      <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <h1 class="modal-title fs-5" id="staticBackdropLabel">线路信息</h1>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body" id="rrr">
                              <td>
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>站点</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="info in infos" :key="info.id">
                                            <td>{{info.name}}</td>
                                        </tr>
                                    </tbody>
                                </table>    
                            </td>
                            </div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
                            </div>
                          </div>
                        </div>
                      </div>



                      <div class="modal-body">
                        <div class="mb-3">
                            <label for="exampleFormControlTextarea1" class="form-label">站点信息（显示几号线经过该站）</label>
                            <textarea v-model="stk" class="form-control" id="exampleFormControlTextarea1" rows="1"></textarea>
                          </div>
                    </div>
                    <button type="button" class="btn btn-primary" @click="chi()" data-bs-toggle="modal" data-bs-target="#staticBackdrop1">
                        查询
                      </button>
                      
                      <!-- Modal -->
                      <div class="modal fade" id="staticBackdrop1" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <h1 class="modal-title fs-5" id="staticBackdropLabel">线路信息</h1>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body" id="rrr">
                              <td>
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>线路</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="info in infos" :key="info.id">
                                            <td>{{info.name}}</td>
                                        </tr>
                                    </tbody>
                                </table>    
                            </td>
                            </div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                </div>
            </div>
        </div>
        
    </ContentField>
  </template>
  
  <script>
  import ContentField from '../../components/ContentField.vue'
  import $ from 'jquery'
  import {ref } from 'vue'
//   import store from '@/store'
  
  export default {
    components: {
        ContentField
    },
    setup(){
        let infos = ref([]);
        let sta = ref('');
        let stk = ref('');
        let category = ref('');
        const che = () =>{
            $.ajax({
            url: 'http://127.0.0.1:3000/getxian/',
            method: 'get',
            // Headers:{
            //     Authorization: "Bearer " + store.state.user.token,
            // },
            data:{
                num:sta.value,
            },
            success(resp){
                infos.value=resp;
                console.log(resp);
            },
            error(resp){
                console.log(resp);
            }
        });
        };
        const chi = () => {
            $.ajax({
            url: 'http://127.0.0.1:3000/getway/',
            method: 'get',
            // Headers:{
            //     Authorization: "Bearer " + store.state.user.token,
            // },
            data:{
                sta:"",
                end:"",
                stk:stk.value,
                category:"3",
            },
            success(resp){
                infos.value=resp;
                console.log(resp);
            },
            error(resp){
                console.log(resp);
            }
        });
        }
        return {
            sta,
            infos,
            che,
            chi,
            category,
            stk,
        }
    }
  }
  
  </script>
  
  <style scoped>
  button {
    width: 20%;
  }
  
  div.error-message {
    color: red;
  }
  
  </style>
  