public class SelectionSort {
    public static void main(String args[]) {
        int arr[] = {5, 2, 8, 3, 6, 4};
        int min, index = 0;
        for(int i=0; i<arr.length-1; i++) {
            min = arr[i];
            index = i;
            for(int j=i; j<arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
    }
    for(int i: arr)
        System.out.println(i);
    }
}
