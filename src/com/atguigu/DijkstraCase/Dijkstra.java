package com.atguigu.DijkstraCase;
import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args) {
        int n =7;

        int[] vertex = new int[n];
        for(int i=0; i<n; i++){
            vertex[i] = i+1;
        }

        int[][] matrix = new int[n][n];
        final int N = 100;
        matrix[0] = new int[]{N,5,7,N,N,N,2};
        matrix[1] = new int[]{5,N,N,9,N,N,3};
        matrix[2] = new int[]{7,N,N,N,8,N,N};
        matrix[3] = new int[]{N,9,N,N,N,4,N};
        matrix[4] = new int[]{N,N,8,N,N,5,4};
        matrix[5] = new int[]{N,N,N,4,5,N,6};
        matrix[6] = new int[]{2,3,N,N,4,6,N};

        Graph graph = new Graph(vertex,matrix);
        graph.dsj(3);
        for(int i=0; i<graph.vv.dis.length; i++){
            System.out.printf(graph.vv.dis[i]+"\t");
        }
    }

}

class Graph{
     int[] vertex;
     int[][] matrix;
     VisitedVertex vv;

    public Graph(int[] vertex, int[][] matrix){
        this.vertex = vertex;
        this.matrix = matrix;
    }

    private void update(int index){
        int len = 0;
        for(int j=0; j<matrix[index].length;j++){
            len = vv.getDis(index) + matrix[index][j];
            if(!vv.in(j)&&len<vv.getDis(j)){
                vv.updatePre(j,index);
                vv.updateDis(j,len);
            }
        }
    }

    public void dsj(int index){
        vv = new VisitedVertex(vertex.length,index);
        update(index);
        for(int j=1; j<vertex.length; j++){
            index = vv.updateArr();
            update(index);
        }
    }

}

class VisitedVertex{
    public boolean[] already_arr;
    public int[] pre_visited;
    public int[] dis;

    public VisitedVertex(int length, int index){
        this.already_arr = new boolean[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];

        Arrays.fill(dis,100);
        this.already_arr[index] = true;
        this.dis[index]=0;
    }

    public boolean in(int index){
        return already_arr[index] == true;
    }

    public void updateDis(int index, int len){
        dis[index] = len;
    }

    public void updatePre(int pre, int index){
        pre_visited[pre] = index;
    }

    public int getDis(int index){
        return dis[index];
    }

    public int updateArr(){
        int min = 100;
        int index = 0;
        for(int i=0; i<already_arr.length; i++){
            if(already_arr[i]==false && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = true;
        return index;
    }

}
