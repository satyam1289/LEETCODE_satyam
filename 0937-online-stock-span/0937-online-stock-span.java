class StockSpanner {
    
    Stack<int[]> stack;
    
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        
        int span = 1;
        
        while(stack.size() > 0 && price >= stack.peek()[0]){
            span += stack.pop()[1];
        }
        
        stack.push(new int[]{price, span});
        
        return span;
    }
}
