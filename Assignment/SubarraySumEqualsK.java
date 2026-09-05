import java.util.HashMap;

public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        // Empty prefix
        prefixSum.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum = currentSum + nums[i];

            int requiredSum = currentSum - k;

            if (prefixSum.containsKey(requiredSum)) {
                count = count + prefixSum.get(requiredSum);
            }

            if (prefixSum.containsKey(currentSum)) {
                prefixSum.put(
                    currentSum,
                    prefixSum.get(currentSum) + 1
                );
            } else {
                prefixSum.put(currentSum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(subarraySum(nums, k));
    }
}
