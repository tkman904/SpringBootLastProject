/*
   React
   NodeJs    SpringBoot
     |         |
   React     React
   ----------------------MSA(JWT)

*/
const api = axios.create({
   baseURL: 'http://43.200.178.170:8080',
   timeout: 50000
})