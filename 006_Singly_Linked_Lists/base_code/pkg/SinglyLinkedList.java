package pkg;
import java.util.Scanner;
import java.util.Random;


public class SinglyLinkedList {
Node head = null;
    public SinglyLinkedList() {
    }
    public int get(int pos) {
        //temp = first node in cycle(i.e.=if 1 points to 2, then 1 is list);
        Node temp = head;
        if(pos-1>this.length(this.head))
            return -1;
        //cycles through for loop until temp is on desired node
        for(int i = 0; i < pos-1; ++i) {
            temp = temp.getNext();
        }
        // System.out.println("\nNode: "+temp.getData());
        return temp.getData();
    }

    public void insert(int pos, int data) {  
        //temp=node to be inserted
        //list=copy of list of Nodes
        //add = contains all of the lost linked Nodes from having list point to temp from anywhere except the end.
        Node temp = new Node(data);
        Node list = this.head;
        Node add = null;
        if (list!=null) {
        //in case that list exsists, makes add equal to list-first node.
            add = list.getNext();
        }
        //if list doesn't exsist, then temp becomes first node in list
        if (head == null) {
            head = temp;
        //if position is 0, then head becomes new node, then points to list
        } else if (pos == 1) {
            this.head = new Node(data);
            this.head.setNext(list);
        } else {
            for(int c = 1; c < pos-1; c++) {
                   if (list.getNext() != null) {
                        list = list.getNext();
                        add = list.getNext();
                    } 
            }
            list.setNext(temp);
            temp.setNext(add);
            
        }
    }

    public void remove(int pos) {
        Node temp = this.head;
        //checks for position in comparison to length of list.  If position is greater than length, then No change will happen.
        if(pos==1)
            this.head=this.head.getNext();
        else if(pos==this.length(this.head))
        {
            for(int i = 0; i < this.length(this.head)-2; i++) 
                temp=temp.getNext();
            temp.setNext(null);
        }
        else if (pos <= this.length(this.head)) {
            for(int i = 1; i < this.length(this.head); i++) {
                if (i != pos-1) {
                //checks for if i has reached the desired position to be removed.  temp is then set to next node
                    temp = temp.getNext();
                } 
                else {
                    //Makes temp skip desired value, "removing" it from the list.  Makes node before desired point to node after desired.
                    //temp.getNext() happens twice since original if statement is not called to cycle the list one forward
                    temp.setNext(temp.getNext().getNext());
                }
            }
        } 
        else {
            System.out.println("No Change");
        }

    }

    public void swap(int pos1, int pos2) {
        // //Node first and second take on the desired nodes to swap
        //swaps pos1 and pos2 to ensure that pos1 is less than or equal to pos2.  Helps with inserts later
        if(pos1>pos2)
        {
            int temp=pos1;
            pos1=pos2;
            pos2=temp;
        }
        Node first = new Node(this.get(pos1));
        System.out.println("First node: "+first.getData());
        Node second = new Node(this.get(pos2));
        System.out.println("Second node: "+second.getData());
        this.remove(pos1);
        //pos2-1 since list currently is missing one node due to removal of 1.
        this.remove(pos2-1);
        this.printList();
        //reinserts first and second node.  pos2 no longer needs to be two subtracted since pos1 is reinserted by the time it is called
        this.insert(pos1, second.getData());
        System.out.println("Position: "+pos1);
        this.insert(pos2, first.getData());
        this.printList();
        
    }
    public void reverse(){
        int len=this.length(this.head);
        for(int i=1; i<len/2+1; i++){
            this.swap(i,len-i+1);
        }
    }

    public void printList() {
        //Cycles through list and prints out all values
        System.out.println("length of list: " + this.length(this.head));
        for(Node temp = this.head; temp != null; temp = temp.getNext()) {
            System.out.println(temp.getData());
        }
        System.out.println("\n");
        System.out.println("\n");


    }

    private int length(Node insert) {
        return insert == null ? 0 : 1 + this.length(insert.getNext());
    }
}
