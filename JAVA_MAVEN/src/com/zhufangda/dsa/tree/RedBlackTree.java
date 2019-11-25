/*
 * @description:
 * @author: ZHU Fangda
 * @Date: 2019-11-22 11:11:06
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-22 17:43:09
 */
package com.zhufangda.dsa.tree;

import java.util.Iterator;

/**
 * LinkedRedBlackTree
 */
public class RedBlackTree<T extends Comparable<T>> implements BinaryTree<T> {
  /**
   * 黑高
   */
  private int blackHeight;

  /**
   * 根节点
   */
  private RedBlackTreeNode<T> root;

  /**
   * 节点数目（不含子叶节点）
   */
  private int size;

  /**
   * 获得树的黑高
   * @return
   */
  public int getBlackHeight() {
    return root.getBlackHeight();
  }

  /***
   * 对参数节点左旋
   *
   * @param node 要旋转的节点
   * @throws Exception
   */
  public void leftRotation(RedBlackTreeNode<T> node) throws Exception {
    if (node.getRightChild() == null) {
      throw new Exception("Illegal Exception. Can not do lefr roation");
    }

    BinaryTreePosition<T> parent = node.getParent();
    BinaryTreePosition<T> y = node.getRightChild();

    // 将y结点与node的父节点相连
    if (node.isLeftChild()) {
      parent.attachLeft(y);
    } else {
      parent.attachRight(y);
    }

    node.attachRight(y.getLeftChild());
    y.attachLeft(node);

  }

  /***
   * 对参数结点右旋
   * @param node 要旋转的结点
   */

  public void rightRotation(RedBlackTreeNode<T> node) throws Exception {
    if (node.getLeftChild() == null) {
      throw new Exception("Illegal Exception. Can not do lefr roation");
    }

    BinaryTreePosition<T> parent = node.getParent();
    BinaryTreePosition<T> y = node.getRightChild();

    // 将y结点与node的父节点相连
    if (node.isLeftChild()) {
      parent.attachLeft(y);
    } else {
      parent.attachRight(y);
    }

    node.attachRight(y.getLeftChild());
    y.attachLeft(node);

  }

  @Override
  public T getRoot() {
    return root.element;
  }

  @Override
  public boolean isEmpty() {
    return root==null;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public int getHeight() {
      //TODO
    return 0;
  }



  @Override
  public Iterator<T> preorderIterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterator<T> inorderIterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterator<T> postorderIterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterator<T> levelorderIterator() {

    return null;
  }

  @Override
  public String toString() {

    return super.toString();
  }

  @Override
  public void insert(T t) {

    BinaryTreePosition<T> node = new RedBlackTreeNode<T>(t);

    // 树为空时直接插入结点
    if (root == null) {
      this.root = (RedBlackTreeNode<T>) node;
      return;
    }


    BinaryTreePosition<T> parent = null; //当前结点双亲
    BinaryTreePosition<T> curr = root; //当前结点

    //找到插入点
    while (curr != null) {
      parent = curr;
      if (t.compareTo(curr.getElem()) < 0) {
        curr = curr.getLeftChild();
      } else {
        curr = curr.getRightChild();
      }
    }

    if (t.compareTo(parent.getElem()) < 0) {
      parent.attachLeft(node);
    } else {
      parent.attachRight(node);
    }
  }

  @Override
  public void remove(T t) {

    BinaryTreePosition<T> parent = null; //当前结点双亲
    BinaryTreePosition<T> curr = root; //当前结点

    while (curr != null) {

      if (t.compareTo(curr.getElem()) < 0) {
        curr = curr.getLeftChild();
      } else if (t.compareTo(curr.getElem()) > 0) {
        curr = curr.getRightChild();
      } else {

      }
    }
    // TODO Auto-generated method stub

  }

    @Override
    public boolean search(T value) {
        return false;
    }

    @Override
    public T mininum() {
        return null;
    }

    @Override
    public BinaryTreePosition<T> mininum(BinaryTreePosition<T> node) {
        return null;
    }

    @Override
    public T maximun() {
        return null;
    }

    @Override
    public BinaryTreePosition<T> maximun(BinaryTreePosition<T> node) {
        return null;
    }

    @Override
    public BinaryTreePosition<T> successor(BinaryTreePosition<T> node) {
        return null;
    }

    @Override
    public BinaryTreePosition<T> predecessor(BinaryTreePosition<T> node) {
        return null;
    }
}

