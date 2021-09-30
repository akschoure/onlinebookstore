import React from 'react';
import {BrowserRouter as Router,Link,Switch,Route} from 'react-router-dom';
import { Container,Row , Jumbotron , Col, Navbar } from 'react-bootstrap';
class Slider extends React.Component{
render(){

    return(
       
     <div class="carousel-item">
      <img src="..." alt="..."/>
     <div class="carousel-caption d-none d-md-block">
      <h5>...</h5>
      <p>...</p>
    </div>
    </div>
    
    );
}
}
export default Slider;