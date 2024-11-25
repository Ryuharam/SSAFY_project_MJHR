<template>
  <h3>3. Login</h3>
  <div>
    <h4>Login</h4>
    <input type="text" placeholder="아이디를 입력해주세요." v-model.trim="id" />
    <div>
      <input type="password" placeholder="비밀번호를 입력해주세요." v-model.trim="pw" />
    </div>
    <button @click="login">로그인</button>
    <div>
      <h5>아직 회원이 아니신가요?</h5>
      <button @click="signup">회원가입</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useUserStore } from '@/stores/userStore';
import {useRouter} from 'vue-router';

const store = useUserStore();
const id = ref('')
const pw = ref('')
const router = useRouter();

const login = function () {
  store.userLogin(id.value, pw.value);
}

const signup = function() {
  router.push('/auth/signup');
}
</script>

<style scoped>
</style>
