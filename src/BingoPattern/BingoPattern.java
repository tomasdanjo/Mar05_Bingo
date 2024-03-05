package BingoPattern;

import Bingo.BingoCard;
import Bingo.BingoGame;
import BingoChecker.*;

import java.util.ArrayList;
import java.util.List;

import static Bingo.BingoGame.bingo;

public abstract class BingoPattern implements Runnable {

    public List<BingoChecker> checkers;
    Bingo.BingoCard card;

    public BingoPattern(Bingo.BingoCard card) {
        this.card = card;
        checkers = new ArrayList<BingoChecker>();
    }

    @Override
    public void run() {
        ArrayList<Thread> thrds = new ArrayList<>();
        for(BingoChecker i : checkers){
            thrds.add(new Thread(i));
        }

        for(Thread i: thrds){
            i.start();
        }

        for(Thread i: thrds){
            try {
                i.join();
            } catch (InterruptedException e) {

                System.out.println("Card "+card.id+" loses");
                return;
            }
        }

//        System.out.println("Card "+card.id+" loses");
        bingo = true;
        System.out.println("Card "+ card.id+" completes pattern" );
        System.out.println(card);
//        Thread.interrupted();




    }
}
