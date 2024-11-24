<template>
  <nav>
    <button @click="showBookList">책 검색</button>
    |
    <button @click="showReviewList">리뷰 검색</button>
  </nav>

  <div>
    <h3>검색 결과</h3>
    <!-- 로딩 상태 표시 -->
    <div v-if="store.loading">검색 중입니다...</div>
    <!-- 검색 결과 표시 -->
    <component v-else :is="activeComponent" :results="store.results?.data || []"  />
    </div>
</template>

<script setup>
import { shallowRef, watch, onMounted } from "vue";
import { useSearchStore } from "@/stores/searchStore";
import BookList from "@/pages/Book/BookList.vue";
import ReviewList from "@/pages/Review/ReviewList.vue";

const activeComponent = shallowRef(BookList);
const store = useSearchStore();

const props = defineProps({
  category: String, // category를 명시적으로 선언
});

// props.category에 따라 초기값 설정
watch(
  () => props.category,
  (newCategory) => {
    if (newCategory === "book") {
      activeComponent.value = BookList;
    } else if (newCategory === "review") {
      activeComponent.value = ReviewList;
    }
  },
  { immediate: true }
);


const showBookList = async () => {
  activeComponent.value = BookList;
  store.searchCondition.key = "title";
  store.searchCondition.offset = 0; // 첫 페이지
  store.searchCondition.size = 100; // 페이지 크기
  await store.fetchBookResults();
};

// 리뷰 검색 요청
const showReviewList = async () => {
  activeComponent.value = ReviewList;
  store.searchCondition.key = "review_title";
  store.searchCondition.orderBy = "review_title";
  store.searchCondition.offset = 0; // 첫 페이지
  store.searchCondition.size = 100; // 페이지 크기
  await store.fetchReviewResults();
  console.log("부모",store.results)
};

// 컴포넌트가 마운트되었을 때 기본적으로 책 검색 결과를 가져오도록 설정
onMounted(() => {
  showBookList(); // 초기 책 검색 결과 호출
});

watch(
  () => store.results,
  (newResults) => {
    console.log("Store results updated:", newResults);
  }
)
</script>

<style scoped></style>
