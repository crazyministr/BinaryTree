import junit.framework.TestCase;
import java.util.NoSuchElementException;

public class BinaryTreeTest extends TestCase {

    private BinaryTreeImpl tree = new BinaryTreeImpl();

    public void test01_nullBinaryTree(){
        try {
            tree.getMinimum(1, null);
            fail("Fail test01");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void test02_binaryTreeWithOneElement() {
        BinaryTree node = new BinaryTree(1, null, null);
        int result = tree.getMinimum(1, node);
        assertEquals(result, 1);
    }

    public void test03_binaryTreeToMuchNumber() {
        BinaryTree node = new BinaryTree(1, null, null);
        try {
            tree.getMinimum(3, node);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void test04_binaryTreeOnlyLeftLine() {
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node2 = new BinaryTree(2, node1, null);
        BinaryTree node3 = new BinaryTree(3, node2, null);
        int result1 = tree.getMinimum(1, node3);
        int result2 = tree.getMinimum(2, node3);
        int result3 = tree.getMinimum(3, node3);

        assertEquals(result1, 1);
        assertEquals(result2, 2);
        assertEquals(result3, 3);
    }

    public void test05_binaryTreeOnlyRightLine() {
        BinaryTree node1 = new BinaryTree(5, null, null);
        BinaryTree node2 = new BinaryTree(4, null, node1);
        BinaryTree node3 = new BinaryTree(3, null, node2);
        int result1 = tree.getMinimum(1, node3);
        int result2 = tree.getMinimum(2, node3);
        int result3 = tree.getMinimum(3, node3);

        assertEquals(result1, 3);
        assertEquals(result2, 4);
        assertEquals(result3, 5);
    }

    public void test06_binaryTreeTestExampleInTarget() {
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node3 = new BinaryTree(3, node1, null);

        BinaryTree node9 = new BinaryTree(9, null, null);
        BinaryTree node18 = new BinaryTree(18, null, null);
        BinaryTree node10 = new BinaryTree(10, node9, node18);

        BinaryTree root = new BinaryTree(8, node3, node10);
        int result = tree.getMinimum(4, root);
        assertEquals(result, 9);

        result = tree.getMinimum(2, root);
        assertEquals(result, 3);

        result = tree.getMinimum(6, root);
        assertEquals(result, 18);
    }

    public void test07_binaryTreeTestExampleInTargetException() {
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node3 = new BinaryTree(3, node1, null);

        BinaryTree node9 = new BinaryTree(9, null, null);
        BinaryTree node18 = new BinaryTree(18, null, null);
        BinaryTree node10 = new BinaryTree(10, node9, node18);

        BinaryTree root = new BinaryTree(8, node3, node10);
        try {
            tree.getMinimum(6, node10);
            tree.getMinimum(2, node1);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void test08_binaryTreeTestExampleUnBinary() {
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node3 = new BinaryTree(1, node1, null);

        BinaryTree node9 = new BinaryTree(9, null, null);
        BinaryTree node18 = new BinaryTree(2, null, null);
        BinaryTree node10 = new BinaryTree(10, node9, node18);

        BinaryTree root = new BinaryTree(8, node3, node10);

        try {
            tree.getMinimum(6, root);
            tree.getMinimum(2, root);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
