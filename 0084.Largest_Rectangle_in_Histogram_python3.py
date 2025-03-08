#59ms 99.72%RT 20250308


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # Adding a zero avoids ending with incomplete rects
        heights.append(0)
        # profile[i] = (h, s) -> A rectangle of height h can start as far back as index s. Sorted by height
        profile = []
        largest_area = 0
        prev_h = 0
        for i, height in enumerate(heights):
            if height == prev_h:
                continue
            prev_h = height
            current_height_start = i
            while profile:
                h, start = profile[-1]
                if h <= height:
                    break
                profile.pop()
                area = (i - start) * h
                current_height_start = start
                if area > largest_area:
                    largest_area = area
            if not profile or profile[-1][0] != height:
                profile.append((height, current_height_start))
        return largest_area
