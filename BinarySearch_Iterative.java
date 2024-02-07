// Binary search implemented iteratively which is O(log(N)) time complexity (worst case)

// Set instance variable "PrintSteps" true to print out each step of program execution
package Binary_Search_Examples;


public class BinarySearch_Iterative {
	private static boolean PrintSteps = true;/* Controls if you want the algorithm to print out each searching step (in the iterative
	process) */
	
	private static String ValWithBrackets(int val) {// Utility function that returns a string representation of value inside brackets
		return "(value: " + val + ")";
	}
	
	private static String IndexAndElement(int arr[], int index) {/* Utility function that returns the string representation of  the 
	index and value of an array element */
		return "[" + index + "]" + ", " + arr[index];
	}
	
	private static boolean LeftRightOutOfBounds(int left, int right, int arr[]) {/* Auxiliary utility function that checks if left 
	and right indexes are out of array bounds (to ensure printing will be legal) */
		int n = arr.length;
		if(left < 0 || left >= n || right < 0 || right >= n) return false;
		return true;
	}
	
	private static String ArraySegment(int arr[], int left, int right) {/* Utility function that returns the string representation of a 
	segment of an array */
    	String S = "";
    	for(int i = left; i <= right; i++) S += (arr[i] + " ");
    	return S;
    }

    public static int binarySearch(int[] arr, int target) {// Looks for target (returns it if found) in a sorted array
    	// Set initial left and right bounds for searching
        int left = 0;
        int right = arr.length - 1;
        if(PrintSteps) System.out.println("Original array: " + ArraySegment(arr, left, right) + ", left bound index: " + left + " " + 
        ValWithBrackets(arr[left]) + ", right bound index: " + right + " " + ValWithBrackets(arr[right]));
        while(left <= right) {// If target is still not found when left > right, it means target doesn't exist
            int mid = left + (right - left) / 2;/* Calculates the mid index by incrementing half of the left -> right distance to the 
            left index */
            if(arr[mid] == target) {// Checks if target is present at mid (returns mid element is yes)
            	if(PrintSteps && LeftRightOutOfBounds(left, right, arr)) System.out.println("Target equals with mid value " + arr[mid] 
            	+ ", target found");
            	return mid;
            }
            if(arr[mid] < target) {// If mid element < target, sets new left bound as mid + 1
            	left = mid + 1;
            	if(PrintSteps && LeftRightOutOfBounds(left, right, arr)) {
            		System.out.println("Target " + target + " greater than mid value " + arr[mid] + " , new left bound set to index " 
            		+ left + " " + ValWithBrackets(arr[left]) + ", right bound index: " + right + " " + 
            		ValWithBrackets(arr[right]));
            	}
            }
            else {// If mid element > target, sets new right bound as mid - 1
            	right = mid - 1;
            	if(PrintSteps && LeftRightOutOfBounds(left, right, arr)){ 
            		System.out.println("Left bound index: " + left + " " + ValWithBrackets(arr[left]) + ", target " + target + 
            		" smaller than mid value " + arr[mid] + " , new right bound set to index " + right + " " + 
            		ValWithBrackets(arr[right]));
            	}
            }
            if(PrintSteps) {
            	System.out.println("Mid index and value: " + IndexAndElement(arr, mid));
            	if(right > left && LeftRightOutOfBounds(left, right, arr)) System.out.println("New array: " + 
            	ArraySegment(arr, left, right));
            }
        }
        return -1;// Target not found
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int target = 16;
        int result = binarySearch(numbers, target);
        if(result == -1) System.out.println("Target not found");
        else System.out.println("Target " + target + " found at index: " + result);
    }
}




