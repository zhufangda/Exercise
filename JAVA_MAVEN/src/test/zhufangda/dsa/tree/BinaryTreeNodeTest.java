package test.zhufangda.dsa.tree;

import com.zhufangda.dsa.tree.BinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {
    BinaryTreeNode<Integer> node1;
    BinaryTreeNode<Integer> node2;
    BinaryTreeNode<Integer> left;
    BinaryTreeNode<Integer> right;
    BinaryTreeNode<Integer> parent;

    @BeforeEach
    void beforeEach(){
        node1 = new BinaryTreeNode<>(13);
        parent = new BinaryTreeNode<>(16);

        left = new BinaryTreeNode<>(15);
        right = new BinaryTreeNode<>(11);

        node2 = new BinaryTreeNode<Integer>(20
            , parent
            , false
            , left
            , right);


    }
    @Test
    void constructor(){

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
    void getElem() {
        assertEquals(13, node1.getElem());
        assertEquals(20, node2.getElem());

    }

    @Test
    void setElem() {
        node1.setElem(12);
        assertEquals(node1.getElem(),12);
    }

    @Test
    void hasParent() {
        assertFalse(node1.hasParent());
        assertTrue(node2.hasParent());
    }

    @Test
    void getParent() {
        assertNull(node1.getParent());
        assertEquals(node2.getParent(), parent);
    }

    @Test
    void setParent() {
        node1.setParent(left);
        assertEquals(left, node1.getParent());
    }

    @Test
    void isLeaf() {
        assertTrue(node1.isLeaf());
        assertFalse(node2.isLeaf());
    }

    @Test
    void isLeftChild() {
        assertTrue(left.isLeftChild());
        assertFalse(right.isRightChild());
    }

    @Test
    void hasLeftChild() {
        assertFalse(node1.hasLeftChild());
        assertTrue(node2.hasLeftChild());
    }

    @Test
    void getLeftChild() {
        assertNull(node1.getLeftChild());
        assertEquals(left, node2.getLeftChild());
    }

    @Test
    void setLeftChild() {
        assertNull(node1.getLeftChild());
        node1.setLeftChild(left);
        assertEquals(left, node1.getLeftChild());
    }

    @Test
    void isRightChild() {
        assertTrue(left.isRightChild());
        assertFalse(right.isRightChild());
    }

    @Test
    void hasRightChild() {
        assertFalse(node1.hasRightChild());
        assertTrue(node2.hasRightChild());
    }

    @Test
    void getRightChild() {
        assertNull(node1.getLeftChild());
        assertEquals(left, node2.getLeftChild());
    }

    @Test
    void setRightChild() {
        assertNull(node1.getRightChild());
        node1.setRightChild(left);
        assertEquals(left, node1.getRightChild());
    }

    @Test
    void seced() {
        assertNotNull(node2.getParent());
        assertEquals(node2, parent.getRightChild());
        node2.secede();
        assertNull(node2.getParent());
        assertNull(parent.getRightChild());


    }

    @Test
    void attachLeft() {
        assertNull(node1.getLeftChild());
        assertNotEquals(node1, left.getParent());
        node1.attachLeft(left);
        assertEquals(left, node1.getLeftChild());
        assertEquals(node1, left.getParent());

    }

    @Test
    void attachRight() {
    }

    @Test
    void testToString() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(20
            , null
            , false
            , null
            ,null);

        assertEquals(node.toString(), "(null)->20->(null,null)");

        node = new BinaryTreeNode<Integer>(20
                , node
                , false
                ,new BinaryTreeNode<>(15)
                ,new BinaryTreeNode<>(11));


        assertEquals(node.toString(),
            String.format("(%d)->%d->(%d,%d)"
            , node.getParent().getElem()
            , node.getElem()
            , node.getLeftChild().getElem(), node.getRightChild().getElem()));
        System.out.println(node.toString());

    }
}
