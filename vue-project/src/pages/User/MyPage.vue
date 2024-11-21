<template>
  <div class="mypage">
    <!-- 마이페이지: 사용자 프로필 및 읽은 도서/독후감 목록 -->
    <h2>My Profile</h2>
    <div class="profile">
      <img src="https://via.placeholder.com/150" alt="Profile" />
      <p>Nickname: {{ nickname }}</p>
      <p>Email: {{ email }}</p>
    </div>
    <div class="my-books">
      <h3>Books I've Read</h3>
      <ul>
        <li v-for="(book, index) in myBooks" :key="index">
          {{ book }}
        </li>
      </ul>
    </div>
    <div class="my-reviews">
      <h3>My Reviews</h3>
      <ul>
        <li v-for="(review, index) in myReviews" :key="index">
          {{ review }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>

</script>

<style scoped>
.mypage {
  padding: 20px;
}

.profile {
  text-align: center;
  margin-bottom: 20px;
}

.profile img {
  border-radius: 50%;
  margin-bottom: 10px;
}

.my-books,
.my-reviews {
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
