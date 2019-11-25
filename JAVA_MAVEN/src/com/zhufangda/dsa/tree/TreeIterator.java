package com.zhufangda.dsa.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-03 17:54:07
 * @LastEditTime: 2019-11-22 10:51:16
 * @LastEditors: ZHU Fangda
 * @Description: 数据结构与算法（java描述）-邓俊辉 p120
 * @FilePath: \tree\src\TreeIterator.java
 */
public class TreeIterator<T> implements Iterator<T>{
    private List<Tree<T>> list;
    private int nextPosition=-1;


    public TreeIterator(){
        this.list = null;
        this.nextPosition = 0;
    }

    public void preorderIterator(Tree<T> tree){
        if(tree==null){
            return;
        }

        list.add(tree);

        Tree<T> iter = tree.getFirstChild();
        while(null != tree){
            preorderIterator(iter);
            iter = iter.getNextSibling();
        }

    }

    public void postorderIterator(Tree<T> tree){
        if(tree==null){
            return;
        }

        Tree<T> iter = tree.getNextSibling();
        while(null!=iter){
            postorderIterator(iter);
            iter = iter.getNextSibling();
        }

        list.add(tree);
    }

    public void levelTraversalIterator(Tree<T> tree){
        if(tree==null){
            return;
        }



        Queue<Tree<T>> queue = new LinkedList<>();
        list.add(tree);

        Tree<T>  iter = null;
        while(!queue.isEmpty()){
            iter = queue.remove();
            list.add(iter);
            iter = iter.getFirstChild();
            while(iter!=null){
                queue.add(iter);
                iter = iter.getNextSibling();
            }
        }
    }

	@Override
	public boolean hasNext() {
        return nextPosition != -1;
	}

    @Override
    public T next() {
        if(!hasNext()) throw new NoSuchElementException("No next element!");

        if(nextPosition == list.size()-1){
            nextPosition = -1;
        }else{
            nextPosition++;
        }
        return list.get(nextPosition).getElem();
    }

}
