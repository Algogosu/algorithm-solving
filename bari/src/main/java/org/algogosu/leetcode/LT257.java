package org.algogosu.leetcode;

import java.util.ArrayList;
import java.util.List;

// Binary Tree Paths
public class LT257 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<String>();
            dfs(root, "", result);
            return result;
        }

        public void dfs(TreeNode node, String path, List<String> result) {
            if (node.left != null) {
                dfs(node.left, path + node.val + "->", result);
            }
            if (node.right != null) {
                dfs(node.right, path + node.val + "->", result);
            }
            if (node.left == null && node.right == null) {
                result.add(path + node.val);
                return;
            }
        }
    }
}
