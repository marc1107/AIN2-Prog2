package aufgabe7;

public class HybridQS {
    private static final int n = 100;

    public static <T extends Comparable<T>> void hybridQuickSort(T[] a) {
        int li = 0;
        int re = a.length - 1;
        if (a.length > n) {
            hybridQuickSortMedian(a, li, re);
        } else {
            insertionSort(a, li, re);
        }
    }

    public static <T extends Comparable<T>> void hybridQuickSortMedian(T[] a) {
        int li = 0;
        int re = a.length - 1;
        if (a.length > n) {
            hybridQuickSortMedian(a, li, re);
        } else {
            insertionSort(a, li, re);
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a, int li, int re) {
        for (int i = li + 1; i < re + 1; i++) { // Evtl. Fehler?
            T v = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(v) > 0) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = v;
        }
    }

    public static <T extends Comparable<T>> void hybridQuickSort(T[] a, int li, int re) {
        if (re - li > n) {
            if (li < re) {
                int pivot = partition(a, li, re);
                hybridQuickSort(a, li, pivot - 1);
                hybridQuickSort(a, pivot + 1, re);
            }
        } else {
            insertionSort(a, li, re);
        }
    }

    public static <T extends Comparable<T>> void hybridQuickSortMedian(T[] a, int li, int re) {
        if (re - li > n) {
            if (li < re) {
                int pivot = partitionMedian(a, li, re);
                hybridQuickSortMedian(a, li, pivot - 1);
                hybridQuickSortMedian(a, pivot + 1, re);
            }
        } else {
            insertionSort(a, li, re);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] a, int li, int re) {
        T pivot = a[re];

        int i = li - 1;

        for (int j = li; j < re; j++) {
            if (!(a[j].compareTo(pivot) > 0)) { // if (a[j] <= pivot)
                i++;
                T tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        T tmp = a[i + 1];
        a[i + 1] = a[re];
        a[re] = tmp;
        return (i + 1);
    }

    private static <T extends Comparable<T>> int partitionMedian(T[] a, int li, int re) {
        T pivot;
        if (a[li].compareTo(a[re]) <= 0 && a[li].compareTo(a[re/2]) >= 0)
            pivot = a[li];
        else if (a[re].compareTo(a[li]) <= 0 && a[re].compareTo(a[re/2]) >= 0)
            pivot = a[re];
        else
            pivot = a[re/2];

        int i = li - 1;

        for (int j = li; j < re; j++) {
            if (!(a[j].compareTo(pivot) > 0)) { // if (a[j] <= pivot)
                i++;
                T tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        T tmp = a[i + 1];
        a[i + 1] = a[re];
        a[re] = tmp;
        return (i + 1);
    }
}
