import java.util.*;

class ZeroSumSubarrays {
    static List<int[]> findZeroSumSubarrays(int[] nums) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }
            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, -3, 1, 6};
        List<int[]> result = findZeroSumSubarrays(nums);
        for (int[] subarray : result) {
            System.out.println(Arrays.toString(subarray));
        }
    }
}
