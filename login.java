import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

 class Login extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn;

    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);

        JLabel user = new JLabel("Username:");
        user.setBounds(30, 30, 80, 25);
        add(user);

        usernameField = new JTextField();
        usernameField.setBounds(120, 30, 120, 25);
        add(usernameField);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(30, 70, 80, 25);
        add(pass);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 120, 25);
        add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(90, 110, 100, 30);
        loginBtn.addActionListener(this);
        add(loginBtn);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?"
            );

            ps.setString(1, usernameField.getText());
            ps.setString(2, new String(passwordField.getPassword()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                new Quiz();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}