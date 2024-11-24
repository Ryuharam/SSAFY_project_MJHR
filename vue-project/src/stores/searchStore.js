import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

const BASE_API_URL = `http://localhost:8080/`;

export const useSearchStore = defineStore("result", () => {
  const searchCondition = ref({
    key: "",        // 검색 필터
    word: "",       // 검색어
    orderBy: "",    // 정렬 기준
    orderDir: "ASC",   // 정렬 방향
    offset: 0,      // 페이징 시작 지점
    size: 100,       // 페이징 크기
  });

  const results = ref([]);
  const loading = ref(false);
  const error = ref(null);

  // 책 검색 요청
  const fetchBookResults = async () => {
    loading.value = true;
    error.value = null;

    try {

      const { key, word, orderBy, orderDir, offset, size } = searchCondition.value;

      // 필수 파라미터 검증
      if (!key || !word) {
        throw new Error("검색 조건(key 또는 word)이 설정되지 않았습니다.");
      }

      const response = await axios.get(`${BASE_API_URL}book/search`, {
        params: {
          key: searchCondition.value.key||"title",
          word: searchCondition.value.word,
          orderBy: searchCondition.value.orderBy||"title",
          orderDir: searchCondition.value.orderDir||"ASC",
          offset: searchCondition.value.offset,
          size: searchCondition.value.size,
        },
      });
      results.value = response.data.data;
      console.log("책 검색 결과:", response.data.data);

    } catch (err) {
      console.error("책 검색 요청 실패:", err);
      error.value = err;
    } finally {
      loading.value = false;
    }
  };


  return {
    searchCondition,
    results,
    loading,
    error,
    fetchBookResults,
    fetchReviewResults,
  };
});
