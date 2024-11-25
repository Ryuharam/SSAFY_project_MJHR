<template>
  <h5>ReviewDetail.vue</h5>
  <hr>
</template>

<script setup>
import { defineProps } from 'vue';

const props = defineProps({
  reviewId: {
    type: String,
    required: true,
  },
  review: {
    type: Object,
    required: true,
  }
})

</script>

<style scoped></style>