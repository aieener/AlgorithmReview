package HuaWeiOA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        List<String> input = new ArrayList<>();

        // load the input
        while(counter != 4 && sc.hasNext()){
            input.add(sc.nextLine());
            counter++;
        }

        // process the input and remove '.'
        List<List<String>> inputSeperate = new ArrayList<>();
        for(String cur : input) {
            char [] curArray = cur.toCharArray();
            List<String> curIp = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(Character curChar : curArray){
                if(curChar != '.'){
                    sb.append(curChar);
                } else {
                    curIp.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            curIp.add(sb.toString());
            inputSeperate.add(curIp);
        }

        List<String> startOne = inputSeperate.get(0);
        List<String> endOne = inputSeperate.get(1);
        List<String> startTwo = inputSeperate.get(2);
        List<String> endTwo = inputSeperate.get(3);

        // now check if there is an overlap
        boolean overlap = false;

        for(int i = 0; i < 4; i++) {
            if(Integer.valueOf(startOne.get(i)) <= Integer.valueOf(startTwo.get(i))
                    && Integer.valueOf(endOne.get(i)) >= Integer.valueOf(endTwo.get(i)) ){
                System.out.println("Overlap IP");
                overlap = true;
                break;
            } else if(Integer.valueOf(startTwo.get(i)) <= Integer.valueOf(startOne.get(i))
                    && Integer.valueOf(endTwo.get(i)) >= Integer.valueOf(endOne.get(i)) ){
                System.out.println("Overlap IP");
                overlap = true;
                break;
            } else {
                break;
            }
        }

        if(!overlap) {
            System.out.println("No Overlap IP");
        }
    }
}
