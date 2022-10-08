package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void oneMonthCalendar(int tage,int firstday){
        boolean loop =true;
        int tag=1;
        for(int o=1;o<firstday;o++){
            System.out.print("   ");
        }
        firstday=firstday-1;
        while(loop){
            for(int s=1+firstday;s<=7;s++){
                if(tag<=9 && tag>=1){
                    System.out.print(" "+tag+" ");
                } else {
                    System.out.print(tag+" ");
                    if(tag==tage){
                        loop=false;
                        break;
                    }
                }
                tag=tag+1;
                firstday=0;
            }
            System.out.println();
        }
    }

    public static void lcg(long x){
        long[] array = new long[10];
        double m =2e+31;
        int a=1103515245;
        int c=12345;
        for (int i=0;i<10;i++){
            if (i==0){
                array[0]=((x*a)+c)%(int)m;
            }else {
                array[i]=((array[i-1]*a)+c)%(int)m;
            }
        }
        System.out.println(array);


    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }
}