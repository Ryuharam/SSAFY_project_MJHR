<template>
  <div class="signup-page">
    <!-- 회원가입 폼 -->
    <h2>Sign Up</h2>
    <form @submit.prevent="handleSignup">
      <div class="form-group">
        <label for="nickname">Nickname:</label>
        <input type="text" id="nickname" v-model="nickname" required />
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" required />
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit">Sign Up</button>
    </form>
    <!-- 로그인 링크 -->
    <p>
      Already have an account?
      <router-link to="/auth/login">Log In</router-link>
    </p>
  </div>
</template>

<script>
export default {
  name: "Signup",
  data() {
    return {
      nickname: "",
      email: "",
      password: "",
    };
  },
  methods: {
    // 회원가입 처리 로직 (예: API 호출)
    handleSignup() {
      console.log("Signing up with:", this.nickname, this.email, this.password);
      // 실제로는 API 호출 후 응답에 따라 작업 수행
      this.$router.push("/auth/login"); // 회원가입 완료 후 로그인 페이지로 이동
    },
  },
};
</script>

<style scoped>
/* 스타일: 간단한 폼 레이아웃 */
.signup-page {
  text-align: center;
  margin: 20px;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input {
  width: 100%;
  padding: 8px;
  margin: 5px 0 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 10px 15px;
  background-color: #333;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #555;
}
</style>
