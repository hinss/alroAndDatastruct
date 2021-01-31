package com.hins.base.datastruct.map;

import java.util.HashMap;

/**
 * @Description: 二分搜索树实现的映射数据结构
 * @Author:Wyman
 * @Date:2019
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {


    class Node{
        K key;
        V value;
        Node left,right;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){

        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K key,V value){
       root = add(root,key,value);
    }


    private Node add(Node node,K key,V value){

        if(node == null){
            size++;
            return new Node(key,value);
        }

        if(key.compareTo(node.key) < 0){
            node.left = add(node,key,value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node,key,value);
        }else {//key.compareTo(node.key) == 0
            node.value = value;
        }

        return node;

    }

    //返回以node为根节点的二分搜索树中,key所在的节点
    private Node getNode(Node node,K key){

        if(node == null){
            return null;
        }

        if(key.compareTo(node.key) == 0){
            return node;
        }else if(key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }else {
            return getNode(node.right,key);
        }
    }

    @Override
    public boolean contains(K key){
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key){

        Node node = getNode(root,key);
        return node == null ? null : node.value;

    }

    @Override
    public void set(K key,V newValue){

        Node node = getNode(root,key);
        if(node == null){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }

        node.value = newValue;
    }


    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }

        return minimum(node.left);
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的而分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K key){

       //// TODO: 2019/9/15 i dont want to write...
        return null;
    }


    public static void main(String[] args) {

        HashMap<Object, Object> map = new HashMap<>();
        map.put("abc",1);
    }






}
