<template>
    <ContentField>
        <div class="card">
            <div class="card-body">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleFormControlTextarea1" class="form-label">输入起始站</label>
                        <textarea v-model="stk" class="form-control" id="exampleFormControlTextarea1" rows="1"></textarea>
                      </div>
                </div>
                <button type="button" class="btn btn-primary" @click="che()" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    遍历所有站点
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
                  <section>
                    <figure>
                        <img width="1000" src="@/assets/all.png" alt="0">
                        <!-- <figcaption>logo</figcaption> -->
                    </figure>
                </section>
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
        let stk = ref('');
        const che = () => {
            $.ajax({
            url: 'http://127.0.0.1:3000/getway/',
            method: 'get',
            // Headers:{
            //     Authorization: "Bearer " + store.state.user.token,
            // },
            data:{
                sta:"",
                end:"",
                category:"4",
                stk:stk.value,
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
            che,
            stk,
            infos,
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
  