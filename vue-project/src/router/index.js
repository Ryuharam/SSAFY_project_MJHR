import { createRouter, createWebHistory } from 'vue-router'
import UserLogin from '@/components/user/UserLogin.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'userLogin',
      component: UserLogin,
    },
  ],
})

export default router
