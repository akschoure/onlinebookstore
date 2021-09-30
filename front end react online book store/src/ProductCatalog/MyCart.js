//import React, { useReducer } from 'react';
import {Component, React , useEffect , useState}  from 'react';
import {Redirect} from 'react-router-dom'
import capi from "../Service/MyCartService"

class MyCart extends Component{
    constructor(props){
        super(props);
        this.state={
            mycart:[],
            red:false
           
        }
    }
    componentDidMount=()=>{
        if(localStorage.getItem("uid")!==null){
        capi.fetchCartByUserId(localStorage.getItem("uid"))
        .then(resp=>{
            console.log(resp.data)
            //this.setState({red:true});
            this.setState({mycart:resp.data})
            console.log(this.state.mycart);
        })
        .catch(err=>{
        console.log(err)
        })
    }else{
        alert("Login first!")
    }
    }
    rmCart=(id)=>{
    capi.removeFromMyCart(id)
    .then(resp=>{
        this.setState({
            red:false
        })
        alert("Remove Successfully!")
        console.log(resp.data)
    })
    }
    render(){

    if(this.state.red){
        return <Redirect to="/cart"/>
    }
        return(
            <div>
                <h2 className="text-center">My Cart List</h2>
                <table class="table table-dark">
  <thead>
    <tr>
      {/* <th >Number</th> */}
      <th >Book Name</th>
      <th >Author Name</th>
      <th >Price</th>
      <th >Quantity</th>
      <th >Action</th>
      
      
      
      
    </tr>
  </thead>
  <tbody>
   {this.state.mycart.map(c=>(
       <tr>
           {/* <td>{b.authorid}</td> */}
           <td>{c.books.title}</td>
           <td>{c.books.author.authorname}</td>
           <td>{c.books.price}</td>
           <td>{c.quantity}</td>
           <td><button className="btn btn-danger" onClick={()=>this.rmCart(c.cartid)}> Remove </button></td>
          
       </tr>
       
   ))
    
   }
  </tbody>
  
</table>
<button className="btn btn-success" onClick={this.byClick}> Buy </button>
            </div>
        )
    }
}

export default MyCart;