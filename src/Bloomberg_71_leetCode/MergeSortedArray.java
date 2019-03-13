package Bloomberg_71_leetCode;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                index--;
                i--;
            } else {
                nums1[index] = nums2[j];
                index--;
                j--;
            }
        }
        while( i >= 0) {
            nums1[index] = nums1[i];
            index--;
            i--;
        }
        while( j >= 0) {
            nums1[index] = nums2[j];
            index--;
            j--;
        }
        return;
    }


    public static void main(String[] args) {
        //[1,0]
        //[2]
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1; // from big to small
        while(i >=0 && j >=0) {
            if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while(i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >=0) {
            nums1[k--] = nums2[j--];
        }
        return;

    }
}
