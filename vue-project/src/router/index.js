import { createRouter, createWebHistory } from 'vue-router'
import { useUserStore } from '@/stores/userStore'

// 레이아웃 컴포넌트 import
import MainLayout from "../layouts/MainLayout.vue";
import AuthLayout from "../layouts/AuthLayout.vue";

// 페이지 컴포넌트 import
import Home from "../pages/Main/Home.vue";
import BookDetail from "../pages/Book/BookDetail.vue";
import SearchResult from "../pages/Search/SearchResult.vue";
import Login from "../pages/Auth/Login.vue";
import Settings from "../pages/User/Settings.vue";
import Signup from "../pages/Auth/Signup.vue";
import MyPage from "../pages/User/MyPage.vue";
import BookList from "../pages/Book/BookList.vue";


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // 메인 레이아웃
    {
      path: "/",
      name: "MainLayout",
      component: MainLayout,
      children: [
        {
          path: "",
          name: "Home",
          component: Home,
        },
        {
          path: "book",
          name: "BookList",
          component: BookList,
        },
        {
          path: "bookdetail",
          name: "BookDetail",
          component: BookDetail,
          props: true, // URL의 :id를 컴포넌트의 props로 전달
        },
        {
          path: "search",
          name: "SearchResult",
          component: SearchResult,
        },
      ],
    },
    // 인증 레이아웃
    {
      path: "/auth",
      component: AuthLayout,
      children: [
        {
          path: "login",
          name: "Login",
          component: Login,
        },
        {
          path: "signup",
          name: "Signup",
          component: Signup,
        },
        {
          path: "settings",
          name: "Settings",
          component: Settings,
        },
        {
          path: "mypage",
          name: "MyPage",
          component: MyPage,
        }
      ],
    },
  ],
})

router.beforeEach((to, from) => {

  const userStore = useUserStore()
  if (!userStore.loginUser && to.name !== 'Login') {
    console.log("로그인이 필요합니다.")
    return { name: 'Login' }
  }
})

export default router
