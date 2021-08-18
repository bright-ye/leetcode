package com.mylearn.leetcode.字符串;

import org.junit.Test;

public class 反转字符串 {

    /**
     * 两个知识点：
     * 1. 双指针法
     * 2. a ^ a  = 0; a ^ a ^ b = b
     */
    class Solution2{
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length -1;
            while (left <right){
                s[left] ^= s[right];
                s[right] ^= s[left];
                s[left] ^= s[right];
                left++;
                right--;
            }
        }
    }

    /**
     * 排序法
     */
    class Solution1{
        public void reverseString(char[] s) {
            for(int i = 0;i<s.length-1;i++){
                for (int j = 0;j<s.length - i -1 ;j++){
                    char temp = s[j];
                    s[j] = s[j+1];
                    s[j+1] = temp;
                }
            }
        }
    }

}
