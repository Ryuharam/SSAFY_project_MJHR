<template>
  <header class="app-header">
    <input type="text" v-model="searchQuery" placeholder="Search for books, users, reviews..."
      @keypress.enter="search" />
    <button @click="search">Search</button>
  </header>

  <button @click="goToLogin">Go to Login</button>

  <router-view />
</template>

<script>
import { ref } from "vue";


</script>

<style>
body {
  margin: 0;
  font-family: Arial, sans-serif;
  background-color: #f5f5f5;
  color: #333;
}

#app {
  text-align: center;
}

button {
  margin: 20px;
  padding: 10px 20px;
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
