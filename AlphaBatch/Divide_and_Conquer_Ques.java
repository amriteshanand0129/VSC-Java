public class Divide_and_Conquer_Ques {

    // Sorting String array using Merge Sort
    public static void sort(String arr[], int si, int ei) {
        if(si >= ei) 
            return;
        int mid = si + (ei - si) / 2;
        sort(arr, si, mid);
        sort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }
    public static void merge(String arr[], int si, int mid, int ei) {
        int i = si;
        int j = mid+1;
        int k = 0;
        String temp[] = new String[ei-si+1];
        while(i<=mid && j<=ei) {
            if(arr[i].compareTo(arr[j]) <= 0) 
                temp[k++] = arr[i++];
            else 
                temp[k++] = arr[j++];
        }
        while(i<=mid)
            temp[k++] = arr[i++];
        while(j<=ei)
            temp[k++] = arr[j++];
        
        for(int a=si, l=0; l<temp.length; a++, l++) {
            arr[a] = temp[l];
        }
    }

    // Finding the majority element
    public static void majority(int nums[], int count[], int si, int ei) {
        if(si>=ei)
            return;
        count[nums[si++]]++;
        majority(nums, count, si, ei);
    }

    public static void sorting(int arr[], int si, int ei) {
        if(si>=ei) {
            return;
        }
        int pivot = arr[ei];
        int iterator = si-1;
        int i = si;
        while(i<=ei) {
            if(arr[i] <= pivot) {
                int temp = arr[++iterator];
                arr[iterator] = arr[i];
                arr[i] = temp;
            }
            i++;
        }
        sorting(arr, si, iterator-1);
        sorting(arr, iterator+1, ei);
    }

    public static void main(String args[]) {

        // Question 1
        String arr[] = {"sun", "earth", "mars", "mercury", "uranus", "neptune", "pluto", "venus", "jupiter", "saturn"};
        sort(arr, 0, arr.length-1);
        System.out.println("\nSorted array: ");
        for(int i=0; i<arr.length; i++) 
            System.out.print(arr[i] + "  ");

        // Question 2
        int nums[] = {2, 2, 1, 1, 1, 2, 2};
        int count[] = new int[109];
        majority(nums, count, 0, nums.length);
        System.out.println("\n\nMajority Elements are: ");
        for(int i=0; i<count.length; i++) 
            if(count[i] > (nums.length)/2)
                System.out.print(i + " ");
        
        // Question 3
        int array[] = {2, 4, 1, 3, 5};
        sorting(array, 0, array.length-1);
        for(int i=0; i<array.length; i++) 
            System.out.print(array[i] + "  ");
    }
}
