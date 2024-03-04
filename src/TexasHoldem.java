import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.*;

public class TexasHoldem {
    int Roundcounter = 0;
    String[] table = {"_", "_", "_", "_", "_"};
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

    //high card = n;
    //one pair = nx10;
    //two pair = nx100;
    //three pair = nx1000; and so on
    int[] cash = {1000/*Player*/, 1000/*bot1*/, 1000/*bot2*/, 1000/*bot3*/, 1000/*bot4*/};
    int[] value = {0/*bot1*/, 0/*bot2*/, 0/*bot3*/, 0/*bot4*/};
    int[] position = {1, 2, 3, 4, 5};
    int stake = 0;
    public TexasHoldem(){
        ArrayList<String> fullGlobalHand = new ArrayList<>();
        Collections.addAll(fullGlobalHand, shuffle(5));
        ArrayList<String> globalHand = new ArrayList<>(Arrays.asList("0", "0", "0", "0", "0"));

        String[] x = {"3h", "2h"};
        ArrayList<String> y = new ArrayList<>(Arrays.asList("7s", "10h", "6s", "5h", "4c"));

        while(Roundcounter < 5) {
            printTable(fullGlobalHand);
            for (int j = 0; j<5; j++) {
                if (position[j] == 0) {
                    player();
                    cash[j] = cash[j] - 25;
                } else if (position[j] == 1 ) {
                    bot1(globalHand);
                    cash[j] = cash[j] - 50;
                } else if (position[j] == 2 ) {
                    bot2();
                } else if (position[j] == 3 ) {
                    bot3();
                } else if (position[j] == 4 ) {
                    bot4();
                }
            }
            globalHand.set(Roundcounter, fullGlobalHand.get(Roundcounter));
            Roundcounter++;
        }



       String[][] xyz = bubbleSort(correctingBullshit(Bullshit(y, new ArrayList<>()), x));
        for(int i = 0; i<xyz.length; i++){
            System.out.println();
            for(int j = 0; j<xyz[i].length; j++){
                System.out.print(xyz[i][j] + " ");
            }
        }
        System.out.println(Straight(xyz));
        System.out.println(Flush(xyz));

    }

    public String decision(int cash, String request){
        //nothing, check, fold, raise, all in

        return "1";
    }

    public void printTable(List<String> fullGlobalHand){
        boolean isEnd = false;
        String Round = "";
        switch(Roundcounter){
            case 0:
                System.out.println("-------------------------------------------------\n" +
                        " h = hearts, d = diamonds, c = clubs, s = spades" +
                        "\n-------------------------------------------------");
                Round = "  [ Pre-Flop ]";
                break;
            case 1 :
                Round = "    [ Flop ]";
                table[0] = fullGlobalHand.get(0);
                table[1] = fullGlobalHand.get(1);
                table[2] = fullGlobalHand.get(2);
                break;
            case 2 :
                Round = "    [ Turn ]";
                table[3] = fullGlobalHand.get(3);
                break;
            case 3 :
                Round = "   [ River ]";
                table[4] = fullGlobalHand.get(4);
                break;
            case 4 :
                isEnd = true;
                break;
        }
            System.out.println(Round);
        if(!isEnd) {
            System.out.println("---------------");
            for (String i : table) {
                System.out.print(" " + i);
            }

            System.out.println("\n---------------");
        }
    }
    public void setPosition(){
    }

    public void player(){
        System.out.println();
    }

    public void bot1(List<String> globalHand){
        String[] personalHand = new String[2];
        ArrayList<String> comb = new ArrayList<>();

        if(Roundcounter == 0){
            personalHand = shuffle(2);
        }else {
            botCalculator(correctingBullshit(Bullshit(globalHand, comb), personalHand));
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
                if (!deck[ranCardY][ranCardX].equals("0")) {
                    break;
                }
            }
            resultHand[i] = deck[ranCardY][ranCardX];
        }
        deck[ranCardY][ranCardX] = "0";

