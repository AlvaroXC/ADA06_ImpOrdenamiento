public class QuickSortApp{
    public static void main(String[] args){
        int maxSize = 100;             // array size
        QuickSort qSort = new QuickSort(maxSize);

        qSort.insert(64);                // insert items
        qSort.insert(21);
        qSort.insert(33);
        qSort.insert(70);
        qSort.insert(12);
        qSort.insert(85);
        qSort.insert(44);
        qSort.insert(3);
        qSort.insert(99);
        qSort.insert(0);
        qSort.insert(108);
        qSort.insert(36);

        qSort.display();                 // display items
        
        qSort.recQSort(0,11);
 
        qSort.display();                // display items
    }
}