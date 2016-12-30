package golovatch.courses.collection;

import java.util.TreeSet;

/**
 * Created by Alex on 12/13/2016.
 */
public class TreeSetDemo {
    public static void main(String[] args) {

        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("B"));
        treeSet.add(new Person("A"));
        treeSet.add(new Person("D"));
        treeSet.add(new Person("C"));
        System.out.println(treeSet);
    }

    static class Person implements Comparable<Person> {
        String name;

        public Person(String name) {
            this.name = name;
        }


        @Override
        public int compareTo(Person o) {
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            return name != null ? name.equals(person.name) : person.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
