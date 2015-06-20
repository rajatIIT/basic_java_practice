package basicLanguageCommand;

import java.util.HashMap;
import java.util.Iterator;

public class basicQuestions {

    public basicQuestions() {

        int A[] = null;
        checkNull(A);

        byte c1 = 0b1100;
        byte c2 = 0b0100;
        int c3 = c1 ^ c2;
        System.out.println(Integer.toBinaryString(c3));
        System.out.println(reverseString("rajat"));
        System.out.println(maxSum(new int[] { 1, 2, 3, 4, 5, 6 }));
        System.out.println(checkSum(new int[] { 1, 2, 3, 4, 5, 6 }, 7));
        printMajority(new int[] { 2, 2, 2, 2, 5, 6 });
    }

    /**
     * 
     */
    public String reverseString(String inputString) {

        char[] stringArray = inputString.toCharArray();

        for (int i = 0; i < (stringArray.length / 2); i++) {
            char swap = stringArray[stringArray.length - i - 1];
            stringArray[stringArray.length - i - 1] = stringArray[i];
            stringArray[i] = swap;
        }

        return (new String(stringArray));
    }

    /**
     * 
     */
    /**
     * maximum sum problem : detect the maximum sum of any two numbers in an
     * array.
     * 
     * @param inputArray
     * @return
     */
    public int maxSum(int[] inputArray) {
        if (!(inputArray == null)) {
            int maxElement;
            int secondMaxElement;
            if (inputArray.length > 1) {
                if (inputArray[0] > inputArray[1]) {
                    maxElement = inputArray[0];
                    secondMaxElement = inputArray[1];
                } else {
                    maxElement = inputArray[1];
                    secondMaxElement = inputArray[0];
                }

                for (int i = 2; i < inputArray.length; i++) {

                    int tempMax1 = selectMax(maxElement, secondMaxElement, inputArray[i]);
                    System.out.println("Choose 1: " + maxElement);

                    int tempMax2 = selectSecondMax(maxElement, secondMaxElement, inputArray[i]);
                    System.out.println("Choose 2: " + secondMaxElement);

                    maxElement = tempMax1;
                    secondMaxElement = tempMax2;
                }

                System.out.println(maxElement + " " + secondMaxElement);
                return (maxElement + secondMaxElement);
            } else {
                // throw new Exception(“Input Array does not even contain two
                // elements! ”);
                System.exit(0);
                return 0;
            }

        } else {
            System.out.println("The input Array is null.");
            return 0;
        }
    }

    private int selectSecondMax(int maxElement, int secondMaxElement, int i) {

        if (maxElement >= secondMaxElement) {
            if (maxElement >= i) {
                if (i >= secondMaxElement)
                    return i;
                else {
                    // i<secondMaxelement
                    return secondMaxElement;
                }
            } else {
                // maxElement<i
                return maxElement;
            }
        } else {
            // maxElement<secondMaxElement
            if (i <= maxElement)
                return maxElement;
            else {
                // i>maxElement
                if (i <= secondMaxElement)
                    return i;
                else {
                    // i>secondMaxElement
                    return secondMaxElement;
                }

            }
        }

    }

    private int selectMax(int maxElement, int secondMaxElement, int i) {
        if (maxElement >= secondMaxElement) {
            if (maxElement >= i)
                return maxElement;
            else {
                // maxElement<i
                return i;
            }
        } else {
            // maxElement<secondMaxElement
            if (i <= maxElement)
                return secondMaxElement;
            else {
                // i>maxElement
                if (i <= secondMaxElement)
                    return secondMaxElement;
                else {
                    // i>secondMaxElement
                    return i;
                }

            }
        }

    }

    /**
     * Given an array A[] and a number x, check for pair in A[] with sum as x
     * 
     * @param A
     * @param sum
     * @return
     */
    public boolean checkSum(int[] A, int sum) {

        if (A.length < 2) {
            System.out.println("Array does not have even two elements!  Can’t proceed.");
            // TODO: handleThisError();
        } else {

            // create hashMap with values as number of occurrences of the key.
            HashMap<Integer, Integer> arrayMap = createHashMap(A);
            for (int i = 0; i < A.length; i++) {
                int difference = sum - A[i];
                if (difference == A[i]) {
                    if (arrayMap.containsKey(difference)) {
                        if (arrayMap.get(difference) >= 2)
                            System.out.println("Found a pair ! (" + difference + "," + difference
                                    + "). ");
                        return true;
                    }
                } else {
                    if (arrayMap.containsKey(difference))
                        System.out.println("Found a pair ! (" + difference + "," + A[i] + ").");
                    return true;
                }
            }

            // of reach entry in hashMap, search for the sum

        }
        return false;
    }

    public HashMap createHashMap(int[] A) {

        HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (intMap.containsKey(A[i]))
                intMap.put(A[i], intMap.get(A[i]) + 1);
            else
                intMap.put(A[i], 1);
        }
        return intMap;
    }

    /**
     * Write a function which takes an array and emits the majority element (if
     * it exists), otherwise prints NONE .
     * 
     * @param A
     */
    public void printMajority(int[] A) {
        // use input validation
        if (A.length > 0) {
            int majorityCount = (A.length / 2 + 1);
            HashMap<Integer, Integer> intMap = createHashMap(A);
            Iterator<Integer> intMapIterator = intMap.keySet().iterator();
            boolean majorityFound = false;
            while (intMapIterator.hasNext()) {
                int nextElement = intMapIterator.next();
                if (intMap.get(nextElement) >= majorityCount) {
                    System.out.println("Has a majority element: " + nextElement);
                    majorityFound = true;
                }
            }
            if (!majorityFound)
                System.out.println("No majority element in the array!");
        } else {
            System.out.println("Wither Array is null or of size zero.");
        }
    }

    public void checkNull(int[] A) {
        if (A == null)
            System.out.println("This is a null array.");
        if (!(A==null) && A.length == 0)
            System.out.println("The length is 0");
    }

}
