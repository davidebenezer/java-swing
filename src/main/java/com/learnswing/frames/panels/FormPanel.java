package com.learnswing.frames.panels;

import com.learnswing.frames.panels.events.FormEvent;
import com.learnswing.listener.FormListener;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JLabel ageLabel;
    private JList ageList;
    private JButton submit;
    @Setter
    private FormListener formListener;


    public FormPanel(){
        //System.out.println("Get Layout: "+getLayout());
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        //initialize form components
        nameLabel = new JLabel("Name :");
        occupationLabel = new JLabel("Occupation :");
        nameField =  new JTextField(10);
        occupationField = new JTextField(10);
        ageLabel = new JLabel("Age Range:");
        ageList = new JList();
        submit = new JButton("Submit");

        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement("Under 18");
        ageModel.addElement("18 to 65");
        ageModel.addElement("Over 65");

        ageList.setModel(ageModel);
        ageList.setPreferredSize(new Dimension(80, 60));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();
                String ageRange = (String) ageList.getSelectedValue();
                FormEvent event = new FormEvent(e, name, occupation);
                if(formListener!=null){
                    formListener.formEventOccurred(event);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // First Row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(nameField, gc);

        // Second Row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(occupationLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(occupationField, gc);

        // Third Row
        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(ageLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(ageList, gc);

        // Fourth Row
        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submit, gc);
    }
}
