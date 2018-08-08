/**
* add two numbers
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
* Explanation: 342 + 465 = 807.
*
* Definition for singly-linked list.
* struct ListNode {
*     int val;
*     ListNode *next;
*     ListNode(int x) : val(x), next(NULL) {}
* };
*/
class Solution {
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		ListNode *cur;
		ListNode *newhead;

		bool head = true;
		int carry = 0;

		if (l1 == NULL && l2 == NULL) return NULL;

		while (l1 != NULL || l2 != NULL || carry != 0)
		{
			int sum = carry;
			if (l1 == NULL && l2 != NULL) { sum += l2->val; l2 = l2->next; }
			else if (l2 == NULL && l1 != NULL) { sum += l1->val; l1 = l1->next; }
			else if (l1 == NULL && l2 == NULL) { sum += 0; }
			else
			{
				sum += l1->val + l2->val;
				l1 = l1->next;
				l2 = l2->next;
			}


			carry = sum / 10;

			ListNode *temp = new ListNode(sum % 10);

			if (head)
			{
				cur = temp;
				newhead = temp;
				head = false;
			}
			else
			{
				cur->next = temp;
				cur = cur->next;
			}

		}

		return newhead;

	}
};