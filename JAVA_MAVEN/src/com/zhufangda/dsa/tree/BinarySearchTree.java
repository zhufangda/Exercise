/*
 * @author: ZHU Fangda
 * @Description:  数据结构与算法(java描述)-邓俊辉 p131
 * @Date: 2019-11-06 11:12:57
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-25 11:34:10
 */
package com.zhufangda.dsa.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
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
  public T getRoot(){
    return root==null?null:root.getElem();
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
    return isEmpty()?0:root.getHeight();
  }

  @Override
  public void insert(T t) {
    BinaryTreePosition<T> node = new BinaryTreeNode<>(t);

    if(isEmpty()){
        root = node;
        return;
    }

    BinaryTreePosition<T> curr = root;
    BinaryTreePosition<T> parent = null;
    boolean isLeft=false;

    while (null != curr) {
      parent = curr;
      if (t.compareTo(curr.getElem()) < 0) {
        curr = curr.getLeftChild();
        isLeft = true;
      } else {
        curr = curr.getRightChild();
        isLeft=false;
      }
    }

    if (isLeft) {
      parent.attachLeft(node);
    } else {
      parent.attachRight(node);
    }
  }

  @Override
  public void remove(T t) {
      BinaryTreePosition<T> node = searchNode(t);
      if(node!=null){
          removeNode(node);
      }
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
  public BinaryTreePosition<T> searchNode(T value){
      if(value == null){
          return null;
      }

      BinaryTreePosition<T> curr = root;
      while (curr != null) {
          if (value.equals(curr.getElem())) {
              return curr;
          } else if (value.compareTo(curr.getElem()) < 0) {
              curr = curr.getLeftChild();
          } else {
              curr = curr.getRightChild();
          }
      }

      return null;


  }

  @Override
  public boolean search(T value) {
    BinaryTreePosition<T> node = searchNode(value);

    return node != null;

  }




  @Override
  public T minimum() {
    BinaryTreePosition<T> curr = minimum(root);
    if (curr == null) {
      return null;
    } else {
      return curr.getElem();
    }
  }

  @Override
  public BinaryTreePosition<T> minimum(BinaryTreePosition<T> node) {
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
      return minimum(node.getRightChild());
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
    builder.append("Tree structure ")
        .append(super.toString())
        .append("\n");

    Stack<BinaryTreePosition<T>> stack = new Stack();

    stack.add(root);
    while (!stack.isEmpty()) {
      BinaryTreePosition<T> curr = stack.pop();
      builder.append(curr).append("\n");
      if(curr.hasRightChild()) stack.add(curr.getRightChild());
      if(curr.hasLeftChild()) stack.add(curr.getLeftChild());
    }
    builder.append("------------\n");
    return builder.toString();
  }

  /************** 遍历器 **********************/
    @Override
    public Iterator<T> preorderIterator() {
        return new Iterator<T>() {
            BinaryTreePosition<T> curr;
            Boolean hasNextElement = true;

            {
                curr = root;
                hasNextElement = (curr != null);
            }

            @Override
            public boolean hasNext() {
                return hasNextElement;
            }

            @Override
            public T next() {
                if (!hasNextElement) {
                    {
                        throw new NoSuchElementException("Can not find next elements.");
                    }
                }

                T ans = curr.getElem();

                if (curr.hasLeftChild()) {
                    curr = curr.getLeftChild();
                }else if(curr.hasRightChild()){
                    curr = curr.getRightChild();
                } else if (curr.isLeftChild() && curr.getParent().hasRightChild()) {
                    curr = curr.getParent().getRightChild();
                } else {
                    while (curr.getParent()!= null) {
                        curr = curr.getParent();

                        if (curr.isLeftChild()  && curr.getParent().hasRightChild()) {
                            curr = curr.getParent().getRightChild();
                            break;
                        }
                    }


                }

                hasNextElement = curr.getParent()!=null;
                return ans;
            }
        };
    }


    @Override
    public Iterator<T> inorderIterator() {
        return new Iterator<T>() {
            BinaryTreePosition<T> curr;
            Boolean hasNextElement = true;

            {
                curr = minimum(root);
                hasNextElement = (curr != null);
            }

            @Override
            public boolean hasNext() {
                return hasNextElement;
            }

            @Override
            public T next() {
                if (!hasNextElement) {
                    {
                        throw new NoSuchElementException("Can not find next elements.");
                    }
                }

                T ans = curr.getElem();

                if (curr.hasRightChild()) {
                    curr = minimum(curr.getRightChild());
                }else{
                    while (curr.getParent() != null) {
                        if (curr.isLeftChild()) {
                            break;
                        }
                        curr = curr.getParent();
                    }
                    curr = curr.getParent();
                }

                hasNextElement = !(curr==null);
                return ans;
            }
        };

    }

    @Override
    public Iterator<T> postorderIterator() {
        return new Iterator<T>() {
            BinaryTreePosition<T> curr;
            Boolean hasNextElement = true;

            {
                curr = aux(root);
                hasNextElement = (curr != null);
            }

            @Override
            public boolean hasNext() {
                return hasNextElement;
            }

            public BinaryTreePosition<T> aux(BinaryTreePosition<T> node){
                while(node!=null){
                    if(node.hasLeftChild()){
                        node = node.getLeftChild();
                    }else if(node.hasRightChild()){
                        node = node.getRightChild();
                    }else{
                        break;
                    }
                }

                return node;
            }
            @Override
            public T next() {
                if (!hasNextElement) {
                    {
                        throw new NoSuchElementException("Can not find next elements.");
                    }
                }

                T ans = curr.getElem();

                if(curr.hasParent() && curr.isLeftChild() && curr.getParent().hasRightChild()) {
                    curr = curr.getParent().getRightChild();
                    curr = aux(curr);

                }else{
                    curr = curr.getParent();
                }

                hasNextElement = (curr!=null);
                return ans;
            }
        };
        //return root.postorderIterator();
    }

    @Override
    public Iterator<T> levelOrderIterator() {
        //TODO
        return null;
//    return root.levelorderIterator();
    }


}
