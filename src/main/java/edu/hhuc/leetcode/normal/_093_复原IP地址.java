package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @ClassName _093_复原IP地址
 * @description:
 * @author: gaoya
 * @create: 2023-01-05 16:07
 * @Version 1.0
 */
public class _093_复原IP地址 {
    private List<String> result = new ArrayList<>();
    private final int segment_count = 4;
    private String[] segments = new String[segment_count];

    public static void main(String[] args) {
        String input = "19216811";
        _093_复原IP地址 instance = new _093_复原IP地址();
        instance.solution1(input);
        System.out.println(instance.result);
    }

    public List<String> solution1(String s) {
        dfs(s, 0, 0);
        return result;
    }

    /**
     * @param input   输入的字符串
     * @param segment 正在处理的第segment ip
     * @param index   当前处理到input字符串的哪个位置了
     */
    public void dfs(String input, int segment, int index) {

        if (segment == segment_count) {
            if (index == input.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < segment_count; i++) {
                    sb.append(segments[i]);
                    if (i != segment_count - 1) {
                        sb.append(".");
                    }
                }
                result.add(sb.toString());
            }
            return;
        }
        if (index == input.length()) {
            return;
        }
        if (input.charAt(index) == '0') {
            segments[segment] = "0";
            dfs(input, segment + 1, index + 1);
            return;
        }
        for (int i = index; i < input.length(); i++) {
            String s = input.substring(index, i+1);
            // 0xFF = 255
            if (Integer.parseInt(s) >0 && Integer.parseInt(s) <= 0xFF) {
                segments[segment] = s;
                dfs(input, segment + 1, i + 1);
            } else {
                break;
            }
        }

    }
}
