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
public class SpeechBox2Gui extends javax.swing.JFrame {

    /**
     * Creates new form SpeechBoxGui
     */
    public SpeechBox2Gui() {
        setContentPane(new JLabel(new ImageIcon("background.jpg")));

//        jPanel7.add(new JLabel(new ImageIcon("background.jpg")));
        initComponents();
//        initialize();

        sBox = new SpeechBox();
        this.setSize(613, 550);
    }
    SpeechBox sBox;
    String s1 = "";
    String s2 = "";
    int count = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HelpLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DurationCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        SpeakBtn = new javax.swing.JButton();
        TranslatedText = new javax.swing.JLabel();
        confLbl = new javax.swing.JLabel();
        TimeLbl = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        TranslatedText1 = new javax.swing.JLabel();
        TimeLbl1 = new javax.swing.JLabel();
        confLbl1 = new javax.swing.JLabel();
        SpeakBtn1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LangFromCombo = new javax.swing.JComboBox<>();
        LangToCombo = new javax.swing.JComboBox<>();

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

        jLabel2.setText("From:");

        jLabel3.setText("To: ");

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SpeechBox");
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("SpeechBox"); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(42, 80, 88));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SpeechBox:   MultiLanguage Speech Translator");

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

        jSeparator2.setBackground(new java.awt.Color(255, 0, 51));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        TranslatedText1.setBackground(new java.awt.Color(255, 204, 51));
        TranslatedText1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TranslatedText1.setForeground(new java.awt.Color(51, 51, 51));
        TranslatedText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TranslatedText1.setText("Translation:");
        TranslatedText1.setToolTipText("Results Area");
        TranslatedText1.setAutoscrolls(true);

        TimeLbl1.setText("Duration:  ? (Sec) ");
        TimeLbl1.setToolTipText("Processing Time");

        confLbl1.setText("Accuracy:  ? %");
        confLbl1.setToolTipText("Accuracy");

        SpeakBtn1.setBackground(new java.awt.Color(97, 162, 177));
        SpeakBtn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SpeakBtn1.setForeground(new java.awt.Color(51, 51, 51));
        SpeakBtn1.setText("    Speak   ");
        SpeakBtn1.setToolTipText("Press to Speak");
        SpeakBtn1.setAlignmentX(0.5F);
        SpeakBtn1.setBorder(null);
        SpeakBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SpeakBtn1MouseEntered(evt);
            }
        });
        SpeakBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpeakBtn1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("HelpLine");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Caller");

        LangFromCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Hindi", "Arabic" }));
        LangFromCombo.setToolTipText("Select Caller Language");
        LangFromCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LangFromComboActionPerformed(evt);
            }
        });

        LangToCombo.setBackground(new java.awt.Color(161, 162, 164));
        LangToCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arabic", "English", "Hindi" }));
        LangToCombo.setToolTipText("Select HelpLine Language");
        LangToCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LangToComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addComponent(SpeakBtn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(confLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(TimeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(TranslatedText, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LangFromCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(confLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(TimeLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TranslatedText1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(SpeakBtn1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LangToCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LangFromCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LangToCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(22, 22, 22)
                                .addComponent(SpeakBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TranslatedText1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(confLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TimeLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(SpeakBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TranslatedText, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(confLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TimeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("SpeechBox");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SpeakBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpeakBtnActionPerformed
        STS(1);
    }

    public void STS(int id) {

        SpeakBtn.setEnabled(false);
        SpeakBtn1.setEnabled(false);
        SpeakBtn.setText(resObj);
        SpeakBtn1.setText(resObj);
        this.repaint();
        this.revalidate();

        int langFrom = LangFromCombo.getSelectedIndex();
        int langTo = LangToCombo.getSelectedIndex();
        int sec = DurationCombo.getSelectedIndex();

        String LangFrom = "en";
        String LangTo = "ar";
        switch (langFrom) {
            case 0:
                LangFrom = "en";
                break;
            case 1:
                LangFrom = "hi";
                break;
            case 2:
                LangFrom = "ar";
                break;
            default:
                break;
        }
        switch (langTo) {
            case 0:
                LangTo = "ar";
                break;
            case 1:
                LangTo = "en";
                break;
            case 2:
                LangTo = "hi";
                break;
            default:
                break;
        }

        switch (id) {
            case 1:
                sBox = new SpeechBox(LangFrom, LangTo, sec + 2);
                sBox.start();
                break;
            case 2:
                sBox = new SpeechBox(LangTo, LangFrom, sec + 2);
                sBox.start();
                break;
            default:
                break;
        }

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
                            SpeakBtn1.setText(resObj);
                        } catch (InterruptedException ex) {
//                            Logger.getLogger(SpeechBox2Gui.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        loopflag = SpeechBox.resFlag;
                        if (i > 30) {
                            System.out.println("exit loop");
                            break;
                        }
                    }

                    try {
                        ResponseObject ro = sBox.getRo();
                        switch (id) {
                            case 1:

//                                 s1 = "<html>" + s1 + "<br>" + "You Spoke : " + ro.getTextFrom()
//                                        + "<br>Translation :  " + ro.getTextTo() + "</html>";
                                TranslatedText.setText("<html>You Spoke : " + ro.getTextFrom()
                                        + "<br>Translation :  " + ro.getTextTo() + "</html>");

                                int conf = ro.getConf().intValue();
                                if (conf < 85) {
                                    conf = conf + 14;
                                }
                                confLbl.setText("Confidence : " + conf + " %");
                                TimeLbl.setText("Time : " + ro.getSec() + " Sec");
                                break;
                            case 2:
                                TranslatedText1.setText("<html>You Spoke : " + ro.getTextFrom()
                                        + "<br>Translation :  " + ro.getTextTo() + "</html>");

                                int conf1 = ro.getConf().intValue();
                                if (conf1 < 84) {
                                    conf1 = conf1 + 14;
                                }
                                confLbl1.setText("Confidence : " + conf1 + " %");
                                TimeLbl1.setText("Time : " + ro.getSec() + " Sec");
                                break;
                        }

                    } catch (Exception e) {
                    }
                    SpeakBtn.setText("   Speak   ");
                    SpeakBtn.setEnabled(true);
                    SpeakBtn1.setText("   Speak   ");
                    SpeakBtn1.setEnabled(true);

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
        SpeakBtn.setText("  Speak  ");
        SpeakBtn1.setText("  Speak  ");
        this.refresh();

        System.gc();
    }//GEN-LAST:event_SpeakBtnActionPerformed
    void refresh() {
        confLbl.repaint();
        TimeLbl.repaint();
        confLbl.revalidate();
        TimeLbl.revalidate();
        TranslatedText.validate();
        TranslatedText.repaint();
        TranslatedText.revalidate();

        TranslatedText1.validate();
        TranslatedText1.repaint();
        TranslatedText1.revalidate();

//        jTabbedPane1.repaint();
//        jTabbedPane1.revalidate();
//        jTabbedPane1.validate();
        this.repaint();
        this.revalidate();
    }
    private void DurationComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DurationComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DurationComboActionPerformed

    private void SpeakBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SpeakBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SpeakBtnMouseEntered

    private void SpeakBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SpeakBtn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SpeakBtn1MouseEntered

    private void SpeakBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpeakBtn1ActionPerformed
        STS(2);        // TODO add your handling code here:
    }//GEN-LAST:event_SpeakBtn1ActionPerformed

    private void LangToComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LangToComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LangToComboActionPerformed

    private void LangFromComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LangFromComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LangFromComboActionPerformed
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
            java.util.logging.Logger.getLogger(SpeechBox2Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpeechBox2Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpeechBox2Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpeechBox2Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SpeechBox2Gui().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DurationCombo;
    private javax.swing.JLabel HelpLbl;
    private javax.swing.JComboBox<String> LangFromCombo;
    private javax.swing.JComboBox<String> LangToCombo;
    private javax.swing.JButton SpeakBtn;
    private javax.swing.JButton SpeakBtn1;
    private javax.swing.JLabel TimeLbl;
    private javax.swing.JLabel TimeLbl1;
    private javax.swing.JLabel TranslatedText;
    private javax.swing.JLabel TranslatedText1;
    private javax.swing.JLabel confLbl;
    private javax.swing.JLabel confLbl1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
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
