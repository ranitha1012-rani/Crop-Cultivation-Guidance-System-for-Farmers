package final_project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class FarmerAuth implements ActionListener {

    JFrame f;
    JTextField name, phone, email;
    JPasswordField pass;
    JButton registerBtn, loginBtn;

    // ================= REGISTER FORM =================
    public void registerForm() {

        f = new JFrame("Farmer Registration");
        f.setSize(400, 420);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 🔹 BACKGROUND IMAGE (ABSOLUTE PATH)
        JLabel bg = new JLabel(new ImageIcon(
            "C:\\Users\\N.Ranitha\\OneDrive - SONA COLLEGE OF TECHNOLOGY\\Documents\\Agrilogo.jpeg"
        ));
        bg.setBounds(0, 0, 400, 420);
        f.setContentPane(bg);
        bg.setLayout(null);


        // 🔹 TITLE
        JLabel title = new JLabel("Farmer Registration");
        title.setBounds(90, 95, 250, 25);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.BLACK);
        bg.add(title);

        // Name
        bg.add(new JLabel("Name")).setBounds(50, 140, 150, 25);
        name = new JTextField();
        name.setBounds(150, 140, 180, 25);
        bg.add(name);

        // Phone
        bg.add(new JLabel("Phone")).setBounds(50, 175, 100, 25);
        phone = new JTextField();
        phone.setBounds(150, 175, 180, 25);
        bg.add(phone);

        // Email
        bg.add(new JLabel("Email")).setBounds(50, 210, 100, 25);
        email = new JTextField();
        email.setBounds(150, 210, 180, 25);
        bg.add(email);

        // Password
        bg.add(new JLabel("Password")).setBounds(50, 245, 100, 25);
        pass = new JPasswordField();
        pass.setBounds(150, 245, 180, 25);
        bg.add(pass);

        // Register Button
        registerBtn = new JButton("Register");
        registerBtn.setBounds(140, 290, 120, 30);
        bg.add(registerBtn);
        registerBtn.addActionListener(this);

        f.setVisible(true);
    }

    // ================= LOGIN FORM =================
    public void loginForm() {

        f = new JFrame("Farmer Login");
        f.setSize(350, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 🔹 BACKGROUND IMAGE
        JLabel bg = new JLabel(new ImageIcon(
            "C:\\Users\\N.Ranitha\\OneDrive - SONA COLLEGE OF TECHNOLOGY\\Documents\\Agri.jpeg"
        ));
        bg.setBounds(0, 0, 350, 300);
        f.setContentPane(bg);
        bg.setLayout(null);

        JLabel title = new JLabel("Farmer Login");
        title.setBounds(110, 30, 200, 25);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.BLACK);
        bg.add(title);

        bg.add(new JLabel("Email")).setBounds(50, 90, 100, 25);
        email = new JTextField();
        email.setBounds(140, 90, 150, 25);
        bg.add(email);

        bg.add(new JLabel("Password")).setBounds(50, 130, 100, 25);
        pass = new JPasswordField();
        pass.setBounds(140, 130, 150, 25);
        bg.add(pass);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(120, 190, 100, 30);
        bg.add(loginBtn);
        loginBtn.addActionListener(this);

        f.setVisible(true);
    }

    // ================= BUTTON ACTION =================
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Connection con = DBConnection.getConnection();

            if (e.getActionCommand().equals("Register")) {

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO farmer(name,phone,email,password) VALUES(?,?,?,?)");

                ps.setString(1, name.getText());
                ps.setString(2, phone.getText());
                ps.setString(3, email.getText());
                ps.setString(4, pass.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(f, "Registration Successful");
                f.dispose();
                loginForm();
            }

            if (e.getActionCommand().equals("Login")) {

                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM farmer WHERE email=? AND password=?");

                ps.setString(1, email.getText());
                ps.setString(2, pass.getText());

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(f, "Login Successful");
                    f.dispose();
                    new CropAdvisoryForm();
                } else {
                    JOptionPane.showMessageDialog(f, "Invalid Login");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        new FarmerAuth().registerForm();
    }
}  