
/*
 * 8-queen problem  using brute force searching
 * This solutions uses following strategies 
 *
 * 1 - fix one queen in one column and generate all
 * non-conflicting permutations - N! in total  
 * this is akin to solving the N-rook problem
 * 2- eliminate from N! permutations - that do not 
 * pass the additional diagonal test 
 * 
 * @author Rajeev Jha
 * @version 1.0
 *
 */

import java.util.Set;
import java.util.HashSet;

public class queen8 {

    private int[] columns ;
    private char[] colNames ;
    private int size ;
    private int solutions ;
    
    public queen8(int N) { 
        this.columns = new int[N] ; 
    	for(int i=0 ; i < N ; i++) this.columns[i] = i+1 ;

        this.colNames = new char[N] ; 
        char a = 'A' ;
    	for(int i=0 ; i < N ; i++) this.colNames[i] = (char) (a + i) ;

        this.size = N ;
        this.solutions = 0 ;
    }

    private void solve() {
        this.generate(this.size);
    }

    /* 
     * permutation generator using a backtracking algo
     * from http://www.cs.princeton.edu/~rs/talks/perms.pdf */

    private void generate(int N){
    	int c ;
        /* factorial 1, 1! case,just one possibility,print that ..*/
        if ( N == 0 ) test_diagonal(); 
        //algorithm adjusted for zero-based indexes ..
        for(c = 0 ; c < N ; c++){
            swap(c,N-1);
            generate(N-1);
            swap(c,N-1);
        }
    
    } 

    /* swap for permutation */
    private void swap(int x, int y){
    	int tmp = this.columns[x] ;
        this.columns[x] = this.columns[y] ;
        this.columns[y] = tmp ;
    
    }

    /* for position of a queen in a column (a permutation)
     * diagonal positions are given by moving 
     * one row up in next column and one row down in 
     * previous column */

    private void test_diagonal(){
        int x ;

    	for(int i = 0 ; i < this.columns.length ; i++) {
            x = this.columns[i] ;
            for(int j = i+1, k = 1; j < this.columns.length ; j++, k++) {
                if((x+k) == this.columns[j]) return ;
                if((x-k) == this.columns[j]) return ;
            }
        }

        // diagonal test passed
        print_board();
    }

    private void print_board() {

    	for(int i = 0 ; i < this.columns.length ; i++) {
            System.out.print(this.colNames[i]);
            System.out.print(this.columns[i] + " ");
        }

        System.out.println();
        this.solutions++ ;

    }

    private int getNumSolutions() {
        return this.solutions ;
    }
   
    public static void main(String[] args) throws Exception {
        queen8 board = new queen8(8);
        board.solve();
        System.out.println(" \n Total " + board.getNumSolutions() + " solutions " );

    }
}



