import axios from 'axios';

const CATEGORY_API_BASE_URL = 'http://localhost:7070/category';


class ApiService {

 

    fetchAllCategory() {
        return axios.get(CATEGORY_API_BASE_URL + '/allCategory');
    }

  
}

export default new ApiService();