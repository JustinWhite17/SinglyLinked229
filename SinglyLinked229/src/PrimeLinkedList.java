import java.util.Scanner;

public class PrimeLinkedList {
    static class Node {
        int data;
        Node next;

        //node for linked list
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //created a method to check if int is prime
    public static boolean Prime(int n) {
        if (n <= 1)
        return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
           if (n % i == 0)
             return false;
        }
        return true;
    }
    //check if int has 3
    public static boolean hasThree(int n) {
        while (n > 0) {
            if (n % 10 == 3)
                return true;
            n /= 10;
        }
        return false;
    }
    //sum of all the nodes in the linked list
    public static int getSum(Node head) {
        int sum = 0;
        while (head != null) {
            sum += head.data;
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a value under a million:  ");
        int n = input.nextInt();

        Node head = null;
        Node tail = null;
        Node headWithThree = null;
        Node tailWithThree = null;

     // If prime, creates a new node and adds it to the end of the linked list
        for (int i = 2; i <= n; i++) {
            if (Prime(i)) {
                Node newNode = new Node(i);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
                if (hasThree(i)) {
                    Node newNodeWithThree = new Node(i);
                    if (headWithThree == null) {
                        headWithThree = newNodeWithThree;
                        tailWithThree = newNodeWithThree;
                    } else {
                        tailWithThree.next = newNodeWithThree;
                        tailWithThree = newNodeWithThree;
                    }
                }
            }
        }

        System.out.print("Prime numbers with 3: ");
        Node current = headWithThree;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        int sum = getSum(headWithThree);
        System.out.println("Sum of prime numbers with the number 3: " + sum);
    }
}

