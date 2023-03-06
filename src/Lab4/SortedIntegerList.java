package Lab4;

import java.util.LinkedList;
import java.util.ListIterator;

public class SortedIntegerList {
    private final boolean possibilityDuplicates;
    private final LinkedList<Integer> data;

    public SortedIntegerList(boolean possibilityDuplicates){
        this.possibilityDuplicates = possibilityDuplicates;
        this.data = new LinkedList<Integer>();
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

        this.data.removeFirstOccurrence(number);
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