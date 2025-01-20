package RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> nums = new RandomArrayList<Integer>();
        nums.add(1);
        nums.add(23);
        nums.add(41);
        System.out.println(nums.getRandomElement());
    }
}
