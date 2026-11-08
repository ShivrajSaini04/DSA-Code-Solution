class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ans = new ArrayList<>();
        int n = s1.length();
        int j = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i=0;i<n;i++){
            if (s1.charAt(i) != s2.charAt(i)){
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
            }
            else {
                if (sb1.length() > 0){
                    List<String> list = new ArrayList<>();
                    list.add(sb1.toString());
                    list.add(sb2.toString());
                    ans.add(list);
                    sb1.setLength(0);
                    sb2.setLength(0);
                }
            }
        }
        if (sb1.length() > 0){
                    List<String> list = new ArrayList<>();
                    list.add(sb1.toString());
                    list.add(sb2.toString());
                    ans.add(list);
                }
        
        return ans;
    }
}