public class Sorting {

    public static void FillArray(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*100);
        }
    }

    public static void main(String[] args) {
        int arraySize = 100000;
        int[] random = new int[arraySize + 1];
        FillArray(random);
        Array sort = new Array(random);
        //sort.print();
        sort.bubbleSort();
        sort.selectionSort();
        sort.collectionSort();
        sort.time();
        //sort.print();
    }

}
