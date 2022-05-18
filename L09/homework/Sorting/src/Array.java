import java.util.Arrays;
import java.util.Date;
public class Array {
    private final int[] arrayBubble, arraySelection, sortedArray;
    private long sortTimeBubble, sortTimeArraySort, sortTimeSelection;
    public Array(int[] array){
        this.arrayBubble = array;
        this.arraySelection = Arrays.copyOf(array, array.length);
        this.sortedArray = Arrays.copyOf(array, array.length);
    }
    void print(){
        String arrayString = Arrays.toString(arrayBubble);
        System.out.println(arrayString);
        String arrayBubbleString = Arrays.toString(arraySelection);
        System.out.println(arrayBubbleString);
        String sortedArrayString = Arrays.toString(sortedArray);
        System.out.println(sortedArrayString);
    }
    void bubbleSort(){
        Date start = new Date();
        for (int k = arrayBubble.length - 1; k >= 0; k--){
            for (int i = 0; i < k; i++){
                if (arrayBubble[i] > arrayBubble[i + 1]) {
                    int temp = arrayBubble[i];
                    arrayBubble[i] = arrayBubble[i + 1];
                    arrayBubble[i + 1] = temp;
                }
            }
        }
        Date end = new Date();
        sortTimeBubble = (end.getTime() - start.getTime());
    }
    void selectionSort(){
        Date start = new Date();
        int n = arraySelection.length;
        for (int i = 0; i < n - 1; i++) {
            int nMin = i;
            int min = arraySelection[i];
            for (int j = i + 1; j < n; j++){
                if (min > arraySelection[j]){
                    min = arraySelection[j];
                    nMin = j;
                }
            }
            arraySelection[nMin] = arraySelection[i];
            arraySelection[i] = min;
        }
        Date end = new Date();
        sortTimeSelection = (end.getTime() - start.getTime());
    }
    void collectionSort(){
        Date start = new Date();
        Arrays.sort(sortedArray);
        Date end = new Date();
        sortTimeArraySort = (end.getTime() - start.getTime());
    }
    void time (){
        System.out.println("Время сортировки\n" + "Bubble: " + sortTimeBubble + "\nSortSelection: " + sortTimeSelection + "\nArraySort: " + sortTimeArraySort);
    }

    
}
