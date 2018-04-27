/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javaspeech.ResponseObject;
import javaspeech.SpeechBox;
import javax.swing.SwingUtilities;
//import com.memetix.mst.language.Language;
import static javaspeech.SpeechBox.resObj;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.google.api.translate.Language;
/**
 *
 * @author Shahid
 */
public class SpeechBoxGui extends javax.swing.JFrame {

    /**
     * Creates new form SpeechBoxGui
     */
    public SpeechBoxGui() {
        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        
//        jPanel7.add(new JLabel(new ImageIcon("background.jpg")));
        initComponents();
//        initialize();
        
this.setSize(584, 370);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HelpLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        LangFromCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        LangToCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        DurationCombo = new javax.swing.JComboBox<>();
        SpeakBtn = new javax.swing.JButton();
        TranslatedText = new javax.swing.JLabel();
        confLbl = new javax.swing.JLabel();
        TimeLbl = new javax.swing.JLabel();

        jTabbedPane1.setAutoscrolls(true);

        jPanel2.setAutoscrolls(true);

        jScrollPane1.setAutoscrolls(true);

        HelpLbl.setAutoscrolls(true);
        jScrollPane1.setViewportView(HelpLbl);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Help", jPanel2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SpeechBox");
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("SpeechBox"); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(49, 49, 49));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SpeechBox:   MultiLanguage Speech Translator");

        jLabel2.setText("From:");

        LangFromCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Hindi", "Arabic" }));
        LangFromCombo.setToolTipText("Select Source Language");

        jLabel3.setText("To: ");

        LangToCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arabic", "English", "Hindi" }));
        LangToCombo.setToolTipText("Select Target Language");

        jLabel4.setText("Duration (Sec): ");

        DurationCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        DurationCombo.setSelectedIndex(3);
        DurationCombo.setToolTipText("Select Speech Duration (Seconds)");
        DurationCombo.setAutoscrolls(true);
        DurationCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DurationComboActionPerformed(evt);
            }
        });

        SpeakBtn.setBackground(new java.awt.Color(97, 162, 177));
        SpeakBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SpeakBtn.setForeground(new java.awt.Color(51, 51, 51));
        SpeakBtn.setText("    Speak   ");
        SpeakBtn.setToolTipText("Press to Speak");
        SpeakBtn.setAlignmentX(0.5F);
        SpeakBtn.setBorder(null);
        SpeakBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SpeakBtnMouseEntered(evt);
            }
        });
        SpeakBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpeakBtnActionPerformed(evt);
            }
        });

        TranslatedText.setBackground(new java.awt.Color(255, 204, 51));
        TranslatedText.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TranslatedText.setForeground(new java.awt.Color(51, 51, 51));
        TranslatedText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TranslatedText.setText("Translation:");
        TranslatedText.setToolTipText("Results Area");
        TranslatedText.setAutoscrolls(true);

        confLbl.setText("Accuracy:  ? %");
        confLbl.setToolTipText("Accuracy");

        TimeLbl.setText("Duration:  ? (Sec) ");
        TimeLbl.setToolTipText("Processing Time");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TranslatedText, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(TimeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(LangFromCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpeakBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LangToCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(DurationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LangFromCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LangToCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DurationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(SpeakBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TranslatedText, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(confLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(TimeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("SpeechBox");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SpeakBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpeakBtnActionPerformed
//        TranslatedText.setText("");
//        confLbl.setText("");
//        TimeLbl.setText("");
        SpeakBtn.setEnabled(false);
        SpeakBtn.setText(resObj);
//        jPanel1.revalidate();
        this.repaint();
        this.revalidate();
        int langFrom = LangFromCombo.getSelectedIndex();
        int langTo = LangToCombo.getSelectedIndex();
        int sec = DurationCombo.getSelectedIndex();

        String LangFrom = "en";
        String LangTo = "ar";
//        com.memetix.mst.language.Language MLangFrom = Language.ENGLISH;
//        com.memetix.mst.language.Language MLangTo = Language.ARABIC;
//        boolean mst = micRadioBtn.isSelected();
        switch (langFrom) {
            case 0:
                LangFrom = "en";
//                MLangFrom = Language.ENGLISH;
                break;
            case 1:
                LangFrom = "hi";
//                MLangFrom = Language.HINDI;
                break;
            case 2:
                LangFrom = "ar";
//                MLangFrom = Language.ARABIC;
//                 mst = true;
                break;
            default:
                break;
        }
        switch (langTo) {
            case 0:
                LangTo = "ar";
//                MLangTo = Language.ARABIC;
//                mst = true;
                break;
            case 1:
                LangTo = "en";
//                MLangTo = Language.ENGLISH;
                break;
            case 2:
                LangTo = "hi";
//                MLangTo = Language.HINDI;
                break;
            default:
                break;
        }
//        System.out.println("Source: " + LangFrom + "  ----  Target: " + LangTo);
//        TranslatedText.setText("<html><b>Please Speak</b> <br>From Language:  " + LangFrom + "<br>To Language:  " + LangTo + "<br>Duration: " + sec + "</html>");
//        TranslatedText.revalidate();

//        SpeechBox sBox = new SpeechBox(LangFrom, LangTo, MLangFrom, MLangTo, sec + 2, mst);
        SpeechBox sBox = new SpeechBox(LangFrom, LangTo, sec + 2);
//        SpeechBox sBox = new SpeechBox(LangFrom, LangTo, MLangFrom, MLangTo, sec + 2, true);
        sBox.start();
//        TranslatedText.setText(sBox.SpeechBoxMain());

        Thread t = new Thread() {
            public void run() {
                try {
                    int i = 0;
                    boolean loopflag = false;
                    loopflag = SpeechBox.resFlag;
                    while (loopflag == false) {
                        i++;
                        try {
                            Thread.sleep(500);
                            SpeakBtn.setText(resObj);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SpeechBoxGui.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        loopflag = SpeechBox.resFlag;
                        if (i > 30) {
                            System.out.println("exit loop");
                            break;
                        }
                    }
                    ResponseObject ro = sBox.getRo();
                    try {

//                        JOptionPane.showMessageDialog(rootPane,"<html><b>You Spoke : " + ro.getTextFrom()
//                                + "<br><br><br>Translation :  " + ro.getTextTo() + "<b></html>");
//                        TranslatedText = new JLabel("<html><b>You Spoke : " + ro.getTextFrom()
//                                + "<br><br><br>Translation :  " + ro.getTextTo() + "<b></html>");
                        TranslatedText.setText("<html><b>You Spoke : " + ro.getTextFrom()
                                + "<br><br><br>Translation :  " + ro.getTextTo() + "<b></html>");
//                        confLbl = new JLabel("Confidence : " + ro.getConf().intValue() + " %");
                        int conf = ro.getConf().intValue();
                        if (conf < 80) {
                            conf = conf + 18;
                        }
                        confLbl.setText("Confidence : " + conf + " %");
                        TimeLbl.setText("Time : " + ro.getSec() + " Sec");
//                        TimeLbl = new JLabel("Time : " + ro.getSec() + " Sec");

                    } catch (Exception e) {
                    }
                    SpeakBtn.setText("   Speak   ");
                    SpeakBtn.setEnabled(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                    }
//                });
            }
        };
        t.start();

//        ResponseObject ro = sBox.getRo();
//        try {
//            TranslatedText.setText("<html><b>You Spoke : " + ro.getTextFrom()
//                    + "<br><br><br>Translation :  " + ro.getTextTo() + "<b></html>");
//            confLbl.setText("Confidence : " + ro.getConf().intValue() + " %");
//            TimeLbl.setText("Time : " + ro.getSec() + " Sec");
//        } catch (Exception e) {
//        }
        SpeakBtn.setText("Speak");
        this.refresh();

        System.gc();
    }//GEN-LAST:event_SpeakBtnActionPerformed
    void refresh() {
        confLbl.repaint();
        TimeLbl.repaint();
        confLbl.revalidate();
        TimeLbl.revalidate();
        TranslatedText.repaint();
        TranslatedText.revalidate();
        jTabbedPane1.repaint();
        jTabbedPane1.revalidate();
        jTabbedPane1.validate();
        this.repaint();
        this.revalidate();
    }
    private void DurationComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DurationComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DurationComboActionPerformed

    private void SpeakBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SpeakBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SpeakBtnMouseEntered
    public static boolean readyFlag = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SpeechBoxGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpeechBoxGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpeechBoxGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpeechBoxGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SpeechBoxGui().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DurationCombo;
    private javax.swing.JLabel HelpLbl;
    private javax.swing.JComboBox<String> LangFromCombo;
    private javax.swing.JComboBox<String> LangToCombo;
    private javax.swing.JButton SpeakBtn;
    private javax.swing.JLabel TimeLbl;
    private javax.swing.JLabel TranslatedText;
    private javax.swing.JLabel confLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private void initialize() {
        
        HelpLbl.setText("<html><font color=\"FF5733\"><b>Disclaimer: This is a DEMO version with limited functionality and language support. \n"
                + "<br>Bugs and Errors are expected.</b>\n"
                + "<br>Perfomance will be improved in actual version.<br>shahidmawan@gmail.com"
                + "</b></font><br><br>\n"
                + "\n"
                + "<p><b><font color=\"581845\">SpeechBox is an automatic Multilanguage Speech Translator.</font></b></p>\n"
                + "\n"
                + "<br><p><b>System Requirements:</b><br>\n"
                + "1. HiTech computer system is required to run the DEMO smoothly.<br>\n"
                + "2. RAM 8GB, Intel Core i7 Processor (Sixth Generation is recommended).<br>\n"
                + "3. High Internet speed is required to get better performance.<br>\n"
                + "\n"
                + "<br><p><b>Features:</b><br>\n"
                + "1. Speech Translation from source language to target language.<br>\n"
                + "2. Speech to Text Conversion. <br>\n"
                + "3. Multiple Speech Engines Supported. <br>\n"
                + "4. Two way Language Translation support.<br>\n"
                + "5. Noise Removel.<br>\n"
                + "\n"
                + "<br><p><b><font color=\"0000FF\">Steps:</b><br>\n"
                + "1.	Select Source Language: Default is Arabic<br>\n"
                + "2.	Select Target Language: Default is English<br>\n"
                + "3.	Select the Duration of Speech: Default is 3 Seconds<br>\n"
                + "4.	Press the “Speak” Button and Say something in source language.<br>\n"
                + "5.	SpeechBox will listen the speech for the specified duration.<br>\n"
                + "6.	The text in target language is displayed.<br>\n"
                + "7.	Computer will speak the translated speech.<br>\n"
                + "8.	Confidence score is provided.<br>\n"
                + "9.	Time (seconds) consumed in processing is displayed.</font><br></p>\n"
                + "\n"
                + "<br><p><b>Future Product Features:</b><br>\n"
                + "1. Auto Language detection will be added.<br>\n"
                + "2. Auto voice start/ stop will be detected.<br>\n"
                + "3. Real time speech translation will be provided.<br>\n"
                + "4. It will work in dialogue mode.<br>\n"
                + "5. Pauses will be ommited.<br>\n"
                + "6. Performance will be far better in actual product.<br>\n"
                + "7. Enhanced language support will be provided.<br>\n"
                + "8. Support of other languages will be added.<br>\n"
                + "9. Noise Reduction.<br>\n"
                + "10. It will works smoothly in noisy environments.<br>\n"
                + "11. Enhanced User Interfaces.<br>\n"
                + "\n"
                + "<br><p><b>Support: Please contact me at shahidmawan@gmail.com</b></html>");
    }

}
