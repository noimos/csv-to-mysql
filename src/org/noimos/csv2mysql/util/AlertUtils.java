package org.noimos.csv2mysql.util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

// Alert utilities
public class AlertUtils {

    public static String title = "Confirmation";
    public static boolean option;

    public static boolean showOption(String message) {
        JLabel label = new JLabel(message);
        int result = JOptionPane.showConfirmDialog(null, label, title, JOptionPane.OK_CANCEL_OPTION);
        return result == 0;
    }

    // show alert (Sinhala supported)
    public static void showAlert(String message) {
        JOptionPane.showMessageDialog(null, "<html><p style='font-size:14; font-family:Iskoola Pota'>" + message + "</p></html>");
    }

    // show error (Sinhala supported)
    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, "<html><p style='font-size:14; font-family:Iskoola Pota'>" + message + "</p></html>", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // show warning (Sinhala supported)
    public static void showWarning(String message) {
        JOptionPane.showMessageDialog(null, "<html><p style='font-size:14; font-family:Iskoola Pota'>" + message + "</p></html>", "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
