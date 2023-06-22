import { createApp } from 'vue'
import App from './App.vue'

createApp(App).mount('#app')

import Vue from 'vue';
import axios from 'axios';

Vue.prototype.$axios = axios;

