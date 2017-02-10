package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Interface DoubleList = (DoubleLinkList) new DoubleLinkList();
	    int pilihan=0;
	    String nim,nama;

	    do{
	        System.out.println("1. AddFirst Mahasiswa");
            System.out.println("2. AddLast Mahasiswa");
            System.out.println("3. Add After nim Mahasiswa");
            System.out.println("4. View Mahasiswa");
            System.out.println("5. Delete First Mahasiswa");
            System.out.println("6. Delete Last Mahasiswa");
            System.out.println("7. Delete by nim Mahasiswa");
            System.out.println("8. Keluar");
            System.out.print("Masukkan Pilihan :");
            pilihan = scn.nextInt();
            switch (pilihan){
                case 1 :
                    System.out.print("NIM : ");
                    nim = scn.next();
                    System.out.print("NAMA : ");
                    nama = scn.next();
                    DoubleList.insertFirst(new Node(new Mahasiswa(nim,nama)));
                    break;
                case 2 :
                    System.out.print("NIM : ");
                    nim = scn.next();
                    System.out.print("NAMA : ");
                    nama = scn.next();
                    DoubleList.insertLast(new Node(new Mahasiswa(nim,nama)));
                    break;
                case 3 :
                    System.out.print("NIM : ");
                    nim = scn.next();
                    System.out.print("NAMA : ");
                    nama = scn.next();
                    System.out.print("Masukkan setelah nim :");
                    String before = scn.next();
                    DoubleList.insertAfter(before, new Node(new Mahasiswa(nim,nama)));
                    break;
                case 4 :
                    DoubleList.display();
                    break;
                case 5 :
                    DoubleList.deleteFirst();
                    break;
                case 6 :
                    DoubleList.deleteLast();
                    break;
                case 7 :
                    System.out.print("Masukkan NIM :");
                    nim = scn.next();
                    DoubleList.deleteByNim(nim);
                    break;
                default:
                    System.out.println("Proses Selesai");
            }

        }while(pilihan !=8 );


    }
}
