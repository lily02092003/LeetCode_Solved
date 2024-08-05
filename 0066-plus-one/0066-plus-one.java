public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1; // Initialize carry to 1 for the increment
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10; // Update the current digit
            carry = sum / 10; // Update the carry
        }
        
        // If carry is still non-zero, it means we need to add a new digit
        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        
        return digits;
    }
}




