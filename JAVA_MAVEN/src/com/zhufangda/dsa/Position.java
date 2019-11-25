/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-03 21:38:05
 * @LastEditTime: 2019-11-22 10:49:33
 * @LastEditors: ZHU Fangda
 * @Description: 数据结构与算法（java描述） 邓俊辉 p57
 * @FilePath: \tree\src\Position.java
 */
package com.zhufangda.dsa;

/**
 * 位置ADT接口
 * @param <T> 节点存储对象类型
 */
public interface Position<T>{
    /**
     * 返回当前节点中存放的对方
     * @return 当前节点存储的元素
     */
    public T getElem();

    /**
     * 将参数指定对象存入当前节点，并返回此前内容
     * @param t 要存入的对象
     * @return 此前节点存储对象
     */
    public T setElem(T t);
}
