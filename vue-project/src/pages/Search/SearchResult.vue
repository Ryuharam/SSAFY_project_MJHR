<template>
  <div class="search-result">
    <!-- 검색 결과: 도서, 사용자, 독후감 목록 -->
    <h2>Search Results for "{{ query }}"</h2>

    <div class="results">
      <div class="books">
        <h3>Books</h3>
        <ul>
          <li v-for="(book, index) in books" :key="index">
            <router-link :to="`/book/${book.id}`">{{ book.title }}</router-link>
          </li>
        </ul>
      </div>

      <div class="users">
        <h3>Users</h3>
        <ul>
          <li v-for="(user, index) in users" :key="index">
            {{ user.name }}
          </li>
        </ul>
      </div>

      <div class="reviews">
        <h3>Reviews</h3>
        <ul>
          <li v-for="(review, index) in reviews" :key="index">
            {{ review.title }}
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchResult",
  data() {
    return {
      query: "Book Title", // 가상의 검색어
      // 가상의 검색 결과
      books: [
        { id: 1, title: "The Great Gatsby" },
        { id: 2, title: "To Kill a Mockingbird" },
      ],
      users: [
        { id: 1, name: "JohnDoe" },
        { id: 2, name: "JaneSmith" },
      ],
      reviews: [
        { id: 1, title: "Great review of '1984'" },
        { id: 2, title: "Thoughts on 'The Catcher in the Rye'" },
      ],
    };
  },
};
</script>

<style scoped>
.search-result {
  padding: 20px;
}

.results {
  display: flex;
  gap: 20px;
}

.books,
.users,
.reviews {
  flex: 1;
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
