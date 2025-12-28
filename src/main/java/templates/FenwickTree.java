// FenwickTree (aka Binary Indexed Tree) implementation in Java
// This implementation is for 1D Fenwick Tree.
// It supports point updates and prefix sum queries.
// It is a data structure that can efficiently update elements and calculate prefix sums in a table of numbers.

// Referenced from https://leetcode.com/problems/count-good-triplets-in-an-array/editorial/?envType=daily-question&envId=2025-04-15

class FenwickTree {

    private int[] tree;

    public FenwickTree(int size) {
        tree = new int[size + 1];
    }

    public void update(int index, int delta) {
        index++;
        while (index < tree.length) {
            tree[index] += delta;
            index += index & -index;
        }
    }

    public int query(int index) {
        index++;
        int res = 0;
        while (index > 0) {
            res += tree[index];
            index -= index & -index;
        }
        return res;
    }

}
