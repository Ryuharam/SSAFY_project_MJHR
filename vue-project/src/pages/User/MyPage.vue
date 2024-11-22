<template>
  <div class="settings-container">
      <div class="profile-section">
          <img :src="profileImage" alt="프로필 이미지" class="profile-image" @click="changeProfileImage">
      </div>
      
      <div class="info-section">
          <button class="info-button">한 줄 소개</button>
          <div class="intro-text">
              <p>소개</p>
          </div>
      </div>

      <div class="book-section">
          <div class="book-header">
              <button class="active">리뷰</button>
              <button>찜</button>
          </div>
          <div class="book-list">
              <div class="book-item" v-for="(book, index) in books" :key="index">
                  <img :src="book.image" alt="책 표지">
                  <p>제목</p>
              </div>
          </div>
      </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const URL = 'https://api.thecatapi.com/v1/images/search';
const profileImage = ref('');
const books = ref([
  { image: '/book1.jpg', title: '제목1' },
  { image: '/book2.jpg', title: '제목2' },
  { image: '/book3.jpg', title: '제목3' }
]);

const changeProfileImage = async () => {
  try {
      const response = await axios.get(URL);
      profileImage.value = response.data[0].url;
  } catch (error) {
      console.error('프로필 이미지 변경 실패:', error);
  }
};

onMounted(async () => {
  await changeProfileImage();
});
</script>

<style scoped>
.settings-container {
  padding: 20px;
}

.profile-section {
  text-align: center;
  margin-bottom: 20px;
}

.profile-image {
  width: 120px;
  height: 120px;
  border-radius: 50%;
  cursor: pointer;
}

.info-section {
  margin-bottom: 20px;
}

.book-header {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
}

.book-list {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
}

.book-item img {
  width: 100%;
  height: auto;
}
</style>