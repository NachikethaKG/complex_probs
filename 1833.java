import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;

        for (int cost : costs) {
            if (coins >= cost) {
                coins -= cost;
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxIceCream(new int[]{1, 3, 2, 4, 1}, 7)); 
    }
}