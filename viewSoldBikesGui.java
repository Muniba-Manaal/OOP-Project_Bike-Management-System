
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class viewSoldBikesGui extends JFrame {
    private JPanel panel;
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


    public viewSoldBikesGui() {
        panel = new JPanel(null);

        ImageIcon  i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(0,0 , 831, 551);

        frame = new JFrame("Bike Showroom");
        panel.setBackground(Color.WHITE);

        AvailableBikes = new JLabel("Sold Bikes");
        BikeNumberPlate = new JLabel("Number Plate");
        BikeColour = new JLabel("Colour");
        BikeCC = new JLabel("CC");
        BikePrice = new JLabel("Price");
        BikeType = new JLabel("Type");


        tArea = new JTextArea();

        ArrayList<Bike> soldBikeList = new ArrayList<Bike>();
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new FileInputStream("soldBikes.ser"));
            while(true){
                Bike b = (Bike)ois.readObject();
//                System.out.println(b.toString());
                soldBikeList.add(b);
            }
//            System.out.println(soldBikeList.isEmpty());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }


        for(int j=0; j<soldBikeList.size(); j++) {
            tArea.append("\n"+soldBikeList.get(j).toString());
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
        tArea.setBackground(new Color(241, 197, 197, 200));


        AvailableBikes.setBounds(280, 15, 600, 100);
        BikeNumberPlate.setBounds(10,100,150,30);
        BikeCC.setBounds(220, 100, 150,30);
        BikeColour.setBounds(550, 100, 150, 30);
        BikePrice.setBounds(750, 100, 150, 30);
        BikeType.setBounds(390, 100, 150, 30);
        tArea.setBounds(10, 140, 800, 320);

        back = new JButton("BACK");

        back.setBounds(350,470,100,30);
        back.setBackground(Color.DARK_GRAY);


        panel.add(AvailableBikes);
        panel.add(BikeNumberPlate);
        panel.add(BikeType);
        panel.add(BikeCC);
        panel.add(BikeColour);
        panel.add(BikePrice);
        panel.add(tArea);
        panel.add(back);
        panel.add(icon);


        frame.add(panel);
        frame.setTitle("Bike Showroom");
        frame.setVisible(true);
        frame.setSize(831,551);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        back.addActionListener(new ActionHandler());
    }

    class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equalsIgnoreCase("back")) {
                frame.dispose();
                new MainMenuGUI();
            }
        }
    }
}
