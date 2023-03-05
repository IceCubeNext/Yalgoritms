import java.io.*;
import java.util.ArrayList;

class Heap {

    public void heap() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStream out = new BufferedOutputStream(System.out);
        MyHeap heap = new MyHeap();
        int steps = Integer.parseInt(br.readLine());
        int value = 0;
        for (int i = 0; i < steps; i++) {
            String[] input = br.readLine().trim().split(" ");
            if (input.length > 1) {
                value = Integer.parseInt(input[1]);
            }
            String command = input[0];
            switch (command) {
                case "1":
                    out.write((heap.get() + "\n").getBytes());
                    out.flush();
                    break;
                case "0":
                    heap.add(value);
                    break;
            }
        }
    }
}

class MyHeap {
    private ArrayList<Integer> heapArray = new ArrayList<>();
    public void add(int value) {
        heapArray.add(value);
        int i = heapArray.size() - 1;
        int parent = (i - 1) / 2;
        while (i > 0 && heapArray.get(i) > heapArray.get(parent)) {
            int temp = heapArray.get(parent);
            heapArray.set(parent, heapArray.get(i));
            heapArray.set(i, temp);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public int get() {
        int result = heapArray.get(0);
        heapArray.set(0, heapArray.get(heapArray.size() - 1));
        heapArray.remove(heapArray.size() - 1);
        heapify(0);
        return result;
    }

    private void heapify(int i) {
        int leftChild;
        int rightChild;
        int largestChild;
        while (true) {
        leftChild = 2 * i + 1;
        rightChild = 2 * i + 2;
        largestChild = i;
            if (leftChild < heapArray.size() && heapArray.get(largestChild) < heapArray.get(leftChild)) {
                largestChild = leftChild;
            }
            if (rightChild < heapArray.size() && heapArray.get(largestChild) < heapArray.get(rightChild)) {
                largestChild = rightChild;
            }
            if (largestChild == i) {
                break;
            }
            int temp = heapArray.get(i);
            heapArray.set(i, heapArray.get(largestChild));
            heapArray.set(largestChild, temp);
            i = largestChild;
        }
    }
}
