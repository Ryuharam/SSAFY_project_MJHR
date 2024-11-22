import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

const BASE_API_URL = `http://localhost:8080/`;

export const useSearchStore = defineStore('result', () => {
  const searchCondition = ref({
    category: "book",
    key: "title",
    word: "b",
    orderBy: "title",
    orderDir: "DESC",
  });

  const results = ref([]);
  const loading = ref(false);
  const error = ref(null);

  const getSearchResults = async function () {

    loading.value = true;
    error.value = null;
    try {
      // 동적으로 URL 생성
      const searchUrl = `${BASE_API_URL}${searchCondition.value.category}/search`;

      const response = await axios.get(searchUrl, {
        params: {
          key: searchCondition.value.key,
          word: searchCondition.value.word,
          orderBy: searchCondition.value.orderBy,
          orderDir: searchCondition.value.orderDir,
        },
      });
      results.value = response.data;
      console.log("검색 결과:", response.data);
    } catch (error) {
      console.error("검색 요청 실패:", error);
    } finally {
      loading.value = false;
    }
  };

  return {
    searchCondition,
    getSearchResults,
  };
});
