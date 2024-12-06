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
          <button class="book-list-btn" @click.prevent="isShow = true" ref="focusButton">
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
          <div v-for="(review, index) in userReviews" :key="index">
            <button @click.prevent="openModal(review)" class="list-btn">
              {{ review.reviewTitle }}
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- updateReview 모달 -->
  <div v-if="showModal" class="modal-overlay" @click.self="closeModal">
    <div class="modal-content">
      <ReviewUpdate :review="selectedReview" @close="closeModal" />
      <button class="close-button" @click="closeModal">X</button>
    </div>
  </div>

</template>

<script setup>
import { ref, onMounted, computed } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/stores/userStore';
import { useBookLikeStore } from '@/stores/bookLikeStore';
import { useReviewStore } from '@/stores/reviewStore';
import ReviewUpdate from '../Review/ReviewUpdate.vue';

const profileImage = ref('');
const shortIntro = ref('');
const fullIntro = ref('');
const store = useUserStore();
const bookLikeStore = useBookLikeStore();
const reviewStore = useReviewStore();

const userId = store.loginUser;
const isShow = ref(true);
const focusButton = ref(null)

const showModal = ref(false);
const selectedReview = ref(null);

const userReviews = computed(() =>
  reviewStore.userReviews
)

const openModal = (review) => {
  selectedReview.value = review;
  showModal.value = true;
}
const closeModal = () => {
  showModal.value = false;
  selectedReview.value = null;
  reviewStore.getUserReviews();
};

onMounted(() => {
  const savedInfo = JSON.parse(localStorage.getItem('userInfo'));
  if (savedInfo) {
    profileImage.value = savedInfo.profileImage || '';
    shortIntro.value = savedInfo.shortIntro || '';
    fullIntro.value = savedInfo.fullIntro || '';
  }
  bookLikeStore.getUserLikes()
  reviewStore.getUserReviews()
  if (focusButton.value) {
    focusButton.value.focus();
  }
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
/* 모달 오버레이 */
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

/* 모달 콘텐츠 */
.modal-content {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  position: relative;
  width: 400px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
}

/* 닫기 버튼 */
.close-button {
  position: absolute;
  top: 10px;
  right: 10px;
  background: none;
  border: none;
  font-size: 18px;
  cursor: pointer;
}

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