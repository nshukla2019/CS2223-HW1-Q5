import java.util.stream.IntStream;
import java.lang.Integer;
import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // randomized integer array
        int[] primitiveA = IntStream.generate( () -> new Random().nextInt(1000)).limit(100).toArray();

        // putting primitiveA in an Integer[]
        Integer[] a = Arrays.stream(primitiveA).boxed().toArray(Integer[]::new);

        // when running, comment out two out of the three sorting algorithms
        // to run each algorithm with a randomized array with a specific input

        // for example: to test QuickSort with an input size of 100
        //      change to limit(100) above
        //      comment out BubbleSort and MergeSort and run
        // then to compare BubbleSort's steps with an input size of 100 to QuickSort
        // comment out QuickSort and MergeSort and run just BubbleSort


        QuickSort.sort(a);
        QuickSort.show(a); // display sorted list
        System.out.format("Quick Sort Steps: %d\n", QuickSort.steps);

       /*
        BubbleSort.sort(a);
        BubbleSort.show(a); // display sorted list
        System.out.format("Bubble Sort Steps: %d\n", BubbleSort.steps);
       */

        /*
         MergeSort.sort(a);
         MergeSort.show(a); // display sorted list
         System.out.format("Merge Sort Steps %d\n", MergeSort.steps);
        */

    }


}
