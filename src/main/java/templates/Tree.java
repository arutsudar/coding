package templates;

import java.util.*;

public class Tree {

    /**
     * Iterative inorder traversal
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    /**
     * TreeNode
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    /**
     * To convert given parent array to a Tree
     * https://leetcode.com/problems/longest-path-with-different-adjacent-characters/description/
     * (Nodes can have multiple children)
     *
     * Eg.:
     *  parent = [-1,0,0,1,1,2], s = "abacbe"
     *
     *             (0 'a')
     *           /      \
     *       (2 'a')    (1 'b')
     *       /           /    \
     *     (5 'e')    (3 'c')   (4 'b')
     *
     *
     */
    public class TreeWithMultipleChildrenWithGivenParentArray {

        Map<Integer, Node> treeMap;

        class Node {
            int i;
            char c;
            int parent;
            List<Node> children;
            Node (int i, char c, int parent) {
                this.i = i;
                this.c = c;
                this.parent = parent;
                this.children = new ArrayList<>();
            }
            void addChild(Node child) {
                this.children.add(child);
            }
        }

        public void longestPath(int[] parent, String s) {        // Main method
            treeMap = new HashMap<>();
            Node dummyRoot = new Node(-1, '$', -1);
            treeMap.put(-1, dummyRoot);
            constructTree(parent, s);
        }

        private void constructTree(int[] parentArr, String s) {   // Construct the tree
            for (int i=0; i<parentArr.length; i++) {
                char c = s.charAt(i);
                int p = parentArr[i];
                Node curr = treeMap.getOrDefault(i, new Node(i, c, p));
                Node parent;
                if (p == -1)
                    parent = treeMap.get(p); // Parent of node 0 is -1
                else
                    parent = treeMap.getOrDefault(p, new Node(p, s.charAt(p), parentArr[p]));

                parent.addChild(curr);

                treeMap.put(i, curr);
                treeMap.put(p, parent);
            }
        }
    }

    /*
        https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/submissions/972646679/
        Construct a binary search tree with the given array.
        BST bst = new BST(nums);
        bst.root will give the root of the BST.
     */
    class BST {

        TreeNode root;

        BST() {
            root = null;
        }

        BST(int[] nums) {
            root = null;
            for (int num : nums)
                insert(num);
        }

        public void insert(int num) {
            root = insert(num, root);
        }

        public TreeNode insert(int num, TreeNode node) {
            if (node == null)
                return node = new TreeNode(num);
            if (num < node.val)
                node.left = insert(num, node.left);
            else
                node.right = insert(num, node.right);
            return node;
        }

    }

}
