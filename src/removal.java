public class removal {
    public static void removeCharacters(String s) {
        StringBuffer sb = new StringBuffer(s);

        for(int i = 0; i<sb.length(); i++) {
            if (!Character.isDigit(sb.charAt(i))) {
                sb.deleteCharAt(i);
                i--;
            }
        }
        System.out.println("original: " + s);
        System.out.println("new: " + sb);
    }
    //if you wanted to just remove a single character you could do in Main.java:
    //s.replaceAll("!", "");
}
