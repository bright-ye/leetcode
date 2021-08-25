package 动态规划;

import com.sun.imageio.plugins.jpeg.JPEGStreamMetadataFormat;

public class 整数拆分 {
    public static void main(String[] args) {
        整数拆分 instance = new 整数拆分();
        int res = instance.integerBreak(6);
        System.out.println(res);
    }

    public int integerBreak(int n) {
        // dp存放正整数i拆分结果的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n +1; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
//
//        for(int i = 0;i<dp.length;i++){
//            System.out.print(dp[i] + " ");
//        }
        return dp[n];
    }
}
