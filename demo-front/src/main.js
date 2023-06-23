import { createApp } from 'vue';
import { createRouter, createWebHistory } from 'vue-router';
import App from './App.vue';
import axios from 'axios';
import RegistrationComponent from './components/RegistrationComponent.vue';
import LoginComponent from './components/LoginComponent.vue';
import DashboardView from './views/DashboardView.vue';
import SearchBar from './views/SearchBar.vue';
import KnjigaPoNaslovu from './components/KnjigaPoNaslovu.vue';
axios.defaults.baseURL = 'http://localhost:8080';


const router = createRouter({
    history: createWebHistory(),
    routes: [
      { path: '/registration', component: RegistrationComponent },
      {path: '/login', component: LoginComponent},
      { path: '/dashboard/:korisnikId', component: DashboardView },
      {path : '/traziKnjiguPoId/:query', component: SearchBar}, //search
      {path: '/traziKnjiguPoNaslovu/:naslov', component: KnjigaPoNaslovu}
      
    ],
  });

const app = createApp(App);
app.config.globalProperties.$axios = axios;

app.use(router);
app.mount('#app');


