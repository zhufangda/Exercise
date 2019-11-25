/*
 * @author: ZHU Fangda
 * @Description:  数据结构与算法(java描述)-邓俊辉 p131
 * @Date: 2019-11-06 11:12:57
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-25 11:34:10
 */
package com.zhufangda.dsa.tree;

import java.util.Iterator;
import java.util.Stack;

/**
 * 基于链表实现的二叉搜索树
 * @author ZHU Fangda
 */
public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {
  protected BinaryTreePosition<T> root;

  /*************************** 构造函数  **************************************/

  /**
   * 创建空树
   */
  public BinarySearchTree() {
    root = null;
  }

  /**
   * 将参数root作为根节点创建树
   * @param value 根节点包含的数值
   */
  public BinarySearchTree(T value) {
    this.root = new BinaryTreeNode<T>(value);
  }

  /*****************************BinaryTree接口方法 ***************************/
  @Override
  public T getRoot() {
    return root.getElem();
  }

  @Override
  public boolean isEmpty() {
    return root==null;
  }

  @Override
  public int getSize() {
    return isEmpty()?0:root.getSize();
  }

  @Override
  public int getHeight() {
    return isEmpty()?-1:root.getHeight();
  }

  @Override
  public Iterator<T> preorderIterator() {
      //TODO
      return null;
//      return root.preorderIterator();
  }

  @Override
  public Iterator<T> inorderIterator() {
        //TODO
      return null;
      //return root.inorderIterator();

  }

  @Override
  public Iterator<T> postorderIterator() {
      //TODO
      return null;
      //return root.postorderIterator();
  }

  @Override
  public Iterator<T> levelorderIterator() {
      //TODO
      return null;
//    return root.levelorderIterator();
  }

  @Override
  public void insert(T t) {
    BinaryTreePosition<T> node = new BinaryTreeNode<>(t);

    BinaryTreePosition<T> curr = root;
    BinaryTreePosition<T> parent = root;

    while (curr != null) {
      parent = curr;
      if (t.compareTo(curr.getElem()) <= 0) {
        curr = curr.getLeftChild();
      } else {
        curr = curr.getRightChild();
      }
    }

    if (t.compareTo(parent.getElem()) <= 0) {
      parent.attachLeft(node);
    } else {
      parent.attachRight(node);
    }
  }

  @Override
  public void remove(T t) {

  }

  /**
   * 将from为跟的子树替换为to为根结点的子树。
   * @param from 原结点
   * @param to 新节点
   */
  protected void transplant(BinaryTreePosition<T> from, BinaryTreePosition<T> to){
    if (from.getParent() == null) {
      root = to;
    } else if (from.getParent().getLeftChild() == from) {
      from.getParent().attachLeft(to);
    } else {
      from.getParent().attachRight(to);
    }
  }

  public void removeNode(BinaryTreePosition<T> node) {
    if (node.hasLeftChild() && node.hasRightChild()) {
      BinaryTreePosition<T> suc = successor(node);
      suc.attachLeft(node.getLeftChild());
      if (node.getLeftChild() != suc) {
        transplant(suc, suc.getRightChild());
        suc.attachLeft(node.getLeftChild());
      }
      transplant(node, suc);
    } else if (node.hasLeftChild()) {
      transplant(node, node.getLeftChild());
    } else {
      transplant(node, node.getRightChild());
    }
  }


  @Override
  public boolean search(T value) {
    if (value == null) {
      return false;
    }

    BinaryTreePosition<T> curr = root;
    while (curr != null) {
      if (value.equals(curr.getElem())) {
        return true;
      } else if (value.compareTo(curr.getElem()) < 0) {
        curr = curr.getLeftChild();
      } else {
        curr = curr.getRightChild();
      }
    }

    return false;
  }


  @Override
  public T mininum() {
    BinaryTreePosition<T> curr = mininum(root);
    if (curr == null) {
      return null;
    } else {
      return curr.getElem();
    }
  }

  @Override
  public BinaryTreePosition<T> mininum(BinaryTreePosition<T> node) {
    BinaryTreePosition<T> curr = node;
    if(curr==null){
      return null;
    }

    while (curr.getLeftChild() != null) {
      curr = curr.getLeftChild();
    }

    return curr;
  }

  @Override
  public T maximun() {
    BinaryTreePosition<T> curr = maximun(root);
    if (curr == null) {
      return null;
    } else {
      return curr.getElem();
    }
  }


  @Override
  public BinaryTreePosition<T> maximun(BinaryTreePosition<T> node) {
    BinaryTreePosition<T> curr = root;
    if (curr == null) {
      return null;
    }

    while (curr.getRightChild() != null) {
      curr = curr.getRightChild();
    }

    return curr;
  }



  @Override
  public BinaryTreePosition<T> successor(BinaryTreePosition<T> node) {
    if (node == null) {
      return null;
    }

    if (node.hasRightChild()) {
      return mininum(node.getRightChild());
    }

    BinaryTreePosition<T> curr = node;
    BinaryTreePosition<T> parent = node.getParent();

    while (parent != null && parent.getRightChild() == curr) {
      curr = curr.getParent();
      parent = curr.getParent();
    }

    return parent;
  }


  @Override
  public BinaryTreePosition<T> predecessor(BinaryTreePosition<T> node) {
    if (node == null) {
      return null;
    }

    if (node.hasLeftChild()) {
      return maximun(node.getLeftChild());
    }

    BinaryTreePosition<T> curr = node;
    BinaryTreePosition<T> parent = node.getParent();

    while (parent != null && parent.getLeftChild() == curr) {
      curr = parent;
      parent = curr.getParent();
    }

    return parent;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    Stack<BinaryTreePosition<T>> stack = new Stack();

    stack.add(root);
    while (!stack.isEmpty()) {
      BinaryTreePosition<T> curr = stack.pop();
      builder.append(curr).append("\n");
      if(curr.hasRightChild()) stack.add(curr.getRightChild());
      if(curr.hasLeftChild()) stack.add(curr.getLeftChild());
    }

    return builder.toString();
  }


}
