package com.company;

/**
 * Created by Aprilita on 2/10/2017.
 */
public class Node<T> {
    public T data;
    public Node next=null;
    public Node prev=null;

    public Node(T data) {
        this.data = data;
        next=prev=null;
    }

    public T getData() {
        return data;
    }

}
