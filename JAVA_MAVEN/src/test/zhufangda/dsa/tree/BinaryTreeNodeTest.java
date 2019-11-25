package test.zhufangda.dsa.tree;
import com.zhufangda.dsa.tree.BinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {
    private BinaryTreeNode<Integer> node1;
    private BinaryTreeNode<Integer> node2;
    private BinaryTreeNode<Integer> left;
    private BinaryTreeNode<Integer> right;
    private BinaryTreeNode<Integer> parent;

    @BeforeEach
    void testBeforeEach(){
        node1 = new BinaryTreeNode<>(13);
        parent = new BinaryTreeNode<>(16);

        left = new BinaryTreeNode<>(15);
        right = new BinaryTreeNode<>(11);

        node2 = new BinaryTreeNode<>(20
            , parent
            , false
            , left
            , right);


    }
    @Test
    void testConstructor(){

        assertNull(node1.getParent());
        assertNull(node1.getLeftChild());
        assertNull(node1.getRightChild());



        assertEquals(parent, node2.getParent());
        assertEquals(node2, parent.getRightChild());

        assertEquals(left, node2.getLeftChild());
        assertEquals(right, node2.getRightChild());

        assertEquals(20, node2.getElem());


    }


    @Test
    void testGetElem() {
        assertEquals(13, node1.getElem());
        assertEquals(20, node2.getElem());

    }

    @Test
    void testSetElem() {
        node1.setElem(12);
        assertEquals(node1.getElem(),12);
    }

    @Test
    void testHasParent() {
        assertFalse(node1.hasParent());
        assertTrue(node2.hasParent());
    }

    @Test
    void testGetParent() {
        assertNull(node1.getParent());
        assertEquals(node2.getParent(), parent);
    }

    @Test
    void testSetParent() {
        node1.setParent(left);
        assertEquals(left, node1.getParent());
    }

    @Test
    void testIsLeaf() {
        assertTrue(node1.isLeaf());
        assertFalse(node2.isLeaf());
    }

    @Test
    void testIsLeftChild() {
        assertTrue(left.isLeftChild());
        assertFalse(right.isLeftChild());
    }

    @Test
    void testHasLeftChild() {
        assertFalse(node1.hasLeftChild());
        assertTrue(node2.hasLeftChild());
    }

    @Test
    void testGetLeftChild() {
        assertNull(node1.getLeftChild());
        assertEquals(left, node2.getLeftChild());
    }

    @Test
    void testSetLeftChild() {
        assertNull(node1.getLeftChild());
        node1.setLeftChild(left);
        assertEquals(left, node1.getLeftChild());
    }

    @Test
    void testIsRightChild() {
        assertFalse(left.isRightChild());
        assertTrue(right.isRightChild());
    }

    @Test
    void testHasRightChild() {
        assertFalse(node1.hasRightChild());
        assertTrue(node2.hasRightChild());
    }

    @Test
    void testGetRightChild() {
        assertNull(node1.getLeftChild());
        assertEquals(left, node2.getLeftChild());
    }

    @Test
    void testSetRightChild() {
        assertNull(node1.getRightChild());
        node1.setRightChild(left);
        assertEquals(left, node1.getRightChild());
    }

    @Test
    void testSecede() {
        assertNotNull(node2.getParent());
        assertEquals(node2, parent.getRightChild());
        node2.secede();
        assertNull(node2.getParent());
        assertNull(parent.getRightChild());
    }

    @Test
    void testAttachLeft() {
        assertNull(node1.getLeftChild());
        assertNotEquals(node1, left.getParent());
        node1.attachLeft(left);
        assertEquals(left, node1.getLeftChild());
        assertEquals(node1, left.getParent());

    }

    @Test
    void testAttachRight() {
        assertNull(node1.getRightChild());
        assertNotEquals(node1, right.getParent());
        node1.attachRight(right);
        assertEquals(right, node1.getRightChild());
        assertEquals(node1, right.getParent());
    }

    @Test
    void testToString() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(20
            , null
            , false
            , null
            , null);

        assertEquals(node.toString(), "(null)->20->(null,null)");

        node = new BinaryTreeNode<>(20
            , node
            , false
            , new BinaryTreeNode<>(15)
            , new BinaryTreeNode<>(11));


        assertEquals(node.toString(),
            String.format("(%d)->%d->(%d,%d)"
            , node.getParent().getElem()
            , node.getElem()
            , node.getLeftChild().getElem(), node.getRightChild().getElem()));
        System.out.println(node.toString());

    }



    @Test
    void testGetSize() {
        assertEquals(1, node1.getSize());
        assertEquals(3, node2.getSize());
        assertEquals(4, parent.getSize());
    }

    @Test
    void testGetHeight() {
        assertEquals(0, node1.getHeight());
        assertEquals(2, parent.getHeight());
        assertEquals(1, node2.getHeight());

    }

    @Test
    void testGetDepth() {
        assertEquals(0, node1.getDepth());
        assertEquals(0, parent.getDepth());
        assertEquals(1, node2.getDepth());
        assertEquals(2, left.getDepth());
        assertEquals(2, right.getDepth());
    }

    @Test
    void testGetPrev() {

    }

    @Test
    void testGetSucc() {
    }

    @Test
    void testInorderIterator() {
    }

    @Test
    void testPostorderIterator() {
    }

    @Test
    void testLevelorderIterator() {
    }

    @Test
    void testFindMinDescendant() {
    }

    @Test
    void testFindMaxDescendant() {
    }

    @Test
    void testPreorderIterator() {
    }

}
