<template>
  <header class="app-header">
    <input type="text" v-model="searchQuery" placeholder="Search for books, users, reviews..."
      @keypress.enter="search" />
    <button @click="search">Search</button>
  </header>

  <button @click="login">Go to Login</button>
  <RouterView/>
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from '@/stores/userStore';

const store = useUserStore();

const id = ref('');
const password = ref('');

const login = function(){
  store.userLogin(id.value, password.value)
}


</script>

<style>

</style>
