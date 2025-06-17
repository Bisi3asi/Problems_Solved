import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> route = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        for(String[] ticket : tickets) {
            // 각 출발지 별 도착할 수 있는 도착지를 각각 key, (value list)의 hashmap으로 변환
            // priorityQueue를 사용하는 이유는 도착지를 사전순으로 정렬하기 위함
            // computeIfAbsent: 해당 key가 이미 존재하면 아무 것도 하지 않고 그 값을 반환
            // 존재하지 않으면 mappingFunction을 통해 새 값을 만들고 map에 저장후 반환
            //즉, containsKey() + put() + get()을 한 줄로 묶은 것
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        
        dfs("ICN");
        // 길이가 0인 배열을 넘기면 내부적으로 동적 배열을 만든다.
        return route.toArray(new String[0]);
    }
    
    private void dfs(String airport) {
        PriorityQueue<String> dests = graph.get(airport);
        
        while(dests != null && !dests.isEmpty()) {
            String next = dests.poll();
            dfs(next);
        }
        
        // 후위 순회 방식으로 DFS 종료 후 정답 배열의 맨 첫번째 원소로 입력해 역순으로 경로를 채워감
        route.add(0, airport);
    }
}