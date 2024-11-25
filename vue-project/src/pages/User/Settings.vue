<template>
  <div class="settings-container">
    <div class="profile-section">
      <img :src="profileImage" alt="프로필 이미지" class="profile-image" @click="triggerFileInput">
      <input type="file" ref="fileInput" @change="changeProfileImage" accept="image/*" style="display: none;">
    </div>
    
    <div class="info-section form">
      <form @submit.prevent="updateInfo">
        <div class="form-group inputForm">
          <label for="shortIntro" class="flex-column">한 줄 소개</label>
          <input type="text" id="shortIntro" v-model="shortIntro" placeholder="한 줄 소개를 입력하세요" class="input">
        </div>
        <div class="form-group inputForm">
          <label for="fullIntro" class="flex-column">소개</label>
          <textarea id="fullIntro" v-model="fullIntro" placeholder="소개를 입력하세요" class="input"></textarea>
        </div>
        <button type="submit" class="button-submit">정보 업데이트</button>
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
.form {
  display: flex;
  flex-direction: column;
  gap: 10px;
  background-color: #ffffff;
  padding: 30px;
  width: 450px;
  border-radius: 20px;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

::placeholder {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

.form button {
  align-self: flex-end;
}

.flex-column>label {
  color: #151717;
  font-weight: 600;
}

.inputForm {
  border: 1.5px solid #ead8c0;
  border-radius: 10px;
  height: 50px;
  display: flex;
  align-items: center;
  transition: 0.2s ease-in-out;
}

.input {
  margin-left: 10px;
  border-radius: 10px;
  border: none;
  width: 100%;
  height: 100%;
}

.input:focus {
  outline: none;
}

.inputForm:focus-within {
  border: 1.5px solid #ead8c0;
}

.flex-row {
  display: flex;
  flex-direction: row;
  align-items: center;
  gap: 10px;
  justify-content: space-between;
}

.flex-row>div>label {
  font-size: 14px;
  color: black;
  font-weight: 400;
}

.span {
  font-size: 14px;
  margin-left: 5px;
  color: #af8f6f;
  font-weight: 500;
  cursor: pointer;
}

.button-submit {
  margin: 20px 0 10px 0;
  background-color: #af8f6f;
  border: none;
  color: white;
  font-size: 15px;
  font-weight: 500;
  border-radius: 10px;
  height: 50px;
  width: 100%;
  cursor: pointer;
}

.button-submit:hover {
  background-color: #D1BB9E;
}

.p {
  text-align: center;
  color: black;
  font-size: 14px;
  margin: 5px 0;
}

.btn {
  margin-top: 10px;
  width: 100%;
  height: 50px;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: 500;
  gap: 10px;
  border: 1px solid #ead8c0;
  background-color: white;
  cursor: pointer;
  transition: 0.2s ease-in-out;
}

.btn:hover {
  border: 1px solid #ead8c0;
  ;
}

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

.settings-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
}

.info-section.form {
  max-width: 450px;
  width: 100%;
  margin: 0 auto;
}

.textarea-container {
  height: auto;
}

.textarea {
  height: 150px;
  resize: vertical;
}

.inputForm {
  flex-direction: column;
  align-items: flex-start;
}

.input {
  width: 100%;
  margin-left: 0;
  padding: 10px;
}

.flex-column > label {
  margin-bottom: 5px;
}

.button-submit {
  width: 100%;
  margin-top: 20px;
}

</style>