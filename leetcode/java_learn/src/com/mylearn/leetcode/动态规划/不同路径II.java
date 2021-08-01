package com.mylearn.leetcode.动态规划;

public class 不同路径II {

    public static void main(String[] args) {
        不同路径II instance = new 不同路径II();
        int[][] obstacleGrid = new int[][]{
                {0,0,0},{0,1,0},{0,0,0}
        };
        obstacleGrid = new int[][]{
                {0,0},{0,1}
        };
        int res = instance.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean flag = false;
        for(int i = 0;i<dp.length;i++){
            if(obstacleGrid[i][0] == 1){
                flag= true;
            }
            if(!flag){
                dp[i][0] = 1;
            }else{
                dp[i][0] = 0;
            }
        }
         flag = false;
        for(int i = 0;i<dp[0].length;i++){
            if(obstacleGrid[0][i] == 1){
                flag  = true;
            }
            if(!flag){
                dp[0][i] = 1;
            }else{
                dp[0][i] = 0;
            }
        }
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else if(obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] != 1){
                    dp[i][j] = dp[i][j-1];
                }else if(obstacleGrid[i-1][j] != 1 && obstacleGrid[i][j-1] == 1){
                    dp[i][j] = dp[i-1][j];
                }else if(obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        for(int i = 0;i<obstacleGrid.length;i++){
            for(int j = 0;j<obstacleGrid[0].length;j++){
                System.out.print(dp[i][j]     +"      " );
            }
            System.out.println();
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
