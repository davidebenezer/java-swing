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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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

        setJMenuBar(createMenubar());
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
            int empCategory = e.getEmpCategory();
            boolean isCitizen = e.isCitizen();
            String taxDetails = e.getTaxDetails();
            String gender = e.getGender();
            textPanel.appendText("Name : "+name+
                    "\nOccupation : "+occupation+
                    "\nAge Category :"+ageCategory+
                    "\nEmp Category :"+empCategory+
                    "\nUS Citizen :"+isCitizen+
                    "\nTax Details :"+taxDetails+
                    "\nGender :"+gender+
                    "\n");
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

    private JMenuBar createMenubar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportMenuItem = new JMenuItem("Export ...");
        JMenuItem importMenuItem = new JMenuItem("Import ...");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitMenuItem.setMnemonic(KeyEvent.VK_X);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        fileMenu.add(exportMenuItem);
        fileMenu.add(importMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenu windowMenu = new JMenu("Window");
        JMenu show = new JMenu("Show");
        JCheckBoxMenuItem personFormMenuItem = new JCheckBoxMenuItem("Person Form");
        personFormMenuItem.setSelected(true);
        show.add(personFormMenuItem);
        personFormMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
                formPanel.setVisible(menuItem.isSelected());
            }
        });
        show.add(formPanel);
        windowMenu.add(show);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        return menuBar;

    }
}
