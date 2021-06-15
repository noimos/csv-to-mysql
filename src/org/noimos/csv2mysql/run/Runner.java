package org.noimos.csv2mysql.run;

import org.noimos.csv2mysql.view.Settings;

/**
 *
 * @author Mahen Samaranayake
 */
public class Runner {
    
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        new Settings().setVisible(true);
    }
}
