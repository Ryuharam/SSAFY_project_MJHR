<template>
  <nav>
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

    <div>
      <div v-if="route.params.category == 'book'">
        <BookList :results="result" />
        <!-- <ul>
          <li v-for="(result, index) in store.results" :key="index">
            {{ result.title }}
          </li>
        </ul> -->
      </div>
      <div v-if="route.params.category == 'review'">
        <ul>
          <li v-for="(result, index) in store.results" :key="index">
            {{ result.reviewTitle }}
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, watch } from "vue";
import { useSearchStore } from "@/stores/searchStore";
import { useRoute } from "vue-router";
import BookList from "@/pages/Book/BookList.vue"

const props = defineProps({
  category: String,
  word: String,
});

const store = useSearchStore();
const route = useRoute();

const category = ref(route.params.category);
const result = ref([])

// 검색 결과를 가져오는 함수
const fetchResults = async () => {
  const word = route.query.word;
  if (!word) {
    store.error = "검색어가 제공되지 않았습니다.";
    store.results = [];
    return;
  }

  // 검색 조건 설정
  store.searchCondition.word = word;
  store.searchCondition.category = category.value;

  if (category.value === "book") {
    store.searchCondition.key = "title";
    store.searchCondition.orderBy = "title";
  } else if (category.value === "review") {
    store.searchCondition.key = "review_title";
    store.searchCondition.orderBy = "review_title";
  }

  try {
    store.loading = true;
    await store.getSearchResults();
    result.value = store.results
  } catch (error) {
    store.error = "검색 중 오류가 발생했습니다.";
  } finally {
    store.loading = false;
  }
};

// 컴포넌트가 마운트될 때와 라우트 변경 시 검색 실행
onMounted(fetchResults);
watch(
  () => [route.params.category, route.query.word],
  ([newCategory]) => {
    category.value = newCategory;
    fetchResults();
  }
);
</script>

<style scoped></style>
