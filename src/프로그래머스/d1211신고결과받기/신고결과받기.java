import java.util.*;

class 신고결과받기 {
    Map<String, Integer> reportMap = new HashMap<>();
    Map<String, Set<String>> result = new HashMap<>();
    public int[] solution(String[] id_list, String[] report, int k) {

        for (String s : report) {
            String[] reportArr = s.split(" ");
            String reportingUser = reportArr[0];
            String reportedUser = reportArr[1];
            result.put(reportingUser, result.getOrDefault(reportingUser, new HashSet<>()));
            if (result.get(reportingUser).add(reportedUser)) {
                reportMap.put(reportedUser, reportMap.getOrDefault(reportedUser, 0) + 1);
            }
        }

        List<String> sanctionedUser = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
            if (entry.getValue() >= k) {
                sanctionedUser.add(entry.getKey());
            }
        }
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            for (String s : result.getOrDefault(id, new HashSet<>())) {
                if (sanctionedUser.contains(s)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}
