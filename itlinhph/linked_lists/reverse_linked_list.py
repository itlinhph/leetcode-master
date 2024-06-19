# https://leetcode.com/problems/reverse-linked-list/description/

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # create a tmp next node, then update cursor to prev node
        prev = None
        while head:
            next = head.next
            head.next = prev
            prev = head
            head = next
        return prev


def print_node(head):
    cur = head
    print("\n--- Node traversal ---")
    while cur:
        print(cur.val)
        cur = cur.next

if __name__ == "__main__":
    # build list node
    arr = [1,2,3,4,5]
    head = ListNode(val=arr[0])
    cur_node = head
    for i in range(1, len(arr)):
        node = ListNode(val=arr[i])
        cur_node.next = node
        cur_node = cur_node.next
    
    print_node(head)

    # reverse list node
    sol = Solution()
    reversed = sol.reverseList(head)

    print_node(reversed)
