<template>
  <nav>
    <RouterLink :to="{ name: 'Home' }">
      <span>Home</span>
    </RouterLink>
    |
    <RouterLink :to="{ name: 'Login' }">
      <span>Login</span>
    </RouterLink>
    |
    <RouterLink :to="{ name: 'Settings' }">
      <span>Settings</span>
    </RouterLink>
    |
    <RouterLink :to="{ name: 'MyPage' }">
      <span>MyPage</span>
    </RouterLink>
    |
    <RouterLink :to="{ name: 'BookList' }">
      <span>BookList</span>
    </RouterLink>
  </nav>
  <h1>1. App.vue</h1>
  <hr>
  <div v-if="store.loginUser">
    <span>안녕하세요, {{ store.loginUser }} 님!</span>
  </div>
  <button v-if="!store.loginUser" @click="login">Go to Login</button>
  <button v-else @click="logout">Logout</button>
  <RouterView />
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

<style scoped></style>