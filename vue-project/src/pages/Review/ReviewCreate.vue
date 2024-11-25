<template>
  <div class="card">
    <span class="title">Leave a Comment</span>
    <form class="form">
      <div class="group">
        <input placeholder="Title" type="text" required="" v-model="review.reviewTitle">
        <label for="name"></label>
      </div>
      <div class="group">
        <input :placeholder="userId" type="email" id="email" name="email" required="" readonly>
        <label for="email"></label>
      </div>
      <div class="group">
        <textarea placeholder="Comment" id="comment" name="comment" rows="5" required=""
          v-model="review.reviewContent"></textarea>
        <label for="comment"></label>
      </div>
      <button @click.prevent="createReview">Submit</button>
    </form>
  </div>

</template>

<script setup>
import { ref, defineProps, defineEmits } from 'vue';
import { useReviewStore } from "@/stores/reviewStore";
import { useUserStore } from '@/stores/userStore';

const props = defineProps({
  isbn: {
    type: String,
    required: true,
  },
});

const userStore = useUserStore();
const store = useReviewStore();
const emits = defineEmits(['close']);

const userId = userStore.loginUser;
console.log(userId);

const review = ref({
  userId: userId,
  isbn: props.isbn,
  reviewTitle: "",
  reviewContent: "",
})


const createReview = function () {
  if (!review.value.reviewTitle || !review.value.reviewContent) {
    alert("Please fill in all fields.");
    return;
  }
  store.createReview(review.value)
  emits('close');
}
</script>

<style scoped>
.card {
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
  border-color: #B90000;
}

.form .group input:focus+label,
.form .group textarea:focus+label {
  top: -10px;
  left: 10px;
  background-color: #fff;
  color: #B90000;
  font-weight: 600;
  font-size: 14px;
}

.form .group textarea {
  resize: none;
  height: 100px;
}

.form button {
  background-color: #B90000;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 10px;
  font-size: 16px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.form button:hover {
  background-color: #B95050;
}
</style>