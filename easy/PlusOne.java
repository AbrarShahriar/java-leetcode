import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] arr = { 9, 8, 9 };
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    static int[] plusOne(int[] digits) {
        return rec(digits, digits[digits.length - 1], digits.length - 1);
    }

    // My Solution
    static int[] rec(int[] digits, int cur, int index) {
        boolean allNine = false;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 9) {
                allNine = true;
            } else {
                allNine = false;
                break;
            }
        }

        if (cur >= 0 && cur <= 8) {
            cur++;
            digits[index] = cur;
            return digits;
        } else {
            if (allNine) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
                for (int i = 1; i < digits.length; i++) {
                    digits[i] = 0;
                }
                return digits;
            } else {
                cur = 0;
                digits[index] = cur;

                return rec(digits, digits[index - 1], index - 1);
            }
        }
    }

    // Smaller Solution
    static int[] better(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}