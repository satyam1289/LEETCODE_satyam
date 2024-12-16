class Solution {
    class Element implements Comparable<Element> {
        int value;
        int index;
        
        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Element other) {
            if (this.value == other.value) {
                return this.index - other.index;
            } else {
                return this.value - other.value;
            }
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int[] result = new int[nums.length];
        PriorityQueue<Element> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new Element(nums[i], i));
            result[i] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            Element smallest = minHeap.poll();
            minHeap.add(new Element(smallest.value * multiplier, smallest.index));
            result[smallest.index] = smallest.value * multiplier;
        }

        return result;
    }
}
