public bool subsequenceSumk(int[] num, int target) {
     //corner cases
     if(num == null || num.length == 0) return false;
     //general cases
     // maintain a hashmap of key as presum, and value as index 
     Map<Integer, Integer> map = new Hashmap<>();
     map.put(0,-1);     // presum base case
     int sum = 0;
     for(int i = 0; i < num.length; ++i) {
          sum += num[i];
          if(map.contains(sum - target)) return true;
          else map.put(sum, i);
     }
     return false;
}