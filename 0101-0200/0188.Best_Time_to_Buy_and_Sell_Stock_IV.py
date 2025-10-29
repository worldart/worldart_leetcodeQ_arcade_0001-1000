//3ms




class DoubleLinkListNode:
    def __init__(self, ind, pre = None, next = None):
        self.ind = ind
        self.pre = pre if pre else self
        self.next = next if next else self

class Solution:
    def MinMaxList(self, arr: List[int]) -> List[int]:
        n = len(arr)
        if n == 0:
            return []
        sign = -1
        res = [9999]
        for num in arr:
            if num * sign > res[-1] * sign:
                res[-1] = num
            else:
                res.append(num)
                sign *= -1
        if len(res) & 1:
            res.pop()
        return res
    def maxProfit(self, k: int, prices: List[int]) -> int:
        newP = self.MinMaxList(prices)
        n = len(newP)
        m = n // 2
        res = 0
        for i in range(m):
            res += newP[i*2+1] - newP[i*2]
        if m <= k:
            return res
        head, tail = DoubleLinkListNode(-1), DoubleLinkListNode(-1)
        NodeList = [DoubleLinkListNode(0, head)]
        for i in range(1, n):
            NodeList.append(DoubleLinkListNode(i, NodeList[-1]))
            NodeList[i-1].next = NodeList[i]
        NodeList[n-1].next = tail
        head.next, tail.pre = NodeList[0], NodeList[n-1]
        heap = []
        for i in range(n-1):
            if i&1:
                heappush(heap, [newP[i] - newP[i+1], i, i+1, 0])
            else:
                heappush(heap, [newP[i+1] - newP[i], i, i+1, 1])
        while m > k:
            loss, i, j, t = heappop(heap)
            if NodeList[i] == None or NodeList[j] == None: continue
            m -= 1
            res -= loss
            nodei, nodej = NodeList[i], NodeList[j]
            nodel, noder = nodei.pre, nodej.next
            l, r = nodel.ind, noder.ind
            valL, valR = newP[l], newP[r]
            noder.pre, nodel.next = nodel, noder
            NodeList[i], NodeList[j] = None, None
            if t == 0:
                heappush(heap, [valR - valL, l, r, 1])
            elif l != -1 and r != -1:
                heappush(heap, [valL - valR, l, r, 0])
        return res






//15ms







class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        buys = [inf] * k
        profs = [-inf] * k

        for price in prices:
            if price < buys[0]:
                buys[0] = price

            if price - buys[0] > profs[0]:
                profs[0] = price - buys[0]

            for i in range(1, k):
                if price - profs[i-1] < buys[i]:
                    buys[i] = price - profs[i-1]
                    
                if price - buys[i] > profs[i]:
                    profs[i] = price - buys[i]

        return(profs[-1])






//15ms






class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        buy = [-prices[0]] * k
        sell = [0] * k

        for i in range(1, len(prices)):
            price = prices[i]
            if -price > buy[0]:
                buy[0] = -price
            if buy[0] + price > sell[0]:
                sell[0] = buy[0] + price

            for j in range(1, k):
                if sell[j - 1] - price > buy[j]:
                    buy[j] = sell[j - 1] - price
                if buy[j] + price > sell[j]:
                    sell[j] = buy[j] + price

        return sell[-1]







//24ms







class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        price = [10 ** 4] * k
        profit = [0] * k

        for p in prices:
            price[0] = p if (p < price[0]) else price[0]
            profit[0] = p - price[0] if (p - price[0] > profit[0]) else profit[0]

            for i in range(1, k):
                price[i] = p - profit[i - 1] if (p - profit[i - 1] < price[i]) else price[i]
                profit[i] = p - price[i] if (p - price[i] > profit[i]) else profit[i]

        return profit[k - 1]
