public class Algorithm {

    static int[] out;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,5,6};
        int r = 4;
        out = new int[r];
        System.out.println(" per ");
        permutation(arr, new int[r], new boolean[arr.length], 0, r);
        System.out.println();

        System.out.println(" com " );
        combination(arr, new boolean[arr.length], 0, 0, 4);
        System.out.println();

    }

    public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {

        if (depth == r) {
            for (int num : out) System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }

    }

    public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {

        if (depth == r) {
            for(int i : out) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
//                visited[i] = true;
                out[depth] = arr[i];
                combination(arr, visited, i+1 , depth + 1, r);
//                visited[i] = false;
            }
        }
    }

}