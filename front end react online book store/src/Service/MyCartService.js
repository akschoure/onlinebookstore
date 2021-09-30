import axios from 'axios';

const MYCART_API_BASE_URL = 'http://localhost:7070/mycart';


class ApiService {



    // fetchAllCart(cid) {
    //     return axios.get(MYCART_API_BASE_URL + '/allcart/'+cid);
    // }

    fetchCartByUserId(userid) {
        return axios.get(MYCART_API_BASE_URL + '/byuserid/'+userid);
    }

    addToCart(uid, bid) {
        // console.log(adcrt)
        return axios.post(MYCART_API_BASE_URL + '/addcart/'+uid+'/'+bid);
    }
   
    removeFromMyCart(cartid){
        return axios.delete(MYCART_API_BASE_URL + '/removecart/'+cartid);
    }
  
}      

export default new ApiService();