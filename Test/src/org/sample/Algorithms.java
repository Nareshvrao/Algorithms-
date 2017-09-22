package org.sample;

public class Algorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
		 int key = 12 ;
	     System.out.println("Element found at: "+jumpSearch(arr,key) + 
	    		 "  , " + binarySearch(arr,key) + "  , " + linearSearch(arr,key));

		 
	}
	private static int linearSearch(int arr[],  int key)
	{
	    int i;
	    int n = arr.length - 1;
	    for (i=0; i<n; i++)
	        if (arr[i] == key)
	         return i;
	    return -1;
	}
	private static int binarySearch(int[] inputArr, int key) {
         
	        int start = 0;
	        int end = inputArr.length - 1;
	        while (start <= end) {
	            int mid = (start + end) / 2;
	            if (key == inputArr[mid]) {
	                return mid;
	            }
	            if (key < inputArr[mid]) {
	                end = mid - 1;
	            } else {
	                start = mid + 1;
	            }
	        }
	        return -1;
	    }
	public static int  jumpSearch (int[] arr,int key){
        int length= arr.length;
        int start=0;
        int jump=(int) Math.sqrt(length);
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
        for(int i=start;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }

}
