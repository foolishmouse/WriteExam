package com.atguigu.divide;


//循环赛制  输入：m 代表2^m个选手
public class Divide {

    public static void main(String[] args) {
        int m = 4;
        FenZhi(m);
    }

    public static void FenZhi(int m){
        int l = 2 << (m-1);
        int[][] arr = new int[l][l];
        int d = 1;
        arr[0][0] = 1;
        int count = 0;
        while(count < m){
            gen(arr, 0, 0, d);
            cpy(arr, 0,0,d,0+d,0+d);
            cpy(arr, 0,0+d,d,0+d,0);
            d = d * 2;
            count++;
        }
        show(arr);
    }

    public static void gen(int[][] arr, int x, int y, int d){
        for (int i = x; i < x+d; i++) {
            for(int j=y; j< y+d; j++){
             arr[i][j+d] = arr[i][j] + d;
            }
        }
    }

    public static void cpy(int[][] arr, int x1, int y1, int d, int x2, int y2){
        for(int i=0; i<d; i++){
            for(int j=0; j<d; j++){
                arr[x2+i][y2+j] = arr[x1+i][y1+j];
            }
        }
    }

    public static void show(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.printf(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
