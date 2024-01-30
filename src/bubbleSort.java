import java.util.Random;

public class bubbleSort {
    bubbleSort(){
        Random random = new Random();
        int[] arr = new int[10];
        for(int i = 0; i<arr.length; i++){
            arr[i] = random.nextInt(10)+1;
            System.out.print(arr[i]);
        }
        int temp = 0;
        boolean swap = false;
        while(swap == false){
            swap = true;
            for(int i = 0; i<arr.length-1; i++){
                if(arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swap = false;
                }
            }
        }

        System.out.println();
        for(int j = 0; j<arr.length; j++){
            System.out.print(arr[j]);
        } 
    }

}
