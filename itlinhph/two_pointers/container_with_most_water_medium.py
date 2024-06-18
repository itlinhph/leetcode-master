# https://leetcode.com/problems/container-with-most-water/description/

class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left, right = 0, len(height) - 1
        max_area = 0
        while left < right:
            current_area = min(height[left], height[right])*(right-left)
            if current_area > max_area:
                max_area = current_area
            if height[left] < height[right]:
                left +=1
            else:
                right -=1
        return max_area
    
if __name__ == "__main__":
    sol = Solution()
    assert sol.maxArea([1,8,6,2,5,4,8,3,7]) == 49
    assert sol.maxArea([1,1]) == 1