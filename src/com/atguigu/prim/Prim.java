package com.atguigu.prim;

public class Prim {

    public static void main(String[] args) {
        int[][] weight = new int[][]{
                {1000,5,7,1000,1000,1000,2},
                {5,1000,1000,9,1000,1000,3},
                {7,1000,1000,1000,8,1000,1000},
                {1000,9,1000,1000,1000,4,1000},
                {1000,1000,8,1000,1000,5,4},
                {1000,1000,1000,4,5,1000,6},
                {2,3,1000,1000,4,6,1000}};
        int verxs = 7;
        int v = 0;
        int res = Search(verxs, weight, v);
        System.out.println(res);
    }

    //修路最小路径问题  verxs表示顶点个数, weight表示路径长度， v表示从第几个顶点开始
    public static int Search(int verxs, int[][] weight, int v){
        int sum = 0;
        int visited[] = new int[verxs];
        for(int i=0; i<verxs; i++){
            visited[i] = 0;
        }
        visited[v] = 1;
        int h1 = -1;//记录两个顶点的下标
        int h2 = -1;
        int minWeight = 1000;
        for(int k=1; k<verxs; k++){//因为有verxs个顶点，需要确定verxs - 1条边
            for(int i=0; i<verxs; i++){
                for(int j=0; j<verxs; j++){
                    if(visited[i] == 1 && visited[j] == 0 && weight[i][j] < minWeight){
                        minWeight = weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println(h1+"->"+h2);
            sum += minWeight;
            visited[h2] = 1;
            minWeight = 1000;
        }
        return sum;
    }
}
