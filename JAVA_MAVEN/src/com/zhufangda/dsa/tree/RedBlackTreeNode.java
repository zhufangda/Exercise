/*
 * @description:
 * @author: ZHU Fangda
 * @Date: 2019-11-22 11:03:11
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-22 17:15:15
 */
package com.zhufangda.dsa.tree;

/**
 * interface for RedBlackTreePosition
 */
public class RedBlackTreeNode<T> extends BinaryTreeNode<T> {
  public static enum COLOR { // dans le fichier Civilite.java
    RED, BLACK
  }

  private COLOR color;

  private int blackHeight;

  public RedBlackTreeNode(T value ) {
    this(COLOR.RED);
  }


  public RedBlackTreeNode(COLOR color) {
    super();
  }

  public void setColor(COLOR color) {
    this.color = color;
  }

  public int getBlackHeight() {
    return this.blackHeight;
  }

  public void setBlackHeight(int blackHeight) {
    this.blackHeight = blackHeight;
  }




}
