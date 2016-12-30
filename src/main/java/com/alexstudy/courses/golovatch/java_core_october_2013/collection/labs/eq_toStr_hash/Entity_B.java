package golovatch.courses.collection.labs.eq_toStr_hash;

import java.util.Arrays;

/**
 * Created by Alex on 12/13/2016.
 */
public class Entity_B {
    private final String[][] stringArr;
    private final double[] doubleArr;

    public Entity_B(String[][] stringArr, double[] doubleArr) {
        this.stringArr = stringArr;
        this.doubleArr = doubleArr;
    }

    public String[][] getStringArr() {
        return stringArr;
    }

    public double[] getDoubleArr() {
        return doubleArr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity_B entity_b = (Entity_B) o;

        if (!Arrays.deepEquals(stringArr, entity_b.stringArr)) return false;
        return Arrays.equals(doubleArr, entity_b.doubleArr);
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(stringArr);
        result = 31 * result + Arrays.hashCode(doubleArr);
        return result;
    }

    @Override
    public String toString() {
        return "Entity_B{" +
                "stringArr=" + Arrays.deepToString(stringArr) +
                ", doubleArr=" + Arrays.toString(doubleArr) +
                '}';
    }
}
