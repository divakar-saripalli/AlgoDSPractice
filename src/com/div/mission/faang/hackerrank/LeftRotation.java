package src.com.div.mission.faang.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeftRotation {
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
	// Write your code here

	if(d < 2 || d > arr.size()){
	    return arr;
	}

	//	List<Integer> newList = new ArrayList<>(arr.size());
	//
	//	for(int i = d; i < arr.size(); i++){
	//	    newList.add(i-d, arr.get(i));
	//	}
	//	for(int i=0; i < d; i++ ){
	//	    newList.add((arr.size() - d)+i, arr.get(i));
	//	}
	//
	//	System.out.println(newList.toString());
	//	return newList;

	reverseArray(arr, 0, d-1);
	reverseArray(arr, d, arr.size()-1);
	reverseArray(arr, 0, arr.size()-1);
	System.out.println(arr.toString());
	return arr;
    }

    public static void reverseArray(List<Integer> arr, int start, int end){
	while(start < end){
	    int temp = arr.get(start);
	    arr.set(start, arr.get(end));
	    arr.set(end, temp);
	    start++;
	    end--;
	}
    }

    public static void main(String[] args) throws IOException {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	int n = Integer.parseInt(firstMultipleInput[0]);

	int d = Integer.parseInt(firstMultipleInput[1]);

	List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(Collectors.toList());

	List<Integer> result = rotateLeft(d, arr);
	bufferedReader.close();
    }
}
