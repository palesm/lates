import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `/api`,
  timeout: 1000
});


export default {
    hello() {
        return AXIOS.get(`/hello`);
    },
    getLates() {
        return AXIOS.get('/lates')
    },
    deleteLates() {
        return AXIOS.delete('/lates')
    },
    generateLates() {
        return AXIOS.get('genLates')
    },
    createLate(late) {
        return AXIOS.post('/lates', late)
    },
    getStats() {
        return AXIOS.get('/stats')
    }
}


