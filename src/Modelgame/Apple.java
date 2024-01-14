package Modelgame;

import java.util.Random;

public class Apple {

    public void createApple(){
        GameField.appleX = new Random().nextInt(20)*GameField.DOT_SIZE;
        GameField.appleY = new Random().nextInt(20)*GameField.DOT_SIZE;
    }
}
