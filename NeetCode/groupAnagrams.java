class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for (int i=0; i<strs.length; i++){
            char[] sw = strs[i].toCharArray();
            Arrays.sort(sw);
            String word = new String(sw);
            
            if(!hm.containsKey(word)){
                hm.put(word, new ArrayList<>());
            }
            
            hm.get(word).add(strs[i]);
        }
        return new ArrayList<>(hm.values());
}
}