
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
import java.security.PublicKey;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import MY_Classes.DB;
import javafx.scene.layout.Border;

import java.sql.*;
import java.util.Stack;

// public class DB{

//   private String username="localhost";
// }

public class AJPro implements ActionListener {
  JFrame f1, f2, f3, f4;
  JButton li, lo;
  JButton lg, la, lm1, lm2, lm3, lm4, lb1, lb2, lb3, lb4, lc1, lc2;

  int Anum = 0, Bnum = 0, Mnum = 0;
  JLabel l3, books, Members, Authors;
  public String un = "", ps = "", sql = "";
  TextField t1, t2;
  Connection myConn;
  Statement mystem;
  ResultSet myRs, myRs1;
  String jdbcUrl = "jdbc:mysql://localhost:3306/project";
  String username = "root";
  String password = "mohit2303";
  int a = 1;

  AJPro() {

    try {
      myConn = DB.getConnection();
      // DriverManager.getConnection(jdbcUrl, username, password);
      // Execute a SQL query to retrieve data (replace with your query)
      sql = "SELECT id, username, password FROM Members";
      mystem = myConn.createStatement();
      myRs1 = mystem.executeQuery(sql);
      while (myRs1.next()) {
        un = myRs1.getString("username");
        ps = myRs1.getString("password");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
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
            + Integer.toString(Bnum) + "</font></pre></html>");
    Members = new JLabel(
        "<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
            + Integer.toString(Mnum) + "</font></pre></html>");
    Authors = new JLabel(
        "<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
            + Integer.toString(Anum) + "</font></pre></html>");

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
        String sql = "SELECT * FROM genres";
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

        if (e.getSource() == Gadd) {
          // Perform an INSERT operation
          String idValue = tid.getText(); // Assuming tid is a JTextField
          String nameValue = tn.getText(); // Assuming tn is a JTextField

          // Create a prepared statement to safely insert data
          String sql = "INSERT INTO `project`.`genres`(`ID`, `Name`) VALUES (?, ?)";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameters using the values from your text fields
          preparedStatement.setString(1, idValue);
          preparedStatement.setString(2, nameValue);
          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {

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

    ManageAuthors() {
      f4 = new JFrame();
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
              myRs.getInt("ID"),
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

    public void actionPerformed(ActionEvent e) {
      try {
        // You should have a database connection established before performing SQL
        // operations
        String idValue = tid.getText(); // Assuming tid is a JTextField
        String fnameValue = tfn.getText();
        String lnameValue = tln.getText();
        String pnumValue = tp.getText();
        String expeValue = te.getText();
        String aboValue = ta.getText(); //
        if (e.getSource() == Aadd) {
          // Perform an INSERT operation
          // Assuming tn is a JTextField

          // Create a prepared statement to safely insert data
          String sql = "INSERT INTO `project`.`authors`(`ID`, `First_Name`,`Last_Name`, `Phone_No`,`Expertise`, `About`) VALUES (?, ?,?,?, ?,?)";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameters using the values from your text fields
          preparedStatement.setString(1, idValue);
          preparedStatement.setString(2, fnameValue);
          preparedStatement.setString(3, lnameValue);
          preparedStatement.setString(4, pnumValue);
          preparedStatement.setString(5, expeValue);
          preparedStatement.setString(6, aboValue);
          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
                 Anum++;
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

          // Create a prepared statement to safely update data
          String sql = "UPDATE `project`.`authors` SET `First_Name`=?,`Last_Name`=?,`Phone_No`=?,`Expertise`,`About`=? WHERE `ID`=?";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

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
          // Assuming tid is a JTextField

          // Create a prepared statement to safely delete data
          String sql = "DELETE FROM `project`.`authors` WHERE `ID`=?";
          // DELETE FROM `project`.`genres` WHERE `ID` = 2;
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameter using the ID value (assuming ID is an integer)
          preparedStatement.setInt(1, Integer.parseInt(idValue));

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            Anum--;
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

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == li) {
      Home();
      if (t1.getText().equals("") || t2.getText().equals("")) {
      l3.setText("TextField can't be empty");
      } else if (t1.getText().equals(un) && t2.getText().equals(ps)) {
      f1.setVisible(false);
      f2.setVisible(true);
      l3.setText("Login successful");
      } else {
      l3.setText("Username or Password is incorrect");
      }
    }
    if (e.getSource() == lo) {
      f2.setVisible(false);
      f1.setVisible(true);
      t1.setText("");
      t2.setText("");
      l3.setText("");
    }
    if (e.getSource() == lg) {

      ManageGenres mg = new ManageGenres();
      f3.setVisible(true);
    }
    if (e.getSource() == la) {
      ManageAuthors ma = new ManageAuthors();
      f4.setVisible(true);
    }

  }

  public static void main(String[] args) {

    AJPro l = new AJPro();

    l.Login();
  }
}
