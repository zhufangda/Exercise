package test.zhufangda.dsa.tree;

import com.zhufangda.dsa.tree.BinarySearchTree;
import com.zhufangda.dsa.tree.BinaryTreePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> tree1;
    private BinarySearchTree<Integer> tree2;
    private BinarySearchTree<Integer> tree3;
    private BinarySearchTree<Integer> emptyTree;

    private int[] inputCase1 = new int[]{6, 5, 7, 2, 5, 8};
    private int[] inputCase2 = new int[]{15,6,18,3,7,17,20,2,4,13,9};
    private int[] inputCase3 = new int[]{2,5,7,6,8,5};
    @BeforeEach
    void setUp() {
        tree1 = new BinarySearchTree<>();
        for(int ele: inputCase1){
            tree1.insert(ele);
        }

        tree2 = new BinarySearchTree<>();
        for(int ele: inputCase2){
            tree2.insert(ele);
        }

        tree3 = new BinarySearchTree<>();
        for(int ele: inputCase3){
            tree3.insert(ele);
        }

        emptyTree = new BinarySearchTree<>();





    }

    @Test
    void getRoot() {
        assertNull(emptyTree.getRoot());
        assertEquals(6, tree1.getRoot());
        assertEquals(15, tree2.getRoot());
    }

    @Test
    void isEmpty() {
        assertTrue(emptyTree.isEmpty());
        assertFalse(tree1.isEmpty());
        assertFalse(tree2.isEmpty());
    }

    @Test
    void getSize() {
        assertEquals(inputCase1.length, tree1.getSize());
        assertEquals(inputCase2.length, tree2.getSize());
        assertEquals(0, emptyTree.getSize());
    }

    @Test
    void getHeight() {
        assertEquals(2, tree1.getHeight());
        assertEquals(4, tree2.getHeight());
        assertEquals(0, emptyTree.getHeight());
    }

    @Test
    void preorderIterator() {
        Iterator<Integer> iter = tree1.preorderIterator();
        int[] res = new int[tree1.getSize()];
        for(int i=0; iter.hasNext();i++){
            res[i] = iter.next();
            System.out.println(res[i]);
        }

        assertArrayEquals(new int[]{6,5,2,5,7,8}, res);



        iter = tree2.preorderIterator();
        res = new int[tree2.getSize()];
        for(int i=0; iter.hasNext();i++){
            res[i] = iter.next();
        }

        assertArrayEquals(new int[]{15,6,3,2,4,7,13,9,18,17,20}, res);

        iter = tree3.preorderIterator();
        res = new int[tree3.getSize()];
        for(int i=0; iter.hasNext();i++){
            res[i] = iter.next();
        }

        assertArrayEquals(new int[]{2,5,7,6,5,8}, res);

    }

    @Test
    void inorderIterator() {
        Iterator<Integer> iter = tree1.inorderIterator();
        int[] res = new int[tree1.getSize()];
        for(int i=0; iter.hasNext();i++){
            res[i] = iter.next();
        }

        assertArrayEquals(new int[]{2,5,5,6,7,8}, res);



        iter = tree2.inorderIterator();
        res = new int[tree2.getSize()];
        for(int i=0; iter.hasNext();i++){
            res[i] = iter.next();
        }

        assertArrayEquals(new int[]{2,3,4,6,7,9,13,15,17,18,20}, res);

        iter = tree3.inorderIterator();
        res = new int[tree3.getSize()];
        for(int i=0; iter.hasNext();i++){
            res[i] = iter.next();
        }

        assertArrayEquals(new int[]{2,5,5,6,7,8}, res);

    }

    @Test
    void postorderIterator() {
        Iterator<Integer> iter = tree1.postorderIterator();
        int[] res = new int[tree1.getSize()];
        for(int i=0; iter.hasNext();i++){
            res[i] = iter.next();

        }

        assertArrayEquals(new int[]{2,5,5,8,7,6}, res);



        iter = tree2.postorderIterator();
        res = new int[tree2.getSize()];
        for(int i=0; iter.hasNext();i++){
            res[i] = iter.next();
        }

        assertArrayEquals(new int[]{2,4,3,9,13,7,6,17,20,18,15}, res);

        iter = tree3.postorderIterator();
        res = new int[tree3.getSize()];
        for(int i=0; iter.hasNext();i++){
            res[i] = iter.next();
            System.out.println(res[i]);
        }

        assertArrayEquals(new int[]{5,6,8,7,5,2}, res);


    }

    @Test
    void levelorderIterator() {

    }

    @Test
    void insert() {


    }

    @Test
    void remove() {

    }

    @Test
    void removeNode() {

    }

    @Test
    void search() {
        BinaryTreePosition<Integer> node = tree1.searchNode(6);
        assertEquals(6, node.getElem());
        assertEquals(5, node.getLeftChild().getElem());
        assertEquals(7, node.getRightChild().getElem());

        node = tree1.searchNode(100);
        assertNull(node);

    }

    @Test
    void testMinimum() {
        assertEquals(2, tree1.minimum());
        assertEquals(2, tree2.minimum());
    }

    @Test
    void testMaximum() {
        assertEquals(8, tree1.maximun());
        assertEquals(20, tree2.maximun());
    }

    @Test
    void successor() {


    }

    @Test
    void predecessor() {

    }

    @Test
    void testToString() {

    }
}
