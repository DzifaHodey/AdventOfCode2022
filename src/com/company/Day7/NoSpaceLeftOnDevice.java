package com.company.Day7;

import com.company.common.InputReader;
import com.company.common.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NoSpaceLeftOnDevice {

    private static final long TOTAL_DISK_SPACE = 70000000;
    private static final long TOTAL_SPACE_REQUIRED = 30000000;

    public static Node findChildren(List<String> commands, AtomicInteger index) {
        Map<String, Node> children = new HashMap<>();
        for (; index.get() < commands.size(); index.incrementAndGet()) {
            String[] s = commands.get(index.get()).split(" ");
            System.out.println("Line " + (index.get() + 1) + ": " + Arrays.toString(s));
            if ("$".equals(s[0])) {
                if ("cd".equals(s[1])) {
                    String folder = s[2];
                    System.out.println("Folder: " + folder);
                    if ("..".equals(folder)) break;
                    index.incrementAndGet();
                    children.put(folder, findChildren(commands, index));
                }
            } else if ("dir".equals(s[0])) {
                String folder = s[1];
                children.put(folder, new Node<Long>(0L, new HashMap<>()));
            } else {
                Long size = Long.parseLong(s[0]);
                System.out.println("Filename: " + s[1] + ", size: " + size);
                children.put(s[1], new Node<Long>(size, new HashMap<>()));
            }
        }
        return new Node<Long>(children.values().stream().mapToLong(node -> (Long) node.getData()).sum(), children);
    }

    public static long getTotalDirectorySizeOfSpecified(Node<Long> parent) {
        long totalSize = 0;
        for (Object n : parent.getChildren().values()) {
            Node<Long> node = (Node<Long>) n;
            if (!node.getChildren().isEmpty() && node.getData() <= 100000) {
                totalSize += node.getData();
            }
            totalSize += getTotalDirectorySizeOfSpecified(node);
        }
        return totalSize;
    }

    public static long getSmallestDirectoryToDelete(Node<Long> parent) {
        long freeSpace = TOTAL_DISK_SPACE - parent.getData();
        long requiredSpace = TOTAL_SPACE_REQUIRED - freeSpace;
        long min = (Long) parent.getData();
        return getMinSize(parent, requiredSpace, min);
    }

    public static long getMinSize(Node<Long> parent, long requiredSpace, long min){
        for (Object n : parent.getChildren().values()) {
            Node<Long> node = (Node<Long>) n;
            if (!node.getChildren().isEmpty() && node.getData() >= requiredSpace) {
                min = Math.min(node.getData(), min);
            }
            min = getMinSize(node, requiredSpace, min);
        }
        return min;
    }


    public static void main(String[] args) {
        List<String> commands = InputReader.read("src/com/company/Day7/terminal.txt");
        Node node = findChildren(commands, new AtomicInteger(0));
        System.out.println(node.getData());
        System.out.println(getTotalDirectorySizeOfSpecified(node));       // PART 1
        System.out.println(getSmallestDirectoryToDelete(node));     // PART 2

    }
}
