package CIT_596.HW_7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 * Time cost for this algorithm:
 * T(n) = O(nlogn) where n is the number of classes to be scheduled
 * For this greedy approach, the highest cost is the sort process
 * which will cost O(nlogn). Then we just iterate through all the
 * courses to be schedule and use greedy method to pick class, this
 * cost another O(n). Hence T(n) = O(nlogn) + O(n) = O(nlogn)
 */

public class Q5part1 {
    /**
     * Q5-1.csv has course name, start time and finish time
     */
    class ClassInfo {
        String courseName;
        Integer startTime;
        Integer endTime;
        Integer priority;

        public ClassInfo(String n, int s, int e) {
            courseName = n;
            startTime = s;
            endTime = e;
            priority = 0;
        }

        @Override
        public String toString() {
            return "ClassInfo{" +
                    "courseName='" + courseName + '\'' +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", priority=" + priority +
                    '}';
        }
    }

    public List<ClassInfo> scheduleClass(String filename) {
        List<ClassInfo> res = new ArrayList<>();
        List<ClassInfo> classInfos = parseFile(filename);
        // sort the list
        Collections.sort(classInfos, new Comparator<ClassInfo>() {
            @Override
            public int compare(ClassInfo c1, ClassInfo c2) {
                return c1.endTime.compareTo(c2.endTime);
            }
        });
        // then just to the greedy approach
        for (ClassInfo curClass : classInfos) {
            if (res.isEmpty() ||
                    curClass.startTime > res.get(res.size() - 1).endTime) {
                res.add(curClass);
            }
        }

        return res;
    }

    private List<ClassInfo> parseFile(String filename) {
        List<ClassInfo> res = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            line = br.readLine(); // skip the first line
            while (line != null) {
                // parse line to ClassInfo Obj
                ClassInfo curClass = parseCourseInfo(line);
                res.add(curClass);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private ClassInfo parseCourseInfo(String info) {
        String[] infoArray = info.split(",");
        int startTime = convertTimeToInt(infoArray[1]);
        int endTime = convertTimeToInt(infoArray[2]);

        ClassInfo res = new ClassInfo(infoArray[0], startTime, endTime);
        return res;
    }

    private int convertTimeToInt(String time) {
        String[] times = time.split(":");
        return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
    }

    public static void main(String[] args) {
        Q5part1 sol = new Q5part1();
        List<ClassInfo> res = sol.scheduleClass("Q5-1.csv");
        for (ClassInfo ci : res) {
            System.out.println(ci.courseName);
        }
    }
}
