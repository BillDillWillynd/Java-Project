import java.util.Scanner;

public class RLE {


    public RLE(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter some text");
        String text = scanner.next();
        int count = 1;
        String ans = "";
        int p = 0; char previouse = text.charAt(p);
        int c = 1; char current = text.charAt(c);

        for(int i = 0; i<text.length()-1; i++){
            if(previouse == current){
                count++;
            }
            else if(previouse!=current){
                ans = ans + previouse + "(" + count + ")";
                count = 1;
            }
            p++;
            c++;
            if(c<text.length()){
                previouse = text.charAt(p);
                current = text.charAt(c);
            }
            else{
                ans = ans + current + "(" + count + ")";
            }
        }
        System.out.println(ans);
    }

    //https://www.youtube.com/watch?v=29ZGKXLdj-s

}
