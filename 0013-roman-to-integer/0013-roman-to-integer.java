class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
    void putInMap(){
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
    public int romanToInt(String s) {
        int n = s.length();
        putInMap();
        int sum = 0;
        for(int i=0;i<n;i++){
            int curr  = map.get(s.charAt(i ));
            if (i!=n-1 && curr < map.get(s.charAt(i + 1))){
                sum -= curr;
            }
            else sum += curr;
        }
        return sum;
    }
}