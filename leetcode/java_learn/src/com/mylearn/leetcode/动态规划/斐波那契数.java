package com.mylearn.leetcode.动态规划;

public class 斐波那契数 {
    public static void main(String[] args) {
        斐波那契数 instance = new 斐波那契数();
        int result = instance.fib(5);
        System.out.println(result);
    }

    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        int a = 0,b = 1,c = 0;
        for(int i = 2;i<=n;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
