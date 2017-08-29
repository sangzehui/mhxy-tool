import Vue from 'vue'
import App from './App.vue'

if (process.env.NODE_ENV === 'production') {
    window.baseUrl = "/mhxy-tool/rest";
} else {
    window.baseUrl = "http://localhost:8089/rest";
}

new Vue({
    el: '#app',
    render: h => h(App)
});
