// src/Sorting.java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        // Example: sort a list of strings (ascending, then descending)
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "Dave"));
        System.out.println("Original names: " + names);

        Collections.sort(names); // ascending (natural order)
        System.out.println("Sorted names (ascending): " + names);

        names.sort(Comparator.reverseOrder()); // descending
        System.out.println("Sorted names (descending): " + names);

        // Example: sort a list of integers (ascending, then descending)
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 1, 4, 3, 2));
        System.out.println("Original numbers: " + numbers);

        Collections.sort(numbers); // ascending
        System.out.println("Sorted numbers (ascending): " + numbers);

        numbers.sort(Comparator.reverseOrder()); // descending
        System.out.println("Sorted numbers (descending): " + numbers);
    }
}
