package com.company;



/**
 * Created by Aprilita on 2/10/2017.
 */
public class DoubleLinkList implements Interface {
    Node<Mahasiswa> head, tail;

    public DoubleLinkList() {
        head=null;
        tail=null;
    }

    private boolean isEmpty(){
        if(head == null && tail == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean isAvailable(Node<Mahasiswa> param, String nim) {
        if(param == null){
            return false;
        }
        if( param.data.getNim().contentEquals(nim)){
            return true;
        }
        return this.isAvailable(param.next,nim);
    }



    @Override
    public void insertFirst(Node<Mahasiswa> baru) {
        if(isEmpty()){
            head = baru;
            tail = head;
            return;
        }
        baru.next = head;
        head.prev = baru;
        head = baru;
    }

    @Override
    public void insertLast(Node<Mahasiswa> baru) {
        if(isEmpty()){
            head = baru;
            tail = head;
            return;
        }
        tail.next = baru;
        baru.prev = tail;
        tail = baru;

    }

    @Override
    public void insertAfter(String nimdepan, Node<Mahasiswa> baru) {
        if(isEmpty()){
            head = baru;
            tail = head;
            return;
        }
        if(!isAvailable(head,nimdepan)){
            System.out.println("NIM " + nimdepan + " tidak ditemukan");
            return;
        }
        head = this.insertAfter(head, nimdepan, baru);

    }

    private Node<Mahasiswa> insertAfter(Node<Mahasiswa> param, String nimdepan,Node<Mahasiswa> baru){
       if(param == null){
           return null;
       }
       if(param.data.getNim().contentEquals(nimdepan) ){
          baru.next = param.next;
          baru.prev = param;
          param.next.prev = baru;
          param.next = baru;
          return param;
       }
       param.next = this.insertAfter(param.next,nimdepan,baru);
       return param;
    }

    @Override
    public void display() {
        if(head==null){
            System.out.println("List kosong");
            return;
        }
        System.out.println("List data Mahaasiswa :");
        this.display(head);
    }

    private void display(Node<Mahasiswa> head){
        if(head != null){
            //head.data.toString();
            Mahasiswa mhs = head.getData();
            System.out.println("NIM  : "  + mhs.getNim());
            System.out.println("NAMA : "+mhs.getNama());
            System.out.println();
            this.display(head.next);
        }
    }

    @Override
    public void deleteFirst() {
        if(isEmpty()){
            System.out.println("Tidak ada data");
            return;
        }
        Node<Mahasiswa> temp = head;
        head = head.next;
        head.prev = null;
        temp = null;
        System.out.println("First Node dihapus");
    }

    @Override
    public void deleteLast() {
        if(isEmpty()){
            System.out.println("Tidak ada data");
            return;
        }
        tail = tail.prev;
        tail.next = null;
        System.out.println("Last Node dihapus");

    }


    @Override
    public void deleteByNim(String nim) {
        if(isEmpty()){
            System.out.println("Tidak ada data");
            return;
        }
        this.head = this.deleteByNim(head,nim);
        System.out.println("NIM "+nim + "dihapus");

    }
    private Node<Mahasiswa> deleteByNim(Node<Mahasiswa> param, String nim){
        if(param == null){
            return null;
        }
        //param.getData().getNim().contentEquals(nim);
        Node<Mahasiswa> temp = param;
        if(temp.getData().getNim().contentEquals(nim)){
            Node<Mahasiswa> save = param.next;
            param = null;
            return save;
        }
        param.next = this.deleteByNim(param.next,nim);
        return param;
    }
}
