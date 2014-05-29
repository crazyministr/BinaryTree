import java.util.NoSuchElementException;

/**
 * {@link BinaryTree} implementation
 */
public class BinaryTreeImpl implements MinimumFinder {

    /**
     * Method that count elements in {@link BinaryTree}. For it, using recursive algorithm
     * @param root vertex in which we want to know count of child's
     * @return count of vertex in {@link BinaryTree}
     */
    private int binaryTreeGetCount(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        return binaryTreeGetCount(root.left) + binaryTreeGetCount(root.right) + 1;
    }

    /**
     * Returns whether the {@link BinaryTree} is binary
     * @param root main root of {@link BinaryTree}
     * @return true if {@link BinaryTree} is binary, otherwise false
     */
    private boolean isBinaryTree(BinaryTree root) {
        if (root == null) {
            return true;
        }
        boolean resultLeft = (root.left == null || root.key > root.left.key) && (root.right == null || root.key < root.right.key);
        return isBinaryTree(root.left) && isBinaryTree(root.right) && resultLeft;
    }

    /**
     * Returns N-th ordinal minimum number in {@link BinaryTree}
     * @param n ordinal number
     * @param tree {@link BinaryTree}
     * @return key of N-th ordinal minimum number
     */
    private int getBinaryElement(int n, BinaryTree tree) {
        int leftCount = binaryTreeGetCount(tree.left);
        if (n == leftCount) {
            return tree.key;
        }
        return (n < leftCount) ? getBinaryElement(n, tree.left) : getBinaryElement(n - (leftCount + 1), tree.right);
    }

    @Override
    public int getMinimum(int n, BinaryTree tree) {
        if (binaryTreeGetCount(tree) < n) {
            throw new NoSuchElementException("Can't find N-th minimum element");
        }
        if (!isBinaryTree(tree)) {
            throw new IllegalArgumentException("This tree isn't binary");
        }

        return getBinaryElement(n - 1, tree);
    }

}
