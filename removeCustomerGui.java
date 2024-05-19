import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class removeCustomerGui extends JFrame {
    private JFrame frame;

    private JLabel icon;
    private ImageIcon i;

    private JLabel customerName;
    private JLabel removeCustomer;

    private JTextField tCustomerName;
    private JTextArea tArea;

    private JButton remove;
    private JButton back;


    public removeCustomerGui() {

        ImageIcon i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(40, 60, 831, 551);

        frame = new JFrame("Bike Showroom");
        tArea = new JTextArea();

//        frame.setBackground(Color.WHITE);

        removeCustomer = new JLabel("Remove Customer");
        customerName = new JLabel("Customer Name: ");

        tCustomerName = new JTextField(20);


        customerName.setFont(new Font("Postmaster", Font.BOLD, 20));
        removeCustomer.setFont(new Font("Postmaster",Font.BOLD,30));


        customerName.setForeground(Color.DARK_GRAY);
        removeCustomer.setForeground(Color.DARK_GRAY);
        tArea.setBackground(new Color(190, 129, 255, 200));


        removeCustomer.setBounds(280,70,300,100);
        customerName.setBounds(225, 190, 200, 30);
        tCustomerName.setBounds(415, 190, 150, 30);
        tArea.setBounds(195,160,400, 150);


        remove = new JButton("Remove");
        back = new JButton("BACK");

        remove.setBounds(280, 250, 100, 30);
        back.setBounds(420, 250, 100, 30);

        remove.setBackground(Color.LIGHT_GRAY);
        back.setBackground(Color.LIGHT_GRAY);


        frame.add(removeCustomer);
        frame.add(customerName);
        frame.add(tCustomerName);
        frame.add(remove);
        frame.add(back);
        frame.add(tArea);
        frame.add(icon);


        frame.setTitle("Bike Showroom");
        frame.setSize(831, 551);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        MyActionListener a = new MyActionListener();
        remove.addActionListener(a);
        back.addActionListener(a);
    }


    class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Remove")) {
                if (tCustomerName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Customer should have name.");
                    tCustomerName.setText(null);
                }
                else {
                    boolean check = BikeOwner.RemoveBikeOwner(tCustomerName.getText());
                    if(check){
                        JOptionPane.showMessageDialog(null,"Customer Removed Successfully.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Customer Not Found.");
                    }
                    frame.dispose();
                MainMenuGUI x = new MainMenuGUI();
                }
            }
            else if(ae.getActionCommand().equalsIgnoreCase("Back")){
                frame.dispose();
                MainMenuGUI y = new MainMenuGUI();
            }
        }
    }
}
