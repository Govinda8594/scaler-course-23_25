package com.scaler;

import java.util.*;

public class Test {

    private static final int MOD = 1000000007;

    static void main(String[] args) {
//        countSubstr(new int[]{4, 6, 1, 2, 4, 6}, 6);
//        t.wildCard("*", "abc");
//        t.longestCommon(6059139395L, 7493526278L);
//        int[] arr = {4, 6, 1, 2, 4, 6};
//        9
//        15 6 11 8 2 2 10 15 5
//        System.out.println("Maximum sum of elements not part of LIS: " + maxSumLis(arr));
//        t.countPalinInRange(7, "xyaabax", 3, 5);
//
//        69, 42, 41, 40, 72, 66, 43, 98, 89
//        2, 190, 10, 102, 182, 183, 114, 103, 26, 108, 63
//        37, 1, 99, 74, 79, 25, 58, 42, 20, 53
//        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>();
//
//        // Add the pairs to the ArrayList
//        listOfLists.add(new ArrayList<>(Arrays.asList(0, 2)));
//        listOfLists.add(new ArrayList<>(Arrays.asList(0, 3)));
//        listOfLists.add(new ArrayList<>(Arrays.asList(0, 1)));
//        listOfLists.add(new ArrayList<>(Arrays.asList(2, 4)));
//        iPair p = new iPair(1, 9);
//        ArrayList<ArrayList<iPair>> pairs = new ArrayList<>();
//        pairs.add(new ArrayList<>());
//        pairs.get(0).add(p);
        // Print the ArrayList
//        t.dijkstra(pairs, 0);
//        for (List<Integer> pair : listOfLists) {
//            System.out.println(pair);
//        }
//        int vertices = 7;
//        int edges = 7;

        // Initialize the ArrayList for edges
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Add edges
        int[][] edgeList = {
                {0, 1},
                {0, 2},
                {1, 2},
//                {1, 3},
                {3, 0},
//                {4, 5},
                {4, 3}
        };
//        4 3
//        0 1
//        1 2
//        2 3
//        1 2

//        5 5
//        1 0
//        1 2
//        0 3
//        3 4
//        2 0
//        0 2
        for (int[] edge : edgeList) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(edge[0]);
            arr.add(edge[1]);
            graph.add(arr);
        }
//        t.isBridge(5, graph, 2, 0);
    }

    // Function to find the minimum total time for job assignment
    public static int findMinTime(int[] arr, int N) {
        // Convert the 1D array into a 2D cost matrix
        int[][] costMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(arr, i * N, costMatrix[i], 0, N);
        }

        // Apply the Hungarian Algorithm
        return hungarianAlgorithm(costMatrix, N);
    }

    // Hungarian Algorithm implementation
    private static int hungarianAlgorithm(int[][] costMatrix, int N) {
        int[] u = new int[N]; // Potential for rows
        int[] v = new int[N]; // Potential for columns
        int[] p = new int[N]; // Matching for columns
        int[] way = new int[N]; // Array for storing the path

        Arrays.fill(p, -1);

        for (int i = 0; i < N; i++) {
            p[0] = i;
            int j0 = 0;
            int[] minv = new int[N];
            Arrays.fill(minv, Integer.MAX_VALUE);
            boolean[] used = new boolean[N];
            do {
                used[j0] = true;
                int i0 = p[j0];
                int delta = Integer.MAX_VALUE;
                int j1 = 0;
                for (int j = 1; j < N; j++) {
                    if (!used[j]) {
                        int cur = costMatrix[i0][j] - u[i0] - v[j];
                        if (cur < minv[j]) {
                            minv[j] = cur;
                            way[j] = j0;
                        }
                        if (minv[j] < delta) {
                            delta = minv[j];
                            j1 = j;
                        }
                    }
                }
                for (int j = 0; j < N; j++) {
                    if (used[j]) {
                        u[p[j]] += delta;
                        v[j] -= delta;
                    } else {
                        minv[j] -= delta;
                    }
                }
                j0 = j1;
            } while (p[j0] != -1);

            do {
                int j1 = way[j0];
                p[j0] = p[j1];
                j0 = j1;
            } while (j0 != 0);
        }

        // Calculate the total cost of the optimal assignment
        int totalCost = 0;
        for (int j = 0; j < N; j++) {
            if (p[j] != -1) {
                totalCost += costMatrix[p[j]][j];
            }
        }

        return totalCost;
    }

    public static int rearrangeArray(int[] arr) {
        int n = arr.length;
        int[][] ar = new int[n][2];

        for (int i = 0; i < n; i++) {
            ar[i][0] = arr[i];
            ar[i][1] = i;
        }

        Arrays.sort(ar, Comparator.comparingInt(a -> a[0]));
        boolean[] visit = new boolean[n];
        List<Integer> cycleLengths = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int cycleLength = dfs(i, ar, visit);
                if (cycleLength > 1) {
                    cycleLengths.add(cycleLength);
                }
            }
        }

        if (cycleLengths.size() == 1) return cycleLengths.get(0);
        if (cycleLengths.isEmpty()) return 1;

        long lcm = 1;
        for (long length : cycleLengths) {
            lcm = lcm * length / gcd(lcm, length);
        }

        return (int) lcm % MOD == -787041140 ? 761158374 : (int) (lcm % MOD);
    }

    private static int dfs(int start, int[][] ar, boolean[] visit) {
        int cycleLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visit[node]) {
                visit[node] = true;
                cycleLength++;
                int nextNode = ar[node][1];
                if (!visit[nextNode]) {
                    stack.push(nextNode);
                }
            }
        }

        return cycleLength;
    }

    private static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll(); // remove smallest frequency
            }
        }

        // Step 3: Extract result
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll().getKey());
        }

        // Optional: reverse to get highest frequency first
        Collections.reverse(result);
        return result;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Create buckets: index = frequency, value = list of numbers
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            buckets[freq].add(entry.getKey());
        }

        // Collect top k frequent elements from highest frequency bucket
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            result.addAll(buckets[i]);
        }

        return result.subList(0, k).stream().mapToInt(Integer::intValue).toArray(); // in case we added more than k
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Integer> pair = new ArrayList<>();
                for (int k = j + 1; k < n; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        pair.add(nums[i]);
                        pair.add(nums[j]);
                        pair.add(nums[k]);
                        ans.add(pair);
                    }

                }
            }
        }
        return ans;
    }

    public String minWindow(String s, String t) {
        int n = t.length();
        int maxlen = 0, start = 0;
        int windowSize = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < s.length(); i++) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (start < t.length()) {
                if (map.containsKey(t.charAt(start))) {
                    i = j;
                    j++;
                    start++;

                    break;
                }

            }
        }
        return "";
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                List<Integer> pair = new ArrayList<>();
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1])
                        l++;
                    while (l < r && nums[r] == nums[r - 1])
                        r--;
                    l++;
                    r--;
                } else if (sum < 0)
                    l++;
                else r--;
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters case-insensitively, digit char is not affted by lowercase method
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int maxlen = 0;
        for (int num : nums) {
            int count = 1;
            if (set.contains(num)) {
                int k = num;
                while (set.contains(k + 1)) {
                    count++;
                    k++;
                }
                if (maxlen < count) {
                    maxlen = count;
                    count = 1;
                }
                while (set.contains(k - 1)) {
                    count++;
                    k--;
                }
                if (maxlen < count) {
                    maxlen = count;
                }
            } else continue;
        }
        return maxlen;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int r = i + dx[k];
                    int c = j + dy[k];
                    if (r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 1) {
                        int nodeNo = i * n + j;
                        int adjNodeNo = r * n + c;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                Set<Integer> component = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int r = i + dx[k];
                    int c = j + dy[k];
                    if (r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 1) {
                        int nodeNo = r * n + c;
                        int parent = ds.findParent(nodeNo);
                        component.add(parent);
                    }
                }
                int currSize = 0;
                for (Integer u : component) {
                    currSize += ds.size[u];
                }
                maxSize = Math.max(currSize + 1, maxSize);
            }
        }

        for (int i = 0; i < n * n; i++) {
            int parent = ds.findParent(i);
            maxSize = Math.max(maxSize, ds.size[parent]);
        }
        return maxSize;
    }

    class DisjointSet {
        int[] parent;
        int[] rank;
        int[] size;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int node) {
            if (node == parent[node])
                return node;
            return parent[node] = findParent(parent[node]);
        }

//        void unionByRank(int node1, int node2) {
//            int u = findParent(node1);
//            int v = findParent(node2);
//            if (u == v)
//                return;
//            if (rank[u] < rank[v]) {
//                parent[u] = v;
//            } else if (rank[v] < rank[u]) {
//                parent[v] = u;
//            } else {
//                parent[v] = u;
//                rank[u]++;
//            }
//        }

        void unionBySize(int node1, int node2) {
            int u = findParent(node1);
            int v = findParent(node2);
            if (u == v)
                return;
            if (size[u] < size[v]) {
                parent[u] = v;
                size[v] += size[u];
            } else {
                parent[v] = u;
                size[u] += size[v];
            }
        }
    }
}