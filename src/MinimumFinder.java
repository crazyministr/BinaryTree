/**
 * Interface that provides finding N-th minimum element in {@link BinaryTree}
 */
public interface MinimumFinder {
    /**
     * Method that finding N-th minimum element
     * @param n position of minimum element
     * @param tree {@link BinaryTree} which are searched
     * @return result minimum of searching
     */
    int getMinimum(int n, BinaryTree tree);
}
