package HW5;

public class Sort {

	public static void MergeSort(int[] input) {
		MergeSorter(input,input[0],input[input.length-1]);
	}
	
	public static void MergeSorter(int[] inputarray, int left, int right)
	   {
		
	      if(left < right)
	      {
	         int middle = (left + right) / 2;
	         MergeSorter(inputarray, left, middle);
	         MergeSorter(inputarray , middle+1, right);
	         MergersortMerger(inputarray, left, middle, right);
	      }
	   }
	
	public static void MergersortMerger(int inputarray[], int left, int middle, int right) {
		 int i, j, k; 
		    int leftarray[]=new int[middle-left+1];
		    int rightarray[]=new int[right-middle];
		    for (i = 0; i < middle-left+1; i++)
		    leftarray[i] = inputarray[left + i];
		    for (j = 0; j < right-middle; j++)
		        rightarray[j] = inputarray[middle + 1 + j];
		    i = 0;  
		    j = 0; 
		    k = left; 
		    for (k=left;i < middle-left+1 && j < right-middle;k++) 
		    {
		        if (leftarray[i] > rightarray[j]) inputarray[k] = leftarray[i++];
		        else inputarray[k] = rightarray[j++];
		    }
		    while (i < middle-left+1) 
		    	inputarray[k++] = leftarray[i++];
		    while (j < right-middle) 
		    	inputarray[k++] = rightarray[j++];
		}
	
	public static void QuickSort(int[] input) {
		QuickSorter(input,input[0],input[input.length-1]);
	}
	
	public static void QuickSorter(int[] inputarray, int left, int right) {
		 if (left <right) {
		        int part = QuickSortParter(inputarray, left, right);
		        QuickSorter(inputarray, left, part-1);
		        QuickSorter(inputarray, part+1, right);
		    }
	}
	
	public static int QuickSortParter(int[] inputarray, int left, int right) {
	    int middle = inputarray[right];
	    int i = left;
	    for (int j = right; j>= left; j--) {
	        if (inputarray[j] > middle) {
	            int temp = inputarray[i];
	            inputarray[i] = inputarray[j];
	            inputarray[j] = temp;
	            
	            i = i+1;
	        }
	    }
	    int temptwo = inputarray[i];
	    inputarray[i] = inputarray[right];
	    inputarray[right] = temptwo;
	    return i;
	}
	
	public static void InsertionSort(int[] input) {
		        for (int i = 1; i < input.length; i++) {
		            int sorter = input[i];
		            int j = i;
		            while (j > 0 && input[j - 1] > sorter) {
		                input[j] = input[j - 1];
		                j--;
		            }
		            input[j] = sorter;
		        }
	}
	
	 public static void upgradedQuickSort(int [] input, int k, int d)                            
	    {
	        while (k<d)
	        {
	            if (d-k<input.length)
	            {
	                QuickSorter(input, k, d);
	                break;
	            }
	            else
	            {
	                int pivot = QuickSortParter(input, k, d);
	                if (pivot - k < pivot - d)
	                {
	                    upgradedQuickSort(input, k, pivot - 1);
	                    k = pivot + 1;
	                }
	                else
	                {
	                    upgradedQuickSort(input, pivot + 1, d);
	                    d = pivot - 1;
	                }
	            }
	        }
	}
}
	
	
	

