public class QuickSort{
    private long[] theArray;          // ref to array theArray
    private int nElems;               // number of data items

    public QuickSort(int max)   {
      theArray = new long[max];      // create array
      nElems = 0;
    }

    public void insert(long value){
      theArray[nElems] = value;      // insert it
      nElems++;                      // increment size
    }

    public void display() {
      for(int j=0; j<nElems; j++)    // for each element,
         System.out.print(theArray[j] + " ");  // display it
      System.out.println("");
    }

    void swap(int i, int j){
        long temp = theArray[i];
        theArray[i] = theArray[j];
        theArray[j] = temp;
    }
    
    /* toma el ultimo elemento como pivote, 
    coloca el pivote en su posicion correcta del arreglo ordenado,
    coloca todos los valores mas pequeños (menores a los pivotes)
    a la izquierda del pivote y coloca todos los valores mas grandes 
    (mayores a los pivotes) a la derecha del pivote 
    */
    int partition(int low, int high){
        
        long pivot = theArray[high];
        
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++){
            // If current element is smaller
            // than the pivot
            if (theArray[j] < pivot){
                // Increment index of
                // smaller element
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return (i + 1);
    }
    
    /* The main function that implements QuickSort
            arr[] --> Array to be sorted,
            low --> Starting index,
            high --> Ending index
    */
    void recQSort(int low, int high){
        if (low < high){
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(low, high);
    
            // Separately sort elements before
            // partition and after partition
            recQSort(low, pi - 1);
            recQSort(pi + 1, high);
        }
    }
}