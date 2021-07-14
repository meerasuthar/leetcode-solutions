class Solution {
    List<List<Integer>> list;
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        list = new LinkedList<>();
        int count=0;
        int[] visited = new int[m*n];
        Queue<Integer> q = new LinkedList<>();
        int rottanOrangesCount = 0;
        int orangeCount=0;
        
        //Creating adj list for BFS
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                List<Integer> inner = new LinkedList<>();
                if (grid[i][j]==2) {
                    //(count + j) represents cell no in matrix
                    q.add(count+j);
                    visited[count+j] = 1;
                    rottanOrangesCount++;
                    orangeCount++;
                } else if (grid[i][j]==1) {
                    orangeCount++;                  
                }
                if (grid[i][j]==2 || grid[i][j]==1) {
                    if (i-1>=0 && grid[i-1][j]!=0) {
                        inner.add(count+j-n);
                    } 
                    if (j-1>=0 && grid[i][j-1]!=0) {
                        inner.add(count+j-1);
                    }
                    if (i+1<grid.length && grid[i+1][j]!=0) {
                        inner.add(count+j+n);
                    }
                    if (j+1<grid[0].length && grid[i][j+1]!=0) {
                        inner.add(count+j+1);
                    }
                }
                list.add(inner);
            }
            count+=n;
        }
        
        //BFS + Level order traversal logic
        int mins=0;
        int toReturn=0;
        while(q.size()>0) {
            int size = q.size();
            mins++;
            for (int j=0;j<size;j++) {
                int cur = q.poll();
                Iterator<Integer> i = list.get(cur).iterator();
                while(i.hasNext()) {
                    int a = i.next();
                    if (visited[a]==0) {
                        visited[a] = 1;
                        rottanOrangesCount++;
                        q.add(a);
                        toReturn = mins;
                    }           
                }              
            }            
        }
        if (orangeCount > rottanOrangesCount) {
            return -1;
        }
        return toReturn;
    }
}