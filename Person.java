import java.io.Serializable;

public class Person implements Serializable {
    String name;
    int age;
    Address address;
    String CNIC;

    Person (){
        address = new Address();
    }

    public Person(String CNIC,String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.CNIC = CNIC;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", CNIC=" + CNIC +
                '}';
    
    }

    public static boolean isCNICValid(String cnic) {
        boolean check = true;
        if (cnic.length() == 13) {
            for (int i = 0; i < cnic.length(); i++) {
                if (!Character.isDigit(cnic.charAt(i))) {
                    check = false;
                    break;
                }
            }
        }
        else {
            check = false;
        }
        return check;
    }



    public static boolean isAgeValid(int age){
        boolean check = true;
        if (age > 18) {
            check = true;
        }
        else {
            check = false;
        }
        return check;
    }
}
