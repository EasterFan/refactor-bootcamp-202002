package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    public static void main(String[] args) {

    }

    public static double fibonacci(int index) throws Exception {
        verify(index);
        double[] arr;
        if (index == 1 || index == 2) {
            return 1;
        } else {
            arr = new double[index];
            arr[0] = arr[1] = 1;
            for (int i = 2; i < arr.length; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
        return arr[index - 1];
    }

    private static void verify(int index) throws Exception {
        if (index <= 0 ) throw new Exception("Bad args");
    }
}
