<template>
  <div class="search-box">
    <div class="search">
      <form @submit.prevent="doSearch">
        <input type="text" class="search__input" v-model.trim="word" placeholder="검색어 입력" >
        <button class="search__button" type="submit">
          <svg class="search__icon" aria-hidden="true" viewBox="0 0 24 24">
            <g>
              <path
            d="M21.53 20.47l-3.66-3.66C19.195 15.24 20 13.214 20 11c0-4.97-4.03-9-9-9s-9 4.03-9 9 4.03 9 9 9c2.215 0 4.24-.804 5.808-2.13l3.66 3.66c.147.146.34.22.53.22s.385-.073.53-.22c.295-.293.295-.767.002-1.06zM3.5 11c0-4.135 3.365-7.5 7.5-7.5s7.5 3.365 7.5 7.5-3.365 7.5-7.5 7.5-7.5-3.365-7.5-7.5z">
          </path>
        </g>
      </svg>
    </button>
  </form>
  </div>
</div>
  <RouterView />
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from 'vue-router';
import { useSearchStore } from '@/stores/searchStore';

const store = useSearchStore();
const router = useRouter();
const word = ref("");

// 검색 실행
const doSearch = async () => {
  if (word.value.trim() === "") {
    alert("공백은 입력될 수 없습니다");
    return;
  }
  console.log(word.value)
  store.word = word.value;
  console.log(store.word);
  store.getSearchResult();

  // SearchResult 이동
  router.push({ name: "SearchResult" });
};



</script>

<style scoped>
.search-box {
  padding-top: 5%;
  padding-bottom: 5%;
}
/* From Uiverse.io by joe-watson-sbf */ 
.search {
  display: flex;
  align-items: center;
  justify-content: space-between;
  text-align: center;
}

.search__input {
  font-family: inherit;
  font-size: inherit;
  background-color: #f4f2f2;
  border: none;
  color: #646464;
  padding: 0.7rem 1rem;
  border-radius: 30px;
  width: 20rem;
  transition: all ease-in-out .5s;
  margin-right: -2rem;
}

.search__input:hover, .search__input:focus {
  box-shadow: 0 0 1em #3a373713;
}

.search__input:focus {
  outline: none;
  background-color: #f0eeee;
}

.search__input::-webkit-input-placeholder {
  font-weight: 100;
  color: #ccc;
}

.search__input:focus + .search__button {
  background-color: #f0eeee;
}

.search__button {
  border: none;
  background-color: #f4f2f2;
  margin-top: .1em;
}

.search__button:hover {
  cursor: pointer;
}

.search__icon {
  height: 1.3em;
  width: 1.3em;
  fill: #b4b4b4;
}
</style>
