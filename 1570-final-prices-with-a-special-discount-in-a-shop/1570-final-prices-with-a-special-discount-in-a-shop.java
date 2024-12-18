class Solution {
    public int[] finalPrices(int[] itemPrices) {
        int itemCount = itemPrices.length;
        Stack<Integer> indexStack = new Stack<>();
        
        for (int currentIndex = 0; currentIndex < itemCount; currentIndex++) {
            while (!indexStack.isEmpty() && itemPrices[indexStack.peek()] >= itemPrices[currentIndex]) {
                itemPrices[indexStack.pop()] -= itemPrices[currentIndex];
            }
            indexStack.add(currentIndex);
        }
        return itemPrices;
    }
}
