import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n==1) {
			return 1;
		}
		else {
			return (fibonacci(n-1) + fibonacci(n-2));
		}
	}

	public static void bubbleSort(int[] arr) {
		int numSwaps = 0;
		boolean isSorted = false;
		int lastSorted = arr.length - 1;

		while(!isSorted) {
			isSorted = true;
			for(int i=0; i<lastSorted; i++) {
				if(arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					isSorted = false;
					numSwaps++;
				}
			}
			lastSorted--;
		}

		int firstElement = arr[0];
		int lastElement = arr[arr.length-1];

		System.out.println("Array is sorted in "+numSwaps+" swaps.");
		System.out.println("First Element: " + firstElement);
		System.out.println("Last Element: " + lastElement);
	}

	private static void leftRotationArray(int k, int[] a, int n) {

		int[] b = new int[n];

		for(int i = 0; i < n; i++) {
			b[(i + (n - k)) % n] = a[i];
		}

		for(int i=0; i<a.length; i++) {
			System.out.print(b[i]);
			System.out.print(" ");
		}
	}

	private static void createAnagram(String a, String b) {

		int deletions = 0;

		List<String> aList = convertToList(a);
		List<String> bList = convertToList(b);

		for(int i=0; i<aList.size(); i++) {
			if(bList.contains(aList.get(i))) {
				bList.remove(aList.get(i));
			}
			else {
				deletions++;
			}
		}

		deletions = deletions + bList.size();

		System.out.println(deletions);
	}

	private static List<String> convertToList(String str) {
		List<String> charList = new ArrayList<String>();      
		for(int i = 0; i<str.length();i++){
			charList.add(Character.toString(str.charAt(i)));
		}
		return charList;
	}

	/*
    Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

    A Node is defined as: 
        class Node {
            int data;
            Node next;
        }
	 */

	boolean hasCycle(Node head) {
		Set<Node> s = new HashSet<Node>();
		while(head != null) {
			if (s.contains(head)) {
				return true;
			}
			else {
				s.add(head);
				head = head.next;
			}
		}
		return false;
	}

	static int[] solve(int[] a, int[] b) {
		int[] sol = new int[2];

		for(int i=0; i<3; i++) {
			if (a[i] > b[i]) {
				sol[0]++;
			}
			else if (a[i] < b[i]){
				sol[1]++;
			}
		}
		return sol;
	}

	private static void calculateCost(double meal_cost, int tip_percent, int tax_percent) {
		double totalCost = 0;

		totalCost = meal_cost + tip_percent*meal_cost/100 + tax_percent*meal_cost/100;

		System.out.println("The total meal cost is "+ Math.round(totalCost) +" dollars.");
	}
	
	private static void ransomNote(int m, int n, String mag, String ran) {
		Map<String, Integer> hashTable = new HashMap<String, Integer>();
		Boolean flag = true;
		
		System.out.println("mag: "+mag);
		System.out.println("ran: "+ran);

		for (String a : mag.split(" ")) {
			Integer i = hashTable.get(a);
			System.out.println("hashTable.get("+a+"): "+i);
			if (i == null) {
				hashTable.put(a, 1);
			} else {
				hashTable.put(a, i + 1);
			}
		}

		for (String b : ran.split(" ")) {
			Integer i = hashTable.get(b);
			System.out.println("hashTable.get("+b+"): "+i);
			if (i == null || hashTable.get(b) == 0) {
				flag = false;
				break;
			} else {
				hashTable.put(b, i - 1);
			}
		}
		
		System.out.println(flag ? "Yes" : "No");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		/*Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		String mag = in.nextLine();
		String ran = in.nextLine();*/

		int m = 1;
		int n = 1;
		String mag = "One  give me grand today night";
		String ran = "give one grand today";
		
		ransomNote(m,n,mag,ran);

		/*Scanner in = new Scanner(System.in);
        double meal_cost = in.nextDouble();
        int tip_percent = in.nextInt();
        int tax_percent = in.nextInt();
        in.close();

        calculateCost(meal_cost,tip_percent,tax_percent);*/

		/*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] a = new int[3];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] b = new int[3];

        String[] bItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b[i] = bItem;
        }*/

		/*int[] a = new int[3];
    	a[0] = 5;
    	a[1] = 6;
    	a[2] = 7;

    	int[] b = new int[3];
    	b[0] = 3;
    	b[1] = 6;
    	b[2] = 10;

        int[] result = solve(a, b);*/

		/*for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();*/

		scanner.close();

		/*int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        int i2 = 0;
        double d2 = 0.0;
        String s2 = "";

        i2 = scan.nextInt();
        d2 = scan.nextDouble();
        scan.nextLine();
        s2 = scan.nextLine();

        System.out.println(s2);

        System.out.println(i + i2);
        System.out.println(d + d2);
        System.out.println(s.concat(s2));

        scan.close();*/

		/*String a = scanner.nextLine();

        String b = scanner.nextLine();

        scanner.close();

        createAnagram(a,b);*/

		/*String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);    
        int k = Integer.parseInt(nk[1]);
        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            System.out.println(aItem);
            a[i] = aItem;
        }

        scanner.close();

        long startTime = System.nanoTime();        
        leftRotationArray(k,a,n);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;

        System.out.println("Time: "+ duration);*/

		/*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
        	arr[i] = scanner.nextInt();
        }
        scanner.close();

        bubbleSort(arr);*/
	}
}