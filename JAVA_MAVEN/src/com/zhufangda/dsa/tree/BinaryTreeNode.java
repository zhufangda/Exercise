/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-03 23:14:44
 * @LastEditTime: 2019-11-25 11:37:49
 * @LastEditors: ZHU Fangda
 * @Description: 数据结构与算法（java描述）-邓俊辉-p125
 * @FilePath: \tree\src\dsa\tree\BinaryTreeNode.java
 */

package com.zhufangda.dsa.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 基于链表节点实现的二叉树节点
 */
public class BinaryTreeNode<T> implements BinaryTreePosition<T> {
    /**
     * 节点中存放的对象
     */
    private T element;

    /** 父节点 */
    private BinaryTreePosition<T> parent;

    /** 左节点 */
    private BinaryTreePosition<T> leftChild;
    /** 右节点 */
    private BinaryTreePosition<T> rightChild;
    /** 后代数目（包含当前节点） */
    private int size;
    /** 当前节点高度 */
    private int height;
    /** 当前节点深度 */
    private int depth;

    /********************** 构造方法 ****************************/
    public BinaryTreeNode() {
        this(null, null, true, null, null);
    }

    /**
     * 创建孤立结点, 结点无双亲,无子女.结点存储element作为数值
     * @param element 结点要存储的对象
     */
    public BinaryTreeNode(T element) {
        this(element, null, false, null, null);
    }

    /**
     * 构造函数
     *
     * @param element     节点内容
     * @param parent      父节点
     * @param asLeftChild 是否作为父节点左孩子
     * @param leftChild   左孩子
     * @param rightChild  右孩子
     */
    public BinaryTreeNode(T element, BinaryTreePosition<T> parent, boolean asLeftChild, BinaryTreePosition<T> leftChild,
            BinaryTreePosition<T> rightChild) {

        this.size = 1;
        this.height = this.depth = 0;

        this.element = element;

        if (null != parent) {
            if (asLeftChild)
                parent.attachLeft(this);
            else
                parent.attachRight(this);
        }

        this.attachLeft(leftChild);
        this.attachRight(rightChild);
    }

    /********************** Position接口 ****************************/
    @Override
    public T getElem() {
        return this.element;
    }

    @Override
    public T setElem(T t) {
        T oldElem = this.element;
        this.element = t;
        return oldElem;
    }

    /********************** BinaryTreePosition接口 ****************************/
    @Override
    public boolean hasParent() {
        return parent != null;
    }

    @Override
    public BinaryTreePosition<T> getParent() {
        return this.parent;
    }

    @Override
    public void setParent(BinaryTreePosition<T> parent) {
        this.parent = parent;
    }

    @Override
    public boolean isLeaf() {
        return !hasLeftChild() && !hasRightChild();
    }

    @Override
    public boolean isLeftChild() {
        return hasParent() && this == parent.getLeftChild();
    }

    @Override
    public boolean hasLeftChild() {
        return null != leftChild;
    }

    @Override
    public BinaryTreePosition<T> getLeftChild() {
        return leftChild;
    }

    @Override
    public void setLeftChild(BinaryTreePosition<T> leftChild) {
        this.leftChild = leftChild;

    }

    @Override
    public boolean isRightChild() {
        return hasParent() && this == parent.getRightChild();
    }

    @Override
    public boolean hasRightChild() {
        return null != rightChild;
    }

    @Override
    public BinaryTreePosition<T> getRightChild() {
        return rightChild;
    }

