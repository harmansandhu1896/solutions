import java.util.Arrays;

public class Stroke {

    public static void main(String[] args) {
        int[] arr = {5,1,4,5,3};
        int maxHeight = getMaximum(arr);
        System.out.println(getMinimumStrokes(arr, maxHeight));
    }
// getting max value to get number of times we need to loop, to use the outer loop to go along y axis.
    public static int getMaximum(final int[] arr) {
        int max = 0;
        for (int i : arr) {

            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public static int getMinimumStrokes(final int[] arr, final int maxHeight) {

        int[] tempArray = Arrays.copyOf(arr, arr.length);

        int stroke = 0;

        boolean isEmptyArea;

        boolean isFirstPositiveInteger;

        for (int i = 0; i < maxHeight; i++) {

            stroke++; // setting the first stroke


            isEmptyArea = false;
            isFirstPositiveInteger = true;
            int arrayLength = tempArray.length;

            for (int j = 0; j < arrayLength; j++) { //iterating through the values of array

              System.out.println("inside j loop "+isEmptyArea+" "+isFirstPositiveInteger+" array value "+tempArray[j]+" i= "+i+" stroke ="+stroke);

                if (tempArray[j] == 0) { //if the value is zero that means the area is empty that sets the boolean true for next iteration that
                    // would satisfy the condition that new stroke is required as area is empty and new int is present there.

                    isEmptyArea = true;

                }

                else
                    {

                    if (isEmptyArea && (tempArray[j] != 0)) { // checking if new stroke is required by checking if empty
                        // area is true and checking if value of temp array is positive integer.

                        if (!isFirstPositiveInteger) {// to see if we hit any non positive area to start the stroke again act as first integer

                            stroke++;

                        }
                        isEmptyArea = false;// as here now we have started the stroke now we know we are in the area and already started the stroke.
                    }

                    tempArray[j] = tempArray[j] - 1;// negating each value of array elements as we are traversing each row as if we have already scanned it.

                    isFirstPositiveInteger = false;// here we are changing the integer status to be false as its not a first integer now

                    }
            }
        }

        return stroke;
    }

}
