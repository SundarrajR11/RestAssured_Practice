package requestBodies;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;


public class Addresses {
    private int block;
    private String street;

    public Addresses() {
    }

    public Addresses(int block, String street) {
        this.block = block;
        this.street = street;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
