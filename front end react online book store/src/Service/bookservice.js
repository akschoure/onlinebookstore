import axios from 'axios';

const BOOK_API_BASE_URL = 'http://localhost:7070/books';


class ApiService {



    fetchAllBooks() {
        return axios.get(BOOK_API_BASE_URL + '/allbooks');
    }

    fetchAllBooksByAuthor(id) {
        return axios.get(BOOK_API_BASE_URL + '/allbooksbyauth/'+id);
    }

    fetchAllBooksByCategory(id) {
        return axios.get(BOOK_API_BASE_URL + '/allbooksbycat/'+id);
    }

  
}

export default new ApiService();