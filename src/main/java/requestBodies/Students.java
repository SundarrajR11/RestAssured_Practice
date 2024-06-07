package requestBodies;

import java.util.List;

public class Students {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isPassed;
    private List<Integer> marks;
    private List<Addresses> addresses;


    public void setAddresses(List<Addresses> addresses){
        this.addresses=addresses;
    }

    public List<Addresses> getAddresses() {
        return addresses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

}
