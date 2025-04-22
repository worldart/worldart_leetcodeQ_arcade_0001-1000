//1ms

class Solution {
    public List<List<Integer>> generate(int numRows) {
        var result = new ArrayList<List<Integer>>();
        for(int i=1;i<=numRows;i++){
            result.add(getData(i, i==1?null:result.get(i-2)));
        }
        return result;
    }

    private List<Integer> getData(int rowNum, List<Integer> previous){
        var result = new ArrayList<Integer>();
        result.add(1);
        if(rowNum == 1){
            return result;
        }
        if(rowNum == 2){
            result.add(1);
            return result;
        }
        for(int i=1;i<previous.size();i++){
            result.add(previous.get(i) + previous.get(i-1));
        }
        result.add(1);
        return result;
    }
}
