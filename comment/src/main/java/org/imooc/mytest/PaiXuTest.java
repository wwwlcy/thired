package org.imooc.mytest;

public class PaiXuTest {

    public static void main(String[] args) {
        int a[] =new int[5];
        int b[]=new int[a.length];
        for (int i = 0; i <5; i++) {
            a[i]=100-i;

        }
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]>a[j]){
                    int temp=a[j];
                    a[i]=temp;
                    a[j]=a[i];
                }
            }
            b[i]=a[i];
        }
        for (int i = 0; i <b.length ; i++) {
            System.out.println(b[i]);
        }
    }
}
