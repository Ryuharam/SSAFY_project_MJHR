import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

const BASE_API_URL = `http://localhost:8080/book/`;

export const useSearchStore = defineStore("result", () => {

  const results = ref([]);  // 검색 결과

  const word = ref("");     // 검색어
  const key = ref("title");
  const orderBy = ref("title");
  const orderDir = ref("ASC");
  const currentPage = ref(1); // 현재 페이지
  const totalPages = ref(0); // 총 페이지 수
  const totalItems = ref(0); // 총 항목 수
  const pageSize = ref(100); // 페이지 크기 (기본값 100)

  const getSearchResult = async (page = 1, size = 100) => {
    try {
      console.log('📡 요청 보내는 중:', { page, size });
      console.log(`${BASE_API_URL}search`)
      const response = await axios.get(`${BASE_API_URL}search`, {
        params: {
          key: key.value,
          word: word.value,
          orderBy: orderBy.value,
          orderDir: orderDir.value,
          page,
          size,
        },
      });
      console.log('✅ 응답 데이터:', response);
      const { data, totalPages: total, totalItems: totalCount } = response.data;

      results.value = data;
      currentPage.value = page;
      totalPages.value = total;
      totalItems.value = totalCount;
      pageSize.value = size;

      console.log('📚 상태 업데이트 완료:', { results: results.value });
    } catch (error) {
      console.error('❌ 도서 목록을 가져오는 데 실패했습니다:', error);
    }
  }

  return {
    key,
    word,
    orderBy,
    orderDir,
    currentPage,
    totalPages,
    totalItems,
    pageSize,
    results,
    getSearchResult,
  };
});
