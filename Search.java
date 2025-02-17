import java.util.*;

class Search {
    public static boolean arraySearch(int[] arr, int key) {
        for (int num : arr) {
            if (num == key) return true;
        }
        return false;
    }

    public static boolean hashSetSearch(HashSet<Integer> set, int key) {
        return set.contains(key);
    }

    public static boolean treeSetSearch(TreeSet<Integer> set, int key) {
        return set.contains(key);
    }

    public static void main(String[] args) {
        int N = 1_000_000;
        int key = N - 1;
        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        
        for (int i = 0; i < N; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }
        
        long start, end;
        
        start = System.nanoTime();
        arraySearch(array, key);
        end = System.nanoTime();
        System.out.println("Array Search Time: " + (end - start) / 1e6 + " ms");
        
        start = System.nanoTime();
        hashSetSearch(hashSet, key);
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) / 1e6 + " ms");
        
        start = System.nanoTime();
        treeSetSearch(treeSet, key);
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) / 1e6 + " ms");
    }
}
