import java.util.Arrays;

public class Client {
    public static void main(String args[]){

        int[] arr = {2,1,3,7,6,4,8,5};

        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] intArray, int p, int r){
        if(p < r){
            int q = partition(intArray, p, r);
            
            quickSort(intArray, p, q-1);
            quickSort(intArray, q+1, r);
        }
    }
    public static int partition(int[] intArray, int p, int r){
        int x = intArray[r];
        int i = p - 1;
        for(int j = p; j < r-1; j++){
            if (intArray[j] <= x) {
                i = i + 1;
                exchange(intArray, i, j);
            }
        }
        exchange(intArray, i+1, r);
        return i + 1;
    }
    public static void exchange(int[] intArray, int indexA, int indexB){
        int temp = intArray[indexA];

        intArray[indexA] = intArray[indexB];
        intArray[indexB] = temp;
    }
}
