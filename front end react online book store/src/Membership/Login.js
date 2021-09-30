
import React, { useReducer } from 'react';
import "./../style/login.css"
import api from "../Service/UserService"
import {Redirect} from "react-router-dom"
//className Component

class  Login extends React.Component{

    constructor(props){  
        //define state for component
        super(props);
        var redirect=false
        if(localStorage.getItem("uid")!==null){
          redirect=true
        }
        this.state={
                    emailid:"",
                    password:"",
                    red:redirect
        };
    }

    onchange=(e)=>{
      this.setState({[e.target.name]:e.target.value})
    }
    userLogin=()=>{
      if(this.state.emailid!==null||this.state.password!==null||this.state.emailid!==''||this.state.password!==''){
        api.loginUser(this.state.emailid, this.state.password)
        .then(resp=>{
          // console.log(resp.data)
          localStorage.setItem("uid", resp.data.userid);
          this.setState({red:true});
          alert("Login Sucessfull!")
        })
        .catch(err=>{
          console.log(err)
          alert("Something Wrong!")
        })
      }else{
        alert("All field are required!")
      }
    }
    
    render(){
      if(this.state.red){
        return <Redirect to="/"/>
      }
        return (
            <div>    

                 <div className="wrapper fadeInDown">
                  <div id="formContent">
                <div className="fadeIn first">
      <img src="https://png.pngitem.com/pimgs/s/111-1114742_person-icon-hd-png-download.png" id="icon" alt="User Icon" />
    </div>

   
    {/* <form> */}
      <input type="text" id="login" className="fadeIn second" name="emailid" placeholder="Email Id" value={this.state.emailid} onChange={this.onchange} />
      <input type="text" id="password" className="fadeIn third" name="password" placeholder="password" value={this.state.password} onChange={this.onchange} />
      <input type="submit" className="fadeIn fourth" value="Log In" onClick={this.userLogin}/>
    {/* </form> */}

   
    {/* <div id="formFooter">
      <a className="underlineHover" href="#">Forgot Password?</a>
    </div> */}

  </div>
</div> 


                  

            </div>   
        );
    }
}
export default Login;



