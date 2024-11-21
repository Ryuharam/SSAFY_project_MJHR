<template>
  <div class="login-page">
    <!-- 로그인 폼 -->
    <h2>Log In</h2>
    <form @submit.prevent="handleLogin">
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" required />
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit">Log In</button>
    </form>
    <!-- 회원가입 링크 -->
    <p>
      Don't have an account?
      <router-link to="/auth/signup">Sign Up</router-link>
    </p>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
    // 로그인 처리 로직 (예: API 호출)
    handleLogin() {
      console.log("Logging in with:", this.email, this.password);
      // 실제로는 API 호출 후 응답에 따라 작업 수행
      this.$router.push("/"); // 로그인 성공 시 메인 페이지로 이동
    },
  },
};
</script>

<style scoped>
/* 스타일: 간단한 폼 레이아웃 */
.login-page {
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
