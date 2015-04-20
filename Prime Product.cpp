ArrayList<Integer> primeProducts(int[] primes) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(int i = 0 ; i < primes.length; i++){
        int len = result.length();
        result.add(primes[i]  );.
        for(int j = 0; j < len ; j++){
            result.add(result.get(j) * primes[i]  );
        }
    }
    return result;
}