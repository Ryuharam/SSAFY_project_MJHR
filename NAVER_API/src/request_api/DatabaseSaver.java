package request_api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import request_api.BookResponse.BookItem;

public class DatabaseSaver {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/mjhr_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "ssafy";

	public static void saveBooks(List<BookResponse.BookItem> books) {
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String checkSql = "SELECT COUNT(*) FROM books WHERE isbn = ?";
			String sql = "INSERT INTO books (isbn, title, author,publisher,image, pubdate ) VALUES (?, ?, ?, ?, ?,?)";

			for (BookResponse.BookItem book : books) {

				// 중복 여부 확인
				if (isBookAlreadyExists(conn, checkSql, book.getIsbn())) {
					continue; // 중복된 경우 건너뜀
				}

				try (PreparedStatement stmt = conn.prepareStatement(sql)) {
					stmt.setString(1, book.getIsbn());
					stmt.setString(2, book.getTitle());
					stmt.setString(3, book.getAuthor());
					stmt.setString(4, book.getPublisher());
					stmt.setString(5, book.getImage());
					stmt.setDate(6, book.getPubdateAsDate());

					stmt.executeUpdate();
				}
			}

			System.out.println("데이터 저장 완료");
		} catch (Exception e) {
			throw new RuntimeException("데이터 저장 중 오류 발생", e);
		}
	}

	// 중복 여부 확인 메서드
	private static boolean isBookAlreadyExists(Connection conn, String sql, String isbn) {
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, isbn);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1) > 0; // 존재하면 true 반환
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("중복 체크 중 오류 발생", e);
		}
		return false;
	}

}
