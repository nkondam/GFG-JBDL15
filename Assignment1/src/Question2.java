import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        List<Long> person = new ArrayList<>();
        person.add(new Person(12, "john", 1).getHeight());
        person.add(new Person(12, "john", 2).getHeight());
        person.add(new Person(12, "john", 3).getHeight());
        person.add(new Person(12, "john", 4).getHeight());
        person.add(new Person(12, "john", 5).getHeight());
        person.add(new Person(12, "john", 6).getHeight());
        Question2 q2 = new Question2();
        System.out.println(q2.findMinOperationSum(person));
    }

    // You had to take list of person in the argument but the logic of calucating is correct so that's okay
    private long findMinOperationSum(List<Long> personList) {
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(personList);
       

        while(pq.size()>1) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            sum = num1+num2+sum;
            pq.add(num1 + num2);
        }
        return sum;
    }
}
