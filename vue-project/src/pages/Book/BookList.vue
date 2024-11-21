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
