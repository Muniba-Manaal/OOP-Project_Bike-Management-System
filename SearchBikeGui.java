import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBikeGui extends JFrame {
    private JFrame frame;

    private JLabel icon;
    private ImageIcon i;

    private JLabel searchBike;
    private JLabel bikeNumberPlate;

    private JTextField tBikeNumberPlate;
    private JTextArea tArea;

    private JButton check;
    private JButton back;


    public SearchBikeGui() {
        ImageIcon i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(60, 50, 831, 551);

        frame = new JFrame("Bike Showroom");
        tArea = new JTextArea();

        frame.setBackground(Color.WHITE);

        searchBike = new JLabel("Check Availability");
        bikeNumberPlate = new JLabel("Bike Number Plate: ");

        tBikeNumberPlate = new JTextField(20);

        searchBike.setFont(new Font("Postmaster", Font.BOLD, 30));
        bikeNumberPlate.setFont(new Font("Postmaster", Font.BOLD, 20));
        bikeNumberPlate.setFont(new Font("Postmaster", Font.BOLD, 20));

        searchBike.setForeground(Color.DARK_GRAY);
        bikeNumberPlate.setForeground(Color.DARK_GRAY);
        tArea.setBackground(new Color(159, 153, 153, 200));


        searchBike.setBounds(310, 30, 600, 100);
        bikeNumberPlate.setBounds(225, 180, 200, 30);
        tBikeNumberPlate.setBounds(415, 180, 150, 30);
        tArea.setBounds(195,160,400, 150);


        check = new JButton("Check");
        back = new JButton("BACK");

        check.setBounds(280, 250, 100, 30);
        back.setBounds(420, 250, 100, 30);

        check.setBackground(Color.lightGray);
        back.setBackground(Color.lightGray);


        frame.add(searchBike);
        frame.add(bikeNumberPlate);
        frame.add(tBikeNumberPlate);
        frame.add(check);
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
        check.addActionListener(a);
        back.addActionListener(a);
    }



    class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Check")) {
                if ((!(Vehicle.isNumberPlateValid(tBikeNumberPlate.getText()))|tBikeNumberPlate.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null, "Invalid Number Plate");
                    tBikeNumberPlate.setText(null);
                }
                else {
                    Bike b = Bike.SearchByVehicleNumberPlate(tBikeNumberPlate.getText());
                    if (b == null) {
                        JOptionPane.showMessageDialog(null, "Bike not Available");
                    } else {
                        JOptionPane.showMessageDialog(null, "Bike is available");
                    }
                }
                frame.dispose();
                MainMenuGUI y = new MainMenuGUI();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("Back")){
                frame.dispose();
                MainMenuGUI x = new MainMenuGUI();
            }
        }
    }
}
