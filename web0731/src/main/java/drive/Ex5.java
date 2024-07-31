package drive;

import board.BoardDAO;
import board.BoardDTO;

public class Ex5 {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.deleteBoard(12);
		System.out.println("삭제 성공");

	}

}
