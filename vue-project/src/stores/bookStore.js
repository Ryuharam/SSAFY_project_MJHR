import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

const REST_API_URL = `http://localhost:8080/book`;

export const useBookStore = defineStore('book', () => {
  const bookList = ref([]);

  const getBookList = function () {
    axios.get(REST_API_URL)
      .then((Response) => {
        console.log(Response)
        bookList.value = Response.data
      })
  }

  return {
    bookList,
    getBookList,
  };
});
