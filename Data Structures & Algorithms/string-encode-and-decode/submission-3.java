class Solution {
    public char uniq='é';
    public String encode(List<String> strs) {
        String encodedString="";
        int count=0;
       
        for(int i=0;i<strs.size();i++){
            
            encodedString+=strs.get(i);
            encodedString+=uniq;
        }
        return encodedString;

    }

    public List<String> decode(String str) {

        List<String> list_ = new ArrayList<>();
        String temp="";
        char curr =' ';
        for(int i=0; i<=str.length()-1;i++){
              curr= str.charAt(i);
            if(curr!=(uniq)){
                temp+=curr;
            }
            else if(curr==uniq){
                list_.add(temp);
                temp="";

            }
           
        }
        return list_;


    }
}
