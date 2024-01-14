package Modelgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FieldKeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT && GameField.snake.direction != Direction.RIGHT){
            GameField.snake.direction = Direction.LEFT;
        }

        if(key == KeyEvent.VK_RIGHT && GameField.snake.direction != Direction.LEFT){
            GameField.snake.direction = Direction.RIGHT;
        }

        if(key == KeyEvent.VK_UP && GameField.snake.direction != Direction.DOWN){
            GameField.snake.direction = Direction.UP;
        }

        if(key == KeyEvent.VK_DOWN && GameField.snake.direction != Direction.UP){
            GameField.snake.direction = Direction.DOWN;
        }
    }
}
