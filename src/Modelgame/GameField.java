package Modelgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameField extends JPanel implements ActionListener{
    private final int SIZE = 320;
    private boolean inGame = true;
    Apple elements = new Apple();
    public static Direction direction = Direction.RIGHT;

    public GameField(){
        setBackground(Color.black);
        elements.loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    public void initGame(){
        for (int i = 0; i < elements.snakeSize; i++) {
            elements.x[i] = 48 - i * elements.DOT_SIZE;
            elements.y[i] = 48;
        }
        Timer timer = new Timer(250,this);
        timer.start();
        elements.createApple();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(inGame){
            g.drawImage(elements.apple,elements.appleX,elements.appleY,this);
            for (int i = 0; i < elements.snakeSize; i++) {
                g.drawImage(elements.snake,elements.x[i],elements.y[i],this);
            }
        } else{
            String str = "Game Over";
            g.setColor(Color.white);
            g.drawString(str,125,SIZE/2);
        }
    }

    public void move(){
        for (int i = elements.snakeSize; i > 0; i--) {
            elements.x[i] = elements.x[i-1];
            elements.y[i] = elements.y[i-1];
        }
        elements.x[0] +=direction.getX() * elements.DOT_SIZE;
        elements.y[0] +=direction.getY() * elements.DOT_SIZE;
    }

    public void checkApple(){
        if(elements.x[0] == elements.appleX && elements.y[0] == elements.appleY){
            elements.snakeSize++;
            elements.createApple();
        }
    }

    public void checkCollisions(){
        for (int i = elements.snakeSize; i >0 ; i--) {
            if(i > 4 && elements.x[0] == elements.x[i] && elements.y[0] == elements.y[i]){
                inGame = false;
                break;
            }
        }
        if((elements.x[0]>SIZE) || (elements.x[0]<0) || (elements.y[0]>SIZE)|| (elements.y[0]<0)){
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();
            checkCollisions();
            move();
        }
        repaint();
    }

    public static class FieldKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && direction != direction.RIGHT){
                direction = Direction.LEFT;
            }

            if(key == KeyEvent.VK_RIGHT && direction != direction.LEFT){
                direction = Direction.RIGHT;
            }

            if(key == KeyEvent.VK_UP && direction != direction.DOWN){
                direction = Direction.UP;
            }

            if(key == KeyEvent.VK_DOWN && direction != direction.UP){
                direction = Direction.DOWN;
            }
        }
    }
}