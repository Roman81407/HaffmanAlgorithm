package ru.penzgtu.haffmanAlgorithm.dataStruct;

import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Tree> arrayList;

    public PriorityQueue() {
        arrayList = new ArrayList<>(1);
    }

    public void insert(Tree tree) {
        int i = 0;
        arrayList.add(tree);
        while (i < arrayList.size() && tree.getRoot().getFreq() > arrayList.get(i).getRoot().getFreq()) {
            i++;
        }

        int j = arrayList.size() - 1;
        while (j > i) {
            arrayList.set(j, arrayList.get(j - 1));
            j--;
        }
        arrayList.set(i, tree);
    }

    public int getSize() {
        return arrayList.size();
    }

    public Tree getTree(int i) {
        return arrayList.get(i);
    }

    public void removeTrees() {
        arrayList.remove(0);
        arrayList.remove(0);
    }
}
