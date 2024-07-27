# https://leetcode.com/problems/house-robber/description/

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        """ 
        Convert problem into dynamic programing:  
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])

        We have two choices: 
            + ignore house_i -> value = dp[i-1])
            + rob    house_i -> value = dp[i-2] + nums[i]
        So max value in house_i = max(dp[i-1], dp[i-2] + nums[i])
        """
        rob1, rob2 = 0, nums[0]
        for i in range(1, len(nums)):
            rob_i = max(rob2, rob1 + nums[i]) # calculate if rob in house i
            rob1 = rob2
            rob2 = rob_i # move to next sub-problem

        return rob2

if __name__ == "__main__":
    sol = Solution()

    assert sol.rob([1,2,3,1]) == 4
    assert sol.rob([2,7,9,3,1]) == 12
    assert sol.rob([10,1,1,10,7,3]) == 23