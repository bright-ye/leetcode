package 单调栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 下一个更大元素II {

    public static void main(String[] args) {
        int nums[] = new int[]{
                100,1,11,1,120,111,123,1,-1,-100
        };

        下一个更大元素II instance = new 下一个更大元素II();
        int[] result = instance.nextGreaterElements(nums);
        for (int i = 0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1;i<nums.length * 2 -1 ;i++){
            int curr = nums[i%nums.length];
            while (!stack.isEmpty() && nums[stack.peek()] < curr){
                result[stack.pop()] = curr;
            }
            stack.push(i%nums.length);
        }
        return result;
    }
}
