lass Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0; // To keep track of the size of the decoded string
        int i;

        // Calculate the size of the decoded string without actually decoding it
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                size *= digit; // Multiply the size by the digit
            } else {
                size++; // Increment the size for non-digit characters
            }

            // If the size exceeds or is equal to k, break the loop
            if (size >= k) {
                break;
            }
        }

        // Now, decode the string in reverse order to find the kth character
        for (int j = i; j >= 0; j--) {
            char c = s.charAt(j);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                size /= digit; // Divide the size by the digit
                k %= size;     // Take the modulo to find the position within the repeated block
            } else if (k % size == 0) {
                return Character.toString(c); // Found the kth character
            } else {
                size--; // Decrement the size for non-digit characters
            }
        }

        return null; // Default return, should not reach here
    }
}
