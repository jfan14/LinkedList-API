import java.io.*;
import java.util.*;

public class LinkedinList {

    Node first, last;


    class Node {
        int data;
        Node next;
    }

    public static void main(String [] args) throws Exception{
        LinkedinList l = new LinkedinList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char command = 'k';
        while(command != 'q') {
            System.out.println("Please choose your option: " +
                    "\n1.Create a List." +
                    "\n2.Print a List." +
                    "\n3.Insert a node into List." +
                    "\n4.Search a node in List." +
                    "\n5.Sort Linked List Element." +
                    "\n6.Print Linked List reverse order" +
                    "\n7.Concatenate Two Linked List (Without creating third list)." +
                    "\n8.Concatenate Two Linked List (With creating third list)." +
                    "\n9.Merge Two Linked List (With creating third list)" +
                    "\n10.Merge Two Linked List (Without creating third list)" +
                    "\n11.Merge Two Linked List and Sort with third list" +
                    "\n12.Merge Two Linked List and Sort without third list" +
                    "\n13.Search and Delete." +
                    "\n15,Reverse Node of List");
            int option = Integer.parseInt(br.readLine());
            switch (option) {
                case 1:
                    l.createList();
                    break;
                case 2:
                    l.printList();
                    break;
                case 3:
                    System.out.println("Enter the position you want to insert: ");
                    int position = Integer.parseInt(br.readLine());
                    System.out.println("Enter the data for this node: ");
                    int data = Integer.parseInt(br.readLine());
                    l.insertNode(position, data);
                    break;
                case 4:
                    System.out.println("Enter the number you want to search: ");
                    int target = Integer.parseInt(br.readLine());
                    l.searchList(target);
                    break;
                case 5:
                    l.sortList();
                    break;
                case 6:
                    l.printReverse();
                    break;
                case 7:
                    System.out.println("Create your first linked List: ");
                    Node n1 = l.createList();
                    System.out.println("Create your second linked List: ");
                    Node n2 = l.createList();
                    l.concatList(n1,n2);
                    break;
                case 8:
                    System.out.println("Create your first linked List: ");
                    Node n3 = l.createList();
                    System.out.println("Create your second linked List: ");
                    Node n4 = l.createList();
                    l.concatList2(n3,n4);
                    break;
                case 9:
                    System.out.println("Create your first linked List: ");
                    Node n5 = l.createList();
                    System.out.println("Create your second linked List: ");
                    Node n6 = l.createList();
                    l.mergeList(n5,n6);
                    break;
                case 10:
                    System.out.println("Create your first linked List: ");
                    Node n7 = l.createList();
                    System.out.println("Create your second linked List: ");
                    Node n8 = l.createList();
                    l.mergeList2(n7,n8);
                    break;
                case 11:
                    System.out.println("Create your first linked List: ");
                    Node n9 = l.createList();
                    System.out.println("Create your second linked List: ");
                    Node n10 = l.createList();
                    l.mergeListSort(n9,n10);
                    break;
                case 12:
                    System.out.println("Create your first linked List: ");
                    Node n11 = l.createList();
                    System.out.println("Create your second linked List: ");
                    Node n12 = l.createList();
                    l.mergeListSort2(n11,n12);
                    break;
                case 13:
                    System.out.println("Enter the data that you want to search: ");
                    int goal = Integer.parseInt(br.readLine());
                    l.searchDelete(goal);
                    break;
                case 14:
                    System.out.println("Create you list first: ");
                    l.createList();
                    l.searchGreatestandSmallest();
                case 15:
                    System.out.println("Create the list that you want to reverse the order");
                    l.createList();
                    l.reverseNode();
                    break;
                default:
                    System.out.println("quitting");
                    command = 'q';
            }
        }
    }
    //================Create a List==================//
    public Node createList() throws Exception {
        //LinkedinList l = new LinkedinList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = new Node();
        System.out.println("Enter data for this node: ");
        first.data = Integer.parseInt(br.readLine());
        first.next = null;
        last = first;

        System.out.println("Do you want to add more nodes? 1 for yes 0 for no");
        int choice = Integer.parseInt(br.readLine());
        while(choice == 1) {
            Node node = new Node();
            System.out.println("Enter data for this node: ");
            node.data = Integer.parseInt(br.readLine());
            last.next = node;
            node.next = null;
            last = node;

            System.out.println("Do you want to add more nodes? 1 for yes 0 for no");
            choice = Integer.parseInt(br.readLine());
        }

        System.out.println("List Created");
        return first;
    }
    //================Print the List==================//
    public void printList() {
        Node temp = first;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    //================Insert a node into List==================//
    public void insertNode(int position, int data) {
        int counter = 1;
        if(position <= 0) {
            System.out.println("Position not valid");
            return;
        }

        if(position == 1) {
            Node node = new Node();
            node.data = data;
            node.next = first;
            first = node;
            System.out.println("Node added");
        }

        Node node = first;
        while(counter < position-1 && node != null) {
            node = node.next;
            counter++;
        }

        if(node == null) {
            System.out.println("Invalid position");
        }

        Node n = new Node();
        n.data = data;
        n.next = node.next;
        node.next = n;
        System.out.println("Node added");
    }
    //================Search element in a List==================//
    public void searchList(int target) {
        Node temp = first;
        int counter = 1;
        while(temp != null) {
            if(temp.data == target) {
                System.out.println("Node is at position: " + counter);
                return;
            }
            temp = temp.next;
            counter++;
        }
        System.out.println("Cannot find node in this list");
    }
    //================Sort element in a List==================//
    public void sortList() {
        List<Integer> l = new ArrayList<>();
        Node temp = first;
        while(temp != null) {
            l.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(l);
        System.out.println(l);
    }
    //================Print list in reverse order==================//
    public void printReverse() {
        Node node = first;
        Stack stack = new Stack();
        while(node != null) {
            stack.push(node.data);
            node = node.next;
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
    //================Print list in reverse order==================//
    public void concatList(Node n1, Node n2) {

        Node temp = n1;
        while(temp.next != null) {
            temp = temp.next;
        }

        //System.out.println(n1.data);
        temp.next = n2;
        while(n1 != null) {
            System.out.println(n1.data);
            n1 = n1.next;
        }
    }
    //================Print list in reverse order==================//
    public void concatList2(Node n1, Node n2) {
        LinkedinList l = new LinkedinList();
        int counter = 1;
        while(n1 != null) {
            l.insertNode(n1.data,counter++);
            n1 = n1.next;
            //counter++;
        }

        while(n2 != null) {
            l.insertNode(n2.data,counter++);
            n2 = n2.next;
            //counter++;
        }
        l.printList();
    }
    //================Merge two Linked List with third list==================//
    public void mergeList(Node n1, Node n2) {
        Node temp = new Node();
        Node head = temp;
        while(n1 != null && n2 != null) {
            temp.next = n1;
            n1 = n1.next;
            temp = temp.next;
            temp.next = n2;
            n2 = n2.next;
            temp = temp.next;
        }
        if(n1 == null) {
            temp.next = n2;
        }else{
            temp.next = n1;
        }
        head = head.next;
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
    //================Merge two Linked List without third list==================//
    public void mergeList2(Node n1, Node n2) {
        Node temp = n1;
        Node head = temp;
        n1 = n1.next;
        while(n1 != null && n2 != null) {
            temp.next = n2;
            n2 = n2.next;
            temp = temp.next;
            temp.next = n1;
            n1 = n1.next;
            temp = temp.next;
        }
        if(n1 == null) {
            temp.next = n2;
        }else{
            temp.next = n1;
        }
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
    //================Merge two Linked List and Sort==================//
    public void mergeListSort(Node n1, Node n2) {
        Node temp = new Node();
        Node head = temp;
        while(n1 != null && n2 != null) {
            if(n1.data < n2.data) {
                temp.next = n1;
                n1 = n1.next;
            }else{
                temp.next = n2;
                n2 = n2.next;
            }
            temp = temp.next;
            if(n1 == null) {
                temp.next = n2;
            }else{
                temp.next = n1;
            }
        }
        head = head.next;
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
    //================Merge two Linked List and Sort without third list==================//
    public void mergeListSort2(Node n1, Node n2) {
        Node temp = n1;
        Node head = temp;
        n1 = n1.next;
        while(n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                temp.next = n1;
                n1 = n1.next;
            } else {
                temp.next = n2;
                n2 = n2.next;
            }
            temp = temp.next;
            if (n1 == null) {
                temp.next = n2;
            } else {
                temp.next = n1;
            }
        }
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
    //================Search and Delete==================//
    public void searchDelete(int data) {

        int position = 1;
        Node temp = first;
        while(temp != null) {
            if(temp == null) {
                System.out.println("Data not exist");
            }
            if(temp.data == data && position == 1) {
                first = first.next;
                temp = null;
                System.out.println("Deleted");
                Node tempy = first;
                while(tempy != null) {
                    System.out.println(tempy.data);
                    tempy = tempy.next;
                }
                return;
            }else{
                Node prev = temp;
                temp = temp.next;
                if(temp == null) {
                    System.out.println("Data not exist");
                }
                if(temp != null && temp.data == data) {
                    prev.next = temp.next;
                    temp = null;
                    System.out.println("Deleted");
                    Node tempy = first;
                    while(tempy != null) {
                        System.out.println(tempy.data);
                        tempy = tempy.next;
                    }
                    return;
                }
                prev = temp;
                temp = temp.next;

            }
            position++;
        }
        System.out.println("Position not valid");
    }
    //================Reverse Node==================//
    public void reverseNode() {
        Node head = first;
        Node prev = null;
        while(head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        Node t = prev;
        while(t != null) {
            System.out.println(t.data);
            t = t.next;
        }
    }
    //================Get Greatest and Smallest Node==================//
    public void searchGreatestandSmallest() {
        Node temp = first;
        int max = temp.data;
        int smallest = temp.data;
        while(temp != null) {
            if(temp.data > max) {
                max = temp.data;
            }
            if(temp.data < smallest) {
                smallest = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Largest number is: " + max + " Smallest number is: " + smallest);
    }
}
