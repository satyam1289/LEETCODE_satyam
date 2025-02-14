class ProductOfNumbers {
    private List<Integer> productList;

    public ProductOfNumbers() {
        productList = new ArrayList<>();
        productList.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            productList.clear();
            productList.add(1);
        } else {
            productList.add(productList.get(productList.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (productList.size() <= k) {
            return 0;
        }
        int len = productList.size();
        return productList.get(len - 1) / productList.get(len - k - 1);
    }
}
