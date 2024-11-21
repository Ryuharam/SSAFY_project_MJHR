<template>
  <div id="app">
    <!-- 헤더: 메인 화면 위의 검색창 -->
    <header class="app-header">
      <input type="text" v-model="searchQuery" placeholder="Search for books, users, reviews..."
        @keypress.enter="search" />
      <button @click="search">Search</button>
    </header>

    <!-- 로그인 버튼 -->
    <button @click="goToLogin">Go to Login</button>

    <!-- 현재 URL에 따라 컴포넌트를 렌더링 -->
    <router-view />
  </div>
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
