import javax.swing.*;
import java.io.Serializable;
import java.io.*;
import java.util.*;

public class Bike extends Vehicle implements Serializable {
     String type;

    public Bike (){
        super();
    }

    public Bike(String bikeNumberPlate,double bikeCC,String bikeColour,double price, String types) {
        super(bikeNumberPlate,bikeCC,bikeColour,price);
        this.type = types;
    }

    public String getTypes() {
        return type;
    }

    public void setTypes(String types) {
        this.type = types;
    }

    @Override
    public String toString() {
        return vehicleNumberPlate + "\t             "+vehicleCC +"\t                   "+type +"\t                   "+ vehicleColour +"\t     "+ price ;
    }

    public static void AddBike(Bike bO) {
        try{
            File file = new File("bikes.ser");
            ObjectOutputStream oos;
            if(file.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(file,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(bO);
            oos.close();
        }
        catch(IOException e){
            System.out.println("Error in File Writing");
        }
    }

    public static boolean RemoveBike(String numberPlate) {
        boolean check = false;
        ArrayList<Bike> bikes = new ArrayList<Bike>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bikes.ser"));
            while (true) {
                Bike b = (Bike) ois.readObject();
                bikes.add(b);
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
        for (int i = 0; i < bikes.size(); i++) {
            if (bikes.get(i).getVehicleNumberPlate().equalsIgnoreCase(numberPlate)) {
                bikes.remove(i);
                check = true;
            }
            else if(i== bikes.size()-1&!(bikes.get(i).getVehicleNumberPlate().equalsIgnoreCase(numberPlate))){
                check = false;
            }
        }
        try {
            File f = new File("bikes.ser");
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(f));
            ous.writeObject(bikes.get(0));
            ous.close();
            for (int i = 1; i < bikes.size(); i++) {
                ous = new MyObjectOutputStream(new FileOutputStream(f,
                        true));
                ous.writeObject(bikes.get(i));
            }
            ous.close();
        } catch (IOException e) {
            System.out.println("IO Exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    return check;
    }




    public static Bike SearchByVehicleNumberPlate(String numberPlate) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("bikes.ser"));
            while (true) {
                Bike b = (Bike) ois.readObject();
                if(b.getVehicleNumberPlate().equalsIgnoreCase(numberPlate)){

                    return b;
                }
            }
        }
        catch(ClassNotFoundException e){
            return null;
        }
        catch(EOFException e){
            System.out.println("Bike not found.");
            return null;
        }
        catch(IOException e){
            return null;
        }
        finally {
            try{
                ois.close();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

    public static void updatePriceOfBike (String key,Double update){
        ArrayList<Bike> bikesList = new ArrayList<Bike>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new
                    FileInputStream("bikes.ser"));
            while(true){
                Bike b = (Bike)ois.readObject();
                bikesList.add(b);
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
        for(int i=0;i<bikesList.size();i++){
            if(bikesList.get(i).getVehicleNumberPlate().equalsIgnoreCase(key)){
                bikesList.get(i).setPrice(update);
            }
        }
        try{
            File f = new File("bikes.ser");
            ObjectOutputStream ous = new ObjectOutputStream(new
                    FileOutputStream(f));
            ous.writeObject(bikesList.get(0));
            ous.close();
            for(int i=1;i<bikesList.size();i++){
                ous = new MyObjectOutputStream(new FileOutputStream(f,
                        true));
                ous.writeObject(bikesList.get(i));
            }
            ous.close();
        }
        catch (IOException e) {
            System.out.println("IO Exception");
        }
        catch(Exception e){
            return;
        }
    }

    public static void AddSoldBike(Bike bO) {
        try{
            File file = new File("soldBikes.ser");
            ObjectOutputStream oos;
            if(file.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(file,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(bO);
            oos.close();
        }
        catch(IOException e){
            System.out.println("Error in File Writing");
        }
    }

}
