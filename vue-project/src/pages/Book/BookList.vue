<template>
  <h5>BookList</h5>
  <div class="book-list">
    <div class="book" v-for="(book, index) in store.bookList" :key="index">
      <BookCard :book="book" />
    </div>
  </div>
</template>

<script>
import { onMounted } from "vue";
import { useBookStore } from "@/stores/bookStore";
import BookCard from "@/components/BookCard.vue";

export default {
  components: {
    BookCard,
  },
  setup() {
    const store = useBookStore(); // setup 안에서 호출

    onMounted(() => {
      store.getBookList();
    });

    return {
      store,
    };
  },
};
</script>

<style scoped>
.book-list {
  display: flex;
  flex-wrap: wrap;
}
</style>
