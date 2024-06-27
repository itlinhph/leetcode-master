# https://leetcode.com/problems/3sum/

class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        nums.sort()

        for i, item in enumerate(nums):
            if i > 0 and item == nums[i-1]:
                continue
            l, r = i + 1, len(nums) - 1
            while l < r:
                three_sum = item + nums[l] + nums[r]
                if three_sum > 0:
                    r -= 1
                elif three_sum < 0:
                    l += 1
                else:
                    res.append([item, nums[l], nums[r]])
                    l += 1
                    while l < r and nums[l] == nums[l-1]:
                        l += 1
        return res

if __name__ == "__main__":
    sol = Solution()
    assert sol.threeSum([-1,0,1,2,-1,-4]) == [[-1,-1,2],[-1,0,1]]
    assert sol.threeSum([0,0,0]) == [[0,0,0]]
    print("Passed!")
