package com.zhufangda.dsa.tree;

import java.util.Iterator;
import com.zhufangda.dsa.Position;

/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-03 21:40:33
 * @LastEditTime: 2019-11-22 16:09:06
 * @LastEditors: ZHU Fangda
 * @Description: 数据结构与算法（java描述）邓俊辉 p123
 * @FilePath: \tree\src\tree\BinTreePosition.java
 */


public interface BinaryTreePosition<T> extends Position<T> {
    /**
     * 判断是否有父亲
     *
     * @description: 判断是否有父亲
     * @return: true 如果父节点存在，否则返回false
     */
    public boolean hasParent();

    /**
     * 返回父节点
     *
     * @description: 返回父节点
     * @return: 返回父节点，如果父节点不存在返回null
     */
    public BinaryTreePosition<T> getParent();

    /**
     * 设置父节点
     *
     * @description: 将函数参数parant设为父节点
     * @param parent 父节点
     */
    public void setParent(BinaryTreePosition<T> parent);

    /**
     * 判断当前节点是否为子叶.
     *
     * @return: true 如果当前节点为子叶， 否则返回false
     */
    public boolean isLeaf();

    /**
     * 判断是否为其父节点的左孩子
     *
     * @return: true如果当前节点为其父节点的左孩子， 否则返回false
     */
    public boolean isLeftChild();

    /**
     * 判断当前节点是否有左孩子
     *
     * @return: true如果当前节点有左孩子，否则返回false
     */
    public boolean hasLeftChild();

    /**
     * 获得当前节点左孩子
     *
     * @return: 返回当前结果左孩子，如果左孩子存在。否则返回null
     */
    public BinaryTreePosition<T> getLeftChild();

    /**
     * 设置当前节点右孩子。
     *
     * @param leftChild 被设为当前节点左孩子的节点
     */
    public void setLeftChild(BinaryTreePosition<T> leftChild);

    /**
     * 判断当前节点是否为其父节点右孩子
     *
     * @return: 返回true如果当前节点是其父节点的右孩子
     */
    public boolean isRightChild();

    /**
     * 判断当前节点是否有右孩子
     *
     * @return 返回true，如果当前节点有右孩子，否则返回false。
     */
    public boolean hasRightChild();

    /***
     * 获得当前节点右孩子
     *
     * @return 当前节点右孩子，如果不存在，返回null.
     */
    public BinaryTreePosition<T> getRightChild();

    /**
     * 设置当前节点右孩子
     *
     * @param rightChild 被设置为当前节点右孩子的节点
     */
    public void setRightChild(BinaryTreePosition<T> rightChild);

    /**
     * 获得当前结点后代节点数目
     *
     * @return 当前节点后代数目（包含当前节点
     */
    public int getSize();

    /**
     * 孩子发生变化后，更新当前节点及其祖先的规模
     */
    public void updateSize();

    /**
     * 返回当前节点高度
     *
     * @return 当前节点高度
     */
    public int getHeight();

    /**
     * 当前节点发生变化后， 更新当前节点及其祖先的高度
     */
    public void updateHeight();

    /**
     * 返回当前节点的深度
     *
     * @return 当前节点的深度
     */
    public int getDepth();

    /**
     * 孩子发生变化后， 更新当前节点及其祖先的规模
     */
    public void updateDepth();

    /**
     * 按照中序遍历的次序， 找到当前直接节点的前驱
     *
     * @return
     */
    public BinaryTreePosition<T> getPrev();

    /**
     * 按照中序遍历的次序， 找到当前直接节点的后继
     *
     * @return
     */
    public BinaryTreePosition<T> getSucc();

    /**
     * 断绝当前节点与其父亲的父子关系， 并返回当前节点
     *
     * @return 返回当前节点
     */
    public BinaryTreePosition<T> secede();

    /**
     * 将节点c作为当前节点的左孩子。
     * 该操作会设当前结点的左孩子为结点C， 并将结点c的父节点设为当前结点
     * @param c 要绑定的节点
     * @return
     */
    public BinaryTreePosition<T> attachLeft(BinaryTreePosition<T> c);

    /**
     * 将节点c作为当前节点的右孩子。
     * 该操作会设当前结点的右孩子为结点C， 并将结点C的父节点设为当前结点
     * @param c 要绑定的节点
     * @return
     */
    public BinaryTreePosition<T> attachRight(BinaryTreePosition<T> c);

    /**
     * 前序遍历
     * @return 前序遍历的迭代器
     */
    public Iterator<BinaryTreePosition<T>> preorderIterator();

    /**
     * 中序遍历
     * @return 前序遍历的迭代器
     */
    public Iterator<BinaryTreePosition<T>> inorderIterator();


    /**
     * 后序遍历
     * @return 前序遍历的迭代器
     */
    public Iterator<BinaryTreePosition<T>> postorderIterator();

    /**
     * 层次遍历
     * @return  层次遍历的迭代器
     */
    public Iterator<BinaryTreePosition<T>> levelorderIterator();

}

