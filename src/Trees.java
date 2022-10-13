public class Trees {

    public static void main(String[] args) {

        // Create a new [Node]
        Node node = new Node(100);

        // Construct tree
        node.left = new Node(75);
        node.right = new Node(125);

        node.left.left = new Node(0);
        node.left.right = new Node(85);

        node.right.left = new Node(110);
        node.right.right = new Node(200);

        // Preorder traversal
        preOrder(node);

        // Inorder traversal
        inOrder(node);

        // Postorder traversal
        postOrder(node);

    }

    /* Preorder traversal of a [Tree] */
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.getValue());
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /* Inorder traversal of a [Tree] */
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.getValue());
            inOrder(root.right);
        }
    }

    /* Postorder traversal of a [Tree] */
    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.getValue());
        }
    }

    /**
     * A [Node] class which will be used for constructing trees.
     */
    public static class Node {

        // Value of each [Node]
        private int val;

        // Child [Node]s
        public Node left;
        public Node right;

        // Constructor
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

        // Get the value of the [Node]
        public int getValue() { 
            return this.val; 
        }

        // Set the value of the [Node]
        public void setValue(int val) {
            this.val = val;
        }
    }
}
