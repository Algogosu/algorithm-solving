import java.util.*;

/*
1. 입력받은 파일 경로를 StringTokenizer를 사용하여 "/"를 기준으로 토큰화하고, 경로를 저장할 스택을 생성합니다.
2. 토큰화된 경로를 순회하면서 빈 문자열과 "."은 무시하고, ".."은 상위 디렉토리로 이동하며, 일반 디렉토리 또는 파일은 스택에 추가합니다.
3. 스택이 비어있는 경우 루트 디렉토리 "/"를 반환하고, 그렇지 않은 경우 스택에 저장된 경로를 순서대로 이어붙여 최종 경로를 생성하여 반환합니다.
*/

class Solution {
   public String simplifyPath(String path) {
       // System.out.println(path);
       // String[] A = path.split("/");
       StringTokenizer st = new StringTokenizer(path, "/");
       // System.out.println(Arrays.toString(A));
       Stack<String> stack = new Stack<>();
       // for (String a : A) {
       while (st.hasMoreTokens()) {
           // System.out.println(stack);
           String a = st.nextToken();
           if (a.equals("")) {
               continue;
           }
           if (a.equals(".")) {
               continue;
           }
           if (a.equals("..")) {
               if (!stack.isEmpty()) {
                   stack.pop();
               }
               continue;
           }
           stack.add(a);
       }
       // System.out.println(stack);
       if (stack.isEmpty()) {
           return "/";
       } else {
           StringBuilder sb = new StringBuilder();
           for (String s : stack) {
               sb.append("/");
               sb.append(s);
           }
           return sb.toString();
       }
   }
}