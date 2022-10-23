package com.learnswing;

import com.learnswing.frames.MainFrame;

import javax.swing.*;

public class Application {
    public static void main(String args[]){
        //multi threading
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
