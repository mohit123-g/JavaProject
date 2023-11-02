
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.*;
// import java.security.PublicKey;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.DefaultTableModel;
import MY_Classes.DB;

// import javafx.scene.layout.Border;

import java.sql.*;
// import java.util.Stack;

public class AJPro implements ActionListener {
  public JFrame f1, f2, f3, f4, f5, f6, f7, f8, f9, msgFrame;
  // public Frame msgFrame;
  JButton li, lo, signup, okButton, muser;
  JCheckBox showpass;

  JButton lg, la, lm1, lm2, lm3, lm4, lb1, lb2, lb3, lb4, lc1, lc2;
 boolean flagS=false;
  int TableCount[] = { 0, 0, 0 };
  JLabel l3, books, Members, Authors, messageLabel,pnumLabel;
  public String Bname1, Mname1, bavl;
  String Tables[] = { "Books", "Members", "Authors" };
  JComboBox Acb, Gcb;
  public String un[], ps[], sql = "", message;
  public TextField t1, t2;
  Connection myConn;
  Statement mystem;
  ResultSet myRs, myRs1;
 

  AJPro() {

    try {

      Acb = new JComboBox();
      Acb.setFont(new Font("Arial", Font.BOLD, 24));

      Gcb = new JComboBox();
      Gcb.setFont(new Font("Arial", Font.BOLD, 24));

      for (int i = 0; i < 3; i++) {          //for counting
        myConn = DB.getConnection();
        String sql2 = "SELECT COUNT(*) FROM project." + Tables[i];
        PreparedStatement preparedStatement2 = myConn.prepareStatement(sql2);
        myRs = preparedStatement2.executeQuery();
        if (myRs.next()) {
          TableCount[i] = myRs.getInt(1);
          System.out.println("Row count for table is: " + TableCount[i]);
        }
      }
      int i = 0;
      myConn = DB.getConnection();
//for geting how may Genres and Author
      sql = "SELECT Name FROM genres";
      mystem = myConn.createStatement();
      myRs = mystem.executeQuery(sql);
      while (myRs.next()) {
        Gcb.addItem(myRs.getString("Name"));
      }
      myConn = DB.getConnection();

      sql = "SELECT First_Name,Last_Name FROM authors";
      mystem = myConn.createStatement();
      myRs1 = mystem.executeQuery(sql);
      while (myRs1.next()) {
        // AuthorsList[i]=myRs1.getString("First_Name")+myRs1.getString("Last_Name");
        Acb.addItem(myRs1.getString("First_Name") + " " + myRs1.getString("Last_Name"));
      }


    } catch (Exception e) {
      System.out.println(e);
    }
    Login();
  }

  public void Login() {
   
    try {
      myConn = DB.getConnection();

      sql = "SELECT * FROM admin";//for geting users or admin
      mystem = myConn.createStatement();
      myRs1 = mystem.executeQuery(sql);
      un = new String[100];
      ps = new String[100];
      int i2 = 0;
      while (myRs1.next()) {
        un[i2] = myRs1.getString("username");
        ps[i2] = myRs1.getString("password");
        // System.out.println(un[i2]);
        // System.out.println(ps[i2]);
        i2++;
      }
    } catch (Exception ex) {
    }
       //login frame design start
    f1 = new JFrame("Login");
    f1.setLayout(new GridBagLayout());
    showpass=new JCheckBox("show password",false);
    
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
    t2.setEchoChar('*');
    li = new JButton("Login");
    li.setFont(new Font("Arial", Font.BOLD, 25));
    signup = new JButton("Sign up");
    signup.setFont(new Font("Arial", Font.BOLD, 25));

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

    
    //for how or hide password
     showpass.addItemListener(new ItemListener() {

        public void itemStateChanged(ItemEvent e) {
          if(flagS==false){
          t2.setEchoChar((char)0);
           flagS=true;
        }
          else if(flagS==true){
            t2.setEchoChar('*');
            flagS=false;
          }

        }
      });
          gc.gridx = 1;
    gc.gridy = 2;
    f1.add(showpass, gc);

    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(li);
    p1.add(signup);
    gc.gridx = 1;
    gc.gridy = 3;
    f1.add(p1, gc);

    gc.gridx = 0;
    gc.gridy = 4;
    gc.gridwidth = 2;
    f1.add(l3, gc);

    li.addActionListener(this);//for sign in
    signup.addActionListener(this);//for open sign up

    f1.setSize(500, 300);
    //frame will appear in center of dispaly
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
    //this
    lg.addActionListener(this);//for open genra frame
    la.addActionListener(this);//for open author frame
    lm1.addActionListener(this);    //for open add member frame
    lm2.addActionListener(this);  //for open edit memeber frame
    lm3.addActionListener(this); //for open delet memeber frame
    lm4.addActionListener(this);//for open list of member frame
    lb2.addActionListener(this);    //for open add book frame
    lb3.addActionListener(this);  //for open edit  book frame
    lb1.addActionListener(this); //for open delet  book frame
    lb4.addActionListener(this);//for open list of bookframe
    lc1.addActionListener(this);//for open genra frame
    lc2.addActionListener(this);//for open genra frame
 //all are dashbord buttons

    ImageIcon i = new ImageIcon("logo.png");
    JLabel logo = new JLabel(i);
    logo.setBounds(0, 0, 400, 200);
    JPanel panel = new JPanel();//dashbord panel
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

    lo = new JButton("Logout");
    lo.setBounds(1800, 0, 100, 50);
    lo.addActionListener(this);//for log out
    
    muser = new JButton("Manage User");
    muser.setBounds(1600, 0, 200, 50);
    muser.addActionListener(this);//for open manage user frame
    f2.add(panel);
    f2.add(lo);
    f2.add(muser);

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

    //this 
    books = new JLabel(
        "<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
            + Integer.toString(TableCount[0]) + "</font></pre></html>");
    Members = new JLabel(
        "<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
            + Integer.toString(TableCount[1]) + "</font></pre></html>");
    Authors = new JLabel(
        "<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
            + Integer.toString(TableCount[2]) + "</font></pre></html>");
          //are for dispaly counts

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
        jsp.setBounds(420, 101, 350, 550);

        f3.add(p1);
        f3.add(p2);
        f3.add(p3);
        f3.add(jsp);
        f3.setSize(800, 800);
        f3.setLocationRelativeTo(null);

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

          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameters using the values from your text fields
          preparedStatement.setString(1, idValue);
          preparedStatement.setString(2, nameValue);
          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {

            Gcb.addItem(nameValue);
            MsgBox m = new MsgBox();
            messageLabel.setText("Genre added successfuly");
            msgFrame.setVisible(true);

            System.out.println("Insert successful.");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Genre is not added successfuly");
            msgFrame.setVisible(true);
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
            MsgBox m = new MsgBox();
            messageLabel.setText("Genre updated successfuly");
            msgFrame.setVisible(true);
            System.out.println("Update successful.");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Genre is not updated successfuly");
            msgFrame.setVisible(true);
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
            MsgBox m = new MsgBox();
            messageLabel.setText("Genre deleted successfuly");
            msgFrame.setVisible(true);
            System.out.println("Delete successful.");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Genre is not deleted successfuly");
            msgFrame.setVisible(true);
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
      pnumLabel=new JLabel("");
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
      p2.add(pnumLabel);//dgbnf
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

      } catch (Exception e) {
        System.out.println(e);
      }
    }

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
          if(tp.getText().length()!=10){
              tp.setText(null);
              pnumLabel.setText("Phone num should be of 10 digit");
            }
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
            Acb.addItem(tfn.getText() + " " + tln.getText());
            TableCount[2]++;
            Authors.setText("<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
                + Integer.toString(TableCount[2]) + "</font></pre></html>");
            MsgBox m = new MsgBox();
            messageLabel.setText("Author added successfuly");
            pnumLabel.setText("");
            msgFrame.setVisible(true);
            System.out.println("Insert successful.");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Author is not added successfuly");
            msgFrame.setVisible(true);
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
          if(tp.getText().length()!=10){
              tp.setText(null);
              pnumLabel.setText("Phone num should be of 10 digit");
            }

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
            MsgBox m = new MsgBox();
            messageLabel.setText("Author updated successfuly");
            pnumLabel.setText("");
            msgFrame.setVisible(true);
            System.out.println("Update successful.");

            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Author is not updated successfuly");
            msgFrame.setVisible(true);
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

