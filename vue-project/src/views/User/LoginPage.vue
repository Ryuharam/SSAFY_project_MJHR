<template>
    <div>
<h2>로고</h2>
<br>
<input type="text" placeholder="ID입력"/>
    <input type="password" placeholder="PW입력"/>
    <button @click="login">로그인</button>
    </div>
</template>


<script setup>
import {ref} from 'vue';
import {useUserStore} from '@/stores/userStore';

const store = useUserStore();

const id = ref('');
const password = ref('');

const login = function(){
    stores.user(id.value, password.value)
}

</script>


<style scoped>

</style>