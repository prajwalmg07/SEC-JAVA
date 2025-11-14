public class prajwal {
    import java.util.*;

public class CRC {

    public static void main(String args[]) {  
        try (Scanner scan = new Scanner(System.in)) {
            int size;  

            // Get the size and bits for data
            System.out.println("Enter the size of the data array: ");  
            size = scan.nextInt();  

            int data[] = new int[size];  

            System.out.println("Enter data bits in the array one by one: ");  
            for(int i = 0 ; i < size ; i++) {  
                System.out.println("Enter bit " + (i + 1) + ":");  
                data[i] = scan.nextInt();  
            }  

            // Get the size and bits for the divisor
            System.out.println("Enter the size of the divisor array:");  
            size = scan.nextInt();  

            int divisor[] = new int[size];  
            System.out.println("Enter divisor bits in the array one by one: ");  
            for(int i = 0 ; i < size ; i++) {  
                System.out.println("Enter bit " + (i + 1) + ":");  
                divisor[i] = scan.nextInt();  
            }

            // Perform CRC calculation
            int rem[] = divideDataWithDivisor(data, divisor);  

            System.out.print("Generated CRC code is: ");  
            for(int i = 0; i < data.length; i++) {  
                System.out.print(data[i]);  
            }  
            for(int i = 0; i < rem.length - 1; i++) {  
                System.out.print(rem[i]);  
            }  
            System.out.println();

            // Now simulate sending data
            int sentData[] = new int[data.length + rem.length - 1];  
            System.out.println("Enter bits in the array which you want to send: ");  
            for(int i = 0; i < sentData.length; i++) {  
                System.out.println("Enter bit " + (i + 1) + ":");  
                sentData[i] = scan.nextInt();  
            }  

            // Verify the received data
            receiveData(sentData, divisor);
        }  
    }  

    static int[] divideDataWithDivisor(int oldData[], int divisor[]) {  
        int rem[] = new int[divisor.length];  
        int data[] = new int[oldData.length + divisor.length - 1];  // Adjusted to add enough space for CRC code
        System.arraycopy(oldData, 0, data, 0, oldData.length);  
        System.arraycopy(data, 0, rem, 0, divisor.length);  

        for(int i = 0; i < oldData.length; i++) {  
            if(rem[0] == 1) {  // If the first bit is 1, perform XOR with divisor
                for(int j = 1; j < divisor.length; j++) {  
                    rem[j-1] = exorOperation(rem[j], divisor[j]);  
                }
            } else {  // If the first bit is 0, just shift and XOR with 0
                for(int j = 1; j < divisor.length; j++) {  
                    rem[j-1] = exorOperation(rem[j], 0);  
                }
            }

            // Move the next bit down into the remainder
            if (i + divisor.length < data.length) {
                rem[divisor.length - 1] = data[i + divisor.length];
            } else {
                rem[divisor.length - 1] = 0;  // Fill with zeros if no more bits
            }
        }  

        return rem;  
    }  

    static int exorOperation(int x, int y) {  
        return (x == y) ? 0 : 1;  
    }  

    static void receiveData(int data[], int divisor[]) {  
        int rem[] = divideDataWithDivisor(data, divisor);  
        for(int i = 0; i < rem.length; i++) {  
            if(rem[i] != 0) {  
                System.out.println("Corrupted data received...");  
                return;  
            }  
        }  
        System.out.println("Data received without any error.");  
    }  
}sss

}
