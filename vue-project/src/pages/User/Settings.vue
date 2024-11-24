<template>
  <div class="settings-container">
    <div class="profile-section">
      <img :src="profileImage" alt="프로필 이미지" class="profile-image" @click="triggerFileInput">
      <input type="file" ref="fileInput" @change="changeProfileImage" accept="image/*" style="display: none;">
    </div>
    
    <div class="info-section">
      <form @submit.prevent="updateInfo">
        <div class="form-group">
          <label for="shortIntro">한 줄 소개:</label>
          <input type="text" id="shortIntro" v-model="shortIntro" placeholder="한 줄 소개를 입력하세요">
        </div>
        <div class="form-group">
          <label for="fullIntro">소개:</label>
          <textarea id="fullIntro" v-model="fullIntro" placeholder="소개를 입력하세요"></textarea>
        </div>
        <button type="submit" class="update-button">정보 업데이트</button>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const profileImage = ref('');
const shortIntro = ref('');
const fullIntro = ref('');
const fileInput = ref(null);

const triggerFileInput = () => {
  fileInput.value.click();
};

const changeProfileImage = (event) => {
  const file = event.target.files[0];
  if (file) {
    const reader = new FileReader();
    reader.onload = (e) => {
      profileImage.value = e.target.result;
    };
    reader.readAsDataURL(file);
  }
};

const updateInfo = async () => {
  try {
    // localStorage에 데이터 저장
    localStorage.setItem('userInfo', JSON.stringify({
      profileImage: profileImage.value,
      shortIntro: shortIntro.value,
      fullIntro: fullIntro.value
    }));

    console.log('정보가 업데이트되었습니다:', { shortIntro: shortIntro.value, fullIntro: fullIntro.value });
    alert('정보가 성공적으로 업데이트되었습니다!');
    // MyPage로 이동
    router.push('/auth/mypage');
  } catch (error) {
    console.error('정보 업데이트 실패:', error);
    alert('정보 업데이트에 실패했습니다. 다시 시도해주세요.');
  }
};

onMounted(() => {
  // 기존에 저장된 정보가 있다면 불러오기
  const savedInfo = JSON.parse(localStorage.getItem('userInfo'));
  if (savedInfo) {
    profileImage.value = savedInfo.profileImage || '';
    shortIntro.value = savedInfo.shortIntro || '';
    fullIntro.value = savedInfo.fullIntro || '';
  }
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

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="text"],
textarea {
  width: 100%;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

textarea {
  height: 100px;
}

.update-button {
  background-color: #4CAF50;
  color: white;
  padding: 10px 15px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.update-button:hover {
  background-color: #45a049;
}
</style>