<template>
  <h5>BookDetail</h5>
  <hr>

</template>

<script setup>
import { defineProps } from 'vue';

defineProps({
  book: {
    type: Object,
    required: true,
  },
});

</script>

<style scoped></style>