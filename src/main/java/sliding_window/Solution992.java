package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Solution992 {

//    给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
//
//            （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
//
//    返回 A 中好子数组的数目。
//
//    示例 1：
//
//    输入：A = [1,2,1,2,3], K = 2
//    输出：7
//    解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

    public static int subarraysWithKDistinct(int[] A, int K) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> hm_back = new HashMap<>();
        int ans = 0;
        int rk = -1;
        int n = A.length;
        int k = 0;//当前区间的不同整数的个数
        int tmp_k = 0;
        Boolean flag = true;
        for (int i = 0; i < A.length; i++) {
            //移左指针，直到k<K
            if (i != 0 && flag) {
                int t = i;
                while (k == K) {
                    int t_num = hm.get(A[t - 1]);
                    if (t_num >= 2) {
                        hm.put(A[t - 1], t_num - 1);
                    } else {
                        hm.remove(A[t - 1]);
                        k--;
                    }
                    //储存删除i-1的一个备份，以便恢复
                    if (t == i) {
                        hm_back = (HashMap<Integer, Integer>) hm.clone();
                        tmp_k = k;
                    }
                    if (k == K)
                        ans++;
                    t++;
                }
            }
            hm = hm_back;
            k = tmp_k;
            flag = false;
            //移右指针直到k>K
            //k<K时，无论rk+1是否在hm中，都可加入；
            //k==K时，只有rk+1在hm中的才可加入。
            while ((rk + 1) < n && (k < K || (k == K && hm.containsKey(A[rk + 1])))) {
                flag = true;
                if (hm.containsKey(A[rk + 1])) {
                    hm.put(A[rk + 1], hm.get(A[rk + 1]) + 1);
                } else {
                    hm.put(A[rk + 1], 1);
                    k++;
                }
//                hm.put(A[rk + 1], hm.containsKey(A[rk + 1]) ? hm.get(A[rk+1]) + 1 : 1 );
                if (k == K)
                    ans++;
                rk++;
            }
        }
        return ans;
    }

//    public static int subarraysWithKDistinct(int[] A, int K) {
//        Window window1 = new Window();
//        Window window2 = new Window();
//        int ans = 0, left1 = 0, left2 = 0;
//        for (int right = 0; right < A.length; right++) {
//            int x = A[right];
//            window1.add(x);
//            window2.add(x);
//            // 让window1左指针移动,直到等于K
//            while (window1.different() > K) {
//                window1.remove(A[left1]);
//                left1++;
//            }
//            // 让window2左指针移动,直到恰好小于K
//            while (window2.different() >= K) {
//                window2.remove(A[left2]);
//                left2++;
//            }
//            // window2恰好少一个，window1恰好等于K
//            // 这时所有以left2为结尾的子数组，都是符合要求的
//            ans += left2 - left1;
//        }
//        return ans;
//    }


    public static void main(String[] args) {
//        int[] A = new int[]{1,2,1,3,4};
//        int[] A = new int[]{2,1,2,1,2}; //10
//        int[] A = new int[]{2,1,1,1,2}; //7
//        int[] A = new int[]{1,2,1,2,3};
        int[] A = new int[]{2, 2, 1, 2, 2, 2, 1, 1};
        System.out.println(subarraysWithKDistinct(A, 2));
    }
}
