package golovatch.courses.collection.labs.eq_toStr_hash;

/**
 * Created by Alex on 12/13/2016.
 */
public class Entity_A {
    private int age;
    private int height;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 31 * (31 * (31 * (name == null ? 0 : name.hashCode()) + height) + age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Entity_A other = (Entity_A) obj;
        if (this.age != other.age
                & this.height != other.height
                & !this.name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Entity_A"
                + "{"
                + "name='" + name + "', "
                + "height='" + height + "', "
                + "age='" + age + "'"
                + "}";
    }
}
