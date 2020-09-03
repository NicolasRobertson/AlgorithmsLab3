import java.util.Arrays;

public class Client {
    public static void main(String agrs[]){

        int[] arr = {2,1,3,7,6,4,5};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public void quickSort(int[] intArray, int l, int r){
        if(l < r){
            int q = partition(intArray, l, r);
            quickSort(intArray, l, q-1);
            quickSort(intArray, q+1, r);
        }
    }
    public int partition(int[] intArray, int l, int r){
        int x = intArray[r];
        int i = l - 1;
        for(int j =l; j < r-1; j++){
            if (intArray[j] <= x) {
                i = i + 1;
                exchange(intArray, l, j);
            }
            exchange(intArray, l-1, r);
            return i + 1;
        }
        return 0;
    }
    public void exchange(int[] intArray, int indexA, int indexB){
        int temp = intArray[indexA];

        intArray[indexA] = intArray[indexB];
        intArray[indexB] = temp;
    }
}
