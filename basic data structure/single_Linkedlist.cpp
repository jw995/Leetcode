#include <stdio.h>
#include <stdlib.h>

struct Node {
	int value;
	Node *next;
};


class MyLinkedList {

private:
	Node *head, *tail;

public:
	/** Initialize your data structure here. */
	MyLinkedList() {
		head = NULL;
		tail = NULL;
	}


	void print_list()
	{
		Node *cur;
		if (head != NULL)
		{
			cur = head;
			while (cur != NULL)
			{
				printf("%d..", cur->value);
				cur = cur->next;
			}
		}

	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	int get(int index) {

		Node *cur;
		if (head != NULL)
		{
			cur = head;
			for (int i = 1; i<index; i++)
			{
				if (cur->next != NULL)
				{
					cur = cur->next;
				}
				else
				{
					printf("\nthe index %d is invalid.\n");
					return -1;
				}

			}
			return cur->value;
		}

		return -1;
	}


	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	void addAtHead(int val) {
		Node *cur = new Node;
		cur->value = val;

		if (head == NULL)
		{
			head = cur;
			tail = cur;
			cur->next = NULL;
		}
		else
		{
			cur->next = head;
			head = cur;
		}
	}

	/** Append a node of value val to the last element of the linked list. */
	void addAtTail(int val) {
		Node *cur = new Node;
		cur->value = val;
		cur->next = NULL;

		// if is the first node
		if (head == NULL)
		{
			head = cur;
			tail = cur;
		}
		else
		{
			tail->next = cur;
			tail = cur;   //tail=tail->next;
		}

	}

	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	void addAtIndex(int index, int val) {
		Node *prev, *after;
		Node *cur = new Node;
		cur->value = val;

		if (head == NULL)
		{
			head = cur;
			tail = cur;
			cur->next = NULL;
		}
		else if (index == 1)
		{
			cur->next = head;
			head = cur;
		}
		else
		{
			prev = head;

			for (int i = 2; i<index; i++)
			{
				prev = prev->next;
			}
			after = prev->next;
			prev->next = cur;
			cur->next = after;

		}

	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	void deleteAtIndex(int index) {
		if (head != NULL)
		{
			Node *prev = head;

			if (index == 1)
			{
				head = head->next;
			}
			else
			{
				for (int i = 2; i<index; i++)
				{
					prev = prev->next;
				}
				if (prev->next != NULL)
				{
					prev->next = prev->next->next;
				}
			}

		}

	}
};

/**
* Your MyLinkedList object will be instantiated and called as such:
* MyLinkedList obj = new MyLinkedList();
* int param_1 = obj.get(index);
* obj.addAtHead(val);
* obj.addAtTail(val);
* obj.addAtIndex(index,val);
* obj.deleteAtIndex(index);
*/

int main()
{
	MyLinkedList obj;
	obj.addAtHead(1);
	obj.addAtTail(13);
	obj.addAtTail(19);
	obj.addAtIndex(2, 2);
	obj.addAtIndex(5, 8);
	obj.print_list();
	printf("\n");

	obj.deleteAtIndex(4);
	obj.print_list();
	int param_1 = obj.get(6);
	printf("\nthe number you are getting is %d\n", param_1);


	return 0;
}
