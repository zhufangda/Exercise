
/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-03 21:35:11
 * @LastEditTime: 2019-11-24 16:56:57
 * @LastEditors: ZHU Fangda
 * @Description: 数据结构与算法（Java描述）邓俊辉 p122
 * @FilePath: \tree\src\BinTree.java
 */
package com.zhufangda.dsa.tree;

import java.util.Iterator;

public interface BinaryTree<T extends Comparable<T>> {
    /**
     * 返回根节点
     * @return 根节点
     */
    public T getRoot();

    /**
     * 判断树是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 返回树的规模
     * @return 返回根的后代数目(包括根)
     */
    public int getSize();

    /**
     * 返回根的高度
     * @return 根节点的高度,如果为空树,返回-1
     */
    public int getHeight();

    /**
     * 插入元素T
     * @param T 插入元素
     */
    public void insert(T t);

    /**
     * 删除元素
     * @param T 删除元素.删除遇到的第一个与t相同的元素
     */
    public void remove(T t);


    /******************* 查找算法 ***************************/
    /**
     * 查找指定元素
     * @return true如果树包含该元素， 否则返回false
     */
    public boolean search(T value);

    /**
     * 找到最小元素
     * @return 最小的值,如果树为空树， 返回null
     */
    public T mininum();

    /**
     * 找到以指定结点node为根的子树的最小元素
     * @param node 指定子树的根节点
     * @return 以node为根的子树的包含最小值的结点,如果树为空树， 返回null
     */
    public BinaryTreePosition<T> mininum(BinaryTreePosition<T> node);

    /**
     * 找到最大元素
     * @return 最小的值，如果树为空树，则返回null
     */
    public T maximun();

    /**
     * 在以node为根节点的树中， 搜索包含最大值的结点
     * @param node 要搜索的书的根节点
     * @return 最小的值，如果树为空树，则返回null
     */
    public BinaryTreePosition<T> maximun(BinaryTreePosition<T> node);



    /**
     * 返回当前结点的后继
     * @return 当前结点的后继，若不存在返回null
     */
    public BinaryTreePosition<T> successor(BinaryTreePosition<T> node);

    /**
     * 返回参数指定的结点node的前驱
     * @param node 树中结点
     * @return 返回结点node的前驱，若不存在否则返回null
     */
    public BinaryTreePosition<T> predecessor(BinaryTreePosition<T> node);

    /*********************** 返回迭代器 ******************/
    /**
     * 前序遍历
     * @return 前序遍历迭代器
     */
    public Iterator<T> preorderIterator();

    /**
     * 中序遍历
     * @return 中序遍历迭代器
     */
    public Iterator<T> inorderIterator();

    /**
     * 后序遍历
     * @return 后续遍历迭代器
     */
    public Iterator<T> postorderIterator();

    /**
     * 层次遍历
     * @return 层次遍历迭代器
     */
    public Iterator<T> levelorderIterator();



}
