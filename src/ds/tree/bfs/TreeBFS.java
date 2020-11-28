package ds.tree.bfs;

import ds.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {
    private Node root;

    public TreeBFS() {
        root = null;
    }

    public static void main(String[] args) {
        TreeBFS tree = new TreeBFS();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);

        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);

        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);

        System.out.println("recursiveTraversal:");
        tree.recursiveTraversal();
        System.out.println();
        System.out.println("BFS traversal");
        tree.bfsTraversal();
    }

    private void bfsTraversal() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.getData() + " ");

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }

    }

    private void recursiveTraversal() {
        int height = height(root);

        for (int level = 1; level <= height; level++) {
            printNodesAtLevel(level, root);
        }

    }

    private void printNodesAtLevel(int level, Node root) {
        if (root == null)
            return;

        if (level == 1)
            System.out.print(root.getData() + " ");
        else if (level > 1) {
            printNodesAtLevel(level - 1, root.left);
            printNodesAtLevel(level - 1, root.right);
        }
    }

    private int height(Node root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
