<template>
  <h3>3. Home.vue</h3>
  <hr>
  <div>
    <h1>추천 도서</h1>
    <div class="book-list">
      <BookList :results="results" />
    </div>
  </div>
</template>

<script setup>
import BookList from '../Book/BookList.vue';
import { useBookStore } from '@/stores/bookStore';
import { computed, onMounted } from 'vue';

// Pinia 스토어 사용
const store = useBookStore();

// `results`를 `store.bookList`에 반응형으로 연결
const results = computed(() => store.bookList);

// 컴포넌트 마운트 시 데이터 요청
onMounted(() => {
  store.getBookList();
});
</script>

<style scoped>
.book-list {
  border: 1px black solid;
}
</style>
