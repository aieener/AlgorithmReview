package CIT_596.HW_7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Time cost for this algorithm:
 * T(n) = O(n^3) where n is the number of classes to be scheduled
 * because my linear scan method has two for loops, which at worst
 * case will cost O(n^2).
 *
 * In the inner loop, every time I call helper function
 * costOfTakingCurClass, this is another O(n) call.
 *
 * Hence for the worst case, T(n) = O(n^3)
 */

public class Q5part2 {
    class ClassInfo {
        String courseName;
        Integer startTime;
        Integer endTime;
        Integer priority;

        public ClassInfo(String n, int s, int e, int p) {
            courseName = n;
            startTime = s;
            endTime = e;
            priority = p;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassInfo classInfo = (ClassInfo) o;

            if (!courseName.equals(classInfo.courseName)) return false;
            if (!startTime.equals(classInfo.startTime)) return false;
            if (!endTime.equals(classInfo.endTime)) return false;
            return priority.equals(classInfo.priority);
        }

        @Override
        public int hashCode() {
            int result = courseName.hashCode();
            result = 31 * result + startTime.hashCode();
            result = 31 * result + endTime.hashCode();
            result = 31 * result + priority.hashCode();
            return result;
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

    class Schedule {
        Set<ClassInfo> courses;
        int priorityPoints;

        public Schedule() {
            courses = new HashSet<>();
            priorityPoints = 0;
        }

        @Override
        public String toString() {
            return "Schedule{" +
                    "courses=" + courses +
                    ", priorityPoints=" + priorityPoints +
                    '}';
        }
    }

    public Schedule scheduleClass(String filename) {
        List<ClassInfo> classInfos = parseFile(filename);


        // now since there are priority involved now
        // this time we will do a DP approach
        Schedule[] M = new Schedule[classInfos.size() + 1];

        // base case
        M[0] = new Schedule();
        M[0].priorityPoints = 0;
        M[0].courses = new HashSet<>();

        Schedule optimalSchedule = new Schedule();
        for (int i = 1; i < M.length; i++) {
            ClassInfo curClass = classInfos.get(i - 1);
            for (int j = 0; j < i; j++) {

                Schedule newSchedule = new Schedule();
                newSchedule.courses = new HashSet<>(M[j].courses); // take a deep cpy
                newSchedule.priorityPoints = M[j].priorityPoints;

                List<ClassInfo> cost = costOfTakingCurClass(M[j], curClass.startTime, curClass.endTime);
                // insert curCourse
                newSchedule.priorityPoints += curClass.priority;
                newSchedule.courses.add(curClass);
                // eject the courses in the schedule that overlaps with curClass: 'cost'
                for (ClassInfo ci : cost) {
                    newSchedule.priorityPoints -= ci.priority;
                    newSchedule.courses.remove(ci);
                }

                if (newSchedule.priorityPoints > optimalSchedule.priorityPoints) {
                    // replace optimalSchedule with newSchedule
                    optimalSchedule = newSchedule;
                }
            }
            M[i] = optimalSchedule;
        }

        return M[M.length - 1];
    }


    private List<ClassInfo> costOfTakingCurClass(Schedule schedule, int startTime, int endTime) {
        List<ClassInfo> res = new ArrayList<>();
        for (ClassInfo curCourse : schedule.courses) {
            // check overlap
            if (endTime < curCourse.startTime || startTime > curCourse.endTime) {
                continue;
            } else {
                res.add(curCourse);
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
        int priority = Integer.valueOf(infoArray[3]);

        ClassInfo res = new ClassInfo(infoArray[0], startTime, endTime, priority);
        return res;
    }

    private int convertTimeToInt(String time) {
        String[] times = time.split(":");
        return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
    }

    public static void main(String[] args) {
        Q5part2 sol = new Q5part2();
        Schedule res = sol.scheduleClass("Q5-2.csv");
        int totalPriority = 0;
        for (ClassInfo ci : res.courses) {
            System.out.println(ci.courseName + " with priority " + ci.priority);
            totalPriority += ci.priority;
        }
        System.out.println("Total priority scheduled are : " + totalPriority);
    }

}
