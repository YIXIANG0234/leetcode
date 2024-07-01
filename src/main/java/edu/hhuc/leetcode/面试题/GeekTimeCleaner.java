package edu.hhuc.leetcode.面试题;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @ClassName GeekTimeCleaner
 * @description:
 * @author: gaoya
 * @create: 2024-05-07 00:02
 * @Version 1.0
 */
public class GeekTimeCleaner {
    public static void main(String[] args) {
        String basePath = "D:\\download\\BaiduNetdiskDownload\\专栏\\192-说透芯片";
        File root = new File(basePath);
        File[] files = root.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
                iterator(file, 1);
            }
        }
    }

    public static void iterator(File file, int level) {
        File[] subFiles = file.listFiles();
        Map<String, List<File>> fileMapping = new HashMap<>();
        for (File doc : subFiles) {
            if (doc.isFile()) {
                String fileName = doc.getName().substring(0, doc.getName().indexOf("."));
                System.out.println(join("\t", level) + doc.getName());
            } else {
                System.out.println(join("\t", level) + doc.getName());
                iterator(doc, level + 1);
            }
        }
    }

    private static String join(String text, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(text);
        }
        return sb.toString();
    }
}
