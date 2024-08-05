/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findPath(TreeNode node, int val, StringBuilder path) {
        if (node == null) {
            return false;
        }
        if (node.val == val) {
            return true;
        }
        if (node.left != null && findPath(node.left, val, path)) {
            path.append('L');
            return true;
        }
        if (node.right != null && findPath(node.right, val, path)) {
            path.append('R');
            return true;
        }
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        findPath(root, startValue, startPath);
        findPath(root, destValue, destPath);

        startPath.reverse();
        destPath.reverse();

        int commonLength = 0;
        while (commonLength < Math.min(startPath.length(), destPath.length()) &&
               startPath.charAt(commonLength) == destPath.charAt(commonLength)) {
            commonLength++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < startPath.length()-commonLength; i++) {
            result.append('U');
        }
        result.append(destPath.substring(commonLength));

        return result.toString();
    }
}