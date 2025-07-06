package old.AdvanceLevelQuestions.BitManipulation;

public class NumberToBinary_and_BinaryToNumber {
    public static void main(String[] args) {

        int number = 2;
        StringBuilder binary = new StringBuilder();
        for (int i = 31; i >= 0; i--) { // Assume 32-bit integers
            binary.append((number >> i) & 1); // Extract each bit
        }
        System.out.println("Binary representation: " + binary.toString());

        int num = 0;
        for(int i=31; i>=0; i--) {
            num += ((1 >> i) & 1);
        }

        System.out.println(num);
    }
}
