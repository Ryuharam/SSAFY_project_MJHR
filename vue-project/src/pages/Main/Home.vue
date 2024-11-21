<template>
  <div class="home-page">
    <!-- 메인 페이지: 추천 도서와 최신 독후감 -->
    <h2>Welcome to My Book Review</h2>
    <div class="recommendations">
      <h3>Recommended Books</h3>
      <ul>
        <li v-for="(book, index) in books" :key="index">
          {{ book }}
        </li>
      </ul>
    </div>
    <div class="reviews">
      <h3>Latest Reviews</h3>
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
.home-page {
  padding: 20px;
}

.recommendations,
.reviews {
  margin-top: 20px;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin-bottom: 5px;
}
</style>
