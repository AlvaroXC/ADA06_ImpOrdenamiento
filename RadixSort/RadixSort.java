// Radix sort Java implementation
import java.util.*;

public class RadixSort {
    private long[] theArray;          // ref to array theArray
    private int nElems;               // number of data items
    //-----------------------------------------------------------
    public RadixSort(int max)   {
        theArray = new long[max];      // create array
        nElems = 0;
    }
    
    //-----------------------------------------------------------
    public void insert(long value){
        theArray[nElems] = value;      // insert it
        nElems++;                      // increment size
    }

    public void display() {
        for(int j=0; j<nElems; j++)    // for each element,
            System.out.print(theArray[j] + " ");  // display it
        System.out.println("");
    }

	// A utility function to get maximum value in arr[]
	private long getMax(){
		long mx = theArray[0];
		for (int i = 1; i < nElems; i++)
			if (theArray[i] > mx)
				mx = theArray[i];
		return mx;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	public void countSort(int exp){
		long[] output = new long[nElems]; // output array
		int i;
		long[] count = new long[10];
		Arrays.fill(count, 0);

		// Store count of occurrences in count[]
		for (i = 0; i < nElems; i++)
			count[(int) ((theArray[i] / exp) % 10)]++;

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = nElems - 1; i >= 0; i--) {
			output[(int) (count[(int) ((theArray[i] / exp) % 10)] - 1)] = theArray[i];
			count[(int) ((theArray[i] / exp) % 10)]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current digit
        theArray = Arrays.copyOf(output, output.length);
		
	}

	// The main function to that sorts arr[] of size n using
	// Radix Sort
	public void sort(){
		// Find the maximum number to know number of digits
		long m = getMax();

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(exp);
	}
}
/* This code is contributed by Devesh Agrawal */

