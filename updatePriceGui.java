import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updatePriceGui extends JFrame {
    private JFrame frame;
    private JLabel icon;
    private ImageIcon i;

    private JLabel updatePrice;
    private JLabel bikeNumberPlate;
    private JLabel newPrice;

    private JTextField tBikeNumberPlate;
    private JTextField tNewPrice;
    private JTextArea tArea;

    private JButton update;
    private JButton back;


    public updatePriceGui() {

        ImageIcon i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(0, 0, 831, 551);


        frame = new JFrame("Bike Showroom");
        tArea = new JTextArea();


        updatePrice = new JLabel("Check Availability");
        bikeNumberPlate = new JLabel("Bike Number Plate:");
        newPrice = new JLabel("New Price:");

        tBikeNumberPlate = new JTextField(20);
        tNewPrice = new JTextField(20);

        updatePrice.setFont(new Font("Postmaster", Font.BOLD, 30));
        bikeNumberPlate.setFont(new Font("Postmaster", Font.BOLD, 20));
        newPrice.setFont(new Font("Postmaster", Font.BOLD, 20));

        updatePrice.setForeground(Color.DARK_GRAY);
        bikeNumberPlate.setForeground(Color.DARK_GRAY);
        newPrice.setForeground(Color.DARK_GRAY);
        tArea.setBackground(new Color(159, 153, 153, 200));


        updatePrice.setBounds(310, 30, 600, 100);
        bikeNumberPlate.setBounds(225, 180, 200, 30);
        tBikeNumberPlate.setBounds(415, 180, 150, 30);
        newPrice.setBounds(225, 230, 200, 30);
        tNewPrice.setBounds(415, 230, 150, 30);
        tArea.setBounds(195,160,400, 170);


        update = new JButton("Update");
        back = new JButton("BACK");

        update.setBounds(280, 280, 100, 30);
        back.setBounds(420, 280, 100, 30);

        update.setBackground(Color.lightGray);
        back.setBackground(Color.lightGray);


        frame.add(updatePrice);
        frame.add(bikeNumberPlate);
        frame.add(tBikeNumberPlate);
        frame.add(newPrice);
        frame.add(tNewPrice);
        frame.add(update);
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
        update.addActionListener(a);
        back.addActionListener(a);
    }



    class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Update")) {
                if (!(Vehicle.isNumberPlateValid(tBikeNumberPlate.getText()))|tBikeNumberPlate.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid Number Plate");
                    tBikeNumberPlate.setText(null);
                }
                else if(!(Vehicle.isPriceValid(Double.parseDouble(tNewPrice.getText())))|tNewPrice.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Invalid Price");
                    tNewPrice.setText(null);
                }
                else {
                    Bike.updatePriceOfBike(tBikeNumberPlate.getText(), Double.parseDouble(tNewPrice.getText()));
                    JOptionPane.showMessageDialog(null, "Price updated.");
                    frame.dispose();
                    MainMenuGUI x = new MainMenuGUI();
                }
            }
            else if(ae.getActionCommand().equalsIgnoreCase("Back")){
                frame.dispose();
                MainMenuGUI x = new MainMenuGUI();
            }
        }
    }
}
