package request_api;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookResponse {

    @JsonProperty("items")
    private List<BookItem> items;

    public List<BookItem> getItems() {
        return items;
    }

    public void setItems(List<BookItem> items) {
        this.items = items;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BookItem {
    	private String isbn;
        private String title;
        private String author;
        private String publisher;
        private String image;
        private String pubdate;
        
        public Date getPubdateAsDate() {
            if (pubdate == null || pubdate.isEmpty()) {
                return null;
            }
            try {
                // "yyyyMMdd" 형식에서 "yyyy-MM-dd"로 변환
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMdd");
                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

                java.util.Date parsedDate = inputFormat.parse(pubdate);
                String formattedDate = outputFormat.format(parsedDate);

                // java.sql.Date로 변환하여 반환
                return Date.valueOf(formattedDate);
            } catch (ParseException e) {
                throw new RuntimeException("출판일 변환 중 오류 발생: " + pubdate, e);
            }
        }

        // Getters and Setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		@Override
		public String toString() {
			return "BookItem [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
					+ ", image=" + image + ", pubdate=" + pubdate + "]";
		}
        
        

        
        
    }
}
