package maths;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.*;

public class M62 {
/*    0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

    例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。*/

    /*//模拟一个循环链表=》将头元素添加到链表尾，删除头元素
    //O(mn)超时
    public int lastRemaining(int n, int m) {
        List<Integer> ls = new ArrayList<Integer>();
        for(int i = 0; i<n; i++)
            ls.add(i);
        while(ls.size()!=1){
            for(int j=0; j<m; j++){
                //不是第m个，则不要删除
                if(j!=m-1)+
                    ls.add(ls.get(0));
                ls.remove(0);
            }
        }
        return ls.get(0);
    }*/

    //归纳法 f(n) = (f(n-1)+m)%n
    //推导 https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/gong-shi-tui-dao-by-keyianpai/
    public int lastRemaining(int n, int m) {
        int fn = 0;
        for (int i = 2; i <= n; i++)
            fn = (fn + m) % i;
        return fn;
    }

}
