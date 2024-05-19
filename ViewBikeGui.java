
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ViewBikeGui extends JFrame {
    private JFrame frame;
    private JLabel icon;
    private ImageIcon i;

    private JLabel AvailableBikes;
    private JLabel BikeNumberPlate;
    private JLabel BikeColour;
    private JLabel BikePrice;
    private JLabel BikeCC;
    private JLabel BikeType;

    private JTextArea tArea;

    private JButton back;


    public ViewBikeGui() {
        ImageIcon  i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(0,0 , 831, 551);

        frame = new JFrame("Bike Showroom");
        frame.setBackground(Color.LIGHT_GRAY);

        AvailableBikes = new JLabel("Available Bikes");
        BikeNumberPlate = new JLabel("Number Plate");
        BikeColour = new JLabel("Colour");
        BikeCC = new JLabel("CC");
        BikePrice = new JLabel("Price");
        BikeType = new JLabel("Type");


        tArea = new JTextArea();

        ArrayList<Bike> bikeList = new ArrayList<Bike>();
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new FileInputStream("bikes.ser"));
            while(true){
                Bike b = (Bike)ois.readObject();
                bikeList.add(b);
            }
        }
        catch (ClassNotFoundException e) {
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        for(int j=0; j<bikeList.size(); j++) {
            tArea.append("\n"+bikeList.get(j).toString());
        }


        AvailableBikes.setFont(new Font("Postmaster",Font.BOLD,30));
        BikeNumberPlate.setFont(new Font("Postmaster",Font.BOLD,20));
        BikeCC.setFont(new Font("Postmaster",Font.BOLD,20));
        BikeColour.setFont(new Font("Postmaster",Font.BOLD,20));
        BikePrice.setFont(new Font("Postmaster",Font.BOLD,20));
        BikeType.setFont(new Font("Postmaster",Font.BOLD,20));
        tArea.setFont(new Font("Postmaster",Font.BOLD,20));


        AvailableBikes.setForeground(Color.DARK_GRAY);
        BikeNumberPlate.setForeground(Color.DARK_GRAY);
        BikeType.setForeground(Color.DARK_GRAY);
        BikeCC.setForeground(Color.DARK_GRAY);
        BikeColour.setForeground(Color.DARK_GRAY);
        BikePrice.setForeground(Color.DARK_GRAY);
        tArea.setForeground(Color.GRAY);
        tArea.setBackground(new Color(159, 153, 153, 200));


        AvailableBikes.setBounds(280, 15, 600, 100);
        BikeNumberPlate.setBounds(10,100,150,30);
        BikeCC.setBounds(220, 100, 150,30);
        BikeColour.setBounds(550, 100, 150, 30);
        BikePrice.setBounds(750, 100, 150, 30);
        BikeType.setBounds(390, 100, 150, 30);
        tArea.setBounds(10, 140, 800, 320);

        back = new JButton("BACK");

        back.setBounds(350,470,100,30);
        back.setBackground(Color.pink);


        frame.add(AvailableBikes);
        frame.add(BikeNumberPlate);
        frame.add(BikeType);
        frame.add(BikeCC);
        frame.add(BikeColour);
        frame.add(BikePrice);
        frame.add(tArea);
        frame.add(back);
        frame.add(icon);


        frame.setTitle("Bike Showroom");
        frame.setVisible(true);
        frame.setSize(831,551);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        back.addActionListener(new ActionHandler());
    }

    class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equalsIgnoreCase("back")) {
                frame.dispose();
                MainMenuGUI v = new MainMenuGUI();
            }
        }
    }
}
