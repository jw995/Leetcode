/**
* Definition for singly-linked list.
* struct ListNode {
*     int val;
*     ListNode *next;
*     ListNode(int x) : val(x), next(NULL) {}
* };
*/

// to determine if there is a ciclein the linked list
// That's exactly what we will come across using two pointers with different speed in a linked list:
// If there is no cycle, the fast pointer will stop at the end of the linked list.
// If there is a cycle, the fast pointer will eventually meet with the slow pointer.



class Solution {
public:
	bool hasCycle(ListNode *head)
	{
		if (head == NULL) { return false; }

		ListNode *walker = head;
		ListNode *runner = head;

		while (runner->next != NULL && runner->next->next != NULL)
		{
			walker = walker->next;
			runner = runner->next->next;
			if (walker == runner)
			{
				return true;
			}
		}

		return false;
	}
};