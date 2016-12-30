package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_8.composition_challenge;


/**
 * Created by Alex on 10/11/2016.
 */
public class TV {
    private String make;
    private boolean isColored;
    private Resolution resolution;
    private boolean isOn;

    public TV(String make, boolean isColored, Resolution resolution, boolean isOn) {
        this.make = make;
        this.isColored = isColored;
        this.resolution = resolution;
        this.isOn = isOn;
    }

    public void turnOnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("TV is turned off.");
        } else {
            isOn = true;
            System.out.println("TV is turned on.");
        }
    }
    public String getMake() {
        return make;
    }

    public boolean isColored() {
        return isColored;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public boolean isOn() {
        return isOn;
    }
}
