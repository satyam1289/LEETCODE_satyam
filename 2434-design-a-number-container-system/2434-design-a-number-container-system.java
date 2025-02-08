import java.util.*;

class NumberContainers {
    
    Map<Integer, Integer> idxToNum;
    Map<Integer, TreeSet<Integer>> numToIdx;

    public NumberContainers() {
        idxToNum = new HashMap<>();
        numToIdx = new HashMap<>();    
    }
    
    public void change(int idx, int num) {
        if (!idxToNum.containsKey(idx)) {        
            idxToNum.put(idx, num);
        } else {          
            int prevNum = idxToNum.get(idx);
            idxToNum.put(idx, num);
            numToIdx.get(prevNum).remove(idx);
            if (numToIdx.get(prevNum).isEmpty())
                numToIdx.remove(prevNum);
        }
        if (!numToIdx.containsKey(num)) {
            numToIdx.put(num, new TreeSet<Integer>());
        }
        numToIdx.get(num).add(idx);
    }
    
    public int find(int num) {   
        if (!numToIdx.containsKey(num))
            return -1;
        return numToIdx.get(num).first();
    }
}
