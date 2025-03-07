class Solution {
    public int[] closestPrimes(int start, int end) {
        int first = -1, second = -1;
        List<Integer> primesList = new ArrayList<>();

        for(int num = start; num <= end; num++){
            if(isPrime(num)){
                if(primesList.size() >= 1 && num <= primesList.get(primesList.size() - 1) + 2){
                    return new int[]{primesList.get(primesList.size() - 1), num};
                }
                primesList.add(num);
            }
        }

        if(primesList.size() < 2){
            return new int[]{first, second};
        }

        int minDiff = Integer.MAX_VALUE;
        for(int idx = 1; idx < primesList.size(); idx++){
            if(minDiff > primesList.get(idx) - primesList.get(idx - 1)){
                minDiff = primesList.get(idx) - primesList.get(idx - 1);
                first = primesList.get(idx - 1);
                second = primesList.get(idx);
            }
        }

        return new int[]{first, second};
    }

    boolean isPrime(int number){     
        if(number == 1) return false;  
        else if(number == 2) return true; 
        for(int divisor = 2; divisor < Math.sqrt(number) + 1; divisor++){
            if(number % divisor == 0){
                return false;
            }
        }
        return true;
    }
}