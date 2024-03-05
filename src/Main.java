import Bingo.BingoCard;
import Bingo.BingoGame;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        Thread game = new Thread(new BingoGame());
        game.start();



    }
}