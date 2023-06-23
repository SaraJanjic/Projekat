<template>
    <div>
    <input type="text" v-model="searchQuery" placeholder="Search by name or ID">
    <button @click="traziKnjiguPoId">Search</button>
    <ul>
      <li v-for="book in books" :key="book.naslov">
      {{ book.naslov }}
      <p>{{ book.naslovnaSlika }}</p>
      <p>{{ book.ISBN }}</p>
      <p>{{ book.datumObjavljivanja }}</p>
      <p>{{ book.brStrana }}</p>
      <p>{{ book.opis }}</p>
      <p>{{ book.zanr }}</p>
      <p>{{ book.ocena }}</p>
      </li>
    </ul>
    </div>
  </template>
  
  <script>
  import axios from 'axios'
  export default {
    data() {
      return {
        books: []
      };
    },
   created(){
  const searchQuery = this.$route.query.searchQuery;
    if(searchQuery){
      axios.get(`/api/traziKnjiguPoId/{searchQuery}`)
      .then(response =>{
        this.books = [response.data];
       } )
       .catch(error => {
        console.error('Error', error);
       });
  }
}
  };
  </script>
  
  <style>
  .search-bar {
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .search-input {
    padding: 8px 12px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 300px;
  }
  
  .search-input:focus {
    outline: none;
    border-color: #4285f4;
  }
  
  .search-button {
    margin-left: 10px;
    padding: 8px 12px;
    font-size: 16px;
    background-color: #4285f4;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  .search-button:hover {
    background-color: #3367d6;
  }
  
  .search-button:active {
    background-color: #1c3aa9;
  }
  </style>
  
  