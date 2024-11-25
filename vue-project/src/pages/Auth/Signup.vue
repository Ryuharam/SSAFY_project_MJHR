<template>
    <form class="form" @submit.prevent="signup">
    <div class="flex-column">
      <label>Id </label>
    </div>
    <div class="inputForm">
      <svg height="20" viewBox="0 0 32 32" width="20" xmlns="http://www.w3.org/2000/svg">
        <g id="Layer_3" data-name="Layer 3">
        </g>
      </svg>
      <input type="text" class="input" placeholder="Enter your Id" v-model.trim="id"/>
    </div>
  <!-- 비밀번호 -->
      <div class="flex-column">
        <label>Password </label>
      </div>
      <div class="inputForm">
        <svg height="20" viewBox="-64 0 512 512" width="20" xmlns="http://www.w3.org/2000/svg">
        </svg>
        <input type="password" class="input" placeholder="Enter your Password" v-model.trim="password"/>
        <svg viewBox="0 0 576 512" height="1em" xmlns="http://www.w3.org/2000/svg">
        </svg>
      </div>
<!-- 이름 -->
      <div class="flex-column">
        <label>Name </label>
      </div>
      <div class="inputForm">
        <svg height="20" viewBox="0 0 32 32" width="20" xmlns="http://www.w3.org/2000/svg">
          <g id="Layer_3" data-name="Layer 3">
          </g>
        </svg>
        <input type="text" class="input" placeholder="Enter your name" v-model.trim="name"/>
      </div>
<!-- 이메일 -->
      <div class="flex-column">
        <label>E-mail</label>
      </div>
      <div class="inputForm">
        <svg height="20" viewBox="0 0 32 32" width="20" xmlns="http://www.w3.org/2000/svg">
          <g id="Layer_3" data-name="Layer 3">
          </g>
        </svg>
        <input type="email" class="input" placeholder="Enter your e-mail" v-model.trim="email"/>
      </div>
<!-- 닉네임 -->
      <div class="flex-column">
        <label>Nickname</label>
      </div>
      <div class="inputForm">
        <svg height="20" viewBox="0 0 32 32" width="20" xmlns="http://www.w3.org/2000/svg">
          <g id="Layer_3" data-name="Layer 3">
          </g>
        </svg>
        <input type="text" class="input" placeholder="Enter your nickname" v-model.trim="nickname"/>
      </div>

      <div class="flex-row">
      </div>
      <button class="button-submit">Sign Up</button>
      <div class="flex-row">
      </div>
    </form>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import axios from 'axios';
  import { useRouter } from 'vue-router'; 
  
  // API 엔드포인트 설정
  const API_URL = 'http://localhost:8080/user';
  
  // 각 필드에 대한 ref 생성
  const id = ref('');
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
      userId: id.value,
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
      id.value = '';
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

  .flex-column > label {
    color: #151717;
    font-weight: 600;
  }

  .inputForm {
    border: 1.5px solid #af8f6f;
    border-radius: 10px;
    height: 50px;
    display: flex;
    align-items: center;
    padding: 0 10px;
    transition: 0.2s ease-in-out;
    background-color: #ffffff;
  }

  .input {
    margin-left: 10px;
    border: none;
    width: 85%;
    height: 100%;
    background-color: transparent;
  }

  .input:focus {
    outline: none;
  }

  .inputForm:focus-within {
    border: 1.5px solid #af8f6f;
  }

  .flex-row {
    display: flex;
    flex-direction: row;
    align-items: center;
    gap: 10px;
    justify-content: space-between;
  }

  .flex-row > div > label {
    font-size: 14px;
    color: black;
    font-weight: 400;
  }

  .span {
    font-size: 14px;
    margin-left: 5px;
    color: #74512d;
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
    background-color: #74512d;
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
    border: 1px solid #ededef;
    background-color: white;
    cursor: pointer;
    transition: 0.2s ease-in-out;
  }

  .btn:hover {
    border: 1px solid #2d79f3;
    ;
  }
</style>