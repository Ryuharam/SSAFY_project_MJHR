<template>
  <div class="mypage-container">
    <div class="user-name">
      <h3>{{ userId }}님의 서재</h3>
    </div>
    <div class="user-page">
      <div class="user-info">
        <div class="profile-section">
          <img :src="profileImage" alt="프로필 이미지" class="profile-image">
        </div>
        <div class="info-section">
          <h4>한 줄 소개</h4>
          <p>{{ shortIntro }}</p>
          <h4>소개</h4>
          <p>{{ fullIntro }}</p>
        </div>
      </div>
      <div>
        <div class="category">
          <button class="book-list-btn" @click.prevent="isShow = true">
            <h3>내가 좋아하는 도서 목록</h3>
          </button>
          <button class="book-list-btn" @click.prevent="isShow = false">
            <h3>내가 작성한 리뷰 목록</h3>
          </button>
        </div>
        <hr>
        <div v-if="isShow" class="result-list">
          <div v-for="(book, index) in bookLikeStore.userLikes" :key="index">
            <button @click.prevent="goBookDetail(book.isbn)" class="list-btn">
              {{ book.title }}
            </button>
          </div>
        </div>
        <div v-if="!isShow" class="result-list">
          <div v-for="(review, index) in reviewStore.userReviews" :key="index">
            <button @click.prevent="" class="list-btn">
              {{ review.reviewTitle }}
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/stores/userStore';
import { useBookLikeStore } from '@/stores/bookLikeStore';
import { useReviewStore } from '@/stores/reviewStore';

const profileImage = ref('');
const shortIntro = ref('');
const fullIntro = ref('');
const store = useUserStore();
const bookLikeStore = useBookLikeStore();
const reviewStore = useReviewStore();

const userId = store.loginUser;
const isShow = ref(true);

onMounted(() => {
  const savedInfo = JSON.parse(localStorage.getItem('userInfo'));
  if (savedInfo) {
    profileImage.value = savedInfo.profileImage || '';
    shortIntro.value = savedInfo.shortIntro || '';
    fullIntro.value = savedInfo.fullIntro || '';
  }
  bookLikeStore.getUserLikes()
  reviewStore.getUserReviews()
});

const router = useRouter();

const goBookDetail = function (isbn) {
  router.push({
    name: 'BookDetail',
    params: { isbn: isbn },
  })
}



</script>

<style scoped>
.mypage-container {
  padding: 4em;
  display: flex;
  flex-direction: column;
  color: #543310;
}

.user-name {
  color: #543310;
}

.user-page {
  display: flex;
  flex-direction: column;
}

.user-info {
  margin: 0;
  padding: 1em;
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
  gap: 3em;
}

.category {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 1em;
}

.book-list-btn {
  border: 0;
  background-color: #F8F4E1;
  color: lightgrey;
  border-radius: 10px;
  padding: 0 2em 0 2em;
}

.book-list-btn:focus {
  background-color: #af8f6f;
  color: white
}

.result-list {
  width: 30em;
}

.list-btn {
  margin: 10px 0 10px 0;
  border: #af8f6f solid;
  background-color: transparent;
  color: #543310;
  font-size: 15px;
  font-weight: 600;
  border-radius: 10px;
  height: 70px;
  width: 100%;
  cursor: pointer;
}

.list-btn:hover {
  border: #F8F4E1;
  background-color: #D1BB9E;
  color: white;
}

.profile-section {
  text-align: center;
  margin-bottom: 20px;
}

.profile-image {
  width: 120px;
  height: 120px;
  border-radius: 50%;
}

.info-section {
  margin-bottom: 20px;
}
</style>