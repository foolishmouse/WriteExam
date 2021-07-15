package com.atguigu.kruskalCase;

public class Kruskal {

    public static void main(String[] args) {
        int[][] arr = {{0,6,14},{0,1,12},{1,2,10},{2,3,3},{3,4,4},{4,5,2},{5,6,9},{0,5,16},{1,5,7},{2,5,6},{2,4,5},{4,6,8}};
        int n=7;
        Kruskal kruskal = new Kruskal();
        int res = kruskal.Search(arr, n);
        System.out.println(res);
    }

    public int Search(int[][] arr, int n){
        EData[] eds = new EData[arr.length];
        for(int i=0; i<arr.length; i++){
            EData temp = new EData(arr[i][0], arr[i][1], arr[i][2]);
            eds[i] = temp;
        }

        sort(eds);

        int index=0;
        EData[] rets = new EData[arr.length];

        int[] ends = new int[n];
        for(int i=0; i<arr.length; i++){
            int p1 = eds[i].start;
            int p2 = eds[i].end;

            int x=getEnds(ends,p1);
            int y=getEnds(ends,p2);

            if(x!=y){
                ends[x] = y;
                rets[index++] = eds[i];
            }

        }

        for(int i=0; i<index; i++){
            System.out.printf(rets[i] + " "+rets[i].weight +" ");
        }

        return rets[0].start;

    }



public void sort(EData[] eds){
    for(int i=0; i<eds.length-1; i++){
        for(int j=0; j<eds.length-1-i;j++){
            if(eds[j].weight > eds[j+1].weight){
                EData temp = eds[j];
                eds[j] = eds[j+1];
                eds[j+1] = temp;
            }
        }
    }
}

public int getEnds(int[] ends, int i){
        while (ends[i] != 0){
            i=ends[i];
        }
        return i;
}

class EData{
    public int start;
    public int end;
    public int weight;

    public EData(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return start+ "<->" +end;
    }
}

}
