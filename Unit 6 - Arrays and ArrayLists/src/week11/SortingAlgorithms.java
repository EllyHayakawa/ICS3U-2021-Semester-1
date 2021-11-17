package week11;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {30, 20, 5, 70, 90, 85, 10};

        selectionSort(arr);
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j;
            for(j = i; j > 0 && temp < arr[j - 1]; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    //the selectionSort must always run through ALL of its code, so it is not faster even if the array is already sorted
    private static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){ //division between sorted and unsorted side
            int smallestIndex = i;
            for(int j = i + 1; j < arr.length; j++){ //select the smallest element on the unsorted side
                if(arr[j] < arr[smallestIndex])
                    smallestIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }
}
