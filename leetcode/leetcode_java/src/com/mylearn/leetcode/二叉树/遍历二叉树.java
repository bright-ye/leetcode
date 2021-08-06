package com.mylearn.leetcode.二叉树;


import java.util.ArrayList;
import java.util.List;

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


}
