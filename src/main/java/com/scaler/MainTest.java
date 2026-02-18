package com.scaler;

import java.util.*;


class MainTest {
    private final Integer availableConnections = 0;

    static void main(String[] args) {
        long[] A = {1, 2, 5, 4, 0};
        int[] B = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        int as = Arrays.stream(B).boxed().mapToInt(Integer::intValue).sum();
        Optional<Integer> a =
                Arrays.stream(B).boxed().filter(Objects::nonNull).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        int K = 10;
//        reverseInGroups(B, B.length, K);
        String[] arr = {"neykgrybpitzfunlefmtmbikgpxkqingmmsudqysarrilgtrnhka", "tmrklbbtojfadcftaxwtqegyxymeioodcfonirhxaozdsfyseulxysvxsjdazsgbzupilyfnmgqflqzsllplfmjzwobvghzibos", "geek",
                "geezer"};
//        longestCommonPrefix(arr,4);
//        smallestSubWithSum(new int[]{6, 3 ,4, 5, 4, 3, 7, 9},8,16);
//        countOccurence(new int[]{3 ,1 ,2 ,2 ,1 ,2 ,3 ,3},8,4);
//        removeDuplicates("HappyNewYear");
//        sortBySetBitCount(new Integer[]{5, 2, 3, 9, 4, 6, 7, 15, 32}, 9);
//        search(new int[]{537
//        },1,537,4);
//        mergeHeaps(new int[]{10, 5, 6, 2},new int[]{12, 7, 9},4,3);
//        missingNumber(new int[]{2},1);
//        duplicates(new int[]{0,3,1,2},4);
//        transitionPoint(new int[]{1,1,1,1},4);
//        pushZerosToEnd(new int[]{3, 0, 0, 5, 4}, 5);
//        findUnion(new int[]{1, 2, 3, 4, 5,}, new int[]{1, 2, 3}, 5, 3);
//        zigZag(new int[]{1,4,3,2},4);
//        findMaximum(new int[]{1,45,47,50,5},5);
//        nthRowOfPascalTriangle(4);
//        saveIronman("I am :IronnorI Ma, i");
//        maxProduct(new int[]{-122, -391, -447}, 3);
//        printUnsorted(new int[]{10,12, 20, 30, 25, 40, 32, 31, 35, 50, 60},11);
//        areElementsContiguous(new int[]{5, 2, 3, 6, 4, 4, 6, 6}, 8);
//        longest(new int[]{4,9,8,5},4);
//        uneatenLeaves(new long[]{2,3,5},10,3);
//        findFibSubset(new int[]{3,4},2);
//        findMaxAverage(new int[]{1, 12, -5, -6, 50, 3},6,4);
//        calculateMaxSumLength(new long[]{1,2,3,2,3,4,1},7,4);
//        findRollOut("bca", new long[]{1, 2, 3}, 3);
//        bitonicGenerator(new int[]{-99, -27, -72, -82, 19, 56, 55, 47, 66, -20, 6, -54, 92, 50, -38, -68, 54, -100, -52},19);
//        int n = (int) Math.sqrt(2);

    }


    static int findMaxAverage(int[] arr, int n, int k) {
        // code here
        int maxAvg = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxAvg = Math.max(maxAvg, sum / k);
        for (int i = k; i < n; i++) {
            sum -= arr[i - k];
            sum += arr[i];
            maxAvg = Math.max(maxAvg, sum / k);
        }
        return maxAvg;
    }

