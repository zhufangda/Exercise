/*
 * @Author: your name
 * @Date: 2019-11-03 16:22:28
 * @LastEditTime: 2019-11-22 10:51:39
 * @LastEditors: ZHU Fangda
 * @Description: In User Settings Edit
 * @FilePath: \tree\src\dsa\tree\LinkedListTree.java
 */
/*
 * @Author: ZHU Fangda
 * @Description: 数据结构与算法（java描述） 邓俊辉 p114
 * @FilePath: \tree\src\LinkedListTree.java
 */

package com.zhufangda.dsa.tree;

public class LinkedListTree<T> implements Tree<T>{
    private T element;
    private LinkedListTree<T> parent, firstChild, nextSibling;

    public LinkedListTree(){

    }


    public LinkedListTree(LinkedListTree<T> parent,
                          LinkedListTree<T> firstChild,
                          LinkedListTree<T> nextSibling){
        this.parent = parent;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }

    @Override
    public T getElem() {
        return element;
    }

    @Override
    public T setElem(T t) {
        T oldElem = this.element;
        this.element = t;
        return oldElem;
    }

    @Override
    public LinkedListTree<T> getParent() {
        return this.parent;
    }

    @Override
    public LinkedListTree<T> getFirstChild() {
        return this.firstChild;
    }

    @Override
    public LinkedListTree<T> getNextSibling() {
        return this.nextSibling;
    }

    @Override
    public int getSize() {
        int size = 1;
        LinkedListTree<T> iter = this.firstChild;
        while(null!=iter){
            size += iter.getSize();
            iter = iter.getNextSibling();
        }

        return size;
    }

    @Override
    public int getHeight() {
        int height = -1;
        LinkedListTree<T> iter = this.firstChild;

        while(null!=iter){
            height = Math.max(height, iter.getHeight());
            iter = iter.getNextSibling();
        }

        return height+1;
    }

    @Override
    public int getDepth() {
        int depth=0;
        LinkedListTree<T> iter = parent;
        while(null!=iter){
            depth++;
            iter = iter.getParent();
        }
        return depth;
    }


}
