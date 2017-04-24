package com.bot;


import javax.swing.*;
import java.awt.*;

public class Line extends JPanel {
    private double k;
    private int b;

    public Line(double k, int b){
        this.k = k;
        this.b = b;
    }

    public double getK(){
        return this.k;
    }

    public int getB() {
        return this.b;
    }

    public void paint(Graphics g){
        g.setColor(Color.RED);
        if(k != 0) {
            if (k > 0) {
                g.drawLine(0, b, (int) ((700 - b) / k), 700);
            } else {
                if (700-b>b) {
                    g.drawLine(0, 700-b, 700, b);
                }
                else{
                    g.drawLine(0, b, (int) (-b/k), 700-b);
                }
            }
        }
        else
            g.drawLine(0,b,700,b);
        g.setColor(Color.red);
    }

}
