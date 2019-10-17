public class Student extends Person {
    /**
     * This student's student number.
     */
    private final String studentNumber;

    /**
     * Initialize this Student named name with UTORid utorid and
     * student number stuNum.
     *
     * @param name   the person's name (family name last)
     * @param utorid the person's UTORid
     */
    Student(String[] name, String utorid, String stuNum) {
        super(name, utorid);
        this.studentNumber = stuNum;
    }

    /**
     * Return this student's student number.
     *
     * @return the student number.
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.studentNumber;
    }
}