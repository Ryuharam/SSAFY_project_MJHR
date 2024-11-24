import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

const REST_API_URL = `http://localhost:8080/booklike/`;

export const userBookLikeStore = defineStore('bookLike', () => {
  const isbn = ref("");         // 도서 ISBN
  const cntBookLike = ref("");  // 도서의 좋아요 수
  const userId = ref("");       // 유저 아이디
  const cntUserLike = ref("");  // 유저가 좋아요한 책 수
  const UserLikes = ref([]);    // 유저가 좋아요한 책

  // 도서 좋아요 수 요청
  const getBookLike = async () => {
    try {
      if (!isbn.value || isbn.value.trim() === "") {
        console.error("ISBN 값이 비어 있거나 잘못되었습니다.");
        return;
      }

      console.log(`Requesting URL: ${REST_API_URL}book/${isbn.value}/count`);
      const response = await axios.get(`${REST_API_URL}book/${isbn.value}/count`);
      cntBookLike.value = response.data; // 좋아요 수 저장
      console.log("좋아요 수 응답:", response.data);
    } catch (error) {
      console.error("좋아요 수를 가져오는 데 실패했습니다.", error);
    }
  };

  return {
    isbn,
    cntBookLike,
    getBookLike,
  };
});