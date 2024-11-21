<template>
  <div>
    <h4>Login</h4>
    <input type="text" placeholder="아이디를 입력해주세요." v-model.trim="id" />
    <div>
      <input type="password" placeholder="비밀번호를 입력해주세요." v-model.trim="pw" />
    </div>
    <button @click="login">로그인</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useUserStore } from '@/stores/userStore';
import axios from 'axios';

const store = useUserStore();
const id = ref('')
const pw = ref('')

const login = function () {
  store.userLogin(id.value, pw.value);
}

</script>

<style scoped>

</style>
