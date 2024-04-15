package com.example.qq.controller.subway;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.qq.controller.user.account.LoginController;
import com.example.qq.pojo.Temp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GetAll {
    Graph graph = new Graph();
    Boolean f = false;

    @GetMapping("/getxian/")
    public List<Temp>getxi(@RequestParam Map<String,String>mp){
        List<Temp>list = new ArrayList<>();
        String type = mp.get("num");
        if(type.equals("1")){
            list.add(new Temp(1,"西王站",""));
            list.add(new Temp(2,"北国商城站",""));
            list.add(new Temp(3,"建和桥站",""));
            list.add(new Temp(4,"北京站",""));
            list.add(new Temp(5,"澳大利亚站",""));
            list.add(new Temp(6,"火星站",""));
            list.add(new Temp(7,"巴中站",""));
            list.add(new Temp(8,"福州站",""));
            list.add(new Temp(9,"桂林站",""));
            list.add(new Temp(10,"天安站",""));
            list.add(new Temp(11,"长春站",""));
        }else if(type.equals("2")){
            list.add(new Temp(1,"长安公园站",""));
            list.add(new Temp(2,"杭州站",""));
            list.add(new Temp(3,"广州站",""));
            list.add(new Temp(4,"澳大利亚站",""));
            list.add(new Temp(5,"吉林站",""));
            list.add(new Temp(6,"美国站",""));
            list.add(new Temp(7,"非洲站",""));
            list.add(new Temp(8,"神界",""));
        }else if(type.equals("3")){
            list.add(new Temp(1,"新百广场站",""));
            list.add(new Temp(2,"时光街站",""));
            list.add(new Temp(3,"和平医院站",""));
            list.add(new Temp(4,"解放广场站",""));
            list.add(new Temp(5,"长白山站",""));
            list.add(new Temp(6,"杭州站",""));
            list.add(new Temp(7,"北京站",""));
            list.add(new Temp(8,"石家庄站",""));
            list.add(new Temp(9,"东王站",""));
            list.add(new Temp(10,"义庄站",""));
        } else if (type.equals("4")) {
            list.add(new Temp(1,"郑州站",""));
            list.add(new Temp(2,"吉安站",""));
            list.add(new Temp(3,"西安站",""));
            list.add(new Temp(4,"商洛站",""));
            list.add(new Temp(5,"昆明站",""));
            list.add(new Temp(6,"长沙站",""));
            list.add(new Temp(7,"襄阳站",""));
            list.add(new Temp(8,"热河站",""));
            list.add(new Temp(9,"衡阳站",""));
            list.add(new Temp(10,"福州站",""));
            list.add(new Temp(11,"淮南站",""));
            list.add(new Temp(12,"开封站",""));
            list.add(new Temp(13,"斗气大陆站",""));
            list.add(new Temp(14,"北青站",""));
            list.add(new Temp(15,"群马站",""));
        }else if (type.equals("5")){
            list.add(new Temp(1,"延安站",""));
            list.add(new Temp(2,"商洛站",""));
            list.add(new Temp(3,"苏州站",""));
            list.add(new Temp(4,"无锡站",""));
            list.add(new Temp(5,"南宁站",""));
            list.add(new Temp(6,"重庆站",""));
            list.add(new Temp(7,"澳门站",""));
            list.add(new Temp(8,"南昌站",""));
            list.add(new Temp(9,"热河站",""));
            list.add(new Temp(10,"长白山站",""));
        } else if (type.equals("6")) {
            list.add(new Temp(1,"丰台站",""));
            list.add(new Temp(2,"商洛站",""));
            list.add(new Temp(3,"襄阳站",""));
            list.add(new Temp(4,"重庆站",""));
            list.add(new Temp(5,"桂林站",""));
            list.add(new Temp(6,"合肥站",""));
            list.add(new Temp(7,"淮南站",""));
            list.add(new Temp(8,"兰州站",""));
            list.add(new Temp(9,"枣庄站",""));
            list.add(new Temp(10,"遵义站",""));
            list.add(new Temp(11,"神界",""));

        } else if (type.equals("7")) {
            list.add(new Temp(1,"东京站",""));
            list.add(new Temp(2,"徐州站",""));
            list.add(new Temp(3,"遵义站",""));
            list.add(new Temp(4,"淮南站",""));
            list.add(new Temp(5,"盐城站",""));
            list.add(new Temp(6,"天安站",""));
            list.add(new Temp(7,"中州站",""));
            list.add(new Temp(8,"山梨站",""));
            list.add(new Temp(9,"宁波站",""));
            list.add(new Temp(10,"群山站",""));
            list.add(new Temp(11,"南通站",""));
            list.add(new Temp(12,"首尔站",""));
            list.add(new Temp(13,"仙台站",""));
            list.add(new Temp(14,"长春站",""));
        }else {
            list.add(new Temp(1,"泉州站",""));
            list.add(new Temp(2,"合肥",""));
            list.add(new Temp(3,"天安站",""));
            list.add(new Temp(4,"星域",""));
            list.add(new Temp(5,"斗气大陆站",""));
            list.add(new Temp(6,"徐州站",""));
            list.add(new Temp(7,"神界",""));
            list.add(new Temp(8,"澳大利亚站",""));
            list.add(new Temp(9,"石家庄站",""));
        }
        return list;
    }
    @GetMapping("/getway/")
    public List<Temp>getw(@RequestParam Map<String,String>mp){
        String st = mp.get("sta");
        String end = mp.get("end");
        String ft = mp.get("category");
//        System.out.println(f);
        if(!f){
            f = true;
            graph.addEdge("西王站","北国商城站",1,1);
            graph.addEdge("北国商城站","建和桥站",1,1);
            graph.addEdge("建和桥站","北京站",1,1);
            graph.addEdge("北京站","石家庄站",1,2);
            graph.addEdge("北京站","杭州站",1,2);
            graph.addEdge("北京站","澳大利亚站",1,1);
            graph.addEdge("澳大利亚站","吉林站",1,3);
            graph.addEdge("澳大利亚站","广州站",1,3);
            graph.addEdge("澳大利亚站","火星站",1,1);
            graph.addEdge("新百广场站","时光街站",1,2);
            graph.addEdge("时光街站","和平医院站",1,2);
            graph.addEdge("和平医院站","解放广场站",1,2);
            graph.addEdge("解放广场站","长白山站",1,2);
            graph.addEdge("长白山站","杭州站",1,2);
            graph.addEdge("杭州站","长安公园站",1,3);
            graph.addEdge("杭州站","广州站",1,3);
            graph.addEdge("石家庄站","东王站",1,2);
            graph.addEdge("东王站","义堂站",1,2);
            graph.addEdge("吉林站","美国站",1,3);
            graph.addEdge("美国站","非洲站",1,3);
            graph.addEdge("非洲站","神界",1,3);
            graph.addEdge("火星站","巴中站",1,1);
            graph.addEdge("巴中站","福州站",1,1);
            graph.addEdge("福州站","桂林站",1,1);
            graph.addEdge("桂林站","天安站",1,1);
            graph.addEdge("天安站","长春站",1,1);
            graph.addEdge("郑州站","吉安站",1,4);
            graph.addEdge("吉安站","西安站",1,4);
            graph.addEdge("西安站","商洛站",1,4);
            graph.addEdge("商洛站","昆明站",1,4);
            graph.addEdge("昆明站","长沙站",1,4);
            graph.addEdge("长沙站","襄阳站",1,4);
            graph.addEdge("襄阳站","热河站",1,4);
            graph.addEdge("热河站","衡阳站",1,4);
            graph.addEdge("衡阳站","福州站",1,4);
            graph.addEdge("福州站","淮南站",1,4);
            graph.addEdge("淮南站","开封站",1,4);
            graph.addEdge("开封站","斗气大陆站",1,4);
            graph.addEdge("斗气大陆站","北青站",1,4);
            graph.addEdge("北青站","群马站",1,4);
            graph.addEdge("延安站","商洛站",1,5);
            graph.addEdge("商洛站","苏州站",1,5);
            graph.addEdge("苏州站","无锡站",1,5);
            graph.addEdge("无锡站","南宁站",1,5);
            graph.addEdge("南宁站","重庆站",1,5);
            graph.addEdge("重庆站","澳门站",1,5);
            graph.addEdge("澳门站","南昌站",1,5);
            graph.addEdge("南昌站","热河站",1,5);
            graph.addEdge("热河站","长白山站",1,5);
            graph.addEdge("丰台站","商洛站",1,6);
            graph.addEdge("商洛站","襄阳站",1,6);
            graph.addEdge("襄阳站","重庆站",1,6);
            graph.addEdge("重庆站","桂林站",1,6);
            graph.addEdge("桂林站","合肥站",1,6);
            graph.addEdge("合肥站","淮南站",1,6);
            graph.addEdge("淮南站","兰州站",1,6);
            graph.addEdge("兰州站","枣庄站",1,6);
            graph.addEdge("枣庄站","遵义站",1,6);
            graph.addEdge("遵义站","神界",1,6);
            graph.addEdge("东京站","徐州站",1,7);
            graph.addEdge("徐州站","遵义站",1,7);
            graph.addEdge("遵义站","淮南站",1,7);
            graph.addEdge("淮南站","盐城站",1,7);
            graph.addEdge("盐城站","天安站",1,7);
            graph.addEdge("天安站","中州站",1,7);
            graph.addEdge("中州站","山梨站",1,7);
            graph.addEdge("山梨站","宁波站",1,7);
            graph.addEdge("宁波站","群山站",1,7);
            graph.addEdge("群山站","南通站",1,7);
            graph.addEdge("南通站","首尔站",1,7);
            graph.addEdge("首尔站","仙台站",1,7);
            graph.addEdge("仙台站","长春站",1,7);
            graph.addEdge("泉州站","合肥站",1,8);
            graph.addEdge("合肥站","天安站",1,8);
            graph.addEdge("天安站","星域",1,8);
            graph.addEdge("星域","斗气大陆站",1,8);
            graph.addEdge("斗气大陆站","徐州站",1,8);
            graph.addEdge("徐州站","神界",1,8);
            graph.addEdge("神界","澳大利亚站",1,8);
            graph.addEdge("澳大利亚站","石家庄站",1,8);

        }
//        System.out.println(st);
//        System.out.println(end);
        List<String>list = new ArrayList<>();
        if(ft.equals("1")){
            list = graph.shortestPath(st,end); // 最短路
        }else if (ft.equals("2")){
            list = graph.minselect(st,end); // 最小换乘
        }else if(ft.equals("3")){ // 返回该站点的线路信息
            String stk = mp.get("stk");
            list = graph.getzhan(stk);
            List<Temp>ans = new ArrayList<>();
            for(int i = 0;i < list.size();i ++){
                ans.add(new Temp(i,list.get(i),""));
            }
            return ans;
        }else { // 返回遍历所有站点信息
            String stk = mp.get("stk");
            st = stk;
            list = graph.traverseStations(stk);
        }
        List<Temp>ans = new ArrayList<>();
        System.out.println(list);
        Integer pre = graph.gettype(st,list.get(1));
        for (int i = 1;i < list.size();i ++){
            Integer t = graph.gettype(list.get(i),list.get(i - 1));
            if(pre != t){
                ans.add(new Temp(i,list.get(i - 1),"换乘" + t + "号线地铁"));
                pre = t;
            }else{
                ans.add(new Temp(i,list.get(i - 1),"乘坐" + t + "号线地铁"));
            }
        }
        ans.add(new Temp(list.size(),list.get(list.size() - 1),"到达"));
        ans.add(new Temp(list.size() + 1,"到达","经过" + list.size() + "站到达"));
        return ans;
    }
}
