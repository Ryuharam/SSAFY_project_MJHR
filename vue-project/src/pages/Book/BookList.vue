<template>
  <div class="book-list">
    <!-- 검색 결과로 도서 목록을 표시 -->
    <h2>Book List</h2>
    <ul>
      <li v-for="(book, index) in books" :key="index">
        <router-link :to="`/book/${book.id}`">{{ book.title }}</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "BookList",
  data() {
    return {
      // 가상의 도서 데이터
      books: [
        { id: 1, title: "The Great Gatsby" },
        { id: 2, title: "To Kill a Mockingbird" },
        { id: 3, title: "1984" },
      ],
    };
  },
};
</script>

<style scoped>
.book-list {
  padding: 20px;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin-bottom: 10px;
}

a {
  text-decoration: none;
  color: #007bff;
}

a:hover {
  text-decoration: underline;
}
</style>
