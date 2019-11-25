/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-03 16:13:48
 * @Description: 数据结构与算法(java描述) - 邓俊辉 P113
 * @FilePath: \tree\Tree.java
 */

package com.zhufangda.dsa.tree;

public interface Tree<T>{

    public T getElem();
    public T setElem(T t);
    public Tree<T> getParent();
    public Tree<T> getFirstChild();
    public Tree<T> getNextSibling();

    /**
     * @description: 返回当前节点后代元素数目
     * @return: 后代元素数目， 包括当前节点
     */
    public int getSize();

    /**
     * @description:返回当前节点的高度
     * @return: 当前节点高度
     */
    public int getHeight();
    /**
     * @description: 返回当前节点深度
     * @return: 当前节点深度
     */
    public int getDepth();

}
