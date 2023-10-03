
// import java.awt.*;
// import java.awt.event.*;
// import java.time.format.TextStyle;
// import javax.swing.*;

// public class Login implements ActionListener {
//   JFrame f1, f2;
//   JButton li, lo;
//   JLabel l1, l2, l3;
//   public String un = "m", ps = "m123";
//   TextField t1, t2;

//   Login() {
//     f1 = new JFrame();
//     f1.setLayout(new GridBagLayout());

//     l1 = new JLabel("UserName:");
//     l1.setFont(new Font("Arial", Font.BOLD, 20));
//     l2 = new JLabel("Password:");
//     l2.setFont(new Font("Arial", Font.BOLD, 20));
//     l3 = new JLabel("");
//     l3.setFont(new Font("Arial", Font.BOLD, 10));
//     t1 = new TextField(20);
//     t1.setFont(new Font("Arial", Font.BOLD, 20));
//     t2 = new TextField(20);
//     t2.setFont(new Font("Arial", Font.BOLD, 20));
//     // t2.setEchoChar('*');
//     li = new JButton("Login");
//     li.setFont(new Font("Arial", Font.BOLD, 15));
//     GridBagConstraints gc = new GridBagConstraints();
//     gc.ipadx = 25; // add padding
//     gc.ipady = 25;
//     gc.gridx = 0;
//     gc.gridy = 0;
//     f1.add(l1, gc);
//     gc.gridx = 1;
//     gc.gridy = 0;
//     f1.add(t1, gc);
//     gc.gridx = 0;
//     gc.gridy = 1;
//     f1.add(l2, gc);
//     gc.gridx = 1;
//     gc.gridy = 1;
//     f1.add(t2, gc);
//     gc.gridx = 1;
//     gc.gridy = 2;
//     f1.add(li, gc);
//     gc.gridx = 0;
//     gc.gridy = 3;
//     gc.gridwidth = 2;
//     f1.add(l3, gc);

//     li.addActionListener(this);
//     f1.setSize(500, 300);
//     f1.setLocationRelativeTo(null);
//     f1.setVisible(true);
//     Home();
//   }

//   public void Home() {
//     f2 = new JFrame();
//     f2.setLayout(new FlowLayout());
//     JLabel g, a, m, b, c;
//     g = new JLabel("Genres");
//     // g.setFont(new Font("Arial", Font.BOLD, 20));
//     a = new JLabel("Author");
//     // a.setFont(new Font("Arial", Font.BOLD, 20));
//     m = new JLabel("Members");
//     // m.setFont(new Font("Arial", Font.BOLD, 20));
//     b = new JLabel("Books");
//     // b.setFont(new Font("Arial", Font.BOLD, 20));
//     c = new JLabel("Circulation");
//     // c.setFont(new Font("Arial", Font.BOLD, 20));
//     Container co1 = f2.getContentPane();
//     co1.setLayout(new GridLayout(10, 0));
//     co1.add(g);co1.add(a);co1.add(m);co1.add(b);co1.add(c);
//     co1.setBackground(Color.blue);
//     // co1.setBounds(0, 0, 100, 0);
//     int  H=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
//     int  V=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
//     JScrollPane jsp=new JScrollPane(co1, V, H);
//     f2.add(jsp);
//     lo = new JButton("Button2");
//     // f2.setBounds(0, 0, 800, 800);

//     f2.add(lo);
//     lo.addActionListener(this);
//     f2.setLocationRelativeTo(null);
//     f2.setSize(200, 200);

//   }

//   public void actionPerformed(ActionEvent e) {
//     if (e.getSource() == li) {
//       // if (t1.getText().equals("") || t2.getText().equals("")) {
//       //   l3.setText("TextFied can't be empty");
//       // } else if (t1.getText().equals(un) && t2.getText().equals(ps)) {
//         f1.setVisible(false);
//         f2.setVisible(true);
//       //   l3.setText("Login successfull");
//       // } else {
//       //   l3.setText("UserName or Password in incorrect");
//       // }
//     } else if (e.getSource() == lo) {
//       f2.setVisible(false);
//       f1.setVisible(true);
//     }
//   }

//   public static void main(String[] args) {
//     Login l = new Login();
//   }
// }

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.*;
import java.security.PublicKey;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.DefaultTableModel;
import MY_Classes.DB;
import MY_Classes.DateChooserBox;
import javafx.scene.layout.Border;

import java.sql.*;
import java.util.Stack;

// public class DB{

//   private String username="localhost";
// }

public class AJPro implements ActionListener {
  public JFrame f1, f2, f3, f4, f5, f6, f7, f8, msgFrame;
  // public Frame msgFrame;
  JButton li, lo, okButton;

  JButton lg, la, lm1, lm2, lm3, lm4, lb1, lb2, lb3, lb4, lc1, lc2;

  int TableCount[] = { 0, 0, 0 };
  JLabel l3, books, Members, Authors, messageLabel;
  String Tables[] = { "Books", "Members", "Authors" };
  public String un = "", ps = "", sql = "", message;
  TextField t1, t2;
  Connection myConn;
  Statement mystem;
  ResultSet myRs, myRs1;
  String jdbcUrl = "jdbc:mysql://localhost:3306/project";
  String username = "root";
  String password = "mohit2303";
  int a = 1;
  public boolean fopen1 = false, msgopen = false, fopen2 = false, fopen3 = false;

