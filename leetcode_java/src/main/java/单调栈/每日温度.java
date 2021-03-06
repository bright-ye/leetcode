package 单调栈;

import java.util.Stack;

public class 每日温度 {

    public static void main(String[] args) {
        int temperatures[] = new int[]{
                73,74,75,71,69,72,76,73
        };

        每日温度 instance = new 每日温度();
        int[] result = instance.dailyTemperatures(temperatures);
        for (int i = 0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<temperatures.length;i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

}
