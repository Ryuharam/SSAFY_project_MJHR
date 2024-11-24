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
  <RouterView v-slot="{ Component, route }">
    <component
      :is="Component"
      v-bind="getPropsForRoute(route)"
    />
  </RouterView>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useSearchStore } from "@/stores/searchStore";

const word = ref("");
const router = useRouter();
const store = useSearchStore();

// 검색 실행
const doSearch = async () => {
  if (word.value.trim() === "") {
    alert("공백은 입력될 수 없습니다");
    return;
  }

  // 검색 조건 설정
  store.searchCondition.word = word.value;
  store.searchCondition.key = "title";
  store.searchCondition.offset = 0;
  store.searchCondition.size = 100;

  // 검색 수행
  await store.fetchBookResults();

  if (store.results.length === 0) {
    alert("검색 결과가 없습니다1.");
    return;
  }

  // BookList로 이동
  router.push("BookList");
};

// 특정 라우트에 props 전달
const getPropsForRoute = (route) => {
  if (route.name === "BookList") {
    return { results: store.results }; // BookList로 이동할 때만 results 전달
  }
  return {};
};

</script>

<style scoped></style>