  AJPro() {

    try {
      // f3.addWindowListener(f3WindowListener);

      // msgFrame.addWindowListener(f3WindowListener);
      // okButton.addActionListener(this);

      // f6.addWindowListener(this);
      // f7.addWindowListener(this);
      // f8.addWindowListener(this);

      // myConn = DB.getConnection();
      // String sql = "SELECT * FROM project.authors";
      // PreparedStatement preparedStatement1 = myConn.prepareStatement(sql);
      // myRs = preparedStatement1.executeQuery();
      // while (myRs.next()) {

      // }

      for (int i = 0; i < 3; i++) {
        myConn = DB.getConnection();
        String sql2 = "SELECT COUNT(*) FROM project." + Tables[i];
        PreparedStatement preparedStatement2 = myConn.prepareStatement(sql2);
        myRs = preparedStatement2.executeQuery();
        if (myRs.next()) {
          TableCount[i] = myRs.getInt(1);
          System.out.println("Row count for table is: " + TableCount[i]);
        }
      }

      myConn = DB.getConnection();
      // DriverManager.getConnection(jdbcUrl, username, password);
      // Execute a SQL query to retrieve data (replace with your query)
      sql = "SELECT id, username, password FROM admin";
      mystem = myConn.createStatement();
      myRs1 = mystem.executeQuery(sql);
      while (myRs1.next()) {
        un = myRs1.getString("username");
        ps = myRs1.getString("password");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    Login();
  }

  public void Login() {

    f1 = new JFrame("Login");
    f1.setLayout(new GridBagLayout());
    JLabel l1, l2;
    l1 = new JLabel("UserName:");
    l1.setFont(new Font("Arial", Font.BOLD, 20));
    l2 = new JLabel("Password:");
    l2.setFont(new Font("Arial", Font.BOLD, 20));
    l3 = new JLabel(" ");
    l3.setFont(new Font("Arial", Font.BOLD, 12));
    t1 = new TextField(20);
    t1.setFont(new Font("Arial", Font.BOLD, 20));
    t2 = new TextField(20);
    t2.setFont(new Font("Arial", Font.BOLD, 20));
    // t2.setEchoChar('*');
    li = new JButton("Login");
    li.setFont(new Font("Arial", Font.BOLD, 15));

    GridBagConstraints gc = new GridBagConstraints();
    gc.ipadx = 25; // add padding
    gc.ipady = 25;
    gc.gridx = 0;
    gc.gridy = 0;
    f1.add(l1, gc);

    gc.gridx = 1;
    gc.gridy = 0;
    f1.add(t1, gc);

    gc.gridx = 0;
    gc.gridy = 1;
    f1.add(l2, gc);

    gc.gridx = 1;
    gc.gridy = 1;
    f1.add(t2, gc);

    gc.gridx = 1;
    gc.gridy = 2;
    f1.add(li, gc);

    gc.gridx = 0;
    gc.gridy = 3;
    gc.gridwidth = 2;
    f1.add(l3, gc);

    li.addActionListener(this);

    f1.setSize(500, 250);
    f1.setLocationRelativeTo(null);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f1.setVisible(true);
  }

  public void Home() {

    f2 = new JFrame("Home");
    f2.setLayout(null);

    JLabel g = new JLabel("<html><font size='15' color=black>Genres</font></html>");
    JLabel a = new JLabel("<html><font size='15' color=black>Author</font></html>");
    JLabel m = new JLabel("<html><font size='15' color=black>Members</font></html>");
    JLabel b = new JLabel("<html><font size='15' color=black>Books</font></html>");
    JLabel c = new JLabel("<html><font size='15' color=black>Circulation</font></html>");
    lg = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Manage Genres</font></pre></html>");
    la = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Manage Author</font></pre></html>");
    lm1 = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Add Member</font></pre></html>");
    lm2 = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Edit Member</font></pre></html>");
    lm3 = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Delete Member</font></pre></html>");
    lm4 = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Member List</font></pre></html>");
    lb1 = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Add Book</font></pre></html>");
    lb2 = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Edit Book</font></pre></html>");
    lb3 = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Delete Book</font></pre></html>");
    lb4 = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Books List</font></pre></html>");
    lc1 = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Issue Book</font></pre></html>");
    lc2 = new JButton("<html><pre><font face='Verdana' size='5' color=black>       Return Book</font></pre></html>");
    lg.addActionListener(this);
    la.addActionListener(this);
    lm1.addActionListener(this);
    lm2.addActionListener(this);
    lm3.addActionListener(this);
    lm4.addActionListener(this);
    lb1.addActionListener(this);
    lb2.addActionListener(this);
    lb3.addActionListener(this);
    lb4.addActionListener(this);

    ImageIcon i = new ImageIcon("logo.png");
    JLabel logo = new JLabel(i);
    logo.setBounds(0, 0, 400, 200);
    JPanel panel = new JPanel();
    f2.add(logo);
    panel.setLayout(new GridLayout(18, 0));
    panel.add(g);
    panel.add(lg);
    panel.add(a);
    panel.add(la);
    panel.add(m);
    panel.add(lm1);
    panel.add(lm2);
    panel.add(lm3);
    panel.add(lm4);
    panel.add(b);
    panel.add(lb1);
    panel.add(lb2);
    panel.add(lb3);
    panel.add(lb4);
    panel.add(c);
    // panel.setLayout(new GridLayout(1,1));
    panel.add(lc1);
    panel.add(lc2);

    panel.setBackground(Color.GRAY);
    panel.setBounds(0, 200, 400, 840);
    // JScrollPane jsp = new JScrollPane(panel);
    // jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    lo = new JButton("Logout");
    lo.setBounds(1800, 0, 100, 50);
    lo.addActionListener(this);

    f2.add(panel);
    f2.add(lo);

    JPanel pb, pm, pa, plba, p1, p2, p3, p4;
    pb = new JPanel();
    pm = new JPanel();
    pa = new JPanel();
    plba = new JPanel();
    JLabel B, M, A, LBA;
    B = new JLabel("<html><font size='40' color=white>Books</font></html>");
    pb.add(B);

    M = new JLabel("<html><font size='40' color=white>Members</font></html>");
    pm.add(M);
    A = new JLabel("<html><font size='40' color=white>Authors</font></html>");
    pa.add(A);
    LBA = new JLabel("<html><font size='40' color=white> Latest Books Added</font></html>");
    // LBA.setFont(new Font("Arial", Font.BOLD, 40));
    plba.add(LBA);
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    p4 = new JPanel();
    // p1.add(pb);p2.add(pm);p3.add(pa);p4.add(plba);

    pb.setBounds(430, 80, 450, 100);
    pb.setBackground(Color.gray);
    p1.setBounds(430, 150, 450, 310);
    p1.setBackground(Color.black);

    pm.setBounds(930, 80, 450, 100);
    pm.setBackground(Color.gray);
    p2.setBounds(930, 150, 450, 310);
    p2.setBackground(Color.black);

    pa.setBounds(1430, 80, 450, 100);
    pa.setBackground(Color.gray);
    p3.setBounds(1430, 150, 450, 310);
    p3.setBackground(Color.black);

    plba.setBounds(430, 500, 1450, 80);
    plba.setBackground(Color.gray);
    p4.setBounds(430, 580, 1450, 390);
    p4.setBackground(Color.black);
    // p3.setLayout(null);

    books = new JLabel(
        "<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
            + Integer.toString(TableCount[0]) + "</font></pre></html>");
    Members = new JLabel(
        "<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
            + Integer.toString(TableCount[1]) + "</font></pre></html>");
    Authors = new JLabel(
        "<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
            + Integer.toString(TableCount[2]) + "</font></pre></html>");

    p1.add(books);
    p2.add(Members);
    p3.add(Authors);
    f2.add(p1);
    f2.add(p2);
    f2.add(p3);
    f2.add(p4);
    f2.add(pb);
    f2.add(pm);
    f2.add(pa);
    f2.add(plba);

    f2.setSize(1920, 1080);
    f2.setLocationRelativeTo(null);
    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f2.setVisible(false);
  }

  public class ManageGenres implements ActionListener {
    JLabel id, n;
    JTextField tid, tn;
    JButton Gadd, Gedit, Gdelete;
    JPanel p1, p2, p3;

    ManageGenres() {

      f3 = new JFrame();
      f3.addWindowListener(f3WindowListener);
      // f3 = new JFrame();
      f3.setLayout(null);

      id = new JLabel("<html><font size='6' color=black>ID:</font><br></br></html>");
      n = new JLabel("<html><font size='6' color=black>Name:</font><br></br></html>");

      tid = new JTextField(5);
      tid.setFont(new Font("Arial", Font.BOLD, 18));
      tn = new JTextField(10);
      tn.setFont(new Font("Arial", Font.BOLD, 18));

      Gadd = new JButton("<html><font size='6' color=black>Add</font></html>");
      Gedit = new JButton("<html><font size='6' color=black>Edit</font></html>");
      Gdelete = new JButton("<html><font size='6' color=black>Delete</font></html>");
      Gadd.addActionListener(this);
      Gedit.addActionListener(this);
      Gdelete.addActionListener(this);
      p1 = new JPanel();
      p1.setBackground(Color.black);
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Manage Genres</font></pre></html>"));
      p1.setBounds(0, 0, 800, 100);

      p2 = new JPanel();
      p2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 80));
      p2.add(id);
      p2.add(tid);
      p2.add(n);
      p2.add(tn);

      p2.setBackground(Color.CYAN);
      p2.setBounds(0, 101, 420, 550);

      p3 = new JPanel();
      p3.setLayout(new GridLayout(1, 3, 40, 40));
      p3.add(Gadd);
      p3.add(Gedit);
      p3.add(Gdelete);
      p3.setBounds(0, 681, 400, 50);

      loadTableData();

    }

    public void loadTableData() {
      // JPanel p4=new JPanel();
      try {
        myConn = DB.getConnection();
        // DriverManager.getConnection(jdbcUrl, username, password);
        // Execute a SQL query to retrieve data (replace with your query)
        String sql = "SELECT * FROM Genres";
        mystem = myConn.createStatement();
        myRs = mystem.executeQuery(sql);
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add columns to the table model (replace with your column names)
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");

        // Populate the table model with data from the result set
        while (myRs.next()) {

          Object[] rowData = {
              myRs.getInt("ID"),
              myRs.getString("Name"),

          };

          tableModel.addRow(rowData);
          // Authors.setText(Integer.toString(Integer.parseInt(Authors.getText())+1));
        }

        // Create a JTable and set its model to the table model
        JTable table = new JTable(tableModel);
        table.getTableHeader().setReorderingAllowed(false);
        table.setEnabled(false);
        // Add a ListSelectionListener to detect row selection changes
        // table.getSelectionModel().addListSelectionListener(new
        // ListSelectionListener() {
        // @Override
        // public void valueChanged(ListSelectionEvent e) {
        // int selectedRow = table.getSelectedRow();

        // if (selectedRow >= 0) {
        // // Retrieve data from the selected row
        // Object idValue = tableModel.getValueAt(selectedRow, 0);
        // Object nameValue = tableModel.getValueAt(selectedRow, 1);

        // // Display the data in the text fields
        // tid.setText(idValue.toString());
        // tn.setText(nameValue.toString());
        // }
        // }
        // });

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        // Create a JScrollPane to display the table
        JScrollPane jsp = new JScrollPane(table, v, h);

        // p4.add(Atable);
        jsp.setBounds(420, 101, 350, 550);

        f3.add(p1);
        f3.add(p2);
        f3.add(p3);
        f3.add(jsp);
        f3.setSize(800, 800);
        f3.setLocationRelativeTo(null);

        // f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // f3.setVisible(false);
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    public void actionPerformed(ActionEvent e) {
      try {
        // You should have a database connection established before performing SQL
        // operations
        myConn = DB.getConnection();
        if (e.getSource() == Gadd) {
          // Perform an INSERT operation
          String idValue = tid.getText(); // Assuming tid is a JTextField
          String nameValue = tn.getText(); // Assuming tn is a JTextField

          // Create a prepared statement to safely insert data
          String sql = "INSERT INTO `project`.`genres`(`ID`, `Name`) VALUES (?,?)";
          // String sql = "insert into genres(ID, Name) values
          // ('"+tid.getText()+"','"+tn.getText()+"')";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameters using the values from your text fields
          preparedStatement.setString(1, idValue);
          preparedStatement.setString(2, nameValue);
          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {

            // msgFrame.setVisible(true);
            // if(msgopen==false){
            // loadTableData();
            MsgBox m = new MsgBox();
            msgFrame.setVisible(true);
            // MsgBox.setVisible(true);
            // MsgBox.okButton.setText();
            // }
            System.out.println("Insert successful.");
            // You may want to update your table or UI here if needed.
          } else {
            System.out.println("Insert failed.");
          }
          loadTableData();

          // Clear the text fields
          tid.setText("");
          tn.setText("");

        }

        if (e.getSource() == Gedit) {
          // Perform an UPDATE operation
          // Replace with your UPDATE SQL statement and logic here
          String idValue = tid.getText(); // Assuming tid is a JTextField
          String nameValue = tn.getText(); // Assuming tn is a JTextField

          // Create a prepared statement to safely update data
          String sql = "UPDATE `project`.`genres` SET `Name`=? WHERE `ID`=?";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameters using the values from your text fields
          preparedStatement.setString(1, nameValue);
          preparedStatement.setInt(2, Integer.parseInt(idValue)); // Assuming ID is an integer

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            System.out.println("Update successful.");
            // You may want to update your table or UI here if needed.
          } else {
            System.out.println("Update failed.");
          }

          // Refresh the table with updated data
          loadTableData();

          // Clear the text fields
          tid.setText("");
          tn.setText("");

        }

        if (e.getSource() == Gdelete) {
          // Perform a DELETE operation
          // Replace with your DELETE SQL statement and logic here
          String idValue = tid.getText(); // Assuming tid is a JTextField

          // Create a prepared statement to safely delete data
          String sql = "DELETE FROM `project`.`genres` WHERE `ID`=?";
          // DELETE FROM `project`.`genres` WHERE `ID` = 2;
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameter using the ID value (assuming ID is an integer)
          preparedStatement.setInt(1, Integer.parseInt(idValue));

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            System.out.println("Delete successful.");
            // You may want to update your table or UI here if needed.
          } else {
            System.out.println("Delete failed.");
          }

          // Refresh the table with updated data
          loadTableData();

          // Clear the text fields
          tid.setText("");
          tn.setText("");

        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

  }

  public class ManageAuthors implements ActionListener {
    JLabel id, fn, ln, phone, expert, abo;
    public JTextField tid, tfn, tln, tp, te;
    JButton Aadd, Aedit, Adelete;
    JTextArea ta;
    JPanel p1, p2, p3;
    String did, dfn, dln, dphone, dexpert, dabo;
    int acount;

    ManageAuthors(int c) {
      acount = c;
      f4 = new JFrame();
      f4.addWindowListener(f3WindowListener);
      f4.setLayout(null);

      id = new JLabel("<html><font size='6' color=black>ID:</font><br></br></html>");
      fn = new JLabel("<html><font size='6' color=black>First Name:</font><br></br></html>");
      ln = new JLabel("<html><font size='6' color=black>Last Name:</font><br></br></html>");
      phone = new JLabel("<html><font size='6' color=black>Phone Number:</font><br></br></html>");
      expert = new JLabel("<html><font size='6' color=black>Expertise:</font><br></br></html>");
      abo = new JLabel("<html><font size='6' color=black>About:</font></html>");

      tid = new JTextField(5);
      tid.setFont(new Font("Arial", Font.BOLD, 18));

      tfn = new JTextField(10);
      tfn.setFont(new Font("Arial", Font.BOLD, 18));
      tln = new JTextField(10);
      tln.setFont(new Font("Arial", Font.BOLD, 18));
      tp = new JTextField(10);
      tp.setFont(new Font("Arial", Font.BOLD, 18));
      te = new JTextField(10);
      te.setFont(new Font("Arial", Font.BOLD, 18));
      ta = new JTextArea(3, 10);
      ta.setFont(new Font("Arial", Font.BOLD, 18));

      Aadd = new JButton("<html><font size='6' color=black>Add</font></html>");
      Aedit = new JButton("<html><font size='6' color=black>Edit</font></html>");
      Adelete = new JButton("<html><font size='6' color=black>Delete</font></html>");
      Aadd.addActionListener(this);
      Aedit.addActionListener(this);
      Adelete.addActionListener(this);

      p1 = new JPanel();
      p1.setBackground(Color.black);
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Manage Authors</font></pre></html>"));
      p1.setBounds(0, 0, 800, 100);

      p2 = new JPanel();
      p2.setLayout(new FlowLayout(FlowLayout.LEFT));
      p2.add(id);
      p2.add(tid);
      p2.add(fn);
      p2.add(tfn);
      p2.add(ln);
      p2.add(tln);
      p2.add(phone);
      p2.add(tp);
      p2.add(expert);
      p2.add(te);
      p2.add(abo);
      p2.add(ta);
      p2.setBackground(Color.CYAN);
      p2.setBounds(0, 101, 240, 550);

      p3 = new JPanel();
      p3.setLayout(new GridLayout(1, 3, 40, 40));
      p3.add(Aadd);
      p3.add(Aedit);
      p3.add(Adelete);
      p3.setBounds(0, 681, 400, 50);
      loadTableData();
    }

    // JPanel p4=new JPanel();
    public void loadTableData() {
      try {
        myConn = DB.getConnection();
        // DriverManager.getConnection(jdbcUrl, username, password);
        // Execute a SQL query to retrieve data (replace with your query)
        String sql = "SELECT * FROM Authors";
        mystem = myConn.createStatement();
        myRs = mystem.executeQuery(sql);
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add columns to the table model (replace with your column names)
        tableModel.addColumn("ID");
        tableModel.addColumn("First_Name");
        tableModel.addColumn("Last_Name");
        tableModel.addColumn("Phone_No");
        tableModel.addColumn("Expertise");
        tableModel.addColumn("About");

        // Populate the table model with data from the result set
        while (myRs.next()) {

          Object[] rowData = {
              myRs.getString("ID"),
              myRs.getString("First_Name"),
              myRs.getString("Last_Name"),
              myRs.getString("Phone_No"),
              myRs.getString("Expertise"),
              myRs.getString("About")

          };
          tableModel.addRow(rowData);

          // Authors.setText(Integer.toString(Integer.parseInt(Authors.getText())+1));
        }

        // Create a JTable and set its model to the table model
        JTable table = new JTable(tableModel);
        table.getTableHeader().setReorderingAllowed(false);
        table.setEnabled(false);

        // table.getSelectionModel().addListSelectionListener(new
        // ListSelectionListener() {
        // @Override
        // public void valueChanged(ListSelectionEvent e) {
        // int selectedRow = table.getSelectedRow();

        // if (selectedRow >= 0) {
        // // Retrieve data from the selected row
        // Object idValue=tableModel.getValueAt(selectedRow, 0);
        // Object fnameValue = tableModel.getValueAt(selectedRow, 1);
        // Object lnameValue = tableModel.getValueAt(selectedRow, 2);
        // Object phoneValue = tableModel.getValueAt(selectedRow, 3);
        // Object expertValue = tableModel.getValueAt(selectedRow, 4);
        // Object aboutValue = tableModel.getValueAt(selectedRow, 5);

        // // Display the data in the text fields
        // tid.setText(idValue.toString());
        // tfn.setText(fnameValue.toString());
        // tln.setText(lnameValue.toString());
        // tp.setText(phoneValue.toString());
        // te.setText(expertValue.toString());
        // ta.setText(aboutValue.toString());
        // }
        // }
        // });
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        // Create a JScrollPane to display the table
        JScrollPane jsp = new JScrollPane(table, v, h);

        // p4.add(Atable);
        jsp.setBounds(240, 101, 550, 550);

        f4.add(p1);
        f4.add(p2);
        f4.add(p3);
        f4.add(jsp);
        f4.setSize(800, 800);
        f4.setLocationRelativeTo(null);

        // f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // f4.setVisible(false);

      } catch (Exception e) {
        System.out.println(e);
      }
    }

    // public void textValueChenged(TextEvent e){

    // }

    public void ASearch(String id) {
      try {
        // Establish a database connection
        myConn = DB.getConnection();

        // Create a SQL query with a parameter placeholder
        String sql = "SELECT * FROM project.authors WHERE `ID`= ?";

        // Create a PreparedStatement with the query
        PreparedStatement preparedStatement = myConn.prepareStatement(sql);

        // Set the parameter value using the provided 'id'
        preparedStatement.setString(1, id);

        // Execute the query
        myRs = preparedStatement.executeQuery();

        // Process the result set
        while (myRs.next()) {
          did = myRs.getString("ID");
          dfn = myRs.getString("First_Name");
          dln = myRs.getString("Last_Name");
          dphone = myRs.getString("Phone_No");
          dexpert = myRs.getString("Expertise");
          dabo = myRs.getString("About");

          System.out.println(dfn);
        }
        if (tfn.getText() == " ") {
          tfn.setText(dfn);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

    }

    public void actionPerformed(ActionEvent e) {
      try {
        // You should have a database connection established before performing SQL
        // operations
        //
        if (e.getSource() == Aadd) {
          // Perform an INSERT operation
          // Assuming tn is a JTextField
          // ASearch("1");
          // Create a prepared statement to safely insert data
          String sql = "INSERT INTO `project`.`authors`(`ID`, `First_Name`,`Last_Name`, `Phone_No`,`Expertise`, `About`) VALUES (?, ?,?,?, ?,?)";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);
          String idValue = tid.getText().trim().isEmpty() ? null : tid.getText(); // Assuming tid is a JTextField
          String fnameValue = tfn.getText().trim().isEmpty() ? null : tfn.getText();
          String lnameValue = tln.getText().trim().isEmpty() ? null : tln.getText();
          String pnumValue = tp.getText().trim().isEmpty() ? null : tp.getText();
          String expeValue = te.getText().trim().isEmpty() ? null : te.getText();
          String aboValue = ta.getText().trim().isEmpty() ? null : ta.getText();
          // Set the parameters using the values from your text fields
          preparedStatement.setString(1, idValue);
          preparedStatement.setString(2, fnameValue);
          preparedStatement.setString(3, lnameValue);
          preparedStatement.setString(4, pnumValue);
          preparedStatement.setString(5, expeValue);
          preparedStatement.setString(6, aboValue);
          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            TableCount[2]++;
            Authors.setText("<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
                + Integer.toString(TableCount[2]) + "</font></pre></html>");

            System.out.println("Insert successful.");
            // You may want to update your table or UI here if needed.
          } else {
            System.out.println("Insert failed.");
          }
          loadTableData();

          // Clear the text fields
          tid.setText(""); // Assuming tid is a JTextField
          tfn.setText("");
          tln.setText("");
          tp.setText("");
          te.setText("");
          ta.setText("");

        }

        if (e.getSource() == Aedit) {
          // Perform an UPDATE operation
          // Replace with your UPDATE SQL statement and logic here
          // Assuming tn is a JTextField
          // ASearch(tid.getText());
          // Create a prepared statement to safely update data
          String sql = "UPDATE `project`.`authors` SET `First_Name`=?,`Last_Name`=?,`Phone_No`=?,`Expertise`=?,`About`=? WHERE `ID`=?";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);
          ASearch(tid.getText());
          String idValue = tid.getText(); // Assuming tid is a JTextField
          String fnameValue;
          if (tfn.getText().trim().isEmpty()) {
            fnameValue = dfn;
          } else {
            fnameValue = tfn.getText();
          }
          String lnameValue;
          if (tln.getText().trim().isEmpty()) {
            lnameValue = dln;
          } else {
            lnameValue = tln.getText();
          }
          String pnumValue;
          if (tp.getText().trim().isEmpty()) {
            pnumValue = dphone;
          } else {
            pnumValue = tp.getText();
          }
          String expeValue;
          if (te.getText().trim().isEmpty()) {
            expeValue = dexpert;
          } else {
            expeValue = te.getText();
          }
          String aboValue;
          if (ta.getText().trim().isEmpty()) {
            aboValue = dabo;
          } else {
            aboValue = ta.getText();
          }
          // Set the parameters using the values from your text fields

          preparedStatement.setString(1, fnameValue);
          preparedStatement.setString(2, lnameValue);
          preparedStatement.setString(3, pnumValue);
          preparedStatement.setString(4, expeValue);
          preparedStatement.setString(5, aboValue);
          preparedStatement.setString(6, idValue);// Assuming ID is an integer

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            System.out.println("Update successful.");

            // You may want to update your table or UI here if needed.
          } else {
            System.out.println("Update failed.");
          }

          // Refresh the table with updated data

          loadTableData();

          // Clear the text fields
          tid.setText(""); // Assuming tid is a JTextField
          tfn.setText("");
          tln.setText("");
          tp.setText("");
          te.setText("");
          ta.setText("");

        }

        if (e.getSource() == Adelete) {
          // Perform a DELETE operation
          // Replace with your DELETE SQL statement and logic here

          // Create a prepared statement to safely delete data
          String sql = "DELETE FROM `project`.`authors` WHERE `ID`=?";
          // DELETE FROM `project`.`genres` WHERE `ID` = 2;
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);
          String idValue = tid.getText(); // Assuming tid is a JTextField
          // String fnameValue = tfn.getText();
          // String lnameValue = tln.getText();
          // String pnumValue = tp.getText();
          // String expeValue = te.getText();
          // String aboValue = ta.getText();
          // Set the parameter using the ID value (assuming ID is an integer)
          preparedStatement.setInt(1, Integer.parseInt(idValue));

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            TableCount[2]--;
            Authors.setText("<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
                + Integer.toString(TableCount[2]) + "</font></pre></html>");
            System.out.println("Delete successful.");
            // You may want to update your table or UI here if needed.
          } else {
            System.out.println("Delete failed.");
          }

          // Refresh the table with updated data
          loadTableData();

          // Clear the text fields
          tid.setText(""); // Assuming tid is a JTextField
          tfn.setText("");
          tln.setText("");
          tp.setText("");
          te.setText("");
          ta.setText("");

        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

  }

  public class ManageMembers implements ActionListener {
    public JLabel mid, mfn, mln, mpn, me, mg, fulname, gender;
    JTextField tid, tfn, tln, tp, te, tg;
    JComboBox cbg;
    JPanel p1, p2, p3, p4;
    JButton Ma, Me, Md, Msearch;
    String id = "0";
    String did, dfn, dln, dphone, demail, dgen;
    int mcount;

    ManageMembers(int c) {
      mcount = c;
      f5 = new JFrame();
      f5.addWindowListener(f3WindowListener);
      f5.setLayout(null);
      f5.setSize(500, 800);
      f5.setLocationRelativeTo(null);
      mid = new JLabel("Enter Member ID:");
      mid.setFont(new Font("Arial", Font.BOLD, 38));
      mfn = new JLabel("First Name:");
      mfn.setFont(new Font("Arial", Font.BOLD, 38));
      mln = new JLabel("Last Name:");
      mln.setFont(new Font("Arial", Font.BOLD, 38));
      mpn = new JLabel("Phone Number:");
      mpn.setFont(new Font("Arial", Font.BOLD, 38));
      me = new JLabel("Email");
      me.setFont(new Font("Arial", Font.BOLD, 38));
      mg = new JLabel("Gender");
      mg.setFont(new Font("Arial", Font.BOLD, 38));
      // tg = new JTextField(20);///wdcefscs
      // tg.setFont(new Font("Arial", Font.BOLD, 38));
      cbg = new JComboBox();
      cbg.setFont(new Font("Arial", Font.BOLD, 38));
      cbg.addItem("Male");
      cbg.addItem("Female");

      Msearch = new JButton("Search");
      Msearch.setFont(new Font("Arial", Font.BOLD, 30));
      tid = new JTextField(10);
      tid.setFont(new Font("Arial", Font.BOLD, 20));
      tfn = new JTextField(20);
      tfn.setFont(new Font("Arial", Font.BOLD, 24));
      tln = new JTextField(20);
      tln.setFont(new Font("Arial", Font.BOLD, 24));
      tp = new JTextField(20);
      tp.setFont(new Font("Arial", Font.BOLD, 24));
      te = new JTextField(20);
      te.setFont(new Font("Arial", Font.BOLD, 24));

      // f6=new JFrame();f6.setLayout(null);f6.setSize(500,
      // 800);f6.setLocationRelativeTo(null);
      // f7=new JFrame();f7.setLayout(null);f7.setSize(500,
      // 800);f7.setLocationRelativeTo(null);
      // f8=new JFrame();f8.setLayout(null);f8.setSize(500,
      // 800);f8.setLocationRelativeTo(null);
      Msearch.addActionListener(this);
      p1 = new JPanel();
      p2 = new JPanel();
      p3 = new JPanel();
      p4 = new JPanel();
      p1.setBackground(Color.black);
      p2.setBackground(Color.LIGHT_GRAY);
      // p3.setBackground(Color.red);
      if (c == 1) {
        AddMember();
      }
      if (c == 2) {
        EditMember();
      }
      if (c == 3) {
        DeleteMember();
      }
      if (c == 4) {
        MembersList();
      }

      // p1.setBounds(0, 0, 500,100); f5.add(p1);

    }

    public void AddMember() {
      // f2.setEnabled(false);

      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Add Member</font></pre></html>"));

      Ma = new JButton("Add New Member");
      Ma.addActionListener(this);
      Ma.setFont(new Font("Arial", Font.BOLD, 30));
      p2.add(mfn);
      p2.add(tfn);
      p2.add(mln);
      p2.add(tln);
      p2.add(mpn);
      p2.add(tp);
      p2.add(me);
      p2.add(te);
      p2.add(mg);
      p2.add(cbg);
      p2.add(p3);

      // f5.setSize(500, 800);
      // f5.setLocationRelativeTo(null);
      p1.setBounds(0, 0, 500, 100);
      p2.setBounds(0, 101, 500, 600);
      p2.setLayout(new FlowLayout(FlowLayout.LEFT));
      p3.setLayout(new FlowLayout());
      p3.add(Ma);
      p3.setBounds(0, 700, 500, 100);
      f5.add(p1);
      f5.add(p2);
      f5.add(p3);

    }

    public void EditMember() {

      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Edit Member</font></pre></html>"));
      Me = new JButton("Edit Member Info");
      Me.setFont(new Font("Arial", Font.BOLD, 30));
      Me.addActionListener(this);
      p2.add(mid);
      p2.add(tid);
      p2.add(Msearch);
      p2.add(mfn);
      p2.add(tfn);
      p2.add(mln);
      p2.add(tln);
      p2.add(mpn);
      p2.add(tp);
      p2.add(me);
      p2.add(te);
      p2.add(mg);
      p2.add(cbg);
      p2.add(p3);

      // f5.setSize(500, 800);
      // f5.setLocationRelativeTo(null);
      p1.setBounds(0, 0, 500, 100);
      p2.setBounds(0, 101, 500, 600);
      p2.setLayout(new FlowLayout(FlowLayout.LEFT));
      p3.setLayout(new FlowLayout());
      p3.add(Me);
      p3.setBounds(0, 700, 500, 100);
      f5.add(p1);
      f5.add(p2);
      f5.add(p3);
    }

    public void DeleteMember() {
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Delete Member</font></pre></html>"));
      Md = new JButton("Delete Member ");
      Md.setFont(new Font("Arial", Font.BOLD, 30));
      Md.addActionListener(this);
      p2.add(mid);
      p2.add(tid);
      p2.add(Msearch);
      p2.add(l3);
      f5.setSize(500, 400);
      f5.setLocationRelativeTo(null);
      p1.setBounds(0, 0, 500, 100);
      p2.setBounds(0, 100, 500, 200);
      p2.setLayout(new FlowLayout(FlowLayout.LEFT));
      p3.setLayout(new FlowLayout());
      p3.add(Md);
      p3.setBounds(0, 300, 500, 100);
      f5.add(p1);
      f5.add(p2);
      f5.add(p3);
    }

    public void MembersList() {
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>List of Members</font></pre></html>"));
      p2.add(mid);
      p2.add(tid);
      p2.add(Msearch);
      Msearch.addActionListener(this);

      fulname = new JLabel("");
      fulname.setFont(new Font("Arial", Font.BOLD, 20));
      mpn.setFont(new Font("Arial", Font.BOLD, 20));
      me.setFont(new Font("Arial", Font.BOLD, 20));
      gender = new JLabel("");
      gender.setFont(new Font("Arial", Font.BOLD, 20));

      f5.setSize(1400, 900);
      f5.setLocationRelativeTo(null);
      p1.setBounds(0, 0, 1400, 100);
      p2.setBounds(0, 100, 1400, 80);
      p2.setLayout(new FlowLayout());
      p3.setLayout(new GridLayout(5, 0, 0, 0));
      p3.add(new JLabel("<html><pre><font face='Verdana' size='20' color=black>  Member Details</font></pre></html>"));
      p3.add(fulname);
      mpn.setText("");
      p3.add(mpn);
      me.setText("");
      p3.add(me);
      p3.add(gender);
      p3.setBounds(1000, 180, 400, 200);
      p4.setLayout(null);
      p4.setBounds(0, 180, 1000, 800);
      f5.add(p4);
      f5.add(p1);
      f5.add(p2);
      f5.add(p3);

      loadTableData();
    }

    public void loadTableData() {
      try {
        myConn = DB.getConnection();
        // DriverManager.getConnection(jdbcUrl, username, password);
        // Execute a SQL query to retrieve data (replace with your query)
        String sql = "SELECT * FROM Members";
        mystem = myConn.createStatement();
        myRs = mystem.executeQuery(sql);
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add columns to the table model (replace with your column names)
        tableModel.addColumn("ID");
        tableModel.addColumn("First_Name");
        tableModel.addColumn("Last_Name");
        tableModel.addColumn("Phone_No");
        tableModel.addColumn("Email");
        tableModel.addColumn("Gender");

        // Populate the table model with data from the result set
        while (myRs.next()) {

          Object[] rowData = {
              myRs.getString("ID"),
              myRs.getString("First_Name"),
              myRs.getString("Last_Name"),
              myRs.getString("Phone_No"),
              myRs.getString("Email"),
              myRs.getString("Gender")

          };
          id = myRs.getString("ID");
          // System.out.println(id);

          tableModel.addRow(rowData);

          // Authors.setText(Integer.toString(Integer.parseInt(Authors.getText())+1));
        }

        JTable table = new JTable(tableModel);
        // table.getTableHeader().setReorderingAllowed(false);
        // table.setEnabled(false);
        // Add a ListSelectionListener to detect row selection changes
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
            int selectedRow = table.getSelectedRow();

            if (selectedRow >= 0) {
              // Retrieve data from the selected row

              Object fnameValue = tableModel.getValueAt(selectedRow, 1);
              Object lnameValue = tableModel.getValueAt(selectedRow, 2);
              Object phoneValue = tableModel.getValueAt(selectedRow, 3);
              Object emailValue = tableModel.getValueAt(selectedRow, 4);
              Object genderValue = tableModel.getValueAt(selectedRow, 5);

              // Display the data in the text fields
              fulname.setText(fnameValue.toString() + " " + lnameValue.toString());
              mpn.setText(phoneValue.toString());
              me.setText(emailValue.toString());
              gender.setText(genderValue.toString());
            }
          }
        });

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        // Create a JScrollPane to display the table
        JScrollPane jsp = new JScrollPane(table, v, h);

        // p4.add(Atable);
        jsp.setBounds(0, 0, 1000, 800);

        p4.add(jsp);
        // f4.setSize(800, 800);
        // f4.setLocationRelativeTo(null

        // f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // f4.setVisible(false);

      } catch (Exception e) {
        System.out.println(e);
      }
    }

