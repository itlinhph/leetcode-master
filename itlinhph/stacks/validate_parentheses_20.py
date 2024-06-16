# https://leetcode.com/problems/valid-parentheses/description/

opposite_char = {
    "}": "{",
    ")": "(",
    "]": "["
}
open_char = "{(["
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        for item in s:
            if item in open_char:
                stack.append(item)
            else:
                if not stack:
                    return False
                opp_char = opposite_char[item]
                if stack.pop() != opp_char:
                    return False
        if stack:
            return False
        return True
    
if __name__ == "__main__":
    valid_parenthese = Solution()
    assert valid_parenthese.isValid("()[]{}") == True
    assert valid_parenthese.isValid("()[]{") == False
    assert valid_parenthese.isValid("({[]}){}") == True
    assert valid_parenthese.isValid("(]") == False

