import React,{Component} from 'react';
//import React, { useReducer } from 'react';
import UserService from '../Service/UserService';
import {Redirect} from "react-router-dom"
import "../style/regi.css"
class Register extends Component{
    constructor(props){  

        //Initialize state for component
        super(props);
        var redirect=false
        if(localStorage.getItem("uid")!==null){
          redirect=true
        }
        this.state={
                    firstname:"",
                    lastname:"",
                    emailid:" ",
                    password:"",
                    mobilenumber:"",
                    gender:"",
                    message: null,
                    red:redirect
        };
        this.saveUser = this.saveUser.bind(this);
    } 
     
    saveUser = (e) => {
      e.preventDefault();
      let user = {firstname: this.state.firstname,lastname:this.state.lastname,emailid: this.state.emailid,password: this.state.password,mobilenumber: this.state.mobilenumber,gender: this.state.gender}
    //   console.log(user)
      UserService.addUser(user)
       .then(resp =>{
         alert("successfully Register!")
        //  console.log(resp.data);
        
        localStorage.setItem("uid", resp.data.userid);
        this.setState({red:true,message : 'User Registration Sucessfull'});
        //  this.props.history.push('/user');
       })
       .catch(err=>{
            alert("Something Wrong!")
         console.error("in err",err.response);
        // this.props.history.push('/user');
       })
    }
     
    onChange = (e) =>
    this.setState({[e.target.name]: e.target.value});
    render(){
        if(this.state.red){
            return <Redirect to="/"/>
          }
        return (
         

<div class="container register-form">
            <div class="form">
                <div class="note">
                    <p>New User Registration</p>
                </div>

                <div class="form-content">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="name" class="form-control" placeholder="First Name*" name="firstname" value={this.state.firstname} onChange={this.onChange}/>
                            </div>
                            <div class="form-group">
                                <input type="name" class="form-control" placeholder="Last Name*" name="lastname" value={this.state.lastname} onChange={this.onChange}/>
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Email Id*" name="emailid" value={this.state.emailid} onChange={this.onChange}/>
                            </div>
                            
                        </div>
                        <div class="col-md-6">
                        <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password *" name="password" value={this.state.password} onChange={this.onChange}/>
                            </div>
                            <div class="form-group">
                                <input type="mobile" class="form-control" placeholder="mobilenumber *"  name="mobilenumber" value={this.state.mobilenumber} onChange={this.onChange}/>
                            </div>
                            <div class="form-group">
                                <input type="gender" class="form-control" placeholder="gender *"  name="gender" value={this.state.gender} onChange={this.onChange}/>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btnSubmit" value="registration" onClick={this.saveUser}>Submit</button>
                </div>
            </div>
        </div>
            
        );
    }
}
export default Register;