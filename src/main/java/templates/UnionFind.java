package templates;

public class UnionFind {

    /**
     * Union by rank and, path compression (in Find)
     *
     * Have tested in problem : https://leetcode.com/problems/redundant-connection/submissions/867587350/
     *                              and many others
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

        void reset(int x) { // Reset the initial properties of node x
            parent[x] = x;
            rank[x] = 0;
        }

    }


    /**
     *
     * From a problem's editorial:
     * https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/editorial/
     *
     * Have tested in problem:
     *  https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/submissions/1026085587/
     *
     */
    private class UnionFind_2 {
        int[] representative;
        int[] componentSize;
        // Number of distinct components in the graph.
        int components;

        // Initialize the list representative and componentSize
        // Each node is representative of itself with size 1.
        public UnionFind_2(int n) {
            components = n;
            representative = new int[n + 1];
            componentSize = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                representative[i] = i;
                componentSize[i] = 1;
            }
        }

        // Get the root of a node.
        int findRepresentative(int x) {
            if (representative[x] == x) {
                return x;
            }

            // Path compression.
            return representative[x] = findRepresentative(representative[x]);
        }

        // Perform the union of two components that belongs to node x and node y.
        int performUnion(int x, int y) {
            x = findRepresentative(x); y = findRepresentative(y);

            if (x == y) {
                return 0;
            }

            if (componentSize[x] > componentSize[y]) {
                componentSize[x] += componentSize[y];
                representative[y] = x;
            } else {
                componentSize[y] += componentSize[x];
                representative[x] = y;
            }

            components--;
            return 1;
        }

        // Returns true if all nodes get merged to one.
        boolean isConnected() {
            return components == 1;
        }
    }

}
