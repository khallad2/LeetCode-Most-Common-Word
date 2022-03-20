class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<String>();
        for(String word: banned){
            bannedSet.add(word);
        }
        
        Map<String, Integer> paraMap = new HashMap<String, Integer>();
        for(String word: paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")){
           if(!bannedSet.contains(word)) {
               paraMap.put(word, paraMap.getOrDefault(word, 0) + 1);
            }
        }
        
        String result = "";
        for(String key: paraMap.keySet()){
            if(result.equals("") || paraMap.get(key) > paraMap.get(result)){
                result = key;
            }
        }
        return result;
    }
}
