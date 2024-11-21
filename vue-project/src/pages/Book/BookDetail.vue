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
export default {
  name: "BookDetail",
  data() {
    return {
      // 가상의 도서 상세 정보
      book: {
        id: 1,
        title: "The Great Gatsby",
        author: "F. Scott Fitzgerald",
        description: "A novel about the American dream and disillusionment.",
      },
      // 가상의 독후감 목록
      reviews: ["Amazing story!", "Loved the characters.", "A timeless classic."],
    };
  },
};
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