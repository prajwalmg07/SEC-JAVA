import java.util.*;

public class CRC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the size of data bits: ");
        int dataSize = scan.nextInt();
        int[] data = new int[dataSize];

        System.out.println("Enter data bits one by one:");
        for (int i = 0; i < dataSize; i++) {
            System.out.print("Bit " + (i + 1) + ": ");
            data[i] = scan.nextInt();
        }

        System.out.print("Enter the size of divisor bits: ");
        int divisorSize = scan.nextInt();
        int[] divisor = new int[divisorSize];

        System.out.println("Enter divisor bits one by one:");
        for (int i = 0; i < divisorSize; i++) {
            System.out.print("Bit " + (i + 1) + ": ");
            divisor[i] = scan.nextInt();
        }

        int[] remainder = divideDataWithDivisor(data, divisor);

        System.out.print("\nGenerated CRC code is: ");
        for (int bit : remainder) {
            System.out.print(bit);
        }

        // Append CRC to data
        int[] sentData = new int[data.length + remainder.length - 1];
        System.arraycopy(data, 0, sentData, 0, data.length);
        System.arraycopy(remainder, 0, sentData, data.length, remainder.length - 1);

        System.out.println("\n\nTransmitted data (data + CRC):");
        for (int bit : sentData) {
            System.out.print(bit);
        }

        // Receiver side check
        receiveData(sentData, divisor);
        scan.close();
    }

    // Division function
    static int[] divideDataWithDivisor(int[] oldData, int[] divisor) {
        int[] data = new int[oldData.length + divisor.length - 1];
        System.arraycopy(oldData, 0, data, 0, oldData.length);
        int[] rem = new int[divisor.length];
        System.arraycopy(data, 0, rem, 0, divisor.length);

        for (int i = 0; i < oldData.length; i++) {
            if (rem[0] == 1) {
                for (int j = 1; j < divisor.length; j++) {
                    rem[j - 1] = exorOperation(rem[j], divisor[j]);
                }
            } else {
                for (int j = 1; j < divisor.length; j++) {
                    rem[j - 1] = exorOperation(rem[j], 0);
                }
            }

            if (i + divisor.length < data.length)
                rem[divisor.length - 1] = data[i + divisor.length];
            else
                rem[divisor.length - 1] = 0;
        }
        return rem;
    }

    // XOR function
    static int exorOperation(int a, int b) {
        return (a == b) ? 0 : 1;
    }

    // Receiver check
    static void receiveData(int[] data, int[] divisor) {
        int[] rem = divideDataWithDivisor(data, divisor);
        boolean error = false;
        for (int bit : rem) {
            if (bit != 0) {
                error = true;
                break;
            }
        }

        if (error)
            System.out.println("\n\nCorrupted data received!");
        else
            System.out.println("\n\nData received without any error.");
    }
}
