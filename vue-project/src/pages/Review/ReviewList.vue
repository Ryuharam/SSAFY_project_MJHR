<template>
  <div v-for="(review, index) in results" :key="index">
    <ReviewDetail :review="review" />
  </div>
</template>

<script setup>
import { defineProps, onMounted, computed } from 'vue';
import { useReviewStore } from "@/stores/reviewStore";
import ReviewDetail from './ReviewDetail.vue';

const store = useReviewStore();

const props = defineProps({
  isbn: {
    type: String,
    required: true,
  },
});


// 리뷰 결과 가져오기
const results = computed(() => store.bookReviews);

onMounted(() => {
  store.getBookReviews(props.isbn); // ISBN 기반으로 리뷰 가져오기
});
</script>

<style scoped></style>
