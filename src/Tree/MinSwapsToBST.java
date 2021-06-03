package Tree;

import java.util.*;

public class MinSwapsToBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static ArrayList<Integer> array1 = new ArrayList<>();

    static void inOrder(int[] arr, int index, int n) {

        if (index >= n) {
            return;
        }
        inOrder(arr, 2 * index + 1, n);
        array1.add(arr[index]);
        inOrder(arr, 2 * index + 2, n);
    }

    static int minSwaps(ArrayList<Integer> arr, int n) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr.get(i), i);
        }
        boolean[] arrC = new boolean[n];
        Arrays.fill(arrC, false);
        Collections.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arrC[i] || map.get(arr.get(i)) == i) {
                continue;
            }
            int j = i, cycle = 0;
            while (!arrC[j]) {
                arrC[j] = true;
                j = map.get(arr.get(j));
                cycle++;
            }
            if (cycle > ans) {
                ans += cycle - 1;
            }
        }
        return ans;
    }

    // another simple approach
    static int minSwaps2(int[] arr, int length) {
        int swaps = 0;
        int[] temp = Arrays.copyOf(arr, length);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(arr[i], i);
        }
        Arrays.sort(temp);
        for (int i = 0; i < length; i++) {
            if (temp[i] != arr[i]) {
                swaps++;
                int val = arr[i];
                int index = map.get(temp[i]);
                swap(arr, i, index);
                map.put(val, map.get(temp[i]));
                map.put(temp[i], i);
            }
        }
        return swaps;
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    static int minSwapsToBST(int[] arr) {
        inOrder(arr, 0, arr.length);
        //return minSwaps(array1, arr.length);
        int[] array = new int[array1.size()];
        int i = 0;
        for (int c : array1) {
            array[i] = c;
            i++;
        }
        return minSwaps2(array, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 11};
        System.out.println(minSwapsToBST(arr));
    }
}
