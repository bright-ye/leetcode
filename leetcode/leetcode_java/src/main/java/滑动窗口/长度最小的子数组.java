package 滑动窗口;

import org.junit.Test;

public class 长度最小的子数组 {

    @Test
    public void test4() {
        int[] nums = new int[]{
                1, 2, 3, 4, 5
        };
        int target = 11;
        System.out.println(minSubArrayLen(target, nums));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{
                1, 1, 1, 1, 1, 1, 1, 1
        };
        int target = 11;
        System.out.println(minSubArrayLen(target, nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{
                1, 4, 4
        };
        int target = 4;
        System.out.println(minSubArrayLen(target, nums));
    }

    @Test
    public void test1() {
        int[] nums = new int[]{
                2, 3, 1, 2, 4, 3
        };
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        int p = 0, q = 0;
        while (q < nums.length) {
            sum += nums[q];
            while (sum >= target) {
                min = Math.min(min, q - p + 1);
                sum -= nums[p];
                p++;
            }
            q++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
