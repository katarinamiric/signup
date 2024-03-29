/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import components.fields.Panel;
import components.fields.PanelInputTextBox;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

/**
 *
 * @author korisnik
 */
public class FrmPerson extends javax.swing.JFrame {

    String form;
    Panel gender;
    Panel date;
    Panel panelFirstName;
    Panel panelLastName;

    private FrmPerson() {
    }

    public String getForm() {
        return form;
    }

    public FrmPerson(Panel panelDate, Panel panelGender) {
        gender = panelGender;
        date = panelDate;
        JButton btnSave;
        this.setPreferredSize(new Dimension(400,500));
        btnSave = new javax.swing.JButton("Save");
        panelFirstName = new components.fields.PanelInputTextBox();
        panelLastName = new components.fields.PanelInputTextBox();

        GridBagLayout gb = new GridBagLayout();
        getContentPane().setLayout(gb);
        GridBagConstraints gbc = new GridBagConstraints();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.gridx = 0;      //FIRSTNAME
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.ipadx = 235;
        getContentPane().add(panelFirstName, gbc);
        
        gbc.gridx = 0;      //LASTNAME
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.ipadx = 235;
        getContentPane().add(panelLastName, gbc);

        gbc.gridx = 0;              //DATE
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.ipadx = 235;
        gbc.weightx = 0.1;
        gbc.anchor = java.awt.GridBagConstraints.NORTH;
        getContentPane().add(panelDate, gbc);

        List<String> list = Arrays.asList("First name:", "", "");
        panelFirstName.initialize(list);
        List<String> list1 = Arrays.asList("Last name:", "", "");
        panelLastName.initialize(list1);

        gbc.gridx = 0;           //GENDER
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.ipadx = 235;
        gbc.anchor = java.awt.GridBagConstraints.NORTH;
        getContentPane().add(panelGender, gbc);
      
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
       

        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.anchor = java.awt.GridBagConstraints.NORTH;
        getContentPane().add(btnSave, gbc);

        pack();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        date.setLabels("Date: ", "");
        gender.setLabels("Gender: ", "");
        panelFirstName.setLabels("First name: ", "");
        panelLastName.setLabels("Last name: ", "");
        String firstName = (String) panelFirstName.getValue();
        String lastName = (String) panelLastName.getValue();
        boolean checkFirstName = true;
        boolean checkLastName = true;
        if (firstName.equals("")) {
            panelFirstName.setLabels("First name: ", "You must input your first name.");
            checkFirstName = false;
        }
        if (lastName.equals("")) {
            panelLastName.setLabels("Last name: ", "You must input your last name.");
            checkLastName = false;
        }
        String dateCheck;
        boolean checkFormat = true;
        boolean checkGenderFormat = true;
        if (date instanceof PanelInputTextBox) {
            dateCheck = (String) date.getValue();
            if (!dateCheck.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
                checkFormat = false;
                date.setLabels("Date: ", "Format not valid! Must be dd/MM/yyyy");
            }
        }
        String genderCheck = (String) gender.getValue();

        if (!(genderCheck.toLowerCase().equals("male") || genderCheck.toLowerCase().equals("female"))) {
            checkGenderFormat = false;
            gender.setLabels("Gender: ", "Format not valid! Must be either \"male\" or \"female\"");
        }

        if (checkFormat && checkGenderFormat && checkFirstName && checkLastName) {
            JOptionPane.showMessageDialog(this, "Name: " + firstName + " Last name: " + lastName + " Date: " + date.getValue() + " Gender:" + gender.getValue().toString().toLowerCase(), "Person is saved.", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
