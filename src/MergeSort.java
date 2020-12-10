public class MergeSort {

    // merge sort
    // sorts by splitting the entire array into halves and keeps doing this until
    // each item is singled out (size = 1)
    // then the merge comes into action where the single items are compared against each other and then merged
    // because merge sort has to single out each item and compare each item regardless of size
        // the number of steps is the same

    static int steps = 0;

    // auxiliary array for merges
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // allocate space just once
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2; // find middle of array
        sort(a, lo, mid); // left half is sorted
        sort(a, mid + 1, hi); // right half is sorted
        merge(a, lo, mid, hi); // merge the two sorted arrays
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi]

        int i = lo, j = mid + 1;
        Comparable[] aux = new Comparable[a.length];

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; // copy a[lo..hi] to aux[lo..hi] for each k in for loop
        }
        for (int k = lo; k <= hi; k++) { // merge back to a[lo..hi].
            steps++;
            if (i > mid) {
                a[k] = aux[j++];
            }
            else if (j > hi) {
                a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }

        }
    }

    // this is how to compare Comparable types
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // prints the sorted array on one line
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