          preparedStatement.setInt(1, Integer.parseInt(idValue));

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            TableCount[2]--;
            Authors.setText("<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
                + Integer.toString(TableCount[2]) + "</font></pre></html>");

            MsgBox m = new MsgBox();
            messageLabel.setText("Author deleted successfuly");
            msgFrame.setVisible(true);
            System.out.println("Delete successful.");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Author is not deleted successfuly");
            msgFrame.setVisible(true);
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
      pnumLabel=new JLabel("");//fg
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
      p2.add(pnumLabel);//ghf
      
      p2.add(me);
      p2.add(te);
      p2.add(mg);
      p2.add(cbg);
      p2.add(p3);

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
      p2.add(pnumLabel);//vvb
      p2.add(me);
      p2.add(te);
      p2.add(mg);
      p2.add(cbg);
      p2.add(p3);

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
      l3.setText("");
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
      JLabel md = new JLabel(
          "<html><pre><font face='Verdana' size='20' color=black>  Member Details</font></pre></html>");

      md.setBounds(1000, 180, 400, 50);
      p3.setBounds(1000, 280, 350, 200);
      fulname.setText("-");
      fulname.setFont(new Font("Arial", Font.BOLD, 15));
      mpn.setText("-");
      mpn.setFont(new Font("Arial", Font.BOLD, 15));
      me.setText("-");
      me.setFont(new Font("Arial", Font.BOLD, 15));
      gender.setText("-");
      gender.setFont(new Font("Arial", Font.BOLD, 15));

      p3.setLayout(new GridLayout(4, 2, 0, 0));
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Name:</font></pre></html>"));
      p3.add(fulname);
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Phone_num:</font></pre></html>"));
      p3.add(mpn);
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Email:</font></pre></html>"));
      p3.add(me);
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Gender:</font></pre></html>"));
      p3.add(gender);

