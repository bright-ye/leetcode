package com.mylearn.leetcode.BFS;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 腐烂的橘子 {

    @Test
    public void test8() {
        腐烂的橘子 instance = new 腐烂的橘子();
        int[][] grid = new int[][]{
                {1}, {2},{1},{1}
        };
        int result = instance.orangesRotting(grid);
        System.out.println(result);
    }

    @Test
    public void test7() {
        腐烂的橘子 instance = new 腐烂的橘子();
        int[][] grid = new int[][]{
                {1}, {2}};
        int result = instance.orangesRotting(grid);
        System.out.println(result);
    }

    @Test
    public void test6() {
        腐烂的橘子 instance = new 腐烂的橘子();
        int[][] grid = new int[][]{
                {1, 2}
        };
        int result = instance.orangesRotting(grid);
        System.out.println(result);
    }

    @Test
    public void test5() {
        腐烂的橘子 instance = new 腐烂的橘子();
        int[][] grid = new int[][]{
                {2, 2, 2, 1, 1}
        };
        int result = instance.orangesRotting(grid);
        System.out.println(result);
    }

    @Test
    public void test4() {
        腐烂的橘子 instance = new 腐烂的橘子();
        int[][] grid = new int[][]{
                {1}
        };
        int result = instance.orangesRotting(grid);
        System.out.println(result);
    }

    @Test
    public void test3() {
        腐烂的橘子 instance = new 腐烂的橘子();
        int[][] grid = new int[][]{
                {0, 2}
        };
        int result = instance.orangesRotting(grid);
        System.out.println(result);
    }

    @Test
    public void test2() {
        腐烂的橘子 instance = new 腐烂的橘子();
        int[][] grid = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        int result = instance.orangesRotting(grid);
        System.out.println(result);
    }

    @Test
    public void test1() {
        腐烂的橘子 instance = new 腐烂的橘子();
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int result = instance.orangesRotting(grid);
        System.out.println(result);
    }

    int[] x = new int[]{
            0, 0, 1, -1
    };
    int[] y = new int[]{
            1, -1, 0, 0
    };

    public int orangesRotting(int[][] grid) {

        Queue<Integer> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i * n + j);
                }
            }
        }


        int result = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean flag = false;
            while (size > 0) {

                Integer index = queue.poll();
                int i = index / n;
                int j = index % n;
                for (int k = 0; k < 4; k++) {
                    int dx = i + x[k];
                    int dy = j + y[k];
                    if (dx >= 0 && dx <= m - 1 && dy >= 0 && dy <= n - 1 && grid[dx][dy] == 1) {
                        flag = true;
                        grid[dx][dy] = 2;
                        queue.add(dx * n + dy);
                    }
                }
                size--;
            }
            if (flag) {
                result++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return result;
    }

}
