<template>
  <div class="app-page">
    <header class="head">
      <nav class="nav-bar">
        <RouterLink :to="{ name: 'Home' }">
          <span>Home</span>
        </RouterLink>
        |
        <RouterLink :to="{ name: 'MyPage' }">
          <span>MyPage</span>
        </RouterLink>
        |
        <RouterLink :to="{ name: 'Settings' }">
          <span>Settings</span>
        </RouterLink>
        |
        <RouterLink v-if="!store.loginUser" :to="{ name: 'Login' }" class="auth-link">
          <span>Login</span>
        </RouterLink>
        <a v-else @click="logout" class="auth-link">Logout</a>
      </nav>
    </header>
    <div class="banner">
      <div class="welcome-user">
        <div v-if="store.loginUser" class="user-name">
          <p>안녕하세요, {{ store.loginUser }} 님!</p>
        </div>
      </div>
    </div>
    <RouterView />
  </div>
</template>

<script setup>

import { ref, onMounted } from "vue";
import { useUserStore } from '@/stores/userStore';

const store = useUserStore();

const id = ref('');
const password = ref('');

const login = function () {
  store.userLogin(id.value, password.value)
}

const logout = function () {
  store.logout()
}

onMounted(() => {
  store.checkLoginStatus()
})

</script>

<style scoped>
.app-page {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.head {
  width: 95%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: end;
  padding: 1%;
}

.banner {
  width: 100%; /* 배너가 페이지 전체 너비를 차지하도록 */
  height: 300px; /* 원하는 높이 설정 */
  background-image: url('@/assets/banner-img.png'); /* 이미지 경로 설정 */
  background-position: center; /* 이미지를 중앙에 배치 */
  background-repeat: no-repeat; /* 반복 방지 */
  display: flex;
}

.welcome-user {
  padding-top: 1%;
  padding-bottom: 1%;
  width: 30%;
  background-color: rgba(209, 187, 158, 0.9);;
  color: #f8f8f7;
  display: flex;
  position: absolute;
  border-radius: 1cap;
}

.user-name {
margin: auto;
}

.auth-link {
  color: #74512d;
  text-decoration: none;
  cursor: pointer;
}

.auth-link:hover {
  text-decoration: underline;
}

nav a {
  color: #74512d;
  text-decoration: none;
}

nav a:hover {
  text-decoration: underline;
}
</style>