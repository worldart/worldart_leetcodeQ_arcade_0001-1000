'''
Time complexity: O(1)
Space complexity: O(1)
'''

def factoring(n):
    l=[]
    
    n=str(n)
    
    if(len(n)==4):
        l.append(str(int(n[0])*1000))
        l.append(str(int(n[1])*100))
        l.append(str(int(n[2])*10))
        l.append(str(int(n[3])*1))  
        
    elif(len(n)==3): 
        l.append(str(int(n[0])*100))
        l.append(str(int(n[1])*10))
        l.append(str(int(n[2])*1)) 
    
    elif(len(n)==2):
        l.append(str(int(n[0])*10))
        l.append(str(int(n[1])*1)) 
        
    elif(len(n)==1):
        l.append(n)
        
    return(l)  

class Solution(object):
    def intToRoman(self, num):
        self.num,final,ref,basic=num,'',{'10':'X','20':'XX','30':'XXX','40':'XL','50':'L','60':'LX','70':'LXX','80':'LXXX','90':'XC','100':'C','200':'CC','300':'CCC','400':'CD','500':'D','600':'DC','700':'DCC','800':'DCCC','900':'CM','1000':'M','2000':'MM','3000':'MMM'},{'1':'I','2':'II','3':'III','4':'IV','5':'V','6':'VI',"7":"VII",'8':'VIII','9':'IX'}
        l1=factoring(self.num)
        for key in l1:
            if(key in ref):
                final+=ref[key]
            elif(key in basic):
                final+=basic[key]
        return(final)


        
        
