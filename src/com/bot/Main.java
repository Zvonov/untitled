package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class    Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    private static ArrayList<Line> lines;
    private static Point p1;
    private static Point p2;
    static JLabel Answer = new JLabel("");
    static JLabel Answer1= new JLabel("");
    static JLabel Answer2 = new JLabel("");
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

        Answer.setBounds(2,430,200,70);
        butPanel.add(Answer);
        Answer1.setBounds(2,450,200,70);
        butPanel.add(Answer1);
        Answer2.setBounds(2,470,200,70);
        butPanel.add(Answer2);




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
                            Line temp = new Line(Math.round((Math.random()*30-15)*10)/10, (int)(Math.random()*frame.getHeight()*1.5));
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
                try(Scanner in = new Scanner(new File("input.txt"))){
                    int n = in.nextInt();
                    for(int i = 0 ; i < n ; i++) {
                        Point p = new Point(in.nextInt(),in.nextInt());
                        points.add(p);
                        pane.add(p);
                        p.setBounds(p.x,p.y,p.x + 3,p.y+3);
                    }
                    n = in.nextInt();
                    for(int i = 0 ;i < n ; i++){
                        Line temp = new Line(in.nextDouble(),in.nextInt());
                        temp.setBounds(2,2,frame.getWidth(), frame.getHeight());
                        lines.add(temp);
                        pane.add(temp);
                    }
                    pane.repaint();
                    pane.revalidate();
                }catch(Exception e2){
                    System.out.print(e2.getStackTrace());
                }
            }
        });
        JButton button7 = new JButton("Решить");
        button7.setBounds(2,370,160,30);
        butPanel.add(button7);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1 = null;
                p2 = null;
                int max = 0;

                for (Point point1 : points) {
                    for (Point point2 : points) {
                        if (point1 != point2) {
                            double k = Math.round((double) (point1.y - point2.y) / (point1.x - point2.x) * 10) / 10;
                            int curr = 0;
                            for (Line line : lines) {
                                if (k == line.getK()) curr++;
                            }
                            if (curr > max) {
                                max = curr;
                                p1 = point1;
                                p2 = point2;
                            }
                        }
                    }
                }
                try {
                    System.out.println("(" + p1.x + " ; " + p1.y + ")");
                    System.out.println("(" + p2.x + " ; " + p2.y + ")");
                    Answer.setText("Ответ:");
                    Answer1.setText("Точка 1: ("+ p1.x+";"+p1.y+")");
                    Answer2.setText("Точка 2: ("+ p2.x+";"+p2.y+")");
                    Point a = new Point(p1.x, p1.y);
                    Point b = new Point(p2.x, p2.y);
                    for (int i=0;i<points.size();i++){
                        while(points.size() > 0) {
                            int index = points.size() - 1;
                           Point point = points.remove(index);
                    pane.remove(point);
                            pane.repaint();
                        }
                        pane.revalidate();
                    }
                    points.add(a);
                    points.add(b);
                    pane.add(a);
                    pane.add(b);
	
		


                    a.setBounds(a.x, a.y,a.x + 10, a.y + 10);
                    points.add(a);
                    pane.repaint();
                    pane.revalidate();

                    b.setBounds(b.x, b.y,b.x + 10, b.y + 10);
                    points.add(b);
                    pane.repaint();
                    pane.revalidate();

                }catch(NullPointerException e1){
                    System.out.print("No such points");
                    Answer.setText("Ответ: No such points");
                }


            }
        });


        JButton button6 = new JButton("Записать в файл");
        button6.setBounds(2,335,160,30);
        butPanel.add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try(PrintWriter out = new PrintWriter(new File("out.txt"))){
                   if(p1 == null || p2 == null) out.println("No such points");
                   else {
                       out.println("(" + p1.x + " ; " + p1.y + ")");
                       out.println("(" + p2.x + " ; " + p2.y + ")");
                   }
               }catch(Exception e1) {
                    System.out.print(e1.getStackTrace());
               }

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
                for (int i=0;i<lines.size();i++){
                    while(lines.size() > 0) {
                        int index = lines.size() - 1;
                        Line line = lines.remove(index);
                        pane.remove(line);
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