    public static int[] findFibSubset(int[] arr, int n) {
        ArrayList<Integer> fib = new ArrayList<>();
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        calculateFibo(max, fib);
        for (int i = 0; i < n; i++) {
            if (fib.contains(arr[i])) {
                ans.add(arr[i]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    static void calculateFibo(int val, ArrayList<Integer> ans) {
        int prev1 = 1;
        int prev2 = 0;
        // For loop to print Fibonacci series
        for (int i = 1; i <= val + 1; i++) {
            if (i > 2) {
                int num = prev1 + prev2;
                prev2 = prev1;
                prev1 = num;
                ans.add(num);
            }
            // For first two terms
            if (i == 1) {
                ans.add(prev2);
            }
            if (i == 2) {
                ans.add(prev1);
            }
        }
    }

    static int nthItem(int L1, int L2, int[] A, int[] B, int N) {
        // code here
        TreeSet<Integer> ans = new TreeSet<>();
        for (int i = 0; i < L1; i++) {
            for (int j = 0; j < L2; j++) {
                ans.add(A[i] + B[j]);
            }
        }
        Integer[] arr = ans.toArray(new Integer[ans.size()]);
        return arr[N - 1].intValue();
    }

    static long uneatenLeaves(long[] arr, int n, int k) {
        // Your code goes here
        long[] leaves = new long[n + 1];
        long size = leaves.length;
        for (int i = 0; i < k; i++) {
            long j = 1;
            while (arr[i] * j < size) {
                leaves[(int) arr[i] * (int) j] = 1;
                j++;
            }
        }
        long count = 0;
        for (int j = 1; j < size; j++) {
            if (leaves[j] == 0) {
                count++;
            }
        }
        return count;
    }

    public static int[] getStarAndSuperStar(int[] arr, int n) {
        // code here
        Stack<Integer> st = new Stack<>();
        int staridx = n - 1;
        boolean flag = true;
        for (; staridx >= 0; staridx--) {
            if (!st.isEmpty() && st.peek() < arr[staridx]) {
                st.push(arr[staridx]);
            } else if (!st.isEmpty() && st.peek() == arr[staridx]) {
                flag = false;
            }
        }
        int[] ans = new int[st.size()];
        if (!flag) {
            ans[0] = -1;
        }
        int k = 0;
        while (!st.isEmpty()) {
            ans[k++] = st.pop().intValue();
        }
        return ans;
    }

    public static int longest(int[] arr, int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2 && arr[1] > arr[0]) {
            return 2;
        }
        int count = 1, max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                count++;
                max = arr[i];
            }
        }
        return count;
    }

    public static boolean areElementsContiguous(int[] arr, int n) {
        //Complete the function
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != arr[i]) {
                if (arr[i - 1] != arr[i] - 1) {
                    return false;
                }
            }
        }
//        TreeSet<Integer> set = new TreeSet<>();
//        for (int i = 0; i < n; i++) {
//            set.add(arr[i]);
//        }
//        for (int i = 1; i < n; i++) {
//            if (!(set.contains(arr[i - 1]) && set.contains(arr[i - 1] + 1))) {
//                return false;
//            }
//        }
        return true;
    }

    static int[] printUnsorted(int[] arr, int n) {
        // code here
        int s = 0, e = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                s = i - 1;
                break;
            }
        }
        if (s == n - 1) {
            return new int[]{0, 0};
        }
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                e = i;
                break;
            }
        }
        int max = arr[s], min = arr[s];
        for (int i = s + 1; i <= e; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        for (int i = 0; i < s; i++) {
            if (min < arr[i]) {
                s = i;
                break;
            }
        }
        for (int i = n - 1; i >= e + 1; i--) {
            if (max > arr[i]) {
                e = i;
                break;
            }
        }
        return new int[]{s, e};
    }

    static long maxProduct(int[] arr, int n) {
        // code here
        int max = arr[0], secMax = max, thirdMax = secMax;
        int min = arr[0], secMin = min;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                thirdMax = secMax;
                secMax = max;
                max = arr[i];
            } else if (arr[i] > secMax && arr[i] != max) {
                thirdMax = secMax;
                secMax = arr[i];
            } else if (arr[i] > thirdMax && arr[i] != secMax) {
                thirdMax = arr[i];
            }
        }
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != min) {
                secMin = Math.min(secMin, arr[i]);
            }
        }
        return Math.max(max * secMax * thirdMax, min * secMin * max);
    }

    public static boolean saveIronman(String s) {

        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanedString.length() - 1;
        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static ArrayList<Long> nthRowOfPascalTriangle(int n) {
//        long mod = 1000000007;
//        ArrayList<Long> al = new ArrayList<>(n );
//
//        for (int i = 0; i <= n; i++) {
//            al.add(0L);
//        }
//        al.set(0, 1L);
//        for (int i = 0; i < n-1; i++) {
//            for (int j = n-1; j >= 1; j--) {
//                al.set(j, (al.get(j) % mod + al.get(j - 1) % mod) % mod);
//            }
//        }
//        al.remove(n);
//        return al;
//                ArrayList<ArrayList<Long>> arr = new ArrayList<>();
//                ArrayList<Long> carr = new ArrayList<>();
//                if(n == 1){
//                    carr.add((long)1);
//                    return carr;
//                }
//
//                for (int i = 0; i < n; i++) {
//                    int colLen = i + 1;
//                    carr = new ArrayList<>();
//                    carr.add(0, (long)1);
//                    for (int j = 1; j < colLen - 1; j++) {
//                        carr.add((arr.get(i-1).get(j-1) + arr.get(i-1).get(j))%1000000007);
//                    }
//                    carr.add((long)1);
//                    arr.add(carr);
//                }
//                return carr;
        ArrayList<Long> pre = new ArrayList<>();
        long mod = 1000000007;
        for (int i = 0; i < n; i++) {
            ArrayList<Long> current = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == i | j == 0) {
                    current.add(1L);
                } else {
                    long num = (pre.get(j) + pre.get(j - 1)) % mod;
                    current.add(num);
                }
            }
            pre = current;
        }
        return pre;
    }

    public static void zigZag(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                if (a[i] > a[i + 1]) {
                    swap(a, i + 1, i);
                }
            } else {
                if (a[i] < a[i + 1]) {
                    swap(a, i + 1, i);
                }
            }
        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        // add your code here
        HashSet<Integer> union = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            union.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            union.add(arr2[i]);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator itr = union.iterator();
        while (itr.hasNext()) {
            result.add(Integer.valueOf(itr.next().toString()));
        }
        return result;
    }

    public static ArrayList<Integer> findUnion1(int[] arr1, int[] arr2, int n, int m) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if ((i == 0 || arr1[i] != arr1[i - 1]) && (j == 0 || arr2[j] != arr2[j - 1])) {
                if (arr1[i] < arr2[j]) {
                    ans.add(arr1[i]);
                    i++;
                } else if (arr1[i] > arr2[j]) {
                    ans.add(arr2[j]);
                    j++;
                } else {
                    ans.add(arr1[i]);
                    i++;
                    j++;
                }
            } else {
                if (arr1[i] <= arr2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        while (i < n) {
            if ((i == 0 || arr1[i] != arr1[i - 1])) {
                ans.add(arr1[i]);
            }
            i++;
        }
        while (j < m) {
            if ((j == 0 || arr2[j] != arr2[j - 1])) {
                ans.add(arr2[j]);
            }
            j++;
        }
        return ans;
    }

    public static ArrayList<Integer> findUnion2(int[] arr1, int[] arr2, int n, int m) {
        // add your code here
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (list.size() == 0 || arr1[i] != list.get(list.size() - 1)) {
                    list.add(arr1[i]);
                }
                i++;
            } else {
                if (list.size() == 0 || arr2[j] != list.get(list.size() - 1)) {
                    list.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < n) {
            if (list.size() == 0 || arr1[i] != list.get(list.size() - 1)) {
                list.add(arr1[i]);
            }
            i++;
        }
        while (j < m) {
            if (list.size() == 0 || arr2[j] != list.get(list.size() - 1)) {
                list.add(arr2[j]);
            }
            j++;
        }
        return list;
    }

    static void pushZerosToEnd(int[] arr, int n) {
        // code here
        int j = n - 1;
        while (j - 1 >= 0) {
            if (arr[j] != 0 && arr[j - 1] == 0) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            } else if (arr[n - 1] == 0) {
                j = n - 1;
            }
            j--;
        }
//        Integer[] zeros = new Integer[arr.length];
//        for (Integer i = 0; i < n; i++) {
//            zeros[i] = arr[i];
//        }
//        Arrays.sort(zeros, (a, b) -> {
//            if (a == 0 && b != 0) {
//                return 1;
//            }else if (a != 0 && b == 0) {
//                return -1;
//            }
//            return 0;
//        });
//        for (int i = 0; i < n; i++) {
//            arr[i] = zeros[i];
//        }
    }

    public static int NumberofElementsInIntersection(int[] a, int[] b, int n, int m) {
        // Your code here
        int count = 0;
        HashSet<Integer> set = new HashSet<>(n);
        for (int i : a) {
            set.add(i);
        }
        HashSet<Integer> set1 = new HashSet<>(m);
        for (int i : b) {
            set1.add(i);
        }
        set.retainAll(set1);
        return set.size();
    }

    public static int firstRepeated(int[] arr, int n) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                if (map.get(arr[i]) > 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    static int transitionPoint(int[] arr, int n) {
        // code here
        if (n == 1 && arr[0] == 1) {
            return 0;
        }
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != arr[i]) {
                return i;
            } else if (arr[i] == 1) {
                count++;
            }
        }
        if (count == n) {
            return 0;
        }
        return -1;
    }

    public static ArrayList<Integer> duplicates(int[] arr, int n) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        if (ans.size() >= 1) {
            return ans;
        }
        ans.add(-1);
        return ans;
    }

    static int missingNumber(int[] array, int n) {
        // Your Code Here
        if (n == 1) {
            return array[0];
        }
        int ans = 0, max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(array[i], max);
        }
        int[] val = new int[max + 1];
        for (int i = 0; i < n - 1; i++) {
            int a = array[i];
            val[a]++;
        }
        for (int i = 1; i <= max; i++) {
            if (val[i] == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        int[] ans = new int[n + m];
        int i = 0, j = 0, k = 0;
        int size = Math.max(n, m);
        while (i < n - 1 && j < m - 1) {
            if (a[i] < b[j]) {
                ans[k] = b[j++];
            } else if (a[i] > b[j]) {
                ans[k] = a[i++];
            }
            k++;
        }
        return ans;
    }

    static void reverseInGroups(int[] arr, int n, int k) {
        // code here
        int left = 0, right = k - 1;
        if (k > n) {
            reverse(arr, 0, n - 1);
        } else {
            boolean contains = true;
            while (contains) {
                reverse(arr, left, right);
                left = right + 1;
                right = right + k;
                if (right >= n) {
                    right = n - 1;
                    reverse(arr, left, right);
                    contains = false;
                }
            }
        }
//        System.out.println(arr.toString());
    }

    static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }

    static String longestCommonPrefix(String[] arr, int n) {
        // code here
        String prefix = "";
        if (arr.length > 1) {
            prefix = commonPrefix(arr[0], arr[1]);
            if (prefix.equals("-1")) {
                return prefix;
            }
        } else {
            return "-1";
        }
        for (int i = 2; i < n; i++) {
            prefix = commonPrefix(prefix, arr[i]);
        }
        return prefix;
    }

    static String commonPrefix(String a, String b) {
        int size = Math.min(a.length(), b.length());
        String prefix = "";
        for (int i = 0; i < size; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                prefix = a.substring(0, i + 1);
            } else {
                break;
            }
        }
        return prefix.length() == 0 ? "-1" : prefix;
    }

    public static int smallestSubWithSum(int[] a, int n, int x) {
        // Your code goes here
        int i = 0, j = i, sum = 0, len = Integer.MAX_VALUE;
        while (j < n) {
            sum += a[j++];
            if (sum > x) {
                len = Math.min(len, j - i);
                sum = 0;
                i++;
                j = i;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static int countOccurence(int[] arr, int n, int k) {
        // your code here,return the answer
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int count = 0;
        Iterator itr = map.values().iterator();
        while (itr.hasNext()) {
            if ((int) itr.next() > n / k) {
                count++;
            }
        }
        return count;
    }

    static String removeDuplicates(String str) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            Character c = ch;
            map.put(ch, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                if (map.get(str.charAt(i)) > 1) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                sb.append(str.charAt(i));
                map.remove(str.charAt(i));
            }
        }
        return sb.toString();
    }

    static void sortBySetBitCount(Integer[] arr, int n) {
        // Your code goes here
        Arrays.sort(arr, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                int a = 0, b = 0;
                int m = Integer.parseInt(o1.toString());
                int n = Integer.parseInt(o2.toString());
                for (int i = 0; i <= 30; i++) {
                    if (((m >> i) & 1) == 1) {
                        a++;
                    }
                }
                for (int i = 0; i <= 30; i++) {
                    if (((n >> i) & 1) == 1) {
                        b++;
                    }
                }
                if (a > b) {
                    return -1;
                } else if (a < b) {
                    return 1;
                }
                return 0;
            }
        });
        // Your code goes here
        Arrays.sort(arr, (i1, i2) -> {
            return Integer.bitCount(i2) - Integer.bitCount(i1);
        });
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int search(int[] arr, int n, int x, int k) {
        //Complete the function
        int i = 0, idx = Integer.MAX_VALUE;
        while (i < n) {
            if (i > 0 && i + 1 < n) {
                if (Math.abs(arr[i - 1] - arr[i]) <= k &&
                        Math.abs(arr[i] - arr[i + 1]) <= k) {
                    if (arr[i] == x) {
                        idx = Math.min(idx, i);
                    }
                }
            } else if (n > 1 && i == n - 1) {
                if (Math.abs(arr[i - 1] - arr[i]) <= k) {
                    if (arr[i] == x) {
                        idx = Math.min(idx, i);
                    }
                }
            } else if (arr.length == 1) {
                if (arr[0] == x) {
                    idx = 0;
                }
            }
            i++;
        }
        return idx == Integer.MAX_VALUE ? -1 : idx;
    }

    boolean checkDuplicatesWithinK(int[] arr, int n, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr, 0) + 1);
        }

        Iterator itr = map.values().iterator();
        while (itr.hasNext()) {
            if ((int) itr.next() > 1) return true;
        }
        int i = 1, j = k;
        while (i + k < n) {
            if (map.containsKey(arr[i - 1]))
                map.put(arr[i - 1], map.get(arr[i - 1]) - 1);
            if (map.get(arr[i - 1]) == 0)
                map.remove(arr[i - 1]);
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            if (map.get(arr[j]) > 1)
                return true;
            i++;
            j++;
        }
        return false;
    }

    int getSingle(int[] arr, int n) {
        // code here
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    long minimizeSum(int N, int[] arr) {
        // code here
        long ans = 0;
        Queue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add((long) arr[i]);
        }
        while (queue.size() > 1) {
            long a = queue.poll();
            long b = queue.poll();
            long sum = a + b;
            queue.add(sum);
            ans += sum;
        }
        return ans;
    }

    String MaxZero(String[] arr, int N) {
        int max = 0;
        String ans = "0";
        for (int i = 0; i < N; i++) {
            int num = Integer.valueOf(arr[i]);
            int count = 0;
            while (num > 9) {
                int digit = num % 10;
                if (digit == 0) {
                    count++;
                }
                num = num / 10;
            }
            if (count > max) {
                max = count;
                ans = String.valueOf(Math.max(Integer.valueOf(ans), Integer.valueOf(arr[i])));
            }
        }
        return max == 0 ? "-1" : ans;
    }

    String roundToNearest(String N) {
        int len = N.length();
        int lastDigit = N.charAt(len - 1) - '0';
        if (lastDigit != 0) {
            if (lastDigit <= 5) {
                N = N.substring(0, len - 1) + '0';
            } else {
                StringBuilder sb = new StringBuilder(N);
                sb.setCharAt(len - 1, '0');
                int sum, carry = 1;
                for (int i = len - 2; i >= 0; --i) {
                    int currDigit = N.charAt(i) - '0';
                    sum = currDigit + carry;
                    if (sum > 9) {
                        sb.setCharAt(i, '0');
                        carry = 1;
                    } else {
                        sb.setCharAt(i, (char) (sum + '0'));
                        carry = 0;
                        break;
                    }
                }
                if (carry == 1) {
                    sb.insert(0, "1");
                }
                N = sb.toString();
            }
        }
        return N;
    }

    public int unvisitedLeaves(int N, int leaves, int[] frogs) {
        // Code here
        int[] vis = new int[leaves + 1];
        for (int i = 0; i < N; i++) {
            int pos = frogs[i];
            if (pos <= leaves && vis[pos] == 0) {
                int temp = pos;
                while (temp <= leaves) {
                    if (vis[temp] == 0) {
                        vis[temp] = 1;
                    }
                    temp += pos;
                }
            }
        }
        int count = 0;
        for (int i = 1; i < leaves + 1; i++) {
            if (vis[i] == 0) {
                count++;
            }
        }
        return count;
    }

    boolean find4Numbers(int[] A, int n, int X) {
        int i, j, num1 = 0, num2 = 0, s = 0;
        if (n < 4) {
            return false;
        }
        Arrays.sort(A);
        for (i = 0; i < n - 3; i++) {
            for (j = i + 1; j < n - 2; j++) {
                num1 = j + 1;
                num2 = n - 1;
                while (num1 < num2) {
                    s = A[i] + A[j] + A[num1] + A[num2];
                    if (s == X) {
                        return true;
                    } else if (s < X) {
                        num1++;
                    } else {
                        num2--;
                    }
                }
            }
        }
        return false;
    }

    boolean isProduct(int[] a, int n, long x) {
        // code here
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i] != 0 && x % a[i] == 0 && set.contains(x / a[i])) {
                return true;
            }
            set.add((long) a[i]);
        }
        return false;
    }

    public void segregateElements(int[] arr, int n) {
        // Your code goes here
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = arr[i];
        }
        Arrays.sort(a, (i, j) -> {
            if (i < j && i < 0) {
                return -1;
            } else if (i > j && j < 0) {
                return 1;
            }
            return 0;
        });
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
    }

    public pair[] allPairs(long[] A, long[] B, long N, long M, long X) {
        // Your code goes here
        Arrays.sort(A);
        Arrays.sort(B);
        ArrayList<pair> pairs = new ArrayList<>();
        pair pair = null;
        int i = 0, j = (int) M - 1;
        while (i < N && j >= 0) {
            long k = A[i] + B[j];
            if (k == X) {
                pair = new pair(A[i], B[j]);
                pairs.add(pair);
                if (A[i] <= B[j]) {
                    j--;
                } else {
                    i++;
                }
            } else if (k > X) {
                j--;
            } else {
                i++;
            }
        }
        return pairs.toArray(new pair[pairs.size()]);
    }

    boolean hasArrayTwoCandidates(int[] arr, int n, int x) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = x - arr[i];
            if (map.containsKey(a)) {
                return true;
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return false;
    }

    //Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        int i = 0;
        while (i < n) {
            if (n - i >= k) {
                Collections.reverse(arr.subList(i, i + k));
                i += k;
            } else {
                Collections.reverse(arr.subList(i, n));
                break;
            }
        }
    }

    //User function Template for Java
    String removeDuplicates2(String str) {
        // code here
        HashSet<Character> set = new HashSet<>();
        String ans = "";
        for (char x : str.toCharArray()) {
            if (!set.contains(x)) {
                ans = ans + x;
                set.add(x);
            }
        }
        return ans;
    }

    String removeDuplicates3(String str) {
        // code here
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (!(s.contains(str.charAt(i) + ""))) {
                s += str.charAt(i);
            }
        }
        return s;
    }
