# https://leetcode.com/problems/design-browser-history/

from utils import DoubleLinkedNode

class BrowserHistory(object):

    def __init__(self, homepage):
        """
        :type homepage: str
        """
        self.current = DoubleLinkedNode(val=homepage)

    def visit(self, url):
        """
        :type url: str
        :rtype: None
        """
        self.current.next = DoubleLinkedNode(val=url, prev=self.current)
        self.current = self.current.next

    def back(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        while steps > 0 and self.current.prev:
            self.current = self.current.prev
            steps -= 1
        return self.current.val

    def forward(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        while steps > 0 and self.current.next:
            self.current = self.current.next
            steps -= 1
        return self.current.val


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)