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
}
