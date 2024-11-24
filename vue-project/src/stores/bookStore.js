import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

const REST_API_URL = `http://localhost:8080/book`;

export const useBookStore = defineStore('book', () => {
  const bookList = ref([]); // 도서 목록
  const currentPage = ref(1); // 현재 페이지
  const totalPages = ref(0); // 총 페이지 수
  const totalItems = ref(0); // 총 항목 수
  const pageSize = ref(100); // 페이지 크기 (기본값 100)

  // 도서 목록 요청
  const getBookList = async (page = 1, size = 100) => {
    try {
      console.log('📡 요청 보내는 중:', { page, size }); // 요청 로그
      const response = await axios.get(`${REST_API_URL}`, {
        params: {
          page,
          size,
        },
      });

      console.log('✅ 응답 데이터:', response); // 전체 응답 로그
      const { data, totalPages: total, totalItems: totalCount } = response.data;

      bookList.value = data;
      currentPage.value = page;
      totalPages.value = total;
      totalItems.value = totalCount;
      pageSize.value = size;

      console.log('📚 상태 업데이트 완료:', { bookList: bookList.value });
    } catch (error) {
      console.error('❌ 도서 목록을 가져오는 데 실패했습니다:', error);
    }
  };

  const isbn = ref("");
  const book = ref({})

  const getBookDetail = async () => {
    try {
      if (!isbn.value) {
        throw new Error("ISBN is not set");
      }
      const response = await axios.get(`${REST_API_URL}/${isbn.value}`);
      book.value = response.data;
    } catch (error) {
      console.error("Failed to fetch book details:", error);
    }
  }


  return {
    bookList,
    currentPage,
    totalPages,
    totalItems,
    pageSize,
    getBookList,
    isbn,
    book,
    getBookDetail,
  };
});
