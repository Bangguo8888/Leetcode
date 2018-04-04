/**
 * Created by bangguo on 2018/4/1.
 */
import java.util.*;
public class ConstructItinerary {
    HashMap<String, PriorityQueue<String>> map;
    List<String> result;
    public List<String> findItinerary(String[][] tickets) {
        map = new HashMap<>();
        result = new LinkedList<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> q = map.get(ticket[0]);
            if (q == null) {
                q = new PriorityQueue<>();
            }
            q.offer(ticket[1]);
            map.put(ticket[0], q);
        }
        dfs("JFK");
        return result;
    }

    private void dfs(String airport) {
        while (map.containsKey(airport)  && !map.get(airport).isEmpty()) {
            dfs(map.get(airport).poll());
        }
        result.add(0, airport);


    }

    public static void main(String[] args) {
        String[][] tickets = new String[][] {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        ConstructItinerary solution = new ConstructItinerary();
        List<String> result = solution.findItinerary(tickets);
        System.out.println(result);
    }
}
