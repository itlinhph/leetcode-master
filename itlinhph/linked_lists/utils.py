# Definition for singly-linked list.
class Node(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def node_traversal(head, name="Node traversal"):
    print("\n--- {} ---".format(name))
    cur = head
    while cur:
        print(cur.val)
        cur = cur.next

def build_list_node_from_arr(arr=[]):
    head = None
    cur = None
    for i, item in enumerate(arr):
        node = Node(val=item)
        if i == 0: # init head
            head = node
            cur = head
        else:
            cur.next = node
            cur = node
    return head