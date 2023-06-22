<template>
    <div>
      <h2>Books</h2>
      <ul>
        <li v-for="knjiga in knjige" :key="knjiga.id">
          <h3>{{ knjiga.naslov }}</h3>
          <p>Autor: {{ knjiga.autor }}</p>
          <p>Zanr: {{ knjiga.zanr }}</p>
          <p>Opis: {{ knjiga.opis }}</p>
          <p>datumObjavljivanja: {{ knjiga.datumObjavljivanja }}</p>
          <p>brStrana: {{ knjiga.brStrana }}</p>
          <p>naslovnaSlika: {{ knjiga.naslovnaSlika }}</p>
        </li>
      </ul>
    </div>
    <div>
    <search-bar @search="performSearch"></search-bar>


    <div v-if="searchResults.length">
      <h2>Search Results</h2>
      <ul>
        <li v-for="book in searchResults" :key="book.id">
          {{ book.naslov }}
        </li>
      </ul>
    </div>
    <div v-else>
      <p>No results found.</p>
    </div>
  </div>
  </template>
  
  <script>
  import axios from 'axios';
  import SearchBar from './views/SearchBar.vue';
  
  export default {
    data() {
      return {
        knjige: [],
        searchResults: []
      };
    },
    mounted() {
      this.fetchKnjige();
    },
    methods: {
      fetchKnjige() {
        axios.get('/api/knjige')
          .then(response => {
            this.knjige = response.data;
          })
          .catch(error => {
            console.error(error);
          });
      },
      searchBooks(query) {
        console.log('Search query:', query); 
        axios.get(`/api/traziKnjiguPoNaslovu/${query}`)
          .then(response => {
            this.searchResults = response.data;
          })
          .catch(error => {
            console.error(error);
          });
      }
    }
  };
  </script>
  
  
  <style>
.knjiga-list {
  list-style: none;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

.knjiga {
  width: 250px;
  margin-bottom: 20px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f7f7f7;
}

.knjiga-info {
  margin-bottom: 10px;
}

.knjiga-naslov {
  font-size: 18px;
  font-weight: bold;
}

.knjiga-autor {
  font-size: 14px;
  color: #666;
}

.knjiga-zanr {
  font-size: 14px;
  color: #666;
}

.knjiga-opis {
  font-size: 14px;
  color: #666;
}

.knjiga-datumObjavljivanja {
  font-size: 14px;
  color: #666;
}

.knjiga-brStrana {
  font-size: 14px;
  color: #666;
}

.book-naslovnaSlika {
  width: 100%;
  height: auto;
  margin-top: 10px;
}
</style>
  