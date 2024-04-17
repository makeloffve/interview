package io.cjgu;

import java.util.Random;
import java.util.TreeSet;

public class StudentIdManager {

    private TreeSet<Integer> ids;

    public StudentIdManager() {
        ids = new TreeSet<>();
    }

    public void add(int id) {
        ids.add(id);
    }

    public boolean container(int id) {
        return ids.contains(id);
    }

    public void remove(int id) {
        ids.remove(id);
    }

    public int random() {
        int index = new Random().nextInt(ids.size() - 1);
        return ids.stream().skip(index).limit(1).findFirst().orElse(0);
    }

    public int min() {
        if (ids.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return ids.last();
    }

}
