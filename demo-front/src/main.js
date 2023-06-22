import { createApp } from 'vue';
import { createRouter, createWebHistory } from 'vue-router';
import App from './App.vue';
import axios from 'axios';
import RegistrationComponent from './components/RegistrationComponent.vue';
import LoginComponent from './components/LoginComponent.vue';
import DashboardComponent from './components/DashboardComponent.vue';
import SearchBar from './views/SearchBar.vue';
axios.defaults.baseURL = 'http://localhost:8080';


const router = createRouter({
    history: createWebHistory(),
    routes: [
      { path: '/registration', component: RegistrationComponent },
      {path: '/login', component: LoginComponent},
      { path: '/dashboard/:korisnikId', component: DashboardComponent },
      {path : '/search/:query', component: SearchBar},
      // Add more routes as needed
    ],
  });

const app = createApp(App);
app.config.globalProperties.$axios = axios;
// Use the router instance in your app
app.use(router);
app.mount('#app');


