import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:7070/user';


class ApiService {



    loginUser(em, pass) {

        return axios.post(USER_API_BASE_URL + '/login/'+em+'/'+pass);
    }
     
    addUser(user) {
        return axios.post(""+USER_API_BASE_URL, user);
    }

  
}

export default new ApiService();