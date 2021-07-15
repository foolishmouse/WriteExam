package com.atguigu.demo;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        if(m<n) {
            int temp = m;
            m = n;
            n = temp;
        }

        int t = gy(m,n);
        System.out.println("它们最大公约数为：" + t);
        System.out.println("它们最小公倍数为：" + m * n / t);
    }
    //      求最大公约数
    private static int gy(int m, int n) {
        if(m%n == 0) return n;
        return gy(n,m%n);
    }
}
