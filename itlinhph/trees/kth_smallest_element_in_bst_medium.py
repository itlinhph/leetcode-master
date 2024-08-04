# https://leetcode.com/problems/kth-smallest-element-in-a-bst/

from utils import TreeNode

class Solution(object):
    def kthSmallest(self, root: TreeNode, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        stack = []
        cur = root
        while cur or stack:
            # dfs move to left node first
            while cur:
                stack.append(cur)
                cur = cur.left
            # use stack to remember previous travesal
            cur = stack.pop()
            
            k -= 1
            if k == 0:
                return cur.val
            
            # then move to the right node
            cur = cur.right


