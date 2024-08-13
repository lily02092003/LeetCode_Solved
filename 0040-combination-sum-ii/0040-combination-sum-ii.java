class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList();
        List<Integer> m= new ArrayList();
        findcombinations(0,candidates,ans,m,target);
        return ans;
    }
    static void findcombinations(int ind,int[] candidates,List<List<Integer>> ans,List<Integer> m,int target){
        if(target==0){
            ans.add(new ArrayList(m));
        }
        for(int i=ind;i<candidates.length;i++){
            if(i>ind && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            m.add(candidates[i]);
            findcombinations(i+1,candidates,ans,m,target-candidates[i]);
            m.remove(m.size()-1);
        }
    }
}