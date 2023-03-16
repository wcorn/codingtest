package algorithm;

public class BinarySearch {
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Object search(Object[] arr, Object target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left<=right) {
            mid = (left+right)/2;
            int a = ((Comparable) target).compareTo(arr[mid]);
            if(a == 0){
                return mid;
            }
            else if(a<0){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return "값이 없습니다.";
    }
}