        return resultHand;
    }
    public List<List<String>> Bullshit(List<String> globalHand, List<String> comb) {
        //WARNING!!! I did not write this
        ArrayList<String> source = new ArrayList<>(globalHand);

        if (comb.size() == 3) {
            List<List<String>> result = new ArrayList<>();
            result.add(comb);
            return result;
        }

        List<List<String>> result = new ArrayList<>();
        Iterator<String> iterator = source.iterator();

        while (iterator.hasNext()) {
            String item = iterator.next();
            iterator.remove();

            List<String> newComb = new ArrayList<>(comb);
            newComb.add(item);

            result.addAll(Bullshit(new ArrayList<>(source), newComb));
        }
        return result;

    }
    public String[][] correctingBullshit(List<List<String>> globalHandComb, String[] personalHand){

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

    public int botCalculator(String[][] result){

        return 1;
    }
    public int RoyalFlush(int straightValue, int straightFlushValue){
        int value = 2;
        if(straightValue == 140000 && straightFlushValue > 2){
            value = value * 1000000000;
        }
        return value;
    }
    public int StraightFlush(int straightValue, int flushValue){
        int value = 2;
        if(straightValue > 2 && flushValue > 2){
            value = value * 100000000;
        }
        return value;
    }
    public int Straight(String[][] result){
        String[][] sortedHand = bubbleSort(result);
        int[][] numericSortedHand = new int[10][5];
        for(int i = 0; i<10; i++) {
            for(int j = 0; j<5; j++){
                numericSortedHand[i][j] = Integer.parseInt(sortedHand[i][j].substring(0, sortedHand[i][j].length()-1));
            }
        }
        int value = 2;
        int currentValue = 0;
        int checkStraight = 0;

        for(int k = 0; k < 10; k++) {
            for (int j = 0; j < 4; j++) {
                if ((numericSortedHand[k][j] + 1) == numericSortedHand[k][j + 1]) {
                    checkStraight++;
                    if (checkStraight == 4 && ((numericSortedHand[k][4] - 1) == numericSortedHand[k][3])) {
                        currentValue = numericSortedHand[k][4];
                        if (currentValue > value) {
                            value = currentValue;
                        }
                    }
                } else {
                    break;
                }
            }
            checkStraight = 0;
        }
        if(value > 2) value = value * 10000;
        return value;
    }
    public int Flush(String[][] result){
        int value = 2;
        int checkFlush = 0;
        for(int i = 0; i<10; i++) {
            for(int j = 1; j<4; j++){
                char suite = result[i][0].charAt(result[i][0].length()-1);
                char element1 = result[i][j].charAt(result[i][j].length()-1);
                if(element1 == suite){
                    checkFlush++;
                    if(checkFlush == 5 && result[i][4].charAt(result[i][4].length()-1) == suite){
                        value = value * 100000;
                        break;
                    }
                }
            }
        }
        return value;
    }



    public String[][] bubbleSort(String[][] result) {
        String[][] sortedHand = new String[10][5];
        int count = 0;
        int value = 0;
        for (int i = 0; i < 10; i++) {
            sortedHand[i] = Arrays.copyOf(result[i], result[i].length);
            boolean swap = true;
            while (swap) {
                swap = false;
                for (int j = 0; j < 4; j++) {
                    int element1 = Integer.parseInt(sortedHand[i][j].substring(0, sortedHand[i][j].length() - 1));
                    int element2 = Integer.parseInt(sortedHand[i][j + 1].substring(0, sortedHand[i][j + 1].length() - 1));
                    if (element1 > element2) {
                        String temp = sortedHand[i][j];
                        sortedHand[i][j] = sortedHand[i][j + 1];
                        sortedHand[i][j + 1] = temp;
                        swap = true;
                    }
                }
            }
        }
        return sortedHand;
    }
}



//personalHand.set(j+2, globalHand.get(j));