import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
import { useUserStore } from './userStore';

const REST_API_URL = `http://localhost:8080/booklike/`;

export const useBookLikeStore = defineStore('bookLike', () => {
  const isbn = ref("");         // 도서 ISBN
  const cntBookLike = ref(0);   // 도서의 좋아요 수
  const isLiked = ref(false);   // 현재 사용자가 좋아요를 눌렀는지 여부
  const userStore = useUserStore(); // 유저 스토어 사용

  // 도서 좋아요 수 요청
  const getBookLike = async () => {
    try {
      if (!isbn.value || isbn.value.trim() === "") {
        console.error("ISBN 값이 비어 있거나 잘못되었습니다.");
        return;
      }
      const response = await axios.get(`${REST_API_URL}book/${isbn.value}/count`);
      cntBookLike.value = response.data;
    } catch (error) {
      console.error("좋아요 수를 가져오는 데 실패했습니다.", error);
    }
  };

  // 현재 사용자가 좋아요 했는지 확인
  const checkUserLike = async () => {
    try {
      const currentUserId = userStore.loginUser; // 로그인한 유저 ID
      const response = await axios.get(`${REST_API_URL}user/${currentUserId}/book/${isbn.value}`);
      isLiked.value = response.data; // 서버에서 true/false를 반환
    } catch (error) {
      console.error("좋아요 상태 확인에 실패했습니다.", error);
    }
  };

  // 도서 좋아요
  const doBookLike = async () => {
    try {
      const currentUserId = userStore.loginUser; // 로그인한 유저 ID
      await axios.post(`${REST_API_URL}user/${currentUserId}/book/${isbn.value}`);
      isLiked.value = true; // 좋아요 상태 업데이트
      await getBookLike(); // 좋아요 수 업데이트
    } catch (error) {
      console.error("좋아요를 저장하는 데 실패했습니다.", error);
    }
  };

  // 도서 좋아요 취소
  const doBookUnlike = async () => {
    try {
      const currentUserId = userStore.loginUser; // 로그인한 유저 ID
      await axios.delete(`${REST_API_URL}user/${currentUserId}/book/${isbn.value}`);
      isLiked.value = false; // 좋아요 상태 업데이트
      cntBookLike.value = response.data; // 서버에서 반환된 좋아요 수로 업데이트
      await getBookLike(); // 좋아요 수 업데이트
    } catch (error) {
      console.error("좋아요 취소를 처리하는 데 실패했습니다.", error);
    }
  };

  const userLikes = ref([]);
  const userId = userStore.loginUser;

  // 사용자 좋아요 도서 목록 가져오기
  const getUserLikes = function () {

    axios.get(`${REST_API_URL}user/${userId}`)
      .then(response => {
        console.log("응답 결과", response)
        userLikes.value = response.data
        console.log(userLikes.value)
      })
      .catch(error => {
        console.log("좋아요 도서 조회 실패", error)
        userLikes.value = [];
      })
  }

  return {
    isbn,
    cntBookLike,
    isLiked,
    getBookLike,
    checkUserLike,
    doBookLike,
    doBookUnlike,
    userLikes,
    getUserLikes,
  };
});
