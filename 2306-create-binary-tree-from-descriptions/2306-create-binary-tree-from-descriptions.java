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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> mp=new HashMap();
        Map<Integer,Boolean> hasparent=new HashMap();

        for(int[] description: descriptions){
            int parent=description[0];
            int child=description[1];
            int isLeft=description[2];

            TreeNode parentnode=mp.getOrDefault(parent,new TreeNode(parent));
            TreeNode childnode=mp.getOrDefault(child,new TreeNode(child));
            if(isLeft==1){
                parentnode.left=childnode;
            }else{
                parentnode.right=childnode;
            }

            mp.put(parent,parentnode);
            mp.put(child,childnode);
            hasparent.put(child,true);
        }
        TreeNode root=null;
        for(int i:mp.keySet()){
            if(!hasparent.containsKey(i)){
                root=mp.get(i);
                break;
            }
        }
        return root;
    }
}