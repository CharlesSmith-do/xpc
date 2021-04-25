package problem;

import java.util.*;

public class threeSums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list1 = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0;i<nums.length ; i++){
            if(nums[i]>0){//若第一个数就大于0则后续不可能和为0，之后的就不用做了break
                break;
            }
            if(i-1>=0&&nums[i]==nums[i-1]){
                continue;//当前数和之前的一样则跳过
            }
            int left = i+1 ;
            int right = nums.length-1;
            while(left < right){

                if(nums[left]+nums[right] > -nums[i]){
                    right--;
                }
                else if(nums[left]+nums[right] < -nums[i]){
                    left++;
                }
                else{
                    List<Integer> list2 = new ArrayList<>();
                    list2.add(nums[left]);
                    list2.add(nums[right]);
                    list2.add(nums[i]);
                    Collections.sort(list2);
                    list1.add(list2);
                    while(left<right && nums[left+1] == nums[left]){
                        left++;
                    }
                    while(left<right && nums[right-1] == nums[right]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return list1;
    }
}
