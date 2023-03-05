import java.io.*;
import java.util.ArrayList;

public class PyramidSort {
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            OutputStream out = new BufferedOutputStream(System.out)){
            int count = Integer.parseInt(br.readLine());
            String[] line = br.readLine().trim().split(" ");
            ArrayList<Long> inputArray = new ArrayList<>();
            MHeap heap = new MHeap();
            for (String item: line) {
                inputArray.add(Long.parseLong(item));
            }
            ArrayList<Long> outputArray = heap.getSortArray(inputArray);
            for (int i = outputArray.size(); i > 0; i--) {
                out.write((outputArray.get(i - 1) + " ").getBytes());
            }
            out.flush();
        }
    }

}
class MHeap {
    private ArrayList<Long> heapArray = new ArrayList<>();

    public ArrayList<Long> getSortArray(ArrayList<Long> array) {
        this.heapArray = array;
        for (int i = heapArray.size() / 2; i >= 0; i--) {
            heapify(i);
        }
        ArrayList<Long> output = new ArrayList<>();
        int size = heapArray.size();
        for (int i = 0; i < size; i++) {
            output.add(get());
        }
        return output;
    }

    public void add(long value) {
        heapArray.add(value);
        int i = heapArray.size() - 1;
        int parent = (i - 1) / 2;
        while (i > 0 && heapArray.get(i) > heapArray.get(parent)) {
            long temp = heapArray.get(parent);
            heapArray.set(parent, heapArray.get(i));
            heapArray.set(i, temp);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public long get() {
        long result = heapArray.get(0);
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
            long temp = heapArray.get(i);
            heapArray.set(i, heapArray.get(largestChild));
            heapArray.set(largestChild, temp);
            i = largestChild;
        }
    }
}