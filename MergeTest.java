package application;

public class MergeTest {
	/**
	 * merge method
	 * 
	 * This method takes the two integer array as a parameter and creates a new
	 * array out of these with sorted array and returns the new array 
	 * 
	 * @param 	a1 	array of integers 
	 * @param 	a2	array of integers
	 * 
	 * @return	new array of integers
	 */
	public static int[] merge(int[] arr1, int[] arr2) {
		//creating new array with the length of two array's length passed in parameter
	    int finalArr[] = new int[arr1.length + arr2.length];
	    
	    //initializing indexes for passed arrays and the new array
	    int index1 = 0;
	    int index2 = 0;
	    int temp = 0;
	    
	    //while loop until the length exceeded by indexes
	    while (index1 < arr1.length || index2 < arr2.length) 
	    {
	    	//if the element of first array is smaller
	        if (index2 >= arr2.length || (index1 < arr1.length && arr1[index1] < arr2[index2])) 
	        {
	            finalArr[temp++] = arr1[index1++];
	        } 
	        else 
	        {
	            finalArr[temp++] = arr2[index2++];
	        }
	    }
	    //returning the final array
	    return finalArr;
	}
	public static void main(String[] args) {
		int[] a = {1, 4, 4};
		int[] b = {3, 3, 4};
		
		int[] d = merge(a,b);
		for (int i = 0; i < d.length; i++)
		{
			System.out.println(d[i]);
		}

	}

}
