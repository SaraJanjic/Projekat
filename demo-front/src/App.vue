<template>
  <img alt="Knjige slika" src="./assets/knjige.jpg">
  <HelloWorld msg="Welcome to Lesart reads"/>
  <router-view></router-view>
  <search-bar @search="performSearch"></search-bar>
   <router-link to="/about">About</router-link>
  <LoginComponent></LoginComponent>
</template>


<script>
import axios from 'axios';
import HelloWorld from './components/HelloWorld.vue'
import SearchBar from './views/SearchBar.vue';
import LoginComponent from './components/LoginComponent.vue';




export default {
  name: 'App',
  components: {
    HelloWorld,
    SearchBar,
    LoginComponent,
  },
  methods: {
    performSearch(naslov) {
  console.log('Search query:', naslov);
  axios.get(`/api/traziKnjiguPoNaslovu/${naslov}`)
    .then(response => {
      const book = response.data;
      if (book) {
        console.log('Found book:', book);
      } else {
        console.log('Book not found');
      }
    })
    .catch(error => {
      console.error(error);
    });
}

  }
}

</script>



<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 10px;
}
</style>
