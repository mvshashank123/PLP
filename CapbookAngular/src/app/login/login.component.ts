import { Component, OnInit } from '@angular/core';
import { DetailsService } from '../details.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email
  password

  constructor(private custService:DetailsService,private router:Router) { 
    this.email=""
    this.password=""
  }

  ngOnInit() {
  }

  loginuser()
 {
   if(this.email!="" && this.password!="")
   {
        this.custService.login(this.email,this.password).subscribe(()=>{
         alert('logged in....')
         this.router.navigate(['userpage/'+this.email])
       }, (error) =>{
        console.log(error)
        alert("Account details are incorrect..")
        });
    }

    
  //   if(this.email=="" && this.password==""){
  //     alert("Please fill the details")
  //   }
   }
  
  
}



