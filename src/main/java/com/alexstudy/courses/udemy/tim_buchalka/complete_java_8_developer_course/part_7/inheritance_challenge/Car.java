package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_7.inheritance_challenge;

/**
 * Created by Alex on 10/9/2016.
 */
public class Car extends Vehicle {
    protected int passangersCount;
    protected int doorsCount;
    protected Category carCategory;
    protected PricePolicy pricePolicy;
    protected int maxSpeed;

    protected enum Category { A, B, C, D, E}
    protected enum PricePolicy {LOW, MIDDLE, HIGTH}
}


