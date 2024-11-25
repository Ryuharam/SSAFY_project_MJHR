import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';


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
      })
      .catch((error) => {
        console.error('❌ 리뷰 등록에 실패했습니다:', error);
        alert("리뷰등록실패")
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
  }

})