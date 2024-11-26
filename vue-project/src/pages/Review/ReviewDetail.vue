<template>
  <!-- updateReview 모달 -->
  <div v-if="showModal" class="modal-overlay" @click.self="closeModal">
    <div class="modal-content">
      <ReviewUpdate :review="props.review" @close="closeModal" />
      <button class="close-button" @click="closeModal">X</button>
    </div>
  </div>

  <!-- ReviewList -->
  <ReviewList :isbn="props.review.isbn" />

  <div class="card">
    <div class="body">
      <button class="update-button" @click="showModal = true">
        <svg xml:space="preserve" viewBox="0 0 41.915 41.916" xmlns:xlink="http://www.w3.org/1999/xlink"
          xmlns="http://www.w3.org/2000/svg" id="Capa_1" version="1.1" fill="#000000">
          <g stroke-width="0" id="SVGRepo_bgCarrier"></g>
          <g stroke-linejoin="round" stroke-linecap="round" id="SVGRepo_tracerCarrier"></g>
          <g id="SVGRepo_iconCarrier">
            <g>
              <g>
                <path
                  d="M11.214,20.956c0,3.091-2.509,5.589-5.607,5.589C2.51,26.544,0,24.046,0,20.956c0-3.082,2.511-5.585,5.607-5.585 C8.705,15.371,11.214,17.874,11.214,20.956z">
                </path>
                <path
                  d="M26.564,20.956c0,3.091-2.509,5.589-5.606,5.589c-3.097,0-5.607-2.498-5.607-5.589c0-3.082,2.511-5.585,5.607-5.585 C24.056,15.371,26.564,17.874,26.564,20.956z">
                </path>
                <path
                  d="M41.915,20.956c0,3.091-2.509,5.589-5.607,5.589c-3.097,0-5.606-2.498-5.606-5.589c0-3.082,2.511-5.585,5.606-5.585 C39.406,15.371,41.915,17.874,41.915,20.956z">
                </path>
              </g>
            </g>
          </g>
        </svg>
      </button>
      <button class="delete-button" @click.prevent="deleteReview">X</button>
      <span class="text">
        ❝ {{ review.reviewTitle }} ❞
      </span>
      <hr class="custom-hr" />
      <span class="text-content">
        {{ review.reviewContent }}
      </span>
      <span class="username">from:
        @{{ review.userId }}</span>
      <div class="footer">
        <div>
          <!-- 댓글버튼 -->
          <div><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
              <g stroke-width="0" id="SVGRepo_bgCarrier"></g>
              <g stroke-linejoin="round" stroke-linecap="round" id="SVGRepo_tracerCarrier"></g>
              <g id="SVGRepo_iconCarrier">
                <path stroke-linejoin="round" stroke-linecap="round" stroke-width="1.5"
                  d="M16 10H16.01M12 10H12.01M8 10H8.01M3 10C3 4.64706 5.11765 3 12 3C18.8824 3 21 4.64706 21 10C21 15.3529 18.8824 17 12 17C11.6592 17 11.3301 16.996 11.0124 16.9876L7 21V16.4939C4.0328 15.6692 3 13.7383 3 10Z">
                </path>
              </g>
            </svg>0</div>
          <!-- 찜버튼 -->
          <div><svg fill="#000000" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg"
              version="1.1" viewBox="-2.5 0 32 32">
              <g stroke-width="0" id="SVGRepo_bgCarrier"></g>
              <g stroke-linejoin="round" stroke-linecap="round" id="SVGRepo_tracerCarrier"></g>
              <g id="SVGRepo_iconCarrier">
                <g id="icomoon-ignore"> </g>
                <path fill="#000000"
                  d="M0 10.284l0.505 0.36c0.089 0.064 0.92 0.621 2.604 0.621 0.27 0 0.55-0.015 0.836-0.044 3.752 4.346 6.411 7.472 7.060 8.299-1.227 2.735-1.42 5.808-0.537 8.686l0.256 0.834 7.63-7.631 8.309 8.309 0.742-0.742-8.309-8.309 7.631-7.631-0.834-0.255c-2.829-0.868-5.986-0.672-8.686 0.537-0.825-0.648-3.942-3.3-8.28-7.044 0.11-0.669 0.23-2.183-0.575-3.441l-0.352-0.549-8.001 8.001zM1.729 10.039l6.032-6.033c0.385 1.122 0.090 2.319 0.086 2.334l-0.080 0.314 0.245 0.214c7.409 6.398 8.631 7.39 8.992 7.546l-0.002 0.006 0.195 0.058 0.185-0.087c2.257-1.079 4.903-1.378 7.343-0.836l-13.482 13.481c-0.55-2.47-0.262-5.045 0.837-7.342l0.104-0.218-0.098-0.221-0.031 0.013c-0.322-0.632-1.831-2.38-7.498-8.944l-0.185-0.215-0.282 0.038c-0.338 0.045-0.668 0.069-0.981 0.069-0.595 0-1.053-0.083-1.38-0.176z">
                </path>
              </g>
            </svg>0</div>
          <!-- 공유버튼 -->
          <div><svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <g id="SVGRepo_bgCarrier" stroke-width="0"></g>
              <g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g>
              <g id="SVGRepo_iconCarrier">
                <path opacity="0.1"
                  d="M21 6C21 7.65685 19.6569 9 18 9C16.3431 9 15 7.65685 15 6C15 4.34315 16.3431 3 18 3C19.6569 3 21 4.34315 21 6Z"
                  fill="#323232"></path>
                <path opacity="0.1"
                  d="M21 18C21 19.6569 19.6569 21 18 21C16.3431 21 15 19.6569 15 18C15 16.3431 16.3431 15 18 15C19.6569 15 21 16.3431 21 18Z"
                  fill="#323232"></path>
                <path opacity="0.1"
                  d="M9 12C9 13.6569 7.65685 15 6 15C4.34315 15 3 13.6569 3 12C3 10.3431 4.34315 9 6 9C7.65685 9 9 10.3431 9 12Z"
                  fill="#323232"></path>
                <path
                  d="M21 6C21 7.65685 19.6569 9 18 9C16.3431 9 15 7.65685 15 6C15 4.34315 16.3431 3 18 3C19.6569 3 21 4.34315 21 6Z"
                  stroke-width="2"></path>
                <path
                  d="M21 18C21 19.6569 19.6569 21 18 21C16.3431 21 15 19.6569 15 18C15 16.3431 16.3431 15 18 15C19.6569 15 21 16.3431 21 18Z"
                  stroke-width="2"></path>
                <path
                  d="M9 12C9 13.6569 7.65685 15 6 15C4.34315 15 3 13.6569 3 12C3 10.3431 4.34315 9 6 9C7.65685 9 9 10.3431 9 12Z"
                  stroke-width="2"></path>
                <path d="M8.7207 10.6397L15.0001 7.5" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                </path>
                <path d="M8.70605 13.353L15 16.5" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                </path>
              </g>
            </svg>0</div>
        </div>
      </div>
    </div>
  </div>


