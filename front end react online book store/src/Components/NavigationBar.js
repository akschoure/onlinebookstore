import {BrowserRouter as Router,Link,Switch,Route} from 'react-router-dom';
import React from 'react';
import {Navbar , Nav} from 'react-bootstrap';
class NavigationBar extends React.Component{
  logout=()=>{
    alert("Logout Sucessfull!")
    localStorage.clear();
  }
 render(){
   
     return (
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
          <Link to="/"  class="navbar-brand" >Online Book Store</Link>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                <Link to="/"  class="nav-link active" aria-current="page" >Home</Link>
              </li>
              <li class="nav-item">
                <Link to="/books" class="nav-link" >Books</Link>
              </li>
              <li class="nav-item">
                <Link to="/category" class="nav-link" >Category</Link>
              </li>
              <li class="nav-item">
                <Link to="/author"class="nav-link" >Author</Link>
              </li>
              <li class="nav-item">
                <Link to="/login"class="nav-link" >Log in</Link>
              </li>
              <li class="nav-item">
                <Link to="/register"class="nav-link" >Register</Link>
              </li>
              <li class="nav-item">
                <a href="#"class="nav-link"onClick={this.logout} >Logout</a>
              </li>

              <li class="nav-item">
                <Link className="nav-link" to="/cart">My Cart</Link>
              </li>

            </ul>
          </div>
        </div>
      </nav>
     );
}
}
export default NavigationBar;
//<li class="nav-item">
//<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
//</li>  

