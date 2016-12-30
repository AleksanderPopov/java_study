package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_8.composition_challenge;

/**
 * Created by Alex on 10/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        Shelf shelf = new Shelf("wood", new Dimension(10, 10, 5), true);
        TV tv = new TV("Panasonic", true, new Resolution(1364, 768), false);

        BedRoom bedRoom = new BedRoom(shelf, tv);
//        bedRoom.getShelf().getWear();
        bedRoom.getDressed();
    }
}
