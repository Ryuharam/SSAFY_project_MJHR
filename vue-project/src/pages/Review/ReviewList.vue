<template>
  <table>
    <thead>
      <tr>
        <th>제목</th>
        <th>작성자</th>
      </tr>
    </thead>
    <tbody>
      <tr class="review-list" v-for="(review, index) in results" :key="index">
        <td>
          {{ review.reviewTitle }}
        </td>
        <td>{{ review.userId }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script setup>
import { defineProps, onMounted, computed } from 'vue';
import { useReviewStore } from "@/stores/reviewStore";

const store = useReviewStore();

const props = defineProps({
  isbn: {
    type: String,
    required: true,
  },
});

const results = computed(() => store.bookReviews)

onMounted(() => {
  store.getBookReviews(props.isbn)
})


</script>

<style scoped></style>