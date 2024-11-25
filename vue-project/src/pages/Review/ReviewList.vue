<template>
  <h5>ReviewList</h5>
  <div class="review-list">

  </div>
</template>

<script setup>
import { defineProps } from 'vue';

defineProps({
  isbn: {
    type: String,
    required: true,
  },
});
</script>

<style scoped></style>
