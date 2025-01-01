import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    /**
     * 暴力
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumBruteForce(int[] nums,int target){
        for (int i = 0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++){
                if (nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 哈希表
     * 思路： 可以用map先存一遍数据及下标，然后再遍历数据，在其中计算当前元素的补数，然后看在map中有没有
     * 如果有，则说明两个数据加起来是target
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSunHashMap(int[] nums, int target){
        // 存元素及其对应下标
        Map<Integer,Integer> numToIndex= new HashMap<>();
        // 遍历数组
        for(int i = 0;i<nums.length;i++){
            // 计算每个元素的补数
            int complement = target - nums[i];
            // 补数在map中，说明当前遍历的这个元素和这个补数对应的map中的元素相加为target
            if (numToIndex.containsKey(complement)){
                // 返回两个元素的数组下标
                return new int[]{numToIndex.get(complement),i};
            }
            // 把数组中的元素存到哈希表
            numToIndex.put(nums[i],i);
        }
        return null;
    }
}
