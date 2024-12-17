import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = { 0, 0, 0, 0, 0 };
        int[] nums2 = { 1, 2, 3, 4, 5 };
        int[] c = merge(nums1, 0, nums2, 5);
        System.out.println(Arrays.toString(c));
    }

    static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            int j = 0;
            for (int i = 0; i < n; i++) {
                nums1[j] = nums2[i];
                j++;
            }

            return nums1;
        }

        if (n == 0) {
            int j = 0;
            for (int i = 0; i < m; i++) {
                int temp = nums1[i];
                nums1[j] = temp;
                j++;
            }

            return nums1;
        }

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j++;
        }

        Arrays.sort(nums1);

        return nums1;

    }
}
