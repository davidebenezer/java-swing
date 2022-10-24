package com.learnswing.frames;

import com.learnswing.frames.panels.FormPanel;
import com.learnswing.frames.panels.TextPanel;
import com.learnswing.frames.panels.ToolBar;
import com.learnswing.frames.panels.events.FormEvent;
import com.learnswing.listener.FormListener;
import com.learnswing.listener.StringListener;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

@Setter
public class MainFrame extends JFrame {

    private FormPanel formPanel;
    private TextPanel textPanel;
    //private JButton jButton;
    private ToolBar toolBar;

    public MainFrame() throws HeadlessException {

        super("Hello World");
        setLayout(new BorderLayout());
        formPanel = new FormPanel();
        textPanel = new TextPanel();
        //jButton = new JButton("Click Me");
        toolBar = new ToolBar();
        toolBar.setTextListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text+"\n");
            }
        });

        formPanel.setFormListener(e -> {
            String name = e.getName();
            String occupation = e.getOccupation();
            int ageCategory = e.getAgeCategory();
            textPanel.appendText("Name : "+name+"\nOccupation : "+occupation+"\nAge Category :"+ageCategory+"\n");
        });

//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                textPanel.appendText("Clicked me\n");
//            }
//        });

        add(formPanel, BorderLayout.WEST);
        add(textPanel, BorderLayout.CENTER);
        //add(jButton, BorderLayout.SOUTH);
        add(toolBar, BorderLayout.NORTH);

        //set default frame size
        setSize(600,500);

        //Quit Application on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
