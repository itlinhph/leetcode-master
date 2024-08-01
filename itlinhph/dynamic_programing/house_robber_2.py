# https://leetcode.com/problems/house-robber-ii/description/

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return max(self.rob_1(nums[1:]), self.rob_1(nums[0:-1]))
    
    def rob_1(self,  nums):
        rob1, rob2 = 0, nums[0]
        for i in range(1, len(nums)):
            rob_i = max(rob2, rob1 + nums[i]) # calculate if rob in house i
            rob1 = rob2
            rob2 = rob_i # move to next sub-problem

        return rob2