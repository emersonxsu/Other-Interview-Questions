bool subsequenceSumk(int[] A, int k) {
//base cases
     if(A == null || A.length == 0) return false;
//general cases
     // maintain a hashmap of key as presum, and value as index 
     Map<Integer, Integer> map = new Hashmap();
     map.put(0,0);     // presum base case
     int sum = 0;
     for(int i = 1; i <= A.length; ++i) {
          sum += A[i-1];
          if(map.contains(sum - k)) return true;
          else map.put(sum, i);
     }
     return false;
}