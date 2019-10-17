import java.util.Arrays;
import java.util.Iterator;

/**
 * A person at the UofT.
 */
class Person implements Iterable<String> {

    /**
     * The person's name (family name last).
     */
    private String[] name;
    /**
     * The person's UTORid
     */
    private final String utorid;

    /**
     * Initialize this Person named name with UTORid utorid.
     *
     * @param name   the person's name (family name last)
     * @param utorid the person's UTORid
     */
    Person(String[] name, String utorid) {
        this.name = Arrays.copyOf(name, name.length);
        this.utorid = utorid;
    }

    /**
     * Return a string representation of this person with this format:
     * 'last name, other names: utorid'
     *
     * @return a string representation of this person
     */
    public String toString() {
        return this.formatName() + ": " + this.utorid;
    }

    /**
     * Return the name formatted as a str. The last name is first, then a
     * comma, then the rest of the names.
     *
     * @return the name formatted as a str.
     */
    String formatName() {
        String formattedName = this.name[name.length - 1] + ",";
        int i = 0;
        while (i != this.name.length - 1) {
            formattedName = formattedName + " " + this.name[i];
            i++;
        }

        return formattedName;
    }

    public void changeLastName(String newLast) {
        this.name[this.name.length - 1] = newLast;
    }

    @Override
    public Iterator<String> iterator() {
        return new NameIterator();
    }

    /**
     * Iterate through the names of a Person.
     */
    private class NameIterator implements Iterator<String> {

        /**
         * The index of the next name in Person.name.
         */
        int nextIndex = 0;

        @Override
        public boolean hasNext() {
            // Because class NameIterator is nested inside class Person, NameIterator
            // can access private Person information!
            return nextIndex != name.length;
        }

        @Override
        public String next() {
            return name[nextIndex++];
        }
    }
}