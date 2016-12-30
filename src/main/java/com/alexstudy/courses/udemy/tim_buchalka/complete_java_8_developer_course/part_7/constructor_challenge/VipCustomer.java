package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_7.constructor_challenge;

/**
 * Created by Alex on 10/9/2016.
 */

/**
 * Create a new class VipCustomer
 * it should have 3 fields name, credit limit, and email address.
 * create 3 constructors
 * 1st constructor empty should call the constructor with 3 parameters with default values
 * 2nd constructor should pass on the 2 values it receives and add a default value for the 3rd
 * 3rd constructor should save all fields.
 * create getters only for this using code generation of intellij as setters wont be needed
 * test and confirm it works.
 */

public class VipCustomer {
    private String name;
    private String emailAddress;
    private int creditLimit;


    public VipCustomer(String name, String emailAddress) {
        this(name, emailAddress, 5000);
    }
    public VipCustomer(String name, String emailAddress, int creditLimit) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.creditLimit = creditLimit;
    }
}
