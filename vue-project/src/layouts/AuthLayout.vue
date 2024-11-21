<template>
  <div class="auth-layout">
    <header class="auth-header">
      <h1>Welcome to My Book Review</h1>
    </header>
    <main class="auth-content">
      <slot></slot>
    </main>
    <footer class="auth-footer">
      <p>&copy; 2024 My Book Review</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: "AuthLayout",
};
</script>

<style scoped>
.auth-layout {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #f9f9f9;
}

.auth-header {
  margin-bottom: 20px;
  font-size: 24px;
  font-weight: bold;
}

.auth-content {
  width: 100%;
  max-width: 400px;
  padding: 20px;
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.auth-footer {
  margin-top: 20px;
  font-size: 14px;
  color: #888;
}
</style>
