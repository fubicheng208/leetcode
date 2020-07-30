package topological;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

import java.util.LinkedList;
import java.util.Queue;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] t : prerequisites) {
            indegrees[t[0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0)
                queue.offer(i);
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res[idx++] = pre;
            numCourses--;
            for (int[] t : prerequisites) {
                if (t[1] != pre) continue;
                if (--indegrees[t[0]] == 0) queue.offer(t[0]);
            }
        }
        return numCourses == 0 ? res : new int[0];
    }
}
