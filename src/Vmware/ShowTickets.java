package Vmware;

public class ShowTickets {
    static long waitingTime(int[] tickets, int p) {
        long res = 0;
        int pIdx = p;
        int ticketPneeds = tickets[p];

        while(ticketPneeds > 0){
            // each time we if the head one has more than one ticket to buy,
            // we increment the time and decrease the number in ticket
            if(tickets[0] > 0){
                res++;
                tickets[0]--;
            }

            shiftToleft(tickets);
            pIdx = (tickets.length + pIdx - 1) % tickets.length;
            ticketPneeds = tickets[pIdx];
        }
        return res;
    }

    static void shiftToleft(int[] array) {
        // Yahoo --> ahooY
        int first = array[0];
        int s = 0;
        int f = 1;
        while(f < array.length) {
            array[s++] = array[f++];
        }
        array[array.length - 1] = first;
    }

    static int[] leftShift(int[] array, int n) {
        if(array.length <= 1) {
            return array;
        }
        int offset = n % array.length;

        // shift to left
        reverse(array, 0, offset - 1);
        reverse(array, offset , array.length - 1);
        reverse(array, 0, array.length - 1);
        return array;
    }

    static void reverse(int [] array, int start, int end){
        int l = start;
        int r = end;
        while( l < r) {
            swap(array, l++, r--);
        }
    }

    static void swap (int [] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,6,3,4,5};
        long res = waitingTime(input, 2);
        System.out.println(res);
    }
}
