package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_9.arraylist_challenge;

/**
 * Created by Alex on 10/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.addContact(new Contact<>("Marina", "02"));
        book.addContact(new Contact<>("Alex", "03"));
        book.addContact(new Contact<>("Zenya", "04"));
        book.printContacts();
    }
}
