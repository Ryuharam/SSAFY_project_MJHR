<template>
  <div class="card-update">
    <span class="title">Edit Comment</span>
    <form class="form">
      <div class="group">
        <input placeholder="Title" type="text" required="" v-model="review.reviewTitle">
        <label for="name"></label>
      </div>
      <div class="group">
        <input :placeholder="userId" type="userId" id="userId" name="userId" required="" readonly>
        <label for="userId"></label>
      </div>
      <div class="group">
        <textarea placeholder="Comment" id="comment" name="comment" rows="5" required=""
          v-model="review.reviewContent"></textarea>
        <label for="comment"></label>
      </div>
      <button @click.prevent="updateReview">Submit</button>
    </form>
  </div>

</template>

<script setup>
import { ref, defineProps, defineEmits } from 'vue';
import { useUserStore } from '@/stores/userStore';
import { useReviewStore } from '@/stores/reviewStore';
import axios from 'axios';

const props = defineProps({
  review: {
    type: Object,
    required: true,
  },
});

const userStore = useUserStore();
const reviewStore = useReviewStore();
const emits = defineEmits(['close']);

const userId = userStore.loginUser;
console.log(userId);

const review = ref({
  reviewId: props.review.reviewId,
  userId: props.review.userId,
  isbn: props.review.isbn,
  reviewTitle: props.review.reviewTitle,
  reviewContent: props.review.reviewContent,
})


const updateReview = function () {
  if (!review.value.reviewTitle || !review.value.reviewContent) {
    alert("Please fill in all fields.");
    return;
  }

  axios({
    url: "http://localhost:8080/review/update",
    method: "PUT",
    params: {
      reviewId: review.value.reviewId,
      userId: review.value.userId,
      isbn: review.value.isbn,
      reviewTitle: review.value.reviewTitle,
      reviewContent: review.value.reviewContent,
    }
  })
    .then(() => {
      reviewStore.getBookReviews(review.value.isbn)
      reviewStore.getUserReviews()
      emits('close');
    })

  emits('close');
}
</script>

<style scoped>
.card-update {
  background-color: #fff;
  border-radius: 10px;
  padding: 20px;
  width: 350px;
  display: flex;
  flex-direction: column;
}

.title {
  font-size: 24px;
  font-weight: 600;
  text-align: center;
}

.form {
  margin-top: 20px;
  display: flex;
  flex-direction: column;
}

.group {
  position: relative;
}

.form .group label {
  font-size: 14px;
  color: rgb(99, 102, 102);
  position: absolute;
  top: -10px;
  left: 10px;
  background-color: #fff;
  transition: all .3s ease;
}

.form .group input,
.form .group textarea {
  padding: 10px;
  border-radius: 5px;
  border: 1px solid rgba(0, 0, 0, 0.2);
  margin-bottom: 20px;
  outline: 0;
  width: 100%;
  background-color: transparent;
}

.form .group input:placeholder-shown+label,
.form .group textarea:placeholder-shown+label {
  top: 10px;
  background-color: transparent;
}

.form .group input:focus,
.form .group textarea:focus {
  border-color: #543310;
}

.form .group input:focus+label,
.form .group textarea:focus+label {
  top: -10px;
  left: 10px;
  background-color: #fff;
  color: #543310;
  font-weight: 600;
  font-size: 14px;
}

.form .group textarea {
  resize: none;
  height: 100px;
}

.form button {
  background-color: #543310;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 10px;
  font-size: 16px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.form button:hover {
  background-color: #AF8F6F;
}
</style>