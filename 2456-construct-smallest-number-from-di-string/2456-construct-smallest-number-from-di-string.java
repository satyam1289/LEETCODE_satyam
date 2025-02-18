class ProductOfNumbers {
    private List<Integer> productSequence;

    public ProductOfNumbers() {
        productSequence = new ArrayList<>();
        productSequence.add(1);
    }

    public void add(int value) {
        if (value == 0) {
            productSequence.clear();
            productSequence.add(1);
        } else {
            productSequence.add(productSequence.get(productSequence.size() - 1) * value);
        }
    }

    public int getProduct(int count) {
        if (productSequence.size() <= count) {
            return 0;
        }
        int length = productSequence.size();
        return productSequence.get(length - 1) / productSequence.get(length - count - 1);
    }
}

class Solution {
    public String smallestNumber(String sequence) {
        int index = 0, stack[] = new int[10], size = sequence.length();
        StringBuilder result = new StringBuilder();
        stack[0] = 1;
        for (int i = 0; i < size; i++){
            if (sequence.charAt(i) == 'I'){
                while (index >= 0) result.append(stack[index--]);
            }
            stack[++index] = i + 2;
        }
        while (index >= 0) result.append(stack[index--]);
        return result.toString();
    }
}
