<template>
  <div class="profile-container">
      <div class="profile-image-section">
          <img 
              :src="profileImage" 
              @click="changeProfileImage"
              alt="프로필 이미지" 
              class="profile-img"
          >
      </div>
      
      <div class="intro-sections">
          <!-- 한 줄 소개 폼 -->
          <form @submit.prevent="submitShortIntro" class="short-intro-form">
              <button type="button" class="intro-btn">한 줄 소개</button>
              <input 
                  type="text" 
                  v-model="shortIntro"
                  placeholder="한 줄 소개를 입력해주세요"
                  class="intro-input"
              >
              <button type="submit" class="submit-btn">한 줄 소개 저장</button>
          </form>

          <!-- 자세한 소개 폼 -->
          <form @submit.prevent="submitFullIntro" class="full-intro-form">
              <textarea 
                  v-model="fullIntro"
                  placeholder="자세한 소개를 입력해주세요"
                  class="full-intro-input"
              ></textarea>
              <button type="submit" class="submit-btn">자세한 소개 저장</button>
          </form>
      </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';

const URL = 'https://api.thecatapi.com/v1/images/search';
const profileImage = ref('');
const shortIntro = ref('');
const fullIntro = ref('');

const changeProfileImage = async () => {
  try {
      const response = await axios.get(URL);
      profileImage.value = response.data[0].url;
  } catch (error) {
      console.error('프로필 이미지 변경 실패:', error);
  }
};

const submitShortIntro = async () => {
  try {
      await new Promise(resolve => setTimeout(resolve, 500));
      console.log('한 줄 소개 저장:', {
          shortIntro: shortIntro.value
      });
  } catch (error) {
      console.error('한 줄 소개 저장 실패:', error);
  }
};

const submitFullIntro = async () => {
  try {
      await new Promise(resolve => setTimeout(resolve, 500));
      console.log('자세한 소개 저장:', {
          fullIntro: fullIntro.value
      });
  } catch (error) {
      console.error('자세한 소개 저장 실패:', error);
  }
};
</script>

<style scoped>
.intro-sections {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.short-intro-form,
.full-intro-form {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.intro-input,
.full-intro-input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.full-intro-input {
  min-height: 100px;
  resize: vertical;
}

.submit-btn {
  padding: 8px 16px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.submit-btn:hover {
  background-color: #45a049;
}
</style>