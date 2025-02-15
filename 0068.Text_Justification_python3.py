#0ms 

class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        res =[]
        currLen ,strtIdx ,wordCount, extraSpace, totalSpaces, spcDist =0, 0, 0, 0, 0, 0
        resStr =""
        for i in range(len(words)):
            if currLen + (wordCount -1)  + len(words[i]) +1  > maxWidth:
                totalSpaces = maxWidth - (currLen) 
                if wordCount-1 > 0:
                    spcDist = totalSpaces//(wordCount-1)
                    if(totalSpaces%(wordCount-1)):
                        extraSpace = totalSpaces - (spcDist * (wordCount -1))
                       
                if i < len(words):
                    if strtIdx == (strtIdx + wordCount-1):
                        resStr += words[strtIdx + wordCount-1] + " "* totalSpaces
                    else:
                        print(spcDist, extraSpace)
                        wc = wordCount
                        for w in words[strtIdx : (strtIdx + wordCount-1)]:
                            resStr += w + " " * spcDist 
                            if extraSpace >0:
                                resStr += " " 
                                extraSpace -=1

                        resStr += words[strtIdx + wordCount-1]
                    res.append(resStr)
                    totalSpaces, spcDist, extraSpace = 0,0,0 
                    currLen = len(words[i])
                    wordCount =1
                    resStr =""
                    strtIdx = i
                
            else:
                currLen += len(words[i])
                wordCount +=1
        else:
            resStr = ""
            totalSpaces = maxWidth - (currLen) 
            for w in words[strtIdx : (strtIdx + wordCount-1)]:
                resStr +=  w + " "
                totalSpaces -=1
            resStr += words[(strtIdx + wordCount-1)] +  " " * totalSpaces
        
            res.append(resStr)
        return res
