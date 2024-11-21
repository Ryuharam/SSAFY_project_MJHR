<template>
  <h5>BookList</h5>
  <div v-for="(num, index) in time" :key="index">
    <BookCard />
  </div>
</template>

<script>
import { ref } from "vue";
import BookCard from "@/components/BookCard.vue";

export default {
  components: {
    BookCard,
  },
  setup() {
    // time 배열을 반응형 데이터로 정의
    const time = ref([1, 2, 3, 4]);

    return {
      time,
    };
  },
};
</script>

<style scoped></style>
