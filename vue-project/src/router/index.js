import { createRouter, createWebHistory } from 'vue-router'
// 레이아웃 컴포넌트 import
import MainLayout from "../layouts/MainLayout.vue";
import AuthLayout from "../layouts/AuthLayout.vue";

// 페이지 컴포넌트 import
import Home from "../pages/Main/Home.vue";
import BookDetail from "../pages/Book/BookDetail.vue";
import SearchResult from "../pages/Search/SearchResult.vue";
import Login from "../pages/Auth/Login.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
      // 메인 레이아웃
  {
    path: "/",
    component: MainLayout,
    children: [
      {
        path: "",
        name: "Home",
        component: Home,
      },
      {
        path: "book/:id",
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
    ],
  },
  ],
})

export default router
