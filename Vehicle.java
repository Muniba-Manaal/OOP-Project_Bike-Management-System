import java.util.*;
import java.io.Serializable;


public class Vehicle implements Serializable{
    String vehicleNumberPlate;
    double vehicleCC;
    String vehicleColour;
    double price;

    public Vehicle (){}

    public Vehicle(String vehicleNumberPlate, double vehicleCC, String vehicleColour, double price) {
        this.vehicleNumberPlate = vehicleNumberPlate;
        this.vehicleCC = vehicleCC;
        this.vehicleColour = vehicleColour;
        this.price = price;
    }

    public String getVehicleNumberPlate() {
        return vehicleNumberPlate;
    }

    public void setVehicleNamePlate(String vehicleName) {
        this.vehicleNumberPlate = vehicleName;
    }

    public double getVehicleCC() {
        return vehicleCC;
    }

    public void setVehicleCC(double vehicleCC) {
        this.vehicleCC = vehicleCC;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNamePlate='" + vehicleNumberPlate + '\'' +
                ", vehicleCC='" + vehicleCC + '\'' +
                ", price=" + price +
                '}';
    }

    public static boolean isCCValid(double cC) {
        boolean check = true;
        if (cC>8300 && cC<0) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean isPriceValid(double p){
        if(p>100000){
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean isNumberPlateValid(String n){
        if(n.length()>8){
            return false;
        }
        else{
            return true;
        }
    }
}
