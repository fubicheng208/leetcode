package topological;

import java.util.LinkedList;
import java.util.Queue;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        //统计入度
        for (int[] cp : prerequisites) indegrees[cp[0]]++;
        Queue<Integer> queue = new LinkedList<Integer>();
        //所有入度为0的点入队
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.offer(i);
        }
        //将队列中的元素出列，修改其入度数组中的值，若入度为0则入队列
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int[] req : prerequisites) {
                //只有该点前一个为pre时才需要删除
                if (req[1] != pre) continue;
                if (--indegrees[req[0]] == 0)
                    queue.offer(req[0]);

            }
        }
        return numCourses == 0;
    }
}
