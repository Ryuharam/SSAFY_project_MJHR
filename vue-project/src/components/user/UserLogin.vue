<template>
    <div>
        <h3>로그인 화면</h3>
        <input type="text" placeholder="아이디를 입력해 주세요." v-model.trim="id"/>
        <input type="password" placeholder="비밀번호를 입력해 주세요." v-model.trim="pw"/>
        <button @click="login">로그인</button>
    </div>
</template>

<script setup>
import {ref} from 'vue';
import {useUserStore} from '@/stores/userStore';

const store = useUserStore;

const id = ref('');
const pw = ref('');

const login = function(){
    store.userLogin(id.value, pw.value)
};

</script>

<style scoped>

</style>