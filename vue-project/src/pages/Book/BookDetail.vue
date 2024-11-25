<template>
  <div class="container">
    <div class="book-info">
      <!-- 이미지 박스 -->
      <div class="img-box">
        <div class="card-img"
          :style="{ backgroundImage: book.image ? `url(${book.image})` : 'url(/path-to-default-image.jpg)' }">
        </div>
      </div>
      <!-- 상세 정보 박스 -->
      <div class="detail-box">
        <div>
          <p>ISBN: {{ isbn }}</p>
          <p>Title: {{ book.title }}</p>
          <p>author: {{ book.author }}</p>
          <p>publisher: {{ book.publisher }}</p>
          <p>pubdate: {{ book.pubdate }}</p>
        </div>
        <div class="like">
          <div class="like-button">
            <input class="on" id="heart" type="checkbox" :checked="isLiked" @change="toggleLike" />
            <label class="like" for="heart">
              <svg class="like-icon" fill-rule="nonzero" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path
                  d="m11.645 20.91-.007-.003-.022-.012a15.247 15.247 0 0 1-.383-.218 25.18 25.18 0 0 1-4.244-3.17C4.688 15.36 2.25 12.174 2.25 8.25 2.25 5.322 4.714 3 7.688 3A5.5 5.5 0 0 1 12 5.052 5.5 5.5 0 0 1 16.313 3c2.973 0 5.437 2.322 5.437 5.25 0 3.925-2.438 7.111-4.739 9.256a25.175 25.175 0 0 1-4.244 3.17 15.247 15.247 0 0 1-.383.219l-.022.012-.007.004-.003.001a.752.752 0 0 1-.704 0l-.003-.001Z">
                </path>
              </svg>
              <span class="like-text">Likes</span>
            </label>
            <span class="like-count one">{{ bookLike }}</span>
            <span class="like-count two">{{ bookLike }}</span>
          </div>

        </div>
      </div>
    </div>
    <hr>
    <!-- 리뷰 -->
    <div class="review">
      <h4>reviews</h4>
      <hr>

      <button @click="showModal = true">리뷰 작성하기</button>
      <!-- ReviewCreate 모달 -->
      <div v-if="showModal" class="modal-overlay" @click.self="closeModal">
        <div class="modal-content">
          <ReviewCreate :isbn="isbn" @close="closeModal" />
          <button class="close-button" @click="closeModal">X</button>
        </div>
      </div>
      <!-- ReviewList -->
      <ReviewList :isbn="isbn" />

    </div>
  </div>
</template>



<script setup>
import { ref, computed, onMounted, watch } from 'vue';
import { useBookStore } from '@/stores/bookStore';
import { useBookLikeStore } from '@/stores/bookLikeStore';
import ReviewCreate from '../Review/ReviewCreate.vue';
import ReviewList from '../Review/ReviewList.vue';


// Props 정의
const props = defineProps({
  isbn: {
    type: String,
    required: true,
  },
});

const showModal = ref(false);

const closeModal = () => {
  showModal.value = false;
};

// Pinia 스토어 사용
const store = useBookStore();
const likeStore = useBookLikeStore();

// 반응형 상태
const book = computed(() => store.book);
const bookLike = computed(() => likeStore.cntBookLike);
const isLiked = ref(false); // 좋아요 여부
const isProcessing = ref(false); // 처리 중인지 여부

const updateLikeStatus = async () => {
  await likeStore.checkUserLike(); // 좋아요 여부 갱신
  await likeStore.getBookLike(); // 좋아요 수 갱신
  isLiked.value = likeStore.isLiked; // 좋아요 상태 갱신
};



const toggleLike = async () => {
  if (isProcessing.value) return; // 중복 요청 방지

  isProcessing.value = true;
  try {
    if (isLiked.value) {
      await likeStore.doBookUnlike();
    } else {
      await likeStore.doBookLike();
    }
    await updateLikeStatus(); // 좋아요 상태와 좋아요 수 동기화

  } finally {
    isProcessing.value = false; // 요청 완료 후 처리 가능 상태로 복구
  }
};


// 컴포넌트 마운트 시 초기화
onMounted(async () => {
  console.log("isbn 확인", props.isbn)
  store.isbn = props.isbn; // 스토어에 isbn 전달
  likeStore.isbn = props.isbn;
  await store.getBookDetail(); // 도서 상세 정보 요청
  await likeStore.checkUserLike(); // 좋아요 상태 확인
  await likeStore.getBookLike(); // 좋아요 수 확인
  await updateLikeStatus(); // 좋아요 상태와 수 업데이트
});

// ISBN 변경 감지
watch(() => props.isbn, async () => {
  store.isbn = props.isbn;
  likeStore.isbn = props.isbn;
  await store.getBookDetail();
  await updateLikeStatus();
});


</script>

<style scoped>
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


.book-info {
  display: flex;
  flex-direction: row;
  /* 가로 배치 */
  gap: 30px;
  /* 이미지와 상세 정보 간 간격 */
  align-items: flex-start;
  /* 세로 정렬 방식 (기본은 위 정렬) */
}

.img-box {
  flex: 1;
  /* 가변 크기 할당 */
  max-width: 300px;
  /* 이미지 최대 너비 제한 */
}

.detail-box {
  flex: 2;
  position: relative;
  /* 자식 요소(absolute) 기준 위치 설정 */
  display: flex;
  flex-direction: column;
  /* 세로 정렬 */
  justify-content: space-between;
  /* 요소를 위-아래로 분배 */
}


.card-img {
  width: 100%;
  /* 박스 너비 */
  height: 300px;
  /* 박스 높이 */
  background-size: contain;
  /* 이미지가 박스 안에 맞게 조정됨 */
  background-repeat: no-repeat;
  /* 이미지 반복 제거 */
  background-position: center;
  /* 이미지 중앙 정렬 */
  border: 1px solid #ddd;
  /* 이미지 박스 테두리 */
}

/* From Uiverse.io by Priyanshu02020 */
#heart {
  display: none;
}

.like-button {
  position: relative;
  cursor: pointer;
  display: flex;
  height: 48px;
  width: 136px;
  border-radius: 16px;
  border: none;
  background-color: #A79277;
  overflow: hidden;
  box-shadow:
    inset -2px -2px 5px rgba(255, 255, 255, 0.2),
    inset 2px 2px 5px rgba(0, 0, 0, 0.1),
    4px 4px 10px rgba(0, 0, 0, 0.4),
    -2px -2px 8px rgba(255, 255, 255, 0.1);
}

.like {
  width: 70%;
  height: 100%;
  display: flex;
  cursor: pointer;
  align-items: center;
  justify-content: space-evenly;
}

.like-icon {
  fill: #505050;
  height: 28px;
  width: 28px;
}

.like-text {
  color: #fcfcfc;
  font-size: 16px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

.like-count {
  position: absolute;
  right: 0;
  width: 30%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #717070;
  font-size: 16px;
  border-left: 2px solid #D1BB9E;
  transition: all 0.5s ease-out;
}

.like-count.two {
  transform: translateY(40px);
}

.on:checked~.like .like-icon {
  fill: #fc4e4e;
  animation: enlarge 0.2s ease-out 1;
  transition: all 0.2s ease-out;
}

.on:checked~.like-count.two {
  transform: translateX(0);
  color: #fcfcfc;
}

.on:checked~.like-count.one {
  transform: translateY(-40px);
}

@keyframes enlarge {
  0% {
    transform: scale(0.5);
  }

  100% {
    transform: scale(1.2);
  }
}
</style>
