package MY_Classes;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateChooserBox {
   public JDateChooser dateChooser;
    // public static void main(String[] args) {
        // JFrame frame = new JFrame("Date Chooser Example");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(400, 200);
        // frame.setVisible(true);
      public DateChooserBox(){
        // JPanel panel = new JPanel();
        // frame.add(panel);

        // Create a JDateChooser
         dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd"); // Set the date format
        dateChooser.setDate(new Date()); // Set an initial date (optional)

        // // Create a label to display the selected date
        // JLabel label = new JLabel("Selected Date: ");

        // // Create a button to get the selected date
        // JButton button = new JButton("Get Date");
        // button.addActionListener(e -> {
        //     Date selectedDate = dateChooser.getDate();
        //     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //     String formattedDate = dateFormat.format(selectedDate);
        //     label.setText("Selected Date: " + formattedDate);
        // });
    }
        // Add components to the panel
        // panel.add(dateChooser);
       

        // frame.setVisible(true);
    // }
}
