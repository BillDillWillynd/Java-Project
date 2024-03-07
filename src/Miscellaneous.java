public class Miscellaneous {

    public static void eraseAllVowels(String text) {
        text = text.replaceAll("[aeiou]", "");
        System.out.println(text);
    }
    public static void convertToUpper(String text){
        char[] arr = new char[text.length()];

        for(int i = 0; i<text.length(); i++){
            arr[i] = text.charAt(i);
            if(i == 0){
                arr[i] = Character.toUpperCase(arr[i]);
            }
            else if(arr[i-1] == ' '){
                arr[i] = Character.toUpperCase(arr[i]);
            }
            System.out.print(arr[i]);
        }
    }
    public static void swappingVowels(){
        String text = "Computer";
        String finalText;
        char[] arr = text.toCharArray();
        int a = 0;
        int b = text.length()-1;
        int count = 0;
        int tempA = 0;
        int tempB = 0;
        char temp;
        while(a<b){
            for(int i = 0; i<text.length(); i++){
                if(Vowels(arr[i])){
                    tempA = i;
                    count++;
                    break;
                }
            }
            for(int j = text.length()-1; j>0; j--){
                if(Vowels(arr[j])){
                    tempB = j;
                    count++;
                    break;
                }
            }
            if(count >= 2){
                temp = arr[tempA];
                arr[tempA] = arr[tempB];
                arr[tempB] = temp;
            }
            a = a + tempA;
            b = b - tempB;
            count = 0;
        }
        for(int i = 0; i<text.length(); i++){
            System.out.print(arr[i]);
        }
    }
    public static boolean Vowels(char ch){
        ch = Character.toUpperCase(ch);
        if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' ||ch == 'U'){
            return true;
        }else{
            return false;
        }
    }
}
