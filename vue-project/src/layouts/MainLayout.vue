<template>
  <div class="main-layout">
    <header class="main-header">
      <h1>My Book Review</h1>
      <nav>
        <router-link to="/">Home</router-link>
        <router-link to="/mypage">My Page</router-link>
        <router-link to="/settings">Settings</router-link>
      </nav>
    </header>
    <main class="main-content">
      <slot></slot>
    </main>
    <footer class="main-footer">
      <p>&copy; 2024 My Book Review</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: "MainLayout",
};
</script>

<style scoped>
.main-layout {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.main-header {
  display: flex;
  justify-content: space-between;
  padding: 10px 20px;
  background-color: #333;
  color: white;
}

.main-header nav a {
  color: white;
  margin: 0 10px;
  text-decoration: none;
}

.main-header nav a:hover {
  text-decoration: underline;
}

.main-content {
  flex: 1;
  padding: 20px;
}

.main-footer {
  text-align: center;
  padding: 10px;
  background-color: #f1f1f1;
  font-size: 14px;
}
</style>
