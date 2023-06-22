<template>
    <div>
      <h1>Korisnici</h1>
      <ul>
        <li v-for="korisnik in korisnici" :key="korisnik.id">
          <h2>{{ korisnik.username }}</h2>
          <p>Ime: {{ korisnik.ime }}</p>
          <p>Prezime: {{ korisnik.prezime }}</p>
          <p>Opis: {{ korisnik.opis }}</p>
          <p>Slika: {{ korisnik.slikaKorisnika }}</p>
          <p>Police: {{ korisnik.korisnickePolice }}</p>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
    import axios from 'axios';
    

  export default {
    data() {
      return {
        korisnici: [] 
      };
    },
    created() {
      axios.get('http://localhost:8080/api/korisnici')
     .then(response => {
      const korisnici = response.data;

    console.log(korisnici); // Ispis podataka korisnika u konzoli
  })
  .catch(error => {
    console.error(error);
  });
      this.fetchKorisnici();
    },
    methods: {
      fetchKorisnici() {
        axios.get('http://localhost:8080/api/korisnici')
      .then(response => {
        this.korisnici = response.data; // Ažuriranje niza users sa dobavljenim korisnicima
      })
      .catch(error => {
        console.log(error);
      });
      }
    }
  };
  </script>
  
  <style>
  .korisnik-list {
    list-style: none;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }
  
  .korisnik {
    width: 250px;
    margin-bottom: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f7f7f7;
  }
  
  .korisnik-username {
    font-size: 18px;
    font-weight: bold;
  }
  
  .korisnik-ime,
  .korisnik-prezime,
  .korisnik-opis,
  .korisnik-slika,
  .korisnik-police {
    font-size: 14px;
    color: #666;
  }
  </style>
  