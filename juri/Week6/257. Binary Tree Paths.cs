using System;
using System.Collections.Generic;

public class Solution
{
    public IList<string> BinaryTreePaths(TreeNode root)
    {
        List<string> resultStr = new List<string>();

        if (root == null)
        {
            return resultStr;
        }

        void recursive(string result, TreeNode node)
        {
            if (node.left == null && node.right == null)
            {
                resultStr.Add(result + node.val);
                return;
            }
            if (node.left != null)
            {
                recursive(result + node.val + "->", node.left);
            }
            if (node.right != null)
            {
                recursive(result + node.val + "->", node.right);
            }
        }

        recursive("", root);
        return resultStr;
    }
}
