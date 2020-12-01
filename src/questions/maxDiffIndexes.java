package questions;

// Java program to implement
// the above approach

// For a given array arr[],
// calculates the maximum j – i
// such that arr[j] > arr[i]
import java.util.*;
class GFG{

    public static void main(String[] args)
    {
        int []v = {9,2,3,4,5,6,7,8,18,0};
        int n = v.length;
        int []maxFromEnd = new int[n + 1];
        Arrays.fill(maxFromEnd, Integer.MIN_VALUE);

// Create an array maxfromEnd
        for (int i = v.length - 1; i >= 0; i--)
        {
            maxFromEnd[i] = Math.max(maxFromEnd[i + 1],
                    v[i]);
        }

        int result = 0;

        for (int i = 0; i < v.length; i++)
        {
            int low = i + 1, high = v.length - 1,
                    ans = i;

            while (low <= high)
            {
                int mid = (low + high) / 2;

                if (v[i] <= maxFromEnd[mid])
                {
                    // We store this as current
                    // answer and look for further
                    // larger number to the right side
                    ans = Math.max(ans, mid);
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }

            // Keeping a track of the
            // maximum difference in indices
            result = Math.max(result, ans - i);
        }
        System.out.print(result + "\n");
    }
}

