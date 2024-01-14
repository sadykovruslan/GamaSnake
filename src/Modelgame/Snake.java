package Modelgame;

public class Snake {
    Apple apple = new Apple();

    Direction direction = Direction.RIGHT;

    public void move(){
        for (int i = GameField.snakeSize; i > 0; i--) {
            GameField.x[i] = GameField.x[i-1];
            GameField.y[i] = GameField.y[i-1];
        }
        GameField.x[0] +=direction.getX() * GameField.DOT_SIZE;
        GameField.y[0] +=direction.getY() * GameField.DOT_SIZE;
    }

    public void eatApple(){
        if(GameField.x[0] == GameField.appleX && GameField.y[0] == GameField.appleY){
            GameField.snakeSize++;
            apple.createApple();
        }
    }
}
