import java.util.*;

public class TexasHoldem {
    int Roundcounter = 1;
    String[] table = {"_", " _", " _", " _", " _"};
    String[][] deck = {{"2h","2d","2c","2s",},
            {"3h","3d","3c","3s"},
            {"4h","4d","4c","4s"},
            {"5h","5d","5c","5s"},
            {"6h","6d","6c","6s"},
            {"7h","7d","7c","7s"},
            {"8h","8d","8c","8s"},
            {"9h","9d","9c","9s"},
            {"10h","10d","10c","10s"},
            {"11h","11d","11c","11s"}, //11 = Jack
            {"12h","12d","12c","12s"}, //12 = Queen
            {"13h","13d","13c","13s"}, //13 = King
            {"14h","14d","14c","14s"}}; //14 = Ace

    public TexasHoldem(){

        ArrayList<String> globalHand = new ArrayList<>();
        Collections.addAll(globalHand,"11h", "5d", "8s", "5s", "3c");
        ArrayList<String> comb = new ArrayList<>();
        String[] personalHand = {"2c", "14d"};

        int[] position = new int[5];
        for(int i = 0; i<5; i++){
            position[i] = (int) ((Math.random() * 5) + 1);
        }

        System.out.println("-------------------------------------------------\n" +
                " h = hearts, d = diamonds, c = clubs, s = spades" +
                "\n-------------------------------------------------");

        printTable(table, Roundcounter);

        correctingBullshit(Bullshit(globalHand, comb), personalHand);

    }

    public void printTable(String[] table, int RoundCounter){
        String Round = "  [ Pre-Flop ]";
        switch(RoundCounter){
            case 2 -> Round = "    [ Flop ]";
            case 3 -> Round = "    [ Turn ]";
            case 4 -> Round = "   [ River ]";
        }
        System.out.println(Round);
        System.out.println("---------------");
        for(String i : table){
            System.out.print(" " + i);
        }

        System.out.println("\n---------------");
    }

    public void Player(){
        System.out.println();
    }
    public void bot1(){
        String[] personalHand = new String[2];

        if(Roundcounter == 1){
            personalHand = shuffle(2);
        }

    }
    public void bot2(){

    }
    public void bot3(){

    }
    public void bot4(){

    }
    public String[] shuffle(int length) {
        String[] resultHand = new String[length];
        int ranCardY = 0;
        int ranCardX = 0;

        for(int i = 0; i<length; i++) {
            while (true) {
                ranCardY = (int) (Math.random() * 13);
                ranCardX = (int) (Math.random() * 4);
                if (deck[ranCardY][ranCardX] != "0") {
                    break;
                }
            }
            resultHand[i] = deck[ranCardY][ranCardX];
        }
        deck[ranCardY][ranCardX] = "0";

        return resultHand;
    }
    public static List<List<String>> Bullshit(List<String> globalHand, List<String> comb) {
     /*             %%%%%%
                   %%%% = =
                   %%C    >
                    _)' _( .' ,
                 __/ |_/\   " *. o
                /` \_\ \/     %`= '_  .
               /  )   \/|      .^',*. ,
              /' /-   o/       - " % '_
             /\_/     <       = , ^ ~ .
             )_o|----'|          .`  '
         ___// (_  - (\
        ///-(    \'   \\     */

        //WARNING!!! I did not write this

        if (comb.size() == 3) {
            List<List<String>> result = new ArrayList<>();
            result.add(comb);
            return result;
        }

        List<List<String>> result = new ArrayList<>();
        Iterator<String> iterator = globalHand.iterator();

        while (iterator.hasNext()) {
            String item = iterator.next();
            iterator.remove();

            List<String> newComb = new ArrayList<>(comb);
            newComb.add(item);

            result.addAll(Bullshit(new ArrayList<>(globalHand), newComb));
        }
        return result;

    }
    public static String[][] correctingBullshit(List<List<String>> globalHandComb, String[] personalHand){

        String[][] result = new String[10][5];

        for(int i = 0; i<10; i++){
            result[i][0] = personalHand[0];
            result[i][1] = personalHand[1];
            for(int j = 0; j<3; j++){
                result[i][j+2] = globalHandComb.get(i).get(j);
            }
        }
        return result;
    }

    public void botCalculator(){

    }
    public int royalFlush(){

        return 1;
    }



}


//personalHand.set(j+2, globalHand.get(j));