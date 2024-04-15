package com.example.qq.controller.subway;
import org.springframework.aop.scope.ScopedProxyUtils;

import java.util.*;

class Graph {
    private Map<String, List<Node>> adjList;
    private Map<String,Map<String,Integer>> mp;

    public Graph() {
        adjList = new HashMap<>();
        mp = new HashMap<>();
    }

    public void addEdge(String source, String destination, int weight,int type) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.get(source).add(new Node(destination, weight));
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(destination).add(new Node(source, weight)); // For undirected graph
//        System.out.println(source);
        mp.putIfAbsent(source,new HashMap<>());
        mp.get(source).put(destination,type);
        mp.putIfAbsent(destination,new HashMap<>());
        mp.get(destination).put(source,type);
    }

    public Integer gettype(String st,String end){
        return mp.get(st).get(end);
    }

    public List<String> shortestPath(String source, String destination) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Map<String,Boolean> st = new HashMap<>();
//        System.out.println(source);

        for (String vertex : adjList.keySet()) {
            distance.put(vertex, Integer.MAX_VALUE);
            st.put(vertex,false);
//            System.out.println(vertex);
//            if(vertex.equals("义堂站")){
//                for(Node node : adjList.get(vertex))
//                System.out.println(node.vertex);
//            }
//            System.out.println(adjList.get(vertex));
//            for(Node node : adjList.get(vertex))
//                System.out.println(node.vertex);
            parent.put(vertex, null);
        }

        distance.put(source, 0);
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            String u = pq.poll().vertex;
//            System.out.println(u);

            if(st.get(u) == true)
                continue;
            st.put(u,true);

            for (Node neighbor : adjList.get(u)) {
                String v = neighbor.vertex;
                int w = neighbor.weight;

                if (distance.get(u) + w < distance.get(v)) {
                    distance.put(v, distance.get(u) + w);
                    parent.put(v, u);
                    pq.offer(new Node(v, distance.get(v)));
                }
            }
        }
        List<String> path = new ArrayList<>();
        path = getPath(source, destination, parent);
        return path;
    }

    public List<String>getzhan(String stk){
        Set<String>set = new HashSet<>();
        List<String>ans = new ArrayList<>();
        for(Node x : adjList.get(stk)){
            set.add(mp.get(stk).get(x.vertex).toString());
        }
        for(String x : set){
            ans.add(x);
        }
        return ans;
    }

    public List<String> minselect(String source, String destination) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Map<String,Boolean> st = new HashMap<>();

        for (String vertex : adjList.keySet()) {
            distance.put(vertex, Integer.MAX_VALUE);
            st.put(vertex,false);
            parent.put(vertex, null);
        }

        distance.put(source, 0);
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            String u = pq.poll().vertex;

            if(st.get(u) == true)
                continue;
            st.put(u,true);

            for (Node neighbor : adjList.get(u)) {
                String v = neighbor.vertex;
                int w = 0;
                if(mp.containsKey(u) && mp.get(u).get(parent.get(u)) != mp.get(u).get(v)){
                    w = 1;
                }

                if (distance.get(u) + w < distance.get(v)) {
                    distance.put(v, distance.get(u) + w);
                    parent.put(v, u);
                    pq.offer(new Node(v, distance.get(v)));
                }
            }
        }
        List<String> path = new ArrayList<>();
        path = getPath(source, destination, parent);
        return path;
    }

    void dfs(String source,List<String> ans,Map<String,Boolean>st){
        st.put(source,true);
        ans.add(source);
        for(Node x : adjList.get(source)){
            if(!st.get(x.vertex)){
                dfs(x.vertex,ans,st);
                ans.add(source);
            }
        }
    }

    public List<String>traverseStations(String source){
        List<String>ans = new ArrayList<>();
        Map<String,Boolean>st = new HashMap<>();
        for (String vertex : adjList.keySet()) {
            st.put(vertex,false);
        }
        dfs(source,ans,st);
        return ans;
    }

    private List<String> getPath(String source, String destination, Map<String, String> parent) {
        List<String> path = new ArrayList<>();
        for (String at = destination; at != null; at = parent.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

//        System.out.println("Shortest path from " + source + " to " + destination + ": " + path);
        return path;
    }

    private static class Node {
        String vertex;
        int weight;


        public Node(String v, int w) {
            vertex = v;
            weight = w;
        }
    }
}

