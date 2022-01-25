package org.noimos.csv2mysql.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import org.noimos.csv2mysql.ctrl.MySQLDatabase;
import org.noimos.csv2mysql.util.AlertUtils;
import org.noimos.csv2mysql.util.WindowUtils;

public class SharesImporter extends javax.swing.JDialog {

    File file = null;
    int count = 0;
    String separator = ",";
    int transactionType = 0;

    public SharesImporter(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        WindowUtils.setFrameInTheMiddleOfTheScreen(this);
        rowsLabel.setText("");
        transactionType = getTranscationType();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        colMember = new javax.swing.JSpinner();
        colDate = new javax.swing.JSpinner();
        colAmount = new javax.swing.JSpinner();
        skipper = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        colF10 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Import Shares");

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

        jLabel2.setText("Membership No. Column");

        jLabel3.setText("Date Column");

        jLabel4.setText("Amount Column");

        colMember.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));

        colDate.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));

        colAmount.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));

        skipper.setText("Skip First Row (Header)");

        jLabel5.setText("F10 Column");

        colF10.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));

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
                                .addComponent(fileText, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(74, 74, 74)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(colAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colDate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colMember, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colF10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(skipper))))
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
                    .addComponent(jLabel2)
                    .addComponent(colMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(colDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(colAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(colF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(rowsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                            String query = getQuery((1 + index), line);
                            try {
                                if (query != null) {
                                    MySQLDatabase.setData(connection, statement, query);
                                }
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
    private javax.swing.JSpinner colAmount;
    private javax.swing.JSpinner colDate;
    private javax.swing.JSpinner colF10;
    private javax.swing.JSpinner colMember;
    private javax.swing.JTextField fileText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progress;
    private javax.swing.JLabel rowsLabel;
    private javax.swing.JCheckBox skipper;
    // End of variables declaration//GEN-END:variables

    DateFormat df = new SimpleDateFormat("M/d/yyyy");
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private String getQuery(int index, String line) {
        StringBuilder query = new StringBuilder("INSERT INTO transaction(number,date,total,state,more_info,transaction_type_id,person_id,"
                + "user_id,workstation_id,stock_taking_id) VALUES (");
        String[] vals = line.split(separator);
        if (vals[0].trim().isEmpty()) {
            return null;
        } else {
            int personId = getPersonId(vals[((Integer) colMember.getValue()) - 1]);
            if (personId > 0) {
                try {
                    Date date = df.parse(vals[((Integer) colDate.getValue()) - 1]);
                    String strDate = dateFormat.format(date);
                    query.append(index);
                    query.append(",'");
                    query.append(strDate);
                    query.append("',");
                    query.append(vals[((Integer) colAmount.getValue()) - 1]);
                    query.append(",'AUTHORIZED','{\"f10\":\"");
//                    query.append(vals[((Integer) colF10.getValue()) - 1]);
                    query.append("");
                    query.append("\"}',");
                    query.append(transactionType);
                    query.append(",");
                    query.append(personId);
                    query.append(",");
                    query.append("1,1,1");
                    query.append(")");
                    return query.toString();
                } catch (Exception e) {
                    System.out.println(e);
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    private int getTranscationType() {
        String query = "SELECT id FROM transaction_type WHERE code='SHARES'";
        Connection connection = null;
        int id = 0;
        try {
            connection = MySQLDatabase.connection();
            ResultSet rs = MySQLDatabase.getData(connection, connection.createStatement(), query);
            if (rs.next()) {
                id = rs.getInt("id");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (Exception ex) {
            }
        }
        return id;
    }

    DecimalFormat nf1 = new DecimalFormat("00");
    DecimalFormat nf2 = new DecimalFormat("00000");

    private int getPersonId(String number) {
        String[] ss = number.split("/");
        int i1 = Integer.parseInt(ss[0]);
        int i2 = Integer.parseInt(ss[1]);
        String num = nf1.format(i1) + "/" + nf2.format(i2);
        String query = "SELECT id FROM person WHERE number='" + num + "'";
        Connection connection = null;
        int id = 0;
        try {
            connection = MySQLDatabase.connection();
            ResultSet rs = MySQLDatabase.getData(connection, connection.createStatement(), query);
            if (rs.next()) {
                id = rs.getInt("id");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (Exception ex) {
            }
        }
        return id;
    }
}
