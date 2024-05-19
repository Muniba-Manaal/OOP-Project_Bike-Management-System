
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class viewCustomerGui extends JFrame {
    private JPanel panel;
    private JFrame frame;
    private JLabel icon;
    private ImageIcon i;

    private JLabel bikeOwner;
    private JLabel ownerName;
    private JLabel ownerAge;
    private JLabel buyingDate;
    private JLabel ownerCNIC;
    private JLabel bikePlate;

    private JTextArea tArea;

    private JButton back;


    public viewCustomerGui() {
        panel = new JPanel(null);

        ImageIcon  i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(60,20 , 831, 551);

        frame = new JFrame("Bike Showroom");
        panel.setBackground(Color.WHITE);

        bikeOwner = new JLabel("Bike Owners");
        ownerName = new JLabel("Name");
        ownerAge = new JLabel("Age");
        ownerCNIC = new JLabel("CNIC");
        buyingDate = new JLabel("Purchase Date");
        bikePlate = new JLabel("Ride");


        tArea = new JTextArea();

        ArrayList<BikeOwner> bikeOwnersList = new ArrayList<BikeOwner>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bikeOwners.ser"));
            while(true){
                BikeOwner b = (BikeOwner)ois.readObject();
                bikeOwnersList.add(b);
            }
        }
        catch (ClassNotFoundException e) {
        }
        catch(EOFException e){
        }
        catch (IOException e) {
        }
        catch(Exception e){
        }


        for(int j=0; j<bikeOwnersList.size(); j++) {
            tArea.append("\n"+bikeOwnersList.get(j).toString());
        }


        bikeOwner.setFont(new Font("Postmaster",Font.BOLD,30));
        ownerName.setFont(new Font("Postmaster",Font.BOLD,20));
        ownerCNIC.setFont(new Font("Postmaster",Font.BOLD,20));
        ownerAge.setFont(new Font("Postmaster",Font.BOLD,20));
        buyingDate.setFont(new Font("Postmaster",Font.BOLD,20));
        bikePlate.setFont(new Font("Postmaster",Font.BOLD,20));
        tArea.setFont(new Font("Postmaster",Font.BOLD,20));


        bikeOwner.setForeground(Color.DARK_GRAY);
        ownerName.setForeground(Color.DARK_GRAY);
        bikePlate.setForeground(Color.DARK_GRAY);
        ownerCNIC.setForeground(Color.DARK_GRAY);
        ownerAge.setForeground(Color.DARK_GRAY);
        buyingDate.setForeground(Color.DARK_GRAY);
        tArea.setForeground(Color.GRAY);
        tArea.setBackground(new Color(241, 197, 197, 200));


        bikeOwner.setBounds(280, 15, 600, 100);
        ownerName.setBounds(10,100,150,30);
        ownerCNIC.setBounds(220, 100, 150,30);
        ownerAge.setBounds(555, 100, 150, 30);
        buyingDate.setBounds(670, 100, 150, 30);
        bikePlate.setBounds(400, 100, 150, 30);
        tArea.setBounds(10, 140, 800, 320);

        back = new JButton("BACK");

        back.setBounds(350,470,100,30);
        back.setBackground(Color.DARK_GRAY);


        panel.add(bikeOwner);
        panel.add(ownerName);
        panel.add(bikePlate);
        panel.add(ownerCNIC);
        panel.add(ownerAge);
        panel.add(buyingDate);
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
