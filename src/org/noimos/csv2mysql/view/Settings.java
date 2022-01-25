package org.noimos.csv2mysql.view;

import java.sql.Connection;
import java.util.Properties;
import org.noimos.csv2mysql.ctrl.MySQLDatabase;
import org.noimos.csv2mysql.ctrl.PropertiesRW;
import org.noimos.csv2mysql.util.AlertUtils;
import org.noimos.csv2mysql.util.WindowUtils;

/**
 *
 * @author Mahen Samaranayake
 */
public class Settings extends javax.swing.JFrame {

    private final static String[] PASSWORDS = new String[]{"ssipladmin123", "ssipladmin@123", "ssipladmin\"123",
        "SSIPLadmin@!(*((@", "SSIPLadmin\"!(*((\"", "123"};
    private int selectedPassword = -1;

    PropertiesRW propertiesRW;

    public Settings() {
        initComponents();
        WindowUtils.setFrameInTheMiddleOfTheScreen(this);
        propertiesRW = new PropertiesRW();
        loadSettings();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hostname = new javax.swing.JTextField();
        port = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        database = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MySQL Connection");
        setResizable(false);

        jLabel1.setText("Hostname");

        jLabel2.setText("Port");

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        jLabel5.setText("Database");

        hostname.setText("localhost");

        port.setText("3306");

        username.setText("root");

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Test");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hostname)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(database, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(port)
                            .addComponent(password))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(hostname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(database, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        selectedPassword = -1;
        if (test(password.getText())) {
            AlertUtils.showAlert("Connection successful");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        selectedPassword = -1;
        if (test(password.getText())) {
            Properties properties = propertiesRW.getProperties();
            properties.setProperty("hostname", hostname.getText());
            properties.setProperty("port", port.getText());
            properties.setProperty("username", username.getText());
            if (selectedPassword == -1) {
                properties.setProperty("password", password.getText());
            }
            properties.setProperty("database", database.getText());
            propertiesRW.storeProperties(properties);
            runTempQuery();
            new Dashboard().setVisible(true);
//            new NoimosItemsImporter().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField database;
    private javax.swing.JTextField hostname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField password;
    private javax.swing.JTextField port;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    private void loadSettings() {
        Properties properties = propertiesRW.getProperties();
        String h = properties.getProperty("hostname");
        String p = properties.getProperty("port");
        String u = properties.getProperty("username");
        String pw = properties.getProperty("password");
        String d = properties.getProperty("database");
        if (h != null) {
            hostname.setText(h);
        }
        if (p != null) {
            port.setText(p);
        }
        if (u != null) {
            username.setText(u);
        }
        if (pw != null) {
            password.setText(pw);
        }
        if (d != null) {
            database.setText(d);
        }
    }

    private boolean test(String pw) {
        try {
            if (database.getText().trim().isEmpty()) {
                AlertUtils.showWarning("Enter the database.");
                return false;
            } else {
                MySQLDatabase.getDb(hostname.getText(), port.getText(), username.getText(), pw, database.getText());
                Connection connection = MySQLDatabase.connection();
                connection.close();
                return true;
            }
        } catch (Exception e) {
            if (e.getMessage().startsWith("Access ")) {
                selectedPassword++;
                if (selectedPassword >= PASSWORDS.length) {
                    AlertUtils.showError(e.getMessage());
                    return false;
                } else {
                    return test(PASSWORDS[selectedPassword]);
                }
            } else {
                AlertUtils.showError(e.getMessage());
            }
            return false;
        }
    }

    private void runTempQuery() {
//        Connection connection = null;
//        try {
//            String query = "ALTER TABLE `member0` CHANGE COLUMN `address` `address` VARCHAR(200) "
//                    + "CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL ";
//            connection = MySQLDatabase.connection();
//            MySQLDatabase.setData(connection, connection.createStatement(), query);
//            connection.commit();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            try {
//                connection.close();
//            } catch (Exception ex) {
//            }
//        }
    }
}
