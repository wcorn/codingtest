package algorithm;

import java.util.Comparator;

public class InsertionSort {
    public static <T> void sort(T[] a, Comparator<? super T> c) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && c.compare(a[j], a[j-1]) < 0; j--)
                swap(a,j,j-1);
        }
    }

    //단순 데이터 sort
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void sort(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && ((Comparable) arr[j]).compareTo(arr[j-1]) < 0; j--) {
                System.out.println(arr[j-1]+" "+arr[j]);
                swap(arr,j, j-1);
            }
        }
    }

    private static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
