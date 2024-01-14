package Modelgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;



public class Apple extends JFrame {
    public Image apple;
    public Image snake;
    public int appleX;
    public int appleY;
    public final int DOT_SIZE = 16;
    public int snakeSize = 3;
    private final int ALL_DOTS = 400;
    public final int[] x = new int[ALL_DOTS];
    public final int[] y = new int[ALL_DOTS];

//    public Elements(){
//        setBackground(Color.black);
//        loadImages();
//        initGame();
//        addKeyListener(new Action.FieldKeyListener());
//        setFocusable(true);
//    }
    public void initGame(){
        for (int i = 0; i < snakeSize; i++) {
            x[i] = 48 - i * DOT_SIZE;
            y[i] = 48;
        }
        Timer timer = new Timer(250, (ActionListener) this);
        timer.start();
        createApple();
    }

    public void loadImages(){
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("snake.png");
        snake = iid.getImage();
    }

    public void createApple(){
        appleX = new Random().nextInt(20)*DOT_SIZE;
        appleY = new Random().nextInt(20)*DOT_SIZE;
    }
}
