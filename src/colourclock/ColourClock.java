package colourclock;

import java.awt.*;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ColourClock extends JFrame {

    private JPanel panel;

    public ColourClock() {
        Calendar cal;
        int second;
        int minute;
        int hour;
        int amPm;
        int millisecond;

        String mornAfter = "";

        Color color;

        setTitle("ColourClock");
        panel = new JPanel();
        JLabel label = new JLabel();
        label.setFont(new Font("Calibri", Font.PLAIN, 36));
        

        panel.add(label);

        add(panel, BorderLayout.CENTER);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //int loopCount = 0;
        while (true) {
            /*loopCount = loopCount + 1;
            System.out.println(loopCount);*/

            cal = new GregorianCalendar();
            second = cal.get(Calendar.SECOND);
            minute = cal.get(Calendar.MINUTE);
            hour = cal.get(Calendar.HOUR);
            amPm = cal.get(Calendar.AM_PM);
            millisecond = cal.get(Calendar.MILLISECOND);

            mornAfter = "";
            if (amPm == 1) {
                mornAfter = "PM";
            } else {
                mornAfter = "AM";
            }

            color = colorGenerator(minute, second, millisecond);
            panel.setBackground(color);

            label.setText("" + hour + ":" + minute + ":" + second + " " + mornAfter + "");
            setVisible(true);

            // Delay for one second
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ColourClock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String args[]) {

        new ColourClock();

    }

    public static Color colorGenerator(int minute, int second, int millisecond) {

        int r = minute * 4;
        int g = second * 4;
        int b = millisecond / 4;

        return (new Color(r, g, b));

    }

}