    public void MSearch(String id) {
      try {
        // Establish a database connection
        myConn = DB.getConnection();

        // Create a SQL query with a parameter placeholder
        String sql = "SELECT * FROM project.members WHERE `ID`= ?";

        // Create a PreparedStatement with the query
        PreparedStatement preparedStatement = myConn.prepareStatement(sql);

        // Set the parameter value using the provided 'id'
        preparedStatement.setString(1, id);

        // Execute the query
        myRs = preparedStatement.executeQuery();
        // int flag = 0;
        // Process the result set
        while (myRs.next()) {
          did = myRs.getString("ID");
          dfn = myRs.getString("First_Name");
          dln = myRs.getString("Last_Name");
          dphone = myRs.getString("Phone_No");
          demail = myRs.getString("Email");
          dgen = myRs.getString("Gender");
          // flag++;
          // System.out.println(flag);
          tfn.setEnabled(true);
          tln.setEnabled(true);
          tp.setEnabled(true);
          te.setEnabled(true);
          cbg.setEnabled(true);

          l3.setText("Member found ");

          fulname.setText("<html><pre>          " + dfn + " " + dln + "</pre></html>");
          mpn.setText("<html><pre>          " + dphone + "</pre></html>");
          me.setText("<html><pre>          " + demail + "</pre></html>");
          gender.setText("<html><pre>          " + dgen + "</pre></html>");

        }
        // if (flag == 0) {

        // }
      } catch (Exception e) {
        e.printStackTrace();
      }

    }

