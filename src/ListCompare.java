//package ru.labs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListCompare {

    private static final int OPERATIONS_COUNT = 200000;
    private static final String TABLE_ROW_FORMAT = "|%-10s|%-20s|%-15s|%-15s|%-30s|\n";
    private static final String TABLE_SEPARATOR_INTER = "|" + "-".repeat(10) + "|" + "-".repeat(20) + "|" + "-".repeat(15) + "|" + "-".repeat(15) + "|" + "-".repeat(30) + "|";
    private static final String TABLE_SEPARATOR_EDGE = "|" + "-".repeat(94) + "|";

    private static long addWithTimer(List<Integer> list, int operationsNumber) {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsNumber; i++) {
            list.add(i);
        }

        return System.currentTimeMillis() - startTime;
    }

    private static long getWithTimer(List<Integer> list) {
        Random random = new Random();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int randomIndex = random.nextInt(list.size());
            list.get(randomIndex);
        }

        return System.currentTimeMillis() - startTime;
    }

    private static long deleteWithTimer(List<Integer> list) {

        Random random = new Random();
        long startTime = System.currentTimeMillis();

        while (list.size() > 0) {
            int randomIndex = random.nextInt(list.size());
            list.remove(randomIndex);
        }

        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long addTimeArrayList = addWithTimer(arrayList,  OPERATIONS_COUNT);
        long addTimeLinkedList = addWithTimer(linkedList, OPERATIONS_COUNT);

        long getTimeArrayList = getWithTimer(arrayList);
        long getTimeLinkedList = getWithTimer(linkedList);

        long deleteTimeArrayList = deleteWithTimer(arrayList);
        long deleteTimeLinkedList = deleteWithTimer(linkedList);

        System.out.println(TABLE_SEPARATOR_EDGE);
        System.out.format(TABLE_ROW_FORMAT, "Method", "Operations number", "ArrayList(ms)", "LinkedList(ms)", "Ratio(LinkedList/ArrayList)");
        System.out.println(TABLE_SEPARATOR_INTER);
        System.out.format(TABLE_ROW_FORMAT, "add", OPERATIONS_COUNT, addTimeArrayList, addTimeLinkedList, (float) addTimeLinkedList / addTimeArrayList);
        System.out.format(TABLE_ROW_FORMAT, "get", OPERATIONS_COUNT, getTimeArrayList, getTimeLinkedList, (float) getTimeLinkedList / getTimeArrayList);
        System.out.format(TABLE_ROW_FORMAT, "delete", OPERATIONS_COUNT, deleteTimeArrayList, deleteTimeLinkedList, (float) deleteTimeLinkedList / deleteTimeArrayList);
        System.out.println(TABLE_SEPARATOR_EDGE);
    }
}

