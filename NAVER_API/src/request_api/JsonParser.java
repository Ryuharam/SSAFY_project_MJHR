package request_api;
import com.fasterxml.jackson.databind.ObjectMapper;

import request_api.BookResponse.BookItem;

import java.util.List;

public class JsonParser {

    public static List<BookResponse.BookItem> parseJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            BookResponse response = mapper.readValue(json, BookResponse.class);
            return response.getItems();
        } catch (Exception e) {
            throw new RuntimeException("JSON 파싱 중 오류 발생", e);
        }
    }
}
