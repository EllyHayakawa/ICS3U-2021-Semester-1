package week10;

public class fizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(1, 6);
    }
    public static String[] fizzBuzz(int start, int end) {
        int[] nums1 = new int[end - start];
        String[] nums = new String[end - start];
        for(int i = 0; i < nums.length; i++){
          if((nums1[i])%3 == 0)
            nums[i] = "Buzz";
          else
            nums[i] = String.valueOf(i + start);
        }
        
        /*String[] arr = new String[end - start];
        for(int i = start; i < arr.length; i++){
          if(nums[i]%3 == 0 && nums[i]%5 == 0)
            arr[i] = "FizzBuzz";
          else if(nums[i]%3 == 0)
            arr[i] = "Fizz";
          else if(nums[i]%5 == 0)
            arr[i] = "Buzz";
          else
            arr[i] = String.valueOf(nums[i]);
        }
        return arr;*/
        return nums;
      }
}
