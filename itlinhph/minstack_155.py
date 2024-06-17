# https://leetcode.com/problems/min-stack/

class MinStack(object):

    def __init__(self):
        self.arr = []
        self.min_stack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.arr.append(val)
        if self.min_stack and self.min_stack[-1] < val:
            self.min_stack.append(self.min_stack[-1])
        else:
            self.min_stack.append(val)

    def pop(self):
        """
        :rtype: None
        """
        self.min_stack.pop()
        return self.arr.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.arr[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_stack[-1]

