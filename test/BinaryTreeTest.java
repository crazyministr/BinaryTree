import junit.framework.TestCase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

public class BinaryTreeTest extends TestCase {
    private MinimumFinderImpl tree = new MinimumFinderImpl();

    public void testNullBinaryTree(){
        try {
            tree.getMinimum(1, null);
            fail("[FAIL] testNullBinaryTree had to return NoSuchElementException");
        } catch (NoSuchElementException e) {
            System.out.println("testNullBinaryTree " + e.getMessage());
        }
    }

    public void testBinaryTreeWithOneElement() {
        BinaryTree node = new BinaryTree(1, null, null);
        assertEquals(1, tree.getMinimum(1, node));
    }

    public void testBinaryTreeToMuchNumber() {
        BinaryTree node = new BinaryTree(1, null, null);
        try {
            tree.getMinimum(3, node);
            fail("[FAIL] testBinaryTreeToMuchNumber had to return NoSuchElementException");
        } catch (NoSuchElementException e) {
            System.out.println("testBinaryTreeToMuchNumber " + e.getMessage());
        }
    }

    public void testBinaryTreeOnlyLeftLine() {
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node2 = new BinaryTree(2, node1, null);
        BinaryTree node3 = new BinaryTree(3, node2, null);

        assertEquals(1, tree.getMinimum(1, node3));
        assertEquals(2, tree.getMinimum(2, node3));
        assertEquals(3, tree.getMinimum(3, node3));
    }

    public void testBinaryTreeOnlyRightLine() {
        BinaryTree node1 = new BinaryTree(5, null, null);
        BinaryTree node2 = new BinaryTree(4, null, node1);
        BinaryTree node3 = new BinaryTree(3, null, node2);

        assertEquals(3, tree.getMinimum(1, node3));
        assertEquals(4, tree.getMinimum(2, node3));
        assertEquals(5, tree.getMinimum(3, node3));
    }

    public void testBinaryTreeTestExampleInTarget() {
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node3 = new BinaryTree(3, node1, null);

        BinaryTree node9 = new BinaryTree(9, null, null);
        BinaryTree node18 = new BinaryTree(18, null, null);
        BinaryTree node10 = new BinaryTree(10, node9, node18);

        BinaryTree root = new BinaryTree(8, node3, node10);

        assertEquals(9, tree.getMinimum(4, root));
        assertEquals(3, tree.getMinimum(2, root));
        assertEquals(18, tree.getMinimum(6, root));
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
            System.out.println("testBinaryTreeTestExampleUnBinary " + e.getMessage());
        }
    }

    public void testPrivateMethodIsBinaryTreeFalse() // test from comments
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        BinaryTree node1 = new BinaryTree(15, null, null);
        BinaryTree node2 = new BinaryTree(7, null, node1);
        BinaryTree root = new BinaryTree(10, node2, null);

        Class<?> clazz = MinimumFinderImpl.class;
        Method method = clazz.getDeclaredMethod("isBinaryTree", BinaryTree.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(clazz.newInstance(), root));
    }

    public void testPrivateMethodIsBinaryTreeTrue()
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        BinaryTree node1 = new BinaryTree(8, null, null);
        BinaryTree node2 = new BinaryTree(7, null, node1);
        BinaryTree root = new BinaryTree(10, node2, null);

        Class<?> clazz = MinimumFinderImpl.class;
        Method method = clazz.getDeclaredMethod("isBinaryTree", BinaryTree.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(clazz.newInstance(), root));
    }

    public void testPrivateMethodMaxValue()
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        BinaryTree node1 = new BinaryTree(15, null, null);
        BinaryTree node2 = new BinaryTree(7, null, node1);
        BinaryTree root = new BinaryTree(10, node2, null);

        Class<?> clazz = MinimumFinderImpl.class;
        Method method = clazz.getDeclaredMethod("maxValue", BinaryTree.class);
        method.setAccessible(true);
        assertEquals(15, method.invoke(clazz.newInstance(), root));
    }

    public void testPrivateMethodMinValue()
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        BinaryTree node1 = new BinaryTree(15, null, null);
        BinaryTree node2 = new BinaryTree(7, null, node1);
        BinaryTree root = new BinaryTree(10, node2, null);

        Class<?> clazz = MinimumFinderImpl.class;
        Method method = clazz.getDeclaredMethod("minValue", BinaryTree.class);
        method.setAccessible(true);
        assertEquals(7, method.invoke(clazz.newInstance(), root));
    }

}
