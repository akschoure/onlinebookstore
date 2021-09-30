//import React, { useReducer } from 'react';
import {Component, React , useEffect , useState}  from 'react';
import { Redirect } from 'react-router';
import api from "../Service/authorservice"

class Author extends Component{
    constructor(props){
        super(props);
        this.state={
            author:[],
            redi:false,
            url:''
           
        }
    }
    componentDidMount=()=>{
        api.fetchAllAuthor()
        .then(resp=>{
            console.log(resp.data)
            this.setState({red:true});
            this.setState({author:resp.data})
        })
        .catch(err=>{
        console.log(err)
        })
    }

    showBook=(id)=>{
        this.setState({redi:true,url:'/books?aid='+id})
    }
    render(){

    if(this.state.redi){
        return <Redirect to={this.state.url}/>
    }
        return(
            <div>
                <h2 className="text-center">Author List</h2>
                <table class="table table-dark">
  <thead>
    <tr>
      {/* <th >Id</th> */}
      <th >Author Name</th>
      <th >Discription</th>
      <th >Action</th>
      
    </tr>
  </thead>
  <tbody>
   {this.state.author.map(b=>(
       <tr>
           {/* <td>{b.authorid}</td> */}
           {/* <td>{b.authorid}</td> */}
           <td>{b.authorname}</td>
           <td>{b.description}</td>
           <td> <button className="btn btn-success" onClick={() => this.showBook(b.authorid)}> GoToBooks </button></td>
       </tr>
       
   ))

   }
  </tbody>
  
</table>
                {}
            </div>
        )
    }
}

export default Author;