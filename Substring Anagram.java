int subStringAnagram(String A, String B) {
    //corner cases
    if(A == null) return -1;
    int m = A.length(), n = B.length();
    if(m == 0 || m < n) return -1;
    if(n == 0) return 0;
    //general cases
    Map<Character, Integer> mapA = new Hashmap<>();
    Map<Character, Integer> mapB = new Hashmap<>();
    // add all chars in B into mapB, add first n chars in A into mapA
    for(int i = 0; i < n; ++i) {
        int countB = mapB.containsKey(B.charAt(i)) ? mapB.get(B.charAt(i)) : 0;
        mapB.put(B.charAt(i), countB + 1);
        int countA = mapA.containsKey(A.charAt(i)) ? mapA.get(A.charAt(i)) : 0;
        mapA.put(A.charAt(i), countA + 1);
    }
    // iterates a size of n window from left to right
    for(int i = 0; i < m - n; ++i) {
        int cnt = 0; //counter for recording right matches
        // compare each char of A and B in the window
        for(int j = i; j < n + i; ++j) { //TODO, n+i may overflow
            if(mapA.get(B.charAt(j)) != mapB.get(B.charAt(j))) break;
            else cnt++;
        }
        if(cnt == n) return i;
        else { // remove 1st char of the window and add next char to it
            mapA.remove(A.charAt(i));
            if(mapA.containsKey(A[n+i+1]) mapA.get(A.charAt(n+i+1))++;
            else mapA.put(A.charAt(n+i+1)], 1);
        }
    }
    return -1; // no match
}
