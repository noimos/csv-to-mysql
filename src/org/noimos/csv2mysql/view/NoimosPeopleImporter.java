package org.noimos.csv2mysql.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFileChooser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.noimos.csv2mysql.ctrl.MySQLDatabase;
import org.noimos.csv2mysql.util.AlertUtils;
import org.noimos.csv2mysql.util.WindowUtils;

/**
 *
 * @author Mahen Samaranayake
 */
public class NoimosPeopleImporter extends javax.swing.JFrame {
    
    File file = null;
    int count = 0;
    String separator = ",";
    
    public NoimosPeopleImporter() {
        initComponents();
        WindowUtils.setFrameInTheMiddleOfTheScreen(this);
        rowsLabel.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fileText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        progress = new javax.swing.JProgressBar();
        rowsLabel = new javax.swing.JLabel();
        skipper = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Members");
        setResizable(false);

        jLabel1.setText("File");

        fileText.setEditable(false);

        jButton1.setText("Open File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Import");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        progress.setStringPainted(true);

        rowsLabel.setText("Rows: ");

        skipper.setText("Skip First Row (Header)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rowsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(skipper))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fileText, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fileText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(skipper)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(rowsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            fileText.setText(file.getName());
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                count = 0;
                boolean checkedSeparator = false;
                while ((line = br.readLine()) != null) {
                    count++;
                    if (!checkedSeparator && line.contains("\t")) {
                        separator = "\t";
                        checkedSeparator = true;
                    }
                }
                rowsLabel.setText("Rows: 0/" + count);
                br.close();
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
                AlertUtils.showError(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader br = null;
                Connection connection = null;
                try {
                    connection = MySQLDatabase.connection();
                    jButton1.setEnabled(false);
                    jButton2.setEnabled(false);
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                    String line;
                    int index = 0;
                    int estIndex = 0;
                    long startTime = System.currentTimeMillis() / 1000;
                    long nowTime = System.currentTimeMillis() / 1000;
                    boolean skipFirstRow = skipper.isSelected();
                    while ((line = br.readLine()) != null) {
                        index++;
                        if (skipFirstRow) {
                            skipFirstRow = false;
                        } else {
                            try {
                                rowsLabel.setText("Rows: " + index + "/" + count + " Estimated time (seconds): " + ((count - index) * (nowTime - startTime) / estIndex));
                            } catch (Exception e) {
                                rowsLabel.setText("Rows: " + index + "/" + count);
                            }
                            progress.setValue((int) (index * 100 / count));
                            Statement statement = connection.createStatement();
                            try {
                                validateLine(line);
//                                MySQLDatabase.setData(connection, statement, getQuery(index, line));
                                connection.commit();
                                estIndex++;
                                nowTime = System.currentTimeMillis() / 1000;
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("error: " + index);
                            }
                        }
                    }
                    progress.setValue(100);
                    br.close();
                    AlertUtils.showAlert("Completed!");
                    progress.setValue(0);
                    rowsLabel.setText("");
                    jButton1.setEnabled(true);
                    jButton2.setEnabled(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    AlertUtils.showError(e.getMessage());
                    jButton1.setEnabled(true);
                    jButton2.setEnabled(true);
                    try {
                        br.close();
                    } catch (Exception ex) {
                    }
                    try {
                        connection.close();
                    } catch (Exception ex) {
                    }
                }
            }
        }).start();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fileText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progress;
    private javax.swing.JLabel rowsLabel;
    private javax.swing.JCheckBox skipper;
    // End of variables declaration//GEN-END:variables

    private void validateLine(String line) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(line.split("\t")[26]);
        } catch (Exception e) {
            AlertUtils.showAlert(line.split("\t")[26]);
            AlertUtils.showError(e.getMessage());
        }
    }
}
