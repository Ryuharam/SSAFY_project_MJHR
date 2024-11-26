import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
import { useUserStore } from './userStore';


const REST_API_URL = `http://localhost:8080/review`;

export const useReviewStore = defineStore("review", () => {
  const bookReviews = ref([]);
  const userReviews = ref([]);
  const currentPage = ref(1); // 현재 페이지
  const totalPages = ref(0); // 총 페이지 수
  const totalItems = ref(0); // 총 항목 수
  const pageSize = ref(100); // 페이지 크기 (기본값 100)

  const review = ref({
    reviewId: "",
    userId: "",
    isbn: "",
    reviewTitle: "",
    reviewContent: "",
  })

  const getBookReviews = function (isbn) {
    console.log('📡 리뷰 목록 조회 요청 보내는 중:');
    console.log(isbn);
    console.log("주소", `${REST_API_URL}/book/${isbn}`);

    axios.get(`${REST_API_URL}/book/${isbn}`)
      .then(response => {
        console.log("결과", response.data);
        bookReviews.value = response.data;
        console.log("도서리뷰", bookReviews)
      })
      .catch(error => {
        console.error("리뷰를 가져오는 데 실패했습니다.", error);
        bookReviews.value = [];
      })
      ;
  };

  const userStore = useUserStore();
  const userId = userStore.loginUser;

  const getUserReviews = function () {
    axios.get(`${REST_API_URL}/myreview/${userId}`)
      .then(response => {
        userReviews.value = response.data;
      })
      .catch(error => {
        console.log("사용자 리뷰 조회 실패", error);
        userReviews.value = [];
      })
  }

  const createReview = function (newReview) {

    console.log(newReview)

    console.log('📡 리뷰 등록 요청 보내는 중:', { newReview });

    axios({
      url: REST_API_URL,
      method: 'POST',
      params: {
        userId: newReview.userId,
        isbn: newReview.isbn,
        reviewTitle: newReview.reviewTitle,
        reviewContent: newReview.reviewContent,
      }
    })
      .then((response) => {
        console.log('📚 리뷰 등록 완료:', response);
        bookReviews.value = getBookReviews(newReview.isbn)
      })
      .catch((error) => {
        console.error('❌ 리뷰 등록에 실패했습니다:', error);
      });
  }

  return {
    bookReviews,
    userReviews,
    currentPage,
    totalPages,
    totalItems,
    pageSize,
    review,
    createReview,
    getBookReviews,
    getUserReviews,
  }

})