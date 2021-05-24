package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fubic
 * @date 2021-02-24
 */
public class Jindian0401 {
/*    节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。

    示例1:
    输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
    输出：true*/

    //总思路：如(0,1)(0,3)(1,2)，转化为边集为{{1,3}{2}{}{}}
    //目标为0-2，先搜索(0,1),再以1为起点，搜索(1,2)
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> es = new ArrayList<>();
        for(int i = 0; i < n; i++){
            es.add(new ArrayList<>());
        }
        for(int i = 0; i < graph.length; i++){
            es.get(graph[i][0]).add(graph[i][1]);
        }
        return dfs(es, start, target, visited);
    }

    public boolean dfs(List<List<Integer>> es, int start, int target, boolean[] visited){
        visited[start] = true;
        List<Integer> ls = es.get(start);
        if(ls.contains(target)){
            return true;
        }else{
            for(int i : ls){
                if(!visited[i]){
                    if(dfs(es, i, target, visited)){
                        return true;
                    }
                }
            }
        }
        visited[start] = false;
        return false;
    }
}
