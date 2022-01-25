package org.noimos.csv2mysql.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import org.noimos.csv2mysql.ctrl.MySQLDatabase;
import org.noimos.csv2mysql.util.AlertUtils;
import org.noimos.csv2mysql.util.WindowUtils;

public class ItemImporter extends javax.swing.JDialog {

    File file = null;
    int count = 0;
    String separator = ",";

    public ItemImporter(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        WindowUtils.setFrameInTheMiddleOfTheScreen(this);
        rowsLabel.setText("");
        initialize();
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
        jLabel3 = new javax.swing.JLabel();
        colName = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        colBarcode = new javax.swing.JSpinner();
        colCategory = new javax.swing.JSpinner();
        colPriceBuying = new javax.swing.JSpinner();
        colPriceSelling = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        colDiscount = new javax.swing.JSpinner();
        skipper = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Import Items");

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

        jLabel3.setText("Name Column");

        colName.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));

        jLabel5.setText("Barcode Column");

        jLabel6.setText("Category ID Column");

        jLabel7.setText("Buying Price Column");

        jLabel8.setText("Selling Price Column");

        colBarcode.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));

        colCategory.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));

        colPriceBuying.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));

        colPriceSelling.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));

        jLabel9.setText("Discount Column");

        colDiscount.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));

        skipper.setText("Skip First Row (Header)");

        jLabel2.setText("Starting ID");

        id.setText("1");

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
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(skipper))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(colName, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colPriceBuying, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colPriceSelling, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                    .addComponent(skipper)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(colName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(colBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(colCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(colPriceBuying, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(colPriceSelling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(colDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    int starting = Integer.parseInt(id.getText().trim());
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
                            String query = getItemQuery(index + starting, line);
                            try {
                                if (query != null) {
                                    int id = getId(line);
                                    if (id == 0) {
                                        id = index + starting;
                                        MySQLDatabase.setData(connection, statement, query);
                                    }
                                    MySQLDatabase.setData(connection, statement, getProductQuery(id, line));
                                    MySQLDatabase.setData(connection, statement, getPromoQuery(id, line));
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
    private javax.swing.JSpinner colBarcode;
    private javax.swing.JSpinner colCategory;
    private javax.swing.JSpinner colDiscount;
    private javax.swing.JSpinner colName;
    private javax.swing.JSpinner colPriceBuying;
    private javax.swing.JSpinner colPriceSelling;
    private javax.swing.JTextField fileText;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progress;
    private javax.swing.JLabel rowsLabel;
    private javax.swing.JCheckBox skipper;
    // End of variables declaration//GEN-END:variables

    private String getItemQuery(int index, String line) {
        StringBuilder query = new StringBuilder("INSERT INTO item(id,code,name,barcode,tags,more_info,item_category_id) VALUES (");
        String[] vals = line.split(separator);
        if (vals[1].trim().isEmpty()) {
            return null;
        } else {
            query.append("'");
            query.append(index);
            query.append("',");
            query.append("'");
            query.append(index);
            query.append("',");
            query.append("'");
            query.append(vals[((Integer) colName.getValue()) - 1].replace("'", ""));
            query.append("',");
            if (vals[((Integer) colBarcode.getValue()) - 1].trim().isEmpty() || vals[((Integer) colBarcode.getValue()) - 1].toUpperCase().equals("NULL")) {
                query.append("null");
                query.append(",");
            } else {
                query.append("'");
                query.append(vals[((Integer) colBarcode.getValue()) - 1]);
                query.append("',");
            }
            query.append("'");
            query.append("[]");
            query.append("',");
            query.append("'");
            query.append("{}");
            query.append("',");
            query.append("'");
            query.append(vals[((Integer) colCategory.getValue()) - 1]);
            query.append("'");
            query.append(")");
            return query.toString();
        }
    }

    private String getProductQuery(int index, String line) {
        StringBuilder query = new StringBuilder("INSERT INTO transaction_product(type,qty,in_stock,price_buying,price_selling,price_retail,"
                + "price_buying_absolute,price_buying_raw,price_other,more_info,item_id,transaction_id) VALUES (");
        String[] vals = line.split(separator);
        query.append("'");
        query.append("IN");
        query.append("',");
        query.append("'");
        query.append(0);
        query.append("',");
        query.append("'");
        query.append(0);
        query.append("',");
        query.append("'");
        query.append(vals[((Integer) colPriceBuying.getValue()) - 1]);
        query.append("',");
        query.append("'");
        query.append(vals[((Integer) colPriceSelling.getValue()) - 1]);
        query.append("',");
        query.append("'");
        query.append(vals[((Integer) colPriceSelling.getValue()) - 1]);
        query.append("',");
        query.append("'");
        query.append(vals[((Integer) colPriceBuying.getValue()) - 1]);
        query.append("',");
        query.append("'");
        query.append(vals[((Integer) colPriceBuying.getValue()) - 1]);
        query.append("',");
        query.append("'");
        query.append(vals[((Integer) colPriceSelling.getValue()) - 1]);
        query.append("',");
        query.append("'");
        query.append("{}");
        query.append("',");
        query.append("'");
        query.append(index);
        query.append("',");
        query.append("'");
        query.append("1");
        query.append("'");
        query.append(")");
        return query.toString();
    }

    private String getPromoQuery(int index, String line) {
        StringBuilder query = new StringBuilder("INSERT INTO promotion_item(discount,item_price,item_id,promotion_id) VALUES (");
        String[] vals = line.split(separator);
        query.append("'");
        query.append(vals[((Integer) colDiscount.getValue()) - 1]);
        query.append("',");
        query.append("'");
        query.append(vals[((Integer) colPriceSelling.getValue()) - 1]);
        query.append("',");
        query.append("'");
        query.append(index);
        query.append("',");
        query.append("'");
        query.append("1");
        query.append("'");
        query.append(")");
        return query.toString();
    }

    private int getId(String line) {
        String[] vals = line.split(separator);
        String name = vals[((Integer) colName.getValue()) - 1].replace("'", "");
        String query = "SELECT * FROM item WHERE name='" + name + "'";
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

    private void initialize() {
        Connection connection = null;
        try {
            connection = MySQLDatabase.connection();
            String query = "select * from stock_taking";
            ResultSet rs = MySQLDatabase.getData(connection, connection.createStatement(), query);
            if (!rs.next()) {
                query = "insert into stock_taking(user) values(1)";
                MySQLDatabase.setData(connection, connection.createStatement(), query);
                connection.commit();
            }
            query = "select * from transaction";
            boolean transPresent = false;
            rs = MySQLDatabase.getData(connection, connection.createStatement(), query);
            if (rs.next()) {
                transPresent = true;
            }
            if (!transPresent) {
                query = "select * from transaction_type where code='ST'";
                rs = MySQLDatabase.getData(connection, connection.createStatement(), query);
                if (rs.next()) {
                    int type = rs.getInt("id");
                    query = "insert into transaction(more_info,transaction_type_id,user_id,workstation_id,stock_taking_id) "
                            + "values('{}'," + type + ",1,1,1)";
                    MySQLDatabase.setData(connection, connection.createStatement(), query);
                    connection.commit();
                }
            }
            query = "select * from promotion";
            rs = MySQLDatabase.getData(connection, connection.createStatement(), query);
            if (!rs.next()) {
                query = "insert into promotion_type(name) values('DISCOUNT')";
                MySQLDatabase.setData(connection, connection.createStatement(), query);
                query = "insert into promotion(type,promotion_type_id) values('PRICE',1)";
                MySQLDatabase.setData(connection, connection.createStatement(), query);
                connection.commit();
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (Exception ex) {
            }
        }
    }
}
