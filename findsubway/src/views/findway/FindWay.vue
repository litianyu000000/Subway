<template>
    <ContentField>
        <div class="card">
            <div class="card-body">
                <div class="row justify-content-md-center">
                  <div class="col-5">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="exampleFormControlTextarea1" class="form-label">出发点</label>
                            <textarea v-model="sta" class="form-control" id="exampleFormControlTextarea1" rows="1"></textarea>
                          </div>
                        <div class="mb-3">
                            <label for="exampleFormControlTextarea1" class="form-label">目的地</label>
                            <textarea v-model="en" class="form-control" id="exampleFormControlTextarea1" rows="1"></textarea>
                          </div>
                    </div>
                    <div>
                      <input type="radio" id="最短路" value="1" v-model="category">
                      <label for="最短路">最短路</label>
                      <br>
                      <input type="radio" id="最小换乘" value="2" v-model="category">
                      <label for="最小换乘">最小换乘</label>
                  </div>
                    <button type="button" class="btn btn-primary" @click="che()" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                        查询
                      </button>
                      
                      <!-- Modal -->
                      <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <h1 class="modal-title fs-5" id="staticBackdropLabel">换乘信息</h1>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                              <td>
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>站点</th>
                                            <th>详情</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="info in infos" :key="info.id">
                                            <td>{{info.name}}</td>
                                            <td>{{info.content}}</td>
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
  
  export default {
    components: {
        ContentField
    },
    setup(){
        let infos = ref([]);
        let sta = ref('');
        let en = ref('');
        let category = ref('');
        const che = () => {
            $.ajax({
            url: 'http://127.0.0.1:3000/getway/',
            method: 'get',
            // Headers:{
            //     Authorization: "Bearer " + store.state.user.token,
            // },
            data:{
                sta:sta.value,
                end:en.value,
                category:category.value,
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
            infos,
            sta,
            en,
            category,
            che,
        }
    }
  }
  </script>
  
  <style scoped>
  button {
    width: 30%;
  }
  
  div.error-message {
    color: red;
  }
  
  </style>
  