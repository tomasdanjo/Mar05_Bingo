package BingoPattern;

import Bingo.BingoCard;
import BingoChecker.BingoColumnChecker;
import BingoChecker.BingoRowChecker;

public class BingoPatternPlus extends BingoPattern{
    public BingoPatternPlus(BingoCard card) {
        super(card);
    }

    @Override
    public void run() {

        checkers.add(new BingoRowChecker(card,3));
        checkers.add(new BingoColumnChecker(card,3));
        super.run();
    }

}
