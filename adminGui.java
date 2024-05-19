import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminGui extends JFrame{
    private JFrame frame;

    private JLabel icon;
    private ImageIcon i;
    private JLabel bikeShowroom;
    private JLabel adminInfo;

    private JLabel userName;
    private JLabel password;


    private JTextField tUsername;
    private JPasswordField tPassword;

    private JTextArea tArea;

    private JButton login;

    public adminGui() {

        ImageIcon  i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(40,60 , 831, 551);

        frame = new JFrame("Bike Showroom");

        bikeShowroom = new JLabel("Bike Showroom");
        adminInfo = new JLabel("Admin Login");

        userName = new JLabel("Username: ");
        password = new JLabel("Password: ");

        tUsername = new JTextField(15);
        tPassword = new JPasswordField(15);

        tArea = new JTextArea();


        bikeShowroom.setFont(new Font("Postmaster",Font.BOLD,40));
        adminInfo.setFont(new Font("Postmaster",Font.BOLD,30));
        userName.setFont(new Font("Postmaster",Font.BOLD,20));
        password.setFont(new Font("Postmaster",Font.BOLD,20));
        tArea.setFont(new Font("Postmaster",Font.BOLD,20));


        bikeShowroom.setForeground(Color.DARK_GRAY);
        adminInfo.setForeground(Color.DARK_GRAY);
        userName.setForeground(Color.DARK_GRAY);
        password.setForeground(Color.DARK_GRAY);
        tArea.setBackground(new Color(159, 153, 153, 200));


        bikeShowroom.setBounds(280, 30, 600, 100);
        adminInfo.setBounds(340,120,450,50);
        userName.setBounds(300,220,150,30);
        password.setBounds(300,290,150,30);
        tArea.setBounds(265,200,345, 200);
        tUsername.setBounds(420, 220, 150, 30);
        tPassword.setBounds(420, 290, 150, 30);


        login = new JButton("Login");
        login.setBackground(Color.PINK);

        login.setBounds(373,350,100,30);


        frame.add(bikeShowroom);
        frame.add(adminInfo);
        frame.add(userName);
        frame.add(tUsername);
        frame.add(password);
        frame.add(tPassword);
        frame.add(login);
        frame.add(tArea);
        frame.add(icon);


        frame.setTitle("Bike Showroom");
        frame.setVisible(true);
        frame.setSize(831,551);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        MyActionListener a = new MyActionListener();
        login.addActionListener(a);
    }
    class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String name;
            String pass;

            if(ae.getActionCommand().equalsIgnoreCase("Login")){

                name = tUsername.getText();
                pass = tPassword.getText();

                if(!name.equalsIgnoreCase("Admin")) {
                    JOptionPane.showMessageDialog(null, "INVALID USER NAME");
                    tUsername.setText(null);
                }
                else if(!(pass.equalsIgnoreCase("123456"))) {
                    JOptionPane.showMessageDialog(null, "INVALID PASSWORD");
                    tPassword.setText(null);
                }
                else if(!(pass.equals("123456")) && !(name.equalsIgnoreCase("admin"))) {
                    JOptionPane.showMessageDialog(null, "INVALID USERNAME AND PASSWORD");
                    tUsername.setText(null);
                    tPassword.setText(null);
                }
                else {
                    frame.dispose();
                    new MainMenuGUI();
                }
            }
        }
    }
}

	
	


