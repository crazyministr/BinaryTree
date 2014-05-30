import java.util.NoSuchElementException;

/**
 * {@link BinaryTree} implementation
 */
public class MinimumFinderImpl implements MinimumFinder {

    /**
     * Method that count elements in {@link BinaryTree}. For it, using recursive algorithm
     * @param root vertex in which we want to know count of child's
     * @return count of vertex in {@link BinaryTree}
     */
    protected int binaryTreeGetCount(BinaryTree root) {
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
    protected boolean isBinaryTree(BinaryTree root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && maxValue(root.left) > root.key ||
            root.right != null && minValue(root.right) < root.key) {
                return false;
        }
        return isBinaryTree(root.left) && isBinaryTree(root.right);
    }

    /**
     * Returns maximum value in subtree {@link BinaryTree}
     * @param root main root of {@link BinaryTree}
     * @return maximum value in subtree {@link BinaryTree}
     */
    protected int maxValue(BinaryTree root) {
        int maxLeft = Integer.MIN_VALUE;
        if (root.left != null) {
            maxLeft = maxValue(root.left);
        }
        int maxRight = Integer.MIN_VALUE;
        if (root.right != null) {
            maxRight = maxValue(root.right);
        }
        return Math.max(root.key, Math.max(maxLeft, maxRight));
    }

    /**
     * Returns minimum value in subtree {@link BinaryTree}
     * @param root main root of {@link BinaryTree}
     * @return minimum value in subtree {@link BinaryTree}
     */
    protected int minValue(BinaryTree root) {
        int minLeft = Integer.MAX_VALUE;
        if (root.left != null) {
            minLeft = minValue(root.left);
        }
        int minRight = Integer.MAX_VALUE;
        if (root.right != null) {
            minRight = minValue(root.right);
        }
        return Math.min(root.key, Math.min(minLeft, minRight));
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
        return (n < leftCount) ?
                getBinaryElement(n, tree.left) :
                getBinaryElement(n - (leftCount + 1), tree.right);
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
