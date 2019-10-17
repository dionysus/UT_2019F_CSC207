import java.util.Iterator;

public class Main {

    // This is the entry point to the program.
    public static void main(String[] args) {

        String[] name = {"First", "Middle", "Last"};
	    Person p1 = new Person(name, "moogah");
        System.out.println(p1);

        // Does this design make sense? What are the alternatives?
        // Would it make more sense to make a Name class that's iterable?

        // Notice the variable type is an interface and generic.
        Iterator<String> iter = p1.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // Want to iterate over the names in p1.
        // for each name n1 in p1:
        //     for each name n2 in p1:
        //          print(n1 + " " + n2)

        // Because Person implements Iterable, we can use the foreach loop.
        // This does magic to create an iterator and call hasNext and next.
        // Notice that the nested loop creates a new NameIterator on each
        // of the outer iterations.
        for (String n1 : p1) {
            for (String n2 : p1) {
                System.out.println(n1 + " " + n2);
            }
        }

    }
}