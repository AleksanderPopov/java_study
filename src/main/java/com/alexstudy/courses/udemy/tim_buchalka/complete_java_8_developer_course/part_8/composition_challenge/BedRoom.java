package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_8.composition_challenge;

/**
 * Created by Alex on 10/11/2016.
 */
public class BedRoom {
    private Shelf shelf;
    private TV tv;

    public BedRoom(Shelf shelf, TV tv) {
        this.shelf = shelf;
        this.tv = tv;
    }

    public void getDressed() {
        tv.turnOnOff();
        shelf.getWear();
        dressWear();
        System.out.println("I'm ready to go");
        tv.turnOnOff();
    }

    private void dressWear() {
        System.out.println("Wearing the new dress.");
    }
}
