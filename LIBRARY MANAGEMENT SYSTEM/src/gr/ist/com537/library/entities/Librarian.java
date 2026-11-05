package gr.ist.com537.library.entities;


public class Librarian extends Person {

    public Librarian(String name, String subName, String email, String password, String address, String phoneNumber) {
        super(name, subName, email, password, address, phoneNumber);
    }


    public String printInfo() {

        return "Name: " + getName() + "\n" +
                "Subname: " + getSubName() + "\n" +
                "email: " + getEmail() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Phone_Number: " + getPhoneNumber() + "\n" +
                '}';
    }

}
