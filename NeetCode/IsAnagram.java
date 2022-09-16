class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        for(int i= 0; i<s.length(); i++){
            list1.add(s.charAt(i));
        }
        for(int j= 0; j<t.length(); j++){
            list2.add(t.charAt(j));
        }
        System.out.println(list1);
        System.out.println(list2);
        Collections.sort(list1);
        Collections.sort(list2);
        boolean value = list1.equals(list2);
        
        return value;
    }
}