# https://leetcode.com/problems/merge-two-sorted-lists/description/
from utils import Node, build_list_node_from_arr, node_traversal

class Solution(object):
    def mergeTwoLists(self, list1: Node, list2: Node):
        """
        :type list1: Optional[Node]
        :type list2: Optional[Node]
        :rtype: Optional[Node]
        """

        # find the head.
        # if list1.val < list2.val:
        #     head = list1
        #     list1 = list1.next
        # else:
        #     head = list2
        #     list2 = list2.next
        
        head = Node() # we have to use this way for empty node case!
        # merge two lists into main chain
        cur = head
        while list1 and list2:
            if list1.val > list2.val:
                cur.next = list2
                list2 = list2.next
                cur = cur.next
            else:
                cur.next = list1
                list1 = list1.next
                cur = cur.next
        # add remain chain in to main list
        if list1:
            cur.next = list1
        else:
            cur.next = list2

        return head

if __name__ == "__main__":
    list_node1 = build_list_node_from_arr(arr=[1,4,5,6])
    list_node2 = build_list_node_from_arr(arr=[2,3,4,6,7])
    
    # merge
    # Output will be like this: [1,2,3,4,4,5,6,6,7]
    sol = Solution()
    merged = sol.mergeTwoLists(list_node1, list_node2)
    
    node_traversal(head=merged, name="Merged")