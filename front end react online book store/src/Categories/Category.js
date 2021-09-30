import {Component, React , useEffect , useState}  from 'react';
import api from "../Service/CategoryService"
import { Redirect } from 'react-router';
class Category extends Component{
   
    constructor(props){
        super(props);

        this.state={
            category:[],
            redi:false,
            url:''
        }
    }

    
    componentDidMount=()=>{
        api.fetchAllCategory()
        .then(resp=>{
            console.log(resp.data)
            this.setState({red:true});
            this.setState({category:resp.data})
            
            
        })
        .catch(err=>{
        console.log(err)
        })
    }
  
    showBook=(id)=>{
        this.setState({redi:true,url:'/books?cid='+id})
    }
    render(){
      
        
    if(this.state.redi){
        return <Redirect to={this.state.url}/>
    }
        return(
            <div>
                <h2 className="text-center">Category List</h2>
                <table class="table table-dark">
  <thead>
    <tr>
      {/* <th >Number</th> */}
      <th >Category</th>
      <th >Discription</th>
      <th >Action</th>
      
    </tr>
  </thead>
  <tbody>
   {this.state.category.map(b=>(
       <tr>
           {/* <td>{b.categoryid}</td> */}
           <td>{b.categoryname}</td>
           <td>{b.description}</td>
           <td> <button className="btn btn-success" onClick={() => this.showBook(b.categoryid)}> GoToBooks </button></td>
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

export default Category;