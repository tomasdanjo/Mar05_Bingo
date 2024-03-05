package Bingo;

import BingoChecker.BingoColumnChecker;
import BingoChecker.BingoRowChecker;
import BingoPattern.BingoPatternHash;
import BingoPattern.BingoPatternPlus;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BingoGame implements Runnable{
    public static boolean [] result;
    public static boolean bingo;
    ArrayList<BingoCard> cards;

    public BingoGame() {
        cards = new ArrayList<>();
        bingo = false;
        result = new boolean[76];
        result[0] = true;
        for(int i=1;i<76;i++){
            result[i] = false;
        }
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many players? ");
        int cnt = sc.nextInt();
        cards = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            cards.add(new BingoCard(i+1));
        }
        for (BingoCard card : cards) {
            System.out.println("Card " + card.id);
            System.out.println(card);
        }

//        ArrayList<Thread> thrds = new ArrayList<>();
//        for(int i=0;i<cnt;i++){
//            thrds.add(new Thread(new BingoColumnChecker(cards.get(i),3)));
//            thrds.add(new Thread(new BingoRowChecker(cards.get(i),3)));
//
//        }

//        for(Thread i: thrds){
//            i.start();
//        }

        ArrayList<Thread> patternThreads = new ArrayList<>();
        for(int i=0;i<cnt;i++){
            patternThreads.add(new Thread(new BingoPatternPlus(cards.get(i))));
            patternThreads.add(new Thread(new BingoPatternHash(cards.get(i))));
        }

        for(Thread i :patternThreads){
            i.start();
        }

        while(!bingo){
            Random random = new Random();
            int randomNum = random.nextInt(75)+1;

            while(result[randomNum]==true){
                randomNum = random.nextInt(75)+1;

            }
            result[randomNum]=true;
            System.out.println("Number: "+randomNum);
            synchronized (result){
                result.notifyAll();
            }



            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            System.out.print("Wala pa napilian: ");
            for(int i=1;i<76;i++){
                if(!result[i]){
                    System.out.print(i+" ");
                }

            }
            System.out.println();


        }

        System.out.print("All numbers chosen: ");
        for(int i=1;i<76;i++){
            if(result[i]){
                System.out.print(i+" ");
            }
        }

        System.out.println();
        for(Thread i : patternThreads){
            i.interrupt();
        }


        // TODO randomly get number from 1-75 while not bingo
    }

}


