package ds.tree.dfs;

import ds.tree.Node;

public class TreeDFS {
    Node root;

    public TreeDFS() {
        this.root = null;
    }

    public static void main(String[] args) {
        TreeDFS tree = new TreeDFS();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);

        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);

        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);

        System.out.println("DFS pre-order:");
        tree.preorderDSF(tree.root);
        System.out.println();
        System.out.println("DFS in-order:");
        tree.inorderDFS(tree.root);
        System.out.println();
        System.out.println("DFS post-order:");
        tree.postorderDFS(tree.root);
    }

    private void postorderDFS(Node root) {
        if (root == null)
            return;

        postorderDFS(root.left);
        postorderDFS(root.right);
        System.out.print(root.getData() + " ");
    }

    private void inorderDFS(Node root) {
        if (root == null)
            return;

        inorderDFS(root.left);
        System.out.print(root.getData() + " ");
        inorderDFS(root.right);

    }

    private void preorderDSF(Node root) {
        if (root == null)
            return;
        System.out.print(root.getData() + " ");
        preorderDSF(root.left);
        preorderDSF(root.right);
    }
}