//User function Template for Java

    String removeDuplicates5(String str) {
        // code here
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            if (map.containsKey(str.charAt(i))) {
                continue;
            } else {
                ans.append(str.charAt(i));
                map.put(str.charAt(i), 1);
            }
        }
        return ans.toString();
    }

    String removeDuplicates6(String str) {
        Map<Character, Integer> map = new HashMap<>();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                result += str.charAt(i);
            }
            map.put(str.charAt(i), 0);
        }
        return result;
    }

    public int countOccurence2(int[] a, int n, int k) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
        }
        int[] b = new int[Math.max(max + 1, n)];
        for (int i = 0; i < n; i++) {
            b[a[i]] += 1;
        }
        int res = 0;
        for (int i = 0; i < Math.max(max + 1, n); i++) {
            if (b[i] > n / k) {
                res++;
            }
        }
        return res;
    }

    public int countOccurence1(int[] arr, int n, int k) {
        int times = n / k;
        // Find the maximum value in the array
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        // Ensure the count array can accommodate the maximum value
        int[] count = new int[maxVal + 1];
        // Count occurrences of each element in the array
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        int elems = 0;
        // Iterate through the count array and count elements that appear more than n/k times
        for (int i = 0; i < count.length; i++) {
            if (count[i] > times) {
                elems++;
            }
        }
        return elems;
    }

    class pair {
        long first, second;

        public pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }


}
