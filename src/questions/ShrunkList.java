package questions;

import java.util.*;

public class ShrunkList {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("a", "b", "c", "d", "e", "e", "e", "e", "e", "e", "d", "d", "c", "b", "f", "g", "f", "h", "h", "h", "t");
        int burstLength1 = 3;
        List<String> expected1 = Arrays.asList("a", "b", "c", "c", "b", "f", "g", "f", "t");
        List<String> actual1 = getShrunkList(list1, burstLength1);
        System.out.println(actual1);

        List<String> list2 = Arrays.asList("a", "b", "c", "b");
        int burstLength2 = 2;
        List<String> expected2 = Arrays.asList("a", "b", "c", "b");
        List<String> actual2 = getShrunkList(list2, burstLength2);
        System.out.println(actual2);

        List<String> list3 = Arrays.asList("a", "b", "c", "d", "e", "e", "e", "e", "d", "d", "c", "b", "f", "g", "f");
        int burstLength3 = 3;
        List<String> expected3 = Arrays.asList("a", "b", "c", "c", "b", "f", "g", "f");
        List<String> actual3 = getShrunkList(list3, burstLength3);
        System.out.println(actual3);
    }

        public static List<String> getShrunkList(List<String> inputArray, int burstLength) {
            Stack<Pair> stack = new Stack<>();
            int n = inputArray.size();
            for(int i = 0; i < n;) {

                boolean flag = false;

                while(i < n && !stack.isEmpty() && stack.peek().str.equals(inputArray.get(i))) {
                    stack.peek().cnt++;
                    i++;
                    flag = true;
                }

                while(!stack.isEmpty() && stack.peek().cnt >= burstLength) {
                    stack.pop();
                }

                if(!flag) {
                    stack.push(new Pair(inputArray.get(i)));
                    i++;
                }
            }

            LinkedList<String> res = new LinkedList<>();
            while(!stack.isEmpty()) {
                Pair pair = stack.pop();
                while(pair.cnt > 0) {
                    res.addFirst(pair.str);
                    pair.cnt--;
                }
            }
            return res;
        }

        static class Pair {
            String str;
            int cnt = 0;
            Pair(String s) {
                str = s;
                cnt = 1;
            }
        }
}