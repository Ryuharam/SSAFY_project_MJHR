<template>
  <h5>ReviewList</h5>
  <div class="review-list">
    <div class="review" v-for="(review, index) in results" :key="index">
      <ul>
        <li>
          <RouterLink :to="`/Review/${review.reviewId}`">
            {{ review.reviewTitle }}
          </RouterLink>
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { defineProps } from 'vue';

defineProps({
  results: {
    type: Array,
    required: true,
  },
});
</script>

<style scoped>

</style>
