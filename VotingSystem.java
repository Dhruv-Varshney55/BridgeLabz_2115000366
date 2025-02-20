import java.util.*;
public class VotingSystem{
    private Map<String, Integer> votes = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, votes.get(candidate));
    }

    public Map<String, Integer> getSortedResults() {
        return new TreeMap<>(votes);
    }

    public Map<String, Integer> getVotingOrder() {
        return voteOrder;
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();
        voting.castVote("Dhruv");
        voting.castVote("Vikas");
        voting.castVote("Dhruv");
        voting.castVote("Rishabh");
        voting.castVote("Vikas");
        System.out.println("Votes in order: " + voting.getVotingOrder());
        System.out.println("Sorted Results: " + voting.getSortedResults());
    }
}