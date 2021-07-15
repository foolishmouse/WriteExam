package com.atguigu.quickSort;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {5,6,2,8,7,1,0,3,4};
        quickSort quickSort = new quickSort();
        quickSort.quick(arr,0,arr.length-1);
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public void quick(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];
        int temp = 0;
        while (l<r){
            while(arr[l] < pivot){
                l += 1;
            }
            while (arr[r] > pivot){
                r -= 1;
            }

            if(l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == pivot){
                l += 1;
            }
            if(arr[r] == pivot){
                r -= 1;
            }

            if(l == r){
                l += 1;
                r += 1;
            }

            if(left < r){
                quick(arr,left,r);
            }
            if(right > l){
                quick(arr, l, right);
            }

        }
    }

}
