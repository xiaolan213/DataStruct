public class Test {
    public static void main(String... args) {
        int a[][] = {{1,2},{2,3},{4,5},{5,6}};
        for (int[] arr:a)
            for (int i: arr)
                System.out.print(i+"\t");
    }
}
