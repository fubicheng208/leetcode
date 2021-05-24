package binary_search;

public class M11 {
    public static int minArray(int[] numbers) {
        if(numbers == null || numbers.length == 0){
            return -1;
        }
        if(numbers.length == 1){
            return numbers[0];
        }
        int l = 0, r = numbers.length - 1;
        while(l <= r){
            int mid = l + ((r - l) >>1);
            if(numbers[mid] > numbers[r]){
                l = mid + 1;
            }else if(numbers[mid] < numbers[r]){
                r = mid - 1;
            }else{
                r--;
            }
        }
        return numbers[l];
    }
}
