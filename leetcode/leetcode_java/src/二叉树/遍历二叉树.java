package com.mylearn.leetcode.二叉树;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 遍历二叉树 {


    /**
     * 前序遍历：根左右
     */
    public class Solution1{
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            preOrder(root,result);
            return result;
        }

        private void preOrder(TreeNode root, ArrayList<Integer> result){
            if(root == null){
                return;
            }
            result.add(root.val);
            preOrder(root.left,result);
            preOrder(root.right,result);
        }
    }

    /**
     * 前序遍历(迭代)
     */
    public class Solution12{
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if(root.right != null){
                    stack.push(root.right);
                }
                if(root.left != null){
                    stack.push(root.left);
                }
            }
            return result;
        }
    }


    /**
     * 中序遍历：左根右
     */
    public class Solution2{
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            inorder(root,result);
            return result;
        }

        private void inorder(TreeNode root,ArrayList<Integer> result){
            if(root == null){
                return;
            }
            inorder(root.left,result);
            result.add(root.val);
            inorder(root.right,result);
        }
    }

    public class Solution22{
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while(cur != null || !stack.isEmpty()){
                if(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }else{
                    cur = stack.pop();
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
            return result;
        }
    }

    /**
     * 后序遍历: 左右根
     */
    public class Solution3{
        public List<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            postOrder(root,result);
            return result;
        }
        private void postOrder(TreeNode root,ArrayList<Integer> result){
            if(root == null){
                return;
            }
            postOrder(root.left,result);
            postOrder(root.right,result);
            result.add(root.val);
        }
    }

    /**
     * 二叉树的后序遍历(迭代)
     * 二叉树的根顺序在边界的时候，可以灵活调整顺序，再把结果翻转
     * 如后序遍历：左右根，可以先"根右左"，再翻转
     */
    public class Solution32{
        public List<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
            Collections.reverse(result);
            return result;
        }
    }


}
