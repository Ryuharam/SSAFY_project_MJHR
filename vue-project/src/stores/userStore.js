import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API_URL = `http://localhost:8080/user`

export const useUserStore = defineStore('user', () => {
    const loginUser = ref(null)
    const accessToken = ref(null)

    const userLogin = function (id, password) {
        axios.post(`${REST_API_URL}/login`, {
            userId: id,
            userPw: password,
        })
            .then((res) => {
                console.log(res)
                accessToken.value = res.data['access-token']
                const token = accessToken.value.split('.')
                const name = JSON.parse(atob(token[1]))['name']

                console.log(token);
                console.log(name);

                loginUser.value = name

                router.push({ name: 'Home' })
            })
            .catch((err) => {
                console.log(err)
                router.push({ name: 'Login' })
            })
    }

    const checkLoginStatus = () => {
        const userStore = useUserStore()
        if (accessToken.value) {
            // 필요한 경우 백엔드에서 토큰 유효성 검사
            // 유효하다면 loginUser 설정
            const token = userStore.accessToken.split('.')
            userStore.loginUser = JSON.parse(atob(token[1]))['name']
        } else {
            router.push({ name: 'Login' })
        }
    }

    const logout = () => {
        loginUser.value = null
        accessToken.value = null
        router.push({ name: 'Login' })
    }

    return { loginUser, accessToken, userLogin, logout, checkLoginStatus }
}, {
    persist: true
})