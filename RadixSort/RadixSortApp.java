public class RadixSortApp {
    public static void main(String[] args){
        int maxSize = 100;  
        RadixSort radix = new RadixSort(maxSize);

        radix.insert(64);                // insert items
        radix.insert(21);
        radix.insert(33);
        radix.insert(70);
        radix.insert(12);
        radix.insert(85);
        radix.insert(44);
        radix.insert(3);
        radix.insert(99);
        radix.insert(0);
        radix.insert(108);
        radix.insert(36);

        radix.display();                 // display items
        
        radix.sort();
                    // array size

        radix.display();                 // display items
    }
}    
