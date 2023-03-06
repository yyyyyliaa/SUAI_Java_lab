package Dop4;

import java.util.*;

public class SortedIntegerList {
    private final boolean possibilityDuplicates;
    private final ArrayList<Integer> data;

    public SortedIntegerList(boolean possibilityDuplicates){
        this.possibilityDuplicates = possibilityDuplicates;
        this.data = new ArrayList<Integer>();
    }

    public int binarySearch(int element, int left, int right) {
        if (left == right) {
            if(data.get(left) == element) return left;
            else return -1;
        }

        int middle = left + (right - left) / 2;

        if (element > data.get(middle)) {
            return binarySearch(element, middle + 1, right);
        } else if (data.get(middle) > element) {
            return binarySearch(element, left, middle - 1);
        }
        return middle;
    }

    public int find(int element){
        return binarySearch(element, 0, data.size()-1);
    }
    public void add(int number){
        ListIterator<Integer> it = data.listIterator();
        while (it.hasNext()) {
            Integer cur = it.next();
            if (cur > number) {
                it.previous();
                it.add(number);
                return;
            }
            if (cur == number && !possibilityDuplicates) return;
        }
        it.add(number);
    }

    public void remove(int number){

        this.data.remove(number);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (obj == this) return true;

        if (!(obj instanceof SortedIntegerList)) return false;


        SortedIntegerList tmp = (SortedIntegerList) obj;

        if (this.data.size() != tmp.data.size()) return false;

        ListIterator<Integer> iteratorThis = this.data.listIterator();
        ListIterator<Integer> iteratorTmp = tmp.data.listIterator();

        while (iteratorThis.hasNext()) {
            if (!(iteratorThis.next().equals(iteratorTmp.next()))) return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (Integer i : data) {
            sb.append(i);
            sb.append(", ");
        }

        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]");
        return sb.toString();

    }
}