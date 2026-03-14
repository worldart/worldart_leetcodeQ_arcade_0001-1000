//0ms




class Solution {
public:
    bool isIsomorphic(string s, string t) {
        vector<int> indexS(200, 0); // Stores index of characters in string s
        vector<int> indexT(200, 0); // Stores index of characters in string t
        
        int len = s.length(); // Get the length of both strings
        
        if(len != t.length()) { // If the lengths of the two strings are different, they can't be isomorphic
            return false;
        }
        
        for(int i = 0; i < len; i++) { // Iterate through each character of the strings
            if(indexS[s[i]] != indexT[t[i]]) { // Check if the index of the current character in string s is different from the index of the corresponding character in string t
                return false; // If different, strings are not isomorphic
            }
            
            indexS[s[i]] = i + 1; // updating position of current character
            indexT[t[i]] = i + 1;
        }
        
        return true; // If the loop completes without returning false, strings are isomorphic
    }
};





//0ms





class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if(s.length() != t.length()) return false ;
        vector<int> v(150,1000) ;
    
        for(int i=0;i<s.length();i++){
            int idx= (int)s[i];
            if(v[idx]== 1000) v[idx] = s[i] - t[i] ;
            else if(v[idx]!=(s[i]-t[i]))  return false ;
        } 
        for(int i=0;i<150;i++){
            v[i]=1000;
        }
        for(int i=0;i<t.length();i++){
            int idx= (int)t[i];
            if(v[idx]== 1000) v[idx] = t[i] - s[i] ;
            else if(v[idx]!=(t[i]-s[i]))  return false ;
        } 
        return true;
        
    }
};






//5ms





class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char,char> mapst;
        unordered_map<char,char> mapts;

        for(int i=0;i<s.length();i++){
            char c1=s[i];
            char c2=t[i];

            if(mapst.count(c1) && mapst[c1]!=c2 ){
                return false;
            }

            if(mapts.count(c2) && mapts[c2]!=c1){
                return false;
            }

            mapst[c1]=c2;
            mapts[c2]=c1;

        }
        return true;
    }
};




















