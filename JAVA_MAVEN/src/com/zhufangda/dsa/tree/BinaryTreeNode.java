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
    T element;

    /** 父节点 */
    private BinaryTreePosition<T> parent;

    /** 左节点 */
    private BinaryTreePosition<T> leftChild;
    /** 右节点 */
    private BinaryTreePosition<T> rightChild;

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

        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.element = element;

        this.parent = parent;
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
        return hasParent() && this == parent.getLeftChild() ? true : false;
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
    public BinaryTreePosition<T> secede() {
        if (null != parent) {
            if (isLeftChild())
                parent.setLeftChild(null);
            else
                parent.setRightChild(null);
            parent = null;

        }

        return this;
    }

    @Override
    public BinaryTreePosition<T> attachLeft(BinaryTreePosition<T> c) {
        if (hasLeftChild())
            getLeftChild().secede();

        if (null != c) {
            c.secede();
            c.setParent(this);
            leftChild = c;
        }

        return this;
    }

    @Override
    public BinaryTreePosition<T> attachRight(BinaryTreePosition<T> c) {
        if (hasRightChild())
            getRightChild().secede();

        if (null != c) {
            c.secede();
            c.setParent(this);
            rightChild = c;
        }

        return this;
    }


    @Override
    public int getHeight() {
        int leftHeight = hasLeftChild()?leftChild.getHeight():-1;
        int rightHeight = hasLeftChild()?leftChild.getHeight():-1;
        return Math.max();
    }

    @Override
    public int getDepth() {
        return 0;
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
