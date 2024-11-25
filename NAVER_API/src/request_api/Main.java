package request_api;
import java.util.List;

import request_api.BookResponse.BookItem;

public class Main {
    public static void main(String[] args) {
        String query = "토익";
        String jsonResponse = NaverBookApi.getJsonResponse(query);

        if (jsonResponse != null) {
            List<BookResponse.BookItem> books = JsonParser.parseJson(jsonResponse);
            if (books != null && !books.isEmpty()) {
                DatabaseSaver.saveBooks(books);
            } else {
                System.out.println("검색 결과가 없습니다.");
            }
        } else {
            System.out.println("API 요청에 실패했습니다.");
        }
    }
}
