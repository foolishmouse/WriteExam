package com.atguigu.demo;

import java.util.*;
public class Main{
    private static int n;
    private static int m;
    private static int x0;
    private static int y0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            n=sc.nextInt();
            m=sc.nextInt();
            char[][] chars=new char[n][m];
            for(int i=0;i<n;i++){
                String strs=sc.next();
                chars[i]=strs.toCharArray();
            }
            x0=sc.nextInt();
            y0=sc.nextInt();
            int k=sc.nextInt();
            int[][] steps=new int[k][2];
            for(int i=0;i<k;i++){
                steps[i][0]=sc.nextInt();
                steps[i][1]=sc.nextInt();
            }
            int ret=-1;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    //起点需要排除，不然会影响最后的结果
                    if(i==x0&&j==y0) {
                        continue;
                    }
                    if(chars[i][j]=='.'){
                        int max=bfs(i,j,chars,steps);
                        //有无法到达的点，输出-1;
                        if(max==-1){
                            System.out.println(-1);
                            return;
                        }
                        //输出最大值
                        ret=Math.max(ret,max);
                    }
                }
            }
            System.out.println(ret);

            //System.out.println(max-1);

        }
    }
    //bfs遍历的模板
    public static int bfs(int ex,int ey,char[][] chars,int[][] steps){
        boolean[][] marked=new boolean[n][m];
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(x0,y0));
        marked[x0][y0]=true;
        int max=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            max++;
            while(size-- >0){
                Node node=queue.poll();
                int x=node.x;
                int y=node.y;
                marked[x][y]=true;
                for(int[] d:steps){
                    int nx=x+d[0];
                    int ny=y+d[1];
                    if(nx==ex&&ny==ey&&chars[nx][ny]=='.') {
                        return max;
                    }
                    if(nx>n-1||nx<0||ny>m-1||ny<0||chars[nx][ny]=='X'||marked[nx][ny]) {
                        continue;
                    }
                    queue.add(new Node(nx,ny));
                }

            }
        }
        return -1;

    }

}
class Node{
    int x;
    int y;
    public Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}