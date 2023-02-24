package templates;

public class UnionFind {



    /**
     * Union by rank and, path compression (in Find)
     *
     * Have tested in problem : https://leetcode.com/problems/redundant-connection/submissions/867587350/
     *
     * Might need some improvements and corrections. (Not sure)
     */
    static class DisjointSet {
        int[] parent;
        int[] rank;

        void init(int n) {
            parent = new int[n+1];
            for (int i=0; i<=n; i++)
                parent[i] = i;
            rank = new int[n+1];
        }

        int find(int x) {
            if (x != parent[x])
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean Union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);
            if (p1 == p2) {
                return false;
            } else if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
                rank[p2]++;
                return true;
            } else {
                parent[p2] = p1;
                rank[p1]++;
                return true;
            }
        }

    }

}
