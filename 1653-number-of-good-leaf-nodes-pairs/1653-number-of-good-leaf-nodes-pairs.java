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
    int goodpairs=0;
    List<Integer> dfs(TreeNode root, int distance){
        if(root==null){
            List<Integer> ans=new ArrayList();
            return ans ;
        }
        if(root.left==null && root.right==null){
            List<Integer> ans=new ArrayList();
            ans.add(1);
            return ans;
        }
        List<Integer> left=dfs(root.left,distance);
        List<Integer> right=dfs(root.right,distance);

        for(int i: left){
            for(int j:right){
                if(i+j<=distance){
                    goodpairs++;
                }
            }
        }
        List<Integer> parent=new ArrayList();
        for(int i:left){
            if(i+1<distance){
                parent.add(i+1);
            }
        }
        for(int i:right){
            if(i+1<distance){
                parent.add(i+1);
            }
        }
        return parent;

    }
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return goodpairs;
    }
}