import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// Quick Sort
// sorts similar to merge sort
// picks a pivot in the given array and splits the array at the pivot
// everything to the left of the pivot is smaller than the pivot
// everything to the right of the pivot is larger than the pivot
// the pivot itself is in the correct position
// this is more efficient than MergeSort for a couple reasons
    // there is no aux array which we have to transfer items of the array into so less space is used
    // also recursive
    // worst case scenario is easy to avoid by randomizing array (shuffling) and choosing a median for the pivot

public class QuickSort {
    static int steps = 0;

    // auxiliary array for merges
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
       Collections.shuffle(Arrays.asList(a));
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); // Sort right part a[j+1 .. hi].
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi + 1; // left and right scan indices
        Comparable v = a[lo]; // partitioning item

        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            steps++;
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }

        exch(a, lo, j); // put v = a[j] into position

        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].

    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void show(Comparable[] a) { // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

}