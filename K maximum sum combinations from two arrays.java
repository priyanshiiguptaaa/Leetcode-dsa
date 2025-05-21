// Java program to find N maximum combinations
// from two arrays by generating all combinations
import java.util.*;

class GfG {
    
    static List<Integer> maxCombinations(int N, int K, 
                              int A[], int B[]) {
        List<Integer> sums = new ArrayList<>();

        // Compute all possible sum combinations
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sums.add(A[i] + B[j]);
            }
        }

        // Sort in non-increasing order
        sums.sort(Collections.reverseOrder());

        List<Integer> topK = new ArrayList<>();

        // Select the top K sums
        for (int i = 0; i < K; i++) {
            topK.add(sums.get(i));
        }

        return topK;
    }

    static void printArr(List<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int N = 2, K = 2;
        int A[] = {3, 2}, B[] = {1, 4};

        List<Integer> result = maxCombinations(N, K, A, B);
        
        printArr(result);
    }
}
