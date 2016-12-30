package golovatch.courses.exception.labs;

/**
 * Created by Alex on 7/31/2016.
 */
public class lab_1 {
    public static void main(String[] args) {
        //nulpointer
        //runtime
        //IOex
        //error
        //do nothing
        System.out.println(0);
        try {
            System.out.println(1);
            if (true) ;
            System.out.println(2);

        } catch (NullPointerException e) {
            System.out.println(3);
            if (true) ;
            System.out.println(4);
        } catch (RuntimeException e) {
            System.out.println(5);
            if (true) ;
            System.out.println(6);
        } catch (Exception e) {
            System.out.println(7);
            if (true) ;
            System.out.println(8);

        } finally {
            System.out.println(9);
            if (true) ;
            System.out.println(10);
        }
        System.out.println(11);
    }
    /*
    * possible traces:
    * 0139Ex
    * 013910Ex
    * 01349Ex
    * 0134910Ex
    *
    * 0179Ex
    * 0179E10x
    * 01789Ex
    * 01789E10x
    *
    * 0159Ex
    * 015910Ex
    * 01569Ex
    * 0156910Ex
    *
    * 019Ex
    * 01910Ex
    *
    * 0129Ex
    * 01291011
    */
}
