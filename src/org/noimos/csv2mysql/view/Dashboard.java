package org.noimos.csv2mysql.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import org.noimos.csv2mysql.ctrl.MySQLDatabase;
import org.noimos.csv2mysql.util.AlertUtils;
import org.noimos.csv2mysql.util.WindowUtils;

/**
 *
 * @author Mahen Samaranayake
 */
public class Dashboard extends javax.swing.JFrame {

    File file = null;
    int count = 0;
    String columns = "";

    public Dashboard() {
        initComponents();
        WindowUtils.setFrameInTheMiddleOfTheScreen(this);
        loadTables();
        rowsLabel.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fileText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tableCombo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        progress = new javax.swing.JProgressBar();
        rowsLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CSV to MySQL Application");
        setResizable(false);

        jLabel1.setText("File");

        jLabel2.setText("Table");

        fileText.setEditable(false);

        jButton1.setText("Open File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableComboActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(fileText)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(rowsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Advanced Options");

        jButton3.setText("Import Item Categories");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Import Items");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Import Shares");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Import Members");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                while ((line = br.readLine()) != null) {
                    count++;
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
                    String table = (String) tableCombo.getSelectedItem();
                    tableCombo.setEnabled(false);
                    jButton1.setEnabled(false);
                    jButton2.setEnabled(false);
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                    String line;
                    int index = 0;
                    while ((line = br.readLine()) != null) {
                        index++;
                        rowsLabel.setText("Rows: " + index + "/" + count);
                        progress.setValue((int) (index * 100 / count));
                        Statement statement = connection.createStatement();
                        MySQLDatabase.setData(connection, statement, getQuery(table, line));
                        connection.commit();
                    }
                    progress.setValue(100);
                    br.close();
                    AlertUtils.showAlert("Completed!");
                    progress.setValue(0);
                    rowsLabel.setText("");
                    tableCombo.setEnabled(true);
                    jButton1.setEnabled(true);
                    jButton2.setEnabled(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    AlertUtils.showError(e.getMessage());
                    tableCombo.setEnabled(true);
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

    private void tableComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableComboActionPerformed
        Connection connection = null;
        try {
            String query = "SHOW COLUMNS FROM " + tableCombo.getSelectedItem();
            connection = MySQLDatabase.connection();
            ResultSet rs = MySQLDatabase.getData(connection, connection.createStatement(), query);
            boolean isFirst = true;
            StringBuilder sb = new StringBuilder("(");
            boolean skippedFirst = false;
            while (rs.next()) {
                if (skippedFirst) {
                    if (!isFirst) {
                        sb.append(",");
                    }
                    String col = rs.getString(1);
                    sb.append(col);
                    isFirst = false;
                } else {
                    skippedFirst = true;
                }
            }
            sb.append(")");
            columns = sb.toString();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_tableComboActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new ItemCategoryImporter(this, true).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new ItemImporter(this, true).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new SharesImporter(this, true).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       new NoimosPeopleImporter().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fileText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar progress;
    private javax.swing.JLabel rowsLabel;
    private javax.swing.JComboBox<String> tableCombo;
    // End of variables declaration//GEN-END:variables

    private void loadTables() {
        Connection connection = null;
        try {
            connection = MySQLDatabase.connection();
            Statement statement = connection.createStatement();
            ResultSet rs = MySQLDatabase.getData(connection, statement, "show tables");
            DefaultComboBoxModel dcm = (DefaultComboBoxModel) tableCombo.getModel();
            while (rs.next()) {
                dcm.addElement(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            AlertUtils.showError(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    private String getQuery(String table, String line) {
        StringBuilder query = new StringBuilder("INSERT INTO " + table + columns + " VALUES (");
        String[] values = line.split("\t");
        boolean isFirst = true;
        boolean skippedFirst = false;
        for (String value : values) {
            if (skippedFirst) {
                if (!isFirst) {
                    query.append(",");
                }
                query.append("'");
                query.append(value.trim().replace("'", "\'"));
                query.append("'");
                isFirst = false;
            } else {
                skippedFirst = true;
            }
        }
        query.append(")");
        System.out.println(query);
        return query.toString();
    }
}
