//This is Code of Two pointer Approach in Java.
//The two-pointer approach is a popular technique used in solving a variety of problems,
//especially in array and linked list manipulations. It involves using two pointers that traverse 
//the data structure in a specific way. Here's an example of the two-pointer approach in Java 
//with a simple problem: finding a pair of elements in an array that sum to a given target.

public class TwoPointerExample {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 8, 12, 15};
        int target = 14;
        findPairWithSum(nums, target);
    }

    public static void findPairWithSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                System.out.println("Pair found: " + nums[left] + " + " + nums[right] + " = " + target);
                return; // You can also store the pair or continue searching for more pairs
            } else if (sum < target) {
                left++; // Move the left pointer to the right to increase the sum
            } else {
                right--; // Move the right pointer to the left to decrease the sum
            }
        }

        System.out.println("No pair found with the sum of " + target);
    }
}
