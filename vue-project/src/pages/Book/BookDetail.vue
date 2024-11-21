<template>
  <div class="book-detail">
    <!-- 도서의 상세 정보와 독후감 목록 -->
    <h2>{{ book.title }}</h2>
    <p><strong>Author:</strong> {{ book.author }}</p>
    <p><strong>Description:</strong> {{ book.description }}</p>

    <div class="reviews">
      <h3>Reviews</h3>
      <ul>
        <li v-for="(review, index) in reviews" :key="index">
          {{ review }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>

</script>

<style scoped>
.book-detail {
  padding: 20px;
}

h2 {
  margin-bottom: 10px;
}

.reviews {
  margin-top: 20px;
}

ul {
  list-style-type: none;
  padding: 0;
}
</style>