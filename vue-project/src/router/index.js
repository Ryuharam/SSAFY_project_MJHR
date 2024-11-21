import { createRouter, createWebHistory } from 'vue-router'
// 레이아웃 컴포넌트 import
import MainLayout from "../layouts/MainLayout.vue";
import AuthLayout from "../layouts/AuthLayout.vue";

// 페이지 컴포넌트 import
import Home from "../pages/Main/Home.vue";
import BookDetail from "../pages/Book/BookDetail.vue";
import SearchResult from "../pages/Search/SearchResult.vue";
import Login from "../pages/Auth/Login.vue";

const isAuth = true //false : 로그인 안된 상태

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
    {
      path: '/login',
      name: 'userLogin',
      component: UserLogin, 
      berforeEnter: (to, from) =>{
        if(isAuth){
          console.log("이미 로그인 된 상태입니다.")
          return {name : 'main'}
        }
      }
    },
  ],
})

router.beforeEach((to, from)=>{
  console.log(to);
  console.log(from);

  if(!isAuth && to.name !== 'userLogin'){ 
    console.log("로그인이 필요합니다.");
    return {name : 'userLogin'}
  }
})




export default router
