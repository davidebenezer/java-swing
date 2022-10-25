package com.learnswing.frames.panels;

import com.learnswing.frames.panels.events.FormEvent;
import com.learnswing.listener.FormListener;
import com.learnswing.properties.AgeCategoryEnum;
import com.learnswing.properties.EmploymentCategoryEnum;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private final JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JLabel ageLabel;
    private JList ageList;
    private JComboBox empCombo;
    private JCheckBox citizenCheck;
    private JLabel taxLabel;
    private JTextField taxDetails;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup gender;
    private final JButton submit;
    @Setter
    private FormListener formListener;


    public FormPanel(){
        //System.out.println("Get Layout: "+getLayout());
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize(dim);

        //initialize form components
        nameLabel = new JLabel("Name :");
        nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        occupationLabel = new JLabel("Occupation :");
        nameField =  new JTextField(10);
        nameLabel.setLabelFor(nameField);
        occupationField = new JTextField(10);
        ageLabel = new JLabel("Age Range:");
        ageList = new JList();
        empCombo = new JComboBox();
        citizenCheck = new JCheckBox();
        taxDetails = new JTextField(10);
        taxLabel = new JLabel("Tax Details :");

        taxLabel.setEnabled(false);
        taxDetails.setEnabled(false);

        citizenCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isCitizen = citizenCheck.isSelected();
                taxLabel.setEnabled(isCitizen);
                taxDetails.setEnabled(isCitizen);
            }
        });

        //taxDetails.setPreferredSize(new Dimension(100,80));

        maleRadio = new JRadioButton("Male");
        maleRadio.setActionCommand("Male");
        maleRadio.setSelected(true);
        femaleRadio = new JRadioButton("Female");
        femaleRadio.setActionCommand("Female");
        gender = new ButtonGroup();
        gender.add(maleRadio);
        gender.add(femaleRadio);

        submit = new JButton("Submit");
        submit.setMnemonic(KeyEvent.VK_O);

        // set up list box

        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(AgeCategoryEnum.BELOW18);
        ageModel.addElement(AgeCategoryEnum.BETWEEN18AND65);
        ageModel.addElement(AgeCategoryEnum.ABOVE65);

        ageList.setModel(ageModel);
        ageList.setPreferredSize(new Dimension(80, 60));
        ageList.setBorder(BorderFactory.createEtchedBorder());

        ageList.setSelectedIndex(1);

        //set up combo box
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement(EmploymentCategoryEnum.EMPLOYED);
        empModel.addElement(EmploymentCategoryEnum.SELF_EMPLOYED);
        empModel.addElement(EmploymentCategoryEnum.UNEMPLOYED);

        empCombo.setModel(empModel);
        //empCombo.setEditable(true);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategoryEnum ageRange = (AgeCategoryEnum) ageList.getSelectedValue();
                EmploymentCategoryEnum empCategory = (EmploymentCategoryEnum) empCombo.getSelectedItem();
                String tax= taxDetails.getText();
                String genderDetail = gender.getSelection().getActionCommand();
                FormEvent event = new FormEvent(e,
                        name,
                        occupation,
                        ageRange.getId(),
                        empCategory.getId(),
                        citizenCheck.isSelected(),
                        tax,
                        genderDetail);

                if(formListener!=null){
                    formListener.formEventOccurred(event);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        layoutComponents();
    }

    public void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;

        // First Row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(nameLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(nameField, gc);

        // Next Row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(occupationLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(occupationField, gc);

        // Next Row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(ageLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(ageList, gc);

        // Next Row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Emp Category :"), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(empCombo, gc);

        // Next Row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("US Citizen :"), gc);

        gc.gridx ++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(citizenCheck, gc);

        // Next Row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(taxLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(taxDetails, gc);

        // Next Row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Gender"), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(maleRadio, gc);

        // Next Row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(femaleRadio, gc);

        // last row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submit, gc);
    }
}
