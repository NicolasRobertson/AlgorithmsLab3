public class TestInteger implements Comparable<TestInteger>{

    /*******************************************************
    * Title: Comparable Interface in Java with Example
    * Author: Chaitanya Singh
    * Availability: beginnersbook.com under Java Collectinos
    *******************************************************/
    Integer testInt;
    static long counter;

    TestInteger(Integer test){
        this.testInt = test;
    }

    public void CountComparisons(){
        counter++;
    }
    public void GetCountComparisons(){
        System.out.println("The number of comparisons is " + counter);
    }

    public int compareTo(TestInteger intToCompare){
        int comparison = this.testInt.compareTo(intToCompare.testInt);
        CountComparisons();
        return comparison == 0 ? comparison: testInt;
    }
}
