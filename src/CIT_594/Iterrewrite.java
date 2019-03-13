package CIT_594;

import java.util.Iterator;
import java.util.LinkedList;

public class Iterrewrite {
    public static void rewrite(LinkedList<String> list) {
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void main(String[] args) {
        LinkedList<String> input = new LinkedList<>();
        input.add("Hello ");
        input.add(" This ");
        input.add(" World ");
        rewrite(input);
    }
}
