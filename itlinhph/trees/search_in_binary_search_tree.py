# https://leetcode.com/problems/search-in-a-binary-search-tree/

from utils import TreeNode

class Solution:
    def searchBST(self, root: TreeNode, val: int):
        if not root:
            return None
        if val > root.val:
            return self.searchBST(root.right, val)
        elif val < root.val:
            return self.searchBST(root.left, val)
        else:
            return root
