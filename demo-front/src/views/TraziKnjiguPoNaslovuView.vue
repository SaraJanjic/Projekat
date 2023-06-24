<template>
    <div>
      <h2>Rezultati pretrage</h2>
        <ul>
            <li v-for="book in books" :key="book.naslov">
              {{ book.naslov }}
               <p> {{ book.naslovnaSlika }}</p>
               <p>Zanr: {{ book.zanr }}</p>
               <p>Ocena: {{ book.ocena }}</p>
               <p>Broj strana: {{ book.brStrana }}</p>
               <p>ISBN: {{ book.isbn }}</p>
               <p>Opis: {{ book.opis }}</p>
               <p>Datum objavljivanja: {{ book.datumObjavljivanja }}</p>
            </li>
        </ul>
    </div>
  </template>

  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        books: [],
      };
    },
    created(){
      const searchTerm = this.$route.query.searchTerm;
      if(searchTerm){
        axios.get(`http://localhost:8080/api/traziKnjiguPoNaslovu/${searchTerm}`)
          .then(response => {
            this.books = [response.data];
          })
          .catch(error => {
            console.error('Error:', error);
          });
      }
    },
  };
  </script>