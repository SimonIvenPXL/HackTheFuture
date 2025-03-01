// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router';
import ActsPage from '../components/ActForm.vue'; // Example component
import PilePage from '../components/FoodPile.vue'; // Example component

const routes = [
    { path: '/acts', component: ActsPage },
    { path: '/', component: PilePage },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
