import java.util.*;

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
    public static int findMax(Integer[] arr){
        int result = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (result < arr[i]){
                result = arr[i]; 
            } 
        }

        return result;
    }

    public static int[] findDuplicates(Integer[] arr){

        Set<Integer> seen = new HashSet<>();

        int[] result = Arrays.stream(arr)
                             .filter(n -> !seen.add(n))
                             .mapToInt(Integer::intValue)
                             .toArray();        

        return result;
    }

    public static int[] findUnique(Integer[] arr){
        
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            boolean isUnique = true; 

            for (int j = 0; j < arr.length; j++){

                if (i != j && arr[i].equals(arr[j])){
                    isUnique = false;
                    break;
                }
            }

            if (isUnique){
                int e = arr[i];
                result.add(e);
            }
            
        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }
    
}

