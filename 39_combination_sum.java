class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        int k = target;
        ans = new LinkedList<>();
        helper(new ArrayList<Integer>(), n, k, candidates);
        return ans;
    }
    
    public void helper(List<Integer> inner, int i, int target, int[] nums) {
        if (target==0) {
            ans.add(new ArrayList<>(inner));
            return;
        } 
        if (i==0) {
            return;
        }    
        if (target < nums[i-1]) {
            helper(inner, i-1, target, nums);
        } else {
            inner.add(nums[i-1]);
            helper(inner, i, target-nums[i-1], nums);            
            inner.remove(inner.size()-1);
            helper(inner, i-1, target, nums);
        }
    }
}