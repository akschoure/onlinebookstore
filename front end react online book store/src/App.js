import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.css'
import Containers from './Containers/Containers';
import NavgationBar from './Components/NavigationBar';
import { Container,Row , Jumbotron , Col } from 'react-bootstrap';
import Footer from './Components/Footer';
import NavigationBar from './Components/NavigationBar';
import {BrowserRouter as Router,Link,Switch,Route} from 'react-router-dom';

function App() {
 const marginTop = {
  marginTop:"20px"
};
  return (
    <div className="App">
    <Router>
   
    <NavigationBar></NavigationBar>
    <Container>
        <Row>
          <Col lg={12} style={marginTop}>
            <Jumbotron className="bg-dark text-white">
                 
                 <Containers></Containers>
               
                 <Footer></Footer>
                
            </Jumbotron>
          </Col>
        </Row> 


     </Container>
    </Router>
   
        

    </div>
  );
}

export default App;