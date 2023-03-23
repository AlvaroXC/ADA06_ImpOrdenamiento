public class MergeSort{
   private long[] theArray;          // ref to array theArray
   private int nElems;               // number of data items

   public MergeSort(int max)   {
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

   public void mergeSort() {
      long[] workSpace = new long[nElems];
      recMergeSort(workSpace, 0, nElems-1);
   }

   private void recMergeSort(long[] workSpace, int lowerBound, int upperBound){
      if(lowerBound == upperBound)            // if range is 1,
         return;                              // no use sorting
      else {                                    
         int mid = (lowerBound+upperBound) / 2; // find midpoint        
         recMergeSort(workSpace, lowerBound, mid); // sort low half
         recMergeSort(workSpace, mid+1, upperBound); // sort high half
         merge(workSpace, lowerBound, mid+1, upperBound); // merge them
      }  // end else
   }  // end recMergeSort()

   private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
      int j = 0;                             // workspace index
      int lowerBound = lowPtr;
      int mid = highPtr-1;
      int n = upperBound-lowerBound+1;       // # of items

      while(lowPtr <= mid && highPtr <= upperBound)
         if( theArray[lowPtr] < theArray[highPtr] )
            workSpace[j++] = theArray[lowPtr++];
         else
            workSpace[j++] = theArray[highPtr++];

      while(lowPtr <= mid)
         workSpace[j++] = theArray[lowPtr++];

      while(highPtr <= upperBound)
         workSpace[j++] = theArray[highPtr++];

      for(j=0; j<n; j++)
         theArray[lowerBound+j] = workSpace[j];
   }
}