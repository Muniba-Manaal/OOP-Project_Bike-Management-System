import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuGUI extends JFrame {

    private JFrame frame;

    private JLabel bikeShowroom;
    private JLabel icon;

    private ImageIcon i;

    private JButton addBike;
    private JButton removeBike;
    private JButton availableBike;
    private JButton sellBike;
    private JButton checkStock;
    private JButton updatePrice;
    private JButton removeCustomer;
    private JButton viewCustomer;
    private JButton viewSoldBikes;
    private JButton exit;

    private JTextArea tArea;


    public MainMenuGUI() {

        ImageIcon  i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(40,20 , 831, 551);

        frame = new JFrame("Bike Showroom");

        bikeShowroom = new JLabel("BIKE SHOWROOM");

        tArea = new JTextArea();

        frame.setBackground(Color.PINK);
        bikeShowroom.setFont(new Font("Postmaster",Font.BOLD,30));


        addBike = new JButton("Add Bike");
        removeBike = new JButton("Remove Bike");
        availableBike = new JButton("Available Bikes");
        sellBike = new JButton("Sell Bike");
        checkStock = new JButton("Check Stock");
        updatePrice = new JButton("Update Price");
        viewCustomer = new JButton("View Customers");
        removeCustomer  = new JButton("Remove Customer");
        viewSoldBikes  = new JButton("View Sold Bikes");
        exit = new JButton("Exit");


        bikeShowroom.setForeground(Color.DARK_GRAY);
        addBike.setBackground(Color.lightGray);
        removeBike.setBackground(Color.lightGray);
        availableBike.setBackground(Color.lightGray);
        sellBike.setBackground(Color.lightGray);
        checkStock.setBackground(Color.lightGray);
        updatePrice.setBackground(Color.lightGray);
        viewCustomer.setBackground(Color.lightGray);
        removeCustomer.setBackground(Color.lightGray);
        viewSoldBikes.setBackground(Color.lightGray);
        tArea.setBackground(new Color(159, 153, 153, 200));
        exit.setBackground(Color.lightGray);


        bikeShowroom.setBounds(280,30,600,100);
        addBike.setBounds(200, 150, 180, 40);
        removeBike.setBounds(450, 150, 180, 40);
        availableBike.setBounds(200, 210, 180, 40);
        sellBike.setBounds(450, 210, 180, 40);
        checkStock.setBounds(200,270,180,40);
        updatePrice.setBounds(450,270,180,40);
        removeCustomer.setBounds(450,330,180,40);
        viewCustomer.setBounds(200,330,180,40);
        viewSoldBikes.setBounds(200,390,180,40);
        tArea.setBounds(170,120,490, 340);
        exit.setBounds(450, 390, 180, 40);


        frame.add(bikeShowroom);
        frame.add(addBike);
        frame.add(removeBike);
        frame.add(availableBike);
        frame.add(sellBike);
        frame.add(checkStock);
        frame.add(updatePrice);
        frame.add(removeCustomer);
        frame.add(viewCustomer);
        frame.add(viewSoldBikes);
        frame.add(exit);
        frame.add(tArea);
        frame.add(icon);


        frame.setTitle("Bike Showroom");
        frame.setSize(831,551);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        MyActionListener a = new MyActionListener();

        addBike.addActionListener(a);
        availableBike.addActionListener(a);
        removeBike.addActionListener(a);
        sellBike.addActionListener(a);
        checkStock.addActionListener(a);
        updatePrice.addActionListener(a);
        removeCustomer.addActionListener(a);
        viewCustomer.addActionListener(a);
        checkStock.addActionListener(a);
        viewSoldBikes.addActionListener(a);
        exit.addActionListener(a);
    }

    class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equalsIgnoreCase( "Add Bike")){
                frame.dispose();
                AddBikeGui a =  new AddBikeGui();
            }
            else if(ae.getActionCommand().equalsIgnoreCase( "Remove Bike")){
                frame.dispose();
                RemoveBikeGui a =  new RemoveBikeGui();
            }
            else if(ae.getActionCommand().equalsIgnoreCase( "Available Bikes")){
                frame.dispose();
                ViewBikeGui a =  new ViewBikeGui();
            }
            else if(ae.getActionCommand().equalsIgnoreCase( "Check Stock")){
                frame.dispose();
                SearchBikeGui a =  new SearchBikeGui();
            }
            else if(ae.getActionCommand().equalsIgnoreCase( "Sell Bike")){
                frame.dispose();
                SellBikeGui a =  new SellBikeGui();
            }
            else if(ae.getActionCommand().equalsIgnoreCase( "Update Price")){
                frame.dispose();
                updatePriceGui g =  new updatePriceGui();
            }
            else if(ae.getActionCommand().equalsIgnoreCase( "Remove Customer")){
                frame.dispose();
                removeCustomerGui g =  new removeCustomerGui();
            }
            else if(ae.getActionCommand().equalsIgnoreCase( "View Customers")){
                frame.dispose();
                viewCustomerGui g =  new viewCustomerGui();
            }
            else if(ae.getActionCommand().equalsIgnoreCase( "View Sold Bikes")){
                frame.dispose();
                viewSoldBikesGui g =  new viewSoldBikesGui();
            }
            else if(ae.getActionCommand().equalsIgnoreCase( "Exit")){
                frame.dispose();
                JOptionPane.showMessageDialog(null,"Bye");
            }
        }
    }
}