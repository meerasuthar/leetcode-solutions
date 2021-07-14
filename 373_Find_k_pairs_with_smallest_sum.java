class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.sum-b.sum);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i=0;i<nums1.length;i++) {
            for (int j=0;j<nums2.length;j++) {
                Pair p = new Pair(nums1[i], nums2[j], nums1[i]+nums2[j]);
                pq.add(p);
            }
        }
        System.out.println(pq.size());
        int c = 0;
        while (c<k) {
            List<Integer> inner = new LinkedList<>();
            Pair cur = pq.poll();
            if (cur == null) {
                break;
            }
            inner.add(cur.e1);
            inner.add(cur.e2);
            ans.add(inner);
            c++;
        }
        return ans;
    }
}

class Pair{
    int e1;
    int e2;
    int sum;
    public Pair(int e1, int e2, int sum) {
        this.e1 = e1;
        this.e2 = e2;
        this.sum = sum;
    }
}