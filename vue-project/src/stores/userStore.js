import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API_URL = `http://localhost:8080/user`

export const useUserStore = defineStore('user', () => {
    const loginUser = ref(null)

    const userLogin = function (id, password) {
        axios.post(`${REST_API_URL}/login`, { //axios.post()로 REST API 서버에 로그인 요청을 보냄
            id,
            password: password,
        })
            .then((res) => {
                console.log(res)
                sessionStorage.setItem('access-token', res.data['access-token'])
                //브라우저의 세션 스토리지에 엑세스 토큰 저장  -> 토큰은 인증에 사용
                const token = res.data['access-token'].split('.')
                const name = JSON.parse(atob(token[1]))['name']
                   
                console.log(token);
                console.log(name);

                loginUser.value = name //loginUser 변수에 추출된 사용자 이름 저장 

                router.push({ name: 'App' }) //로그인 성공->App(메인)로 리다이렉트

            })
            .catch((err) => {
                console.log(err)
                router.push({ name: 'UserLogin' }) //로그인 실패 -> UserLogin으로 리다이렉트 
            })
    }

    return { loginUser, userLogin }
})
