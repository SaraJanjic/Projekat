<template>
  <div id="app">
    <img alt="Knjige slika" src="./assets/knjige.jpg">
    <HelloWorld msg="Welcome to Lesart reads"/>
    <div class ="search-bar">
      <input type="text" v-model="searchTerm" placeholder="Unesite naslov knjige">
      <button @click="search">Pretraži</button>
    </div>
    <router-view></router-view>
    <router-link to="/login">Go to Login</router-link><br />
    
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'


export default {
  name: 'App',
  components: {
    HelloWorld,
    
  },
  data() {
    return {
      searchTerm: '',
    };
  },
  methods: {
    search(){
        if(this.searchTerm){
          this.$router.push({path : '/search', query: {searchTerm: this.searchTerm}});
        }
    },


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