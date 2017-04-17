package com.bot;

public class Prog extends Panel{
9     Prog(int n){
                    JLabel X = new JLabel("X"+n+":");
                    JLabel Y =new JLabel("Y"+n+":");
                    X.setBounds(0,0, 20,30);
                    Y.setBounds(60,0,20,30);
                    final JTextField x = new JTextField();
                    final JTextField y = new JTextField();
                    x.setBounds(20,0,20,30);
                    y.setBounds(80,0,20,30);
                  setLayout(null);
                   add(X);
                   add(Y);
                   add(x);
                   add(y);
               }





