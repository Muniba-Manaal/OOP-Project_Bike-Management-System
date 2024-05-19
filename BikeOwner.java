import java.io.*;
import java.util.ArrayList;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;


public class BikeOwner extends Person implements Serializable {
    Date dateOfBuying;
    String purchasedVehicle;


    public BikeOwner() {
        dateOfBuying = new Date();
    }

    public BikeOwner(String CNIC,String name, int age, Address address, Date dateOfBuying,String purchasedVehicle) {
        super(CNIC,name, age, address);
        this.dateOfBuying = dateOfBuying;
        this.purchasedVehicle = purchasedVehicle;
    }

    public Date getDateOfBuying() {
        return dateOfBuying;
    }

    public void setDateOfBuying(Date dateOfBuying) {
        this.dateOfBuying = dateOfBuying;
    }

    public String getPurchasedVehicle() {
        return purchasedVehicle;
    }

    public void setPurchasedVehicle(String purchasedVehicle) {
        this.purchasedVehicle = purchasedVehicle;
    }

    @Override
    public String toString() {
        return name + "\t          "+CNIC +"         "+purchasedVehicle +"\t"+ age +"\t    "+ dateOfBuying.toString();
//        "BikeOwner{" +
//            "dateOfBuying=" +  +
//                    ", purchasedVehicle='" +  + '\'' +
//                    ", name='" +  + '\'' +
//                    ", age=" +  +
//                    ", address=" + address.toString() +
//                    ", CNIC='" +  + '\'' +
//                    '}';
    }

    public static void AddBikeOwner(BikeOwner bO) {
    try{
        File file = new File("bikeOwners.ser");
        ObjectOutputStream oos = null;
        if(file.exists()){
            oos = new MyObjectOutputStream(new FileOutputStream(file,true));
        }
        else{
            oos = new ObjectOutputStream(new FileOutputStream(file));
        }

        System.out.println(bO.toString());
        oos.writeObject(bO);
        oos.close();
    }
//    catch(EOFException e){
//        System.out.println("File ended");
//    }
//    catch(FileNotFoundException e){
//        System.out.println(e.getMessage());
//    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }
}



    public static boolean RemoveBikeOwner(String name) {
        boolean check = false;
        ArrayList<BikeOwner> bikeOwners = new ArrayList<BikeOwner>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bikeOwners.ser"));
            while (true) {
                BikeOwner bO = (BikeOwner) ois.readObject();
                bikeOwners.add(bO);
            }
        }
        catch (ClassNotFoundException e) {
        }
        catch (EOFException e) {
        }
        catch (IOException e) {
        }
        catch (Exception e) {
        }
        for (int i = 0; i < bikeOwners.size(); i++) {
            if (bikeOwners.get(i).getName().equalsIgnoreCase(name)) {
                bikeOwners.remove(i);
                check = true;
            }
            else if(i== bikeOwners.size()-1&!(bikeOwners.get(i).getName().equalsIgnoreCase(name))){
                check = false;
            }
        }
        try {
            File f = new File("bikeOwners.ser");
            ObjectOutputStream ous = new ObjectOutputStream(new
                    FileOutputStream(f));
            ous.writeObject(bikeOwners.get(0));
            ous.close();
            for (int i = 1; i < bikeOwners.size(); i++) {
                ous = new MyObjectOutputStream(new FileOutputStream(f,
                        true));
                ous.writeObject(bikeOwners.get(i));
            }
            ous.close();
        } catch (IOException e) {
            System.out.println("IO Exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return check;
    }



    public static BikeOwner SearchByName(String name) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new
                    FileInputStream("bikeOwners.ser"));
            while (true) {
                BikeOwner bO = (BikeOwner) ois.readObject();
                if(bO.getName().equalsIgnoreCase(name)){
                    return bO;
                }
            }
        }
        catch(ClassNotFoundException e){
            return null;
        }
        catch(EOFException e){
            System.out.println("Bike Owner not found.");
            return null;
        }
        catch(IOException e){
            return null;
        }
    }


    public static BikeOwner SearchByCNIC(String carOwnerCNIC) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new
                    FileInputStream("bikeOwners.ser"));
            while (true) {
                BikeOwner bO = (BikeOwner) ois.readObject();
                if(bO.getName().equalsIgnoreCase(carOwnerCNIC)){
                    return bO;
                }
            }
        }
        catch(ClassNotFoundException e){
            return null;
        }
        catch(EOFException e){
            System.out.println("Bike Owner not found.");
            return null;
        }
        catch(IOException e){
            return null;
        }
    }


    public static String display() {
        String stu = "";
        try {
            ObjectInputStream ois = new ObjectInputStream(new
                    FileInputStream("bikeOwners.ser"));
            while (true) {
                BikeOwner s = (BikeOwner) ois.readObject();
                stu += s.toString()+"\n";
            }
        }
        catch(ClassNotFoundException e){
            return "Class not found";
        }
        catch(EOFException e){
            return stu;
        }
        catch(IOException e){
            return "Error";
        }
    }
}

