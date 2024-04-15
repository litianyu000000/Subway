package com.example.qq.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Temp {
    int id;
    String name;
    String content;
    public Temp(int a,String b,String c){
        id = a;
        name = b;
        content = c;
    }
}
