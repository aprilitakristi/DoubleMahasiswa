package com.company;

/**
 * Created by Aprilita on 2/10/2017.
 */
public interface Interface {
    public boolean isAvailable(Node<Mahasiswa> param,String nim);
    public void insertFirst(Node<Mahasiswa> baru);
    public void insertLast(Node<Mahasiswa> baru);
    public void insertAfter(String nimdepan,Node<Mahasiswa> baru);
    public void display();
    public void deleteFirst();
    public void deleteLast();
    public void deleteByNim(String nim);

}
