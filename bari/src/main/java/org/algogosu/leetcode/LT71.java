package org.algogosu.leetcode;

import java.util.Stack;

// Simplify Path
public class LT71 {
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();

        // 스택에 경로 저장
        for (String s : arr) {
            // 빈 문자열이거나 현재 경로면 무시
            if (s.isEmpty() || s.equals(".")) {
                continue;
            }
            // 상위 경로로 이동
            else if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
                continue;
            }
            // 경로 추가
            else {
                st.push(s);
            }
        }

        // 결과 path 만들기
        while (!st.isEmpty()) {
            result.insert(0, "/" + st.pop());
        }

        // 결과가 없으면 "/" 리턴
        if (result.isEmpty()) {
            result = new StringBuilder("/");
        }

        return result.toString();
    }
}