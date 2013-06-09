
/*
 * Tower of Hanoi
 *
 * @author Rajeev Jha
 * @version 1.0
 *
 */

import java.util.Set;
import java.util.HashSet;

public class thanoi {

    public thanoi() { }

    private void move(int a, int current, int dest) {
        System.out.println("Move " + a + " from " + current + " to " + dest );
    }

    private void move(int a1, int a2, int current, int dest) {

        // calculate other
        int other = (1+2+3 - current - dest);
          
        if((a2-a1) <= 1 ) {
            move(a1,current,other);
            move(a2,current,dest);
            move(a1,other,dest);
            return ;
        } else {

            move(a1,a2-1,current,other);
            move(a2,current,dest);
            move(a1,a2-1,other,dest);
        }
    }

    public static void main(String[] args) throws Exception {
        int N = 4 ;
        thanoi puzzle = new thanoi();
        puzzle.move(1,N,1,3);
    }
}



