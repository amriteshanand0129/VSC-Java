public class Search_Rotated {

    // Searching for an element in a rotated and sorted array

    public static int search(int arr[], int si, int ei, int target) {
        int mid = si + (ei - si)/2;

        // Target found
        if(arr[mid] == target) 
            return mid;

        // Target not found in array
        if(si>=ei)
            return -1;

        // Mid lies on line 1
        if(arr[mid] >= arr[si]) {

            // Target is on the left of line 1
            if(arr[si] <= target && target <= arr[mid]) 
                return search(arr, si, mid-1, target);

            // Target is on the right of mid including line 1 and line 2
            else
                return search(arr, mid+1, ei, target);
        }

        // Mid lies on line 2
        else {

            // Target is on the right of line 2
            if(arr[ei] >= target && target >= arr[mid]) 
                return search(arr, mid+1, ei, target);
            
            // Target is on the left of mid including line 1 and line 2
            else    
                return search(arr, si, mid-1, target);
        }
    }
    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Required index is " +  search(arr, 0, arr.length-1, 9));
    }
}
