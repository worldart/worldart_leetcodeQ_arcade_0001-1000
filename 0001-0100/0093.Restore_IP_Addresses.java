//0ms


class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 3 && s.length() < 13) {
            combination(s.toCharArray(), 0, res, new char[15], 0, 0, 0);
        }
        return res;
    }

    private static void combination(
            char[] s, int idx, List<String> res, char[] address, int adrSize, int groupSize, int numberOfPoints ) {
        int tailSize = s.length - adrSize + numberOfPoints;
        if (tailSize < 4 - numberOfPoints || tailSize > (4 - numberOfPoints) * 3) return;
        if (groupSize == 0) {
            address[adrSize] = s[idx++];
            combination(s, idx, res, address, adrSize + 1, 1, numberOfPoints);
            if (numberOfPoints == 3) {
                if (idx == s.length) res.add(String.valueOf(address, 0, adrSize + 1));
            } else {
                address[++adrSize] = '.';
                combination(s, idx, res, address, ++adrSize, 0, numberOfPoints + 1);
            }
        } else if (groupSize == 1 && s[idx - 1] > '0') {
            address[adrSize] = s[idx++];
            combination(s, idx, res, address, adrSize + 1, 2, numberOfPoints);
            if (numberOfPoints == 3) {
                if (idx == s.length) res.add(String.valueOf(address, 0, adrSize + 1));
            } else {
                address[++adrSize] = '.';
                combination(s, idx, res, address, ++adrSize, 0, numberOfPoints + 1);
            }
        } else if (groupSize == 2 &&
                (s[idx - 2] == '1' ||
                        s[idx - 2] == '2' && (s[idx - 1] < '5' || (s[idx - 1] == '5') && s[idx] <= '5'))) {
            address[adrSize] = s[idx++];
            if (numberOfPoints == 3) {
                if (idx == s.length) res.add(String.valueOf(address, 0, adrSize + 1));
            } else {
                address[++adrSize] = '.';
                combination(s, idx, res, address, ++adrSize, 0, numberOfPoints + 1);
            }
        }
    }    
}
