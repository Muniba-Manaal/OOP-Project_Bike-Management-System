
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBikeGui extends JFrame {
    private JFrame frame;
    private JLabel icon;
    private ImageIcon i;
    private JLabel addingBike;
    private JLabel bikeNumberPlate;
    private JLabel bikeColour;
    private JLabel bikePrice;
    private JLabel bikeCC;
    private JLabel bikeType;

    private JTextField tBikeNumberPlate;
    private JTextField tBikeColour;
    private JTextField tBikePrice;
    private JTextField tBikeCC;
    private JTextField tBikeType;

    private JButton save;
    private JButton back;

    private JTextArea tArea;


    public AddBikeGui() {

        ImageIcon i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(0, 0, 831, 551);

        frame = new JFrame("Bike Showroom");

        tArea = new JTextArea();

        addingBike = new JLabel("ADDING A Bike");
        bikeNumberPlate = new JLabel("Bike Number Plate: ");
        bikeColour = new JLabel("Bike Colour: ");
        bikePrice = new JLabel("Bike Price: ");
        bikeCC = new JLabel("Bike CC: ");
        bikeType = new JLabel("Bike Type: ");

        tBikeNumberPlate = new JTextField(20);
        tBikeColour = new JTextField(20);
        tBikePrice = new JTextField(20);
        tBikeCC = new JTextField(20);
        tBikeType = new JTextField(20);


        addingBike.setFont(new Font("Postmaster", Font.BOLD, 30));
        bikeNumberPlate.setFont(new Font("Postmaster", Font.BOLD, 20));
        bikeColour.setFont(new Font("Postmaster", Font.BOLD, 20));
        bikeNumberPlate.setFont(new Font("Postmaster", Font.BOLD, 20));
        bikePrice.setFont(new Font("Postmaster", Font.BOLD, 20));
        bikeCC.setFont(new Font("Postmaster", Font.BOLD, 20));
        bikeType.setFont(new Font("Postmaster", Font.BOLD, 20));


        addingBike.setForeground(Color.DARK_GRAY);
        bikeNumberPlate.setForeground(Color.DARK_GRAY);
        bikeColour.setForeground(Color.DARK_GRAY);
        bikePrice.setForeground(Color.DARK_GRAY);
        bikeCC.setForeground(Color.DARK_GRAY);
        bikeType.setForeground(Color.DARK_GRAY);
        tArea.setBackground(new Color(159, 153, 153, 200));


        addingBike.setBounds(280, 30, 600, 100);
        bikeNumberPlate.setBounds(225, 140, 200, 30);
        tBikeNumberPlate.setBounds(415, 140, 150, 30);
        bikeColour.setBounds(225, 190, 150, 30);
        tBikeColour.setBounds(415, 190, 150, 30);
        bikePrice.setBounds(225, 240, 150, 30);
        tBikePrice.setBounds(415, 240, 150, 30);
        bikeCC.setBounds(225, 290, 150, 30);
        tBikeCC.setBounds(415, 290, 150, 30);
        bikeType.setBounds(225,340,150,30);
        tBikeType.setBounds(415,340,150,30);
        tArea.setBounds(195,110,405, 340);


        save = new JButton("SAVE");
        back = new JButton("BACK");

        save.setBounds(280, 400, 100, 30);
        back.setBounds(420, 400, 100, 30);

        save.setBackground(Color.lightGray);
        back.setBackground(Color.lightGray);


        frame.add(addingBike);
        frame.add(bikeNumberPlate);
        frame.add(tBikeNumberPlate);
        frame.add(bikeColour);
        frame.add(tBikeColour);
        frame.add(bikePrice);
        frame.add(tBikePrice);
        frame.add(bikeCC);
        frame.add(tBikeCC);
        frame.add(bikeType);
        frame.add(tBikeType);
        frame.add(save);
        frame.add(back);
        frame.add(tArea);
        frame.add(icon);


        frame.setTitle("Bike Showroom");
        frame.setSize(831, 551);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        MyActionListener a = new MyActionListener();
        save.addActionListener(a);
        back.addActionListener(a);
    }



    class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Save")) {
                String numberPlate, colour, type;
                Double CC, price;

                if (!(Vehicle.isNumberPlateValid(tBikeNumberPlate.getText()))|tBikeNumberPlate.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid Number Plate");
                    tBikeNumberPlate.setText(null);
                }
                else if(!(Vehicle.isPriceValid(Double.parseDouble(tBikePrice.getText())))|tBikePrice.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Invalid Price");
                    tBikePrice.setText(null);
                }
                else if(!(Vehicle.isCCValid(Double.parseDouble(tBikeCC.getText())))|tBikePrice.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Invalid CC");
                    tBikeCC.setText(null);
                }
                else if(tBikeColour.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Bike should have colour.");
                    tBikeColour.setText(null);
                }
                else if(tBikeType.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Bike should have colour.");
                    tBikeType.setText(null);
                }
                else {
                    frame.dispose();
                    numberPlate = tBikeNumberPlate.getText();
                    colour = tBikeColour.getText();
                    type = tBikeType.getText();
                    CC = Double.parseDouble(tBikeCC.getText());
                    price = Double.parseDouble(tBikePrice.getText());

                    Bike b = new Bike(numberPlate, CC, colour, price, type);
                    Bike.AddBike(b);
                    JOptionPane.showMessageDialog(null, "Bike Added Successfully");
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
