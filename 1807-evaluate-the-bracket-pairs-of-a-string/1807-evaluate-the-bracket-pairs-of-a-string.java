class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
       HashMap<String,String> map = new HashMap<>();
       int n = s.length();

       //first map the knowledge key value pair
       for(List<String> list : knowledge){
        map.put(list.get(0),list.get(1));
       }

       // now find keys in the string and replace 
       StringBuilder res = new StringBuilder();
       int i =0 ;

       while(i<n){
          char ch = s.charAt(i);

          if (ch == '('){
            i++;
            StringBuilder str = new StringBuilder();
            while(s.charAt(i) != ')'){
                str.append(s.charAt(i));
                i++;
            }

            String key = str.toString();
            res.append(map.getOrDefault(key, "?"));
           
          }
          else res.append(ch);
          i++;
       }

       return res.toString();
    }
}