package com.learnswing.frames.panels;

import com.learnswing.listener.StringListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {
    private JButton helloButton;
    private JButton goodByeButton;
    private StringListener textListener;

    public ToolBar(){
        helloButton = new JButton("Hello");
        goodByeButton = new JButton("Good Bye");
        helloButton.addActionListener(this);
        goodByeButton.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(helloButton);
        add(goodByeButton);
    }

    public void setTextListener(StringListener textListener) {
        this.textListener = textListener;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if(textListener!=null) {
            if (clicked == helloButton) {
                textListener.textEmitted("Hello!");
            } else if (clicked == goodByeButton) {
                textListener.textEmitted("Good Bye!");
            }
        }
    }
}
