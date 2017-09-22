package org.sample;

public class Algo {

	 public static void main(String args[])
	    {
	        
	        int arr[] = {2,3,4,10,40};
	        int n = arr.length;
	        int x = 10;
	        int result = exponentialSearch(arr,x);
	        if (result == -1)
	            System.out.println("Element not present");
	        else
	            System.out.println("Element found at index "+result);
	    }
	 
	 private static int exponentialSearch(int arr[],  int x)
	    {
	        // If x is present at firt location itself
		 int n = arr.length - 1 ;
	        if (arr[0] == x)
	            return 0;
	      
	        // Find range for binary search by
	        // repeated doubling
	        int i = 1;
	        while (i < n && arr[i] <= x)
	            i = i*2;
	      
	        //  Call binary search for the found range.
	        return binarySearch(arr, i/2, Math.min(i, n), x);
	    }
	 
	private static int binarySearch(int[] arr , int key){
		
		int n = arr.length - 1 ;
		int start = 0 ;
		
		
		while ( start <= n	){
			int mid  = (start + n) / 2 ;
			if(key == arr[mid]){
				return mid ;
			}else if (  key > arr[mid]){
				start = mid ;
			}else if (  key < arr[mid]){
				n = mid ;
			}
			
		}
		return -1;
	}
private static int binarySearch(int[] arr , int start , int n , int key ){
		
		
		while ( start <= n	){
			int mid  = (start + n) / 2 ;
			if(key == arr[mid]){
				return mid ;
			}else if (  key > arr[mid]){
				start = mid ;
			}else if (  key < arr[mid]){
				n = mid ;
			}
			
		}
		return -1;
	}
	
	private static int jumpSearch(int[] arr , int key){
		int length = arr.length - 1 ;
		int start = 0 ;
		int jump = (int) Math.sqrt(length);
		  for(int i=0;i<length;i+=jump){
	            if(arr[i]==key){
	                return i;
	            }
	            else if(arr[i]>key){
	                start=arr[i-jump];
	                break;
	            }else{
	                start=i+1;
	            }
	        }
	        for(int j=start;j<arr.length;j++){
	            if(arr[j]==key){
	                return j;
	            }
	        }
		
		return -1;
	}
	public static int interpolationSearch(int[] arr, int key)
    { //	        int arr[] = {2,3,4,10,40};

        int start = 0;
        int n = arr.length - 1;
        int mid;
        while (arr[start] <= key && arr[n] >= key) 
        {
            if (arr[n] - arr[start] == 0)
                return (start + n)/2;
            /** out of range is possible  here **/
             mid = start +((key - arr[start]) * (n - start)) / (arr[n] - arr[start]);  
 
             if (key ==  arr[mid])
            	 return mid;
             else if (key > arr[mid]) 
            	 start = mid + 1;
             else if (key > arr[mid])
            	 n = mid - 1;
        }
        if (arr[start] == key)
            return start;
           /** not found **/
        else
            return -1; 
    } 
}
