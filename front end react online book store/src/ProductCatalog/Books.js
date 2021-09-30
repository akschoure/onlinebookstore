import React, { Component } from 'react'
import api from "../Service/bookservice";
import capi from "../Service/MyCartService"
import {Link, Redirect} from "react-router-dom"

class Books extends Component {

    constructor(props) {
        super(props)
        this.state = {
            books: [],
            message: null,
            red:false
        }
      
        // this.myCart = this.myCart.bind(this);
        
        this.reloadBooks = this.reloadBooks.bind(this);
    }

    componentDidMount(prevProps) {
        const queryString = window.location.search;
        const urlParams = new URLSearchParams(queryString);
        const auid = urlParams.get('aid');
        const catid = urlParams.get('cid')
        console.log(auid)
        // if (prevProps.location.key !== this.props.location.key) {
        //     this.setState({red:true})
        //     alert("Ni")
        // }
        if(auid!==null){
            this.reloadAuthBooks(auid);
            // alert("a3")
            return;
            
        }
        if( catid!==null){
            this.reloadCatBooks(catid);
            // alert("2")
            return;
            // alert("2")
        }
        this.reloadBooks();
        // alert("3")
    }

    reloadBooks() {
        api.fetchAllBooks()
            .then((resp) => {
                this.setState({books: resp.data})
                console.log(this.state.books);
            });
            

    }
    reloadAuthBooks(id) {
        api.fetchAllBooksByAuthor(id)
            .then((resp) => {
                this.setState({books: resp.data})
                console.log(this.state.books);
            });
            

    }
    reloadCatBooks(id) {
        api.fetchAllBooksByCategory(id)
            .then((resp) => {
                this.setState({books: resp.data})
                console.log(this.state.books);
            });
            

    }

    
    // myCart(bookid) {
    //     window.localStorage.setItem("userId", bookid);
    //     this.props.history.push('/mycart');
    // }
    addToCart=(bid)=>{
        var uid = localStorage.getItem("uid");
        if(uid!==null){
            
        // var cart = {
        //     userId:uid,
        //     bookId:bid,
        //     quantity:1
        // }
        capi.addToCart(uid, bid)
        .then((resp) => {
            console.log(resp.data)
            // this.setState({books: resp.data})
            alert("Successfully Added!")
            console.log(this.state.books);
        });
    }else{
        alert("Login First!")
    }
    }
    

    render() {
        return (
            <div>
                <h2 className="text-center">Books List</h2>
              
                <table className="table table-dark">
                <thead>
                        <tr> 
                           <th >Title</th>
                           <th >Author</th>
                           <th >Publication</th>
                           <th >Isbn</th>
                           <th >Language</th>
                           <th >Descrtiption</th>
                           <th >ArrivalDate</th>
                           <th >Pages</th>
                           <th >Price</th>
<th>Action</th>
                         </tr>
                </thead>
                    <tbody>
                    {this.state.books.map(b=>(
                          <tr>
                             
                             <td>{b.title}</td>
                             {/* {console.log(b.author.authorid)} */}
                             <td>{b.author.authorname}</td>
                             <td>{b.publication}</td>
                             <td>{b.isbn}</td>
                             {/* <td>{b.imageurl}</td> */}
                             <td>{b.language}</td>
                            <td>{b.description}</td>
                            <td>{b.arrivaldate}</td>
                            <td>{b.pages}</td>
                            <td>{b.price}</td>
                           
                       <td>
                       {/* <button className="btn btn-success m-1" onClick={() => this.buyBook(b.bookid)}> Buy Book </button> */}
            
                      <button className="btn btn-success m-1" onClick={()=>this.addToCart(b.bookid)}>AddtoCart</button>
                </td>
       </tr>
   ))

   }
                    </tbody>
                </table>

            </div>
        );
    }

}

export default Books;