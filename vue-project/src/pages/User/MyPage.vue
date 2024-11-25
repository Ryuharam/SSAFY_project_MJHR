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
      <div class="book-list">
        <BookList :results="bookStore.myBooks" />
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useUserStore } from '@/stores/userStore';
import { useBookStore } from '@/stores/bookStore';
import BookList from '../Book/BookList.vue';

const profileImage = ref('');
const shortIntro = ref('');
const fullIntro = ref('');
const store = useUserStore()
const bookStore = useBookStore();

const userId = store.loginUser;

onMounted(() => {
  const savedInfo = JSON.parse(localStorage.getItem('userInfo'));
  if (savedInfo) {
    profileImage.value = savedInfo.profileImage || '';
    shortIntro.value = savedInfo.shortIntro || '';
    fullIntro.value = savedInfo.fullIntro || '';
  }
});
</script>

<style scoped>
.mypage-container {
  padding: 4em;
  border: #333 solid;
  display: flex;
  flex-direction: column;
}

.user-page {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}

.user-info {
  margin: 0;
  padding: 1em;
  border: #333 solid;
  width: 10em;
}

.book-list {
  border: #333 solid;
  width: 30em;
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

h1,
h2 {
  color: #333;
}

p {
  margin-bottom: 15px;
}
</style>