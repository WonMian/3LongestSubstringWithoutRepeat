/**
 * Created by wangmian on 16/12/23.
 */
import java.util.*;
public class Solution {
    public static int lengthOfLongestSubstring2(String s) {
        // 字符串输入不合法
        if (s == null) {
            return 0;
        }

        // 标记字符是否出现过，并且记录是的最新一次访问的元素的位置
        int[] appear = new int[256];
        // 初始化为-1
        Arrays.fill(appear, -1);
        // 当前处理的开始位置
        int start = 0;
        // 保存结果
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            // 如果字符已经出现过(在标记开位置)，就重新标记start
            if (appear[s.charAt(i)] >= start) {
                start = appear[s.charAt(i)] + 1;
            }
            // 如果没有出现过就求最大的非重复子串的长度
            else {
                result = Math.max(result, i - start + 1);
            }
            // 标记第i个字符已经被访问过（最新是第i个位置）
            appear[s.charAt(i)] = i;
        }
        System.out.println(result);

        return result;
    }
    public static void main(String[] args){
        String test = "dvdf";
        lengthOfLongestSubstring2(test);

    }

}
