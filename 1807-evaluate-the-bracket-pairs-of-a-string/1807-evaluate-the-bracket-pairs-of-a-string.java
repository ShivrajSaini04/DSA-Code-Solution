class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
       HashMap<String,String> map = new HashMap<>();
       String copy = s;
       int n = s.length();

       //first map the knowledge key value pair
       for(List<String> list : knowledge){
        map.put(list.get(0),list.get(1));
       }

       // now find keys in the string
       List<String> list = new ArrayList<>();
       StringBuilder change = new StringBuilder();
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
            // list.add(str.toString());
            if (map.containsKey(key) ) change.append(map.get(key));
            else change.append("?");
          }
          if (ch == s.charAt(i)) change.append(ch);
          i++;
       }

       // check and replace 

    //    for (String key : list){
    //      String old =  "(" + key + ")";
    //      if (map.containsKey(key))  
    //         copy = copy.replace(old , map.get(key));
    //       else 
    //         copy = copy.replace(old , "?");
    //     }
       return change.toString();
    }
}