<template>
    <h3>회원가입</h3>
    <div>
      <h4>Signup Form</h4>
      <input type="text" placeholder="아이디를 입력해주세요." v-model.trim="userId" />
      <input type="password" placeholder="비밀번호를 입력해주세요." v-model.trim="password" />
      <input type="text" placeholder="이름을 입력해주세요." v-model.trim="name" />
      <input type="email" placeholder="이메일을 입력해주세요." v-model.trim="email" />
      <input type="text" placeholder="닉네임을 입력해주세요." v-model.trim="nickname" />
      <button @click="signup">회원가입 완료</button>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import axios from 'axios';
  import { useRouter } from 'vue-router'; // Import useRouter
  
  // API 엔드포인트 설정
  const API_URL = 'http://localhost:8080/user';
  
  // 각 필드에 대한 ref 생성
  const userId = ref('');
  const password = ref('');
  const name = ref('');
  const email = ref('');
  const nickname = ref('');
  
  // Initialize router
  const router = useRouter();
  
  // 실제 API 호출 함수
  async function registerUser(userData) {
    console.log(userData);
    try {
      const response = await axios({
        method: 'POST',
        url: `${API_URL}/signup`,
        headers: {
          'Content-Type': 'application/json',
        },
        data: userData,
      });
      return response.data;
    } catch (error) {
      throw error;
    }
  }
  
  const signup = async () => {
    const userData = {
      userId: userId.value,
      userPw: password.value,
      userName: name.value,
      userEmail: email.value,
      userNic: nickname.value,
    };
  
    console.log("회원가입 요청 데이터", userData);
  
    try {
      const response = await registerUser(userData);
      const token = response.token;
      localStorage.setItem('jwt', token);
      alert(`${userData.userId}님이 가입되었습니다!`);
      router.push('/auth/login');
      
      // 가입 후 폼 초기화
      userId.value = '';
      password.value = '';
      name.value = '';
      email.value = '';
      nickname.value = '';
      
      // Navigate to login page after successful signup
    } catch (error) {
      if (error.response && error.response.data) {
        alert(`회원가입 실패: ${error.response.data.message}`);
      } else {
        alert('회원가입에 실패했습니다. 서버와의 통신 오류입니다.');
      }
      console.error('회원가입 오류:', error);
    }
  };
  </script>
  
  <style scoped>

  </style>