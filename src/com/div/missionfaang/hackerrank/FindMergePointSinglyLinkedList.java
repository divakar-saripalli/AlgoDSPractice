package src.com.div.missionfaang.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindMergePointSinglyLinkedList {

    static class SinglyLinkedListNode {
	public int data;
	public SinglyLinkedListNode next;

	public SinglyLinkedListNode(int nodeData) {
	    this.data = nodeData;
	    this.next = null;
	}
    }

    static class SinglyLinkedList {
	public SinglyLinkedListNode head;
	public SinglyLinkedListNode tail;

	public SinglyLinkedList() {
	    this.head = null;
	    this.tail = null;
	}

	public void insertNode(int nodeData) {
	    SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

	    if (this.head == null) {
		this.head = node;
	    } else {
		this.tail.next = node;
	    }

	    this.tail = node;
	}
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
	while (node != null) {
	    System.out.print(String.valueOf(node.data) + ", ");
	    node = node.next;
	}
    }

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
	int list1Length = length(head1);
	int list2Length = length(head2);
	int difference = Math.abs(list1Length - list2Length);
	System.out.println("Difference in length :: " + difference);
	System.out.println("List1 in length :: " + list1Length);
	System.out.println("List2 in length :: " + list2Length);
	printSinglyLinkedList(head1);
	printSinglyLinkedList(head2);
	if(list1Length == 0 || list2Length == 0){
	    return 0;
	}
	if(list2Length > list1Length){
	    SinglyLinkedListNode temp = head1;
	    head1 = head2;
	    head2 = temp;
	}
	for(int i = 0; i < difference; i++){
	    head1 = head1.next;
	}

	while(head1!= null && head2 != null){
	    if(head1 == head2){
		return head1.data;
	    }
	    head1 = head1.next;
	    head2 = head2.next;
	}
	return 0;

    }

    static int length(SinglyLinkedListNode head){
	int length = 0;
	while(head.next != null){
	    length++;
	    head = head.next;
	}
	return length;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
	int tests = scanner.nextInt();
	scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	for (int testsItr = 0; testsItr < tests; testsItr++) {
	    int index = scanner.nextInt();
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	    SinglyLinkedList llist1 = new SinglyLinkedList();

	    int llist1Count = scanner.nextInt();
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	    for (int i = 0; i < llist1Count; i++) {
		int llist1Item = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		llist1.insertNode(llist1Item);
	    }

	    SinglyLinkedList llist2 = new SinglyLinkedList();

	    int llist2Count = scanner.nextInt();
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	    for (int i = 0; i < llist2Count; i++) {
		int llist2Item = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		llist2.insertNode(llist2Item);
	    }

	    SinglyLinkedListNode ptr1 = llist1.head;
	    SinglyLinkedListNode ptr2 = llist2.head;

	    for (int i = 0; i < llist1Count; i++) {
		if (i < index) {
		    ptr1 = ptr1.next;
		}
	    }

	    for (int i = 0; i < llist2Count; i++) {
		if (i != llist2Count-1) {
		    ptr2 = ptr2.next;
		}
	    }

	    ptr2.next = ptr1;

	    System.out.println(findMergeNode(llist1.head, llist2.head));
	}
	scanner.close();
    }
}