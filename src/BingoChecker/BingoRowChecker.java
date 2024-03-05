package BingoChecker;

import Bingo.BingoCard;
import Bingo.BingoGame;

public class BingoRowChecker extends BingoChecker{
    int row;

    public BingoRowChecker(BingoCard card, int row) {
        super(card);
        this.row = row-1;
    }


    @Override
    public void run() {
        for(int col=0;col<5;col++){

            int num = card.nums[row][col];
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
//
//        System.out.println("Card "+card.id+" done:");
//        System.out.println(card);

    }

}
