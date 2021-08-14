package closest_number;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


	class Result {

	    /*
	     * Complete the 'closestNumbers' function below.
	     *
	     * The function is expected to return an INTEGER_ARRAY.
	     * The function accepts INTEGER_ARRAY arr as parameter.
	     */

	    public static List<Integer> closestNumbers(List<Integer> arr) {
	    	
			return arr;
	    // Write your code here

	    }
	}

public class Closest_Number {
	static int[] closestNumbers(int[] arr) {
		Arrays.sort(arr);
		//hashMap, key is going to be the minimal difference, value - all elements which have the same difference;
		Map<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
		
		//inicialize a var with mincurrent differnce which stores the min differernce
		int minDiff = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length - 1; i++) {
			
			int currentDiff = arr[i+1] - arr[i];
			//if minDiff greater than currentDiff
			if (minDiff >= currentDiff) {
				//we found the smallest differernce;
				//check if hashMapContains add adjacent number to register
				if (hashMap.containsKey(hashMap)) {
					hashMap.get(currentDiff).add(arr[i]);
					hashMap.get(currentDiff).add(arr[i+1]);
				} else {
					//but if the hashMap does not contain current different patterns we inicialize
					List<Integer> tempList = new ArrayList<Integer>();
					tempList.add(arr[i]);
					tempList.add(arr[i + 1]);
					//put the array list into hashMap
					hashMap.put(currentDiff, tempList);
				}
				//update the minDiff
				minDiff = currentDiff;
			}
		}
		//minimal difference in the sort 
		List<Integer> minDiffElements = hashMap.get(minDiff);
		int[] result = new int[minDiffElements.size()];
		
		//copy all the values from the list to result array
		for(int i=0; i<result.length; i++) {
			result[i] = minDiffElements.get(minDiff);
		}
		return result;
	}
	
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = Integer.parseInt(bufferedReader.readLine().trim());

	        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());

	        List<Integer> result = Result.closestNumbers(arr);

	        bufferedWriter.write(
	            result.stream()
	                .map(Object::toString)
	                .collect(joining(" "))
	            + "\n"
	        );

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
	}


