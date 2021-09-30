import axios from 'axios';

const AUTHOR_API_BASE_URL = 'http://localhost:7070/author';


class ApiService {

 

    fetchAllAuthor() {
        return axios.get(AUTHOR_API_BASE_URL + '/allauthor');
    }

  
}

export default new ApiService();