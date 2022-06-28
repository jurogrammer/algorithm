package programmers.receive_report_result;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportListByReporter = new HashMap<>();
        for (String id : id_list) {
            reportListByReporter.put(id, new HashSet<>());
        }

        for (String line : report) {
            String[] s = line.split(" ");
            String reporter = s[0];
            String reportee = s[1];

            Set<String> reportees = reportListByReporter.get(reporter);
            reportees.add(reportee);
        }

        Map<String, Integer> reportCntByReportee = new HashMap<>();
        for (String id : id_list) {
            reportCntByReportee.put(id, 0);
        }

        for (String id : id_list) {
            Set<String> reportees = reportListByReporter.get(id);
            for (String reportee : reportees) {
                reportCntByReportee.computeIfPresent(reportee, (key, val) -> val + 1);
            }
        }

        int[] answer = new int[id_list.length];
        int i = 0;

        for (String reporter : id_list) {
            int receiveMailCnt = 0;
            Set<String> reportees = reportListByReporter.get(reporter);
            for (String reportee : reportees) {
                Integer reportCnt = reportCntByReportee.get(reportee);
                if (reportCnt >= k) {
                    receiveMailCnt++;
                }
            }
            answer[i] = receiveMailCnt;
            i++;
        }
        return answer;
    }
}