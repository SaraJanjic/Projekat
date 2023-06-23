<template>
  <div>
    <h1>Welcome to the Home Page! </h1>
    <router-link to="/registration"> Idi na Registraciju</router-link>
    <router-view></router-view>
    </div>
    <div>
    <router-link to ="/knjige">Knjige</router-link>
    </div>
    <div>
      <input type="text" v-model="searchQuery" placeholder="Search by name or ID">
    <button @click="searchBooks">Search</button>
    </div>
  </template>

  <script>
export default{
  data(){
    return{
      searchQuery: ''
    };
  },
  methods : {
    searchBooks(){
      if(this.searchQuery){
        this.$router.push({path: '/search', query : {searchQuery: this.searchQuery}});
      }
    },
  },
}
</script>


