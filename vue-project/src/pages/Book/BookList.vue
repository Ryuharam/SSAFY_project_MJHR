<template>
  <div class="book-list">
    <div class="book" v-for="(book, index) in results" :key="index">
      <BookCard :book="book" />
    </div>
  </div>
</template>

<script setup>
import { defineProps } from 'vue';
import BookCard from "@/components/BookCard.vue";

// 부모 컴포넌트로부터 전달받을 props 정의
defineProps({
  results: {
    type: Array,
    required: true,
  },
});
</script>

<style scoped>
.book-list {
  display: flex;
  flex-wrap: wrap;

}
</style>
