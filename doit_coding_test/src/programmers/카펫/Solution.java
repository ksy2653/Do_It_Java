package programmers.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        for (int col = 1; col <= Math.sqrt(yellow); col++) {
            if (yellow % col == 0) {
                int row = yellow / col; // 가로
                // 갈색 타일이 노란색 타일을 감싸는 조건 확인
                if (2 * (row + col) + 4 == brown) {
                    return new int[] {row + 2, col + 2}; // 가로, 세로 반환
                }
            }
        }
        return null;
    }
}
