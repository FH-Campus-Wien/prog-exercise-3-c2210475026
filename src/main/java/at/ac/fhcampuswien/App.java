package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void oneMonthCalendar(int tage,int firstday){
        boolean loop =true;
        int tag=1;
        for(int o=1;o<firstday;o++){    //leezeichen für die darstellung
            System.out.print("   ");
        }
        firstday=firstday-1;
        while(loop){
            for(int s=1+firstday;s<=7;s++){         //jede Reihe, max 7 Tage
                if(tag<=9 && tag>=1){                  //wenn die Tage einstellig sind wird auch ein Leerzeichen davor geprintet
                    System.out.print(" "+tag+" ");
                } else {                                //wenn Tag zweistellig wird geprintet
                    System.out.print(tag+" ");
                    if(tag==tage){                      //wenn letzter tag erreicht loop beenden
                        loop=false;
                        break;
                    }
                }
                tag=tag+1;                              //tage werden hochgezählt
                firstday=0;                             //nach der ersten Zeile soll das Datum immer am "Montag" ausgegeben werden
            }
            System.out.println();                       //nächste Zeile
        }
    }

    public static long[] lcg(long x){
        long[] array = new long[10];
        long m =(long) Math.pow(2,31);
        long a=1103515245L;
        long c=12345L;                      //alles in Long casten
        for (int i=0;i<10;i++){
            if (i==0){
                array[0]=(((x*a)+ c)%m);         //bei erster Rechnung wird der Startwert genommen
            }else {
                array[i]=(((array[i-1]*a)+c)%m); //nach erster Rechnung wird immer die ArrayStelle davor als "Startwert" genommen
            }
        }
        return array;
    }
    public static void guessingGame(int numberToGuess){
        boolean loop=true;
        int counter=1;
        Scanner scanner=new Scanner(System.in);
        while (loop){                       //wird solange geguessed bis richtig erraten oder nach 10 versuchen
            System.out.print("Guess number "+counter+": ");
            int input=scanner.nextInt();
            if (counter==10){                  //output wenn 10ter versuch erreicht
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                loop=false;                     //loop wird beendet
            } else if (numberToGuess>input){
                System.out.println("The number AI picked is higher than your guess.");
            } else if(numberToGuess<input){
                System.out.println("The number AI picked is lower than your guess.");
            } else {            //output wenn richtig erraten if(input==numberToGuess)
                System.out.println("You won wisenheimer!");
                loop=false;
            }
            counter=counter+1;
        }
    }
    //https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
    public static int randomNumberBetweenOneAndHundred(){
        Random r =new Random();
        return r.nextInt(100)+1;  //nextInt(x) -> inkl. 0 exkl. x, da 1-100 so berechnet
    }
    public static boolean swapArrays(int[] array1,int[] array2){
        if(array1.length!=array2.length){           //wenn arrays nicht gleich lang false
            return false;
        }else {                             //wenn sie gleichlang dann swappen mit zwischenvariable
            for (int i=0;i<array1.length;i++){
                int sub=array1[i];
                array1[i]=array2[i];
                array2[i]=sub;
            }
            return true;
        }
    }

    public static String camelCase(String input){
        StringBuilder stringbuild = new StringBuilder();    //unser return
        String forbidden =",;.:'´`?!";          //alles was verboten ist
        input = input.toLowerCase();            //input wird klein gemacht
        boolean fehler;
        boolean space=true;                     //da erster Char bei output Groß sein soll muss am anfang true sein
        for (int i=0;i<input.length();i++){     //jede stelle von eingabe wird durchiteriert
            fehler=false;                       //fehler wird bei jeder stelle wieder auf false gesetzt
            char newChar = input.charAt(i);     //die Stelle die gecheckt werden soll
            if (Character.isSpaceChar(newChar)){
                space=true;                     //falls es Space ist nächste Stelle groß
            } else if (space){
                newChar=Character.toTitleCase(newChar); //nächste Stelle wird groß
                space=false;
            }
            for( char n : forbidden.toCharArray()){
                if (newChar == n) {         //wird gecheckt ob input an der current Stelle einen nicht erwünschten Input hat
                    fehler = true;
                    break;
                }
            }
            if (!fehler && !Character.isSpaceChar(newChar)){
                stringbuild.append(newChar);        //wenn Stelle kein Space und erwünscht ist wird sie zum output String hinzugefügt
            }
        }
        return stringbuild.toString();              //return den output (Datatype String)
    }

    public static int checkDigit(int[] zahlen){
        int[] gewichtung= new int[zahlen.length];
        for(int i=0;i<zahlen.length;i++){
            gewichtung[i]=i+2;
        }
        int summe=0;
        for (int i=0;i< zahlen.length;i++){
            summe = summe + (zahlen[i]*gewichtung[i]);
        }
        int rest = summe%11;
        int prufnr =11-rest;
        if (prufnr==10){
            return 0;
        }else if(prufnr==11){
            return 5;
        }else {
            return prufnr;
        }
    }


    public static void main(String[] args) {
        //oneMonthCalendar(28,1);
        //System.out.println(lcg(0));
        //guessingGame(randomNumberBetweenOneAndHundred());
        //camelCase("my name isn't Alice!");
        checkDigit(new int[]{3, 9, 1, 5, 8});
    }
}