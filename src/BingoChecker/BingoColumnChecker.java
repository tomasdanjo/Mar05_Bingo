package BingoChecker;

import Bingo.BingoCard;
import Bingo.BingoGame;

public class BingoColumnChecker extends BingoChecker{
    int col;

    public BingoColumnChecker(BingoCard card, int col) {
        super(card);
        this.col = col-1;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            int num = card.nums[i][col];
            while(BingoGame.result[num]==false){
                try {
                    synchronized (BingoGame.result){
                        BingoGame.result.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

//        System.out.println("Card "+card.id+" done:");
//        System.out.println(card);

    }
}
