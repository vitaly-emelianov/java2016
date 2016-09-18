package ru.sbt.homework_02;

/**
 * Created by vitaly on 9/18/16.
 */
public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    /**
     * Person's object constructor.
     * @param man - is person a man
     * @param name - person's name
     */
    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * <p>
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {

    }
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
