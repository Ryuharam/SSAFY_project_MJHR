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
  <button @click="login">Go to Login</button>
  <RouterView />
</template>

<script setup>

import { ref } from "vue";
import { useUserStore } from '@/stores/userStore';

const store = useUserStore();

const id = ref('');
const password = ref('');

const login = function () {
  store.userLogin(id.value, password.value)
}



</script>

<style scoped></style>
