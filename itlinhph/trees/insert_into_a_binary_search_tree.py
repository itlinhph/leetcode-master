# https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
from utils import TreeNode

class Solution(object):
    def insertIntoBST(self, root: TreeNode, val: int):
        """
        :type root: TreeNode
        :type val: int
        :rtype: TreeNode
        """
        if not root.val:
            return TreeNode(val)
        if val > root.val:
            root.right = self.insertIntoBST(root.right, val)
        else:
            root.left = self.insertIntoBST(root.left, val)
        
        return root
    
    def insertIntoBST_2(self, root: TreeNode, val: int):
        cur = root
        if not cur:
            return TreeNode(val=val)
        while True:
            if val > cur.val:
                if cur.right:
                    cur = cur.right
                else:
                    cur.right = TreeNode(val=val)
                    break
            else:
                if cur.left:
                    cur = cur.left
                else:
                    cur.left = TreeNode(val=val)
                    break

        return root
