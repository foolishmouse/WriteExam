package com.atguigu.FloydCase;

import java.util.Arrays;

public class Floyd {

    public static void main(String[] args) {
        int n =7;

        int[] vertex = new int[n];
        for(int i=0; i<n; i++){
            vertex[i] = i+1;
        }

        int[][] matrix = new int[n][n];
        final int N = 100;
        matrix[0] = new int[]{0,5,7,N,N,N,2};
        matrix[1] = new int[]{5,0,N,9,N,N,3};
        matrix[2] = new int[]{7,N,0,N,8,N,N};
        matrix[3] = new int[]{N,9,N,0,N,4,N};
        matrix[4] = new int[]{N,N,8,N,0,5,4};
        matrix[5] = new int[]{N,N,N,4,5,0,6};
        matrix[6] = new int[]{2,3,N,N,4,6,0};

        Graph graph = new Graph(vertex.length,matrix,vertex);

        graph.algorithm();

        for(int i=0; i<graph.dis.length; i++){
            for(int j=0; j<graph.dis[i].length; j++){
                System.out.printf(graph.dis[i][j]+"\t");
            }
            System.out.println();
        }
    }

}

class Graph{
    public int[] vertex;
    public int[][] dis;
    public int[][] pre;

    public Graph(int length, int[][] matrix, int[] vertex){
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];

        for(int i=0; i<length; i++){
            Arrays.fill(pre[i],i);
        }
    }

    public void algorithm(){
        int len = 0;
        for(int k=0; k<dis.length; k++){
            for(int i=0; i<dis.length; i++){
                for(int j=0; j<dis.length; j++){
                    len = dis[i][k] + dis[k][j];
                    if(len < dis[i][j]){
                        dis[i][j]=len;
                        pre[i][j]=pre[k][j];
                    }
                }
            }
        }
    }

}
