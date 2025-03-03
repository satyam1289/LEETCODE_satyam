class Solution {
    public int[] pivotArray(int[] arr, int mid) {
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : arr) {
            if (num < mid) {
                left.add(num);
            } else if (num == mid) {
                equal.add(num);
            } else {
                right.add(num);
            }
        }

        int index = 0;
        for (int num : left) {
            arr[index++] = num;
        }
        for (int num : equal) {
            arr[index++] = num;
        }
        for (int num : right) {
            arr[index++] = num;
        }

        return arr;
    }
}
