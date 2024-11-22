<template>
  <div class="books-container">
      <div class="tab-buttons">
          <button 
              :class="['tab-btn', { active: activeTab === 'review' }]"
              @click="activeTab = 'review'"
          >
              리뷰
          </button>
          <button 
              :class="['tab-btn', { active: activeTab === 'wishlist' }]"
              @click="activeTab = 'wishlist'"
          >
              찜
          </button>
      </div>
      
      <div class="book-grid">
          <div class="book-item" v-for="book in displayedBooks" :key="book.id">
              <img :src="book.cover" alt="책 표지">
              <p class="book-title">{{ book.title }}</p>
          </div>
      </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue';

const activeTab = ref('review');
const reviewBooks = ref([
  { id: 1, cover: 'book1.jpg', title: '제목1' },
  { id: 2, cover: 'book2.jpg', title: '제목2' },
  { id: 3, cover: 'book3.jpg', title: '제목3' }
]);
const wishlistBooks = ref([
  { id: 4, cover: 'book4.jpg', title: '제목4' },
  { id: 5, cover: 'book5.jpg', title: '제목5' }
]);

const displayedBooks = computed(() => {
  return activeTab.value === 'review' ? reviewBooks.value : wishlistBooks.value;
});
</script>

<style scoped>

</style>