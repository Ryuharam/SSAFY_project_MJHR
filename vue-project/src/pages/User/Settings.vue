<template>
  <div class="settings-container">
    <div class="user-name">
      <h3>{{ userId }}님의 서재</h3>
    </div>
    <div class="user-page">
      <div class="user-info">
        <div class="profile-section">
          <img :src="profileImage" alt="프로필 이미지" class="profile-image" @click="triggerFileInput">
          <input type="file" ref="fileInput" @change="changeProfileImage" accept="image/*" style="display: none;">
        </div>
      </div>
      <div class="info-section form">
        <form @submit.prevent="updateInfo">
          <div class="form-group inputForm">
            <label for="shortIntro" class="flex-column">한 줄 소개</label>
            <input type="text" id="shortIntro" v-model="shortIntro" placeholder="한 줄 소개를 입력하세요" class="input">
          </div>
          <div class="form-group inputForm">
            <label for="fullIntro" class="flex-column">소개</label>
            <textarea id="fullIntro" v-model="fullIntro" placeholder="소개를 입력하세요" class="input">
            </textarea>
          </div>
          <button type="submit" class="button-submit">정보 업데이트</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/stores/userStore';

const store = useUserStore();
const userId = store.loginUser;

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
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  width: 100%;
}

.user-name {
  color: #543310;
  margin-bottom: 20px;
}

.user-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px;
  width: 40%;
}

.profile-section {
  text-align: center;
}

.profile-image {
  width: 120px;
  height: 120px;
  border-radius: 50%;
  cursor: pointer;
}

.info-section {
  width: 100%;
  max-width: 450px;
}

form {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.inputForm {
  display: flex;
  flex-direction: column;
  gap: 5px;
}

label {
  font-size: 14px;
  color: #543310;
  font-weight: 600;
}

.input,
textarea {
  width: 100%;
  padding: 10px;
  border: 1.5px solid #ecedec;
  border-radius: 10px;
  font-size: 14px;
  font-family: inherit;
  background-color: #ffffff;
  resize: vertical;
  /* 텍스트 영역 높이 조절 가능 */
}

textarea {
  min-height: 100px;
  /* 최소 높이 설정 */
  max-height: 300px;
  /* 최대 높이 설정 */
}

.input:focus,
textarea:focus {
  outline: none;
  border-color: #af8f6f;
}

.button-submit {
  background-color: #af8f6f;
  color: white;
  border: none;
  border-radius: 10px;
  height: 50px;
  font-size: 15px;
  cursor: pointer;
  transition: background-color 0.2s;
  width: 100%;
}

.button-submit:hover {
  background-color: #d1bb9e;
}
</style>