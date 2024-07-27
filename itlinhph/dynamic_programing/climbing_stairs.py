# https://leetcode.com/problems/climbing-stairs/description/

class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        # the same as fibonaxi problem -> use DP to resolve
        fn1, fn2 = 0, 1
        for _ in range(0,n):
            tmp = fn2
            fn2 +=fn1
            fn1=tmp

        return fn2


if __name__ == "__main__":
    sol = Solution()
    print(sol.climbStairs(6))