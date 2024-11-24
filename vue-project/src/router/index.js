import { createRouter, createWebHistory } from 'vue-router'
import { useUserStore } from '@/stores/userStore'

// 레이아웃 컴포넌트 import
import MainLayout from "../layouts/MainLayout.vue";
import AuthLayout from "../layouts/AuthLayout.vue";
import BookLayout from "../layouts/BookLayout.vue";

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
          path: "search/:category?",
          name: "SearchResult",
          component: SearchResult,
          props: route => ({
            category: route.params.category || "book", // 기본값 설정
            word: route.query.word, // 쿼리에서 word 가져오기
          }),
        },
      ],
    },
    // 도서 레이아웃
    {
      path: "/book",
      name: "BookLayout",
      component: BookLayout,
      children: [
        {
          path: "list",
          name: "BookList",
          component: BookList,
        },
        {
          path: "detail/:isbn",
          name: "BookDetail",
          component: BookDetail,
          props: true, 
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
  //Settings, MyPage만 로그인x에서 접근 불가능
  const restrictedPages = ['/auth/settings', '/auth/mypage']

  if (!userStore.loginUser && restrictedPages.includes(to.path)) {
    console.log("이 페이지는 로그인이 필요합니다.")
    return { name: 'Login' }
  }

})

export default router
