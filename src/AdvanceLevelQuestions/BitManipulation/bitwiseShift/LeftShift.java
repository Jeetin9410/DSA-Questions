package AdvanceLevelQuestions.BitManipulation.bitwiseShift;

public class LeftShift {
    public static void main(String[] args) {
        // This same code can be used to print decimal to binary.
        int number = 2;
        StringBuilder binary = new StringBuilder();
        for (int i = 31; i >= 0; i--) { // Assume 32-bit integers
            binary.append((number >> i) & 1); // Extract each bit
        }
        System.out.println("Binary representation: " + binary.toString());
    }
}
