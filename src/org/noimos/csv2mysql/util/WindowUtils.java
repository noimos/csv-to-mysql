package org.noimos.csv2mysql.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;

// utilities of frames
public class WindowUtils {

    public static void setFrameInTheMiddleOfTheScreen(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int) (dim.getWidth() / 2 - frame.getWidth() / 2), (int) (dim.getHeight() / 2 - frame.getHeight() / 2));
    }

    public static void setFrameInTheMiddleOfTheScreen(JDialog frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int) (dim.getWidth() / 2 - frame.getWidth() / 2), (int) (dim.getHeight() / 2 - frame.getHeight() / 2));
    }

}
