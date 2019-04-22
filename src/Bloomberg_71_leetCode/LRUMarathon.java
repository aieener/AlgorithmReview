package Bloomberg_71_leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * The only difference with LRU is this time
 *  we have an array of LinkedList!
 *  Node[] nodes = new Node[10]
 *  Sensor id 越高越接近终点
 */
public class LRUMarathon {
    class Node {
        String name; // key
        int id;      // val group id
        Node prev, next;
        Node (String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    Node [] nodes = new Node[10];
    Map<String, Node> map = new HashMap<>();

    public LRUMarathon() {
        // set up head and tail to each List/sensor
        for(int i = 0; i < 10; i++) {
            Node head = new Node("" + i, -1);
            Node tail = new Node("" + i, -1);
            head.next = tail;
            tail.prev = head;
            nodes[i] = head;
        }
    }

    public void update(String name, int sensor) {
        Node cur = new Node(name, sensor);
        if(map.containsKey(name)) {
            // simply del old
            Node old = map.get(name);
            old.prev.next = old.next;
            old.next.prev = old.prev;
        }
        map.put(name, cur);
        move(cur, sensor);
    }

    // move node to nodes[sensor]'s head;
    public void move(Node node, int sensor) {
        nodes[sensor].next.prev = node;
        node.next = nodes[sensor].next;
        nodes[sensor].next = node;
        node.prev = nodes[sensor];
    }

    // each sensor maitain's from top to least
    public void topK(int k) {
        for(int i = 9; i >=0; i--) {
            Node cur = nodes[i].next;
            while(cur.id != -1 && k > 0) {
                System.out.print(cur.name + " | ");
                k--;
                cur=cur.next;
            }
        }
    }

    public static void main(String[] args) {

        LRUMarathon sol = new LRUMarathon();
        sol.update("a", 1);
        sol.update("b", 1);
        sol.topK(2);
        System.out.println("\n----------");
        sol.update("c", 1);
        sol.update("b", 2);
        sol.update("c", 2);
        sol.topK(2);
        System.out.println("\n----------");

        sol.update("b", 3);
        sol.topK(1);
        System.out.println("\n----------");

        sol.update("a", 2);
        sol.topK(3);
        System.out.println("\n----------");
        sol.update("a", 7);
        sol.topK(3);
    }
}

class Marathon{
    class Node {
        String name;
        int id; // sensorID
        Node next, prev;
        Node (String n, int i) {
            name = n;
            id = i;
        }
    }

    Node[] nodes = new Node[10]; // 10 sensors, each sensor is a LinkedList
    Map<String, Node> map  = new HashMap<>(); // each person --> sensor

    public Marathon() {
        // initialize 10 sensor
        // all start with a dummy headNode(i, -1);
        for(int i = 0; i <10; i++) {
            Node headNode = new Node("" + i , -1);
            Node tailNode = new Node("" + i , -1);
            headNode.next = tailNode;
            tailNode.prev = headNode;
            nodes[i] = headNode;
        }
    }

    public void update(String name, int sensor) {
        if(map.containsKey(name)){
            // simply del old
            Node old = map.get(name);
            old.prev.next = old.next;
            old.next.prev = old.prev;
        }
        Node newNode = new Node(name, sensor);
        map.put(name, newNode); // override old
        move(newNode,sensor);
    }

    // move node to nodes[sensor]'s head;
    public void move(Node node, int sensor) {
        Node head = nodes[sensor];
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // each sensor maitain's from top to least
    public void topK(int k) {
        for(int i = nodes.length - 1; i >=0 ; i--) {
            Node head = nodes[i].next;
            while(head.id != -1 && k>0){
                System.out.print(head.name + " | ");
                head = head.next;
                k--;
            }
        }
    }

    public static void main(String[] args) {

        Marathon sol = new Marathon();
        sol.update("a", 1);
        sol.update("b", 1);
        sol.topK(2);
        System.out.println("\n----------");
        sol.update("c", 1);
        sol.update("b", 2);
        sol.update("c", 2);
        sol.topK(2);
        System.out.println("\n----------");

        sol.update("b", 3);
        sol.topK(1);
        System.out.println("\n----------");

        sol.update("a", 2);
        sol.topK(3);
        System.out.println("\n----------");
        sol.update("a", 7);
        sol.topK(3);
    }

}
