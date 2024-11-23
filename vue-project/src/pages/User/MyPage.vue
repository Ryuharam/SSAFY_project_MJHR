<template>
  <div class="mypage-container">
    <h3>3.MyPage</h3>
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
</template>

<script setup>
import { ref, onMounted } from 'vue';

const profileImage = ref('');
const shortIntro = ref('');
const fullIntro = ref('');

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
}

.info-section {
  margin-bottom: 20px;
}

h1, h2 {
  color: #333;
}

p {
  margin-bottom: 15px;
}
</style>