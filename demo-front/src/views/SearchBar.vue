<template>
    <div>
    <input type="text" v-model="searchQuery" placeholder="Search by name or ID">
    <button @click="searchBooks">Search</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        searchQuery: '',
      };
    },
    methods: {
      searchBooks() {
        this.$emit('search', this.searchQuery);
      },
    },
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
  
  