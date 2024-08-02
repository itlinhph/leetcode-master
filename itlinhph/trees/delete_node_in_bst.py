# https://leetcode.com/problems/delete-node-in-a-bst/description/

from utils import TreeNode

class Solution(object):
    def deleteNode(self, root, key):
        """
        :type root: TreeNode
        :type key: int
        :rtype: TreeNode
        """
        
        if key > root.val:
            root.right = self.deleteNode(root.right, key)
        elif key < root.val:
            root.left = self.deleteNode(root.left, key)
        else: # find the target node 
            # case 1: target has only one child/no child:
            if not root.left:
                return root.right
            elif not root.right:
                return root.left
            # case 2: target has 2 childs
            else:
                min_node = self.find_min(root.right)
                root.val = min_node
                root.right = self.deleteNode(root.right, min_node.val)
        return root

    def find_min(self, root):
        cur = root
        while cur and cur.left:
            cur = cur.left
        return cur