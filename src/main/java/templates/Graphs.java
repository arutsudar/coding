package templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphs {

    public static class WeightedDirectedGraphs1 {
        /**
         * weights = [[1,2,85],[2,3,999],[3,1,36],[2,4,66]]
         * n = 4
         * (1 indexed)
         * <p>
         * map :
         * 1 -> [[2,85]]             (From 1, we can navigate to 2 , at cost of 85)
         * 2 -> [[3,999],[4,66]]     (From 2, we can navigate to 3 , at cost of 999,
         * AND we can navigate to 4 , at cost of 66)
         * 3 -> [[1,36]]             (From 3, we can navigate to 1 , at cost of 36)
         */
        public static Map<Integer, List<Integer[]>> getAdjMap(int[][] weights, int n) {
            Map<Integer, List<Integer[]>> adjMap = new HashMap();
            for (int i = 0; i < n; i++) {
                int u = weights[i][0]; // Subtract with "-1" , if it needs to be 0 indexed. int u = weights[i][0] - 1;
                int v = weights[i][1]; // Subtract with "-1" , if it needs to be 0 indexed. int v = weights[i][1] - 1;
                int w = weights[i][2];
                List<Integer[]> list = adjMap.get(u);
                if (list == null) list = new ArrayList();
                list.add(new Integer[]{v, w});
                adjMap.put(u, list);
            }
            return adjMap;
        }
    }

    public static class WeightedDirectedGraphs2 {
        /**
         * weights = [[1,2,85],[1,3,999],[3,1,36],[2,3,77]]
         * n = 3
         * (1 indexed)
         *
         * map :
         *      [
         *          [0, 0, 0, 0],
         *          [0, 0, 85, 999],
         *          [0, 0, 0, 77],
         *          [0, 36, 0, 0],
         *      ]
         *
         * @param weights int[][] - Each row is like -> weights[i] = (ui, vi, wi)
         * @param n - Number of nodes
         * @return int[][]
         */
        public static int[][] getAdjMap(int[][] weights, int n) {
            int[][] map = new int[n+1][n+1];
            for (int i = 0; i < weights.length; i++) {
                int u = weights[i][0];
                int v = weights[i][1];
                int weight = weights[i][2];
                map[u][v] = weight;
            }
            return map;
        }
    }



    // ------------------------------------------------------------------------------------------------------------ //



    /**
     * connections = [[0,1],[1,2],[2,0],[1,3]]
     *
     * map :
     *      0 -> [1,2]
     *      1 -> [0,2,3]
     *      2 -> [1,0]
     *      3 -> [1]
     */
    public static class UndirectedGraphs {

        public static Map<Integer, List<Integer>> getAdjacencyMap(List<List<Integer>>  connections) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (List<Integer> connection : connections) {
                int x = connection.get(0);
                int y = connection.get(1);

                List<Integer> temp1 = map.getOrDefault(x, new ArrayList<>());
                temp1.add(y);
                map.put(x, temp1);

                List<Integer> temp2 = map.getOrDefault(y, new ArrayList<>());
                temp2.add(x);
                map.put(y, temp2);
            }
            return map;
        }

        public static Map<Integer, List<Integer>> getAdjacencyMap(int[][] connections) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] connection : connections) {
                int x = connection[0];
                int y = connection[1];
                List<Integer> temp1 = map.getOrDefault(x, new ArrayList<>());
                temp1.add(y);
                map.put(x, temp1);
                List<Integer> temp2 = map.getOrDefault(y, new ArrayList<>());
                temp2.add(x);
                map.put(y, temp2);
            }
            return map;
        }

        // Not tested yet
        public static List<List<Integer>> getAdjacencyList(int n, int[][] edges) {
            List<List<Integer>> values = new ArrayList<>();
            for(int i = 0; i < n; i++){
                values.add(new ArrayList<>());
            }
            for(int [] edge : edges){
                values.get(edge[0]).add(edge[1]);
                values.get(edge[1]).add(edge[0]);
            }
            return values;
        }

        /**
         * For each node, get neighbours
         * as an array
         */
        public static List<Integer>[] getAdjacencyArray(int n, int[][] edges) {
            List<Integer>[] graph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                int a = edge[0], b = edge[1];
                graph[a].add(b);
                graph[b].add(a);
            }
            return graph;
        }

    }

    /**
     * Weighted undirected graph
     */
    public static class WeightedUndirectedGraphs {

        /**
         * For each node, get weights of neighbours
         * as a list
         */
        public static List<List<Integer>> getAdjacencyList(int[] vals, int[][] edges) {
            List<List<Integer>> values = new ArrayList<>();
            for (int i = 0; i < vals.length; i++) {
                values.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                values.get(edge[0]).add(vals[edge[1]]);
                values.get(edge[1]).add(vals[edge[0]]);
            }
            return values;
        }

        /**
         * For each node, get neighbour and also its weight as an array.
         * as a Map
         * <p>
         * node1 = List (
         * []{neighbourNode1, weight1} ,
         * []{neighbourNode2, weight2}
         * )
         * // https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
         */
        public static Map<Integer, List<Integer[]>> getAdjMap(int[][] weights, int n) {
            Map<Integer, List<Integer[]>> adjMap = new HashMap();
            for (int i = 0; i < n; i++) {
                int u = weights[i][0]; // Subtract with "-1" , if it needs to be 0 indexed. int u = weights[i][0] - 1;
                int v = weights[i][1]; // Subtract with "-1" , if it needs to be 0 indexed. int v = weights[i][1] - 1;
                int w = weights[i][2];
                List<Integer[]> list1 = adjMap.get(u);
                if (list1 == null) list1 = new ArrayList();
                list1.add(new Integer[]{v, w});
                adjMap.put(u, list1);

                List<Integer[]> list2 = adjMap.get(v);
                if (list2 == null) list2 = new ArrayList();
                list2.add(new Integer[]{u, w});
                adjMap.put(v, list2);
            }
            return adjMap;
        }
    }

}
