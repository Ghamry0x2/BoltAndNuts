package boltsandnuts;
import java.util.HashMap;

public class BoltsAndNuts {
    public static void main(String[] args) {
        char nuts[] = {'*', '$', '%', '&', '!', '#', '^', '@'}; 
        char bolts[] = {'!', '#', '%', '@', '*', '$', '&', '^'}; 
  
        ////----------Quick Sort//----------
        match(nuts, bolts, 0, nuts.length-1); 
        
        ////----------Merge Sort//----------
//        sort(nuts, 0, nuts.length-1);
//        sort(bolts, 0, nuts.length-1);

        ////----------Hashmap//----------
//        hashMap(bolts, nuts);
        
        System.out.println("Matched nuts and bolts are : "); 
        printArray(nuts); 
        printArray(bolts); 
    }
    
    private static void printArray(char[] arr) { 
        for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " "); 
        } 
        System.out.print("\n"); 
    } 
    
    
    //----------HashMap Method----------
    
    private static void hashMap(char[] bolts, char[] nuts){
        HashMap<Character, Integer> map = new HashMap();
        
        for (int i = 0; i < nuts.length; i++) {
            map.put(nuts[i], i);
        }
        
        for (int i = 0; i < bolts.length; i++) {
            if( map.get(bolts[i]) != null ){
                nuts[i] = bolts[i];
            }
        }
    }
 
    //----------QuickSort Method----------
    private static void match(char[] nuts, char[] bolts, int low, int high) { 
        if (low < high) { 
            int pivot = partition(nuts, low, high, bolts[high]); 

            partition(bolts, low, high, nuts[pivot]); 
  
            match(nuts, bolts, low, pivot-1); 
            match(nuts, bolts, pivot+1, high); 
        } 
    }
    
    private static int partition(char[] arr, int low, int high, char pivot) { 
        int i = low; 
        char temp1, temp2; 
        printArray(arr);
        System.out.println(arr[low] + "\t" + arr[high] + "\t" + pivot);
        for (int j = low; j < high; j++) { 
            if (arr[j] < pivot){ 
                temp1 = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp1; 
                i++; 
            } 
            else if(arr[j] == pivot){ 
                temp1 = arr[j]; 
                arr[j] = arr[high]; 
                arr[high] = temp1; 
                j--; 
            } 
        } 
        temp2 = arr[i]; 
        arr[i] = arr[high]; 
        arr[high] = temp2; 
        
        return i; 
    }
    
    //----------MergeSort Method----------
    private  static void merge(char arr[], int l, int m, int r) { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        char L[] = new char [n1]; 
        char R[] = new char [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    private static void sort(char arr[], int l, int r) { 
        if (l < r) { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    }
}