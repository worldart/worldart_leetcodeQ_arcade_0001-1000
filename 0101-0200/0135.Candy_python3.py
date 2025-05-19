#15ms



class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        total_candies = n
        i = 1

        while i < n:
            if ratings[i] == ratings[i - 1]:
                i += 1
                continue

            current_peak = 0
            while i < n and ratings[i] > ratings[i - 1]:
                current_peak += 1
                total_candies += current_peak
                i += 1
            
            if i == n:
                return total_candies

            current_valley = 0
            while i < n and ratings[i] < ratings[i - 1]:
                current_valley += 1
                total_candies += current_valley
                i += 1

            total_candies -= min(current_peak, current_valley)

        return total_candies





#23ms




class Solution:
    def candy(self, ratings: List[int]) -> int:
        res = [1] * len(ratings)

        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                res[i] = max(res[i], res[i - 1] + 1)
            
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                res[i] = max(res[i], res[i + 1] + 1)

        return sum(res)




#7ms







class Solution:
    def candy(self, ratings: List[int]) -> int:
        # manage edge cases
        prev = ratings[0]
        ratings.append(ratings[-1])

        ans = h = 0
        n = len(ratings)
        lagging = -1
        for i in range(n):
            curr = ratings[i]
            if prev > curr:  # not update lagging
                h -= 1
            else:  # update lagging and correct if necessary
                if lagging < i - 1:
                    correction = 1 - h
                    if correction < 0:
                        lagging += 1
                    ans += correction * (i - lagging)
                    h = 1
                lagging = i
                if prev == curr:
                    h = 1
                elif prev < curr:
                    h += 1
            ans += h
            prev = curr
        return ans - 1


        # # manage edge cases
        # prev = ratings[0]
        # ratings.append(ratings[-1])

        # n = len(ratings)
        # lagging = -1
        # for i in range(n):
        #     curr = ratings[i]
        #     if prev > curr:  # not update lagging
        #         ratings[i] = ratings[i - 1] - 1
        #     else:  # update lagging and correct if necessary
        #         if lagging < i - 1:
        #             correction = 1 - ratings[i - 1]
        #             if correction < 0:
        #                 lagging += 1
        #             for j in range(lagging, i):  # excluding i
        #                 ratings[j] += correction
        #         lagging = i
        #         if prev == curr:
        #             ratings[i] = 1
        #         elif prev < curr:
        #             ratings[i] = ratings[i - 1] + 1
        #     prev = curr
        # return sum(ratings) - 1  # - 1 is artifact from right edge case mgnt