    @Override
    public void setRightChild(BinaryTreePosition<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void updateSize() {
        size = 1;
        if (hasLeftChild())
            size += getLeftChild().getSize();
        if (hasRightChild())
            size += getRightChild().getSize();
        if (hasParent())
            getParent().updateSize();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void updateHeight() {
        height = 0;
        if (hasLeftChild()){
            height = Math.max(height, 1 + leftChild.getHeight());
        }

        if (hasRightChild()){
            height = Math.max(height, 1 + rightChild.getHeight());
        }


        if (hasParent())
            parent.updateHeight();
    }

    @Override
    public int getDepth() {
        return this.depth;
    }

    @Override
    public void updateDepth() {

        depth = hasParent()?1+parent.getDepth():0;

        if(hasLeftChild()){
            leftChild.updateDepth();
        }

        if(hasLeftChild()){
            rightChild.updateDepth();
        }


    }

    @Override
    public BinaryTreePosition<T> getPrev() {
        // 如果左子树非空, 则其中最大者即为当前节点的直接前驱
        if (hasLeftChild())
            return findMinDescendant(getLeftChild());
        // 如果是右孩子, 则返回父节点
        if (isRightChild())
            return getParent();

        BinaryTreePosition<T> v = this;
        while (v.isLeftChild()) {
            v = v.getParent();
        }

        return v.getParent();
    }

    @Override
    public BinaryTreePosition<T> getSucc() {
        if (hasRightChild())
            return findMaxDescendant(getRightChild());
        if (isLeftChild())
            return getParent();

        BinaryTreePosition<T> v = this;
        while (v.isRightChild()) {
            v = v.getParent();
        }
        return v.getParent();
    }

    @Override
    public BinaryTreePosition<T> secede() {
        if (null != parent) {
            if (isLeftChild())
                parent.setLeftChild(null);
            else
                parent.setRightChild(null);

            parent.updateHeight();
            parent.updateSize();

            parent = null;
            updateDepth();
        }

        return this;
    }

    @Override
    public BinaryTreePosition<T> attachLeft(BinaryTreePosition<T> c) {
        if (hasLeftChild())
            getLeftChild().secede();

        leftChild = c;
        if (null != c) {
            c.secede();
            c.setParent(this);

            c.updateDepth();
        }

        updateSize();
        updateHeight();

        return this;
    }

    @Override
    public BinaryTreePosition<T> attachRight(BinaryTreePosition<T> c) {
        if (hasRightChild())
            getRightChild().secede();

        rightChild = c;

        if (null != c) {
            c.secede();
            c.setParent(this);
            c.updateDepth();
        }

        updateSize();
        updateHeight();

        return this;
    }


    @Override
    public Iterator<BinaryTreePosition<T>> inorderIterator() {
        List<BinaryTreePosition<T>> list = new ArrayList<>();
        inorder(list, this);
        return list.iterator();
    }

    @Override
    public Iterator<BinaryTreePosition<T>> postorderIterator() {
        List<BinaryTreePosition<T>> list = new ArrayList<>();
        postorder(list, this);
        return list.iterator();
    }

    @Override
    public Iterator<BinaryTreePosition<T>> levelorderIterator() {
        List<BinaryTreePosition<T>> list = new ArrayList<>();
        levelorder(list, this);
        return list.iterator();

    }

    /********* 辅助方法 ********************************/
    /**
     * 在参数v的后代中找到最小的后代
     *
     * @param <E> 泛型参数
     * @param v   待寻找的节点
     * @return 返回v节点的最小后代
     */
    protected static <E> BinaryTreePosition<E> findMinDescendant(BinaryTreePosition<E> v) {
        if (null != v) {
            while (v.hasLeftChild())
                v = v.getLeftChild();
        }

        return v;
    }

    /**
     * 在参数v的后代中找到最大的后代
     *
     * @param <E> 泛型参数
     * @param v   待寻找的节点
     * @return 返回v节点的最大后代
     */
    protected static <E> BinaryTreePosition<E> findMaxDescendant(BinaryTreePosition<E> v) {

        if (null != v) {
            while (v.hasRightChild())
                v = v.getRightChild();
        }

        return v;
    }

    /**
     * 前序遍历以v为根节点的子树
     *
     * @param list
     * @param v
     */
    private static <E> void preorder(List<BinaryTreePosition<E>> list, BinaryTreePosition<E> v) {
        if (null == v)
            return;
        list.add(v);
        if (v.hasRightChild())
            preorder(list, v.getLeftChild());
        if (v.hasLeftChild())
            preorder(list, v.getLeftChild());
    }

    private static <E> void inorder(List<BinaryTreePosition<E>> list, BinaryTreePosition<E> v) {
        if (null == v)
            return;
        if (v.hasRightChild())
            inorder(list, v.getLeftChild());
        list.add(v);
        if (v.hasRightChild())
            inorder(list, v.getLeftChild());
    }

    private static <E> void postorder(List<BinaryTreePosition<E>> list, BinaryTreePosition<E> v) {
        if (null == v)
            return;

        if (v.hasRightChild())
            postorder(list, v.getLeftChild());
        if (v.hasLeftChild())
            postorder(list, v.getLeftChild());
        list.add(v);
    }

    private static <E> void levelorder(List<BinaryTreePosition<E>> list, BinaryTreePosition<E> v) {
        Queue<BinaryTreePosition<E>> queue = new LinkedList<>();

        queue.add(v);
        while(!queue.isEmpty()){
            v = queue.poll();
            list.add(v);

            if(v.hasLeftChild()){
                queue.add(v.getLeftChild());
            }

            if(v.hasRightChild()){
                queue.add(v.getRightChild());
            }

        }


    }

    @Override
    public Iterator<BinaryTreePosition<T>> preorderIterator() {
        return null;
    }

    /********************* 重写Object方法 ******************/
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("(").append(hasParent()?parent.getElem():null)
               .append(")->") . append(getElem())
               .append("->(")
               .append(hasLeftChild()?leftChild.getElem():null)
               .append(",")
               .append(hasRightChild()?rightChild.getElem():null)
               .append(")");
        return builder.toString();
    }

}
