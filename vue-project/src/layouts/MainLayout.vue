<template>
  <h2>2-1. MainLayout</h2>
  <hr>
  <div class="search">
    <form @submit.prevent="doSearch">
      <input type="text" v-model.trim="word" placeholder="검색어 입력" />
      <button type="submit">검색</button>
    </form>
  </div>
  <hr>
  <RouterView />
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from 'vue-router';
import { useSearchStore } from '@/stores/searchStore';

const store = useSearchStore();
const router = useRouter();
const word = ref("");

// 검색 실행
const doSearch = async () => {
  if (word.value.trim() === "") {
    alert("공백은 입력될 수 없습니다");
    return;
  }
  console.log(word.value)
  store.word = word.value;
  console.log(store.word);
  store.getSearchResult();

  // SearchResult 이동
  router.push({ name: "SearchResult" });
};



</script>

<style scoped></style>
