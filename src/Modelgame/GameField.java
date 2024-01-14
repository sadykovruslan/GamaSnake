package Modelgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameField extends JPanel implements ActionListener{
    private static final int ALL_DOTS = 400;
    public static final int[] x = new int[ALL_DOTS];
    public static final int[] y = new int[ALL_DOTS];
    public static int appleX;
    public static int appleY;
    public static final int DOT_SIZE = 16;
    private final int SIZE = 320;
    public static int snakeSize = 3;
    private boolean inGame = true;
    private Image appleImage;
    private Image snakeImage;
    Apple apple = new Apple();
    public static Snake snake = new Snake();

    public GameField(){
        setBackground(Color.black);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }
    public void loadImages(){
        ImageIcon iia = new ImageIcon("apple.png");
        appleImage = iia.getImage();
        ImageIcon iid = new ImageIcon("snake.png");
        snakeImage = iid.getImage();
    }

    public void initGame(){
        for (int i = 0; i < snakeSize; i++) {
            x[i] = 48 - i * DOT_SIZE;
            y[i] = 48;
        }
        Timer timer = new Timer(250,this);
        timer.start();
        apple.createApple();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(inGame){
            g.drawImage(appleImage,appleX,appleY,this);
            for (int i = 0; i < snakeSize; i++) {
                g.drawImage(snakeImage,x[i],y[i],this);
            }
        } else{
            String str = "Game Over";
            g.setColor(Color.white);
            g.drawString(str,125,SIZE/2);
        }
    }

    public void checkCollisions(){
        for (int i = snakeSize; i >0 ; i--) {
            if(i > 4 && x[0] == x[i] && y[0] == y[i]){
                inGame = false;
                break;
            }
        }
        if((x[0]>SIZE) || (x[0]<0) || (y[0]>SIZE)|| (y[0]<0)){
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            snake.eatApple();
            snake.move();
            checkCollisions();
        }
        repaint();
    }
}