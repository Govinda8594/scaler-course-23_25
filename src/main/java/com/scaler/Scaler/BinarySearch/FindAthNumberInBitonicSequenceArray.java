package com.scaler.Scaler.BinarySearch;

public class FindAthNumberInBitonicSequenceArray {

    // Function for binary search in ascending part
    public int ascendingBinarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // Function for binary search in descending part of array
    public int descendingBinarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // finding bitonic point
    public int findBitonicPoint(int[] arr, int n, int l, int r) {
        int mid;
        mid = (r + l) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
            return findBitonicPoint(arr, n, mid, r);
        } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return findBitonicPoint(arr, n, l, mid);
        }
        return -1;
    }

    // Function to search key in bitonic array
    public int searchBitonic(int[] arr, int n, int key, int index) {
        if (key > arr[index]) {
            return -1;
        } else if (key == arr[index]) {
            return index;
        } else {
            int temp = ascendingBinarySearch(arr, 0, index - 1, key);
            if (temp != -1) {
                return temp;
            }

            // Search in right of k
            return descendingBinarySearch(arr, index + 1, n - 1, key);
        }
    }

    public int solveQ(int[] arr, int b) {
        int index = findBitonicPoint(arr, arr.length, 0, arr.length - 1);
        int x = searchBitonic(arr, arr.length, b, index);
        return x;
    }

    public int solve(int[] A, int B) {
        return solveQ(A, B);
    }

    // finding peak element
    public int solve1(int[] A, int B) {

        int N = A.length;
        int l = 0, h = N - 1, mid = 0, midx = 0, ans = -1;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                midx = mid;
                if (A[mid] == B) {
                    return mid;
                }
                break;
            } else if (A[mid] > A[mid - 1]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        ans = leftBitonicArray(A, B, 0, midx - 1);
        if (ans == -1) {
            ans = rightBitonicArray(A, B, midx + 1, N - 1);
        }
        return ans;

    }

    /// ///////////////////////////////////////////////////////////////////////////////
    // finding the element in left Bitonic Array
    public int leftBitonicArray(int[] A, int B, int l, int h) {
        int mid = 0;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] > B) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // finding the element in the right Bitonic array
    public int rightBitonicArray(int[] A, int B, int l, int h) {
        int mid = 0;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] > B) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }

    /// /////////////////////////////////////////////////////////////////////////

    public int solve3(int[] A, int B) {
        int n = A.length;

        int bitonicIndex = getBitonicIndex(A);

        if (A[bitonicIndex] == B) { // if bitonicIndex == B then return bitonicIndex
            return bitonicIndex;
        }

        if (B > A[bitonicIndex]) { // if the Bth element is greater then all the array elements then rturn -1
            return -1;
        }

        // after finding the peak element first search element from 0 to bitonicIndex - 1 which elements are in assending order
        int l = 0, r = bitonicIndex - 1;
        while (l <= r) {
            int m = (r + l) / 2;
            if (A[m] == B) {
                return m;
            } else if (A[m] < B) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        // if we not got the Bth element then search  from bitonicIndex + 1 to n-1 which elements are in decending order
        l = bitonicIndex + 1;
        r = n - 1;
        while (l <= r) {
            int m = (r + l) / 2;
            if (A[m] == B) {
                return m;
            } else if (A[m] > B) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    // find the bitonic Index which is the peak element of the array
    public static int getBitonicIndex(int[] A) {

        int n = A.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = (r + l) / 2;
            if (A[m] > A[m - 1] && A[m] > A[m + 1]) {
                return m;
            } else if (A[m] > A[m - 1] && A[m] < A[m + 1]) {
                l = m;
            } else {
                r = m;
            }
        }

        return 0;
    }

    public int searchBitonic(int[] arr, int target) {
        int n = arr.length;
        int peak = findPeak(arr);

        // Search in increasing part
        int idx = binarySearchInc(arr, 0, peak, target);
        if (idx != -1) return idx;

        // Search in decreasing part
        return binarySearchDec(arr, peak + 1, n - 1, target);
    }

    private int findPeak(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // peak index
    }

    private int binarySearchInc(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private int binarySearchDec(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
