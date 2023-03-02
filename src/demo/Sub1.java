package demo;

import javafx.scene.Scene;

import java.util.Scanner;

public class Sub1 extends Thread{
   private int min=10 ;
   private int sec=0 ;

//    public Sub1() {
//    }
//
//    public Sub1(int min, int sec) {
//        this.min = min;
//        this.sec = sec;
//    }
//    public  void nhap(){
//        Scanner dl = new Scanner(System.in);
//        System.out.println("Nhập giờ :");
//        min= dl.nextInt();
//        System.out.println("Nhập giây:");
//        sec = dl.nextInt();
//    }

    @Override
    public void run(){


        for (int m=min; m>=0;m--){
            int bd ;
            int dl;
           if (m==min){
                bd = sec;
           }else {
               bd=59;
           }
           if (m==0){
               dl=0;
           }else {
               dl=-1;
           }
           for (int s=bd;s>dl;s--) {
               System.out.println(m  +":"+ s );

               try {
                   Thread.sleep(1000);
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }
           }
        }
    }
}
