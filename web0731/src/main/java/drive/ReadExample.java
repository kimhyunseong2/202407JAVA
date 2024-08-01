package drive;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import board.BoardDAO;
import board.BoardDTO;


public class ReadExample {

	public static void main(String[] args) throws IOException {
//		FileReader reader = new FileReader("C:/Temp/test1.txt");
		String line = "";
		BoardDAO dao = new BoardDAO();
		BufferedReader br = new BufferedReader(new FileReader("C:/Temp/board1.csv")); // 보조 스트림
		while ((line = br.readLine())!= null) {
			// CSV 파일의 각 줄을 쉼표로 분리
			String[] data = line.split(", ");
			BoardDTO dto = new BoardDTO(0, data[0], data[1], data[2], null, 0); // cvs파일을 (BoardDTO)객체에 넣는다
			System.out.println(dto);
			
			dao.insertBoard(dto);  //BoardDAO에 insertBoard 이용
			System.out.println("insert 완료!");
			
			// 분리된 데이터 출력
//			for(String element : data) {
//				System.out.println(element + " ");
//			}
//			System.out.println();
		}
		br.close();
	}

}
