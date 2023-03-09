package algorithm;

import java.util.Arrays;

public class MergeSort {
    public static void sort(Object[] arr) {
        divide(arr, 0, arr.length - 1);
    }

    private static void divide(Object[] arr, int left, int right) {
        int mid;
        if (left < right) {
            mid = (right + left) / 2;
            divide(arr, left, mid);
            divide(arr, mid + 1, right);
            conquer(arr, left, mid, right);
        }

    }

    @SuppressWarnings({"unchecked","rawtypes"})
    private static void conquer(Object[] arr, int left, int mid, int right) {
        Object[] sortedArr = new Object[arr.length];
        int i, j, k, l;
        i = left;
        j = mid+1;
        k = left;
        while(i<=mid&&j<=right){
            if(((Comparable)arr[i]).compareTo(arr[j])<=0)
                sortedArr[k++] = arr[i++];
            else
                sortedArr[k++] = arr[j++];
        }
        if(i>mid){
            for(l=j; l<=right; l++)
                sortedArr[k++] = arr[l];
        }
        // 남아 있는 값들을 일괄 복사
        else{
            for(l=i; l<=mid; l++)
                sortedArr[k++] = arr[l];
        }

        // 배열 sorted[](임시 배열)의 리스트를 배열 list[]로 재복사
        for(l=left; l<=right; l++){
            arr[l] = sortedArr[l];
        }
    }
}
