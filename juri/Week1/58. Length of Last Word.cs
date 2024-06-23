public class Solution {
    public int LengthOfLastWord(string s) {
        string[] arr = s.Trim().Split();
        return arr[arr.Length - 1].Length;
    }
}