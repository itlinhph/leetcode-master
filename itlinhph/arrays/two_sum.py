# https://leetcode.com/problems/two-sum/description/

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        remain_map = {}
        for i, item in enumerate(nums):
            remain_map[target - item] = i
        
        for j, item in enumerate(nums):
            if remain_map.get(item) is not None and remain_map.get(item) != j:
                return [j, remain_map[item]]
        return []

if __name__ == "__main__":
    sol = Solution()
    assert sol.twoSum(nums = [2,7,11,4,15], target = 18) == [1, 2]