    public void actionPerformed(ActionEvent e) {
      try {
        myConn = DB.getConnection();
        if (e.getSource() == Ma) {
          // Perform an INSERT operation
          loadTableData();
          // Create a prepared statement to safely insert data
          String sql = "INSERT INTO `project`.`members`(`ID`, `First_Name`, `Last_Name`, `Phone_No`, `Email`, `Gender`) VALUES (?, ?, ?, ?, ?, ?)";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameters using the values from your text fields
          int id1 = Integer.parseInt(id);
          id1 = id1 + 1;
          String idValue = Integer.toString(id1); // Replace with your logic for generating the ID
          String fnameValue = tfn.getText().trim().isEmpty() ? null : tfn.getText();
          String lnameValue = tln.getText().trim().isEmpty() ? null : tln.getText();
          String pnumValue = tp.getText().trim().isEmpty() ? null : tp.getText();
          String emailValue = te.getText().trim().isEmpty() ? null : te.getText();
          // String genderValue=tg.getText().trim().isEmpty() ? dgen : tg.getText();
          String genderValue;
          Object selectedItem = cbg.getSelectedItem();

          if (selectedItem == null || selectedItem.toString().isEmpty()) {
            genderValue = dgen; // Assign the default value
          } else {
            genderValue = selectedItem.toString(); // Assign the selected item as a string
          }

          preparedStatement.setString(1, idValue);
          preparedStatement.setString(2, fnameValue);
          preparedStatement.setString(3, lnameValue);
          preparedStatement.setString(4, pnumValue);
          preparedStatement.setString(5, emailValue);
          preparedStatement.setString(6, genderValue);

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            MsgBox m = new MsgBox();
            messageLabel.setText("Member added successfuly");
            msgFrame.setVisible(true);
            System.out.println("Insert successful.");
            TableCount[1]++;
            Members.setText("<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
                + Integer.toString(TableCount[1]) + "</font></pre></html>");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Member is not added successfuly");
            msgFrame.setVisible(true);
            System.out.println("Insert failed.");
          }

          // Refresh the table with updated data
          // loadTableData();

          // Clear the text fields
          tid.setText(""); // Assuming tid is a JTextField
          tfn.setText("");
          tln.setText("");
          tp.setText("");
          te.setText("");
          // tg.setText("");

        }

        if (e.getSource() == Me) {
          // Perform an UPDATE operation

          // Create a prepared statement to safely update data
          String sql = "UPDATE `project`.`members` SET `First_Name`=?, `Last_Name`=?, `Phone_No`=?, `Email`=?, `Gender`=? WHERE `ID`=?";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Msearch.addActionListener(new ActionListener() {
          // @Override
          // public void actionPerformed(ActionEvent e) {
          // Set the JFrame's visibility to false when the button is clicked
          // MSearch(tid.getText());
          // }
          // });

          // Set the parameters using the values from your text fields
          String idValue = tid.getText(); // Assuming tid is a JTextField
          String fnameValue = tfn.getText().trim().isEmpty() ? dfn : tfn.getText();
          String lnameValue = tln.getText().trim().isEmpty() ? dln : tln.getText();
          String pnumValue = tp.getText().trim().isEmpty() ? dphone : tp.getText();
          String emailValue = te.getText().trim().isEmpty() ? demail : te.getText();
          // String genderValue=tg.getText().trim().isEmpty() ? dgen : tg.getText();

          String genderValue;
          Object selectedItem = cbg.getSelectedItem();
          if (selectedItem == null || selectedItem.toString().isEmpty()) {
            genderValue = dgen; // Assign the default value
          } else {
            genderValue = selectedItem.toString(); // Assign the selected item as a string
          }

          preparedStatement.setString(1, fnameValue);
          preparedStatement.setString(2, lnameValue);
          preparedStatement.setString(3, pnumValue);
          preparedStatement.setString(4, emailValue);
          preparedStatement.setString(5, genderValue);
          preparedStatement.setString(6, idValue); // Assuming ID is an integer

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            MsgBox m = new MsgBox();
            messageLabel.setText("Member details update successfuly");
            msgFrame.setVisible(true);
            System.out.println("Update successful.");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Member details is not update successfuly");
            msgFrame.setVisible(true);
            System.out.println("Update failed.");
          }

          // Refresh the table with updated data
          // loadTableData();

          // Clear the text fields
          tid.setText(""); // Assuming tid is a JTextField
          tfn.setText("");
          tln.setText("");
          tp.setText("");
          te.setText("");
        }

        if (e.getSource() == Md) {
          // Perform a DELETE operation

          // Create a prepared statement to safely delete data
          String sql = "DELETE FROM `project`.`members` WHERE `ID`=?";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameter using the ID value (assuming ID is an integer)
          String idValue = tid.getText(); // Assuming tid is a JTextField
          preparedStatement.setInt(1, Integer.parseInt(idValue));

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            MsgBox m = new MsgBox();
            messageLabel.setText("Member deleted successfuly");
            msgFrame.setVisible(true);
            TableCount[1]--;
            Members.setText("<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
                + Integer.toString(TableCount[1]) + "</font></pre></html>");
            l3.setText("Member deleted");
            System.out.println("Delete successful.");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Member is not deleted successfuly");
            msgFrame.setVisible(true);
            System.out.println("Delete failed.");
          }

          // Refresh the table with updated data
          // loadTableData();

          // Clear the text fields

        }

        if (e.getSource() == Msearch) {
          MSearch(tid.getText());
        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public class ManageBooks implements ActionListener {

    public JLabel Bid, Bname, Bauthor, Bgenre, Bquantity, Bpublisher, Bprice, Date_Rece, Book_Desc, Book_Cover,Book_img;
    JTextField tid, tn, ta, tg, tq, tp, tpr, tdr, tbd, tbc;
    JComboBox cbg;
    JPanel p1, p2, p3, p4;
    JButton Ba, Be, Bd, Bsearch, selaut, cancel, selpic, clear;
    ImageIcon i;
    BufferedImage image;
    String imgPath="";
    // ="C:/Users/mohit/OneDrive/Pictures/th (1).jpeg";
    // "https://upload.wikimedia.org/wikipedia/en/thumb/e/e2/IMG_Academy_Logo.svg/640px-IMG_Academy_Logo.svg.png"
    URL imgUrl;
    // String did, dfn, dln, dphone, demail, dgen;
    // int mcount;
    ManageBooks(int c) {
     try{ // mcount=c;
      f6 = new JFrame();
      f6.addWindowListener(f3WindowListener);
      f6.setLayout(null);
      f6.setSize(1500, 1000);
      f6.setLocationRelativeTo(null);
      Bid = new JLabel("Book id:");
      Bid.setFont(new Font("Arial", Font.BOLD, 38));
      Bname = new JLabel("Name:");
      Bname.setFont(new Font("Arial", Font.BOLD, 38));
      Bauthor = new JLabel("Author:");
      Bauthor.setFont(new Font("Arial", Font.BOLD, 38));
      Bgenre = new JLabel("Genre:");
      Bgenre.setFont(new Font("Arial", Font.BOLD, 38));
      Bquantity = new JLabel("Quantity:");
      Bquantity.setFont(new Font("Arial", Font.BOLD, 38));
      Bpublisher = new JLabel("Publisher:");
      Bpublisher.setFont(new Font("Arial", Font.BOLD, 38));
      Bprice = new JLabel("Price:");
      Bprice.setFont(new Font("Arial", Font.BOLD, 38));
      Date_Rece = new JLabel("Date Received:");
      Date_Rece.setFont(new Font("Arial", Font.BOLD, 38));
      Book_Desc = new JLabel("Book Description:");
      Book_Desc.setFont(new Font("Arial", Font.BOLD, 38));
      Book_Cover = new JLabel("Book Cover:");
      Book_Cover.setFont(new Font("Arial", Font.BOLD, 38));

      // imgUrl=new URL(imgPath);
      // image= ImageIO.read(imgUrl);
      i=new ImageIcon();
       Book_img=new JLabel();
     
      // tg = new JTextField(20);///wdcefscs
      // tg.setFont(new Font("Arial", Font.BOLD, 38));
      cbg = new JComboBox();
      cbg.setFont(new Font("Arial", Font.BOLD, 38));
      // cbg.addItem("Male");
      // cbg.addItem("Female");

      clear = new JButton("Clear");
       clear.setFont(new Font("Arial", Font.BOLD, 30));
      Ba = new JButton("Add Book");
          Ba.setFont(new Font("Arial", Font.BOLD, 30));
      cancel = new JButton("Cancel");
      cancel.setFont(new Font("Arial", Font.BOLD, 30));
      selaut = new JButton("select author");
      selaut.setFont(new Font("Arial", Font.BOLD, 30));
      selpic = new JButton("Sselect picture");
      selpic.setFont(new Font("Arial", Font.BOLD, 30));

      tid = new JTextField(20);
      tid.setFont(new Font("Arial", Font.BOLD, 24));
      tn = new JTextField(20);
      tn.setFont(new Font("Arial", Font.BOLD, 24));
      ta = new JTextField(20);
      ta.setFont(new Font("Arial", Font.BOLD, 24));
      tg = new JTextField(20);
      tg.setFont(new Font("Arial", Font.BOLD, 24));
      tq = new JTextField(20);
      tq.setFont(new Font("Arial", Font.BOLD, 24));
      tp = new JTextField(20);
      tp.setFont(new Font("Arial", Font.BOLD, 24));
      tpr = new JTextField(20);
      tpr.setFont(new Font("Arial", Font.BOLD, 24));
      tdr = new JTextField(20);
      tdr.setFont(new Font("Arial", Font.BOLD, 24));
      tbd = new JTextField(20);
      tbd.setFont(new Font("Arial", Font.BOLD, 24));
         tbc = new JTextField(20);
      tbc.setFont(new Font("Arial", Font.BOLD, 24));

      // // f6=new JFrame();f6.setLayout(null);f6.setSize(500,
      // // 800);f6.setLocationRelativeTo(null);
      // // f7=new JFrame();f7.setLayout(null);f7.setSize(500,
      // // 800);f7.setLocationRelativeTo(null);
      // // f8=new JFrame();f8.setLayout(null);f8.setSize(500,
      // // 800);f8.setLocationRelativeTo(null);
      // Msearch.addActionListener(this);
      p1 = new JPanel();
      p2 = new JPanel();
      p3 = new JPanel();
      p4 = new JPanel();
      p1.setBackground(Color.black);
      // p2.setBackground(Color.LIGHT_GRAY);
      // p3.setBackground(Color.red);
      if (c == 1) {
        AddBook();
      }
      if (c == 2) {
        EditBook();
      }
      if (c == 3) {
        DeleteBook();
      }
      if (c == 4) {
        BooksList();
      }

      // p1.setBounds(0, 0, 1500,100); f6.add(p1);
    }catch(Exception e){}
    }

    public void AddBook() {
      // f2.setEnabled(false);
      p2.setLayout(new FlowLayout(FlowLayout.LEFT,10,1));
      p3.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
      p4.setLayout(new FlowLayout(FlowLayout.CENTER,60,0));
      p1.setLayout(new FlowLayout());
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Add Member</font></pre></html>"));
      selpic.addActionListener(this);
      // Ma = new JButton("Add New Member");
      // Ma.addActionListener(this);
      // Ma.setFont(new Font("Arial", Font.BOLD, 30));
      p2.add(Bid);
      p2.add(tid);
      p2.add(Bname);
      p2.add(tn);
      p2.add(Bauthor);
      p2.add(ta);
      // p2.add(selaut);
      p2.add(Bgenre);
      p2.add(tg);
      p2.add(Bquantity);
      p2.add(tq);
      p2.add(Bpublisher);
      p2.add(tp);
      p2.add(Bprice);
      p2.add(tpr);
      p2.add(Date_Rece);
      p2.add(tdr);

      p3.add(Book_Desc);
      p3.add(tbd);
      p3.add(Book_Cover);
      p3.add(tbc);
     p3.add(selpic);
      p3.add(Book_img);
      
      
      p4.add(clear);
      p4.add(Ba);
      p4.add(cancel);

      // f5.setSize(500, 800);
      // f5.setLocationRelativeTo(null);
      
      p1.setBounds(0, 0, 1500, 100);
      p2.setBounds(0, 100, 450, 700);
      p3.setBounds(751, 100, 600, 700);
      // Book_img.setBounds(751, 400, 700, 400);
      p4.setBounds(0, 850, 1500, 60);
      // p2.setLayout(new FlowLayout(FlowLayout.LEFT));
      //
      // p3.add(Ma);
      // p3.setBounds(0, 700, 500, 100);
      f6.add(p1);
      f6.add(p2);
      f6.add(p3);
      f6.add(p4);
      // f5.add(p2);
      // f5.add(p3);

    }

    public void EditBook() {

      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Edit Member</font></pre></html>"));
      // Me = new JButton("Edit Member Info");
      // Me.setFont(new Font("Arial", Font.BOLD, 30));
      // Me.addActionListener(this);
      // p2.add(mid);
      // p2.add(tid);
      // p2.add(Msearch);
      // p2.add(mfn);
      // p2.add(tfn);
      // p2.add(mln);
      // p2.add(tln);
      // p2.add(mpn);
      // p2.add(tp);
      // p2.add(me);
      // p2.add(te);
      // p2.add(mg);
      // p2.add(cbg);
      // p2.add(p3);

      // // f5.setSize(500, 800);
      // // f5.setLocationRelativeTo(null);
      p1.setBounds(0, 0, 1500, 100);
      // p2.setBounds(0, 101, 500, 600);
      // p2.setLayout(new FlowLayout(FlowLayout.LEFT));
      // p3.setLayout(new FlowLayout());
      // p3.add(Me);
      // p3.setBounds(0, 700, 500, 100);
      f6.add(p1);
      // f5.add(p2);
      // f5.add(p3);
    }

    public void DeleteBook() {
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Delete Member</font></pre></html>"));
      // Md = new JButton("Delete Member ");
      // Md.setFont(new Font("Arial", Font.BOLD, 30));
      // Md.addActionListener(this);
      // p2.add(mid);
      // p2.add(tid);
      // p2.add(Msearch);
      // p2.add(l3);
      // f5.setSize(500, 400);
      // f5.setLocationRelativeTo(null);
      p1.setBounds(0, 0, 1500, 100);
      // p2.setBounds(0, 100, 500, 200);
      // p2.setLayout(new FlowLayout(FlowLayout.LEFT));
      // p3.setLayout(new FlowLayout());
      // p3.add(Md);
      // p3.setBounds(0, 300, 500, 100);
      f6.add(p1);
      // f5.add(p2);
      // f5.add(p3);
    }

    public void BooksList() {
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>List of Members</font></pre></html>"));
      // p2.add(mid);
      // p2.add(tid);
      // p2.add(Msearch);
      // Msearch.addActionListener(this);

      // fulname = new JLabel("");
      // fulname.setFont(new Font("Arial", Font.BOLD, 20));
      // mpn.setFont(new Font("Arial", Font.BOLD, 20));
      // me.setFont(new Font("Arial", Font.BOLD, 20));
      // gender = new JLabel("");
      // gender.setFont(new Font("Arial", Font.BOLD, 20));

      // f5.setSize(1400, 900);
      // f5.setLocationRelativeTo(null);
      p1.setBounds(0, 0, 1500, 100);
      // p2.setBounds(0, 100, 1400, 80);
      // p2.setLayout(new FlowLayout());
      // p3.setLayout(new GridLayout(5, 0, 0, 0));
      // p3.add(new JLabel("<html><pre><font face='Verdana' size='20' color=black>
      // Member Details</font></pre></html>"));
      // p3.add(fulname);
      // mpn.setText("");
      // p3.add(mpn);
      // me.setText("");
      // p3.add(me);
      // p3.add(gender);
      // p3.setBounds(1000, 180, 400, 200);
      // p4.setLayout(null);
      // p4.setBounds(0, 180, 1000, 800);
      // f5.add(p4);
      f6.add(p1);
      // f5.add(p2);
      // f5.add(p3);

      // loadTableData();
    }

    // public void loadTableData() {
    // try {
    // myConn = DB.getConnection();
    // // DriverManager.getConnection(jdbcUrl, username, password);
    // // Execute a SQL query to retrieve data (replace with your query)
    // String sql = "SELECT * FROM Members";
    // mystem = myConn.createStatement();
    // myRs = mystem.executeQuery(sql);
    // DefaultTableModel tableModel = new DefaultTableModel();

    // // Add columns to the table model (replace with your column names)
    // tableModel.addColumn("ID");
    // tableModel.addColumn("First_Name");
    // tableModel.addColumn("Last_Name");
    // tableModel.addColumn("Phone_No");
    // tableModel.addColumn("Email");
    // tableModel.addColumn("Gender");

    // // Populate the table model with data from the result set
    // while (myRs.next()) {

    // Object[] rowData = {
    // myRs.getString("ID"),
    // myRs.getString("First_Name"),
    // myRs.getString("Last_Name"),
    // myRs.getString("Phone_No"),
    // myRs.getString("Email"),
    // myRs.getString("Gender")

    // };
    // id = myRs.getString("ID");
    // // System.out.println(id);

    // tableModel.addRow(rowData);

    // // Authors.setText(Integer.toString(Integer.parseInt(Authors.getText())+1));
    // }

    // JTable table = new JTable(tableModel);
    // // table.getTableHeader().setReorderingAllowed(false);
    // // table.setEnabled(false);
    // // Add a ListSelectionListener to detect row selection changes
    // table.getSelectionModel().addListSelectionListener(new
    // ListSelectionListener() {
    // @Override
    // public void valueChanged(ListSelectionEvent e) {
    // int selectedRow = table.getSelectedRow();

    // if (selectedRow >= 0) {
    // // Retrieve data from the selected row

    // Object fnameValue = tableModel.getValueAt(selectedRow, 1);
    // Object lnameValue = tableModel.getValueAt(selectedRow, 2);
    // Object phoneValue = tableModel.getValueAt(selectedRow, 3);
    // Object emailValue = tableModel.getValueAt(selectedRow, 4);
    // Object genderValue = tableModel.getValueAt(selectedRow, 5);

    // // Display the data in the text fields
    // fulname.setText(fnameValue.toString() + " " + lnameValue.toString());
    // mpn.setText(phoneValue.toString());
    // me.setText(emailValue.toString());
    // gender.setText(genderValue.toString());
    // }
    // }
    // });

    // int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
    // int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
    // // Create a JScrollPane to display the table
    // JScrollPane jsp = new JScrollPane(table, v, h);

    // // p4.add(Atable);
    // jsp.setBounds(0, 0, 1000, 800);

    // p4.add(jsp);
    // // f4.setSize(800, 800);
    // // f4.setLocationRelativeTo(null

    // // f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // // f4.setVisible(false);

    // } catch (Exception e) {
    // System.out.println(e);
    // }
    // }

    // public void MSearch(String id) {
    // try {
    // // Establish a database connection
    // myConn = DB.getConnection();

    // // Create a SQL query with a parameter placeholder
    // String sql = "SELECT * FROM project.members WHERE `ID`= ?";

    // // Create a PreparedStatement with the query
    // PreparedStatement preparedStatement = myConn.prepareStatement(sql);

    // // Set the parameter value using the provided 'id'
    // preparedStatement.setString(1, id);

    // // Execute the query
    // myRs = preparedStatement.executeQuery();
    // // int flag = 0;
    // // Process the result set
    // while (myRs.next()) {
    // did = myRs.getString("ID");
    // dfn = myRs.getString("First_Name");
    // dln = myRs.getString("Last_Name");
    // dphone = myRs.getString("Phone_No");
    // demail = myRs.getString("Email");
    // dgen = myRs.getString("Gender");
    // // flag++;
    // // System.out.println(flag);
    // tfn.setEnabled(true);
    // tln.setEnabled(true);
    // tp.setEnabled(true);
    // te.setEnabled(true);
    // cbg.setEnabled(true);

    // l3.setText("Member found ");

    // fulname.setText("<html><pre> "+dfn+" "+dln+"</pre></html>");
    // mpn.setText("<html><pre> "+dphone+"</pre></html>");
    // me.setText("<html><pre> "+demail+"</pre></html>");
    // gender.setText("<html><pre> "+dgen+"</pre></html>");

    // }
    // // if (flag == 0) {

    // // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // }

    // }
 public void setimg(String img){
  
     
 }
    public void actionPerformed(ActionEvent e) {
      try {
        if(e.getSource()==selpic){
               imgPath=tbc.getText();
                 imgUrl=new URL(imgPath);
      image= ImageIO.read(imgUrl);
               i=new ImageIcon(image);
              Book_img.setIcon(i);
            Book_img.repaint();
        //  Book_img.setBounds(751, 400, 700, 400);
        // f6.add(Book_img);
          tbc.setText("");
        }
      // myConn = DB.getConnection();
      // if (e.getSource() == Ba) {
      // // Perform an INSERT operation
      // // loadTableData();
      // // Create a prepared statement to safely insert data
      // String sql = "INSERT INTO `project`.`books`(`bid`, `Name`,`Author`, `Genre`, `Quantity`, `Publisher`,`Price`,`Date_R`,`Book_Desc`,`Book_Cover`) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?)";
      // PreparedStatement preparedStatement = myConn.prepareStatement(sql);

      // // Set the parameters using the values from your text fields
      // // int id1 = Integer.parseInt(id);
      // // id1 = id1 + 1;
      // String idValue = tid.getText().trim().isEmpty() ? null : tid.getText(); // Replace with your logic for
      // // generating the ID
      // String fnameValue = tfn.getText().trim().isEmpty() ? null : tfn.getText();
      // String lnameValue = tln.getText().trim().isEmpty() ? null : tln.getText();
      // String pnumValue = tp .getText().trim().isEmpty() ? null : tp.getText();
      // String emailValue = te .getText().trim().isEmpty() ? null : te.getText();
      // // String genderValue=tg.getText().trim().isEmpty() ? dgen : tg.getText();
      // String genderValue;
      // Object selectedItem = cbg.getSelectedItem();

      // if (selectedItem == null || selectedItem.toString().isEmpty()) {
      // genderValue = dgen; // Assign the default value
      // } else {
      // genderValue = selectedItem.toString(); // Assign the selected item as a
      // string
      // }

      // preparedStatement.setString(1, idValue);
      // preparedStatement.setString(2, fnameValue);
      // preparedStatement.setString(3, lnameValue);
      // preparedStatement.setString(4, pnumValue);
      // preparedStatement.setString(5, emailValue);
      // preparedStatement.setString(6, genderValue);

      // int rowsAffected = preparedStatement.executeUpdate();

      // if (rowsAffected > 0) {
      // MsgBox m=new MsgBox();
      // messageLabel.setText("Member added successfuly");
      // msgFrame.setVisible(true);
      // System.out.println("Insert successful.");
      // TableCount[1]++;
      // Members.setText("<html><br></br><br></br><br></br><br></br><pre><font
      // face='Arial' size='50' color=white>"
      // + Integer.toString(TableCount[1]) + "</font></pre></html>");
      // // You may want to update your table or UI here if needed.
      // } else {
      // MsgBox m=new MsgBox();
      // messageLabel.setText("Member is not added successfuly");
      // msgFrame.setVisible(true);
      // System.out.println("Insert failed.");
      // }

      // // Refresh the table with updated data
      // // loadTableData();

      // // Clear the text fields
      // tid.setText(""); // Assuming tid is a JTextField
      // tfn.setText("");
      // tln.setText("");
      // tp.setText("");
      // te.setText("");
      // // tg.setText("");

      // }

      // if (e.getSource() == Me) {
      // // Perform an UPDATE operation

      // // Create a prepared statement to safely update data
      // String sql = "UPDATE `project`.`members` SET `First_Name`=?, `Last_Name`=?,
      // `Phone_No`=?, `Email`=?, `Gender`=? WHERE `ID`=?";
      // PreparedStatement preparedStatement = myConn.prepareStatement(sql);

      // // Msearch.addActionListener(new ActionListener() {
      // // @Override
      // // public void actionPerformed(ActionEvent e) {
      // // Set the JFrame's visibility to false when the button is clicked
      // // MSearch(tid.getText());
      // // }
      // // });

      // // Set the parameters using the values from your text fields
      // String idValue = tid.getText(); // Assuming tid is a JTextField
      // String fnameValue = tfn.getText().trim().isEmpty() ? dfn : tfn.getText();
      // String lnameValue = tln.getText().trim().isEmpty() ? dln : tln.getText();
      // String pnumValue = tp.getText().trim().isEmpty() ? dphone : tp.getText();
      // String emailValue = te.getText().trim().isEmpty() ? demail : te.getText();
      // // String genderValue=tg.getText().trim().isEmpty() ? dgen : tg.getText();

      // String genderValue;
      // Object selectedItem = cbg.getSelectedItem();
      // if (selectedItem == null || selectedItem.toString().isEmpty()) {
      // genderValue = dgen; // Assign the default value
      // } else {
      // genderValue = selectedItem.toString(); // Assign the selected item as a
      // string
      // }

      // preparedStatement.setString(1, fnameValue);
      // preparedStatement.setString(2, lnameValue);
      // preparedStatement.setString(3, pnumValue);
      // preparedStatement.setString(4, emailValue);
      // preparedStatement.setString(5, genderValue);
      // preparedStatement.setString(6, idValue); // Assuming ID is an integer

      // int rowsAffected = preparedStatement.executeUpdate();

      // if (rowsAffected > 0) {
      // MsgBox m=new MsgBox();
      // messageLabel.setText("Member details update successfuly");
      // msgFrame.setVisible(true);
      // System.out.println("Update successful.");
      // // You may want to update your table or UI here if needed.
      // } else {
      // MsgBox m=new MsgBox();
      // messageLabel.setText("Member details is not update successfuly");
      // msgFrame.setVisible(true);
      // System.out.println("Update failed.");
      // }

      // // Refresh the table with updated data
      // // loadTableData();

      // // Clear the text fields
      // tid.setText(""); // Assuming tid is a JTextField
      // tfn.setText("");
      // tln.setText("");
      // tp.setText("");
      // te.setText("");
      // }

      // if (e.getSource() == Md) {
      // // Perform a DELETE operation

      // // Create a prepared statement to safely delete data
      // String sql = "DELETE FROM `project`.`members` WHERE `ID`=?";
      // PreparedStatement preparedStatement = myConn.prepareStatement(sql);

      // // Set the parameter using the ID value (assuming ID is an integer)
      // String idValue = tid.getText(); // Assuming tid is a JTextField
      // preparedStatement.setInt(1, Integer.parseInt(idValue));

      // int rowsAffected = preparedStatement.executeUpdate();

      // if (rowsAffected > 0) {
      // MsgBox m=new MsgBox();
      // messageLabel.setText("Member deleted successfuly");
      // msgFrame.setVisible(true);
      // TableCount[1]--;
      // Members.setText("<html><br></br><br></br><br></br><br></br><pre><font
      // face='Arial' size='50' color=white>"
      // + Integer.toString(TableCount[1]) + "</font></pre></html>");
      // l3.setText("Member deleted");
      // System.out.println("Delete successful.");
      // // You may want to update your table or UI here if needed.
      // } else {
      // MsgBox m=new MsgBox();
      // messageLabel.setText("Member is not deleted successfuly");
      // msgFrame.setVisible(true);
      // System.out.println("Delete failed.");
      // }

      // // Refresh the table with updated data
      // // loadTableData();

      // // Clear the text fields

      // }

      // if(e.getSource()==Msearch){
      // MSearch(tid.getText());
      // }

      } catch (Exception ex) {
      ex.printStackTrace();
      }
    }

  }

  public class MsgBox {
    public MsgBox() {
      msgFrame = new JFrame();
      msgFrame.addWindowListener(f3WindowListener);

      msgFrame.setTitle("Message Box");
      msgFrame.setSize(400, 200);
      // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      msgFrame.setLocationRelativeTo(null);

      message = "This is your message."; // Set your desired message here
      messageLabel = new JLabel("<html><pre>        " + message + "</pre></html>");
      messageLabel.setFont(new Font("Arial", Font.BOLD, 18));

      okButton = new JButton("OK");
      okButton.setFont(new Font("Arial", Font.BOLD, 18));
      okButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Set the JFrame's visibility to false when the button is clicked
          msgFrame.setVisible(false);
        }
      });
      msgFrame.setLayout(new BorderLayout());
      msgFrame.add(messageLabel, BorderLayout.CENTER);
      msgFrame.add(okButton, BorderLayout.SOUTH);
      // msgFrame.setVisible(false);

    }
  }

  WindowListener f3WindowListener = new WindowAdapter() {
    @Override
    public void windowOpened(WindowEvent e) {
      if (e.getSource() == f3) {
        lg.setEnabled(false);
        // msgopen=false;
      }
      if (e.getSource() == f4) {
        la.setEnabled(false);
      }

      if (e.getSource() == f5) {
        (lm1).setEnabled(false);
        (lm2).setEnabled(false);
        (lm3).setEnabled(false);
        (lm4).setEnabled(false);
      }
      if (e.getSource() == f6) {
        (lb1).setEnabled(false);
        (lb2).setEnabled(false);
        (lb3).setEnabled(false);
        (lb4).setEnabled(false);
      }
      // if(e.getSource()==msgFrame){
      // f3.setEnabled(true);
      // msgopen=false;
      // }
    }

    @Override
    public void windowClosing(WindowEvent e) {
      if (e.getSource() == f3) {
        lg.setEnabled(true);
      }
      if (e.getSource() == f4) {
        (la).setEnabled(true);
      }
      if (e.getSource() == f5) {
        (lm1).setEnabled(true);
        (lm2).setEnabled(true);
        (lm3).setEnabled(true);
        (lm4).setEnabled(true);
      }
      if (e.getSource() == f6) {
        (lb1).setEnabled(true);
        (lb2).setEnabled(true);
        (lb3).setEnabled(true);
        (lb4).setEnabled(true);
      }
    }
    // @Override
    // public void windowClosed(WindowEvent e) {
    // if(e.getSource()==f3){
    // lg.setEnabled(true);
    // fopen1 = false;
    // }
    // if(e.getSource()==f4){fopen2=false;}

    // if(e.getSource()==f5){fopen3=false;}
    // if(e.getSource()==msgFrame){
    // f3.setEnabled(true);
    // msgopen=false;
    // }

    // }
    // @Override
    // public void windowIconified(WindowEvent e) {
    // }
    // @Override
    // public void windowDeiconified(WindowEvent e) {
    // }
    // @Override
    // public void windowActivated(WindowEvent e) {

    // }
    // @Override
    // public void windowDeactivated(WindowEvent e) {
    // // if(e.getSource()==f3){
    // // lg.setEnabled(true);

    // // }
    // }
  };

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == li) {
      Home();
      // if (t1.getText().equals("") || t2.getText().equals("")) {
      // l3.setText("TextField can't be empty");
      // } else if (t1.getText().equals(un) && t2.getText().equals(ps)) {
      f1.setVisible(false);
      f2.setVisible(true);

      // l3.setText("Login successful");
      // } else {
      // l3.setText("Username or Password is incorrect");
      // }
    }
    if (e.getSource() == lo) {
      f2.setVisible(false);
      f5.setVisible(false);
      f1.setVisible(true);
      t1.setText("");
      t2.setText("");
      l3.setText("");
    }
    if (e.getSource() == lg) {
      // if (fopen1 == false) {

      ManageGenres mg = new ManageGenres();
      f3.setVisible(true);
      // fopen1 = true;
      // } else {

      // f3.setVisible(false);
      // fopen1 = false;
      // }
    }
    if (e.getSource() == la) {
      // if (fopen2 == false) {
      ManageAuthors ma = new ManageAuthors(2);
      f4.setVisible(true);
      // fopen2 = true;
      // } else {
      // f4.setVisible(false);
      // fopen2 = false;
      // }
    }
    if (e.getSource() == lm1) {
      // if (fopen3 == false) {
      ManageMembers mm = new ManageMembers(1);
      f5.setVisible(true);
      // fopen3 = true;
      // } else {
      // f5.setVisible(false);
      // fopen3 = false;
      // }

    }
    if (e.getSource() == lm2) {
      // if (fopen3 == false) {
      ManageMembers mm2 = new ManageMembers(2);
      mm2.tfn.setEnabled(false);
      mm2.tln.setEnabled(false);
      mm2.tp.setEnabled(false);
      mm2.te.setEnabled(false);
      mm2.cbg.setEnabled(false);
      f5.setVisible(true);
      // fopen3 = true;
      // } else {
      // f5.setVisible(false);
      // fopen3 = false;
      // }
    }
    if (e.getSource() == lm3) {
      // if (fopen3 == false) {
      ManageMembers mm3 = new ManageMembers(3);
      f5.setVisible(true);
      // fopen3 = true;
      // } else {
      // f5.setVisible(false);
      // fopen3 = false;
      // }
    }
    if (e.getSource() == lm4) {
      // if (fopen3 == false) {
      ManageMembers mm4 = new ManageMembers(4);
      f5.setVisible(true);
      // fopen3 = true;
      // } else {
      // f5.setVisible(false);
      // fopen3 = false;
      // }
    }
    if (e.getSource() == lb1) {
      // if (fopen3 == false) {
      ManageBooks mb1 = new ManageBooks(1);
      f6.setVisible(true);
      // fopen3 = true;
      // } else {
      // f5.setVisible(false);
      // fopen3 = false;
      // }
    }
    if (e.getSource() == lb2) {
      // if (fopen3 == false) {
      ManageBooks mb2 = new ManageBooks(2);
      f6.setVisible(true);
      // fopen3 = true;
      // } else {
      // f5.setVisible(false);
      // fopen3 = false;
      // }
    }
    if (e.getSource() == lb3) {
      // if (fopen3 == false) {
      ManageBooks mb3 = new ManageBooks(3);
      f6.setVisible(true);
      // fopen3 = true;
      // } else {
      // f5.setVisible(false);
      // fopen3 = false;
      // }
    }
    if (e.getSource() == lb4) {
      // if (fopen3 == false) {
      ManageBooks mb4 = new ManageBooks(4);
      f6.setVisible(true);
      // fopen3 = true;
      // } else {
      // f5.setVisible(false);
      // fopen3 = false;
      // }
    }

    if (e.getSource() == okButton) {
      // if (msgopen == true)
      // {
      msgFrame.setVisible(false);
      // msgopen = false;
      // }
    }

  }

  public static void main(String[] args) {

    AJPro l = new AJPro();

    // l.Login();
  }
}