</template>

<script setup>
import axios from 'axios';
import { defineProps, ref } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/stores/userStore';
import { useReviewStore } from '@/stores/reviewStore';
import ReviewUpdate from './ReviewUpdate.vue';

const showModal = ref(false)

const closeModal = () => {
  showModal.value = false;
};

const props = defineProps({
  review: {
    type: Object,
    required: true,
  },
})

const router = useRouter();
const userStore = useUserStore();
const reviewStroe = useReviewStore();

const deleteReview = function () {

  console.log(`http://localhost:8080/review/delete/${props.review.reviewId}`);

  if (userStore.loginUser !== props.review.userId) {
    alert("다른사람의 답글을 지울 수 없습니다")
    return
  }

  axios.delete(`http://localhost:8080/review/delete/${props.review.reviewId}`)
    .then(() => {
      router.push({
        name: 'BookDetail',
        params: { isbn: props.review.isbn },
      });
      reviewStroe.getBookReviews(props.review.isbn)
    })
    .catch((error) => {
      console.error('Failed to delete review:', error);
      alert('리뷰 삭제에 실패했습니다. 다시 시도해주세요.');
    });

}


</script>

<style scoped>
.update-button {
  background: transparent;
  border: 0;
  color: #Af8F6F;
  font-size: 18px;
}

.update-button svg {
  position: absolute;
  right: 40px;
  top: 14px;
  fill: #Af8F6F;
  width: 15px;
}

.delete-button {
  position: absolute;
  top: 10px;
  right: 10px;
  background: none;
  border: none;
  font-size: 18px;
  cursor: pointer;
  color: #Af8F6F;
}

.card {
  position: relative;
  background-color: #F8F4E1;
  padding: 1em;
  z-index: 5;
  box-shadow: 4px 4px 20px rgba(0, 0, 0, 0.3);
  border-radius: 10px;
  width: 80%;
  margin: 1% 1%;
  transition: 200ms ease-in-out;
}

.username {
  color: #Af8F6F;
  font-size: 0.85em;
  font-weight: 600;
  position: absolute;
  top: 60%;
  right: 10%;
}

.body {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.body .text {
  margin: 0 10px 0 0;
  white-space: pre-line;
  color: #543310;
  font-weight: 400;
  line-height: 1.5;
  margin-bottom: 4px;
}

.custom-hr {
  border: none;
  border-top: #Af8F6F;
}

.text-content {
  margin: 0 10px 0 0;
  white-space: pre-line;
  color: #543310;
  font-weight: 400;
  line-height: 1.5;
  margin: auto;
  margin-bottom: 4px;
}

.footer {
  position: relative;
  width: 100%;
  color: #9fa4aa;
  font-size: 12px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  border: none;
  margin-top: 10px;
}

.footer div {
  margin-right: 1rem;
  height: 20px;
  display: flex;
  align-items: center;
  cursor: pointer;
}

.footer svg {
  margin-right: 5px;
  height: 100%;
  stroke: #9fa4aa;
}

/* 모달 오버레이 */
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

/* 모달 콘텐츠 */
.modal-content {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  position: relative;
  width: 400px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
}

/* 닫기 버튼 */
.close-button {
  position: absolute;
  top: 10px;
  right: 10px;
  background: none;
  border: none;
  font-size: 18px;
  cursor: pointer;
}
</style>