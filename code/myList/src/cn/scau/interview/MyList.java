package cn.scau.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyList {
	private Node head;

	private class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	/**
	 * 
	 * @param data
	 */
	public void add(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	/**
	 * 顺序打印链表
	 * 
	 */
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
    /**
     * 逆序打印链表
     * 使用栈实现
     */
	public void reversePrint() {
		if (head == null) {
			throw new NullPointerException("链表为空!");
		}
		LinkedList<Integer> stack = new LinkedList<>();
		Node temp = head;
		while(temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		while(stack.size()!=0) {
			int v = stack.pop();
			System.out.print(v+" ");
		}
	}
	
	public int size() {	
		int size = 0;
		Node temp = head;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	/**
	 * 查找链表倒数第k个结点的值 只遍历一次链表 实现：使用两个指针同时指向链表头结点，第一个链表向前遍历k-1个结点后，
	 * 第二个节点也开始向后遍历，当第一个节点遍历到末尾时， 第二个结点此时对应的结点为倒数第k个结点
	 * 
	 * @param k 倒数第k个结点
	 * @return  倒数第k个结点的值
	 */
	public int findKNode(int k) {
		if (head == null) {
			throw new NullPointerException("链表为空!");
		}
		int data = 0;
		Node temp1 = head;
		Node temp2 = head;
		int i = 0;
		for (; i < k - 1 && temp1.next != null; i++) {
			temp1 = temp1.next;
		}
		if (i < k - 1 || k <= 0) {
			throw new NullPointerException("k不合法！");
		}
		while (temp1.next != null) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		data = temp2.data;
		return data;
	}
    /**
     * 反转链表
     */
	public void reverse() {
		if (head == null) {
			throw new NullPointerException("链表为空!");
		}
		MyList listTemp = new MyList();
		listTemp.head = head;
		Node head2 = listTemp.head;
		Node temp = head2.next;
		head2.next = null;
		Node behind = head2;
		while(temp!=null) {
			Node node  = new Node(temp.data);
			node.next = behind;
			behind = node;
			temp = temp.next;
		}
		head = behind;
	}
	
	public MyList reverse2() {
		if (head == null) {
			throw new NullPointerException("链表为空!");
		}	  
		Node temp = head.next;
		head.next = null;
		Node behind = head;
		while(temp!=null) {
			Node node  = new Node(temp.data);
			node.next = behind;
			behind = node;
			temp = temp.next;
		}
		MyList reverseList = new MyList();
		reverseList.head = behind;
		return reverseList;
	}


}
