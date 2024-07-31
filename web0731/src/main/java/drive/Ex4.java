package drive;

import board.BoardDAO;
import board.BoardDTO;

public class Ex4 {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(4,"하나", "글제목","글내용","", 0);
		dao.updateBoard(dto);
		System.out.println("업데이트 성공");

	}

}
