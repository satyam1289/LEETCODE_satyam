import java.util.*;
 

public class Solution {
  public int maxDifference(String s, int k) {
    int res = Integer.MIN_VALUE;

    for (Pair<Character, Character> p : getPermutations()) {
      char a = p.getKey();
      char b = p.getValue();

      int[][] min = new int[2][2];
      for (int[] row : min)
        Arrays.fill(row, Integer.MAX_VALUE / 2);

      List<Integer> preA = new ArrayList<>(List.of(0));
      List<Integer> preB = new ArrayList<>(List.of(0));

      for (int l = 0, r = 0; r < s.length(); ++r) {
        preA.add(preA.get(preA.size() - 1) + (s.charAt(r) == a ? 1 : 0));
        preB.add(preB.get(preB.size() - 1) + (s.charAt(r) == b ? 1 : 0));

        while (r - l + 1 >= k &&
               preA.get(l) < preA.get(preA.size() - 1) &&
               preB.get(l) < preB.get(preB.size() - 1)) {
          int pa = preA.get(l) % 2;
          int pb = preB.get(l) % 2;
          min[pa][pb] = Math.min(min[pa][pb], preA.get(l) - preB.get(l));
          ++l;
        }

        int pa = preA.get(preA.size() - 1);
        int pb = preB.get(preB.size() - 1);
        res = Math.max(res, (pa - pb) - min[1 - pa % 2][pb % 2]);
      }
    }

    return res;
  }

  private List<Pair<Character, Character>> getPermutations() {
    List<Pair<Character, Character>> list = new ArrayList<>();
    for (char a : "01234".toCharArray())
      for (char b : "01234".toCharArray())
        if (a != b)
          list.add(new Pair<>(a, b));
    return list;
  }
}
