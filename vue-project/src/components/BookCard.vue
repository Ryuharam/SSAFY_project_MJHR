<template>
  <div>
    <div class="card">
      <!-- 이미지 섹션 -->
      <div class="card-img" :style="{ backgroundImage: `url(${book.image})` }">
      </div>

      <!-- 상세 정보 섹션 -->
      <div class="card-details">
        <p class="text-title">{{ book.title }}</p>
        <p class="text-body">{{ book.author }}</p>
      </div>

      <button @click="goBookDetail" class="card-button">More info</button>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter()

const props = defineProps({
  book: Object,
})

const goBookDetail = function () {
  console.log(props.book.title)
  router.push({
    name: 'BookDetail',
    params: { isbn: props.book.isbn },
  })
}


</script>

<style scoped>
/* From Uiverse.io by alexruix */
.card {
  position: relative;
  width: 190px;
  height: 254px;
  border-radius: 20px;
  overflow: visible;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 15px;
  background: #FFF2E1;
  border: 2px solid #F8F4E1;
  margin: 0.5rem;
  transition: 0.5s ease-out;
  padding: 15px;
}

/* 이미지 섹션 */
.card-img {
  width: 100%;
  height: 60%;
  /* 카드 상단의 60%를 이미지로 사용 */
  background-size: cover;
  /* 이미지를 잘라서 카드에 맞춤 */
  background-position: center;
  /* 이미지를 중앙 정렬 */
  border-bottom: 2px solid #ddd;
  /* 이미지와 상세 정보 구분선 */
}

.card-details {
  width: 90%;
  height: 40%;
  /* 카드 상단의 60%를 이미지로 사용 */
  background-color: #EAD9C0;
  padding: 10px;
  border-radius: 5px;
  color: #74512D;
  gap: .1em;
  display: grid;
  place-content: center;
  overflow: hidden;
  /* 넘치는 텍스트 숨김 */
  text-overflow: ellipsis;
  /* 줄임표 추가 */
}

.card-button {
  transform: translate(-50%, 125%);
  width: 60%;
  border-radius: 1rem;
  border: none;
  background-color: #543310;
  color: #fff;
  font-size: 1rem;
  padding: .5rem 1rem;
  position: absolute;
  left: 50%;
  bottom: 0;
  opacity: 0;
  transition: 0.3s ease-out;
}


/*Text*/
.text-title {
  font-size: 1em;
  font-weight: bold;
  color: #543310;
  margin: auto;
  white-space: nowrap;
  /* 텍스트를 한 줄로 제한 */
  overflow: hidden;
  /* 넘치는 텍스트 숨김 */
  text-overflow: ellipsis;
  /* 줄임표 추가 */
  width: 100%;
  /* 텍스트 줄임표를 적용할 영역 크기 설정 */
}

.text-body {
  color: #74512D;
  margin: auto;
}

/*Hover*/
.card:hover {
  border-color: #543310;
  box-shadow: 0 4px 18px 0 rgba(0, 0, 0, 0.25);
}

.card:hover .card-button {
  transform: translate(-50%, 50%);
  opacity: 1;
}
</style>