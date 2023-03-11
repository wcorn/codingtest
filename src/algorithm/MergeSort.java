package algorithm;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort {
    //객체 비교할 sort
    public static <T> void sort(T[] a, Comparator<? super T> c) {
            ComparatorSort(a, c);
    }

    //단순 데이터 sort
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

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void conquer(Object[] arr, int left, int mid, int right) {
        Object[] sortedArr = new Object[arr.length];

        int i, j, k, l;
        i = left;
        j = mid + 1;
        k = left;

        //두배열 중 하나가 빌때까지 두 배열 비교해서 작은값 정렬된 배열에 넣기
        while (i <= mid && j <= right) {
            if (((Comparable) arr[i]).compareTo(arr[j]) <= 0)
                sortedArr[k++] = arr[i++];
            else
                sortedArr[k++] = arr[j++];
        }
        // 남아 있는 값들을 일괄 복사
        if (i > mid) {
            for (l = j; l <= right; l++)
                sortedArr[k++] = arr[l];
        }
        // 남아 있는 값들을 일괄 복사
        else {
            for (l = i; l <= mid; l++)
                sortedArr[k++] = arr[l];
        }

        // 배열 sortedArr[](임시 배열)의 리스트를 배열 list[]로 재복사
        for (l = left; l <= right; l++) {
            arr[l] = sortedArr[l];
        }
    }

    private static <T> void ComparatorSort(Object[] a, Comparator<? super T> c) {
        comparatorDivide(a, 0, a.length - 1, c);
    }

    private static <T> void comparatorDivide(Object[] a, int left, int right, Comparator<? super T> c) {
        int mid;
        if (left < right) {
            mid = (right + left) / 2;
            comparatorDivide(a, left, mid, c);
            comparatorDivide(a, mid + 1, right, c);
            comparatorConquer(a, left, mid, right, c);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static <T> void comparatorConquer(Object[] arr, int left, int mid, int right, Comparator c) {
        Object[] sortedArr = new Object[arr.length];
        int i, j, k, l;
        i = left;
        j = mid + 1;
        k = left;
        //두배열 중 하나가 빌때까지 두 배열 비교해서 작은값 정렬된 배열에 넣기
        while (i <= mid && j <= right) {
            //비교할때 매개변수로 받은 Comparator 사용
            if (c.compare(arr[i], arr[j]) <= 0) {
                sortedArr[k++] = arr[i++];
            } else {
                sortedArr[k++] = arr[j++];
            }
        }
        // 남아 있는 값들을 일괄 복사
        if (i > mid) {
            for (l = j; l <= right; l++)
                sortedArr[k++] = arr[l];
        }
        // 남아 있는 값들을 일괄 복사
        else {
            for (l = i; l <= mid; l++)
                sortedArr[k++] = arr[l];
        }
        // 배열 sortedArr[](임시 배열)의 리스트를 배열 list[]로 재복사
        for (l = left; l <= right; l++) {
            arr[l] = sortedArr[l];
        }
    }

}