      p4.setLayout(null);
      p4.setBounds(0, 180, 1000, 800);
      f5.add(p4);
      f5.add(p1);
      f5.add(p2);
      f5.add(md);
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

        }

        JTable table = new JTable(tableModel);

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

      } catch (Exception e) {
        System.out.println(e);
      }
    }

    public void MSearch(String id, int flag) {
      // fulname.setText("-");
      //   mpn.setText("-");
      //   me.setText("-");
      //   gender.setText("-");
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
        l3.setText("Member not found");
        
        Mname1 ="";
        while (myRs.next()) {
           if (flag == 2) {
            System.out.println( flag);
            Mname1 = myRs.getString("First_Name") + " " + myRs.getString("Last_Name");
            
          }else if (flag == 0) {
            did = myRs.getString("ID");
            
            dfn = myRs.getString("First_Name");
            dln = myRs.getString("Last_Name");
            dphone = myRs.getString("Phone_No");
            demail = myRs.getString("Email");
            dgen = myRs.getString("Gender");
            // flag++;
            // System.out.println(flag);
            tfn.setEnabled(true);
            tfn.setText(dfn);
            tln.setEnabled(true);
            tln.setText(dln);
            tp.setEnabled(true);
            tp.setText(dphone);
            te.setEnabled(true);
            te.setText(demail);
            cbg.setEnabled(true);
            int AuCount = cbg.getItemCount();
            // Iterate through the items to find a match by name
            for (int i = 0; i < AuCount; i++) {
              Object item = cbg.getItemAt(i); // Get the item at index i
              if (item != null && item.toString().equals(dgen)) {
                cbg.setSelectedIndex(i); // Set the selected index to match the item
                break; // Exit the loop once a match is found
              }
            }
             
            l3.setText("Member found ");
            fulname.setFont(new Font("Arial", Font.BOLD, 15));
            fulname.setText(dfn + " " + dln);
            mpn.setFont(new Font("Arial", Font.BOLD, 15));
            mpn.setText(dphone);
            me.setFont(new Font("Arial", Font.BOLD, 15));
            me.setText(demail);
            gender.setFont(new Font("Arial", Font.BOLD, 15));
            gender.setText(dgen);
          }
         
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
           if(tp.getText().length()!=10){
              tp.setText(null);
              pnumLabel.setText("Phone num should be of 10 digit");
            }
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
            pnumLabel.setText("");
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

          // Set the parameters using the values from your text fields
          String idValue = tid.getText(); // Assuming tid is a JTextField
          String fnameValue = tfn.getText().trim().isEmpty() ? dfn : tfn.getText();
          String lnameValue = tln.getText().trim().isEmpty() ? dln : tln.getText();
          if(tp.getText().length()!=10){
              tp.setText(null);
              pnumLabel.setText("Phone num should be of 10 digit");
            }
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
            pnumLabel.setText("");
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
          tid.setText("");
          l3.setText("");
        }

        if (e.getSource() == Msearch) {
          MSearch(tid.getText(), 0);
        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public class ManageBooks implements ActionListener {

    public JLabel Bid, Bname, Bauthor, Bgenre, Bquantity, Bpublisher, Bprice, Date_Rece, Book_Desc, Book_Cover,
        Book_img;
    JTextField tid, tn, ta, tg, tq, tp, tpr, tdr, tbd, tbc;

    JPanel p1, p2, p3, p4;
    JButton Ba, Be, Bd, Bsearch, Bsearch1, selaut, cancel, selpic, clear;
    ImageIcon i;
    BufferedImage image;
    String imgPath = "";
    // ="C:/Users/mohit/OneDrive/Pictures/th (1).jpeg";
    // "https://upload.wikimedia.org/wikipedia/en/thumb/e/e2/IMG_Academy_Logo.svg/640px-IMG_Academy_Logo.svg.png"
    URL imgUrl;

    // String did, dfn, dln, dphone, demail, dgen;
    // int mcount;
    ManageBooks(int c) {
      try { // mcount=c;
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
        Book_Cover = new JLabel("Enter Book Cover Link only:");
        Book_Cover.setFont(new Font("Arial", Font.BOLD, 38));

        // imgUrl=new URL(imgPath);
        // image= ImageIO.read(imgUrl);
        i = new ImageIcon();
        Book_img = new JLabel();

        clear = new JButton("Clear");
        clear.setFont(new Font("Arial", Font.BOLD, 30));
        clear.addActionListener(this);
        Ba = new JButton("Add Book");
        Ba.setFont(new Font("Arial", Font.BOLD, 30));
        Be = new JButton("Edit Book");
        Be.setFont(new Font("Arial", Font.BOLD, 30));
        Bd = new JButton("Delete Book");
        Bd.setFont(new Font("Arial", Font.BOLD, 30));
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 30));
        cancel.addActionListener(this);
        selaut = new JButton("select author");
        selaut.setFont(new Font("Arial", Font.BOLD, 30));
        selpic = new JButton("Select picture");
        selpic.setFont(new Font("Arial", Font.BOLD, 30));
        Bsearch = new JButton("Search");
        Bsearch.setFont(new Font("Arial", Font.BOLD, 30));

        Bsearch1 = new JButton("Search");
        Bsearch1.setFont(new Font("Arial", Font.BOLD, 30));

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

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p1.setBackground(Color.black);

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
      } catch (Exception e) {
      }
    }

    public void AddBook() {
      // f2.setEnabled(false);
      p2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
      p3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
      p4.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
      p1.setLayout(new FlowLayout());
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Add a New Book</font></pre></html>"));
      selpic.addActionListener(this);
      Ba.addActionListener(this);

      p2.add(Bid);
      p2.add(tid);
      p2.add(Bname);
      p2.add(tn);
      p2.add(Bauthor);
      p2.add(new JLabel("<html><pre>                           </pre></html>"));

      p2.add(Acb);
      p2.add(new JLabel("<html><pre>                        </pre></html>"));
      // p2.add(selaut);
      p2.add(Bgenre);
      p2.add(new JLabel("<html><pre>                                    </pre></html>"));

      p2.add(Gcb);
      p2.add(new JLabel("<html><pre>                                </pre></html>"));
      p2.add(Bquantity);
      p2.add(tq);
      p2.add(Bpublisher);
      p2.add(tp);
      p2.add(Bprice);
      p2.add(tpr);
      p2.add(Date_Rece);
      tdr.setText("YYYY-MM-DD");
      p2.add(tdr);

      p3.add(Book_Desc);
      p3.add(tbd);
      p3.add(Book_Cover);
      p3.add(tbc);
      p3.add(selpic);
      // p3.add(Book_img);

      p4.add(clear);
      p4.add(Ba);
      p4.add(cancel);

       int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
      int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
      // Create a JScrollPane to display the table
      JScrollPane jsp = new JScrollPane(Book_img, v, h);

jsp.setBounds(751, 400, 700, 400);
      p1.setBounds(0, 0, 1500, 100);
      p2.setBounds(0, 100, 450, 700);
      p3.setBounds(751, 100, 600, 700);
      // Book_img.setBounds(751, 400, 700, 400);
      p4.setBounds(0, 850, 1500, 60);

      f6.add(p1);
      f6.add(p2);
      f6.add(jsp);
      f6.add(p3);
      f6.add(p4);

    }

    public void EditBook() {
      // f2.setEnabled(false);
      p2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
      p3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
      p4.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
      p1.setLayout(new FlowLayout());
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Edit Book Details</font></pre></html>"));
      selpic.addActionListener(this);
      Be.addActionListener(this);
      Bsearch.addActionListener(this);

      p2.add(Bid);
      tid = new JTextField(5);
      p2.add(tid);
      p2.add(Bsearch);
      p2.add(Bname);
      p2.add(tn);
      p2.add(Bauthor);
      p2.add(new JLabel("<html><pre>                           </pre></html>"));

      p2.add(Acb);
      p2.add(new JLabel("<html><pre>                        </pre></html>"));
      // p2.add(selaut);
      p2.add(Bgenre);
      p2.add(new JLabel("<html><pre>                                    </pre></html>"));

      p2.add(Gcb);
      p2.add(new JLabel("<html><pre>                                </pre></html>"));
      p2.add(Bquantity);
      p2.add(tq);
      p2.add(Bpublisher);
      p2.add(tp);
      p2.add(Bprice);
      p2.add(tpr);
      p2.add(Date_Rece);
      tdr.setText("YYYY-MM-DD");
      p2.add(tdr);

      p3.add(Book_Desc);
      p3.add(tbd);
      p3.add(Book_Cover);
      p3.add(tbc);
      p3.add(selpic);
      int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
      int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
      // Create a JScrollPane to display the table
      JScrollPane jsp = new JScrollPane(Book_img, v, h);
      // p3.add(Book_img);

      p4.add(clear);
      p4.add(Be);
      p4.add(cancel);

      p1.setBounds(0, 0, 1500, 100);
      p2.setBounds(0, 100, 450, 700);
      p3.setBounds(751, 100, 600, 400);
      jsp.setBounds(751, 400, 700, 400);
      p4.setBounds(0, 850, 1500, 60);

      f6.add(p1);
      f6.add(p2);
      f6.add(p3);
      f6.add(jsp);
      f6.add(p4);

    }

    public void DeleteBook() {
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Delete Member</font></pre></html>"));
           l3.setText("");
      Bd.addActionListener(this );
      p2.add(Bid);
      p2.add(tid);
      p2.add(Bsearch);
      Bsearch.addActionListener(this);
      p2.add(l3);
      f6.setSize(500, 400);
      f6.setLocationRelativeTo(null);
      p1.setBounds(0, 0, 1500, 100);
      p2.setBounds(0, 100, 500, 200);
      p2.setLayout(new FlowLayout(FlowLayout.LEFT));
      p3.setLayout(new FlowLayout());
      p3.add(Bd);
      p3.setBounds(0, 300, 500, 100);
      f6.add(p1);
      f6.add(p2);
      f6.add(p3);
    }

    public void BooksList() {
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>List of Books</font></pre></html>"));
      p2.add(Bid);
      p2.add(tid);
      p2.add(Bsearch1);
      Bsearch1.addActionListener(this);
      int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
      int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
      // Create a JScrollPane to display the table
      JScrollPane jsp = new JScrollPane(Book_img, v, h);
      Bid.setText("-");
      Bid.setFont(new Font("Arial", Font.BOLD, 20));
      Bname.setText("-");
      Bname.setFont(new Font("Arial", Font.BOLD, 20));
      Bauthor.setText("-");
      Bauthor.setFont(new Font("Arial", Font.BOLD, 20));
      Bgenre.setText("-");
      Bgenre.setFont(new Font("Arial", Font.BOLD, 20));
      Bquantity.setText("-");
      Bquantity.setFont(new Font("Arial", Font.BOLD, 20));
      Bpublisher.setText("-");
      Bpublisher.setFont(new Font("Arial", Font.BOLD, 20));
      Bprice.setText("-");
      Bprice.setFont(new Font("Arial", Font.BOLD, 20));
      Date_Rece.setText("-");
      Date_Rece.setFont(new Font("Arial", Font.BOLD, 20));
      p3.setLayout(new GridLayout(8, 2, 0, 0));
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Book id:</font></pre></html>"));
      p3.add(Bid);
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Name:</font></pre></html>"));
      p3.add(Bname);
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Author:</font></pre></html>"));
      p3.add(Bauthor);
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Genre:</font></pre></html>"));
      p3.add(Bgenre);
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Quantity:</font></pre></html>"));
      p3.add(Bquantity);
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Publisher:</font></pre></html>"));
      p3.add(Bpublisher);
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Price:</font></pre></html>"));
      p3.add(Bprice);
      p3.add(new JLabel("<html><pre><font face='Verdana' size='5' color=balck>Date_RCV:</font></pre></html>"));
      p3.add(Date_Rece);

      p1.setBounds(0, 0, 1500, 100);
      p2.setBounds(0, 100, 1500, 100);
      jsp.setBounds(1100, 200, 300, 300);
      p3.setBounds(1100, 500, 300, 400);

      p4.setBounds(10, 200, 1000, 780);
      f6.add(p4);
      f6.add(p1);
      f6.add(p2);
      f6.add(p3);
      f6.add(jsp);
      // f5.add(p3);

      loadTableData();
    }

    public void loadTableData() {
      // String imgLink;
      try {
        myConn = DB.getConnection();
        // DriverManager.getConnection(jdbcUrl, username, password);
        // Execute a SQL query to retrieve data (replace with your query)
        String sql = "SELECT * FROM Books";
        mystem = myConn.createStatement();
        myRs = mystem.executeQuery(sql);
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add columns to the table model (replace with your column names)
        tableModel.addColumn("BID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Author");
        tableModel.addColumn("Genre");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Publisher");
        tableModel.addColumn("Price");
        tableModel.addColumn("Date-RCV");
        tableModel.addColumn("BookC_Link");

        // Populate the table model with data from the result set
        while (myRs.next()) {

          Object[] rowData = {
              myRs.getString(1),
              myRs.getString(2),
              myRs.getString(3),
              myRs.getString(4),
              myRs.getString(5),
              myRs.getString(6),
              myRs.getString(7),
              myRs.getString(8),
              myRs.getString(10)

          };

          tableModel.addRow(rowData);

        }
        JTable table = new JTable(tableModel);
        // table.getTableHeader().setReorderingAllowed(false);
        // table.setEnabled(false);
        // Add a ListSelectionListener to detect row selection changes
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
            int selectedRow = table.getSelectedRow();
            try {
              if (selectedRow >= 0) {
                // Retrieve data from the selected row
                Object idValue = tableModel.getValueAt(selectedRow, 0);
                Object nameValue = tableModel.getValueAt(selectedRow, 1);
                Object authorValue = tableModel.getValueAt(selectedRow, 2);
                Object genreValue = tableModel.getValueAt(selectedRow, 3);
                Object quanValue = tableModel.getValueAt(selectedRow, 4);
                Object publValue = tableModel.getValueAt(selectedRow, 5);
                Object priceValue = tableModel.getValueAt(selectedRow, 6);
                Object date_rValue = tableModel.getValueAt(selectedRow, 7);
                Object bcLinkValue = tableModel.getValueAt(selectedRow, 8);

                // Display the data in the text fields

                imgPath = bcLinkValue.toString();
                imgUrl = new URL(imgPath);
                image = ImageIO.read(imgUrl);
                i = new ImageIcon(image);
                Book_img.setIcon(i);
                Book_img.repaint();

                Bid.setText(idValue.toString());
                Bname.setText(nameValue.toString());
                Bauthor.setText(authorValue.toString());
                Bgenre.setText(genreValue.toString());
                Bquantity.setText(quanValue.toString());
                Bpublisher.setText(publValue.toString());
                Bprice.setText(priceValue.toString());
                Date_Rece.setText(date_rValue.toString());

              }
            } catch (Exception ex) {
            }
          }
        });

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        // Create a JScrollPane to display the table
        JScrollPane jsp = new JScrollPane(table, v, h);
        p4.setLayout(null);
        // p4.add(Atable);
        jsp.setBounds(0, 0, 1000, 700);

        p4.add(jsp);

      } catch (Exception e) {
        System.out.println(e);
      }
    }

    public void BSearch(String id, int flag) {
      try {
        // Establish a database connection
        myConn = DB.getConnection();

        // Create a SQL query with a parameter placeholder
        String sql = "SELECT * FROM project.books WHERE `Bid`= ?";
          
        // Create a PreparedStatement with the query
        PreparedStatement preparedStatement = myConn.prepareStatement(sql);

        // Set the parameter value using the provided 'id'
        preparedStatement.setString(1, id);

        // Execute the query
        myRs = preparedStatement.executeQuery();
        // int flag = 0;
        // Process the result set
        l3.setText("Book not found");
        Bname1="";
        while (myRs.next()) {
l3.setText("Book found ");
          if (flag == 0) {
            
            tn.setText(myRs.getString(2));
            int AuCount = Acb.getItemCount();
            int GeCount = Gcb.getItemCount();
            // Iterate through the items to find a match by name
            for (int i = 0; i < AuCount; i++) {
              Object item = Acb.getItemAt(i); // Get the item at index i
              if (item != null && item.toString().equals(myRs.getString(3))) {
                Acb.setSelectedIndex(i); // Set the selected index to match the item
                break; // Exit the loop once a match is found
              }
            }
            for (int i = 0; i < GeCount; i++) {
              Object item = Gcb.getItemAt(i); // Get the item at index i
              if (item != null && item.toString().equals(myRs.getString(4))) {
                Gcb.setSelectedIndex(i); // Set the selected index to match the item
                break; // Exit the loop once a match is found
              }
            }
            tq.setText(myRs.getString(5));
            tp.setText(myRs.getString(6));
            tpr.setText(myRs.getString(7));
            tdr.setText(myRs.getString(8));
            tbd.setText(myRs.getString(9));
            tbc.setText(myRs.getString(10));
            // flag++;
            // System.out.println(flag);
            tn.setEditable(true);
            Acb.setEnabled(true);
            Gcb.setEnabled(true);
            tq.setEditable(true);
            tp.setEditable(true);
            tpr.setEditable(true);
            tdr.setEditable(true);
            tbd.setEditable(true);
            tbc.setEditable(true);
          }
          if (flag == 1) {
            imgPath = myRs.getString(10);
            imgUrl = new URL(imgPath);
            image = ImageIO.read(imgUrl);
            i = new ImageIcon(image);
            Book_img.setIcon(i);
            Book_img.repaint();

            Bid.setText(myRs.getString(1));
            Bname.setText(myRs.getString(2));
            Bauthor.setText(myRs.getString(3));
            Bgenre.setText(myRs.getString(4));
            Bquantity.setText(myRs.getString(5));
            Bpublisher.setText(myRs.getString(6));
            Bprice.setText(myRs.getString(7));
            Date_Rece.setText(myRs.getString(8));
          }
          if (flag == 2) {
            Bname1 = myRs.getString(2);
            System.out.println(Bname1);
            bavl = "yes";

          }

        }
        // if (flag == 0) {

        // }
      } catch (Exception e) {
        e.printStackTrace();
      }

    }

    public void setimg(String img) {

    }

    public void actionPerformed(ActionEvent e) {
      try {
        if (e.getSource() == selpic) {

          // imgUrl=new URL(imgPath);
          // image= ImageIO.read(imgUrl);
          imgPath = tbc.getText();
          imgUrl = new URL(imgPath);
          image = ImageIO.read(imgUrl);
          i = new ImageIcon(image);
          Book_img.setIcon(i);
          Book_img.repaint();

        }
        if (e.getSource() == clear) {
          tid.setText("");
          tn.setText("");
          tq.setText("");
          tp.setText("");
          tpr.setText("");
          tdr.setText("");
          tbd.setText("");
          tbc.setText("");
        }
        if (e.getSource() == cancel) {
          f6.dispose();
          (lb1).setEnabled(true);
          (lb2).setEnabled(true);
          (lb3).setEnabled(true);
          (lb4).setEnabled(true);
        }
        myConn = DB.getConnection();
        if (e.getSource() == Ba) {
          // Perform an INSERT operation
          // loadTableData();
          // Create a prepared statement to safely insert data
          String sql = "INSERT INTO `project`.`books`(`bid`, `Name`,`Author`, `Genre`, `Quantity`, `Publisher`,`Price`,`Date_R`,`Book_Desc`,`Book_Cover`) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?)";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameters using the values from your text fields

          String idValue = tid.getText().trim().isEmpty() ? null : tid.getText(); // Replace with your logic for
          // generating the ID
          String nameValue = tn.getText().trim().isEmpty() ? null : tn.getText();
          String authorValue = Acb.getSelectedItem().toString();
          String genteValue = Gcb.getSelectedItem().toString();
          String qualityValue = tq.getText().trim().isEmpty() ? null : tq.getText();
          String pubValue = tp.getText().trim().isEmpty() ? null : tp.getText();
          String priceValue = tpr.getText().trim().isEmpty() ? null : tpr.getText();
          String date_rValue = tdr.getText().trim().isEmpty() ? null : tdr.getText();
          String book_descValue = tbd.getText().trim().isEmpty() ? null : tbd.getText();
          String book_coverValue = tbc.getText().trim().isEmpty() ? null : tbc.getText();

          preparedStatement.setString(1, idValue);
          preparedStatement.setString(2, nameValue);
          preparedStatement.setString(3, authorValue);
          preparedStatement.setString(4, genteValue);
          preparedStatement.setString(5, qualityValue);
          preparedStatement.setString(6, pubValue);
          preparedStatement.setString(7, priceValue);
          preparedStatement.setString(8, date_rValue);
          preparedStatement.setString(9, book_descValue);
          preparedStatement.setString(10, book_coverValue);

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            MsgBox m = new MsgBox();
            messageLabel.setText("Book added successfuly");
            msgFrame.setVisible(true);
            System.out.println("Insert successful.");
            TableCount[0]++;
            books.setText("<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
                + Integer.toString(TableCount[0]) + "</font></pre></html>");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Book is not added successfuly");
            msgFrame.setVisible(true);
            System.out.println("Insert failed.");
          }

          // Refresh the table with updated data
          // loadTableData();

          // Clear the text fields
          tid.setText(""); // Assuming tid is a JTextField
          tn.setText("");
          tq.setText("");
          tp.setText("");
          tpr.setText("");
          tdr.setText("");
          tbd.setText("");
          tbc.setText("");
          Book_img.setText("");

          // tg.setText("");

        }

        if (e.getSource() == Be) {
          // Perform an UPDATE operation

          // Create a prepared statement to safely update data
          String sql = "UPDATE `project`.`books` SET `Name`=?,`Author`=?, `Genre`=?, `Quantity`=?, `Publisher`=?,`Price`=?,`Date_R`=?,`Book_Desc`=?,`Book_Cover`=? WHERE `Bid`=?";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameters using the values from your text fields
          String idValue = tid.getText().trim().isEmpty() ? null : tid.getText(); // Replace with your logic for
          // generating the ID
          String nameValue = tn.getText().trim().isEmpty() ? null : tn.getText();
          String authorValue = Acb.getSelectedItem().toString();
          String genteValue = Gcb.getSelectedItem().toString();
          String qualityValue = tq.getText().trim().isEmpty() ? null : tq.getText();
          String pubValue = tp.getText().trim().isEmpty() ? null : tp.getText();
          String priceValue = tpr.getText().trim().isEmpty() ? null : tpr.getText();
          String date_rValue = tdr.getText().trim().isEmpty() ? null : tdr.getText();
          String book_descValue = tbd.getText().trim().isEmpty() ? null : tbd.getText();
          String book_coverValue = tbc.getText().trim().isEmpty() ? null : tbc.getText();

          preparedStatement.setString(10, idValue);
          preparedStatement.setString(1, nameValue);
          preparedStatement.setString(2, authorValue);
          preparedStatement.setString(3, genteValue);
          preparedStatement.setString(4, qualityValue);
          preparedStatement.setString(5, pubValue);
          preparedStatement.setString(6, priceValue);
          preparedStatement.setString(7, date_rValue);
          preparedStatement.setString(8, book_descValue);
          preparedStatement.setString(9, book_coverValue);

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            MsgBox m = new MsgBox();
            messageLabel.setText("Book details update successfuly");
            msgFrame.setVisible(true);
            System.out.println("Update successful.");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Book details is not update successfuly");
            msgFrame.setVisible(true);
            System.out.println("Update failed.");
          }

          // Refresh the table with updated data
          // loadTableData();

          // Clear the text fields
          tid.setText(""); // Assuming tid is a JTextField
          tn.setText("");
          tq.setText("");
          tp.setText("");
          tpr.setText("");
          tdr.setText("");
          tbd.setText("");
          tbc.setText("");
        }

        if (e.getSource() == Bd) {
          // Perform a DELETE operation

          // Create a prepared statement to safely delete data
          String sql = "DELETE FROM `project`.`books` WHERE `Bid`=?";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          // Set the parameter using the ID value (assuming ID is an integer)
          String idValue = tid.getText(); // Assuming tid is a JTextField
          preparedStatement.setInt(1, Integer.parseInt(idValue));

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            MsgBox m = new MsgBox();
            messageLabel.setText("Book deleted successfuly");
            msgFrame.setVisible(true);
            TableCount[0]--;
            books.setText("<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
                + Integer.toString(TableCount[0]) + "</font></pre></html>");
            l3.setText("Member deleted");
            System.out.println("Delete successful.");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Book is not deleted successfuly");
            msgFrame.setVisible(true);
            System.out.println("Delete failed.");
          }

          // Refresh the table with updated data
          // loadTableData();

          // Clear the text fields

        }

        if (e.getSource() == Bsearch) {
          BSearch(tid.getText(), 0);
        }

        if (e.getSource() == Bsearch1) {
          BSearch(tid.getText(), 1);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

  }

  public class Book_Issue_Retuen implements ActionListener {
    JPanel p1, p2, p3, p4;
    JLabel lid,Bid, Mid, IssDate, retDate, BookAvl, Bname, Mname, BookFalg;
    JButton Issue, Cancel, Return, Sbook, Smember;
    JTextField tbid, tmid, tissueD, treturnD,tid;
    String bstate;
      String id = "0";
    Book_Issue_Retuen(int c) {

      // mcount=c;
      f7 = new JFrame();
      f7.addWindowListener(f3WindowListener);
      f7.setLayout(null);
      f7.setSize(1200, 800);
      f7.setLocationRelativeTo(null);
      Bid = new JLabel("<html><pre><font face='Arial' size='6' color=black>Enter Book ID:</font></pre></html>");
      Mid = new JLabel("<html><pre><font face='Arial' size='6' color=black>Enter Member ID:</font></pre></html>");
      IssDate = new JLabel("<html><pre><font face='Arial' size='6' color=black>Issue Date:</font></pre></html>");
      retDate = new JLabel("<html><pre><font face='Arial' size='6' color=black>Return Date:</font></pre></html>");
      BookAvl = new JLabel(
          "<html><pre><font face='Arial' size='6' color=black>Is This Book Available:</font></pre></html>");
      BookFalg = new JLabel("");
      Bname = new JLabel("Book Name");
      Mname = new JLabel("Member Name");
      lid=new JLabel("<html><pre><font face='Arial' size='6' color=black>Return/Issue id:</font></pre></html>");

      Issue = new JButton("Issue");
      Issue.setFont(new Font("Arial", Font.BOLD, 25));
      Return = new JButton("Return");
      Return.setFont(new Font("Arial", Font.BOLD, 25));
      Cancel = new JButton("Cancel");
      Cancel.setFont(new Font("Arial", Font.BOLD, 25));
      Sbook = new JButton("search book");
      Sbook.setFont(new Font("Arial", Font.BOLD, 18));
      Smember = new JButton("search member");
      Smember.setFont(new Font("Arial", Font.BOLD, 18));
      Cancel.addActionListener(this);
      tid=new JTextField(10);
       tid.setFont(new Font("Arial", Font.BOLD, 18));
      tbid = new JTextField(10);
      tbid.setFont(new Font("Arial", Font.BOLD, 18));
      tmid = new JTextField(10);
      tmid.setFont(new Font("Arial", Font.BOLD, 18));
      tissueD = new JTextField("YYYY-MM-DD", 10);
      tissueD.setFont(new Font("Arial", Font.BOLD, 18));
      treturnD = new JTextField("YYYY-MM-DD", 10);
      treturnD.setFont(new Font("Arial", Font.BOLD, 18));

      p1 = new JPanel();
      p2 = new JPanel();
      p3 = new JPanel();
      p4 = new JPanel();
      p1.setBackground(Color.black);

      if (c == 1) {
        IssueBook();
      }
      if (c == 2) {
        ReturnBook();
      }

      // p1.setBounds(0, 0, 1500,100); f6.add(p1);

    }

    public void IssueBook() {
      f7.setSize(800, 450);
      f7.setLocationRelativeTo(null);
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Issue Book</font></pre></html>"));
      p2.setLayout(new GridBagLayout());
      GridBagConstraints gc = new GridBagConstraints();
      gc.gridx = 0;
      gc.gridy = 0;
      p2.add(Bid, gc);
      gc.gridx = 1;
      gc.gridy = 0;
      p2.add(tbid, gc);
      gc.gridx = 2;
      gc.gridy = 0;
      p2.add(Sbook, gc);
      gc.gridx = 1;
      gc.gridy = 1;
      p2.add(Bname, gc);

      gc.gridx = 0;
      gc.gridy = 2;
      p2.add(Mid, gc);
      gc.gridx = 1;
      gc.gridy = 2;
      p2.add(tmid, gc);
      gc.gridx = 2;
      gc.gridy = 2;
      p2.add(Smember, gc);
      gc.gridx = 1;
      gc.gridy = 3;
      p2.add(Mname, gc);

      gc.gridx = 0;
      gc.gridy = 4;
      p2.add(BookAvl, gc);
      gc.gridx = 1;
      gc.gridy = 4;
      p2.add(BookFalg, gc);
      gc.gridx = 0;
      gc.gridy = 5;
      p2.add(IssDate, gc);
      gc.gridx = 1;
      gc.gridy = 5;
      p2.add(tissueD, gc);
      gc.gridx = 0;
      gc.gridy = 6;
      p2.add(retDate, gc);
      gc.gridx = 1;
      gc.gridy = 6;
      p2.add(treturnD, gc);
   
      p3.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
      p3.add(Issue);
      p3.add(Cancel);
      Issue.addActionListener(this);
      Sbook.addActionListener(this);
      Smember.addActionListener(this);
      p1.setBounds(0, 0, 800, 50);
      p2.setBounds(0, 50, 800, 310);
      p3.setBounds(0, 350, 800, 100);
      f7.add(p1);
      f7.add(p2);
      f7.add(p3);
    }

    public void ReturnBook() {
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Return Book</font></pre></html>"));
      tbid.setEditable(false);
      tmid.setEditable(false);
      tissueD.setEditable(false);
      treturnD.setEditable(false);
      tid.setEditable(false);
      p2.setLayout(new GridBagLayout());
      GridBagConstraints gc = new GridBagConstraints();
      gc.gridx = 0;
      gc.gridy = 0;
      p2.add(Bid, gc);
      gc.gridx = 1;
      gc.gridy = 0;
      p2.add(tbid, gc);

      gc.gridx = 1;
      gc.gridy = 1;
      p2.add(Bname, gc);

      gc.gridx = 0;
      gc.gridy = 2;
      p2.add(Mid, gc);
      gc.gridx = 1;
      gc.gridy = 2;
      p2.add(tmid, gc);

      gc.gridx = 1;
      gc.gridy = 3;
      p2.add(Mname, gc);

      gc.gridx = 0;
      gc.gridy = 5;
      p2.add(IssDate, gc);
      gc.gridx = 1;
      gc.gridy = 5;
      p2.add(tissueD, gc);
      gc.gridx = 0;
      gc.gridy = 6;
      p2.add(retDate, gc);
      gc.gridx = 1;
      gc.gridy = 6;
      p2.add(treturnD, gc);
          gc.gridx = 0;
      gc.gridy = 7;
      p2.add(lid, gc);
      gc.gridx = 1;
      gc.gridy = 7;
      p2.add(tid, gc);
      p3.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
      p3.add(Return);
      p3.add(Cancel);
      Return.addActionListener(this);

      p1.setBounds(0, 0, 1200, 100);
      p2.setBounds(-60, 130, 500, 300);
      p3.setBounds(0, 700, 500, 100);
      p4.setBounds(505, 100, 700, 700);
      f7.add(p1);
      f7.add(p2);
      f7.add(p3);
      f7.add(p4);
      loadTableData();
    }

   
    public void loadTableData() {
      // String imgLink;
      try {
        myConn = DB.getConnection();
        // DriverManager.getConnection(jdbcUrl, username, password);
        // Execute a SQL query to retrieve data (replace with your query)
        String sql = "SELECT * FROM iss_rec";
        mystem = myConn.createStatement();
        myRs = mystem.executeQuery(sql);
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add columns to the table model (replace with your column names)
       tableModel.addColumn("Return/Issue ID"); 
        tableModel.addColumn("Book ID");
        tableModel.addColumn("Member ID");
        tableModel.addColumn("State");
        tableModel.addColumn("Iss-Date");
        tableModel.addColumn("Rtn-Date");

        // Populate the table model with data from the result set
        while (myRs.next()) {

          Object[] rowData = {
            myRs.getString(1),
              myRs.getString(2),
              myRs.getString(3),
              myRs.getString(4),
              myRs.getString(5),
              myRs.getString(6),

          };
         id = myRs.getString("RIid");
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
            try {
              if (selectedRow >= 0) {
                // Retrieve data from the selected row
                Object idValue = tableModel.getValueAt(selectedRow, 0);
                Object bidValue = tableModel.getValueAt(selectedRow, 1);
                Object midValue = tableModel.getValueAt(selectedRow, 2);
                Object stateValue = tableModel.getValueAt(selectedRow, 3);
                Object issDValue = tableModel.getValueAt(selectedRow, 4);
                Object retDValue = tableModel.getValueAt(selectedRow, 5);

                // Display the data in the text fields
                 tid.setText(idValue.toString()); 
                tbid.setText(bidValue.toString());
                ManageBooks mb1 = new ManageBooks(5);
                mb1.BSearch(bidValue.toString(), 2);
                Bname.setText(Bname1);
                tmid.setText(midValue.toString());
                ManageMembers mm1 = new ManageMembers(5);
                mm1.MSearch(midValue.toString(), 2);
                Mname.setText(Mname1);
                tissueD.setText(issDValue.toString());
                treturnD.setText(retDValue.toString());

              }
            } catch (Exception ex) {
            }
          }
        });

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        // Create a JScrollPane to display the table
        JScrollPane jsp = new JScrollPane(table, v, h);
        p4.setLayout(null);
        // p4.add(Atable);
        jsp.setBounds(0, 0, 670, 700);

        p4.add(jsp);

      } catch (Exception e) {
        System.out.println(e);
      }
    }

    public void actionPerformed(ActionEvent e) {
      try {
        if (e.getSource() == Cancel) {
          f7.dispose();
          (lc1).setEnabled(true);
          (lc2).setEnabled(true);

        }
        if (e.getSource() == Sbook) {
          bavl = "No";
          ManageBooks mb1 = new ManageBooks(5);
          mb1.BSearch(tbid.getText(), 2);
         if(Bname1!="") {Bname.setText(Bname1);}
          BookFalg.setText(bavl);
        }
        if (e.getSource() == Smember) {
          ManageMembers mm0 = new ManageMembers(5);
          mm0.MSearch(tmid.getText(), 2);
          if(Mname1!=""){Mname.setText(Mname1);}
        }

        myConn = DB.getConnection();
        if (e.getSource() == Issue) {
          // Perform an INSERT operation
          loadTableData();
          // Create a prepared statement to safely insert data
          String sql = "INSERT INTO `project`.`iss_rec`(`RIid`,`bid`,`mid`,`bstate`,`bissuedate`,`breturndate`) VALUES ( ?,?,?, ?, ?, ?)";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);
             int id1 = Integer.parseInt(id);
          id1 = id1 + 1;

          bstate = "Issued";
          String idValue = Integer.toString(id1);
          String bidValue = tbid.getText().trim().isEmpty() ? null : tbid.getText();
          String midValue = tmid.getText().trim().isEmpty() ? null : tmid.getText();
          String bstateValue = bstate;
          String bissue_DValue = tissueD.getText().trim().isEmpty() ? null : tissueD.getText();
          String breturn_DValue = treturnD.getText().trim().isEmpty() ? null : treturnD.getText();
          // String genderValue=tg.getText().trim().isEmpty() ? dgen : tg.getText();

          preparedStatement.setString(1, idValue);
          preparedStatement.setString(2, bidValue);
          preparedStatement.setString(3, midValue);
          preparedStatement.setString(4, bstateValue);
          preparedStatement.setString(5, bissue_DValue);
          preparedStatement.setString(6, breturn_DValue);

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            MsgBox m = new MsgBox();
            messageLabel.setText("Book Issued successfuly");
            msgFrame.setVisible(true);
            System.out.println("Insert successful.");
            TableCount[0]++;
            books.setText("<html><br></br><br></br><br></br><br></br><pre><font face='Arial' size='50' color=white>"
                + Integer.toString(TableCount[0]) + "</font></pre></html>");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Book is not Issued successfuly");
            msgFrame.setVisible(true);
            System.out.println("Insert failed.");
          }

          // Refresh the table with updated data
          // loadTableData();

          // Clear the text fields
          tbid.setText(""); // Assuming tid is a JTextField
          tmid.setText("");
          tissueD.setText("");
          treturnD.setText("");
          Bname.setText("");
          Mname.setText("");
          BookFalg.setText("");
         
          // tg.setText("");

        }

        if (e.getSource() == Return) {
          // Perform an UPDATE operation

          // Create a prepared statement to safely update data
          String sql = "UPDATE `project`.`iss_rec` SET `bid`=?,`mid`=?,`bstate`=?,`bissuedate`=?,`breturndate`=? WHERE `RIid`=?";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);

          ;
          bstate = "Return";
          String idValue = tid.getText();
          String bidValue = tbid.getText().trim().isEmpty() ? null : tbid.getText();
          String midValue = tmid.getText().trim().isEmpty() ? null : tmid.getText();
          String bstateValue = bstate;
          String bissue_DValue = tissueD.getText().trim().isEmpty() ? null : tissueD.getText();
          String breturn_DValue = treturnD.getText().trim().isEmpty() ? null : treturnD.getText();


          preparedStatement.setString(1, bidValue);
          preparedStatement.setString(2, midValue);
          preparedStatement.setString(3, bstateValue);
          preparedStatement.setString(4, bissue_DValue);
          preparedStatement.setString(5, breturn_DValue);
          preparedStatement.setString(6, idValue);
          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            MsgBox m = new MsgBox();
            messageLabel.setText("Book return successfuly");
            msgFrame.setVisible(true);
            System.out.println("Update successful.");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("Book is not return successfuly");
            msgFrame.setVisible(true);
            System.out.println("Update failed.");
          }

          // Refresh the table with updated data
          loadTableData();

          // Clear the text fields
          tbid.setText(""); // Assuming tid is a JTextField
          tmid.setText("");
          tissueD.setText("");
          treturnD.setText("");
         Bname.setText("");
          Mname.setText("");
          BookFalg.setText("");
           f7.dispose();
        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

  }

  public class ManageUser implements ActionListener {
    JLabel id, fn, ln, usern, pass;
    String type = "user";
    public JTextField tid, tfn, tln, tun;
    TextField tpass;
    JCheckBox ctype;
    JButton Aadd, Aedit, Adelete;
    JTextArea ta;
    JPanel p1, p2, p3;
    String did, dfn, dln, dun, dpass;
    String id1 = "0";
    int acount;

    ManageUser(int i) {

      f8 = new JFrame();
      f8.addWindowListener(f3WindowListener);
      f8.setLayout(null);
      // f8.setLocationRelativeTo(null);
      id = new JLabel("<html><font size='6' color=black>ID:</font><br></br></html>");
      fn = new JLabel("<html><font size='6' color=black>First Name:</font><br></br></html>");
      ln = new JLabel("<html><font size='6' color=black>Last Name:</font><br></br></html>");
      usern = new JLabel("<html><font size='6' color=black>Username:</font><br></br></html>");
      pass = new JLabel("<html><font size='6' color=black>Passwords:</font><br></br></html>");

      tid = new JTextField(5);
      tid.setFont(new Font("Arial", Font.BOLD, 18));
      tid.setEditable(false);
      tfn = new JTextField(10);
      tfn.setFont(new Font("Arial", Font.BOLD, 18));
      tln = new JTextField(10);
      tln.setFont(new Font("Arial", Font.BOLD, 18));
      tun = new JTextField(10);
      tun.setFont(new Font("Arial", Font.BOLD, 18));
      tpass = new TextField(10);
      tpass.setFont(new Font("Arial", Font.BOLD, 18));
      //  tpass.setEchoChar("*");
      ctype = new JCheckBox("Make This User as Admin", false);

      Aadd = new JButton("<html><font size='6' color=black>Add</font></html>");
      Aedit = new JButton("<html><font size='6' color=black>Edit</font></html>");
      Adelete = new JButton("<html><font size='6' color=black>Delete</font></html>");
      Aadd.addActionListener(this);
      Aedit.addActionListener(this);
      Adelete.addActionListener(this);
      p1 = new JPanel();
      p1.setBackground(Color.black);
      p2 = new JPanel();
      p3 = new JPanel();
      if (i == 1) {
        UserManage();
      }
      if (i == 2) {
        Sign_Up();
      }
    }

    public void UserManage() {

      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Manage User</font></pre></html>"));
      p1.setBounds(0, 0, 800, 100);

      p2.setLayout(new FlowLayout(FlowLayout.LEFT));
      p2.add(id);
      p2.add(tid);
      p2.add(fn);
      p2.add(tfn);
      p2.add(ln);
      p2.add(tln);
      p2.add(usern);
      p2.add(tun);
      p2.add(pass);
      p2.add(tpass);
       tpass.setEchoChar('*'); 
     showpass=new JCheckBox("show password",false);
     
     showpass.addItemListener(new ItemListener() {

        public void itemStateChanged(ItemEvent e) {
          if(flagS==false){
          tpass.setEchoChar((char)0);
           flagS=true;
        }
          else if(flagS==true){
            tpass.setEchoChar('*');
            flagS=false;
          }

        }
      });
      p2.add(showpass);

      p2.add(ctype);
      ctype.addItemListener(new ItemListener() {

        public void itemStateChanged(ItemEvent e) {
          type = "admin";

        }
      });
      p2.setBackground(Color.CYAN);
      p2.setBounds(0, 101, 240, 550);

      p3.setLayout(new GridLayout(1, 3, 40, 40));
      p3.add(Aadd);
      p3.add(Aedit);
      p3.add(Adelete);
      p3.setBounds(0, 681, 400, 50);
      f8.add(p1);
      f8.add(p2);
      f8.add(p3);

           
      
      f8.setSize(800, 800);
      f8.setLocationRelativeTo(null);
      loadTableData();
    }

    public void Sign_Up() {
      f9 = new JFrame();
      f9.addWindowListener(f3WindowListener);
      f9.setSize(500, 800);
      f9.setLocationRelativeTo(null);
      f9.setLayout(null);
      p1.add(new JLabel("<html><pre><font face='Verdana' size='50' color=white>Register user</font></pre></html>"));
      p1.setBounds(0, 0, 500, 100);

      id.setFont(new Font("Arial", Font.BOLD, 35));
      tid.setFont(new Font("Arial", Font.BOLD, 35));
      fn.setFont(new Font("Arial", Font.BOLD, 35));
      tfn.setFont(new Font("Arial", Font.BOLD, 35));
      ln.setFont(new Font("Arial", Font.BOLD, 35));
      tln.setFont(new Font("Arial", Font.BOLD, 35));
      usern.setFont(new Font("Arial", Font.BOLD, 35));
      tun.setFont(new Font("Arial", Font.BOLD, 35));
      pass.setFont(new Font("Arial", Font.BOLD, 35));
      tpass.setFont(new Font("Arial", Font.BOLD, 35));
      ctype.setFont(new Font("Arial", Font.BOLD, 20));
      p2.setLayout(new FlowLayout(FlowLayout.LEFT));
      p2.add(id);
      p2.add(tid);
      p2.add(fn);
      p2.add(tfn);
      p2.add(ln);
      p2.add(tln);
      p2.add(usern);
      p2.add(tun);
      p2.add(pass);
      p2.add(tpass);
        tpass.setEchoChar('*'); 
     showpass=new JCheckBox("show password",false);
     
     showpass.addItemListener(new ItemListener() {

        public void itemStateChanged(ItemEvent e) {
          if(flagS==false){
          tpass.setEchoChar((char)0);
           flagS=true;
        }
          else if(flagS==true){
            tpass.setEchoChar('*');
            flagS=false;
          }

        }
      });
      p2.add(showpass);

      p2.add(ctype);
      ctype.addItemListener(new ItemListener() {

        public void itemStateChanged(ItemEvent e) {
          type = "admin";

        }
      });
      p2.setBackground(Color.CYAN);
      p2.setBounds(80, 100, 330, 600);

      p3.setLayout(new GridLayout(1, 3, 40, 40));
      p3.add(Aadd);
      Aadd.addActionListener(this);
      p3.setBounds(0, 700, 500, 60);
      f9.add(p1);
      f9.add(p2);
      f9.add(p3);
      loadTableData();
    }

    // JPanel p4=new JPanel();
    public void loadTableData() {
      try {
        myConn = DB.getConnection();
        // DriverManager.getConnection(jdbcUrl, username, password);
        // Execute a SQL query to retrieve data (replace with your query)
        String sql = "SELECT * FROM admin";
        mystem = myConn.createStatement();
        myRs = mystem.executeQuery(sql);
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add columns to the table model (replace with your column names)
        tableModel.addColumn("ID");
        tableModel.addColumn("First_Name");
        tableModel.addColumn("Last_Name");
        tableModel.addColumn("Username");
        tableModel.addColumn("Password");
        tableModel.addColumn("Type");

        // Populate the table model with data from the result set
        while (myRs.next()) {

          Object[] rowData = {
              myRs.getString(1),
              myRs.getString(2),
              myRs.getString(3),
              myRs.getString(4),
              myRs.getString(5),
              myRs.getString(6),

          };
          id1 = myRs.getString("id");
          tableModel.addRow(rowData);

          // Authors.setText(Integer.toString(Integer.parseInt(Authors.getText())+1));
        }

        // Create a JTable and set its model to the table model
        JTable table = new JTable(tableModel);
        // table.getTableHeader().setReorderingAllowed(false);
        // table.setEnabled(false);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
            int selectedRow = table.getSelectedRow();

            if (selectedRow >= 0) {
              // Retrieve data from the selected row
              Object idValue = tableModel.getValueAt(selectedRow, 0);
              Object fnameValue = tableModel.getValueAt(selectedRow, 1);
              Object lnameValue = tableModel.getValueAt(selectedRow, 2);
              Object userValue = tableModel.getValueAt(selectedRow, 3);
              Object passValue = tableModel.getValueAt(selectedRow, 4);
              Object typeValue = tableModel.getValueAt(selectedRow, 5);

              // Display the data in the text fields
              tid.setText(idValue.toString());
              tfn.setText(fnameValue.toString());
              tln.setText(lnameValue.toString());
              tun.setText(userValue.toString());
              tpass.setText(passValue.toString());
              if (typeValue.toString() == "admin") {
                ctype.setSelected(true);
              }
            }
          }
        });
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        // Create a JScrollPane to display the table
        JScrollPane jsp = new JScrollPane(table, v, h);

        // p4.add(Atable);
        jsp.setBounds(240, 101, 500, 550);
        f8.add(jsp);

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
        //
        if (e.getSource() == Aadd) {
          // Perform an INSERT operation
          // Assuming tn is a JTextField
          // ASearch("1");
          // Create a prepared statement to safely insert data
          String sql = "INSERT INTO `project`.`admin`(`id`, `First_Name`,`Last_Name`, `username`,`password`, `type`) VALUES (?, ?,?,?, ?,?)";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);
          int id2 = Integer.parseInt(id1);
          id2 = id2 + 1;
          String idValue = Integer.toString(id2); // Assuming tid is a JTextField
          String fnameValue = tfn.getText().trim().isEmpty() ? null : tfn.getText();
          String lnameValue = tln.getText().trim().isEmpty() ? null : tln.getText();
          String unValue = tun.getText().trim().isEmpty() ? null : tun.getText();
          String passValue = tpass.getText().trim().isEmpty() ? null : tpass.getText();
          String typeValue = type;
          // Set the parameters using the values from your text fields
          preparedStatement.setString(1, idValue);
          preparedStatement.setString(2, fnameValue);
          preparedStatement.setString(3, lnameValue);
          preparedStatement.setString(4, unValue);
          preparedStatement.setString(5, passValue);
          preparedStatement.setString(6, typeValue);
          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            MsgBox m = new MsgBox();
            messageLabel.setText("User or Admin added successfuly");
            msgFrame.setVisible(true);
            System.out.println("Insert successful.");
            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("User or Admin is not added successfuly");
            msgFrame.setVisible(true);
            System.out.println("Insert failed.");
          }
          loadTableData();

          // Clear the text fields
          tid.setText(""); // Assuming tid is a JTextField
          tfn.setText("");
          tln.setText("");
          tun.setText("");
          tpass.setText("");
          ctype.setSelected(false);
          f9.dispose();
          f8.dispose();
          Login();
          muser.setEnabled(true);
        }

        if (e.getSource() == Aedit) {
          // Perform an UPDATE operation
          // Replace with your UPDATE SQL statement and logic here
          // Assuming tn is a JTextField
          // ASearch(tid.getText());
          // Create a prepared statement to safely update data
          String sql = "UPDATE `project`.`admin` SET `First_Name`=?,`Last_Name`=?, `username`=?,`password`=?, `type`=? WHERE `id`=?";
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);
          // ASearch(tid.getText());

          String idValue = tid.getText().trim().isEmpty() ? null : tid.getText(); // Assuming tid is a JTextField
          String fnameValue = tfn.getText().trim().isEmpty() ? null : tfn.getText();
          String lnameValue = tln.getText().trim().isEmpty() ? null : tln.getText();
          String unValue = tun.getText().trim().isEmpty() ? null : tun.getText();
          String passValue = tpass.getText().trim().isEmpty() ? null : tpass.getText();
          String typeValue = type;

          preparedStatement.setString(1, fnameValue);
          preparedStatement.setString(2, lnameValue);
          preparedStatement.setString(3, unValue);
          preparedStatement.setString(4, passValue);
          preparedStatement.setString(5, typeValue);
          preparedStatement.setString(6, idValue);
          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            MsgBox m = new MsgBox();
            messageLabel.setText("User or Admin updated successfuly");
            msgFrame.setVisible(true);
            System.out.println("Update successful.");

            // You may want to update your table or UI here if needed.
          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("User or Admin is not updated successfuly");
            msgFrame.setVisible(true);

            System.out.println("Update failed.");
          }

          // Refresh the table with updated data

          loadTableData();

          // Clear the text fields
          tid.setText(""); // Assuming tid is a JTextField
          tfn.setText("");
          tln.setText("");
          tun.setText("");
          tpass.setText("");
          ctype.setSelected(false);
          f8.dispose();
          muser.setEnabled(true);

        }

        if (e.getSource() == Adelete) {
          // Perform a DELETE operation
          // Replace with your DELETE SQL statement and logic here

          // Create a prepared statement to safely delete data
          String sql = "DELETE FROM `project`.`admin` WHERE `id`=?";
          // DELETE FROM `project`.`genres` WHERE `ID` = 2;
          PreparedStatement preparedStatement = myConn.prepareStatement(sql);
          String idValue = tid.getText(); // Assuming tid is a JTextField
        
          preparedStatement.setInt(1, Integer.parseInt(idValue));

          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
            MsgBox m = new MsgBox();
            messageLabel.setText("User or Admin deleted successfuly");
            msgFrame.setVisible(true);
            System.out.println(" Delete successful.");
            // You may want to update your table or UI here if needed.

          } else {
            MsgBox m = new MsgBox();
            messageLabel.setText("User or Admin  is not deleted successfuly");
            msgFrame.setVisible(true);
            System.out.println("Delete failed.");
          }

          // Refresh the table with updated data

          loadTableData();
          // Clear the text fields
          tid.setText(""); // Assuming tid is a JTextField
          tfn.setText("");
          tln.setText("");
          tun.setText("");
          tpass.setText("");
          ctype.setSelected(false);
          f8.dispose();
          muser.setEnabled(true);

        }
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
      if (e.getSource() == f7) {
        (lc1).setEnabled(false);
        (lc2).setEnabled(false);
      }
      if (e.getSource() == f8) {
        muser.setEnabled(false);

      }
      if (e.getSource() == f9) {
        // f1.setVisible(false);

      }

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
      if (e.getSource() == f7) {
        (lc1).setEnabled(true);
        (lc2).setEnabled(true);
      }
      if (e.getSource() == f8) {
        muser.setEnabled(true);

      }
      if (e.getSource() == f9) {
        Login();
        f1.setVisible(true);

      }
    }

  };

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == li) {
      int flag = 0;
      Home();

      String enteredUsername = t1.getText().trim(); // Trim whitespace from input
      String enteredPassword = t2.getText().trim(); // Trim whitespace from input

      // Check if either field is empty
      if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
        flag = 2;
      } else {
        for (int i = 0; i < un.length; i++) {
          if (enteredUsername.equals(un[i]) && enteredPassword.equals(ps[i])) {
            flag = 1;

            break;
          }
        }
      }

      if (flag == 2) {
        l3.setText("Username and Password can't be empty");
      } else if (flag == 1) {
        f1.setVisible(false);
        f2.setVisible(true);
        l3.setText("Login successful");
      } else {
        l3.setText("Username or Password is incorrect");
      }
    }

    if (e.getSource() == signup) {
      ManageUser mu1 = new ManageUser(2);
      f9.setVisible(true);
    }
    if (e.getSource() == lo) {
      f2.setVisible(false);
      // f5.setVisible(false);
      f1.setVisible(true);
      t1.setText("");
      t2.setText("");
      l3.setText("");
    }
    if (e.getSource() == muser) {

      ManageUser mu = new ManageUser(1);
      f8.setVisible(true);
    }
    if (e.getSource() == lg) {

      ManageGenres mg = new ManageGenres();
      f3.setVisible(true);

    }
    if (e.getSource() == la) {

      ManageAuthors ma = new ManageAuthors(2);
      f4.setVisible(true);

    }
    if (e.getSource() == lm1) {

      ManageMembers mm = new ManageMembers(1);
      f5.setVisible(true);

    }
    if (e.getSource() == lm2) {

      ManageMembers mm2 = new ManageMembers(2);
      mm2.tfn.setEnabled(false);
      mm2.tln.setEnabled(false);
      mm2.tp.setEnabled(false);
      mm2.te.setEnabled(false);
      mm2.cbg.setEnabled(false);
      f5.setVisible(true);

    }
    if (e.getSource() == lm3) {

      ManageMembers mm3 = new ManageMembers(3);
      f5.setVisible(true);

    }
    if (e.getSource() == lm4) {

      ManageMembers mm4 = new ManageMembers(4);
      f5.setVisible(true);

    }
    if (e.getSource() == lb1) {

      ManageBooks mb1 = new ManageBooks(1);
      Acb.setEnabled(true);
      Gcb.setEnabled(true);
      f6.setVisible(true);

    }
    if (e.getSource() == lb2) {
      // if (fopen3 == false) {
      ManageBooks mb2 = new ManageBooks(2);
      mb2.tn.setEditable(false);
      Acb.setEnabled(false);
      Gcb.setEnabled(false);
      mb2.tq.setEditable(false);
      mb2.tp.setEditable(false);

      mb2.tpr.setEditable(false);
      mb2.tdr.setEditable(false);
      mb2.tbd.setEditable(false);
      mb2.tbc.setEditable(false);
      f6.setVisible(true);

    }
    if (e.getSource() == lb3) {

      ManageBooks mb3 = new ManageBooks(3);
      f6.setVisible(true);

    }
    if (e.getSource() == lb4) {

      ManageBooks mb4 = new ManageBooks(4);
      f6.setVisible(true);

    }
    if (e.getSource() == lc1) {

      Book_Issue_Retuen bir1 = new Book_Issue_Retuen(1);
      f7.setVisible(true);

    }
    if (e.getSource() == lc2) {

      Book_Issue_Retuen bir2 = new Book_Issue_Retuen(2);
      f7.setVisible(true);

    }

    if (e.getSource() == okButton) {

      msgFrame.setVisible(false);

    }

  }

  public static void main(String[] args) {

    AJPro l = new AJPro();

  }
}
