/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import components.fields.Panel;
import components.fields.PanelInputComboBox;
import components.fields.PanelInputDateCombobox;
import components.fields.PanelInputDatePicker;
import components.fields.PanelInputRadioButton;
import components.fields.PanelInputTextBox;
import domain.FinalForms;
import domain.Form;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author korisnik
 */
public class FrmConfiguration extends javax.swing.JFrame {

    public FrmConfiguration() {
        initComponents();
        this.setTitle("New Configuration");
        List<String> forms = Arrays.asList("F1", "F2", "F3");
        inputForm.initialize(forms);
        List<String> dates = Arrays.asList("TextField", "ComboBox", "Date Picker");
        inputDate.initialize(dates);
        List<String> genders = Arrays.asList("TextField", "Radio Button", "ComboBox");
        inputGender.initialize(genders);
        inputForm.setLabels("Form:", "");
        inputDate.setLabels("Date:", "");
        inputGender.setLabels("Gender:", "");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputForm = new components.fields.PanelInputComboBox();
        inputDate = new components.fields.PanelInputComboBox();
        inputGender = new components.fields.PanelInputComboBox();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(inputForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inputGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String formType = (String) inputForm.getValue();
        String dateType = (String) inputDate.getValue();
        String genderType = (String) inputGender.getValue();
        Form form = new Form();
        form.setForm(formType);
        form.setDate(dateType);
        form.setGender(genderType);
        Panel pDate = null;
        Panel pGender = null;
        List<String> items = Arrays.asList("Male", "Female");

        if (dateType.equals("TextField")) {
            pDate = new PanelInputTextBox();
        }
        if (dateType.equals("ComboBox")) {
            pDate = new PanelInputDateCombobox();
        }
        if (dateType.equals("Date Picker")) {
            pDate = new PanelInputDatePicker();
        }
        if (genderType.equals("TextField")) {
            pGender = new PanelInputTextBox();
        }
        if (genderType.equals("Radio Button")) {
            pGender = new PanelInputRadioButton();
            pGender.initialize(items);
        }
        if (genderType.equals("ComboBox")) {
            pGender = new PanelInputComboBox();
            pGender.initialize(items);

        }

        pDate.setLabels("Date:", "");

        pGender.setLabels("Gender:", "");

        FrmPerson frmP = new FrmPerson(pDate, pGender);
       
        if (formType.equals("F1")) {
            FinalForms.setF1(frmP);
            frmP.setTitle("Form F1");
        }
        if (formType.equals("F2")) {
            FinalForms.setF2(frmP);
            frmP.setTitle("Form F2");
        }
        if (formType.equals("F3")) {
            FinalForms.setF3(frmP);
            frmP.setTitle("Form F3");
        }

        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private components.fields.PanelInputComboBox inputDate;
    private components.fields.PanelInputComboBox inputForm;
    private components.fields.PanelInputComboBox inputGender;
    // End of variables declaration//GEN-END:variables

}
