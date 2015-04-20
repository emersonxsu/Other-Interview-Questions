public int maxSizedSubSequence(int [] num, int target){
    //corner cases
    if(num == null || num.length == 0) return false;
    //general cases
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int sum = 0;
    int maxLength = 0;
    for(int i = 0 ;i < num.length; ++i){
        sum += num[i];
        if(map.containsKey(sum - target)){
            int prevIdx = map.get(sum - target);
            maxLength = Math.max(maxLength, i - prevIdx);
        } else map.put(sum, i);
    }
    return maxLength;
}