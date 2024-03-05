package BingoPattern;

import Bingo.BingoCard;
import BingoChecker.BingoColumnChecker;
import BingoChecker.BingoRowChecker;

public class BingoPatternHash extends BingoPattern{

    public BingoPatternHash(BingoCard card) {
        super(card);
    }

    @Override
    public void run() {

        checkers.add(new BingoRowChecker(card,2));
        checkers.add(new BingoRowChecker(card,4));
        checkers.add(new BingoColumnChecker(card,2));
        checkers.add(new BingoColumnChecker(card,4));
        super.run();
    }
}
