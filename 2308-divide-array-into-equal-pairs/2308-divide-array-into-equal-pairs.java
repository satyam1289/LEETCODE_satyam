class Solution {
    public boolean divideArray(int[] numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            frequencyMap.put(numbers[i], frequencyMap.getOrDefault(numbers[i], 0) + 1);
        }
        
        for (int element : frequencyMap.keySet()) {
            if (frequencyMap.get(element) % 2 != 0) return false;
        }
        
        return true;
    }
}
