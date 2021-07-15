package com.atguigu.GongYSBS;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if(m<n) {
            int temp = m;
            m = n;
            n = temp;
        }
        int gys = GYS(m, n);
        int gbs = GBS(m, n);
        System.out.println("公约数："+gys);
        System.out.println("公倍数："+gbs);
    }

    public static int GYS(int m, int n){
        while (m%n!=0){
            int temp = m%n;
            m = n;
            n = temp;
        }
        return n;
    }

    public static int GBS(int m, int n){
        int gys = GYS(m, n);
        return m*n/gys;
    }

}


