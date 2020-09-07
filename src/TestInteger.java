public class TestInteger implements Comparable<TestInteger>{

    /*******************************************************
    * Title: Comparable Interface in Java with Example
    * Author: Chaitanya Singh
    * Availability: beginnersbook.com under Java Collectinos
    *******************************************************/

    /*Establish Variables*/
    Integer testInt;
    static long counter;

    /*Constructor*/
    TestInteger(Integer test){
        this.testInt = test;
    }

    /*Comparison Counter*/
    public void CountComparisons(){
        counter++;
    }

    /*Methods for comparison counter*/
    public static void GetCountComparisons(){
        System.out.println("Comparisons: " + counter);
    }
    public static void ResetCountComparisons(){
        counter = 0;
    }

    /*Returns int value of TestInteger*/
    public int toInt(){
        return testInt.intValue();
    }

    /*Compares TestIntegers*/
    public int compareTo(TestInteger intToCompare){
        int comparison;
        CountComparisons();

        if(testInt.intValue() <= intToCompare.toInt()){ comparison = 0; }
        else {comparison = 1; }

        return comparison;
    }
}
