import junit.framework.TestCase;
import java.util.NoSuchElementException;

public class BinaryTreeTest extends TestCase {
    private MinimumFinderImpl tree = new MinimumFinderImpl();

    public void testNullBinaryTree(){
        try {
            tree.getMinimum(1, null);
            fail("[FAIL] testNullBinaryTree had to return NoSuchElementException");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testBinaryTreeWithOneElement() {
        BinaryTree node = new BinaryTree(1, null, null);
        assertEquals(tree.getMinimum(1, node), 1);
    }

    public void testBinaryTreeToMuchNumber() {
        BinaryTree node = new BinaryTree(1, null, null);
        try {
            tree.getMinimum(3, node);
            fail("[FAIL] testBinaryTreeToMuchNumber had to return NoSuchElementException");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testBinaryTreeOnlyLeftLine() {
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node2 = new BinaryTree(2, node1, null);
        BinaryTree node3 = new BinaryTree(3, node2, null);

        assertEquals(tree.getMinimum(1, node3), 1);
        assertEquals(tree.getMinimum(2, node3), 2);
        assertEquals(tree.getMinimum(3, node3), 3);
    }

    public void testBinaryTreeOnlyRightLine() {
        BinaryTree node1 = new BinaryTree(5, null, null);
        BinaryTree node2 = new BinaryTree(4, null, node1);
        BinaryTree node3 = new BinaryTree(3, null, node2);

        assertEquals(tree.getMinimum(1, node3), 3);
        assertEquals(tree.getMinimum(2, node3), 4);
        assertEquals(tree.getMinimum(3, node3), 5);
    }

    public void testBinaryTreeTestExampleInTarget() {
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node3 = new BinaryTree(3, node1, null);

        BinaryTree node9 = new BinaryTree(9, null, null);
        BinaryTree node18 = new BinaryTree(18, null, null);
        BinaryTree node10 = new BinaryTree(10, node9, node18);

        BinaryTree root = new BinaryTree(8, node3, node10);

        assertEquals(tree.getMinimum(4, root), 9);
        assertEquals(tree.getMinimum(2, root), 3);
        assertEquals(tree.getMinimum(6, root), 18);
    }

    public void testBinaryTreeTestExampleUnBinary() {
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node3 = new BinaryTree(1, node1, null);

        BinaryTree node9 = new BinaryTree(9, null, null);
        BinaryTree node18 = new BinaryTree(2, null, null);
        BinaryTree node10 = new BinaryTree(10, node9, node18);

        BinaryTree root = new BinaryTree(8, node3, node10);

        try {
            tree.getMinimum(6, root);
            tree.getMinimum(2, root);
            fail("[FAIL] testBinaryTreeTestExampleUnBinary had to return IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testBinaryTreeTestExampleFromComments() {
        BinaryTree node1 = new BinaryTree(15, null, null);
        BinaryTree node2 = new BinaryTree(7, null, node1);
        BinaryTree root = new BinaryTree(10, node2, null);
        try {
            tree.getMinimum(1, root);
            fail("[FAIL] testBinaryTreeTestExampleFromComments had to return IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
