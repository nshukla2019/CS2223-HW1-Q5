public class BubbleSort{
    static int steps = 0;

    // Bubble Sort
    // sorts by taking two pairs and comparing them to each other
    // if the right int is smaller than the left int
        // use exch to swap the places of the two ints so they are in the correct order
        // sets swapped to true
    // then moves to the next pair and repeats
    // uses double nested loop to compare 2 pairs

    public static void sort(Comparable[] a)
    {
        boolean swapped;
        for(int i = a.length; i > 1; i--) {
            swapped = false; // base case
            for(int j = 1; j < i; j++) {
                steps++;
                if (a[j-1].compareTo(a[j]) > 0) { // left element is larger than right
                    // swap the two elements
                    exch(a, j, j-1);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    // Print the array on a single line
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // exchange two ints (switch places)
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}










