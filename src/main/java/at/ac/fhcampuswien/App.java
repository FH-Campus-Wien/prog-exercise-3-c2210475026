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

    public static long[] lcg(long x){
        long[] array = new long[10];
        long m =(long) Math.pow(2,31);
        long a=1103515245L;
        long c=12345L;
        for (int i=0;i<10;i++){
            if (i==0){
                array[0]=(((x*a)+ c)%m);         //noch kleine abweichung zu echter zahl
            }else {
                array[i]=(((array[i-1]*a)+c)%m); //same here
            }
        }
        return array;
    }
    public static void guessingGame(int numberToGuess){
        boolean loop=true;
        int counter=1;
        Scanner scanner=new Scanner(System.in);
        while (loop){
            System.out.print("Guess number "+counter+": ");
            int input=scanner.nextInt();
            if (counter==10){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                loop=false;
            } else if (numberToGuess>input){
                System.out.println("The number AI picked is higher than your guess.");
            } else if(numberToGuess<input){
                System.out.println("The number AI picked is lower than your guess.");
            } else {
                System.out.println("You won wisenheimer!");
                loop=false;
            }
            counter=counter+1;
        }
    }
    //https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
    public static int randomNumberBetweenOneAndHundred(){
        Random r =new Random();
        return r.nextInt(100)+1;  //inklusiv 0-exclusive 101
    }
    public static boolean swapArrays(int[] array1,int[] array2){
        if(array1.length!=array2.length){
            return false;
        }else {
            for (int i=0;i<array1.length;i++){
                int sub=array1[i];
                array1[i]=array2[i];
                array2[i]=sub;
            }
            return true;
        }
    }

    public static String camelCase(String input){
        StringBuilder stringbuild = new StringBuilder();
        String forbidden =",;.:'´`?!";
        input = input.toLowerCase();
        boolean fehler;
        boolean space=true;
        for (int i=0;i<input.length();i++){
            fehler=false;
            char newChar = input.charAt(i);
            if (Character.isSpaceChar(newChar)){
                space=true;
            } else if (space){
                newChar=Character.toTitleCase(newChar);
                space=false;
            }
            for( char n : forbidden.toCharArray()){
                if (newChar == n) {
                    fehler = true;
                    break;
                }
            }
            if (!fehler && !Character.isSpaceChar(newChar)){
                stringbuild.append(newChar);
            }
        }
        return stringbuild.toString();

    }
    public static void main(String[] args) {
        //oneMonthCalendar(28,1);
        //System.out.println(lcg(0));
        //guessingGame(randomNumberBetweenOneAndHundred());
        camelCase("my name isn't Alice!");
    }
}