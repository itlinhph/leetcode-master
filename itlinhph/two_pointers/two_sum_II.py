# https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        left, right = 0, len(numbers) - 1
        while left < right:
            if numbers[left] + numbers[right] > target:
                right -= 1
            elif numbers[left] + numbers[right] < target:
                left += 1
            else:
                return [left+1, right+1]
        return []
    

if __name__ == "__main__":
    sol = Solution()
    assert sol.twoSum([2,7,11,15], 9) == [1,2]
    assert sol.twoSum([2,3,4], 6) == [1,3]
    assert sol.twoSum([-1,0], -1) == [1,2]

