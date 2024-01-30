public class Miscellaneous {

    public static void eraseAllVowels(String text){
        text = text.replaceAll("[aeiou]", "");
        System.out.println(text);
    }

}
