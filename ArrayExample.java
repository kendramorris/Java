public class ArrayExample {
  public static void main(String[] args) {
    int[] nums = new int[40];

    for (int i = 0; i < nums.length; i++) {
      nums [i] = i +1;
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums[i] +10;
    }

    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}