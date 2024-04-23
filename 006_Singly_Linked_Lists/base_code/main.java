import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
	SinglyLinkedList n = new SinglyLinkedList();
        for(int i=1; i<7; i++){
            int temp = ((int)(Math.random()*253));
            n.insert(i, i);
        }
        //testing cases
        // n.swap(1, 2);

        // n.remove(1);
        // n.insert(3,2);
        n.printList();
        n.reverse();
        n.printList();
	}
}
