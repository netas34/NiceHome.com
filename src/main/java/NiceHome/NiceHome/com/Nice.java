package NiceHome.NiceHome.com;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Nice {
    /**
     * Get a random integer in range
     *
     * @param min - the min number in the range
     * @param max - the max number in the range
     * @return - a random integer number between the min number and max number inclusive.
     */
    public static int randomInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    

    /**
     * Print the numbers in a given range in a random order
     * This is the classic option
     * Time complexity - o(n)
     * Space complexity - o(n)
     * @param min - the minimum number in the range
     * @param max - the maximum number in the range
     */
    public static void printNumbersOneWay(int min, int max) {
        if(min > max) return;
        Set<Integer> p = new HashSet<Integer>();
        while (p.size() <=  max - min ) {
        	int nextNumber = randomInRange(min, max);
            if (p.contains(nextNumber)) {
                continue;
            }
            System.out.println(nextNumber);
            p.add(nextNumber);    
            }
        }


    /**
     * Prints all numbers in a given range in a random order
     * This is classic way with array
     * Time complexity - o(n)
     * Space complexity - o(n)
     * @param min - the minimum number in the range
     * @param max - the maximum number in the range
     */
    public static void printNumbersTwoWay(int min, int max) {
    	int[] num = new int[max - min + 1];
        for (int i = min; i <= max; i++) {
        	num[i - min] = i;
        }
    	int count = 0;

        while (count < num.length) {
            int nextIndex = randomInRange(0, num.length - 1 - count);
            System.out.println(num[nextIndex]);
            num[nextIndex] = num[num.length - 1 - count];
            count++;
        }
    }
    /**
     * Print the numbers in a given range in a random order
     * this solution is recursive way.
     * Time complexity - o(n)
     * Space complexity - o(n)
     * @param min - the minimum number in the range
     * @param max - the maximum number in the range
     */
    public static void printNumbersBestWay(int min, int max){
        if(min > max) return;
        int random = randomInRange(min, max);
        System.out.println(random);
        printNumbersBestWay(min, random-1);
        printNumbersBestWay(random+1, max);
    }

        
    public static void main(String[] args) {
    	printNumbersOneWay(0,2);
    	printNumbersTwoWay(0,2);
    	printNumbersBestWay(0,2);
        
   }
}