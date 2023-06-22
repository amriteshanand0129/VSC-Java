public class Divide_and_Conquer {
     
    // Merge Sort

    // Function for dividing elements of array into smaller elements
    public static void mergesort(int arr[], int si, int ei) {
        if(ei <= si)
            return;
        int mid = si + (ei - si) /2;

        mergesort(arr, si, mid);
        mergesort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    // Function for merging the left and right parts of divided array
    public static void merge(int arr[], int si, int mid, int ei) {

        int temp[] = new int[ei-si+1];

        int i = si;      // Iterator for left part array
        int j = mid+1;   // Iterator for right part array
        int k = 0;       // Iterator for temporary array

        while(i<=mid && j<=ei) {  // Whichever part of array(left/right) (i/j) ends first -> loop ends
            if(arr[i] < arr[j]) 
                temp[k++] = arr[i++];
            else 
                temp[k++] = arr[j++];
        }

        // Leftover elements

        // from the left part array
        while(i<=mid) 
            temp[k++] = arr[i++];

        // from the right part array
        while(j<=ei)
            temp[k++] = arr[j++];

        // copying value of temporaray array into original array    
        for(k = 0, i = si; k<temp.length; k++, i++) 
            arr[i] = temp[k];
    }

    // Quick Sort

    public static void quicksort(int arr[], int si, int ei) {

        if(si >= ei)
            return;
        int pivot = arr[ei];  // Taking last element of array as pivot
        int index = si-1;
        for(int i=si; i<=ei; i++)  {
            if(arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[++index];
                arr[index] = temp;
            }
        }
        quicksort(arr, si, index-1);  // Calling quicksort for left part of pivot index
        quicksort(arr, index+1, ei);  // Calling quicksort for right part of pivot index
    }
    public static void main(String args[]) {

        // Merge Sort
        long startTime = System.currentTimeMillis();
        int arr[] = {6, 3, 9, 5, 2, 8, 8, 1, 85, 0, -5};
    
        System.out.print("Original array 1: ");
        for(int i=0; i<arr.length; i++) 
            System.out.print(arr[i] + " ");

        mergesort(arr, 0, arr.length-1);

        System.out.print("\nSorted array using merge sort: ");
        for(int i=0; i<arr.length; i++) 
            System.out.print(arr[i] + " ");

        // Quick Sort

        int arr2[] = {17,16,15,-11,10,9,-8,7,6,5,4,3,-2,1,0};

        System.out.print("\nOriginal array 2: ");
        for(int i=0; i<arr2.length; i++) 
            System.out.print(arr2[i] + " ");
        
        quicksort(arr2, 0, arr2.length-1);

        System.out.print("\nSorted array using quick sort: ");
        for(int i=0; i<arr2.length; i++) 
            System.out.print(arr2[i] + " ");
        long endTime = System.currentTimeMillis();
        System.out.println("\nTotal time taken = "+ (endTime - startTime) + "ms");
    }
}
