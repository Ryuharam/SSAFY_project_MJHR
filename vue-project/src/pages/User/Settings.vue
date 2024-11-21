<template>
  <div class="settings">
    <!-- 설정 페이지: 사용자 정보 수정 -->
    <h2>Settings</h2>
    <form @submit.prevent="saveSettings">
      <div class="form-group">
        <label for="nickname">Nickname:</label>
        <input type="text" id="nickname" v-model="nickname" />
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" />
      </div>
      <div class="form-group">
        <label for="statusMessage">Status Message:</label>
        <textarea id="statusMessage" v-model="statusMessage"></textarea>
      </div>
      <button type="submit">Save Changes</button>
    </form>
  </div>
</template>

<script>

</script>

<style scoped>
.settings {
  padding: 20px;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input,
textarea {
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
