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
import { useRouter } from "vue-router";

const word = ref("");
const router = useRouter();

const doSearch = function () {
  console.log("호출")
  if (word.value.trim() === "") {
    alert("공백은 입력될 수 없습니다");
    return;
  }

  // SearchResult 페이지로 이동하며 검색어 전달
  router.push({
    name: "SearchResult",
    query: {
      word: word.value,
    },
  });
};

</script>

<style scoped></style>
