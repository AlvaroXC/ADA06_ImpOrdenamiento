public class QuickSort{
    private Auto[] theArray;          // ref to array theArray
    private int nElems;               // number of data items

    public QuickSort(int max){
      theArray = new Auto[max];      // create array
      nElems = 0;
    }

    public void insert(Auto value){
      theArray[nElems] = value;      // insert it
      nElems++;                      // increment size
    }

    public void display() {
      for(int j=0; j<nElems; j++)    // for each element,
         System.out.print(theArray[j].getNombre()+" "+theArray[j].getAnio() + "\n");  // display it
      System.out.println("");
    }

    void swap(int i, int j){
        Auto temp = theArray[i];
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
        
        int pivot = theArray[high].getAnio();
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++){
            if (theArray[j].getAnio()<(pivot)){
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return (i + 1);
    }
    
    void recQSort(int low, int high){
        if (low < high){

            int pi = partition(low, high);
    
            recQSort(low, pi - 1);
            recQSort(pi + 1, high);
        }
    }
}