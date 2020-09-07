import java.util.Arrays;
import java.util.Random;

public class Client {
    public static void main(String args[]){

        System.out.println("<Generate random integers>");
        TestInteger[] test = GenerateRandomTestIntegers();
        performTest(test);

        System.out.println("<Generate increasing integers>");
        test = GenerateIncreasingTestIntegers();
        performTest(test);

        System.out.println("<Generate 10 sets of 1000 ordered integers>");
        test = GenerateTenOrderedTestIntegerArrays();
        performTest(test);

        System.out.println("<Generate 100 sets of 100 ordered integers>");
        test = GenerateOneHundredOrderedTestIntegerArrays();
        performTest(test);

    }

    /*Quicksort algorithm*/
    public static void quickSort(TestInteger[] intArray, int p, int r){
        if(p < r){
            int q = partition(intArray, p, r);
            
            quickSort(intArray, p, q-1);
            quickSort(intArray, q+1, r);
        }
    }
    public static int partition(TestInteger[] intArray, int p, int r){
        TestInteger x = intArray[r];
        TestInteger i = new TestInteger(p - 1);
        for(int j = p; j < r-1; j++){
            if (intArray[j].compareTo(x) == 0) {
                i = new TestInteger(i.toInt() + 1);
                exchange(intArray, i.toInt(), j);
            }
        }
        exchange(intArray, i.toInt()+1, r);
        return i.toInt() + 1;
    }
    public static void exchange(TestInteger[] intArray, int indexA, int indexB){
        TestInteger temp = intArray[indexA];

        intArray[indexA] = intArray[indexB];
        intArray[indexB] = temp;
    }

    /*Perform test of efficiency for quicksort and timesort*/
    public static void performTest(TestInteger[] testArray){
        TestInteger[] quickSortTest = testArray;
        TestInteger[] timSortTest = testArray;

        quickSort(quickSortTest, 0, quickSortTest.length-1);
        System.out.println("Quicksort ");
        TestInteger.GetCountComparisons();
        TestInteger.ResetCountComparisons();

        Arrays.sort(timSortTest);
        System.out.println("Timsort ");
        TestInteger.GetCountComparisons();
        TestInteger.ResetCountComparisons();

        System.out.println();
    }

    /*Print out TestInteger arrays to make sure they're generating properly and being sorted*/
    public static void printTestIntegerArray(TestInteger[] arrayToPrint){
        for(int i=0; i<arrayToPrint.length;i++){
            System.out.println(arrayToPrint[i].toInt());
        }
    }

    /*Methods for Generating Test Integer Arrays*/
    public static TestInteger[] GenerateRandomTestIntegers(){
        TestInteger[] ArrayTestIntegers = new TestInteger[10000];
        Random rand = new Random();

        for(int i=0; i<10000; i++){
            TestInteger testInt = new TestInteger(rand.nextInt(1000000));
            ArrayTestIntegers[i] = testInt;
        }

        return ArrayTestIntegers;
    }
    public static TestInteger[] GenerateIncreasingTestIntegers(){
        TestInteger[] ArrayTestIntegers = new TestInteger[10000];

        for(int i=0; i<10000; i++){
            TestInteger testInt = new TestInteger(i);
            ArrayTestIntegers[i] = testInt;
        }

        return ArrayTestIntegers;
    }
    public static TestInteger[] GenerateTenOrderedTestIntegerArrays(){
        TestInteger[] ArrayTestIntegers = new TestInteger[10000];
        Random rand = new Random();
        int value = 0;

        for(int i=0; i<10000; i++){
            if(i%1000 == 0){
                value = rand.nextInt(1000000);
            }
            TestInteger testInt = new TestInteger(value);
            ArrayTestIntegers[i] = testInt;
            value++;
        }

        return ArrayTestIntegers;
    }
    public static TestInteger[] GenerateOneHundredOrderedTestIntegerArrays(){
        TestInteger[] ArrayTestIntegers = new TestInteger[10000];
        Random rand = new Random();
        int value = 0;

        for(int i=0; i<10000; i++){
            if(i%100 == 0){
                value = rand.nextInt(1000000);
            }
            TestInteger testInt = new TestInteger(value);
            ArrayTestIntegers[i] = testInt;
            value++;
        }

        return ArrayTestIntegers;
    }
}
