<template>
  <div id="app">
    <img alt="Knjige slika" src="./assets/knjige.jpg">
    <HelloWorld msg="Welcome to Lesart reads"/>
    <div>
      <input type="text" v-model="naslov" placeholder="Unesite naslov knjige">
      <button @click="pretraziKnjige">Pretraži</button>
    </div>
    <router-link to="/pretraga-knjiga">Pretraži knjige</router-link>
    <router-view></router-view>
    <login-component @login-success="handleLoginSuccess"></login-component>
    <router-link to="/about">About</router-link>
    <LoginComponent></LoginComponent>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import LoginComponent from './components/LoginComponent.vue';
import axios from 'axios';

export default {
  name: 'App',
  components: {
    HelloWorld,
    LoginComponent,
  },
  data() {
    return {
      naslov: '',
      rezultatiPretrage: [],
    };
  },
  methods: {
    pretraziKnjige() {
      axios.get(`/api/traziKnjiguPoNaslovu/${this.naslov}`)
        .then(response => {
          this.rezultatiPretrage = response.data;
        })
        .catch(error => {
          console.error('Greška pri pretrazi knjiga:', error);
        });
    },
    handleLoginSuccess() {
      // Preusmjeravanje korisnika na odgovarajuću stranicu na temelju uloge
      const userRole = JSON.parse(localStorage.getItem('user')).uloga;
      switch (userRole) {
        case 'CITALAC':
          this.$router.push('/citalac-home');
          break;
        case 'AUTOR':
          this.$router.push('/autor-home');
          break;
        case 'ADMINISTRATOR':
          this.$router.push('/admin-home');
          break;
        default:
          break;
      }
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