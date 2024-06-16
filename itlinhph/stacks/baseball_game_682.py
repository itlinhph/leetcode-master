# https://leetcode.com/problems/baseball-game/

class Solution(object):
    def calPoints(self, operations):
        """
        :type operations: List[str]
        :rtype: int
        """
        total_point = 0
        stack = []
        for item in operations:
            if item == "C":
                stack.pop()
            elif item == "D":
                stack.append(stack[-1]*2)
            elif item == "+":
                stack.append(stack[-1]+ stack[-2])
            else:
                stack.append(int(item))
        
        total_point = sum(stack)

        return total_point
    

if __name__ == "__main__":
    baseball = Solution()
    ops = ["5","2","C","D","+"]
    points = baseball.calPoints(ops)
    print(points)
    assert points == 30
    ops = ["5","-2","4","C","D","9","+","+"]
    points = baseball.calPoints(ops)
    print(points)
    