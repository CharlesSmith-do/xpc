package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSums {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list1 = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-3 ; i++){
            if(nums[i] > target){
                return list1;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1 ; j <nums.length -2 ;j++){
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    if(nums[i]+nums[j]+nums[left]+nums[right] > target){
                        right--;
                    }
                    else if(nums[i]+nums[j]+nums[left]+nums[right] < target){
                        left++;
                    }
                    else
                    {
                        List<Integer> list2 = new ArrayList<>();
                        list2.add(nums[i]);
                        list2.add(nums[j]);
                        list2.add(nums[left]);
                        list2.add(nums[right]);
                        if(list1.contains(list2)){
                            left++;
                            right--;
                            continue;
                        }
                        else{
                            list1.add(list2);
                            left++;
                            right--;
                        }
                    }
                }

            }
        }
        return list1;
    }
}
