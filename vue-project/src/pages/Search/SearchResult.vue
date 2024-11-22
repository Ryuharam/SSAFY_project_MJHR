<template>
  <nav>
    <RouterLink :to="{ name: 'SearchResult', params: { category: 'all' }, query: { word: route.query.word } }">
      통합 검색
    </RouterLink>
    |
    <RouterLink :to="{ name: 'SearchResult', params: { category: 'book' }, query: { word: route.query.word } }">
      책 검색
    </RouterLink>
    |
    <RouterLink :to="{ name: 'SearchResult', params: { category: 'review' }, query: { word: route.query.word } }">
      리뷰 검색
    </RouterLink>
  </nav>

  <div>
    <h3>검색 결과 - {{ category }}</h3>
    <div v-if="store.loading">검색 중...</div>
    <div v-if="store.error">{{ store.error }}</div>
    <div v-else>
      {{ category }}
      <div v-if="category === 'book'">
        <h4>책 검색 결과</h4>
        <!-- <ul>
          <li v-for="(result, index) in store.results" :key="index">{{ result.title }}</li>
        </ul> -->
      </div>
      <div v-else-if="category === 'review'">
        <h4>리뷰 검색 결과</h4>
        <!-- <ul>
          <li v-for="(result, index) in store.results" :key="index">{{ result.content }}</li>
        </ul> -->
      </div>
      <div v-else>
        <h4>통합 검색 결과</h4>
        <!-- <ul>
          <li v-for="(result, index) in store.results" :key="index">{{ result.title || result.content }}</li>
        </ul> -->
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, watch } from "vue";
import { useSearchStore } from "@/stores/searchStore";
import { useRoute } from "vue-router";

const store = useSearchStore();
const route = useRoute();

// category 및 word 가져오기
const category = ref(route.params.category || "all");
const word = route.query.word;

const fetchResults = () => {
  if (!word) {
    store.error = "검색어가 제공되지 않았습니다.";
    return;
  }

  // 검색 조건 기본 설정
  store.searchCondition.word = word;

  // 카테고리별 검색 조건 설정
  if (category.value === "book") {
    store.searchCondition.category = "book";  // book에 요청
    store.searchCondition.key = "title";      // 제목 기준으로 검색
    store.searchCondition.orderBy = "title";  // 제목 기준으로 정렬
  } else if (category.value === "review") {
    store.searchCondition.category = "review"; // review에 요청
    store.searchCondition.key = "reviewTitle";
    store.searchCondition.orderBy = "reviewTitle";
  } else {
    // 통합 검색
    store.searchCondition.category = "all";
    store.searchCondition.orderBy = ""; // 정렬 기준 없음 (기본값)
  }

  console.log("검색 조건:", store.searchCondition);

  // 검색 요청
  store.getSearchResults();
};


// 초기 로드 및 라우트 변경 시 검색
onMounted(fetchResults);
watch(
  () => [route.params.category, route.query.word],
  () => {
    category.value = route.params.category
    console.log("URL 변경 감지: category =", route.params.category, ", word =", route.query.word);
    fetchResults();
  }
);

</script>

<style scoped></style>
