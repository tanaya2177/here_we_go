package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    Login() {

        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40, 20, 100, 30);
        add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        add(jPasswordField);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.addActionListener(this);
        add(b2);

        setSize(400, 250);
        setLocation(500, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();

                String user = textField.getText();
                String pass = new String(jPasswordField.getPassword());

                String query = "select * from login where ID='" + user + "' and PW='" + pass + "'";
                ResultSet rs = c.statement.executeQuery(query);

                if (rs.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}