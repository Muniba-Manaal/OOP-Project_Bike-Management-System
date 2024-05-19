import java.io.Serializable;

public class Address implements Serializable {
    String homeNumber;
    String street;
    String city;

    Address(){}

    Address(String homeNumber, String street, String city) {
        this.homeNumber = homeNumber;
        this.street = street;
        this.city = city;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "homeNumber='" + homeNumber + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
