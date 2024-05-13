package edu.hhuc.leetcode.面试题;

import java.io.File;

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
        String basePath = "D:\\download\\BaiduNetdiskDownload\\专栏";
        File root = new File(basePath);
        File[] files = root.listFiles();
        for (File file:files) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
                iterator(file);
            }
        }
    }

    public static void iterator(File file) {
        File[] subFiles = file.listFiles();
        for (File doc:subFiles) {
            if (doc.isFile()) {
                System.out.println("\t"+doc.getName());
            }
        }
    }
}
