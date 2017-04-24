package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class    Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    private static ArrayList<Line> lines;
    public static void createGUI() {
        lines = new ArrayList<Line>();
        final JFrame frame = new JFrame("Testframe");
	    frame.setPreferredSize(new Dimension(700,700));
	    JPanel panel = new JPanel(new BorderLayout());
        Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(250,700));
        final Panel pane   = new Panel();
        pane.setLayout(null);
        //pointpane.setPreferredSize(new Dimension(350,700));

	    JLabel addPointwithCoords = new JLabel("Добавить точку по координатам");
	    addPointwithCoords.setBounds(2,2,300,25);
	    butPanel.add(addPointwithCoords);
	    JLabel addRandomPoints = new JLabel("Добавить рандомное количество точек");
	    addRandomPoints.setBounds(2,50,300,25);
	    butPanel.add(addRandomPoints);
        JLabel X = new JLabel("X:");
        X.setBounds(2,25,15,25);
        butPanel.add(X);
        JLabel Y = new JLabel("Y:");
        Y.setBounds(45,25,15,25);
        butPanel.add(Y);
        JLabel N = new JLabel("NUM:");
        N.setBounds(2,75,30,25);
        butPanel.add(N);
        final JTextField x = new JTextField();
        x.setBounds(17,25, 25,25);
        butPanel.add(x);
        final JTextField y = new JTextField();
        y.setBounds(60,25, 25,25);
        butPanel.add(y);
        final JTextField n = new JTextField();
        n.setBounds(35,70,25,25);
        butPanel.add(n);



        JButton button1 = new JButton("Добавить точку");
        button1.setBounds(2,100,160,30);
        butPanel.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int X = (!x.getText().equals("")?Integer.parseInt(x.getText()):0);
                int Y= (!y.getText().equals("")?Integer.parseInt(y.getText()):0);
                int N = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                if ((X>0)&&(Y>0)) {
                    Point b = new Point(X, Y);
                    points.add(b);
                    pane.add(b);
                    b.setBounds(b.x,b.y,b.x + 3,b.y+3);
                    pane.revalidate();
                    pane.repaint();
                }
                else {
                    if (N>0){
                        for (int i=0;i<N;i++){
                            Point b = new Point((int)(Math.random()*(frame.getWidth()-250)), (int)(Math.random()*frame.getHeight()));
                            points.add(b);
                            pane.add(b);
                            b.setBounds(b.x,b.y,b.x + 3,b.y+3);
                            pane.revalidate();
                            pane.repaint();
                        }
                    }
                }

            }
        });


        JButton button4 = new JButton("Добавить прямую");
        button4.setBounds(2,265,160,30);
        butPanel.add(button4);

        JLabel addLinewithCoords = new JLabel("Добавить по коэфициентам");
        addLinewithCoords.setBounds(2,150,300,25);
        butPanel.add(addLinewithCoords);
        JLabel addRandomLine = new JLabel("Добавить рандомное количество прямых");
        addRandomLine.setBounds(2,200,300,25);
        butPanel.add(addRandomLine);
        JLabel K = new JLabel("K:");
        K.setBounds(2,175,25,25);
        butPanel.add(K);
        JLabel B = new JLabel("B:");
        B.setBounds(45,175,25,25);
        butPanel.add(B);
        JLabel Num = new JLabel("NUM:");
        Num.setBounds(2,225,30,25);
        butPanel.add(Num);
        final JTextField k = new JTextField();
        k.setBounds(17,175, 25,25);
        butPanel.add(k);
        final JTextField b = new JTextField();
        b.setBounds(60,175, 25,25);
        butPanel.add(b);
        final JTextField num = new JTextField();
        num.setBounds(35,225,30,25);
        butPanel.add(num);

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double K = (!k.getText().equals("")?Double.parseDouble(k.getText()):0);
                int B = (!b.getText().equals("")?Integer.parseInt(b.getText()):0);
                int N = (!num.getText().equals("")?Integer.parseInt(num.getText()):0);
                if (K != 0 || B != 0) {
                    System.out.print(K + " " + B);
                    Line temp = new Line(K, B);
                    lines.add(temp);
                    pane.add(temp);
                    temp.setBounds(2,2,frame.getWidth(), frame.getHeight());
                    pane.revalidate();
                    pane.repaint();
                }
                else {
                    if (N>0){
                        for (int i=0;i<N;i++){
                            Line temp = new Line((Math.random()*20-10), (int)(Math.random()*frame.getHeight()/2));
                            lines.add(temp);
                            pane.add(temp);
                            temp.setBounds(2,2,frame.getWidth(), frame.getHeight());
                            pane.revalidate();
                            pane.repaint();
                        }
                    }
                }
            }
        });

        JButton button5 = new JButton("Прочитаит файл");
        button5.setBounds(2,300,160,30);
        butPanel.add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton button6 = new JButton("Записать в файл");
        button6.setBounds(2,335,160,30);
        butPanel.add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton button7 = new JButton("Решить");
        button7.setBounds(2,370,160,30);
        butPanel.add(button7);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton button3 = new JButton("очистить");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<points.size();i++){
                    while(points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pane.remove(point);
                        pane.repaint();
                        pane.revalidate();
                    }
                }
            }
        });
        button3.setBounds(2,420,160,30);
        butPanel.add(button3);
        panel.add(pane,BorderLayout.CENTER);
        panel.add(butPanel,BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }




    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}
