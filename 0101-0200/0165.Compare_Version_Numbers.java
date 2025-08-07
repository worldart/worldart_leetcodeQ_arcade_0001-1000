//0ms






class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int num1 = 0, num2 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i++) - '0');
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j++) - '0');
            }
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }
}







//1ms






class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i=0;i<Math.max(v1.length,v2.length);i++){
            int num1 = i<v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i<v2.length ? Integer.parseInt(v2[i]) : 0;
            if(num1<num2){
                return -1;
            }
            if(num1>num2){
                return 1;
            }
        }
        return 0;
    }
}






//0ms






class Solution {
    public int compareVersion(String v1, String v2) {
        int n = v1.length();
        int m = v2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int num1 = 0;
            while (i < n && v1.charAt(i) != '.') {
                num1 = num1 * 10 + (v1.charAt(i) - '0');
                i++;
            }
            int num2 = 0;
            while (j < m && v2.charAt(j) != '.') {
                num2 = num2 * 10 + (v2.charAt(j) - '0');
                j++;
            }
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
            i++;
            j++;
        }
        return 0;
    }
}
