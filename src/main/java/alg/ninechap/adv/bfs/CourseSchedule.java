package alg.ninechap.adv.bfs;


import java.util.*;

/**
 * Created by yuding on 1/25/18.
 * Given the total number of courses and a list of prerequisite pairs,
 * return the ordering of courses you should take to finish ALL COURSES.
 *
 * This is the simple version of topological sorting problem
 * Given n = 2, prerequisites = [[1,0]] Return [0,1]
 * Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
 *
 * Return [0,1,2,3] or [0,2,1,3]
 *       2 - - - - - -
 *      /             \
 *     /               \
 *    0 - - -  1 - - - 3
 *
 */

public class CourseSchedule {
    /**
     * The array version
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] edges = new ArrayList[numCourses]; // courses and its prereq
        int [] degree = new int[numCourses];

        // initialize the edges
        for(int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        // find degrees and edges
        for(int [] cur : prerequisites) {
            int courseIdx = cur[0];
            int preReqIdx = cur[1];
            degree[courseIdx]++;
            edges[preReqIdx].add(courseIdx); // prereq --> course
        }

        Queue<Integer> queue = new LinkedList<>();
        // find StartNodes
        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 0) {
                queue.offer(i); // only add the 0 degree courses
            }
        }

        int count = 0;
        int [] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[count] = course;
            count++;
            int n = edges[course].size(); // num of neighbors
            for(int j = 0; j < n; j++) {
                int curIdx = (int) edges[course].get(j);
                degree[curIdx]--; // decrease it's degree
                if(degree[curIdx] == 0) {
                    queue.offer(curIdx);
                }
            }
        }
        if(count == numCourses) {
            return res;
        }
        return new int [0];
    }

    //--------- prac --------------
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int [] res = new int[numCourses];
        if(numCourses == 0) {
            return res;
        }
        List<Integer>[] Edges = new List[numCourses];
        // initialize Edges
        for(int i = 0; i < numCourses; i++) {
            Edges[i] = new ArrayList<>();
        }
        // find indegree and fill the graph using adjList
        int [] indegree = new int[numCourses];  // course idx --> degree
        findIndegree(indegree, Edges, prerequisites);

        // find startNode
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Do BFS find courseOrder
        int index = 0;
        while(!queue.isEmpty()) {
            int expandCourseID = queue.poll();
            res[index] = expandCourseID;
            for(Integer genID : Edges[expandCourseID]){
                indegree[genID]--;
                if(indegree[genID] == 0) {
                    queue.offer(genID);
                }
            }
            index++;
        }
        if(index == numCourses){
            return res;
        }
        return new int[0];
    }

    private void findIndegree(int [] indegree, List<Integer>[] Edges, int [][] prerequisites) {
        // prerequisites: [0, 1] have to take 1 first, then 0
        // directed graph: firstID ---> nextID
        for(int[] pair : prerequisites) {
            int takeFirstID = pair[1];
            int takeNextID = pair[0];
            indegree[takeNextID]++;
            Edges[takeFirstID].add(takeNextID);
        }
    }

}
