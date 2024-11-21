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
  <RouterView />
</template>

<script>

</script>

<style scoped></style>
