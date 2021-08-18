package 单调栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 下一个更大元素I {

    public static void main(String[] args) {
        int[] nums1 = new int[]{
                4,1,2
        };
        int[] nums2 = new int[]{
                1,3,4,2
        };

        下一个更大元素I instance = new 下一个更大元素I();
        int[] result = instance.nextGreaterElement(nums1,nums2);
        for (int i = 0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result,-1);
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1;i<nums2.length;i++){
            int curr = nums2[i];
            while (!stack.isEmpty() && nums2[stack.peek()] < curr){
                map.put(nums2[stack.pop()],curr);
            }
            stack.push(i);
        }
        for(int i = 0;i<nums1.length;i++){
            result[i] = map.getOrDefault(nums1[i],-1);
        }
        return result;
    }

}
