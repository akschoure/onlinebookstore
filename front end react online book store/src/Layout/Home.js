import React from 'react';
import {BrowserRouter as Router,Link,Switch,Route} from 'react-router-dom';
import { Container,Row , Jumbotron , Col } from 'react-bootstrap';
import {Carousel} from 'react-bootstrap'
import img1 from "../style/image/bestbook.jpg"
import img2 from "../style/image/top-authors.jpg"
import img3 from "../style/image/Ayurveda.jpg"
function Home(){

    return(

  
//    <div id="carouselExampleIndicators" className="carousel slide" data-ride="carousel">
//   <ol classNameName="carousel-indicators">
//     <li data-target="#carouselExampleIndicators" data-slide-to="0" className="active"></li>
//     <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
//     <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
//   </ol>
//   <div className="carousel-inner">
//     <div className="carousel-item active">
//       <img className="d-block w-100" src={img1} alt="First slide"/>
//     </div>
//     <div className="carousel-item">
//       <img className="d-block w-100" src={img1}  alt="Second slide"/>
//     </div>
//     <div className="carousel-item">
//       <img className="d-block w-100" src={img1}  alt="Third slide"/>
//     </div>
//   </div>
//   <a className="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
//     <span className="carousel-control-prev-icon" aria-hidden="true"></span>
//     <span className="sr-only">Previous</span>
//   </a>
//   <a className="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
//     <span className="carousel-control-next-icon" aria-hidden="true"></span>
//     <span className="sr-only">Next</span>
//   </a>
// </div>


<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src={img1} alt="First slide"/>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src={img2} alt="Second slide"/>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src={img3} alt="Third slide"/>
    </div>
  </div>
</div>





    );
}

export default Home;