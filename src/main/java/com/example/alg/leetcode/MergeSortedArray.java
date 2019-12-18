package com.example.alg.leetcode;

public class MergeSortedArray {
	/*
	public void merge(int[] nums1, int m, int[] nums2, int n) {    
        if( n == 0) {
            return;
        }
        
        if(n == 0 && m == 0){
            return;
        }
        
        if(n == 1 && m == 1){
            if(nums2[0] < nums1[0]) {
                nums1[1] = nums1[0]; 
                nums1[0] = nums2[0]; 
            } else {
                nums1[1] = nums2[0];                 
            }
            return;
        }
        
        if( m == 0) {
            for(int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];    
            }
            
            return;
        }
        
        for(int i = m + n; i > 0; i--){
        	if(m > 0) {
	            if(nums2[n - 1] >= nums1[m - 1]) {            	
	                nums1[i - 1] = nums2[n - 1];
	                n--;
	            } else {
	                if(nums2[n - 1] < nums1[m - 1]) {
	                    nums1[i - 1]   = nums1[m - 1];
	                   	m--;
	                }
	            }
        	} else {
        		nums1[i - 1] = nums2[n - 1];
                n--;        		
        	}
            if(n == 0 ) {//&& m == 0){                
                break;
            }
        }
    }
	*/
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		
        int i = m - 1, j = n - 1, k = m + n - 1;
        
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
            }
            else if (j < 0) {
                nums1[k--] = nums1[i--];
            }
            else if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            }
            else {
                nums1[k--] = nums1[i--];
            }
        }
    }

	public static void main(String[] args) {
		/*
		int m = 3;
		int n = 3;
		
		int[] nums1 = new int[] {4, 5, 6, 0, 0, 0};
		int[] nums2 = new int[] {1, 2, 3};
		*/
		/*
		int m = 1;
		int n = 1;
		int[] nums1 = new int[] {1, 0};
		int[] nums2 = new int[] {2};
		*/
		/*
		int m = 1;
		int n = 1;
		int[] nums1 = new int[] {2, 0};
		int[] nums2 = new int[] {1};
		*/
		/*
		int m = 3;
		int n = 3;
		int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
		int[] nums2 = new int[] {4, 5, 6};
		*/
		/*
		int m = 4;
		int n = 3;
		int[] nums1 = new int[] {0, 2, 4, 8, 0, 0, 0};
		int[] nums2 = new int[] {1, 3, 9};
		*/
		
		int m = 4;
		int n = 5;
		int[] nums1 = new int[] {3, 4, 5, 8, 0, 0, 0, 0, 0};
		int[] nums2 = new int[] {1, 3, 8, 10, 11};
		
		new MergeSortedArray().merge(nums1, m, nums2, n);
		
		for(int num : nums1) {
			System.out.print(String.format(" %d ", num));
		}
	}

}
