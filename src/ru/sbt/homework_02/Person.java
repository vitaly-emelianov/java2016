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
     *
     * @param man  - is person a man
     * @param name - person's name
     */
    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
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
        if (man && !person.man) {
            if (spouse != null && spouse.getName().equals(person.name)) {
                return false;
            } else {
                if (spouse != null) {
                    spouse.divorce();
                }
                if (person.getSpouse() != null) {
                    person.getSpouse().divorce();
                }
                this.spouse = person;
                person.spouse = this;
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (getSpouse() == null) {
            return false;
        } else {
            this.spouse = null;
            return true;
        }
    }

    public static void main(String[] args) {
        Person jack = new Person(true, "Jack");
        Person ann = new Person(false, "Ann");
        Person john = new Person(true, "John");
        Person walter = new Person(true, "Walter");
        Person amy = new Person(false, "Amy");

        System.out.println(jack.marry(ann));
        System.out.println(jack.marry(amy));
        System.out.println(jack.getSpouse());
        System.out.println(amy.getSpouse().getName());
        System.out.println(ann.getSpouse() == null);

        
        System.out.println(ann.marry(walter));
        System.out.println(walter.getSpouse().getName());
//        System.out.println(ann.getSpouse().getName());

    }
}
