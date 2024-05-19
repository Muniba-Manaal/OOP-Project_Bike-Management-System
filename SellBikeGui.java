import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellBikeGui extends JFrame {
    private JFrame frame;
    private JLabel icon;
    private ImageIcon i;

    private JLabel SellingBike;
    private JLabel customerName;
    private JLabel customerCNIC;
    private JLabel customerAge;
    private JLabel customerHomeNumber;
    private JLabel customerCity;
    private JLabel customerStreet;
    private JLabel day;
    private JLabel month;
    private JLabel year;
    private JLabel vehicleNumberPlate;

    private JTextField tCustomerName;
    private JTextField tCustomerCNIC;
    private JTextField tCustomerAge;
    private JTextField tCustomerHomeNumber;
    private JTextField tCustomerStreet;
    private JTextField tCustomerCity;
    private JTextField tDay;
    private JTextField tMonth;
    private JTextField tYear;
    private JTextField tVehicleNumberPlate;

    private JTextArea tArea;

    private JButton sell;
    private JButton back;


    public SellBikeGui() {

        ImageIcon i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(60, 30, 831, 551);

        frame = new JFrame("Bike Showroom");
        tArea = new JTextArea();

        frame.setBackground(Color.WHITE);

        SellingBike = new JLabel("Sell Bike");
        customerName = new JLabel("Customer Name:");
        customerAge = new JLabel("Customer Age: ");
        customerCNIC = new JLabel("Customer CNIC: ");
        customerHomeNumber = new JLabel("Customer Home: ");
        customerCity = new JLabel("Customer City: ");
        customerStreet = new JLabel("Customer Street: ");
        day = new JLabel("Day: ");
        month = new JLabel("Month: ");
        year = new JLabel("year: ");
        vehicleNumberPlate = new JLabel("Vehicle Plate:");


        tCustomerName = new JTextField(20);
        tCustomerAge = new JTextField(20);
        tCustomerCNIC = new JTextField(20);
        tCustomerHomeNumber = new JTextField(20);
        tCustomerStreet = new JTextField(20);
        tCustomerCity = new JTextField(20);
        tDay = new JTextField(20);
        tMonth = new JTextField(20);
        tYear = new JTextField(20);
        tVehicleNumberPlate = new JTextField(20);


        SellingBike.setFont(new Font("Postmaster", Font.BOLD, 30));
        customerName.setFont(new Font("Postmaster", Font.BOLD, 20));
        customerAge.setFont(new Font("Postmaster", Font.BOLD, 20));
        customerCNIC.setFont(new Font("Postmaster", Font.BOLD, 20));
        customerHomeNumber.setFont(new Font("Postmaster", Font.BOLD, 20));
        customerCity.setFont(new Font("Postmaster", Font.BOLD, 20));
        customerStreet.setFont(new Font("Postmaster", Font.BOLD, 20));
        day.setFont(new Font("Postmaster", Font.BOLD, 20));
        month.setFont(new Font("Postmaster", Font.BOLD, 20));
        year.setFont(new Font("Postmaster", Font.BOLD, 20));
        vehicleNumberPlate.setFont(new Font("Postmaster", Font.BOLD, 20));


        SellingBike.setForeground(Color.DARK_GRAY);
        customerName.setForeground(Color.DARK_GRAY);
        customerAge.setForeground(Color.DARK_GRAY);
        customerCNIC.setForeground(Color.DARK_GRAY);
        customerHomeNumber.setForeground(Color.DARK_GRAY);
        customerCity.setForeground(Color.DARK_GRAY);
        customerStreet.setForeground(Color.DARK_GRAY);
        day.setForeground(Color.DARK_GRAY);
        month.setForeground(Color.DARK_GRAY);
        year.setForeground(Color.DARK_GRAY);
        vehicleNumberPlate.setForeground(Color.DARK_GRAY);
        tArea.setBackground(new Color(241, 197, 197, 200));


        SellingBike.setBounds(320, 0, 600, 100);
        customerName.setBounds(215, 80, 200, 30);
        tCustomerName.setBounds(415, 80, 150, 30);
        customerCNIC.setBounds(215, 120, 180, 30);
        tCustomerCNIC.setBounds(415, 120, 150, 30);
        customerAge.setBounds(215, 160, 150, 30);
        tCustomerAge.setBounds(415, 160, 150, 30);
        customerHomeNumber.setBounds(215, 200, 200, 30);
        tCustomerHomeNumber.setBounds(415, 200, 150, 30);
        customerCity.setBounds(215, 240, 200, 30);
        tCustomerStreet.setBounds(415, 240, 150, 30);
        customerStreet.setBounds(215,280,200,30);
        tCustomerCity.setBounds(415,280,150,30);
        day.setBounds(215,320,150,30);
        tDay.setBounds(415,320,150,30);
        month.setBounds(215,360,150,30);
        tMonth.setBounds(415,360,150,30);
        year.setBounds(215,400,150,30);
        tYear.setBounds(415,400,150,30);
        vehicleNumberPlate.setBounds(215,440,150,30);
        tVehicleNumberPlate.setBounds(415,440,150,30);
        tArea.setBounds(195,68,400, 442);

        sell = new JButton("SELL");
        back = new JButton("BACK");

        sell.setBounds(280, 480, 100, 30);
        back.setBounds(420, 480, 100, 30);

        sell.setBackground(Color.lightGray);
        back.setBackground(Color.lightGray);


        frame.add(SellingBike);
        frame.add(customerName);
        frame.add(tCustomerName);
        frame.add(customerAge);
        frame.add(tCustomerAge);
        frame.add(customerCNIC);
        frame.add(tCustomerCNIC);
        frame.add(customerHomeNumber);
        frame.add(tCustomerHomeNumber);
        frame.add(customerCity);
        frame.add(tCustomerStreet);
        frame.add(customerStreet);
        frame.add(tCustomerCity);
        frame.add(tDay);
        frame.add(day);
        frame.add(tMonth);
        frame.add(month);
        frame.add(year);
        frame.add(tYear);
        frame.add(vehicleNumberPlate);
        frame.add(tVehicleNumberPlate);
        frame.add(sell);
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
        sell.addActionListener(a);
        back.addActionListener(a);
    }



    class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("sell")) {

                String name, home, street, city, numberPlate, cnic;
                int day, month, year, age;
                if (!(Person.isAgeValid(Integer.parseInt(tCustomerAge.getText()))) | tCustomerAge.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Minimum Age should be 18.");
                    tCustomerAge.setText(null);
                } else if (!(Person.isCNICValid(tCustomerCNIC.getText())) | tCustomerCNIC.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid CNIC.");
                    tCustomerCNIC.setText(null);
                } else if (!(Vehicle.isNumberPlateValid(tVehicleNumberPlate.getText())) | tVehicleNumberPlate.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid Bike Number Plate.");
                    tVehicleNumberPlate.setText(null);
                }
                else if (tCustomerName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Customer Should have name.");
                    tCustomerName.setText(null);
                }
                else if (tCustomerHomeNumber.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Customer might have home.");
                    tCustomerHomeNumber.setText(null);
                }
                else if (tCustomerStreet.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Customer might have street.");
                    tCustomerStreet.setText(null);
                }else if (tCustomerCity.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Customer might have city.");
                    tCustomerCity.setText(null);
                }else if (tDay.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Day is empty.");
                    tDay.setText(null);
                }else if (tMonth.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Month is empty.");
                    tMonth.setText(null);
                }else if (tYear.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Year is empty.");
                    tYear.setText(null);
                }
                else {
                    name = tCustomerName.getText();
                    age = Integer.parseInt(tCustomerAge.getText());
                    cnic = tCustomerCNIC.getText();
                    home = tCustomerHomeNumber.getText();
                    street = tCustomerStreet.getText();
                    city = tCustomerCity.getText();
                    day = Integer.parseInt(tDay.getText());
                    month = Integer.parseInt(tMonth.getText());
                    year = Integer.parseInt(tYear.getText());
                    numberPlate = tVehicleNumberPlate.getText();

                    Date d = new Date(day, month, year);
                    Address a = new Address(home, street, city);
                    BikeOwner b = new BikeOwner(cnic, name, age, a, d, numberPlate);

                    Bike sold = Bike.SearchByVehicleNumberPlate(numberPlate);
                    if(sold==null){
                        JOptionPane.showMessageDialog(null,"Bike Not Found.");
                    }
                    else {
                        BikeOwner.AddBikeOwner(b);
                        Bike.AddSoldBike(sold);
                        Bike.RemoveBike(numberPlate);
                        JOptionPane.showMessageDialog(null, "Bike sold successfully");
                        frame.dispose();
                        MainMenuGUI x = new MainMenuGUI();
                    }
                }
            }
            else if(ae.getActionCommand().equalsIgnoreCase("Back")){
                frame.dispose();
                MainMenuGUI x = new MainMenuGUI();
            }
        }
    }
}
