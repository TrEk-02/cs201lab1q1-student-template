import java.util.*;
import java.util.stream.Collectors;

public class NumbersArray {

    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,1,5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));       
        
        System.out.println();

        input = new Integer[] {1,2,3,4,1,2,5,3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input))); 
    }

    // Write your methods here
    public static Integer findMax(Integer[] arr){
        int result = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (result < arr[i]){
                result = arr[i]; 
            } 
        }

        return result;
    }

    public static Integer[] findDuplicates(Integer[] arr){

        Set<Integer> seen = new HashSet<>();

        Integer[] result = Arrays.stream(arr)
                             .filter(n -> !seen.add(n))
                             .toArray(Integer[]::new);        

        return result;
    }

    public static Integer[] findUnique(Integer[] arr) {

        Map<Integer, Long> counts = Arrays.stream(arr)
                .collect(Collectors.groupingBy(
                        n -> n,
                        Collectors.counting()
                ));

        return Arrays.stream(arr)
                .filter(n -> counts.get(n) == 1)
                .toArray(Integer[]::new);
}
    
}

