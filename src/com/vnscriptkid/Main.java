package com.vnscriptkid;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void linkedlist() {
        LinkedList list = new LinkedList();
        System.out.println(Arrays.toString(list.toArray()));
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        // 1, 2, 3, 4
        int threeAwayEnd = list.getKthFromTheEnd(3);
        System.out.println("3 steps from end: " + threeAwayEnd);
        System.out.println(Arrays.toString(list.toArray()));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("index of 3: " + list.indexOf(3));
        System.out.println("contains 2: " + list.contains(2));
        System.out.println("contains 5: " + list.contains(5));
        list.deleteFirst();
        list.deleteLast();
        System.out.println("after delete first and last: ");
        list.print();
        System.out.println("count now: " + list.size());
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void expressionEvaluation() {
        boolean shouldTrue = BalancedExpression.check("{([thanh]<cool>)[boy]}");
        boolean shouldFalse = BalancedExpression.check("([thanh]<cool>)[boy}");
        System.out.println("shouldTrue: " + shouldTrue);
        System.out.println("shouldFalse: " + shouldFalse);
    }

    public static void reverseString() {
        String result = ReverseStringUsingStack.reverse("thanh");
        System.out.println(result);
    }

    public static void stackImplementation() {
        Stack stack = new Stack();
        System.out.println("is empty: " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.print();
        System.out.println("top now: " + stack.peek());
        stack.pop();
        System.out.println("pop one, top now: " + stack.peek());
        System.out.println("is empty: " + stack.isEmpty());
        stack.pop();
        stack.pop();
        System.out.println("is empty: " + stack.isEmpty());
    }

    public static void buildQueueUsingArray() {
        MyArrayDeque queue = new MyArrayDeque();
        System.out.println("is empty: " + queue.isEmpty());
        System.out.println("is full: " + queue.isFull());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        // 3 4 6
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(5);
        queue.enqueue(6); // 5 -> 0
        queue.enqueue(7); // 6 -> 1
        System.out.println(queue.size());
        System.out.println(queue);
    }

    public static void reverseAQueue() {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.addAll(List.of(1,2,3));
        System.out.println(queue);
        ReverseQueue.reverse(queue);
        System.out.println(queue);
    }

    public static void queueUsingStack() {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue.peek());
        queue.enqueue(4);
        queue.dequeue();
        System.out.println(queue.peek());
    }

    public static void usePriorityQueue() {
        PriorityQueue queue = new PriorityQueue(20);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(1);
        queue.enqueue(10);
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }

    public static void useHashMap() {
        System.out.println(FirstNonRepeatedChar.findInString("nguyen trung thanh"));
        System.out.println(FirstNonRepeatedChar.findInString("i love iphone"));
    }

    public static void useHashSet() {
        System.out.println(FirstRepeatedChar.find("nguyen trung thanh"));
        System.out.println(FirstRepeatedChar.find("he like running"));
    }

    public static void hashTableUsingChaining() {
        HashTable hashTable = new HashTable();
        hashTable.put(2, "thanh");
        hashTable.put(12, "link");
        hashTable.put(3, "phuong");
        hashTable.put(4, "nghi");
        hashTable.put(5, "bich");
        hashTable.put(22, "hi");
        System.out.println(hashTable);
        hashTable.put(12, "update 12");
        // 2-"thanh" 12-"update 12" 22-"hi"
        hashTable.remove(12);
        System.out.println(hashTable.get(12));
        System.out.println(hashTable.get(22));
        hashTable.remove(5);
    }

    public static void useBinaryTree() {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(9);
        tree.insert(6);
        tree.insert(10);
        tree.insert(3);
        tree.insert(4);
        System.out.println(tree.kDistanceFromRoot(2));
        tree.traverseLevelOrder();
        System.out.println();
        System.out.println(tree.height());;
        System.out.println(tree.minValue());
        System.out.println(tree.minValueFast());
        BinaryTree another = new BinaryTree();
        another.insert(5);
        another.insert(2);
        another.insert(9);
        another.insert(6);
        another.insert(10);
        another.insert(3);
        System.out.println(tree.equals(another));
        System.out.println(tree.isBinaryTree());
        tree.swapRoot();
        System.out.println(tree.isBinaryTree());
    }

    public static void useFactorial() {
        System.out.println(Factorial.usingLoop(4));
        System.out.println(Factorial.usingRecursion(4));
    }

    public static void useHeap() {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        heap.remove();
        System.out.println(heap);
    }

    public static void heapSort() {
        int[] arr = {5,2,3,8,6,7,17,12};
        Heap heap = new Heap();
        for (int i : arr) {
            heap.insert(i);
        }
        int[] sortedArr = new int[arr.length];
        for (int i = 0; i < sortedArr.length; i++) {
            sortedArr[i] = heap.remove();
        }
        System.out.println(Arrays.toString(sortedArr));
    }

    public static void usingHeapify() {
        int[] arr = {5,2,3,8,6,7,17,12};
        Heap heap = new Heap();
        heap.heapify(arr);
        System.out.println(heap);
    }

    public static void kLargestOfArray(int [] arr, int k) {
        Heap heap = new Heap();
        for (int i : arr) {
            heap.insert(i);
        }
        int[] kLargest = new int[k];
        for (int i = 0; i < k; i++) {
            kLargest[i] = heap.remove();
        }
        System.out.println(Arrays.toString(kLargest));
    }

    public static void useTrie() {
        TrieUsingArray trie = new TrieUsingArray();
        trie.insert("can");
        trie.insert("cat");
        trie.insert("cant");
    }

    public static void trieUsingHashTable() {
        TrieUsingHashTable trie = new TrieUsingHashTable();
        trie.insert("can");
        trie.insert("cat");
        trie.insert("cant");
        System.out.println(trie.contains("canada"));
        System.out.println(trie.contains("can"));
        System.out.println(trie.contains("ca"));
    }

    public static void traverseTrie() {
        TrieUsingHashTable trie = new TrieUsingHashTable();
        trie.insert("car");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("card");
        trie.insert("egg");
        trie.traversePreOrder();
        System.out.println("");
        trie.traversePostOrder();
    }

    public static void deleteWordInTrie() {
        TrieUsingHashTable trie = new TrieUsingHashTable();
        trie.insert("cat");
        trie.insert("cant");
        trie.insert("care");
        trie.delete("care");
        System.out.println(trie.contains("cat"));
        System.out.println(trie.contains("cant"));
        System.out.println(trie.contains("care"));
    }

    public static void autoCompletion() {
        TrieUsingHashTable trie = new TrieUsingHashTable();
        trie.insert("car");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("card");
        trie.insert("egg");
        System.out.println(trie.autoCompletion("car").toString());
    }

    public static void useGraph() {
        Graph graph = new Graph();
        graph.addNode("Thanh");
        graph.addNode("Bich");
        graph.addNode("Cheo");
        graph.addNode("Ahmed");
        graph.addNode("Hien");
        graph.addNode("Dung");
        graph.addEdge("Thanh", "Bich");
        graph.addEdge("Thanh", "Cheo");
        graph.addEdge("Dung", "Thanh");
        graph.removeEdge("Dung", "Thanh");
        graph.addEdge("Ahmed", "Thanh");
        graph.print();
    }

    public static void graphDFS() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");
        graph.depthFirstSearch("A");
        graph.dfsUsingStack("A");
    }

    public static void graphBFS() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");
        graph.bfsUsingQueue("A");
    }

    public static void useTopologicalSorting() {
        Graph graph = new Graph();
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        graph.addEdge("X", "A");
        graph.addEdge("X", "B");
        graph.addEdge("A", "P");
        graph.addEdge("B", "P");
        graph.topologicalSorting();
    }

    public static void graphCycleDetection() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "C");
        graph.addEdge("D", "A");
        System.out.println("Has cycle: " + graph.cycleDetection());;
    }

    public static void useWeightedGraph() {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "D", 6);
        graph.addEdge("C", "D", 1);
        graph.addEdge("A", "C", 4);
        graph.addEdge("A", "D", 2);
        graph.print();
    }
    
    public static void useWeightedGraphOOP() {
        WeightedGraphOOP graph = new WeightedGraphOOP();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "D", 6);
        graph.addEdge("C", "D", 1);
        graph.addEdge("A", "C", 4);
        graph.addEdge("A", "D", 2);
        graph.print();
    }

    public static void useDjikstra() {
        WeightedGraphOOP graph = new WeightedGraphOOP();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "D", 2);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "D", 6);
        graph.addEdge("C", "D", 1);
        graph.addEdge("B", "E", 1);
        graph.addEdge("E", "D", 5);
        graph.dijkstra("A");
    }

    public static void checkUndirectedGraphHasCycle() {
        WeightedGraphOOP graph = new WeightedGraphOOP();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 4);
        System.out.println(graph.hasCycle());
    }

    public static void usePrimAlgorimthm() {
        WeightedGraphOOP graph = new WeightedGraphOOP();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 5);
        graph.prim("A");
    }

    public static void useBubbleSort() {
        int[] numbers = {1,6,2,3,4,9,7,8};
        BubbleSort sorter = new BubbleSort(numbers);
        System.out.println(Arrays.toString(sorter.sort()));
    }

    public static void useSelectionSort() {
        int[] numbers = {1,6,2,3,4,9,7,8};
        System.out.println(Arrays.toString(new SelectionSort().sort(numbers)));
    }

    public static void useInsertionSort() {
        int[] numbers = {1,6,2,3,4,9,7,8};
        System.out.println(Arrays.toString(new InsertionSort().sort(numbers)));
    }

    public static void useMergeSort() {
        int[] numbers = {1,6,2,3,4,9,7};
        MergeSort sorter = new MergeSort(numbers);
        System.out.println(Arrays.toString(sorter.sort()));
    }

    public static void useQuickSort() {
        int[] numbers = {1,25,2,18,4,9,7,8,23,14,19};
        System.out.println(Arrays.toString(new QuickSort().sort(numbers)));
    }

    public static void useCountSort() {
        int[] numbers = {1,25,2,18,4,9,7,8,23,14,19};
        System.out.println(Arrays.toString(new CountSort().sort(numbers)));
    }

    public static void useLinearSearch() {
        int[] numbers = {1,6,2,9,3,5,4};
        System.out.println(new LinearSearch().find(numbers, 3));
        System.out.println(new LinearSearch().find(numbers, 100));
    }

    public static void useBinarySearch() {
        int[] numbers = {1,5,6,8,9,10,15,17};
        System.out.println(new BinarySearch().findUsingRecursion(numbers, 15));
        System.out.println(new BinarySearch().findUsingRecursion(numbers, 5));
        System.out.println(new BinarySearch().findUsingLoop(numbers, 15));
        System.out.println(new BinarySearch().findUsingLoop(numbers, 5));
    }

    public static void useStringUtils() {
        System.out.println(StringUtils.countVowels("nguyEn trung thanh "));
        System.out.println(StringUtils.reverseString("nguyEn trung thanh"));
        System.out.println(StringUtils.reverseWords("I miss her"));
        System.out.println(StringUtils.reverseWordsSecond("I miss her"));
        System.out.println(StringUtils.areRotations("ABC", "CAB"));
        System.out.println(StringUtils.areRotations("ABC", "CBA"));
        System.out.println(StringUtils.areRotations(null, "CBA"));
        System.out.println(StringUtils.removeDuplicates("abcadedf"));
        System.out.println(StringUtils.mostRepeatedChar("nguyentrungthanh"));
        System.out.println(StringUtils.mostRepeatedCharAnotherImpl("nguyentrungthanh"));
        System.out.println(StringUtils.capitalize("  nguyen  trung thanh"));
        System.out.println(StringUtils.capitalizeAnotherImple("  nguyen  trung thanh"));
        System.out.println(StringUtils.capitalizeAnotherImple(" "));
        System.out.println(StringUtils.capitalizeAnotherImple(null));
        System.out.println(StringUtils.areAnagram("ABC", "CBA"));
        System.out.println(StringUtils.areAnagram("ABC", "CBD"));
        System.out.println(StringUtils.areAnagramBetter("ABC", "CBD"));
        System.out.println(StringUtils.areAnagramBetter("ABC", "BAC"));
        System.out.println(StringUtils.isPalindrome("MADAM"));
        System.out.println(StringUtils.isPalindrome("MADAMS"));
        System.out.println(StringUtils.isPalindromeSecond("MADAM"));
        System.out.println(StringUtils.isPalindromeSecond("MADAMS"));
        System.out.println(StringUtils.isPalindromeThird("MADAM"));
        System.out.println(StringUtils.isPalindromeThird("MADAMS"));
    }

    public static void main(String[] args) {
        useStringUtils();
    }
}
