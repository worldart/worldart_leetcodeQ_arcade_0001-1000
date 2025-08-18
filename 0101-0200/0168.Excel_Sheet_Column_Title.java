//0ms





class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder title=new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            title.insert(0,(char)(columnNumber%26+'A'));
            columnNumber=columnNumber/26;
        }
        return title.toString();
    }
}




//0ms





class Solution {
    public String convertToTitle(int col) {

        StringBuilder sb = new StringBuilder();


        while(col>0){
            col--;
            char c = (char) ('A' + col%26);
        sb.append(c);
            col = col / 26;
        }
        
        return sb.reverse().toString();


        
    }
}
