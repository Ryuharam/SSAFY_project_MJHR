<template>
  <div>
    <h3>검색 결과</h3>
    <div v-if="store.loading">검색 중...</div>
    <div v-if="store.error">{{ store.error }}</div>

  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useSearchStore } from "@/stores/searchStore";
import { useRoute } from "vue-router";

const store = useSearchStore();
const route = useRoute();

onMounted(() => {
  const word = route.query.word;
  console.log("검색어:", word);

  // searchCondition 초기값 확인
  console.log("초기 검색 조건:", store.searchCondition);

  if (word) {
    store.searchCondition.word = word; // 값 업데이트
    console.log("업데이트된 검색 조건:", store.searchCondition);
    store.getSearchResults();
  } else {
    store.error = "검색어가 제공되지 않았습니다.";
  }
});
</script>

<style></style>