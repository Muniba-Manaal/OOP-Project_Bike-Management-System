import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RemoveBikeGui extends JFrame {
    private JFrame frame;

    private JLabel icon;
    private ImageIcon i;

    private JLabel bikeNumberPlate;
    private JLabel removeBike;

    private JTextField tBikeNumberPlate;
    private JTextArea tArea;

    private JButton remove;
    private JButton back;


    public RemoveBikeGui() {

        ImageIcon i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(60, 40, 831, 551);

        frame = new JFrame("Bike Showroom");
        tArea = new JTextArea();


        removeBike = new JLabel("Remove Bike");
        bikeNumberPlate = new JLabel("Bike Number Plate: ");

        tBikeNumberPlate = new JTextField(20);


        bikeNumberPlate.setFont(new Font("Postmaster", Font.BOLD, 20));
        removeBike.setFont(new Font("Postmaster",Font.BOLD,30));


        bikeNumberPlate.setForeground(Color.DARK_GRAY);
        removeBike.setForeground(Color.DARK_GRAY);
        tArea.setBackground(new Color(159, 153, 153, 200));


        removeBike.setBounds(280,70,300,100);
        bikeNumberPlate.setBounds(225, 190, 200, 30);
        tBikeNumberPlate.setBounds(415, 190, 150, 30);
        tArea.setBounds(195,160,400, 150);


        remove = new JButton("Remove");
        back = new JButton("BACK");

        remove.setBounds(280, 250, 100, 30);
        back.setBounds(420, 250, 100, 30);


        remove.setBackground(Color.lightGray);
        back.setBackground(Color.lightGray);


        frame.add(removeBike);
        frame.add(bikeNumberPlate);
        frame.add(tBikeNumberPlate);
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
                if(!(Vehicle.isNumberPlateValid(tBikeNumberPlate.getText()))|tBikeNumberPlate.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Invalid Number Plate");
                    tBikeNumberPlate.setText(null);
                }
                else{
                    boolean check = Bike.RemoveBike(tBikeNumberPlate.getText());
                    if(check){
                        JOptionPane.showMessageDialog(null,"Bike Removed Successfully.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Bike Not Found.");
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
