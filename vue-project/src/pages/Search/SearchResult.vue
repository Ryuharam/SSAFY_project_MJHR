<template>
  <h1>검색 결과</h1>
  <div class="book-list">
    <BookList :results="results" />
  </div>
</template>

<script setup>
import BookList from '../Book/BookList.vue';
import { computed, onMounted } from 'vue';
import { useSearchStore } from '@/stores/searchStore';

const store = useSearchStore();

const results = computed(() => store.results);

onMounted(() => {
  store.getSearchResult();
})

</script>

<style scoped>
.book-list {
  display: flex;
  justify-content: center;
}
</style>
